package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.apache.http.params.CoreConnectionPNames;
import utils.Logger;
import utils.Utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.util.Objects.nonNull;
import static org.eclipse.jetty.http.HttpStatus.Code.OK;

public class RequestClient {
    public static Logger log = Logger.get(RequestClient.class);
    public static final int TIMEOUT_IN_MILLIS = 30000;

    public static Response post(RequestSpecification spec, String path, Object bodyPayload, int statusCode) {

        RequestSpecification specification = given()
//                .log().headers() // if someone wanna add a log-headers for debugging tests
                .config(getConfig())
                .spec(spec)
                .body(bodyPayload);

        log.info("Sending POST request with url \n" + getBaseUri(spec) + path + "\nand body:\n" + Utils.prettyPrint(bodyPayload));

        Response response =
                specification.when()
                        .post(path);

        log.info("Received response in " + getRequestTime(response) + ":\n" + Utils.prettyPrint(response.body().asString()));


        response.then()
                .statusCode(statusCode);

        return response;
    }

    public static Response options(RequestSpecification spec, String path, Object bodyPayload, int statusCode) {
        RequestSpecification specification = given()
                .config(getConfig())
                .spec(spec)
                .body(bodyPayload);

        log.info("Sending OPTIONS request with url \n" + getBaseUri(spec) + path + "\nand body:\n" + Utils.prettyPrint(bodyPayload));

        Response response =
                specification.when()
                        .options(path);

        log.info("Received response in " + getRequestTime(response) + ":\n" + Utils.prettyPrint(response.body().asString()));


        response.then()
                .statusCode(statusCode);

        return response;
    }

    public static Response post(RequestSpecification spec, String path, Map<String, Object> dtoObjects, Map<String, File> filePayload, int statusCode) {

        RequestSpecification specification = given()
//                .log().headers() // if someone wanna add a log-headers for debugging tests
                .config(getConfig())
                .spec(spec)
                .multiPart((MultiPartSpecification) filePayload);

        log.info("Sending POST request with url \n" + getBaseUri(spec) + path + "\nand body:\n" + Utils.prettyPrint(dtoObjects));

        Response response =
                specification.when()
                        .post(path);

        log.info("Received response in " + getRequestTime(response) + ":\n" + Utils.prettyPrint(response.body().asString()));


        response.then()
                .statusCode(statusCode);

        return response;
    }

    public static Response put(String path, File image) {
        return given().urlEncodingEnabled(false)
                .body(image)
                .put(path);
    }

    public static Response postFormParams(RequestSpecification spec, String path, Map<String, Object> bodyPayload) {

        RequestSpecification specification = given()
                .config(getConfig())
                .spec(spec)
                .formParams(bodyPayload).relaxedHTTPSValidation();

        log.info("Sending POST request with url \n" + getBaseUri(spec) + path + "\nand body:\n" + bodyPayload.toString());

        Response response =
                specification.when()
                        .post(path);

        log.info("Received response in " + getRequestTime(response) + ":\n" + Utils.prettyPrint(response.body().asString()));

        return response;
    }

    public static Response postJson(RequestSpecification spec, String path, String json) {

        RequestSpecification specification = given()
                .log().headers()
                .config(getConfig())
                .spec(spec)
                .body(json);

        log.info("Sending POST request with url \n" + getBaseUri(spec) + path + "\nand body:\n" + Utils.prettyPrint(json));

        Response response =
                specification.when()
                        .post(path);

        log.info("Received response in " + getRequestTime(response) + ":\n" + Utils.prettyPrint(response.body().asString()));


        return response;
    }

    public static Response postNew(RequestSpecification spec, String path, Object bodyPayload) {

        RequestSpecification specification = given()
                .config(getConfig())
                .spec(spec)
                .body(bodyPayload);

        log.info("Sending POST request with url \n" + getBaseUri(spec) + path + "\nand body:\n" + Utils.prettyPrint(bodyPayload));

        Response response =
                specification.when()
                        .post(path);

        log.info("Received response in " + getRequestTime(response) + ":\n" + Utils.prettyPrint(response.body().asString()));

        return response;
    }

    public static Long getRequestTime(Response response) {
        return response.getTime();
    }

    public static Response post(RequestSpecification spec, String path, Object bodyPayload) {
        return post(spec, path, bodyPayload, OK.getCode());
    }

    public static <T> T post(RequestSpecification spec, String path, Object bodyPayload, Class<T> responseClass) {
        return post(spec, path, bodyPayload, OK.getCode()).as(responseClass);
    }

    public static <T> List<T> post(RequestSpecification spec, String path, Object bodyPayload, Class<T> responseClass, String listPath) {
        return post(spec, path, bodyPayload, OK.getCode()).jsonPath().getList(listPath, responseClass);
    }

    public static String getBaseUri(RequestSpecification specification) {
        return ((RequestSpecificationImpl) specification).getBaseUri();
    }

    public static Response get(RequestSpecification spec, String path, Map<String, ?> pathParams, int statusCode, Boolean shouldValidateStatusCode) {

        RequestSpecification specification = given()
                .log().all() // if someone wanna add a log-headers for debugging tests
                .config(getConfig())
                .spec(spec);

        String info = "Sending GET request with url \n" + getBaseUri(spec) + path;

        if (nonNull(pathParams)) {
            specification.queryParams(pathParams);
            info += "\nand path params:\n" + Arrays.toString(pathParams.entrySet().toArray());
        }

        log.info(info);

        Response response = specification.when().get(path);

        log.info("Received response:\n" + Utils.prettyPrint(response.body().asString()));

        if (shouldValidateStatusCode) {
            response.then().statusCode(statusCode);
        }

        return response;
    }

    public static Response get(RequestSpecification spec, String path) {
        return get(spec, path, null, OK.getCode(), true);
    }

    public static <T> T get(RequestSpecification spec, String path, Class<T> responseClass) {
        return get(spec, path, null, OK.getCode(), true).as(responseClass);
    }

    public static <T> T get(RequestSpecification spec, String path, Map<String, ?> pathParams, Class<T> responseClass) {
        return get(spec, path, pathParams, OK.getCode(), true).as(responseClass);
    }

    public static <T> T get(RequestSpecification spec, String path, Map<String, ?> pathParams, Class<T> responseClass, int statusCode, Boolean toCheckStatusCode) {
        return get(spec, path, pathParams, statusCode, toCheckStatusCode).as(responseClass);
    }

    public static <T> T get(RequestSpecification spec, String path, Map<String, ?> pathParams, Class<T> responseClass, Boolean toCheckStatusCode) {
        return get(spec, path, pathParams, OK.getCode(), toCheckStatusCode).as(responseClass);
    }

    public static Response get(RequestSpecification spec, String path, Map<String, ?> pathParams) {
        return get(spec, path, pathParams, OK.getCode(), true);
    }

    public static <T> T get(RequestSpecification spec, String path, Map<String, ?> pathParams, int statusCode, Class<T> responseClass) {
        return get(spec, path, pathParams, statusCode, true).as(responseClass);
    }

    public static <T> T post(RequestSpecification spec, String path, Object bodyPayload, int code, Class<T> responseClass) {
        return post(spec, path, bodyPayload, code).as(responseClass);
    }

    public static <T> T postNew(RequestSpecification spec, String path, Object bodyPayload, Class<T> responseClass) {
        return postNew(spec, path, bodyPayload).as(responseClass);
    }

    public static Response postReturnResponse(RequestSpecification spec, String path, Object bodyPayload) {
        return postNew(spec, path, bodyPayload);
    }

    public static Response delete(RequestSpecification spec, String path) {

        RequestSpecification specification = given()
                .config(getConfig())
                .spec(spec);

        String info = "Sending DELETE request with url \n" + getBaseUri(spec) + path;

        log.info(info);

        Response response = specification.when().delete(path);

        if (nonNull(response)) {
            log.info("Received response:\n" + Utils.prettyPrint(response.body().asString()));
        }

        return response;
    }

    public static RestAssuredConfig getConfig() {
        return RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, TIMEOUT_IN_MILLIS)
                        .setParam(CoreConnectionPNames.SO_TIMEOUT, TIMEOUT_IN_MILLIS))
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON));
    }

    public static String convertListToJson(List<Object> dtoObjects) {
        try {
            com.fasterxml.jackson.databind.ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(dtoObjects);
        } catch (Exception e) {
            throw new RuntimeException("Error converting list to JSON", e);
        }
    }
}

package utils;

import java.util.Map;

public class UrlBuilderBase {

    public static String buildAddress(String baseUrl, String[] path, Map<String, String> queryParams) {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);

        if (path != null && path.length > 0) {
            for (String pathSegment : path) {
                urlBuilder.append("/").append(pathSegment);
            }
        }

        if (queryParams != null && !queryParams.isEmpty()) {
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                urlBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
            // Remove the trailing "&"
            urlBuilder.setLength(urlBuilder.length() - 1);
        }

        return urlBuilder.toString();
    }

    public static String buildAddress(String baseUrl, String[] path) {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);

        if (path != null && path.length > 0) {
            for (String pathSegment : path) {
                urlBuilder.append("/").append(pathSegment);
            }
        }

        return urlBuilder.toString();
    }

    public static String buildAddress(String baseUrl) {
        return baseUrl;
    }
}

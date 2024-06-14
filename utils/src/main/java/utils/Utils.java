package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import enums.EnvProperties;
import lombok.extern.log4j.Log4j;
import net.datafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
@Log4j
public class Utils
{
    public static final String DEFAULT_ENV = "aqa";

    private static final String KILL = "taskkill /F /IM \"%s\" /T";
    private static final String KILL_REMOTE_PROCESS = "taskkill /s %s -u %s -p %s /F /IM \"%s\" /T";
    private static final String TASKLIST = "tasklist";
    private static final Faker FAKER = new Faker();
    private static final int DEFAULT_RETRY_ACTION_INTERVAL_MILLIS = 1000;
    private static final int DEFAULT_NUMBER_OF_RETRIES = 3;


    public static String prettyPrint(Object obj)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonParser jp = new JsonParser();
        JsonElement je;
        je = jp.parse(gson.toJson(obj));
        return gson.toJson(je);
    }

    public static String prettyPrint(String obj)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je;
        try {
            je = jp.parse(obj);
        } catch (Exception e) {
            je = jp.parse(gson.toJson(obj));
        }
        return gson.toJson(je);
    }

    public static <T> T parseJson(String json, Class<T> clazz)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, clazz);
    }

    public static <T> T parseJson(String json, TypeToken<T> clazz)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, clazz.getType());
    }

    public static String parseJsonFile(String filePath, String key)
    {
        JSONParser parser = new JSONParser();
        String value = "";
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            value = (String) jsonObject.get(key);

        } catch (Exception e) {
            e.getMessage();
        }
        return value;
    }

    public static <T> T parseJsonFile(String filePath, Class<T> clazz)
    {
        JSONParser parser = new JSONParser();
        T value = (T) "";
        try {
            FileInputStream fisTargetFile = new FileInputStream(new File(filePath));
            String targetFileStr = IOUtils.toString(fisTargetFile, "UTF-8");
            value = parseJson(targetFileStr, clazz);

        } catch (Exception e) {
            e.getMessage();
        }
        return value;
    }

    public static String convertToUTF8(String text)
    {
        return new String(text.getBytes(StandardCharsets.UTF_8));
    }

    public static void editJsonFile(String filePath, String key, String value)
    {
        try {
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            System.out.println(jsonObject);
            String currentValue = (String) jsonObject.get(key);
            jsonObject.put(key, currentValue + " " + value);

            FileWriter writer = new FileWriter(filePath);
            writer.write(jsonObject.toJSONString());

            FileOutputStream outputStream = new FileOutputStream(filePath);
            byte[] strToBytes = jsonObject.toString().getBytes();
            outputStream.write(strToBytes);

        } catch (ParseException | IOException e) {
            e.getMessage();
        }
    }

    public static String decorateInfoString(String infoString)
    {
        StringBuilder builder = new StringBuilder();
        int infoStringLength = infoString.split("\n")[0].length();
        for (int i = 0; i < infoStringLength; i++) {
            builder.append("=");
        }
        builder.append("\n");
        builder.append(infoString);
        builder.append("\n");
        for (int i = 0; i < infoStringLength; i++) {
            builder.append("=");
        }
        return builder.toString();
    }


    public static String getRandomCallID()
    {
        return "auto-" + new DateTime().getMillis();
    }



    public static void waitFor(Integer timeInMillis, boolean withLog)
    {
        if (withLog) log.info("Waiting for " + timeInMillis + " millis.");
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForThreadsToFinish(Thread... threads)
    {
        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static boolean isSessionAlive(WebDriver driver)
    {
        try {
            driver.getPageSource();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitFor(Integer timeInMillis)
    {
        waitFor(timeInMillis, true);
    }




    public static void deleteDirectory(String path)
    {
        log.info("Trying to delete " + path);
        try {
            FileUtils.deleteDirectory(new File(path));
        } catch (IOException e) {
            log.info("Failed to delete " + path + " with error: " + e.getMessage());
        }
    }

    public static String getLastFolderFromDirectory(String path)
    {
        Path parentFolder = Paths.get(path);
        Optional<File> mostRecentFolder =
                Arrays
                        .stream(parentFolder.toFile().listFiles())
                        .filter(f -> f.isDirectory())
                        .max(Comparator.comparingLong(File::lastModified));
        if (mostRecentFolder.isPresent()) {
            File mostRecent = mostRecentFolder.get();
            return mostRecent.getPath().substring(mostRecent.getPath().lastIndexOf("\\") + 1);
        } else {
            log.info("folder is empty!");
            return "";
        }
    }


    public static boolean checkFolderNameContains(String path, String text)
    {
        Path parentFolder = Paths.get(path);
        List<Object> folderObjectList =
                Arrays.asList(Arrays
                        .stream(parentFolder.toFile().listFiles())
                        .filter(f -> f.isDirectory())
                        .sorted((f1, f2) -> Long.compare(f1.lastModified(),
                                f2.lastModified())).toArray());
        for (int i = 0; i < folderObjectList.size(); i++) {
            File file = (File) folderObjectList.get(i);
            if (file.getPath().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getAllFilesInDirectory(String path)
    {
        List<String> results = new ArrayList<String>();
        try {
            File[] files = new File(path).listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    results.add(file.getName());
                }
            }
            return results;
        } catch (Exception e) {
            log.info("Cannot fond path path: " + path);
            return results;
        }
    }

    public static boolean doesListContainPartOfString(List<String> files, String searchFor)
    {
        for (String file : files) {
            if (file.contains(searchFor))
                return true;
        }
        return false;
    }

    public static List<String> getAllFoldersInDirectory(String path)
    {
        File file = new File(path);
        return Arrays.asList(file.list(new FilenameFilter()
        {
            @Override
            public boolean accept(File current, String name)
            {
                return new File(current, name).isDirectory();
            }
        }));
    }

    public static String getFileNameContainingString(List<String> list, String searchFor)
    {
        for (String s : list) {
            if (s.contains(searchFor))
                return s;
        }
        return "";
    }

    public static String getEnv()
    {
        String env = nonNull(EnvProperties.TEST_ENV.getValue()) ? EnvProperties.TEST_ENV.getValue() : EnvProperties.TEST_ENV.getName();
        if (env.contains("prod"))
            return "prod";
        else if (env.contains("aqa"))
            return "aqa";
        else if (env.contains("qa"))
            return "qa";
        else if (env.contains("dev"))
            return "dev";
        else if (env.contains("local"))
            return "local";
        else
            return env.equals("") ? DEFAULT_ENV : env;
    }

    public static void runCmdCommand(String processPath)
    {
        try {
            Runtime rt = Runtime.getRuntime();
            log.info("Running command " + processPath + " - Waiting for result");
            rt.exec("cmd.exe /c" + processPath);
            log.info("Command " + processPath + " - Completed Successfully");
        } catch (Exception e) {
            log.info("Failed to run command.\n" +
                    "Command: " + processPath + "\n" +
                    e.getMessage());
        }
    }

    public static String runCommandGetOutput(String command)
    {
        String line;
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec(command);

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            StringBuilder commandOutput = new StringBuilder();
            while ((line = input.readLine()) != null) {
                commandOutput.append(line);
                commandOutput.append('\n');
            }
            BufferedReader input2 = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
            while ((line = input2.readLine()) != null) {
                commandOutput.append(line);
                commandOutput.append('\n');
            }
            pr.waitFor();
            return commandOutput.toString();
        } catch (Exception e) {
            log.info("Failed to run command.\n" +
                    "Command: " + command + "\n" +
                    e.getMessage());
            return "Unable to get result output from command " + command;
        }
    }

    public static void killProcess(String serviceName)
    {
        try {
            Runtime.getRuntime().exec(String.format(KILL, serviceName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void killRemoteProcess(String slave, String user, String pass, String serviceName)
    {
        try {
            Runtime.getRuntime().exec(String.format(KILL_REMOTE_PROCESS, slave, user, pass, serviceName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Object> convertObjectToMap(Object object)
    {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(object);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Map.class);
        } catch (Exception e) {
            log.info("Could not convert object to map " + e.getMessage());
            return null;
        }
    }

    public static String convertDtoMapToStringWithReplaceParameter(Map<String, Object> dtoMap, String from, String to)
    {
        return dtoMap.entrySet().stream().map(r -> r.getKey() + from + r.getValue()).collect(Collectors.joining(to));
    }

    public static String convertObjectToString(Object object)
    {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(object);
            return json;
        } catch (Exception e) {
            log.info("Could not convert object to map " + e.getMessage());
            return null;
        }
    }


    public static boolean isProcessRunning(String serviceName)
    {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(TASKLIST);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(serviceName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void deleteFile(File file)
    {
        if (nonNull(file)) {
            if (file.delete()) {
                log.info("file deleted");
            } else {
                log.info("file is not deleted");
            }
        }
    }

    public static String generateRandomUUID()
    {
        return UUID.randomUUID().toString();
    }

    public static String generateRandomUUIDReplaceSuffix(Optional<String> SuffixOptional)
    {
        String suffix = SuffixOptional.orElse("");
        String uuid = generateRandomUUID();
        uuid = uuid.substring(0, uuid.length() - suffix.length()) + suffix;
        return uuid;
    }

    public static Integer getRandomInteger(int max, int min)
    {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static String getMessagePartByNumber(String text, int size, int messageToReturn)
    {
        List<String> ret = new ArrayList<String>((text.length() + size - 1) / size);

        for (int i = 0; i < text.length(); i += text.length() / size) {
            ret.add(text.substring(i, Math.min(text.length(), i + text.length() / size)));
        }
        return ret.get(messageToReturn - 1);
    }

    public static Long getTimestampMillis()
    {
        return new DateTime().getMillis();
    }

    public static String getRandomString(int length)
    {
        return RandomStringUtils.random(length, true, false);
    }

    public static String getRandomString()
    {
        return getRandomString(9);
    }

    public static String getRandomEmail()
    {
        return getRandomString(9)+"@"+getRandomString(3)+".com";
    }

    public static int getAbsRandomInt()
    {
        return Math.abs(new Random().nextInt());
    }
    public static int getAbsRandomInt(int digits) {
        long min = (long) Math.pow(10, digits - 1);
        return (int) ThreadLocalRandom.current().nextLong(min, min * 10);
    }


    public static Double getRandomDouble()
    {
        return new Random().nextDouble();
    }

    public static Float getRandomFloat()
    {
        return new Random().nextFloat();
    }

    public static Integer get8DigitsInteger()
    {
        return getRandomInteger(99999999, 10000000);
    }


    public static String getUSARandomPhoneNumber()
    {
        return "+18457" + getRandomInteger(999999, 100000);
    }

    public static String getEuropeRandomPhoneNumber()
    {
        return "256" + getRandomInteger(999999999, 100000000);
    }

    public static String getRandomInternationalPhoneNumber(){
        return "+256" + FAKER.number().numberBetween(100000000, 999999999);
    }

    public static String getRandomInternalPhoneNumber(){
        return "0" + FAKER.number().numberBetween(100000000, 999999999);
    }

    public static String getFakerRandomEmail(){
        return FAKER.internet().emailAddress();
    }

    public static String getRandomAddress(){
        return FAKER.address().fullAddress();
    }

    public static String getRandomFamilyName(){
        return FAKER.name().firstName();
    }

    public static String getRandomMiddleName(){
        return FAKER.name().firstName();
    }

    public static String getRandomSurname(){
        return FAKER.name().lastName();
    }

    public static String getRandomCity(){
        return FAKER.address().cityName();
    }


    public static String decodeBase64(String encodedString)
    {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes);
    }

    public static void createDirectory(String folderName)
    {
        File theDir = new File(folderName);
        if (!theDir.exists()) {
            log.info("creating directory: " + theDir.getName());

            try {
                if (theDir.mkdirs())
                    log.info(folderName + " folder created");
            } catch (Exception e) {
                log.info("Failed creating directory: " + theDir.getName() + " with Error: " + e.getMessage());
            }
        }
    }

    /**
     * Retry action for given number of intervals and waiting time of timeToWaitMilliseconds for each interval
     *
     * @param timeToWaitMilliseconds - number of milliseconds to wait for each interval
     * @param interval               - number of retries
     * @param action                 - the action to try to complete
     * @param <R>                    - return value of the action
     * @return R if action returned R before timeout, otherwise returns null
     */

    @Nonnull
    public static <R> Optional<R> retryUntilReturns(int timeToWaitMilliseconds, int interval, Supplier<Optional<R>> action)
    {
        Optional<R> res;
        for (int i = 0; i < interval; i++) {
            if ((res = action.get()).isPresent()) return res;
            waitFor(timeToWaitMilliseconds);
        }
        return Optional.empty();
    }

    @Nonnull
    public static <R> Optional<R> retryUntilReturns(Supplier<Optional<R>> action)
    {
        return retryUntilReturns(DEFAULT_RETRY_ACTION_INTERVAL_MILLIS, DEFAULT_NUMBER_OF_RETRIES, action);
    }

    @Nullable
    public static <R> R retryUntilReturnsWithoutFail(int timeToWaitMilliseconds, int interval, Supplier<Optional<R>> action)
    {
        Optional<R> r = retryUntilReturns(timeToWaitMilliseconds, interval, action);
        return r.orElse(null);
    }

    @Nonnull
    public static <R> R retryUntilReturnsOrElseFail(String failMessage, int timeToWaitMilliseconds, int interval, Supplier<Optional<R>> action)
    {
        Optional<R> r = retryUntilReturns(timeToWaitMilliseconds, interval, action);
        Assert.assertTrue(r.isPresent(), failMessage);
        return r.get();
    }

    @Nonnull
    public static <R> R retryUntilReturnsOrElseFail(String failMessage, Supplier<Optional<R>> action)
    {
        return retryUntilReturnsOrElseFail(failMessage, DEFAULT_RETRY_ACTION_INTERVAL_MILLIS, DEFAULT_NUMBER_OF_RETRIES, action);
    }

    @Nonnull
    public static Boolean retryUntilTrue(int timeToWaitMilliseconds, int interval, Supplier<Boolean> action)
    {
        Boolean res;
        for (int i = 0; i < interval; i++) {
            if ((res = action.get())) return res;
            waitFor(timeToWaitMilliseconds);
        }
        return null;
    }

    @Nonnull
    public static Boolean retryUntilTrue(Supplier<Boolean> action)
    {
        return retryUntilTrue(DEFAULT_RETRY_ACTION_INTERVAL_MILLIS, DEFAULT_NUMBER_OF_RETRIES, action);
    }

    @Nonnull
    public static <R> Optional<R> tryCatch(Supplier<Optional<R>> action, Function<Exception, Optional<R>> catchAction)
    {
        Optional<R> returnValue;
        try {
            returnValue = action.get();
        } catch (Exception e) {
            returnValue = catchAction.apply(e);
        }
        return returnValue;
    }

    @Nonnull
    public static <R> Optional<R> tryCatchThrowException(Supplier<R> action)
    {
        Optional<R> returnValue;
        try {
            returnValue = Optional.of(action.get());
        } catch (Exception e) {
            throw e;
        }
        return returnValue;
    }

    @Nonnull
    public static <R> Optional<R> tryCatchIgnoreException(Supplier<Optional<R>> action)
    {
        return tryCatch(action, unused -> Optional.empty());
    }

    @Nonnull
    public static <R> Optional<R> tryCatchLogException(Supplier<Optional<R>> action)
    {
        return tryCatch(action, e -> {
            log.info(e.getMessage());
            return Optional.empty();
        });
    }

    @Nonnull
    public static Optional<Boolean> tryCatchLogException(Runnable action)
    {
        return tryCatchLogException(() ->
                {
                    action.run();
                    return Optional.of(true);
                }
        );
    }

    public static Process startProcess(String command, String path)
    {
        log.info("Running command: " + command + "\nin " + path);
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd \"" + path + "\" && " + command);
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException e) {
            log.info("Failed to start process with error: " + e.getMessage());
        }
        return p;
    }

    public static void waitForAndDestroyProcess(Process p)
    {
        try {
            p.waitFor();
            p.destroyForcibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void startProcessAndWaitForAndDestroy(String command, String path)
    {
        Process p = startProcess(command, path);
        waitForAndDestroyProcess(p);
    }
//
//    public static boolean isRunInContainer()
//    {
//        return !enums.EnvProperties.CONTAINER_ENGINE.getValue().equalsIgnoreCase(ContainerEngine.NONE.getEngineName());
//    }
//
//    public static boolean isRunInDocker()
//    {
//        return enums.EnvProperties.CONTAINER_ENGINE.getValue().equalsIgnoreCase(ContainerEngine.DOCKER.getEngineName());
//    }
//
//    public static boolean isRunInKubernetes()
//    {
//        return enums.EnvProperties.CONTAINER_ENGINE.getValue().equalsIgnoreCase(ContainerEngine.KUBERNETES.getEngineName());
//    }
public static void grabScreenshot(String name)
{
    try {
        Robot robot = new Robot();
        String format = "png";

        String fileName = System.getProperty("user.dir") + "/build/reports/tests/" + name + System.currentTimeMillis() + ".png";
        Rectangle captureRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
        ImageIO.write(screenFullImage, format, new File(fileName));
        Logger.log("Screenshot saved at: " + fileName);
    } catch (AWTException | IOException ex) {
        System.err.println(ex);
    }
}

    public static String filterDigitsOnly(@Nonnull String str)
    {
        return str.replaceAll("\\D+", "");
    }

}

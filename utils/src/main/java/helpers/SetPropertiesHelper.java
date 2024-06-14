package helpers;

import utils.Utils;

public class SetPropertiesHelper extends PropertyHelper
{

    public static void init(Class enumClass, String moduleName)
    {
        setProperties(enumClass, moduleName);
    }

    private static void setProperties(Class enumClass, String moduleName)
    {
        PropertyHelper.init(enumClass, getPath(moduleName));
    }

    public static String getPath(String moduleName)
    {
        return System.getProperty("user.dir") + "/../"+moduleName+"/src/main/resources/" + Utils.getEnv() + ".properties";
    }
}

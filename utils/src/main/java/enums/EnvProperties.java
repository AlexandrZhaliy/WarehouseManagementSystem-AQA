package enums;

public enum EnvProperties {
    TESTRAIL_ENABLE_FLAG(""),
    TESTRAIL_RUN_ID(""),
    BUILD_NUMBER(""),
    CONTAINER_ENGINE("false"),
    CONTAINER_URL(""),
//    SELENOID_URL("http://aqa-itms.mvr.warehouse_management.se:4444/wd/hub"),
    SELENOID_URL("http://hub.selenoid-node-v01.warehouse_management.se/wd/hub"),
    SERVICES_ENV(""),
    WEB_ENV(""),
    TEST_ENV("aqa");

    private String name;

    EnvProperties(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return System.getProperty(this.toString());
    }

    public void setValue(String value)
    {
        System.setProperty(this.name(), value);
    }
}

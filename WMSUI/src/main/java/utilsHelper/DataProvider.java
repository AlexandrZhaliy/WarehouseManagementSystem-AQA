package utilsHelper;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.getAbsRandomInt;
import static utils.Utils.getRandomString;


public class DataProvider {
    public String groupArticleVN;
    public String vehicleRegistrationNumber;
    public String companyGroup;
    public String companyGroup2;
    public String warehousesGroup;
    public String warehousesGroup2;
    public String companyName;
    public String companyName2;
    public String companyWarehouseName;
    public String companyWarehouseName2;
    public String warehouseName;
    public String warehouseName2;
    public String articleName_VN;
    public String articleName_TD;
    public String articleName_GPS;
    public String uniqArticleSerialNumber;
    public String uniqArticleCode;
    public String storageUnit_VN;
    public String storageUnit_TD;
    public String storageUnit_GPS;
    public String supplierName;
    public String manufacturerName;
    public String supplierGroupName;
    public String manufacturerGroupName;
    public String randomSuffix;
    public String vinNumber;


    public List<String> VN_serialNumberlist;
    public List<String> TD_serialNumberlist;
    public List<String> GPS_serialNumberlist;

    public DataProvider() {
        randomSuffix = getRandomString();
        vinNumber = "UU3ARG6BGF" + getAbsRandomInt(6);
        groupArticleVN = "Auto_group_article_VN_name_" + randomSuffix;
        companyGroup = "Auto_comp_group_name_" + randomSuffix;
        companyGroup2 = "Auto_comp_group_name_2_" + randomSuffix;
        warehousesGroup = "Auto_ware_group_name_" + randomSuffix;
        warehousesGroup2 = "Auto_ware_group_name_2_" + randomSuffix;
        companyName = "Company_Name_" + randomSuffix;
        companyName2 = "Company_Name_2_" + randomSuffix;
        companyWarehouseName = "Auto_Central_ware_name_" + randomSuffix;
        companyWarehouseName2 = "Auto_Central_ware_name_2_" + randomSuffix;
        warehouseName = "Auto_Installation_ware_name_" + randomSuffix;
        warehouseName2 = "Auto_Installation_ware_name_2_" + randomSuffix;
        articleName_VN = "PN-GOV-V-UG-35-SQR-RYW_" + randomSuffix;
        articleName_TD = "Auto_article_TD_" + randomSuffix;
        articleName_GPS = "Auto_article_GPS_" + randomSuffix;
        uniqArticleSerialNumber = "Auto_uniq_article_serial_number" + randomSuffix;
        uniqArticleCode = "Auto_uniq_article_code" + randomSuffix;
        storageUnit_VN = "Auto_storage_unit_VN_" + randomSuffix;
        storageUnit_TD = "Auto_storage_unit_TD_" + randomSuffix;
        storageUnit_GPS = "Auto_storage_unit_GPS_" + randomSuffix;
        supplierName = "Auto_supplier_name_" + randomSuffix;
        manufacturerName = "Auto_manufacturer_name_" + randomSuffix;
        supplierGroupName = "Auto_supplier_group_name_" + randomSuffix;
        manufacturerGroupName = "Auto_manufacturer_group_name_" + randomSuffix;

        VN_serialNumberlist = new ArrayList<>();
        TD_serialNumberlist = new ArrayList<>();
        GPS_serialNumberlist = new ArrayList<>();
    }
}

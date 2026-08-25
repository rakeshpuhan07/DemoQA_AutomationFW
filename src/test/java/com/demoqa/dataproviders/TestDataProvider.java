package com.demoqa.dataproviders;

import org.testng.annotations.DataProvider;

import com.demoqa.Utils.ExcelUtils;

public class TestDataProvider {

//    @DataProvider(name = "loginData")
//    public Object[][] getLoginData() {
//
//    	String filePath = System.getProperty("user.dir")
//    	        + "/src/test/resources/TestData.xlsx";
//
//        return ExcelUtils.getTestData(filePath, "LoginData");
//    }
    
    @DataProvider(name = "formData")
    public Object[][] getFormData() {

        return ExcelUtils.getTestData(
                "TestData.xlsx",
                "Sheet1");
    }
}

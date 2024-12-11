package Contants;

import tests.BaseTest;

public class FileConstants {
	
	public static final String SCHEMA_VALIDATION_JSON_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\java\\schemaValidation\\SchemaValidations.json";
    public static final String JSON_DATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\jsonTestData.json";
    public static final String API_BASE_URI="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
    public static final String REPORT_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\java\\apiReports\\"+BaseTest.getTimeStamp()+".html";
}

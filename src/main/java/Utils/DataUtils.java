package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.jayway.jsonpath.JsonPath;  //add this import to read json files to string

import Contants.FileConstants;

public class DataUtils {
	
	public static String readJsonFileToString(String path) throws IOException {
		
		byte[] data=Files.readAllBytes(Paths.get(path));
		return new String(data);
		
	}
	public static Object getJsonData(String jsonPath) throws IOException {
		
		String testData=DataUtils.readJsonFileToString(FileConstants.JSON_DATA_FILE_PATH);
		Object value= JsonPath.read(testData, jsonPath);
		return value;
	}

}

package com.nitara.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;


public class DataProviderUtils {
	
	
	
	@DataProvider
	public static Object[] getData(Method m) throws IOException {
		List<Map<String,String>> list = new ArrayList<>();
		String testname = m.getName();
		String tname = m.getName();
		String sheet = tname.substring(0, testname.lastIndexOf("_"));
		
		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails(sheet);
		}
		
		List<Map<String,String>> smallList = new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			Map<String,String> map = list.get(i);
			System.out.println(map);
			System.out.println("Testcase"+map.get("testcase"));
			if(map.get("testcase").equalsIgnoreCase(testname)) {
				//if(list.get(i).get("execute").equalsIgnoreCase("yes")) {
					smallList.add(list.get(i));
				//}
			}
		}
		
		list.removeAll(smallList);
		
		return smallList.toArray();
		
		
	}

}

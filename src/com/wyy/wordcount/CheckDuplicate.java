package com.wyy.wordcount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckDuplicate {
	

	public static void main(String[] args) {
		String[] strings = {"1","2","3","3","34","a","a","d","df"};
		checkDuplicate(strings);
	}
	
	private static void checkDuplicate(String[] strings){
		Map<String, Integer> map = new HashMap<String,Integer>();
		for(int i = 0;i<strings.length;i++){
			if((map.get(strings[i])) == null){
				map.put(strings[i], 1);
			}else {
				map.put(strings[i], map.get(strings[i]).intValue()+1);
				System.out.println(strings[i]); 
			}
		}
	}

}

package com.wyy.wordcount;

public class Premutation {

	public static void main(String[] args) {
		String str = "ahds";
		premutation(str.toCharArray(), 3);
	}
	
	private static void premutation(char[] str,int i){
		if (i >= str.length) {
			return;
		}
		
		if (i == str.length - 1) {
			System.out.println(String.valueOf(str));
		}else {
			for(int j = i; j<str.length;j++){
				char temp = str[j];
				str[j] = str[i];
				str[i] = temp;
				
				premutation(str, i+1);
				
				temp = str[j];
				str[j] = str[i];
				str[i] = temp;
			}
		}
		
		
	}

}

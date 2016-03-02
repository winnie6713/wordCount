package com.wyy.wordcount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *˼·��  
	1�����ļ����ݴ���StringBuffer�С�
  	2������split()�����ָ��ַ������ɰ�(����������.���������������ո񡱣����س���)�ָ�õ�һ�����顣  
	3���������飬�������һ��Map <String,Integer>��,key=���ʣ�value=���ʳ��ֵĴ�����  
	4���� Ҫ����ļ��г���Ƶ����ߵļ������ʣ���Ҫ��Map��������  
 * @author weiyunyun 2016.2.24
 *
 */
public class WordCount {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\1.txt"));
			StringBuffer buffer = new StringBuffer();
			String string = "" ;
			while((string = reader.readLine())!=null){
				buffer.append(string);
			}
			Map<String, Integer> map = new HashMap<String, Integer>();
			StringTokenizer tokenizer = new StringTokenizer(buffer.toString(), ",.!\n");
			while(tokenizer.hasMoreTokens()){
				String letter = tokenizer.nextToken();
				int count;
				if(map.get(letter) == null){
					count = 1;
				}else {
					count = map.get(letter).intValue()+1;
				}
				map.put(letter, count);
			}
			Set<WordEntity> set = new TreeSet<WordEntity>();
			for(String key : map.keySet()){
				set.add(new WordEntity(key,map.get(key)));
			}
			
			//�Լ�ƴ���ַ��������������Ҫ���ַ�����ʽ
			for(Iterator<WordEntity> iterator = set.iterator();iterator.hasNext();){
				WordEntity entity = iterator.next();
				System.out.println("����"+entity.getKey()+"���ֵĴ���Ϊ��" + entity.getCount());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

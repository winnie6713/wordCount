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
 *思路：  
	1、将文件内容存入StringBuffer中。
  	2、利用split()函数分割字符串，可按(“，”，“.”，“！”，“空格”，“回车”)分割，得到一个数组。  
	3、遍历数组，将其放入一个Map <String,Integer>中,key=单词，value=单词出现的次数。  
	4、如 要求出文件中出现频率最高的几个单词，则要对Map进行排序。  
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
			
			//自己拼接字符串，输出我们想要的字符串格式
			for(Iterator<WordEntity> iterator = set.iterator();iterator.hasNext();){
				WordEntity entity = iterator.next();
				System.out.println("单词"+entity.getKey()+"出现的次数为：" + entity.getCount());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

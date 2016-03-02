package com.wyy.wordcount;

public class WordEntity implements Comparable<WordEntity>{

	private String key;
	private Integer count;
	
	public WordEntity(String key, Integer count) {
		super();
		this.key = key;
		this.count = count;
	}

	@Override
	public int compareTo(WordEntity o) {
		int cmp = count.intValue()-o.count.intValue();
		return cmp == 0 ? key.compareTo(o.key) : -cmp;
	}

	public String toString(){
		return key + "出现的次数为："+count;
	}

	public String getKey() {
		return key;
	}

	public Integer getCount() {
		return count;
	}
}

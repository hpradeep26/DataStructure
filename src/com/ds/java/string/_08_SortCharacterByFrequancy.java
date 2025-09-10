package com.ds.java.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class _08_SortCharacterByFrequancy {

	public static void main(String[] args) {
		List<Character> frequencySort = frequencySort("tree");
		System.out.println(frequencySort);
	}
	
	public static List<Character> frequencySort(String s) {
		List<Character> list = new ArrayList<Character>();
		Map<Character,Integer> map = new HashMap<>();
		 
		 for(int i=0;i<s.length();i++)
		    {
		        if(map.containsKey(s.charAt(i)))
		            map.put(s.charAt(i),map.get(s.charAt(i))+1);
		        else
		            map.put(s.charAt(i),1);
		    }
		System.out.println(map);
		
		
		List<Map.Entry<Character, Integer> > sortedDict = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		Collections.sort(sortedDict, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
			 return o1.getValue() == o2.getValue() ? o1.getKey() - o2.getKey() : o2.getValue() - o1.getValue();
			}
		});
		
		for (Map.Entry<Character, Integer> entry :sortedDict) {
			list.add(entry.getKey());
		}	
		return list;
	}
	
	

}

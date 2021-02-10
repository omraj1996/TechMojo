package com.java.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MaximumHashTags {
	//funtion to sort hashtags based on count values in descending order
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static void main(String[] args) {

		// Arrays of String to take input tweets
		String str[] = new String[] { "Worlds best cricketer is #sachin", "Worlds best cricketer is #sachin",
				"Worlds best cricketer is #sachin", "Worlds best cricketer is #sachin",
				"Worlds best cricketer is #Virat", "Worlds best cricketer is #Virat", "Worlds best cricketer is #Virat",
				"Worlds best cricketer is #Virat", "Worlds best cricketer is #Virat", "Worlds best cricketer is #Virat",
				"Worlds best cricketer is #Virat", "Worlds best cricketer is #Dhoni", "Worlds best cricketer is #Rahul",
				"Worlds best cricketer is #Shyam", "Worlds best cricketer is #Shyam", "Worlds best cricketer is #Shyam",
				"Worlds best cricketer is #Shyam", "Worlds best cricketer is #Shyam", "Worlds best cricketer is #Shyam",
				"Worlds best cricketer is #Shyam", "Worlds best cricketer is #Shyam", "Worlds best cricketer is #Shyam",

				"Worlds best cricketer is #Sohan", "Worlds best cricketer is #Sohan", "Worlds best cricketer is #Sohan",
				"Worlds best cricketer is #Sohan", "Worlds best cricketer is #Sohan", "Worlds best cricketer is #Mohan",
				"Worlds best cricketer is #Raju", "Worlds best cricketer is #Raju", "Worlds best cricketer is #Raju",
				"Worlds best cricketer is #Raju", "Worlds best cricketer is #Raju", "Worlds best cricketer is #Raju",
				"Worlds best cricketer is #Raju", "Worlds best cricketer is #Raju", "Worlds best cricketer is #Raju",
				"Worlds best cricketer is #Raju", "Worlds best cricketer is #Kaju", "Worlds best cricketer is #Hariom",
				"Worlds best cricketer is #Hari", "Worlds best cricketer is #Hari", "Worlds best cricketer is #Hari",
				"Worlds best cricketer is #Hari", "Worlds best cricketer is #Hari", "Worlds best cricketer is #Hari",
				"Worlds best cricketer is #Robby" };

		// Map for keeping track of hashtags and their counts
		HashMap<String, Integer> hastag = new HashMap<String, Integer>();
		for (int i = 0; i < str.length; i++) {
			// Arraylist for storing all the words generated from sentence.words are
			// separated using split functions from java.lang package and then stored in a
			// list.
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(str[i].split(" ")));

			for (int j = 0; j < list.size(); j++) {
				// check if the word is starting from # or not.If Yes, then store the word in
				// map and update the count(if not present then make the corresponding count as
				// 1).
				if (list.get(j).charAt(0) == '#') {
					if (hastag.containsKey(list.get(j))) {
						hastag.put(list.get(j), hastag.get(list.get(j)) + 1);
					} else {
						hastag.put(list.get(j), 1);
					}
				}
			}
		}
		// Call sort a map based on values
		Map<String, Integer> hashtags = sortByValue(hastag);
		int count = 0;
		//print top 10  trending hastag
		for (Entry<String, Integer> e : hashtags.entrySet()) {
			if (count == 10)
				break;
			count++;
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
}

//Output
#Raju 10
#Shyam 9
#Virat 7
#Hari 6
#Sohan 5
#sachin 4
#Hariom 1
#Kaju 1
#Rahul 1
#Robby 1

package com.frey.base.data.structure;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Frey on 2017/11/6.
 */
public class MapSetList {

    private static ConcurrentMap concurrentMap = new ConcurrentHashMap<String,String>();
    private static HashMap<String, String> hashMap = new HashMap<String, String>();
    private static LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();
    private static Hashtable<String,String> hashtable = new Hashtable<String, String>();
    private static HashSet<String> hashSet = new HashSet();

    private static ArrayList<String> arrayList = new ArrayList<String>();
    private static LinkedList<String> linkedList = new LinkedList<String>();



    public static void main(String[] args) {
        hashMap.put("A", "a");
        concurrentMap.put("B", "b");
        linkedHashMap.put("C", "c");
        hashtable.put("D", "d");
        hashSet.add("E");
        arrayList.add("f");
        linkedList.add("g");
        System.out.println(hashMap.get("A"));
        System.out.println(concurrentMap.get("B"));
        System.out.println(linkedHashMap.get("A"));
        System.out.println(hashtable.get("D"));
        System.out.println(hashSet.toString());

    }
}

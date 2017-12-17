package com.frey.hbase.service;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by frey on 2017/8/8.
 */
public class HBaseService {

    public static void main(String[] args) {
        String regEx = "count(\\d+)(df)";
        String s = "count000dfdfsdffaaaa1";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(s);
        if(mat.find()){
            System.out.println(mat.group(2));
        }
    }
}

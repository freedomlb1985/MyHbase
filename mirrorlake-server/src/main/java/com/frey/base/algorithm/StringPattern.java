package com.frey.base.algorithm;

/**
 * Created by Frey on 2017/11/14.
 */
public class StringPattern {
    public static void main(String[] args) {

    }

    public static int violentMatching(String s, String t) {
        int i =0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == t.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int KMP(String s, String t) {
        int i = 0;
        int j = 0;
        //得到next数组
        int[] next = getNext(t);
        while (i < s.length() && j < t.length()) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                //根据next数组的指示j进行回溯，而i永远不会回溯
                j = next[j];
            }
        }
        if (j == t.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String t) {
        int[] next = new int[t.length()];
        next[0] = -1;
        int suffix = 0;  // 后缀
        int prefix = -1;  // 前缀
        while (suffix < t.length() - 1) {
            //若相等或前缀索引为-1，则前缀后缀索引均+1
            if (prefix == -1 || t.charAt(prefix) == t.charAt(suffix)) {
                ++prefix;
                ++suffix;
                //改进的地方
                if (t.charAt(prefix) == t.charAt(suffix)) {
                    next[suffix] = next[prefix];
                } else {
                    next[suffix] = prefix;
                }
            } else {
                prefix = next[prefix];
            }
        }
        return next;
    }

}

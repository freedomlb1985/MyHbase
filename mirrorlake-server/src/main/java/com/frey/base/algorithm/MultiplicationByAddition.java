package com.frey.base.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frey on 2017/11/14.
 */
public class MultiplicationByAddition {

    public static void main(String[] args) {
        int a = 20;
        int b = 5;
        System.out.println(myAdd(a,b));
        System.out.println(mySub(a,b));//20-5会溢出得到错误结果
        System.out.println(myMulti(a,b));
        System.out.println(myDiv(a,b));
        System.out.println(myDiv(a,-b));

    }

    public static int myAdd(int a, int b) {
        return (a ^ b) + ((a & b) << 1);
    }

    public static int mySub(int a, int b) {
        return myAdd(a, myAdd(~b, 1));
    }

    public static int myMulti(int a, int b) {
        boolean flag = b < 0;
        if(flag) b = -b;
        Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
        for(int i = 0; i < 32; i ++) {
            pos.put(1 << i, i);
        }
        int sum = 0;
        while(b > 0) {
            int last = b & (~b + 1);
            sum += a << pos.get(last);
            b = b & (b -1);
        }
        if(flag) sum = - sum;
        return sum;
    }

    public static int myDiv(int a, int b) {
        boolean flag = (a < 0) ^ (b < 0);
        if(a < 0) a = -a;
        if(b < 0) b = -b;
        if(a < b) return 0;
        int msb =0;
        while((b << msb) < a) {
            msb++;
        }
        int q =0;
        for(int i = msb; i >=0; i--) {
            if((b << i) > a) continue;
            q |= 1 << i;
            a -= b << i;
        }
        if(flag) q = -q;
        return q;
    }

}
























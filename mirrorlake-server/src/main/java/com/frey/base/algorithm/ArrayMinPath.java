package com.frey.base.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Frey on 2017/11/19.
 */
public class ArrayMinPath {

    public static void main(String[] args) throws IOException {
        int [][] arr = new int[10][10];
        Random ran = new Random(System.currentTimeMillis());
        File f = new File("./data/array.txt");
        if(!f.getParentFile().exists()) {
            f.getParentFile().mkdir();
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                arr[i][j] = ran.nextInt(1000);
                bw.write(arr[i][j] + ",");
            }
            bw.newLine();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String line = null;
        while((line = br.readLine()) != null) {
            if(line.trim().length() == 0) {
                continue;
            }

        }
        getMinPath(arr);
    }

    public static int getMinPath(int[][] arr) {
        if(arr == null || arr.length ==0) {
            return 0;
        }
        int i = 0, j = 0;
        int row = arr.length;
        int col = arr[0].length;
        int [][] cache = new int[row][col];
        cache[0][0] = arr[0][0];
        for(i = 1; i < row ; i++) {
            cache[i][0] = cache[i - 1][0] + arr[i][0];
        }
        for(j = 1; j < col; j++) {
            cache[0][j] = cache[0][j] + arr[0][j];
        }
        for(i = 1; i < row; i++) {
            for(j = 1; j < col; j++) {
                if(cache[i - 1][j] < cache[i][j - 1]) {
                    cache[i][j] = cache[i-1][j] + arr[i][j];
                    System.out.println("[" + (i - 1) + ", " + j + "]");
                }else {
                    cache[i][j] = cache[i][j - 1] + arr[i][j];
                    System.out.println("[" + i + ", " + (j - 1) + "]");
                }
            }
        }
        System.out.println("[" + (row - 1) + ", " + (col - 1) + "]");
        System.out.println("Path: " + cache[row -1][col -1]);
        return cache[row -1][col -1];
    }

}

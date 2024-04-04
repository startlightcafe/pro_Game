package com.itheima.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //将一维数组打乱
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        //放到二维数组中
        int[][] arr2 = new int[4][4];

        //方法1
        for (int i = 0; i < arr.length; i++) {
            arr2[i / 4][i % 4] = arr[i];
        }
        //方法2
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = arr[i * 4 + j];
            }
        }

        // 输出
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.printf("%-2d ",arr2[i][j]);
            }
            System.out.println();
        }
    }
}

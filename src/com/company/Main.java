package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 冒泡排序
        // 循环变量
        int[] a = {1,4,7,9,33,66,77,88,};
        int count = 0;
        int jiaohuan = 0;
        System.out.println("原始数组：" + Arrays.toString(a));
        for (int i = 0; i < a.length-1; i++) {  //7
            for (int j = 0; j < a.length-1-i; j++) {  //7  0( (n-1 )) = n^2  0( (n-1) * ( n-1)) n^2
                if (a[j] > a[j+1]) {
                    System.out.println(a[j] + "和" + a[j + 1] + "交换位置");


                     int temp = a[j];
                      a[j] = a [j+1];
                      a[j+1] = temp;

                    System.out.println("交换完之后：" + Arrays.toString(a));
                    jiaohuan++;

                }
                count++;
            }

        }
        System.out.println("共运行了：" + count + "论排序" + jiaohuan + "轮交换");

    }
}

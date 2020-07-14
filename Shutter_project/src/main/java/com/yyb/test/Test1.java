package com.yyb.test;

/**
 * @author yuyongbo
 * @create 2020-06-30 14:40
 */
public class Test1 {

    public static void main(String[] args) {
        char[] a = {'a','b','c','d','e','f'};
        removeRight(a,4);
    }

    public static char[] removeRight(char[] chars ,int n){
        String str = String.valueOf(chars);
        String temp1 = str.substring(str.length() - n);
        String temp2 = str.substring(0,str.length() - n);
        System.out.println(temp1 + temp2);
        return (temp1 + temp2).toCharArray();
    }
}

package com.itheima.dao;

import java.util.Scanner;

public class SX8_1 {
    public static void main(String[] args) {
        test("3936300.362");
    }

    public static void test(String s){
//        Scanner input = new Scanner(System.in) ;
//        System.out.print("请输入钱的数值: ") ;
//        s = input.nextLine() ;
        //组件
        String num1[] = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"} ;
        String num2[] = {"","拾", "佰", "仟"} ;
        String num3[] = {"圆整", "万", "亿"} ;
        String num4[] = {"角", "分", "厘"} ;
        String sA = "";
        String sB = "";

        if(s.contains(".")) {
            sA = s.substring(0, s.indexOf(".")) ;
            sB = s.substring(s.indexOf(".")+1) ;

        }else {
            sA = s ;
        }

        int lengthA = sA.length() ;   //小数点之前的长度
        int lengthA1 = lengthA ;
        int m = 0;
        int n = 1;
        for(int i = 2; i >= 0; i--) {    // 判断 万 亿
            if(lengthA1 < i*4+1)
                continue ;

            if(lengthA == 1 && s.contains(".")
                    && sA.substring(lengthA-1).equals("0"))
                break ;
            int tailnum = lengthA-(i*4+1) ;
            for(int j = 3; j >= 0; j--) {
                if(lengthA1 != i*4 + j+1)
                    continue ;
                int num =Integer.parseInt(s.substring(m, n)) ;
                if(num == 0) {
                    if(lengthA1 > 1 && m != tailnum
                            && !s.substring(m+1,n+1).equals("0")) {
                        System.out.print(num1[num]) ;
                    }
                    else if(lengthA == 1)
                        System.out.print(num1[num]) ;
                    else if(lengthA1 == tailnum)
                        System.out.print(num2[num]) ;
                }
                else {
                    System.out.print(num1[num]) ;
                    System.out.print(num2[j]);
                }
                lengthA1-- ;
                m++;
                n++;
            }
            System.out.print(num3[i]);
        }
        if(s.contains(".")) {
            m = 0;
            n = 1;
            int lengthB = sB.length() ;
            for(int i = 0; i <= lengthB-1; i++) {
                int num =Integer.parseInt(sB.substring(i, i+1)) ;
                if(num == 0) {
                    if( i != lengthB-1 && !sA.equals("0")
                            && !sB.substring(i+1,i+2).equals("0"))
                        System.out.print(num1[num]) ;
                    else if(i == lengthB-1)
                        System.out.print(num2[num]) ;
                }
                else {
                    System.out.print(num1[num]) ;
                    System.out.print(num4[i]);
                }
            }
        }
        else
            System.out.print("整");
    }
}


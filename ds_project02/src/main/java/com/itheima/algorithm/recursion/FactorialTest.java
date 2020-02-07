package com.itheima.algorithm.recursion;

import java.math.BigInteger;

/**
 * 计算n!(n的阶乘)
 *
 * 包名：com.itheima.recursion 文件名：FactorialTest
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/7 14:55
 */
public class FactorialTest {
    //递推公式：0!=1 n!=n*(n-1)!

    /**
     * 传统的计算阶乘的方法
     * @param n 输入的数字，最大值不能超过12
     * @return n的阶乘
     */
    public static int factorial(int n) {
        if (n == 0){
            return 1;
        }else {
            return factorial(n-1)*n;
        }
    }

    /**
     * 当n较大时，改进为BigInteger构成的
     * @param n 输入的数字
     * @return n的阶乘
     */
    public static BigInteger factorial2(int n){
        if (n == 0){
            return BigInteger.ONE;
        }else {
            return BigInteger.valueOf(n).multiply(factorial2(n-1));
        }
    }

    public static void main(String[] args) {
        //测试12!=479,001,600， 13！=6,227,020,800  计算13!超出int的范围-2^31~ 2^31 -1** (-2147483648 ~ 2147483647)
        int factorial = factorial(13);
        System.out.println(factorial);

        //改进后的计算阶乘
        BigInteger bigInteger = factorial2(100);
        System.out.println(bigInteger);
    }
    //阶乘 n! 当我们n足够大的时候

    //数组处理我们的阶乘的问题

}

package main.newCoder;

/**
 * 两数相除
 */
public class Leetcode_29 {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend == -2147483648) return 2147483647;
            else return -dividend;
        }
        if(divisor == -2147483648){
            if(dividend == -2147483648) return 1;
            else return 0;
        }

        int quotient = 0;
        int count = 1;
        int state = 0; //1表示异号，0表示同号
        if(dividend < 0 && divisor > 0){
            state = 1;
            dividend = -dividend;
        }
        if(dividend > 0 && divisor < 0){
            state = 1;
            divisor = -divisor;
        }
        if(dividend < 0 && divisor < 0){
            divisor = -divisor;
            dividend = -dividend;
        }
        int origin_dividend = dividend;
        int origin_divisor = divisor;
        if(dividend < divisor) return 0;
        while(dividend >= divisor){
            dividend = dividend - divisor;
            divisor = divisor + divisor;
            quotient = quotient + count;
            count = count + count;
            if(divisor == -2147483648) break;
        }
        int res = quotient + divide(dividend, origin_divisor);
        if(state == 0){
            return res;
        }else{
            return -res;
        }
    }

    public static void main(String[] args) {
        Leetcode_29 leetcode_29 = new Leetcode_29();
        int res = leetcode_29.divide(-2147483648, 2);
        System.out.println(res);
    }
}
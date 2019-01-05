package org.gadget.image.test;

/**
 * 1，数值正负取反
 * 2，乘、除运算使用位运算
 * 3，……
 */
public class MathTest {

    /**
     * 数值正负取反
     *
     * @param num 目标数值
     * @return 取反数值
     */
    private static int negative(int num) {
        return (~num) + 1;
    }

    /**
     * 取绝对值
     * 若是正数，则返回
     * 若是负数，则转正数后返回
     *
     * @param num 正负数
     * @return 正数
     */
    private static int abs(int num) {
        if (num < 0) {
            return negative(num);
        } else {
            return num;
        }
    }

    /**
     * 位运算方式求乘积
     *
     * @param num1 被乘数
     * @param num2 扯乘数
     * @return 乘积
     */
    public static int mult(int num1, int num2) {
        boolean p = num1 > 0 && num2 > 0;
        if (!p) {
            if (num1 == 0 || num2 == 0)
                return 0;
            num1 = abs(num1);
            num2 = abs(num2);
        }
        int tmp = 0;
        while (num2 > 0) {
            if ((num2 & 1) > 0) tmp += num1;
            num1 <<= 1;
            num2 >>= 1;
        }
        return p ? tmp : negative(tmp);
    }

    /**
     * 位运算求商
     *
     * @param num1 被除数
     * @param num2 除数
     * @return 商
     */
    public static int div(int num1, int num2) throws Exception {
        if (num2 == 0)
            throw new Exception("被除数不可为0！");
        else if (num1 == 0)
            return 0;

        boolean p = num1 > 0 && num2 > 0;
        if (!p) {
            num1 = abs(num1);
            num2 = abs(num2);
        }

        int i, tmp;
        i = 31;
        tmp = 0;
        while (i >= 0) {
            if ((num1 >> i) >= num2) {
                tmp += (1 << i);
                num1 -= (num2 << i);
            }
            i--;
        }
        return p ? tmp : negative(tmp);
    }
}

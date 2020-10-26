package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 9:34 2020-10-20
 * @Description 找出比当前回文整数大的下一个回文整数
 **/
public class PalindromeInteger {
    /**
     * 将回文数分成左右两部分，如果为奇数的话左半部分带上中间值，现在要考虑两种情况：
     * 第一种是下一个回文数的位数会+1，例如99，999
     * 第二种是下一个回文数的位数不变，例如121，113311
     * 第一种情况将左右两部分都分别+1，再去掉左半部分的最后一个0，最后拼上+1后的右半部分的转置组，这种情况不区分整数位数的奇偶性
     * 第二种情况是将左半部分+1，再根据整数位数的奇偶性来确定下一步操作
     * 当为奇数时，截取左半部分的0-left-1个字符，转置后与左半部分拼接
     * 当为偶数时，直接将左半部分转置并与左半部分拼接,注意不能直接用stringBuffer.append(stringBuffer.reserve());
     * @param palindromeNumber
     * @return
     */
    public int palindrome(int palindromeNumber) {
        if (palindromeNumber < 9) {
            return palindromeNumber + 1;
        }
        if (palindromeNumber == 9) {
            return 11;
        }
        int ans = 0;
        int i = palindromeNumber % 2;

        String s = String.valueOf(palindromeNumber);
        boolean isOdd = s.length() % 2 == 0 ? false : true;
        StringBuffer stringBuffer = new StringBuffer(s);
        int mid = (stringBuffer.length() - 1) / 2;
        String left = stringBuffer.substring(0, mid + 1);
        String right = stringBuffer.substring(mid + 1, stringBuffer.length());
        int leftInt = Integer.valueOf(left)+1;
        int rightInt = Integer.valueOf(right) + 1;
        StringBuffer stringBuffer1 = new StringBuffer(String.valueOf(leftInt));
        StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(rightInt));
        if (stringBuffer1.length() > left.length()) {
            stringBuffer1.deleteCharAt(stringBuffer1.length() - 1);
            String string = stringBuffer1.append(stringBuffer2.reverse()).toString();
            ans = Integer.valueOf(string);
        } else {
            if (isOdd) {
                String string = stringBuffer1.append(new StringBuffer(stringBuffer1.substring(0, stringBuffer1.length() - 1)).reverse()).toString();
                ans = Integer.valueOf(string);
            } else {
                /*注意不能直接用stringBuffer.append(stringBuffer.reserve());*/
                String string = stringBuffer1.append(new StringBuffer(stringBuffer1.substring(0, stringBuffer1.length())).reverse()).toString();
                ans = Integer.valueOf(string);
            }

        }
        return ans;
    }
}

package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:31 2020-10-04
 * @Description 字符串转整形
 **/
public class MyAtoi {
    public int myAtoi(String s) {
        if(s.equals("")||s.isEmpty()){
            return 0;
        }
        char[] chars = s.toCharArray();
        String result="";
        int count=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]!=' '){
                System.out.println(chars[i]);
                System.out.println(Character.isDigit(chars[i]));
                if(chars[i]!='+'&&chars[i]!='-'&&!Character.isDigit(chars[i])){
                    return 0;
                }
                else{
                    result=result+chars[i];
                    if(chars[i]=='+'||chars[i]=='-'){
                        count=0;
                    }
                    else{
                        count=1;
                    }
                    for(int j=i+1;j<chars.length;j++){
                        if(Character.isDigit(chars[j])){
                            count++;
                            result=result+chars[j];
                        }
                        else{
                            break;
                        }
                    }
                    if(result.equals("+")||result.equals("-")){
                        return 0;
                    }


                    if (result.charAt(0) == '-') {
                        Long aLong = Long.valueOf(result);
                        int compare = aLong.compareTo(-2147483648l);
                        if (compare <= 0) {
                            return -2147483648;
                        } else {
                            //return Integer.valueOf(result);
                        }
                    }
                    else{
                        Long aLong = Long.valueOf(result);
                        int compare = aLong.compareTo(2147483647l);
                        if (compare <= 0) {
                            //return Integer.valueOf(result);
                        } else {
                            if (result.charAt(0)=='+')
                                return +2147483647;
                            else
                                return 2147483647;
                        }
                    }
                    break;
                }
            }
        }
        return Integer.valueOf(result);
    }

}

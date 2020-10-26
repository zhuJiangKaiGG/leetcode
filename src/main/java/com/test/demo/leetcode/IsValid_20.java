package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author :zjk
 * @Date :Create in 14:22 2020-10-13
 * @Description 有效的括号
 **/
public class IsValid_20 {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Map<Character,Character>map = new HashMap();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        if (s.length() % 2 == 1||s.charAt(0)==')'||s.charAt(0)=='}'||s.charAt(0)==']'||s.charAt(s.length()-1)=='('||s.charAt(s.length()-1)=='{'||s.charAt(s.length()-1)=='[') {
            return false;
        }
        //List可以换成栈，为空时，表示true
        List<Character> list = new ArrayList<>();
        boolean ans = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                list.add(s.charAt(i));
            } else {
                if(list.size()==0)
                    return false;
                Character character = map.get(list.get(list.size()-1));
                if (character.equals(s.charAt(i))) {
                    list.remove(list.size() - 1);
                } else {
                    ans = false;
                    break;
                }
            }
        }
        if(list.size()!=0){
            ans=false;
        }
        return ans;
    }
//    public boolean isValid(String s) {
//        int n = s.length();
//        if (n % 2 == 1) {
//            return false;
//        }
//
//        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
//            put(')', '(');
//            put(']', '[');
//            put('}', '{');
//        }};
//        Deque<Character> stack = new LinkedList<Character>();
//        for (int i = 0; i < n; i++) {
//            char ch = s.charAt(i);
//            if (pairs.containsKey(ch)) {
//                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
//                    return false;
//                }
//                stack.pop();
//            } else {
//                stack.push(ch);
//            }
//        }
//        return stack.isEmpty();
//    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

package com.test.demo.leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author :zjk
 * @Date :Create in 19:29 2020-09-13
 * @Description 无重复字符最长字串
 **/
public class LongestSubString {
    //自己思路，利用map,不适合abcadefghijk用例;需要对每个字符进行遍历
    public int lengthOfLongestSubstring(String s) {
        int array = 0;
        int count = 0;
        Map<String,Integer>map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
            //这里要对最好一个字符进行判断，当最后一个字符也属于最长字串时，要+1
            if (map.get(String.valueOf(chars[i])) != null||i == (chars.length-1)) {
                //记录长度在这里操作
                if (count > array) {
                    if(i==(chars.length-1)&&map.get(String.valueOf(chars[i])) == null){
                        array=count+1;
                        System.out.println("成功");
                    }
                    else{
                        array=count;
                    }

                }
                map.clear();
                map.put(String.valueOf(chars[i]), i);
                count = 1;
            } else {
                count++;
                map.put(String.valueOf(chars[i]), i);
            }
        }
        return array;
    }

    /**
     * 发现了什么？如果我们依次递增地枚举子串的起始位置，那么子串的结束位置也是递增的！这里的原因在于，假设我们选择字符串中的第 kk 个字符作为起始位置，并且得到了不包含重复字符的最长子串的结束位置为 r_kr
     * k
     * ​
     *  。那么当我们选择第 k+1k+1 个字符作为起始位置时，首先从 k+1k+1 到 r_kr
     * k
     * ​
     *   的字符显然是不重复的，并且由于少了原本的第 kk 个字符，我们可以尝试继续增大 r_kr
     * k
     * ​
     *  ，直到右侧出现了重复字符为止。
     *
     * 这样以来，我们就可以使用「滑动窗口」来解决这个问题了：
     *
     * 我们使用两个指针表示字符串中的某个子串（的左右边界）。其中左指针代表着上文中「枚举子串的起始位置」，而右指针即为上文中的 r_kr
     * k
     * ​
     *  ；
     *
     * 在每一步的操作中，我们会将左指针向右移动一格，表示 我们开始枚举下一个字符作为起始位置，然后我们可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度；
     *
     * 在枚举结束后，我们找到的最长的子串的长度即为答案。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_Answer(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为0，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符，避免滑动窗口中出现重复的字符
                //例如abcade,当i从0遍历时，Set中包含abc，此时把需要把a删除才能进入到while循环里
                occ.remove(s.charAt(i - 1));
            }
            while (rk  < n && !occ.contains(s.charAt(rk))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i);
        }
        return ans;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

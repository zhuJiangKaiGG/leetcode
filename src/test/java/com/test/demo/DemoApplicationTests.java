package com.test.demo;

import com.test.demo.dao.ClientDao;
import com.test.demo.leetcode.*;
import com.test.demo.reflect.Animal;
import com.test.demo.reflect.AnimalFactory;
import com.test.demo.test.SingletonTest;
import com.test.demo.test.decoratorattern.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    ClientDao clientDao;
    @Test
    void triggerDemo(){
        try {
            clientDao.changePassword();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    void procedureDemo(){
        try {
            clientDao.findAllClient();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    void tttt(){
        int i = 5, j = 2;
        System.out.println((double) i/(double) j);
    }
    @Test
    void contextLoads() {
        List<String>list=new ArrayList();
        String[] s= new String[]{"s,c,d"};
        String[] b = s;
        s[0] = "g";
        System.out.println(b[0]);
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/42852fd7045c442192fa89404ab42e92?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
     * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
     * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
     *链接：https://www.nowcoder.com/questionTerminal/42852fd7045c442192fa89404ab42e92?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 解题思路：分析题意，列出出现所有情况。
     * 这里采用了一个列表记录检索的元素，当列表为空，添加指针所指元素；
     * 当列表只存在一个元素时，比较元素是否相同，若相同则添加，不同则删除列表中的第一个元素；
     * 当列表存在两个元素时，比较元素是否相同，若相同则删除字符串中指针所指元素，不同则添加至列表；
     * 当列表存在三个元素时，若元素与列表最后一个元素相同则删除字符串中指针所指元素，不同则删除此时列表中所有的元素并添加该元素。直至遍历完字符串。
     */
    @Test
    public void num1(){
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        List<StringBuilder> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            StringBuilder str=new StringBuilder();
            String STR=new String();
            STR=scan.next();
            str.append(STR);
            list.add(str);
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<N;i++) {
            str=list.get(i);
            int j=0;
//char a=' ';
            List<Character> slist=new LinkedList<>();
            while(j<str.length()) {
                char a=str.charAt(j);
                //if 和 else if两个都满足，只执行第一个
                if(slist.isEmpty()) {
                    slist.add(0, a);
                    j++;
                }
                else if(slist.size()==1&&slist.get(0)==a) {
                    slist.add(1, a);
                    j++;
                }
                else if(slist.size()==2&&slist.get(1)==a) {
                    str.deleteCharAt(j);
                }
                else if(slist.size()==2&&slist.get(1)!=a) {
                    slist.add(a);
                    j++;
                }
                else if(slist.size()==3&&slist.get(2)==a) {
                    str.deleteCharAt(j);
                }
                else if(slist.size()==3&&slist.get(2)!=a){
                    slist.clear();
                    slist.add(a);
                    j++;
                }
                else {
                    slist.clear();
                    slist.add(a);
                    j++;
                }
            }
            System.out.println(str);

    }
//        Student student = studentMapper.selectByPrimaryKey(6);
//        System.out.println("student");
//        System.out.println(student);
    }
    @Test
    void Singleton(){
        SingletonTest instance = SingletonTest.getInstance();
        instance.setName("zjk");
        System.out.println(instance.getName());
    }
    @Test
    void atoi(){
        System.out.println(-120%10);

    }

    @Test
    void reflectTest() throws ClassNotFoundException {
        Animal animal = AnimalFactory.createAnimal("com.test.demo.reflect.Dog");
        animal.shout();
    }
    @Test
    void decoratorTest(){
        Beverage beverage = new DarkRoast();
        System.out.println(beverage.getDescription()+"   price:"+beverage.cost());
        Beverage beverage1 = new Decaf();
        System.out.println(beverage1.getDescription()+"    price"+beverage1.cost());
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription()+"    price"+beverage1.cost());
        beverage1 = new Milk(beverage1);
        System.out.println(beverage1.getDescription()+"    price"+beverage1.cost());
    }
    @Test
    void test_12(){
        IntToRoman_12 intToRoman_12 = new IntToRoman_12();
        String s = intToRoman_12.intToRoman(58);
        System.out.println(s);
    }
    @Test
    void test_13(){
        RomanToInt_13 romanToInt_13 = new RomanToInt_13();
        int iv = romanToInt_13.romanToInt("IV");
        System.out.println(iv);
    }
    @Test
    void test_14(){
        LongestCommonPrefix_14 longestCommonPrefix_14 = new LongestCommonPrefix_14();
        String[] strs = new String[]{"ab", "a"};
        String s = longestCommonPrefix_14.longestCommonPrefix(strs);
        System.out.println(s);
    }
    @Test
    void test_15(){
        ThreeSum_15 threeSum_15 = new ThreeSum_15();
        ThreeSum_15 threeSum_151 = new ThreeSum_15();
        System.out.println(threeSum_15==threeSum_151);


    }
    @Test
    void test_17(){
//        LetterCombinations_17 letterCombinations_17 = new LetterCombinations_17();
//    List<>
//        letterCombinations_17.backtrack();
}
    @Test
    void  test_18(){
        FourSum_18 fourSum_18 = new FourSum_18();
        List<List<Integer>> lists = fourSum_18.fourSum(new int[]{-4,0,-4,2,2,2,-2,-2}, 7);
        System.out.println(lists);
    }
    @Test
    void test_19(){
        IsValid_20 isValid_20 = new IsValid_20();
        isValid_20.isValid("()[]{}");
    }
    @Test
    void test_22(){
        GenerateParenthesis_22 generateParenthesis_22 = new GenerateParenthesis_22();
        List<String> list = generateParenthesis_22.generateParenthesis(3);
        System.out.println(list);
    }
    @Test
    void test_23(){
//        MergeKLists_23 mergeKLists_23 = new MergeKLists_23();
//        MergeTwoLists_21.ListNode listNode = new MergeTwoLists_21.ListNode(1);
//        mergeKLists_23.mergeKLists()
    }
    @Test
    void test_25(){
        ReverseKGroup reverseKGroup = new ReverseKGroup();

    }
    @Test
    void test_26(){
        RemoveDuplicates_26 removeDuplicates_26 = new RemoveDuplicates_26();
        int i = removeDuplicates_26.removeDuplicates(new int[]{1, 1, 2});
        System.out.println(i);
    }
    @Test
    void test_pn(){
        PalindromeInteger palindromeInteger = new PalindromeInteger();
        int palindrome = palindromeInteger.palindrome(113311);
        System.out.println(palindrome);
    }
    @Test
    void test_32(){
        LongestValidParentheses_32 longestValidParentheses_32 = new LongestValidParentheses_32();
        int i = longestValidParentheses_32.longestValidParentheses("(()");
        System.out.println(i);
    }

}

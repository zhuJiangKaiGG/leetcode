package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 10:48 2020-09-15
 * @Description 寻找两个正序数组的中位数
 **/
public class FindMedianSortedArrays {
    /**
     * 思路：
     *创建一个新数组，长度为num1和num2数组长度之和。
     *将两个数组的数按顺序排列在新数组中
     * 找出新数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays_my(int[] nums1, int[] nums2) {
        int num2_index=0;//nums2数组的索引
        double result = 0;//结果
        int flag=0;//判断第一个数组是否遍历完成，0否，1遍历完成
        int count=0;//计算midNum数组已经赋值的个数
        int[] midNum=new int[nums1.length+nums2.length];//存储第一个和第二个数组的值
        if(nums1.length==0&&nums2.length!=0){
            midNum=nums2;
        }
        if(nums2.length==0&&nums1.length!=0){
            midNum=nums1;
        }
        if(nums1.length!=0&&nums2.length!=0){//当两个数组都不为空时将原数组合并为一个升序的新数组
            for (int i = 0; i < nums1.length; i++){//对第一个数组进行遍历
                while(num2_index < nums2.length){//对第二个数组进行遍历
                    //将第二个数组中比第一个数组第i个值小的放入数组中
                    if (nums1[i] > nums2[num2_index]){
                        midNum[i + num2_index] = nums2[num2_index];
                        count++;
                        num2_index++;
                    }
                    //遇到比num1[i]大的数时如果num1数组遍历完，则继续将剩下num2加入midNum中
                    // 如果没有遍历完则停止遍历num2数组，
                    else{
                        if(flag==0){
                            //如果num1数组没有遍历完，将num1[i]加入到midNum数组中
                            //遍历完时，不需要再将num[i]中的值加入到midNum中
                            midNum[i + num2_index] = nums1[i];
                            count++;
                        }
                        //当遍历到num[i]最后一个值时，将flag设为1，表示数组num1已经遍历完
                        if((i+1)==nums1.length){
                            flag=1;
                            //num1数组已经全部都存入minNum中，将当前遍历的num2[num2_index]加入到midNum中
                            midNum[i + num2_index + 1] = nums2[num2_index];
                            count++;
                            num2_index++;
                        }
                        //停止num2遍历
                        else{
                            break;
                        }
                    }

                }
                //停止遍历num2后，如果num2遍历完了，则需要判断是否将当前的num1[i]加入到midNum中
                if (num2_index == nums2.length) {
                    if ((i + 1) != nums1.length) {
                        midNum[i + num2_index] = nums1[i];
                    }
                    //假如当前count!=midNum.length,即num1中还有值未赋值
                    if (count != midNum.length) {
                        midNum[i + num2_index] = nums1[i];
                    }
                }

            }
        }
        if ((midNum.length % 2)==0){
            result = ((double) midNum[(midNum.length / 2) - 1] + (double) midNum[(midNum.length / 2)]) / 2;
        }
        else{
            result = ((double) midNum[(midNum.length - 1) / 2]);
        }
        return result;
    }
}

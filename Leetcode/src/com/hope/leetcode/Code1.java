package com.hope.leetcode;

import java.util.ArrayList;

/**
 *题目描述：
 *	Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *	Try to solve it in linear time/space.
 *	Return 0 if the array contains less than 2 elements.
 *	You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range. 
 *题目大意：
 *	给定一个未排序的数组，找出其排序后的序列中两个相邻元素之间的最大差值。
 *	最好在线性时间、线性空间复杂度内完成。
 *	如果数组少于2个元素，返回0
 *	可以假设数组中的所有元素均为非负整数，并且在32位带符号整数的范围以内。
 */
public class Code1 {
	public int maximumGap(int[] nums) {
		//TODO 学习了桶排序但是还没有成功，明天继续搞
		if(nums.length<2)
			return 0;
		ArrayList<Integer> buckets = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			buckets.add(nums[i],buckets.get(nums[i]++));
		}
		for(int i=0,j=0;i<buckets.size();i++){
			while(buckets.get(i)!=null){
				buckets.set(i, (buckets.get(i)-1));
				nums[j]=i;
			}
		}
		
		return 0;
    }
}

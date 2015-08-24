package com.hope.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


/**
 *题目描述：
 *		Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *		Try to solve it in linear time/space.
 *		Return 0 if the array contains less than 2 elements.
 *		You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range. 
 *题目大意：
 *		给定一个未排序的数组，找出其排序后的序列中两个相邻元素之间的最大差值。
 *		最好在线性时间、线性空间复杂度内完成。
 *		如果数组少于2个元素，返回0
 *		可以假设数组中的所有元素均为非负整数，并且在32位带符号整数的范围以内。
 *解题思路：
 *		1、一般桶排序的思路：
 *			背景：对n个取值范围满足【0,1）的数组nums[]进行排序
 *			算法：
 *				a、假设同时又n个桶，将第i个数放入下标为：Math.floor(nums[i]*n)（注①）的桶中
 *				b、重复a操作，是nums[]数组中的数全部放入对应的桶中。
 *				c、对每个桶进行排序（可以选择任意方法，包括调用桶排序递归方法）
 *				d、将各个排完序的桶按照顺序打印出里面的数字
 *				e、得到排序后的数组。
 *		2、本题中的基于桶排序的改造算法：
 *			背景：由于本题中数组的取值范围在【0,2147483647)之间，
 *					不满足一般桶排序的条件，所以在计算各个数字对应的桶下标时，
 *					需要进行转化为【0,1）的操作。
 *					新的下标公式，即：(nums[i]-min)/(max-min)*(n-1)（注②）
 *			算法：
 *				a、遍历一遍待排序数组，找出数组中的最大值和最小值
 *				b、根据新的下标公式，重复桶排序操作
 *				c、根据排序后的数组，重新遍历，找出最大间隙。并返回。
 *		注：
 *			①：Math.floor()作用是进行向上取整
 *			②：这里的n-1是由于桶标号由0开始导致的最大桶标号为（n-1）
 */
public class Code1 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int maximumGap(int[] nums) {
		int len = nums.length;//len用来存储待排序数组长度
		if(len<2){
			return 0;
		}
		//初始化桶
		ArrayList[] buckets = new ArrayList[len];//用array来声明桶的数组
		//确定最大和最小值
		int max = 0;
		int min = 0;
		for (int num : nums) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		//		分桶
		for (int i = 0; i < len; i++) {
			int temp = (int) Math.floor((nums[i]-min)/(max-min)*(len-1));//确定nums[i]的桶标号
			if(null == buckets[temp])
				buckets[temp] = new ArrayList();
			buckets[temp].add(nums[i]);
		}
		//		小桶排序
		for (int i = 0;i < len;i++) {
			if(null!=buckets[i])
				Collections.sort(buckets[i]);//用集合自带的排序来为小桶内部排序
		}
		//		打印排序结果
		int count = 0;
		for (int i = 0; i < len; i++) {
			if(null!=buckets[i]){
				Iterator it = buckets[i].iterator();
				while(it.hasNext()){
					 int sortedNum = (Integer)it.next();
					 nums[count] = sortedNum;
					 count++;
				}
			}
		}
		//		确定最大间隙值
		int maximumGap = 0;
		for (int i = 0; i < len-1; i++) {
			int temp = (nums[i+1] - nums[i]);
			maximumGap = Math.max(maximumGap, temp);
		}
		return maximumGap;
    }
}

package com.hope.leetcode;

/**
 * 8/23/2015
 * 阿里笔试第19题
 * 	一组整型数中，有一个数字重复3遍，其它数字重复2遍，
 * 	请找出这个重复3遍的数字。比如：
 * 		[88, 459, 5262, 88, -17, 88, -17, 459, 5262], 结果为88。
 * 	要求程序代码中额外申请的空间为O(1)，
 * 	请给出一个平均时间复杂度不大于O(nlogn)的算法。
 * 	请首先用文字阐述答题思路，然后用Java程序实现。
 * 注：水平有限，并没有很好地完成这道题
 */
public class Code2 {
	public int solution(int nums[]){
		int[] buckets = new int[65535];
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]<0)
				buckets[65535+nums[i]]++;
			else 
				buckets[nums[i]]++;
		}
		for(int i= 0,j=0; i < 65535;i++){
			if(buckets[i]==3)
				if (i>32767)
					return i-65535;
				else return i;
			while((buckets[i]--)>0){
				nums[j++]=i;
			}
		}
		buckets=null;
		return 0;
	}
}

package com.hope.leetcode;

import java.util.ArrayList;

/**
 *��Ŀ������
 *	Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *	Try to solve it in linear time/space.
 *	Return 0 if the array contains less than 2 elements.
 *	You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range. 
 *��Ŀ���⣺
 *	����һ��δ��������飬�ҳ�����������������������Ԫ��֮�������ֵ��
 *	���������ʱ�䡢���Կռ临�Ӷ�����ɡ�
 *	�����������2��Ԫ�أ�����0
 *	���Լ��������е�����Ԫ�ؾ�Ϊ�Ǹ�������������32λ�����������ķ�Χ���ڡ�
 */
public class Code1 {
	public int maximumGap(int[] nums) {
		//TODO ѧϰ��Ͱ�����ǻ�û�гɹ������������
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

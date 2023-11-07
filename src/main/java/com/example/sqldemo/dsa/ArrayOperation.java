package com.example.sqldemo.dsa;

import java.math.BigInteger;
import java.util.*;

public class ArrayOperation {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
       /* 1) if m= 0 ? return num2
        2) if n = 0 ? return num1
        3) take elements from nums1 upto length of m and put it into array
        4) take elements from nums2 upto length of n and put it into array
        5) sort the array
*/
        if (n >= 0) System.arraycopy(nums2, 0, nums1, 0 + m, n);
        System.out.println(Arrays.toString(nums1));
        Arrays.sort(nums1);
        return nums1;
    }

    public int removeElement(int[] nums, int val) {
        /*1) define variable k =0
        2) take variable size and assign length of nums in that var
        3) iterate nums[]
        4) remove elements that matches the value
        5) define variable k and assign length of nums
        6) now fill remaining data in nums*/

        int k = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                k = k - 1;
                nums[i] = Integer.MAX_VALUE;
            }
        }
        Arrays.sort(nums);
        return k;
    }

    public int removeDuplicates(int[] nums) {
        List<Integer> integerList = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!integerList.contains(nums[i])) {
                integerList.add(nums[i]);
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    /*
    * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

    Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.

    Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.*/
    public int removeDuplicatesWithUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) <= 2) {
                nums[index] = nums[i];
                index++;
            }
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        return index;
    }

    public int[] sortArrayByParity(int[] nums) {
        int[] array = new int[nums.length];

        int startIndex = 0;
        int endIndex = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                array[startIndex] = num;
                startIndex++;
            } else {
                array[endIndex] = num;
                endIndex--;
            }
        }
        return array;
    }

    /*
    * An array is monotonic if it is either monotone increasing or monotone decreasing.

    An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

    Given an integer array nums, return true if the given array is monotonic, or false otherwise.



    Example 1:

    Input: nums = [1,2,2,3]
    Output: true
    Example 2:

    Input: nums = [6,5,4,4]
    Output: true
    Example 3:

    Input: nums = [1,3,2]
    Output: false
 */
    public static boolean isMonotonic(int[] nums) {
       boolean asc = true;
       boolean desc = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[i+1]) {
                asc = false;
            }
            if (nums[i] < nums[i+1]) {
                desc = false;
            }
        }
        return asc || desc;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : nums) {
            map.put(integer, map.getOrDefault(integer,0) + 1);
        }
        return map.values().stream().max(Integer::compareTo).get();
    }

    /*Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
        Example 1:

        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]
        Example 2:

        Input: nums = [-1,-100,3,99], k = 2
        Output: [3,99,-1,-100]
        Explanation:
        rotate 1 steps to the right: [99,-1,-100,3]
        rotate 2 steps to the right: [3,99,-1,-100]
 */
    public static void rotate(int[] nums, int k) {
        reverse(nums,0, nums.length - k -1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    /*
    * Given an array of integers nums, return the number of good pairs.

    A pair (i, j) is called good if nums[i] == nums[j] and i < j.



    Example 1:

    Input: nums = [1,2,3,1,1,3]
    Output: 4
    Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
    Example 2:

    Input: nums = [1,1,1,1]
    Output: 6
    Explanation: Each pair in the array are good.
    Example 3:

    Input: nums = [1,2,3]
    Output: 0*/
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int[] plusOne(int[] digits) {
        StringBuilder builder = new StringBuilder();
        for(Integer integer : digits) {
            builder.append(integer);
        }
        String number = String.valueOf(new BigInteger(builder.toString()).add(BigInteger.ONE));
        int[] array = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            array[i] = Character.getNumericValue(number.charAt(i));
            System.out.println(number.charAt(i));
        }
        return array;
    }

    public static void splitArray(int[] nums, int size) {
        List<List<Integer>> multiIntList = new LinkedList<>();

        int count = 0;
        while (count < nums.length) {
            List<Integer> list = new LinkedList<>();

            int count1 = 0;
            for (int i = count1; i < size && count < nums.length; i++) {
                list.add(nums[count]);
                count++;
            }
            multiIntList.add(list);
        }
        System.out.println(multiIntList);
    }

    public int[] searchRange(int[] nums, int target) {
        int firstPosition = -1;
        int lastPosition = -1;

        for(int i = 0; i < nums.length; i++) {
            if (i == target) {
                firstPosition = firstPosition == -1 ? i : firstPosition;
                lastPosition = i;
            }
        }

        return new int[]{firstPosition, lastPosition};
    }

    /*
    * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

    Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

    0 <= j <= nums[i] and
    i + j < n
    Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



    Example 1:

    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example 2:

    Input: nums = [2,3,0,1,4]
    Output: 2
 */
    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return nums.length - 1;
        }
        int index = 0;
        int jump = 0;

        for (int i = 0; i < nums.length; i++) {
            int maxJump = i == 0 ? 0 : index < nums.length ? nums[index] : nums[nums.length - 1];
            if (maxJump <= nums[i] && i != 0) {
                jump = jump + 1;
                index = index + nums[i];
            }
        }

        return jump;
    }
}

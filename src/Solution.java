import java.util.HashSet;

public class Solution {
    //Given an array of integers nums which is sorted in ascending order, and an integer target,
    // write a function to search target in nums.
    // If target exists, then return its index. Otherwise, return -1.
    //
    //You must write an algorithm with O(log n) runtime complexity.
    static public int search(int[] nums, int target) {

        if(nums.length < 1 || nums.length > Math.pow(10,4) )
            return -1;
        if(target > Math.pow(10,4))
            return -1;

        if(!(isSorted(nums)))
            return -1;

        HashSet<Integer> hash = new HashSet<>();
        for (int num : nums) {
            hash.add(num);
        }
        //test for uniqueness
        if(hash.size() != nums.length)
        {return -1;}

        int high = nums.length-1;
        int low = 0;
        int midpoint;
        //while low < high
        while(!(low > high) ){

            //find midpoint low - high /2
            midpoint = (high + low )/2;
            //check if midpoint == target if so return midpoint
            if(nums[midpoint] == target)
                return midpoint;

            //if target is greater than midpoint shift start to mid+1 (want to search right side of midpoint)
            if(target > nums[midpoint] )
            {
              low = midpoint+1;
            }
            //if target is less than the midpoint shift high to mid-1 (want to search left side of midpoint)
            if(target < nums[midpoint])
            {
                high = midpoint -1;
            }
        }
        return  -1;
    }

    static boolean isSorted(int[] nums)
    {
        if (nums.length <= 1)
            return true;

        for (int i =1; i < nums.length; i++) {
            if(nums[i] > Math.pow(-10,4))
                return false;

            if(nums[i - 1] > nums[i])
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        double n = Math.pow(10,4);
        int i = (int) n;
        int[] nums = new int[i +1];
        int target =9;

        System.out.println(search(nums, target) );
    }
}

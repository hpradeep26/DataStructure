package co.ds.java.leetcode75.prefixsum;

public class _L_724_Find_Pivot_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int pivotIndex(int[] nums) {
        // Initialize total sum of the given array...
      int totalSum = 0;
      // Initialize 'leftsum' as sum of first i numbers, not including nums[i]...
      for (int ele : nums)
          totalSum += ele;

      int leftTotal=0;
      for(int i = 0;i<nums.length;i++){
          int rightTotal = totalSum - leftTotal - nums[i];
          if(rightTotal==leftTotal){
              return i;
          }
          leftTotal += nums[i];
      }
   return -1;
  }

}

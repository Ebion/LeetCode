class Solution {
    public boolean isGoodArray(int[] nums) {
        Arrays.sort(nums);
        
        int result = nums[0];
        for (int element: nums) {
            result = gcd(result, element);
  
            if(result == 1)
            {
               return true;
            }
        }
        
        return false;
    }
    
    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return gcd(b % a, a);
        }
    }
    
    // The array can never reach 1 if the array has a perfect square/multiplicative number
    // Lets say there is 3, 6, 9, then this would be impossible, or 2, 4, 6, 8, 10
    // Find the common demoniator instead which needs to be a common factor of all numbers present
}
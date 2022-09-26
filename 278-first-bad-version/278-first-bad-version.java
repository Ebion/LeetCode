/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); 
      
      false, false, true, true
      
      
      
      */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int first = 0;
        int last = n;
        
        int result = 0;
        
        while (first <= last) {
            int mid_pt = first + (last-first)/2;
            boolean curr = isBadVersion(mid_pt);
            if (!curr) {
                first = mid_pt + 1;
            } else {
                last = mid_pt - 1;
                result = mid_pt;
            }
        }
        return result;
    }
}
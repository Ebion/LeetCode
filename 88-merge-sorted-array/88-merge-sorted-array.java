class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int i3 = m + n - 1;
        while (i3 >= 0) {
            if (i2 < 0) {
                break;
            } else if (i1 < 0) {
                nums1[i3] = nums2[i2];
                i3--;
                i2--;
            } else if (nums1[i1] >= nums2[i2]) {
                int replacement = nums1[i1];
                nums1[i3] = replacement;
                i3--;
                i1--;
            } else if (nums1[i1] < nums2[i2]) {
                nums1[i3] = nums2[i2];
                i3--;
                i2--;
            } 
        }
    }
}
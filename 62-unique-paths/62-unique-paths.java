class Solution {
    public int uniquePaths(int m, int n) {
        int total_moves = (m-1) + (n-1);
        int move_down = n - 1;
        return NcR(total_moves, move_down);
    }
    
    static int NcR(int n, int r)
    {
 
        // p holds the value of n*(n-1)*(n-2)...,
        // k holds the value of r*(r-1)...
        int p = 1, k = 1;
 
        // C(n, r) == C(n, n-r),
        // choosing the smaller value
        if (n - r < r) {
            r = n - r;
        }
 
        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;
 
                // gcd of p, k
                int m = __gcd(p, k);
 
                // dividing by gcd, to simplify
                // product division by their gcd
                // saves from the overflow
                p /= m;
                k /= m;
 
                n--;
                r--;
            }
 
            // k should be simplified to 1
            // as C(n, r) is a natural number
            // (denominator should be 1 ) .
        }
        else {
            p = 1;
        }
 
        // if our approach is correct p = ans and k =1
        return p;
    }
 
    static int __gcd(int n1, int n2)
    {
        int gcd = 1;
 
        for (int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
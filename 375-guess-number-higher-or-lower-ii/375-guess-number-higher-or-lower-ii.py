import sys

class Solution(object):
    def getMoneyAmount(self, n):
        def dp(s,e):
            if (s, e) in memo:
                return memo[(s,e)];
            
            if (s >= e):
                return 0;
            
            ans = sys.maxsize
            
            for k in range(s,e+1):
                next_step = max(dp(s,k-1), dp(k+1,e))
                ans = min(ans, k + next_step);
            
            memo[(s,e)] = ans;
            return ans;
        
        memo = {}
        return dp(1,n);
        
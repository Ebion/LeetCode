class Solution(object):
    def longestPalindrome(self, words):
        d = {}
        result = 0
        doubles = 0
        for word in words:
            opp = word[::-1]
            if (opp == word):
                if (word in d):
                    d[opp] = d[opp] - 1
                    if (d[opp] == 0):
                        del d[opp]
                    result = result + 2
                    doubles = doubles - 1;
                else:
                    if (word in d):
                        d[word] = d[word] + 1
                    else :
                        d[word] = 1
                    doubles = doubles + 1
            else:
                if (opp in d):
                    d[opp] = d[opp] - 1
                    if (d[opp] == 0):
                        del d[opp]
                    result = result + 2;
                else:
                    if (word in d):
                        d[word] = d[word] + 1
                    else :
                        d[word] = 1
        if (doubles > 0):
            result = result + 1;
        return result*2;
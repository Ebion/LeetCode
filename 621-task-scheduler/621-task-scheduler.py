class Solution(object):
    def leastInterval(self, tasks, n):
        d = {}
        result = 0;
        if (n == 0):
            return len(tasks);
        for task in tasks:
            if (task in d):
                d[task] = d[task] + 1
            else:
                d[task] = 1
        while (d):
            steps = n + 1;
            for k, v in sorted(d.items(), key=lambda item: item[1],reverse=True):
                ##print(k, result, steps)
                if (steps == 0):
                    break
                else:
                    d[k] = d[k] - 1;
                    result = result + 1
                    steps = steps - 1;
                    if (d[k] == 0):
                        del d[k]
            if (d):
                result = result + steps;
        return result;
        
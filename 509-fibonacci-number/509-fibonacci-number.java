class Solution {
    public int fib(int n) {
        int[] fib_arr = new int[2];
        fib_arr[0] = 0;
        fib_arr[1] = 1;
        int counter = 2;
        if (n == 0) {
            return 0;
        }
        while (counter <= n) {
            int curr_fib = fib_arr[0] + fib_arr[1];
            fib_arr[0] = fib_arr[1];
            fib_arr[1] = curr_fib;
            counter += 1;
        }
        return fib_arr[1];
    }
}
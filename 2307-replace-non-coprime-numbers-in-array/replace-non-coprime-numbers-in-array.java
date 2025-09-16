import java.util.*;

class Solution {
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a * b) / gcd(a, b);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Long> stack = new ArrayList<>();
        
        for (int num : nums) {
            stack.add((long) num);

            while (stack.size() > 1) {
                long a = stack.get(stack.size() - 1);
                long b = stack.get(stack.size() - 2);
                long g = gcd(a, b);
                
                if (g == 1) break;
                
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add(lcm(a, b));
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (long val : stack) {
            ans.add((int) val);
        }
        return ans;
    }
}
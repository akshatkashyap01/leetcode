class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (char d = '0'; d <= '9'; d++) {
            String replaced = numStr.replace(d, '9');
            int value = Integer.parseInt(replaced);
            maxVal = Math.max(maxVal, value);
        }

        for (char d = '1'; d <= '9'; d++) {
            String replaced = numStr.replace(d, '0');
            int value = Integer.parseInt(replaced);
            minVal = Math.min(minVal, value);
        }
        
        return maxVal - minVal;
    }
}
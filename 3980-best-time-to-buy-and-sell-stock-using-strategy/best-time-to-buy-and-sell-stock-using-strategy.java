class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int len = prices.length;
        long[] pref = new long[len+1];
        long[] strPref = new long[len+1];
        for(int i = 0; i < len; i++){
            pref[i+1] = pref[i] + prices[i];
            strPref[i+1] = strPref[i]+((long) prices[i] * strategy[i]);
        }

        int half = k/2;
        long ans = strPref[len];
        for(int i = 0;i <= len-k;i++){
            long left = strPref[len] - (strPref[i+k] - strPref[i]);
            long add = pref[i+k] - pref[i+half];
            ans = Math.max(ans, left + add);
        }
        
        return ans;
    }
}
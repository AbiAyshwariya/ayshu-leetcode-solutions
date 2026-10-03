class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        
        int[] dp = new int[n];
        int maxLength = 0;
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                // Case 1: s[i-1] is '(' -> pattern looks like "..." + "()"
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } 
                // Case 2: s[i-1] is ')' -> pattern looks like "..." + "))"
                else {
                    int prev = i - dp[i - 1] - 1;
                    if (prev >= 0 && s.charAt(prev) == '(') {
                        dp[i] = dp[i - 1] + 2 + (prev >= 1 ? dp[prev - 1] : 0);
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        
        return maxLength;
    }
}
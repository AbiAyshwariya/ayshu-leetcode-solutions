class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0; // Minimum possible open parentheses count
        int cmax = 0; // Maximum possible open parentheses count
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmin = Math.max(0, cmin - 1);
                cmax--;
            } else { // c == '*'
                cmin = Math.max(0, cmin - 1); // Treat '*' as ')'
                cmax++;                        // Treat '*' as '('
            }
            
            if (cmax < 0) {
                return false; // More ')' than '(' and '*' combined
            }
        }
        
        return cmin == 0;
    }
}
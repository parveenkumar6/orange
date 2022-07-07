package DPBottomup;

public class LongestPalindromeSubStr {
    public String longestPalindrome2(String s){
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
    public String longestPalindrome(String s) {
        int startIndexOutput = 0;
        int maxLengthOutput = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //Condition#1
                    if (j - i == 1) dp[i][j] = true;
                    //Condition#1
                    if (dp[i + 1][j - 1]) dp[i][j] = true;
                }
                //Getting Indexes for Substring
                if (dp[i][j] && j - i + 1 > maxLengthOutput) {
                    maxLengthOutput = j - i + 1;
                    startIndexOutput = i;
                }
            }
        }
        return s.substring(startIndexOutput, startIndexOutput + maxLengthOutput);
    }

    public static void main(String[] args) {
        String s = "abccba";
        String ans = new LongestPalindromeSubStr().longestPalindrome2(s);
        System.out.println(ans);
    }
}

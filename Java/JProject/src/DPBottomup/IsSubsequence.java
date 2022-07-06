package DPBottomup;

public class IsSubsequence {

    /**
     * source = "abc"
     * target = "ahbgdc"
     * <p>
     * Checking if source is there in target sequence.
     * source = |a|_|b|__|c|
     * target = |a|h|b|gd|c|
     * 'a' is found at 0 position,
     * 'b' is found at 2 position,
     * 'c' is found at 5 position.
     * <p>
     * i = row index
     * j = column index
     * <p>
     * dp = dp two-d array
     * number of rows in dp = length of source string + 1
     * number of columns in dp = length of target string  + 1
     * <p>
     * i = row index
     * j = column index
     */

    private boolean isSubsequence(String source, String target) {
        //i = row, j = column
        if (source.length() == 0) return true;
        int[][] dp = new int[source.length() + 1][target.length() + 1];
        for (int j = 1; j < target.length() + 1; j++) {
            for(int i = 1; i < source.length() + 1; i++){
                if(source.charAt(i-1) == target.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
            if(dp[source.length()][j] == source.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String source = "abc", target = "ahbgdc";
        boolean ans = new IsSubsequence().isSubsequence(source, target);
        System.out.println(ans);
    }
}

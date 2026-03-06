package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean solve(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> dict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        String s = "pineapplepenapple";

        System.out.println("String: " + s);
        System.out.println("Dict: " + dict);
        System.out.println("Can segmented: " + wb.solve(s, dict));
    }
}

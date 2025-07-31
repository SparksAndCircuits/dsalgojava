public class HouseRobber {
    public int maxMoneyTopDown(int[] HouseNetWorth) {
        int dp[] = new int[HouseNetWorth.length];
        return maxMoneyTopDown(dp, HouseNetWorth, 0);
    }

    private int maxMoneyTopDown(int[] dp, int[] HouseNetWorth, int currentIndex) {
        if (currentIndex >= HouseNetWorth.length) {
            return 0;
        }

        if (dp[currentIndex] == 0) {
            int stealCurrent = HouseNetWorth[currentIndex] + maxMoneyTopDown(dp, HouseNetWorth, currentIndex + 2);
            int skippCurrent = maxMoneyTopDown(dp, HouseNetWorth, currentIndex + 1);
            dp[currentIndex] = Math.max(stealCurrent, skippCurrent);
        }

        return dp[currentIndex];
    }

    public int maxMoneyBottomUp(int[] wealth) {
        int dp[] = new int[wealth.length + 2];
        dp[wealth.length] = 0;

        for (int i = wealth.length - 1; i >= 0; i--) {
            dp[i] = Math.max(wealth[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[2];
    }
}

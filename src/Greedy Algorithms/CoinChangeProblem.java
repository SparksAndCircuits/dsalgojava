import java.util.Arrays;

public class CoinChangeProblem {
    static void CoinChangeProblem(int[] coins, int N) {
        Arrays.sort(coins);
        int index = coins.length - 1;

        while (true) {
            int coinValue = coins[index];
            int maxAmount = (N / coinValue) * coinValue;
            index--;

            if (maxAmount > 0) {
                System.out.println("Coin Value" + coinValue + " taken count" + (N / coinValue));
                N = N - maxAmount;
            }

            if (N == 0) {
                break;
            }
        }
    }
}

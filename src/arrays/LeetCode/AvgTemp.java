import java.util.*;

public class AvgTemp {
    public static void main(String[] args) {
        try (Scanner console = new Scanner(System.in)) {
            System.out.println("How many day's of temperature do you want?");
            int numDays = console.nextInt();
            int[] temps = new int[numDays];
            int sum = 0;

            for (int i = 1; i <= numDays; i++) {
                System.out.println("Day " + i + "'s high temperature!");
                int next = console.nextInt();
                sum += next;
            }

            double average = sum / numDays;
            System.out.println();
            System.out.println("The average temperature is: " + average);

            for (int i = 0; i < temps.length; i++) {
                if (temps[i] > average) {
                }
            }
        }
    }
}

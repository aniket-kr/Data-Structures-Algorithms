package algorithmic_toolbox.week3;

import java.util.Arrays;
import java.util.Scanner;

public class MaxAdvertRevenue {

  public static long getMaxRevenue(int[] profits, int[] clicks) {
    Arrays.sort(profits);
    Arrays.sort(clicks);

    long total = 0;
    for (int i = 0; i < profits.length; i++) {
      total += profits[i] * clicks[i]; 
    }
    return total;
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    int[] profits = new int[N];
    int[] clicks = new int[N];

    for (int i = 0; i < N; i++) {
      profits[i] = scanner.nextInt();
    }
    for (int i = 0; i < N; i++) {
      clicks[i] = scanner.nextInt();
    }
    scanner.close();

    System.out.println(getMaxRevenue(profits, clicks));
  }
}

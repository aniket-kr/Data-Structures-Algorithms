package algorithmic_toolbox.week3;

import java.util.Scanner;

public class MaxPrizes {

  public static int closestSum(int k) {
    return (int) ((Math.sqrt(8L * k + 1) - 1) / 2);
  }

  public static long sumTill(int n) {
    return (n * (n + 1L)) / 2;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();

    int k = closestSum(n);

    System.out.println(k);
    for (int i = 1; i < k; i++) {
      System.out.printf("%d ", i);
    }
    System.out.println(k + n - sumTill(k));
  }
}

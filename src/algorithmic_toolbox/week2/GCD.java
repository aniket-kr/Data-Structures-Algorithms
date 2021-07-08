package algorithmic_toolbox.week2;

import java.util.Scanner;

public class GCD {

  /**
   * Computes the GCD of two integers a and b.
   * 
   * @param a first integer. Must be greater or equal to b.
   * @param b second integer. Must be smaller or equal to a.
   * @return HCF or GCD of a and b
   */
  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public static int getGcd(int a, int b) {
    return (a > b) ? gcd(a, b) : gcd(b, a);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    scanner.close();

    System.out.println(getGcd(a, b));
  }
}

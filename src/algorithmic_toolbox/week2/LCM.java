package algorithmic_toolbox.week2;

import java.util.Scanner;


public class LCM {

  public static int getGcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return getGcd(b, a % b);
  }

  public static long getLcm(int a, int b) {
    long hcf = (a > b) ? getGcd(a, b) : getGcd(b, a);

    return (a / hcf) * (b / hcf);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    scanner.close();

    System.out.println(getLcm(a, b));
  }
}
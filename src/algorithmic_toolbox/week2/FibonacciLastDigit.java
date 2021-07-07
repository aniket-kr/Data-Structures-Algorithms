package algorithmic_toolbox.week2;

import java.util.Scanner;

public class FibonacciLastDigit {
  
  private static int getFibonacciLastDigit(int n) {
    if (n < 2) {
      return n;
    }

    int previous = 0;
    int current = 1;

    int nextTerm;
    for (int i = 1; i < n; i++) {
      nextTerm = (previous + current) % 10;
      previous = current;
      current = nextTerm;
    }

    return current;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();

    int c = getFibonacciLastDigit(n);
    System.out.println(c);
  }
}

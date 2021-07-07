package algorithmic_toolbox.week2;

import java.util.Scanner;


public class Fibonacci {

  private static long calcFib(int n) {
    if (n < 2) {
      return n;
    }

    long[] terms = { 0, 1 };
    long newTerm;
    for (int i = 1; i < n; i++) {
      newTerm = terms[0] + terms[1];
      terms[0] = terms[1];
      terms[1] = newTerm;
    }
    return terms[1];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();

    System.out.println(calcFib(n));
  }
}
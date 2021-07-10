package algorithmic_toolbox.week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class NumberPiece implements Comparable<NumberPiece> {
  private final String numStr;

  public NumberPiece(String s) {
    this.numStr = s;
  }

  public NumberPiece(int num) {
    this(Integer.toString(num));
  }

  @Override
  public int compareTo(NumberPiece o) {
    int cmpLen = Integer.max(numStr.length(), o.numStr.length());

    char thisChar, otherChar;
    int cmp;
    for (int i = 0; i < cmpLen; i++) {
      thisChar = i < numStr.length() ? numStr.charAt(i) : '9';
      otherChar = i < o.numStr.length() ? o.numStr.charAt(i) : '9';

      cmp = Character.compare(thisChar, otherChar);
      if (cmp != 0) {
        return cmp;
      }
    }

    return 0;
  }

  @Override
  public String toString() {
      return numStr;
  }
}

public class MaxSalary {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    NumberPiece[] pieces = new NumberPiece[N];

    for (int i = 0; i < N; i++) {
      pieces[i] = new NumberPiece(scanner.nextInt());
    }
    scanner.close();

    // problem logic
    Arrays.sort(pieces, Comparator.reverseOrder());

    for (NumberPiece p : pieces) {
      System.out.print(p);
    }
    System.out.println();
  }
}

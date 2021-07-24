package algorithmic_toolbox.week5;

import java.util.Scanner;

public class EditDistance {
  
  public static int getEditDist(String from, String to) {
    int[][] table = new int[to.length() + 1][from.length() + 1];
    
    // fill in base cases
    for (int i = 0; i <= to.length(); i++) { table[i][0] = i; }
    for (int i = 0; i <= from.length(); i++) { table[0][i] = i; }

    // fill the table up
    int minDist;
    for (int r = 1; r <= to.length(); r++) {
      for (int c = 1; c <= from.length(); c++) {
        minDist = Integer.min(
          Integer.min(table[r][c - 1], table[r - 1][c - 1]),
          table[r - 1][c]
        );

        table[r][c] = to.charAt(r - 1) == from.charAt(c - 1) ? minDist : minDist + 1;
      }
    }

    return table[to.length()][from.length()];
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String from = scanner.nextLine();
    String to = scanner.nextLine();
    scanner.close();

    System.out.println(getEditDist(from, to));
  }
}

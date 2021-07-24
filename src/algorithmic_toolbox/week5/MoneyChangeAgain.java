package algorithmic_toolbox.week5;

import java.util.Arrays;
import java.util.Scanner;

public class MoneyChangeAgain {

  public static int change(int target, int[] coins) {
    int[] table = new int[target + 1];
    Arrays.fill(table, -1);
    table[0] = 0;

    int res, potential_count;
    for (int i = 0; i <= target; i++) {
      if (table[i] != -1) {
        for (int coin : coins) {
          res = i + coin;
          potential_count = table[i] + 1;
          if (res <= target) {
            if      (table[res] == -1) { table[res] = potential_count; }
            else if (table[res] > potential_count) { table[res] = potential_count; }
          }
        }
      }
    }

    return table[target];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int target = scanner.nextInt();
    scanner.close();

    int[] coins = { 1, 3, 4 };
    System.out.println(change(target, coins));
  }
}

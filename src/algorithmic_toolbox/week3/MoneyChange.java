package algorithmic_toolbox.week3;

import java.util.Scanner;

public class MoneyChange {
  public static final int[] DENOMINATIONS = {10, 5, 1};
  
  public static int countCoins(int money, int[] denominations) {
    int totalCoins = 0;
    for (int coinValue : denominations) {
      if (money == 0) { break; }
      
      totalCoins += money / coinValue;
      money = money % coinValue;
    }
    return totalCoins;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int money = scanner.nextInt();
    scanner.close();

    System.out.println(countCoins(money, DENOMINATIONS));
  }
}

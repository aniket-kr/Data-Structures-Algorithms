package algorithmic_toolbox.week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Loot {
  private int value;
  private int mass;

  public static final Comparator<Loot> BY_UNIT_VALUE = (
    Comparator.comparingDouble((Loot loot) -> loot.calcValue(1))
  );

  public Loot(int value, int mass) {
    this.value = value;
    this.mass = mass;
  }

  public int getMass() {
    return mass;
  }

  public int getValue() {
    return value;
  }

  public double calcValue(int mass) {
    return (double) value / this.mass * mass;
  }
}

public class MaxLoot {

  public static double maxValue(Loot[] items, int capacity) {
    double totalValue = 0;
    for (Loot loot : items) {
      if (capacity >= loot.getMass()) {
        totalValue += loot.getValue();
        capacity -= loot.getMass();
      } else {
        totalValue += loot.calcValue(capacity);
        capacity = 0;
        break;
      }
    }

    return totalValue;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numItems = scanner.nextInt();
    int capacity = scanner.nextInt();

    Loot[] items = new Loot[numItems];
    for (int i = 0; i < numItems; i++) {
      items[i] = new Loot(scanner.nextInt(), scanner.nextInt());
    }
    scanner.close();

    Arrays.sort(items, Loot.BY_UNIT_VALUE.reversed());
    double maxValue = maxValue(items, capacity);
    System.out.printf("%.4f\n", maxValue);
  }
}

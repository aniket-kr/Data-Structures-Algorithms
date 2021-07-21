
package algorithmic_toolbox.week4;

import java.util.Random;
import java.util.Scanner;

public class Quick3Way {

  public static void quicksort(int[] arr) {
    shuffle(arr);
    quicksort(arr, 0, arr.length - 1);
  }

  private static void quicksort(int[] arr, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    // partitioning - 3Way
    int lt = lo, gt = hi;
    int pivot = arr[lo];
    int cmp;
    for (int i = lo + 1; i <= gt;) {
      cmp = Integer.compare(arr[i], pivot);
      if      (cmp < 0) { swap(arr, lt++, i++); }
      else if (cmp > 0) { swap(arr, i, gt--); }
      else              { i++; }
    }

    quicksort(arr, lo, lt - 1);
    quicksort(arr, gt + 1, hi);
  }

  private static void shuffle(int[] arr) {
    Random rnd = new Random();
    int randIndex;
    for (int i = 0; i < arr.length; i++) {
      randIndex = i + rnd.nextInt(arr.length - i);
      swap(arr, i, randIndex);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();

    int[] nums = new int[size];
    for (int i = 0; i < size; i++) {
      nums[i] = scanner.nextInt();
    }
    scanner.close();

    quicksort(nums);

    for (int elmt : nums) {
      System.out.printf("%d ", elmt);
    }
    System.out.println();
  }
}

package algorithmic_toolbox.week4;

import java.util.Scanner;

public class Majority {

  private static int findMajority(int[] arr, int lo, int hi) {
    if (hi <= lo) {
      return arr[lo];
    }

    int mid = lo + (hi - lo) / 2;
    int maj1 = findMajority(arr, lo, mid);
    int maj2 = findMajority(arr, mid + 1, hi);

    return merge(arr, maj1, maj2, lo, hi);
  }

  private static int merge(int[] arr, int m1, int m2, int lo, int hi) {
    int m1Count = 0, m2Count = 0;
    int majCount = (hi - lo + 1) / 2 + 1;

    for (int i = lo; i <= hi; i++) {
      if      (arr[i] == m1) { m1Count++; }
      else if (arr[i] == m2) { m2Count++; }
    }

    if (m1Count >= majCount) {
      return m1;
    } else if (m2Count >= majCount) {
      return m2;
    } else {
      return -1;
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();

    int[] nums = new int[size];
    for (int i = 0; i < size; i++) {
      nums[i] = scanner.nextInt();
    }
    scanner.close();

    int maj = findMajority(nums, 0, nums.length - 1);
    System.out.println((maj == -1) ? 0 : 1);
  }
  
}
package algorithmic_toolbox.week4;

import java.util.Scanner;

public class BinarySearch {

  private static int bSearch(int[] arr, int elmt) {
    int lo = 0;
    int hi = arr.length - 1;

    int mid;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;

      if (arr[mid] > elmt) {
        hi = mid - 1;
      } else if (arr[mid] < elmt) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
      return -1;
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    // create and populate sorted array
    int n = scanner.nextInt();
    int[] sortedArr = new int[n];
    for (int i = 0; i < n; i++) {
      sortedArr[i] = scanner.nextInt();
    }

    int cases = scanner.nextInt();
    for (int i = 0; i < cases; i++) {
      System.out.printf("%d ", bSearch(sortedArr, scanner.nextInt()));
    }
    System.out.println();
    scanner.close();
   }
}

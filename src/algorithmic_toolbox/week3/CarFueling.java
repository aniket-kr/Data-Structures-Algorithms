package algorithmic_toolbox.week3;

import java.util.Scanner;

public class CarFueling {
  
  public static int floor(int[] stops, int val) {
    int start = 0;
    int end = stops.length - 1;

    int mid;
    while (start <= end) {
      mid = (start + end) / 2;
      if (stops[mid] < val)      { start = mid + 1; }
      else if (stops[mid] > val) { end = mid - 1; }
      else                       { return stops[mid]; }
    }

    mid = (start + end) / 2;
    return (stops[mid] < val) ? stops[mid] : stops[mid - 1];
  }

  public static int count_stops(int[] stops, int range) {
    int pos = 0;
    int stopsCounter = 0;

    int reach, newPos;
    while (true) {
      reach = pos + range;
      newPos = floor(stops, reach);
      
      if (newPos == pos) {
        return -1;  // impossible
      }
      pos = newPos;

      if (pos >= stops[stops.length - 1]) {
        break;
      }
      stopsCounter++;
    }

    return stopsCounter;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int dest = scanner.nextInt();
    int range = scanner.nextInt();
    int stopsCount = scanner.nextInt();
    
    int[] stops = new int[stopsCount + 2];
    for (int i = 1; i < stopsCount + 1; i++) {
      stops[i] = scanner.nextInt();
    }
    scanner.close();

    // prepare the 'stops' array
    stops[0] = 0;  // initial pos
    stops[stopsCount + 1] = dest;  // final destination

    System.out.println(count_stops(stops, range));
  }
}

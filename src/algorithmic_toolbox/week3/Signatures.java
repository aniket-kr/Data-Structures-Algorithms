package algorithmic_toolbox.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Line {

  private int left;
  private int right;

  public static Comparator<Line> ORDER_BY_LEFT = Comparator.comparingInt((Line line) -> line.left);

  public Line(int left, int right) {
    this.left = left;
    this.right = right;
  }

  public int getLeft() {
    return left;
  }

  public int getRight() {
    return right;
  }

  @Override
  public String toString() {
    return String.format("Line(%d, %d)", left, right);
  }
}

public class Signatures {

  public static List<Integer> findPoints(Line[] lines) {
    List<Integer> points = new ArrayList<>();

    int max_right = -1;
    for (Line line : lines) {

      if (max_right >= 0 && max_right < line.getLeft()) {
        points.add(max_right);
        max_right = -1;
      }

      if (max_right < 0 || line.getRight() < max_right) {
        max_right = line.getRight();
      }
    }
    points.add(max_right);
    return points;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    Line[] lines = new Line[N];
    for (int i = 0; i < N; i++) {
      lines[i] = new Line(scanner.nextInt(), scanner.nextInt());
    }
    scanner.close();

    // sort according to start of line
    Arrays.sort(lines, Line.ORDER_BY_LEFT);

    List<Integer> points = findPoints(lines);
    System.out.println(points.size());
    for (Integer point : points) {
      System.out.printf("%s ", point.toString());
    }
    System.out.println();
  }
}

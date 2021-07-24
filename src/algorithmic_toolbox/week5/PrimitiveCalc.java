package algorithmic_toolbox.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;


public class PrimitiveCalc {
  
  @SuppressWarnings("unchecked")
  public static List<IntUnaryOperator> bestOpers(int target, IntUnaryOperator[] opers) {
    List<IntUnaryOperator>[] table = (List<IntUnaryOperator>[]) (new List[target + 1]);
    table[1] = new ArrayList<IntUnaryOperator>();

    int res;
    List<IntUnaryOperator> potentialOpers;
    for (int i = 0; i <= target; i++) {
      if (table[i] != null) {
        for (IntUnaryOperator oper : opers) {
          res = oper.applyAsInt(i);
          potentialOpers = new ArrayList<>(table[i]);
          potentialOpers.add(oper);

          if (res <= target && (table[res] == null || table[res].size() > potentialOpers.size())) {
            table[res] = potentialOpers;
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

    IntUnaryOperator[] opers = {
      (int x) -> x + 1,
      (int x) -> x * 2,
      (int x) -> x * 3
    };

    List<IntUnaryOperator> opersList = bestOpers(target, opers);

    System.out.println(opersList.size());
    
    int result = 1;
    for (IntUnaryOperator oper : opersList) {
      System.out.printf("%d ", result);
      result = oper.applyAsInt(result);
    }
    System.out.println(result);
  }
}

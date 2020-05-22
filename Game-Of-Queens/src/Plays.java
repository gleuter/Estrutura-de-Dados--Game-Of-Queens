import java.util.LinkedList;

public class Plays {
  public boolean processAttacks(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
    int line, columms;

    for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {

      line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
      columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
      System.out.println("Next move for right: ");

      for (int countRight = columms; countRight < 8; countRight++) {
        columms = columms + 1;
        System.out.println("Line" + line + "Columns" + columms);
        if (borad[line][columms] == 1) {
          return true;
        }
      }
    }
    
    return false;
  }
}

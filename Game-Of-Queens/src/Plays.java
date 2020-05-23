import java.util.LinkedList;

public class Plays {

	public boolean processAttacksRight(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line = 0, columns =0,lineManipulated =0,columsManipulated =0;

		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columns = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			 lineManipulated = line;
			 columsManipulated = columns;
			System.out.println("Next move for right: >>>>>>");

			for (int countRight = columsManipulated; countRight < 7; countRight++) {
				columsManipulated = (columsManipulated + 1);
				System.out.println("Line : " + line + " Columns : " + columsManipulated);
				if (borad[lineManipulated][columsManipulated] == 1) {
					System.out.println("You lLose !");
					return true;
				}
			}
			
		}
			return false;
	}

	public boolean processAttacksLeft(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms;

		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			System.out.println("<<<<< Next move for Left:");
			for (int countleft = columms; countleft >0; countleft--) {
				columms = (columms - 1);
				System.out.println("Line: " + line + " Columns :" + columms);
				if (borad[line][columms] == 1) {
					System.out.println("You Lose !");
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	public boolean processAttacksUp(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms, lineMan;

		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			System.out.println("^^^^^^ Next move Up : ");
			lineMan = line;
			
			for (int countUp = line; countUp > 0; countUp--) {
				lineMan = lineMan - 1;
				System.out.println("Line: " + lineMan + " Columns :" + columms);
				if (borad[lineMan][columms] == 1) {
					System.out.println("You Lose !");
					return true;
				}
			}
		}
		return false;
	}

	
	public boolean processAttacksDown(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms, lineMan;

		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			System.out.println("vvvvv Next move Down : ");
			lineMan = line;
			
			for (int countUp = line; countUp < 7; countUp++) {
				lineMan = lineMan  + 1;
				System.out.println("Line: " + lineMan + " Columns :" + columms);
				if (borad[lineMan][columms] == 1) {
					System.out.println("You Lose !");
					return true;
				}
			}
		}
		return false;
	}

	
	
	
	
	
}

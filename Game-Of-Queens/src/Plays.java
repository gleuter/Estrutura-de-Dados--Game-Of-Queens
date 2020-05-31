
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Plays {

	Map<Integer, List<Queens>> linkedListAttackForQueens;

	public boolean processAttacksRight(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line = 0, columns = 0, lineManipulated = 0, columsManipulated = 0;

		linkedListAttackForQueens = new HashMap<>();

		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			 
			if(linkedListAttackForQueens.get(listCounter + 1).size()>0)
			linkedListAttackForQueens.put(listCounter + 1, new LinkedList());

			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columns = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();

			lineManipulated = line;
			columsManipulated = columns;
			System.out.println("Next move for right: >>>>>>");

			for (int countRight = columsManipulated; countRight < 7; countRight++) {

				columsManipulated = (columsManipulated + 1);
				linkedListAttackForQueens.get(listCounter + 1).add(new Queens(lineManipulated, columsManipulated));

				System.out.println("Line : " + line + " Columns : " + columsManipulated);
				if (borad[lineManipulated][columsManipulated] == 1) {
					System.out.println("You lLose !");
					return true;
				}
			}
			System.out.println(linkedListAttackForQueens);
		}
		return false;
	}

	public boolean processAttacksLeft(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms;
		linkedListAttackForQueens = new HashMap<>();

		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			linkedListAttackForQueens.put(listCounter + 1, new LinkedList());

			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			System.out.println("<<<<< Next move for Left:");
			for (int countleft = columms; countleft > 0; countleft--) {
				columms = (columms - 1);
				linkedListAttackForQueens.get(listCounter + 1).add(new Queens(line, columms));
				System.out.println("Line: " + line + " Columns :" + columms);
				if (borad[line][columms] == 1) {
					System.out.println("You Lose !");
					return true;
				}
			}
			System.out.println(linkedListAttackForQueens);
		}
		return false;
	}

	public boolean processAttacksUp(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms, lineMan;
		linkedListAttackForQueens = new HashMap<>();

		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			linkedListAttackForQueens.put(listCounter + 1, new LinkedList());

			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			System.out.println("^^^^^^ Next move Up : ");
			lineMan = line;

			for (int countUp = line; countUp > 0; countUp--) {
				lineMan = lineMan - 1;
				System.out.println("Line: " + lineMan + " Columns :" + columms);
				linkedListAttackForQueens.get(listCounter + 1).add(new Queens(lineMan, columms));
				if (borad[lineMan][columms] == 1) {
					System.out.println("You Lose !");
					return true;
				}
			}
			System.out.println(linkedListAttackForQueens);
		}
		return false;
	}

	public boolean processAttacksDown(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms, lineMan;
		linkedListAttackForQueens = new HashMap<>();

		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			linkedListAttackForQueens.put(listCounter + 1, new LinkedList<>());
			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			System.out.println("vvvvv Next move Down : ");
			lineMan = line;

			for (int countUp = line; countUp < 7; countUp++) {
				lineMan = lineMan + 1;
				System.out.println("Line: " + lineMan + " Columns :" + columms);
				linkedListAttackForQueens.get(listCounter + 1).add(new Queens(lineMan, columms));
				if (borad[lineMan][columms] == 1) {
					System.out.println("You Lose !");
					return true;
				}
			}
			System.out.println(linkedListAttackForQueens);	
		}
		return false;
	}

	public boolean processAttacksTopRightDiagonal(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms, lineMan = 0, columnM = 0;
		linkedListAttackForQueens = new HashMap<>();
				
		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			linkedListAttackForQueens.put(listCounter + 1, new LinkedList<>());
			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			columnM = columms;
			lineMan = line;
			while (true) {
				lineMan = lineMan - 1;
				columnM = columnM + 1;
				if (lineMan < 0 || columnM > 7) {
					break;
				}
				linkedListAttackForQueens.get(listCounter + 1).add(new Queens(lineMan, columnM));
				System.out.println("Top right diagonal / " + " Line: " + lineMan + " Columns :" + columnM);
				if (borad[lineMan][columms] == 1) {
					System.out.println("You Lose !");
					return true;
				}
			}
			System.out.println(linkedListAttackForQueens);	
		}
		return false;
	}

	public boolean processAttacksTopLeftDiagonal(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms, lineMan = 0, columnM = 0;
		linkedListAttackForQueens = new HashMap<>();
		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			linkedListAttackForQueens.put(listCounter + 1, new LinkedList<>());
			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			columnM = columms;
			lineMan = line;
			while (true) {
				lineMan = lineMan - 1;
				columnM = columnM - 1;
				if (lineMan < 0 || columnM > 7) {
					break;
				}
				linkedListAttackForQueens.get(listCounter + 1).add(new Queens(lineMan, columnM));
				System.out.println("Top left diagonal  \\ \\ \\ " + " Line: " + lineMan + " Columns :" + columnM);
				if (borad[lineMan][columms] == 1) {
					System.out.println("You Lose !");
					return true;
				}
			}
			System.out.println(linkedListAttackForQueens);	
		}
		return false;
	}

	public boolean processAttacksDownLeftDiagonal(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms, lineMan = 0, columnM = 0;
		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			linkedListAttackForQueens.put(listCounter + 1, new LinkedList<>());
			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			lineMan = line;
			columnM = columms;
			while (true) {
				lineMan = lineMan + 1;
				columnM = columnM - 1;
				if (lineMan > 7 || columnM < 0) {
					break;
				}
				linkedListAttackForQueens.get(listCounter + 1).add(new Queens(lineMan, columnM));
				System.out.println(
						"Process Attacks Down Left Diagonal  / " + " Line: " + lineMan + " Columns :" + columnM);
				if (borad[lineMan][columms] == 1) {
					System.out.println("You Lose !");
					return true;
				}
			}
			System.out.println(linkedListAttackForQueens);	
		}
		return false;
	}

	public boolean processAttacksDownRigthDiagonal(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms, lineMan = 0, columnM = 0;
		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			linkedListAttackForQueens.put(listCounter + 1, new LinkedList<>());
			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();
			lineMan = line;
			columnM = columms;
			while (true) {
				lineMan = lineMan + 1;
				columnM = columnM + 1;
				if (lineMan > 7 || columnM > 7) {
					break;
				}
				linkedListAttackForQueens.get(listCounter + 1).add(new Queens(lineMan, columnM));
				System.out.println("Attacks Down Rigth Diagonal \\" + " Line: " + lineMan + " Columns :" + columnM);
				if (borad[lineMan][columms] == 1) {
					System.out.println("You Lose !");
					return true;
				}
			}
			System.out.println(linkedListAttackForQueens);	
		}
		return false;
	}
}

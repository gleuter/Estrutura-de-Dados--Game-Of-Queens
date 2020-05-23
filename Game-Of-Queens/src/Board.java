import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;



public class Board {
	Plays plays = new Plays();
	
	/**
	 * Create a board filled with zero
	 *
	 * @param board
	 */
	public Board createBoardEmpty(int board[][]) {
		for (int line = 0; line < board.length; line++) {
			for (int column = 0; column < board[0].length; column++) {
				board[line][column] = 0;
				System.out.print(board[line][column] + "\t");
			} // finish for column
			System.out.println();
		} // finish for line
		return this;
	}

	public Board createBoardEmpty(int board[][], int lineInput, int columnInput) {
		for (int line = 0; line < board.length; line++) {
			for (int column = 0; column < board[0].length; column++) {
				board[line][column] = 0;
				board[lineInput][columnInput] = 1;
				System.out.print(board[line][column] + "\t");
			} // finish for column
			System.out.println();
		} // finish for line
		return this;
	}

	/**
	 * Receives a matrix and dynamically returns and inserts a play
	 *
	 * @param board          matrix
	 * @param repeatQuantity Number of interactions
	 * @return new matrix with random numbers
	 */
	public int[][] insertRandomPosition(int board[][], int repeatQuantity) {
		int[][] boardRandom = new int[0][];
		for (int i = 0; i < repeatQuantity; i++) {
			boardRandom = insertRandom(board);
			System.out.println("--------------" + i + "---------------");
			printBoard(boardRandom);
			System.out.println("-----------------------------");
		}
		return boardRandom;
	}

	public int[][] insertRandomPosition(int board[][]) {
		int[][] boardRandom = insertRandom(board);
		System.out.println("------------------------------------");
		printBoard(board);
		return boardRandom;
	}

	private Board printBoard(int[][] board) {
		for (int line = 0; line < board.length; line++) {
			for (int column = 0; column < board[0].length; column++) {
				System.out.print(board[line][column] + "\t");
			} // finish for column
			System.out.println();
		} // finish for line
		return this;
	}

	private int[][] insertRandom(int[][] board) {
		Random numberRamdom = new Random();
		board[numberRamdom.nextInt(board.length)][numberRamdom.nextInt(board.length)] = 1;
		return board;
	}

	public int systemIO(String lineOrColums) {
		Scanner read = new Scanner(System.in);
		int lineInputUser = 0, columnInputUser = 0;
		if (lineOrColums.contains("line")) {
			System.out.println("Enter the line: ");
			return lineInputUser = read.nextInt();
		} else {
			System.out.println("Enter the Column : ");
			columnInputUser = read.nextInt();
			return columnInputUser;
		}

	}

	private LinkedList<Queens> listMovements(int line, int colums) {
		LinkedList<Queens> listOfQueensPositioned = new LinkedList<Queens>();
		Queens queens = new Queens(line, colums);
		listOfQueensPositioned.add(queens);
		return listOfQueensPositioned;
	}

	public int[][] insertUserCordenada(int[][] board, int line, int colum) {
		board[line][colum] = 1;
		printBoard(board);
		return board;
	}

	public Board initGame(int[][] board, int numberOfRepetitions) {
		for (int i = 0; i < numberOfRepetitions; i++) {
			if (i > 0) {

			}
			System.out.println("Number play : " + (i + 1));
			int line = systemIO("line");
			int colums = systemIO("colums");
			System.out.println("Queens: " + (i + 1));
		//	System.out.println("Location :" + "[" + line + " " + colums + "]");
			
			printQueensList(listMovements(line,colums));
			board[line][colums] = 1;
			printBoard(board);
//			plays.processAttacksRight(listMovements(line,colums),board);
//			plays.processAttacksLeft(listMovements(line,colums),board);
			plays.processAttacksUp(listMovements(line,colums),board);
			plays.processAttacksDown(listMovements(line,colums),board);
		}
		return this;
	}
	
	public static void printQueensList(LinkedList<Queens> lisOfQueensPositionad) {
		for(int positionOfList = 0;positionOfList < lisOfQueensPositionad.size();positionOfList++) {
			System.out.println("Queens List : " + (positionOfList +1));
			System.out.println("Line   : " + (lisOfQueensPositionad.get(positionOfList).getLineQueens()));	
			System.out.println("Colums : " + (lisOfQueensPositionad.get(positionOfList).getColumsQueens()));	
		}
	}
	
	
	

	public boolean processAttacks(LinkedList<Queens> listOfQueensPosisiotioned, int borad[][]) {
		int line, columms;

		for (int listCounter = 0; listCounter < listOfQueensPosisiotioned.size(); listCounter++) {
			line = listOfQueensPosisiotioned.get(listCounter).getLineQueens();
			columms = listOfQueensPosisiotioned.get(listCounter).getColumsQueens();

			System.out.println("Next move for right: " + listCounter);
			for (int countRight = columms; countRight < 8; countRight++) {
				columms += 1;
				System.out.println("Line" + line + "Columns" + columms);
				if (borad[line][columms] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	public void AttackingTheRight() {

	}

	public int[][] validaDiagonal(int[][] board) {
		final int line = systemIO("line");
		final int colums = systemIO("colums");

		board[line][colums] = 1;
		int origemLinha = line;
		int origemColuna = colums;

		for (int i = origemLinha - 1; i >= 1; i--) {
			for (int j = origemColuna - 1; j >= 1; j--) {
				int linhasAbsoluta = Math.abs(origemLinha - i);
				int colunABS = Math.abs(origemColuna - j);
				if (linhasAbsoluta + colunABS == 2) {
					linhasAbsoluta--;
					colunABS--;
					System.out.println("Linha " + i + " Coluna " + j);
				}
			}
		}
		return board;
	}

	public int redutor(int cordenada, String valorRetorno) {
		return valorRetorno.contains("sub") ? cordenada - 1 : cordenada + 1;
	}

}

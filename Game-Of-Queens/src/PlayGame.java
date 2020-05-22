public class PlayGame {
  public static void main(String[] args) {
    Board chessBoard = new Board();
    int[][] board = new int[8][8];
    Plays plays = new Plays();

    chessBoard.createBoardEmpty(board)
    .initGame(board,2);

  }
}
public class PlayGame {
  public static void main(String[] args) {
    Board tabuleiro = new Board();
    int[][] board = new int[8][8];
    Plays plays = new Plays();

    tabuleiro.createBoardEmpty(board).initGame(board).validaDiagonal(board);
     tabuleiro.validaDiagonal(board);

  }
}
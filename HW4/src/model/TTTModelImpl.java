package model;

import java.util.Objects;

/**
 * Concrete implementation of the TTTModel interface.
 */
public class TTTModelImpl implements TTTModel {

  private final Player[][] board;
  private Player currentPlayer;
  private boolean gameOver;
  private Player winner;

  public static final int SIZE = 3; // 3x3 board

  public TTTModelImpl() {
    this.board = new Player[SIZE][SIZE];
    this.currentPlayer = Player.X; // X always starts
    this.gameOver = false;
    this.winner = null;
  }

  @Override
  public void makeMove(int row, int col) {
    checkBounds(row, col);

    if (gameOver) {
      throw new IllegalStateException("Game is already over.");
    }

    if (board[row][col] != null) {
      throw new IllegalArgumentException("Cell is already occupied.");
    }

    board[row][col] = currentPlayer;
    checkWinnerOrDraw();

    if (!gameOver) {
      currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }
  }

  @Override
  public Player getCell(int row, int col) {
    checkBounds(row, col);
    return board[row][col]; // can be null (meaning empty)
  }

  @Override
  public Player getCurrentPlayer() {
    if (gameOver) {
      throw new IllegalStateException("Game is over.");
    }
    return currentPlayer;
  }

  @Override
  public boolean isGameOver() {
    return gameOver;
  }

  @Override
  public Player getWinner() {
    return winner; // can be null if draw or ongoing
  }

  @Override
  public void resetGame() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        board[i][j] = null;
      }
    }
    currentPlayer = Player.X;
    gameOver = false;
    winner = null;
  }

  // --- Private helper methods ---

  private void checkBounds(int row, int col) {
    if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
      throw new IllegalArgumentException("Invalid cell coordinates.");
    }
  }

  private void checkWinnerOrDraw() {
    // Check rows, columns, and diagonals
    for (int i = 0; i < SIZE; i++) {
      // Check row
      if (board[i][0] != null &&
          board[i][0] == board[i][1] &&
          board[i][1] == board[i][2]) {
        declareWinner(board[i][0]);
        return;
      }

      // Check column
      if (board[0][i] != null &&
          board[0][i] == board[1][i] &&
          board[1][i] == board[2][i]) {
        declareWinner(board[0][i]);
        return;
      }
    }

    // Check diagonals
    if (board[0][0] != null &&
        board[0][0] == board[1][1] &&
        board[1][1] == board[2][2]) {
      declareWinner(board[0][0]);
      return;
    }

    if (board[0][2] != null &&
        board[0][2] == board[1][1] &&
        board[1][1] == board[2][0]) {
      declareWinner(board[0][2]);
      return;
    }

    // Check for draw
    boolean boardFull = true;
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (board[i][j] == null) {
          boardFull = false;
          break;
        }
      }
    }

    if (boardFull) {
      gameOver = true;
      winner = null;
    }
  }

  private void declareWinner(Player p) {
    gameOver = true;
    winner = p;
  }
}

public static void main(String[] args) {
  TTTModel game = new TTTModelImpl();
  game.makeMove(0, 0); // X
  game.makeMove(1, 1); // O
  game.makeMove(0, 1); // X
  game.makeMove(2, 2); // O
  game.makeMove(0, 2); // X wins

  System.out.println("Winner: " + game.getWinner()); // Output: X
}

package model;

/**
 * Interface representing the Tic Tac Toe game's back-end logic.
 */
public interface TTTModel {

  /**
   * Makes a move for the current player at the specified row and column.
   *
   * @param row The row index (0-based).
   * @param col The column index (0-based).
   * @throws IllegalArgumentException if the cell is already occupied or if indices are out of bounds.
   * @throws IllegalStateException if the game is already over.
   */
  void makeMove(int row, int col);

  /**
   * Returns the player occupying the given cell.
   *
   * @param row The row index (0-based).
   * @param col The column index (0-based).
   * @return the Player (X or O) at that cell, or null if the cell is empty.
   * @throws IllegalArgumentException if the indices are out of bounds.
   */
  Player getCell(int row, int col);

  /**
   * Returns the player whose turn it is.
   *
   * @return the Player (X or O).
   * @throws IllegalStateException if the game is over.
   */
  Player getCurrentPlayer();

  /**
   * Checks if the game is over due to a win or draw.
   *
   * @return true if the game is over, false otherwise.
   */
  boolean isGameOver();

  /**
   * Returns the winner of the game, if any.
   *
   * @return the winning Player (X or O), or null if it's a draw or the game is not over yet.
   */
  Player getWinner();

  /**
   * Resets the board to start a new game.
   */
  void resetGame();
}

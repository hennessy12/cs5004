package model;

/**
 * Represents the two players in the Tic Tac Toe game.
 * Null is never used as a value—empty cells will be checked using other logic.
 */
public enum Player {
  X,
  O;

  // Design decision:
  // We only allow X and O as valid players.
  // We avoid using null to represent an empty cell to prevent NullPointerExceptions
  // and encourage explicit handling of empty states in the model logic.
}

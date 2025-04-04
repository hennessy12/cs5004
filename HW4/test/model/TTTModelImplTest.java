package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TTTModelImplTest {

  private TTTModel model;

  @BeforeEach
  void setUp() {
    model = new TTTModelImpl();
  }

  @Test
  void testInitialState() {
    assertFalse(model.isGameOver());
    assertEquals(Player.X, model.getCurrentPlayer());
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        assertNull(model.getCell(i, j));
      }
    }
  }

  @Test
  void testMakeValidMoves() {
    model.makeMove(0, 0); // X
    assertEquals(Player.X, model.getCell(0, 0));
    assertEquals(Player.O, model.getCurrentPlayer());

    model.makeMove(1, 1); // O
    assertEquals(Player.O, model.getCell(1, 1));
    assertEquals(Player.X, model.getCurrentPlayer());
  }

  @Test
  void testInvalidMoveOutsideBoard() {
    assertThrows(IllegalArgumentException.class, () -> model.makeMove(-1, 0));
    assertThrows(IllegalArgumentException.class, () -> model.makeMove(3, 3));
  }

  @Test
  void testMoveOnOccupiedCell() {
    model.makeMove(0, 0); // X
    assertThrows(IllegalArgumentException.class, () -> model.makeMove(0, 0)); // Invalid
  }

  @Test
  void testGameWinByRow() {
    model.makeMove(0, 0); // X
    model.makeMove(1, 0); // O
    model.makeMove(0, 1); // X
    model.makeMove(1, 1); // O
    model.makeMove(0, 2); // X wins

    assertTrue(model.isGameOver());
    assertEquals(Player.X, model.getWinner());
  }

  @Test
  void testGameDraw() {
    model.makeMove(0, 0); // X
    model.makeMove(0, 1); // O
    model.makeMove(0, 2); // X
    model.makeMove(1, 1); // O
    model.makeMove(1, 0); // X
    model.makeMove(1, 2); // O
    model.makeMove(2, 1); // X
    model.makeMove(2, 0); // O
    model.makeMove(2, 2); // X

    assertTrue(model.isGameOver());
    assertNull(model.getWinner());
  }

  @Test
  void testGetCellBeforeMove() {
    assertNull(model.getCell(2, 2));
  }

  @Test
  void testGetCellOutOfBounds() {
    assertThrows(IllegalArgumentException.class, () -> model.getCell(5, 5));
  }

  @Test
  void testResetGame() {
    model.makeMove(0, 0);
    model.makeMove(1, 1);
    model.resetGame();

    assertFalse(model.isGameOver());
    assertNull(model.getWinner());
    assertEquals(Player.X, model.getCurrentPlayer());

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        assertNull(model.getCell(i, j));
      }
    }
  }

  @Test
  void testMakeMoveAfterGameOverThrows() {
    // Win in first row
    model.makeMove(0, 0); // X
    model.makeMove(1, 0); // O
    model.makeMove(0, 1); // X
    model.makeMove(1, 1); // O
    model.makeMove(0, 2); // X wins

    assertTrue(model.isGameOver());

    assertThrows(IllegalStateException.class, () -> model.makeMove(2, 2));
  }

  @Test
  void testGetCurrentPlayerAfterGameOverThrows() {
    model.makeMove(0, 0);
    model.makeMove(1, 0);
    model.makeMove(0, 1);
    model.makeMove(1, 1);
    model.makeMove(0, 2); // X wins

    assertThrows(IllegalStateException.class, () -> model.getCurrentPlayer());
  }
}

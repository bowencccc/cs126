package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  @Test
  public void testValidBoardNoWinner() throws Exception{
    TicTacToeBoard board = new TicTacToeBoard(null);
    assertEquals(Evaluation.UnreachableState, board.evaluate());

    TicTacToeBoard board2 = new TicTacToeBoard("OX");
    assertEquals(Evaluation.UnreachableState, board2.evaluate());

    TicTacToeBoard board3 = new TicTacToeBoard("xxxxxxxxxxx");
    assertEquals(Evaluation.UnreachableState, board3.evaluate());

    TicTacToeBoard board4 = new TicTacToeBoard("xxx123456");
    assertEquals(Evaluation.Xwins, board4.evaluate());

    TicTacToeBoard board5 = new TicTacToeBoard("o12o34o56");
    assertEquals(Evaluation.Owins, board5.evaluate());

    TicTacToeBoard board6 = new TicTacToeBoard("werdaasde");
    assertEquals(Evaluation.NoWinner, board6.evaluate());
  }
}

package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  @Test
  public void testValidBoardNoWinner(){
    //check illegal input
    TicTacToeBoard board = new TicTacToeBoard("xx");
    assertEquals(Evaluation.Invalid, board.evaluate());

    TicTacToeBoard il_board = new TicTacToeBoard("xxxxxxxxxxxxx");
    assertEquals(Evaluation.Invalid, il_board.evaluate());

    TicTacToeBoard null_board = new TicTacToeBoard(null);
    assertEquals(Evaluation.Invalid, null_board.evaluate());

    //check unreachable input
    TicTacToeBoard unReachable_board = new TicTacToeBoard("xxxxxxxxx");
    assertEquals(Evaluation.UnreachableState, unReachable_board.evaluate());

    TicTacToeBoard unReachable_board2 = new TicTacToeBoard("xxxxoo123");
    assertEquals(Evaluation.UnreachableState, unReachable_board2.evaluate());

    TicTacToeBoard unReachable_board3 = new TicTacToeBoard("xxxooo123");
    assertEquals(Evaluation.UnreachableState, unReachable_board3.evaluate());

    //check Xwins
    TicTacToeBoard xwin_board = new TicTacToeBoard("xxxoo3456");
    assertEquals(Evaluation.Xwins, xwin_board.evaluate());

    //check Owins
    TicTacToeBoard owin_board = new TicTacToeBoard("oxxox4o56");
    assertEquals(Evaluation.Owins, owin_board.evaluate());

    //check no winner
    TicTacToeBoard nowinner_board = new TicTacToeBoard("werdaasde");
    assertEquals(Evaluation.NoWinner, nowinner_board.evaluate());

    TicTacToeBoard nowinner_board2 = new TicTacToeBoard("Oxoxx.O12");
    assertEquals(Evaluation.NoWinner, nowinner_board2.evaluate());
  }
}

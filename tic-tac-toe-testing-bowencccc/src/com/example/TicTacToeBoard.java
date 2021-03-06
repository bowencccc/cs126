package com.example;

import java.util.Locale;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
  String state;
  Boolean valid;
  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {
    if (board == null || board.length() != 9) {
      valid = false;
      return;
    }
    state = board;
    valid = true;
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    // Return invalid if the board is invalid
    if (!valid) {
      return Evaluation.Invalid;
    }
    // Return unreachablestate if the board is not reachable by applying the helper function
    if (!check_reachable()) {
      return Evaluation.UnreachableState;
    }
    // Evaluate the winner if the state is reachable
    boolean x_win = check_win('x');
    boolean o_win = check_win('o');
    if (x_win) return Evaluation.Xwins;
    if (o_win) return Evaluation.Owins;
    //otherwise return no winner
    return Evaluation.NoWinner;
  }

  /**
   * Check whether the state is reachable
   * @return boolean true if the state is reachable, otherwise false.
   */
  public boolean check_reachable() {
    state = state.toLowerCase();
    int count = 0;
    // count the number of (xs - os)
    for(int i = 0; i < state.length(); i++) {
      if (state.charAt(i) == 'x') {
        count++;
      }
      if (state.charAt(i) == 'o') {
        count--;
      }
    }
    // check that the number of (xs - os) = 1 or number of (xs - os) = 0
    if (count > 1 || count < 0) {
      return false;
    } else {
      if (count == 1) {
        // if the number of (xs - os) = 1, x wins and the state is reachable
        return true;
      } else {
        // otherwise the number of (xs - os) = 0, o wins and the state is reachable
        boolean x_win = check_win('x');
        boolean o_win = check_win('o');
        //check whether o wins -> reachable
        if (o_win) {
          //check whether x also wins -> unreachable
          return !x_win;
        } else {
          // there is no winner, thus reachable
          return true;
        }
      }
    }
  }

  /**
   * check if there exists a winner
   * @param player x or o which we want to check
   * @return whether someone wins or not
   */
  public boolean check_win(char player) {
    state = state.toLowerCase();

    // check horizontal
    for (int i = 0; i < 9; i = i + 3) {
      if (state.charAt(i) != player) continue;
      if (state.charAt(i) == state.charAt(i+1) && state.charAt(i) == state.charAt(i+2)) {
        return true;
      }
    }

    //check vertical
    for (int i = 0; i < 3; i++) {
      if (state.charAt(i) != player) continue;
      if (state.charAt(i) == state.charAt(i+3) && state.charAt(i) == state.charAt(i+6)) {
        return true;
      }
    }

    // check diagonally
    if (state.charAt(4) == player && state.charAt(0) == player && state.charAt(8) == player) {
      return true;
    }
    if (state.charAt(4) == player && state.charAt(2) == player && state.charAt(6) == player) {
      return true;
    }
    return false;
  }
}

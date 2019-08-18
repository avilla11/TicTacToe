// This program sets up a TicTacToe board and allows two people
//  to play the game
// https://en.wikipedia.org/wiki/Tic-tac-toe

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe extends Board {
    public static Scanner in;
    public static String turn;

    public static void main(String[] args) {
        // instantiate a new TicTacToe object to call the start method
        TicTacToe tictac = new TicTacToe();
        tictac.start();
    }

    // need a non-static method to be able to implement the abstract class
    public void start() {
        in = new Scanner(System.in);
        String playAgain = "n";

        do {
            board = new String[3][3];
            turn = "X";
            String winner = null;
            populateEmptyBoard();

            System.out.println("Welcome to Multi-Player Tic-Tac-Toe!!!");
            System.out.println("--------------------------------------");

            super.printBoard();

            System.out.println();
            System.out.println("X plays first. Enter a space number to place X in:");

            // keep looping until a winner is discovered or the game is a draw
            while (winner == null) {
                int numInput;

                try {
                    numInput = in.nextInt();

                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println("Error: Re-enter slot number:");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException: Re-enter slot number:");
                    in.nextLine();
                    continue;
                }

                System.out.println();
                if (board[0][0].equals(String.valueOf(numInput))) {
                    board[0][0] = turn;
                    checkTurn();
                    super.printBoard();
                    winner = checkWinner();
                } else if (board[0][1].equals(String.valueOf(numInput))) {
                    board[0][1] = turn;
                    checkTurn();
                    super.printBoard();
                    winner = checkWinner();
                } else if (board[0][2].equals(String.valueOf(numInput))) {
                    board[0][2] = turn;
                    checkTurn();
                    super.printBoard();
                    winner = checkWinner();
                } else if (board[1][0].equals(String.valueOf(numInput))) {
                    board[1][0] = turn;
                    checkTurn();
                    super.printBoard();
                    winner = checkWinner();
                } else if (board[1][1].equals(String.valueOf(numInput))) {
                    board[1][1] = turn;
                    checkTurn();
                    super.printBoard();
                    winner = checkWinner();
                } else if (board[1][2].equals(String.valueOf(numInput))) {
                    board[1][2] = turn;
                    checkTurn();
                    super.printBoard();
                    winner = checkWinner();
                } else if (board[2][0].equals(String.valueOf(numInput))) {
                    board[2][0] = turn;
                    checkTurn();
                    super.printBoard();
                    winner = checkWinner();
                } else if (board[2][1].equals(String.valueOf(numInput))) {
                    board[2][1] = turn;
                    checkTurn();
                    super.printBoard();
                    winner = checkWinner();
                } else if (board[2][2].equals(String.valueOf(numInput))) {
                    board[2][2] = turn;
                    checkTurn();
                    super.printBoard();
                    winner = checkWinner();
                } else {
                    System.out.println("Slot already taken; re-enter slot number:");
                    continue;
                }
            }

            System.out.println();
            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("It's a draw! Thanks for playing.");
            } else {
                System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
            }

            System.out.println();
            System.out.println("Do you want to do the greatest rematch of all time?");
            playAgain = in.next();
        } while(playAgain.equals("y") || playAgain.equals("Y") || playAgain.equals("Yes") || playAgain.equals("YES") || playAgain.equals("yes"));
    }

    // Change turn to the other player
    public static void checkTurn() {
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
    }

    // determines if there is a winner of the current board
    public static String checkWinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;

            switch (i) {
                case 0:
                    line = board[0][0] + board[0][1] + board[0][2];
                    break;
                case 1:
                    line = board[1][0] + board[1][1] + board[1][2];
                    break;
                case 2:
                    line = board[2][0] + board[2][1] + board[2][2];
                    break;
                case 3:
                    line = board[0][0] + board[1][0] + board[2][0];
                    break;
                case 4:
                    line = board[0][1] + board[1][1] + board[2][1];
                    break;
                case 5:
                    line = board[0][2] + board[1][2] + board[2][2];
                    break;
                case 6:
                    line = board[0][0] + board[1][1] + board[2][2];
                    break;
                case 7:
                    line = board[0][2] + board[1][1] + board[2][0];
                    break;
            }


            // builds a String line representation to see if there is a winner
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        //double check that the board is full and leads to a draw
        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board[0]).contains(String.valueOf(i+1))) {
                break;
            }
            else if (Arrays.asList(board[1]).contains(String.valueOf(i+1))) {
                break;
            }
            else if (Arrays.asList(board[2]).contains(String.valueOf(i+1))) {
                break;
            }
            else if (i == 8) {
                return "draw";
            }
        }

        System.out.println();
        System.out.println(turn + "'s turn; Enter a space number to place " + turn + " in:");
        return null;
    }

    // create the starting game board
    public static void populateEmptyBoard() {
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                board[0][0] = String.valueOf(i + 1);
            } else if (i == 1) {
                board[0][1] = String.valueOf(i + 1);
            } else if (i == 2) {
                board[0][2] = String.valueOf(i + 1);
            } else if (i == 3) {
                board[1][0] = String.valueOf(i + 1);
            } else if (i == 4) {
                board[1][1] = String.valueOf(i + 1);
            } else if (i == 5) {
                board[1][2] = String.valueOf(i + 1);
            } else if (i == 6) {
                board[2][0] = String.valueOf(i + 1);
            } else if (i == 7) {
                board[2][1] = String.valueOf(i + 1);
            } else if (i == 8) {
                board[2][2] = String.valueOf(i + 1);
            }
        }
    }
}

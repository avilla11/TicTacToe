// TicTacToe needs a board to play on
// this is the board for TicTacToe

public abstract class Board {
    // this is the multi-dimensional array to hold the board's move choices
    static String[][] board;

    // prints the game board
    static void printBoard() {
        System.out.println("/---|---|---\\");
        System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
        System.out.println("\\---|---|---/");
    }
}

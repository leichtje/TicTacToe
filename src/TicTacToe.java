import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

//        clearBoard();
//        display(board);

        String player = "X";
        int playerRowMove;
        int playerColMove;
        boolean isValidMove;
        boolean donePlaying;
        boolean playing = false;
        int moveCount;
        do { //Program Loop
            System.out.println("Welcome to the game of Tic Tac Toe X's go first.");
            //Starts game by clearing board and resetting move count
            clearBoard();
            moveCount = 1;
            do {     //Game Loop
//                display(board);
                //Determines player based on turn count
                if (moveCount % 2 != 0) {
                    player = "X";
                } else {
                    player = "O";
                }
                do {       // Player Loop
                    playerRowMove = SafeInputs.getRangedInt(in, "Player: " + player + " What is the row number you want?", 1, 3) - 1;
                    playerColMove = SafeInputs.getRangedInt(in, "Player: " + player + " What is the column number you want?", 1, 3) - 1;
                    isValidMove = isValidMove(playerRowMove, playerColMove);
                    if (!isValidMove) {
                        System.out.println("That space is already taken. Please try again.");
//                        moveCount = moveCount - 1;
                    }
                } while (!isValidMove);
                board[playerRowMove][playerColMove] = player;
                display(board);
                moveCount = moveCount + 1;
                // Check it is a win
                //Only Check if more than four moves
                if (moveCount > 5) {
                    playing = isWin(player);
                    //If not win or tie switch player while  is not updating repeating the loop
//                    if (moveCount > 7) {
//                        playing = isTie(player);
//                    }  Checks for a tie
                    if (moveCount == 10) {  //Determines a tie
                        System.out.println("The board is filled. The game is a tie.");
                        playing = true;
                    }
                }
            } while (!playing);
            if (moveCount != 10) {
                System.out.println("Congratulations! Player: " + player + " wins");
            }
            //Check if they want to play again
            donePlaying = SafeInputs.getYNConfirm(in, "Do you want to play again[Y/N]");
            System.out.println("Switch your markers.");
        } while (!donePlaying);


    }

    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String[][] board = new String[ROW][COL];

    private static void clearBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = " ";
            }
        }
    }
    //{{0,0,0},{0,0,0},{0,0,0}}

    public static void display(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.printf("|%2s", board[row][col]);
            }
            System.out.println("|");
            System.out.println();
        }

    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) {
            return true;
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        //Checks for row win
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                    board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        //Checks for col win
        for (int col = 0; col < COL; col++) {
            if (board[col][0].equals(player) &&
                    board[col][1].equals(player) &&
                    board[col][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        //Checks for Diagonal win
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
            }
            if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) ||
                    board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isTie(String player) {
            for (int row = 0; row < ROW; row++) {
                if (board[row][0].equals("X") &&
                        board[row][1].equals("O") || board[row][0].equals("O") &&
                        board[row][1].equals("X") || board[row][2].equals("O") &&
                        board[row][1].equals("X") || board[row][2].equals("X") &&
                        board[row][1].equals("O")) {
                    return true;
                }
            }
            for (int col = 0; col < COL; col++) {
                if (board[col][0].equals("X") &&
                        board[col][1].equals("O") || board[col][0].equals("O") &&
                        board[col][1].equals("X") || board[col][2].equals("O") &&
                        board[col][1].equals("X") || board[col][2].equals("X") &&
                        board[col][1].equals("O")) {
                    return true;
                }
            }
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL; col++) {
                }
                if (board[0][0].equals("X") && board[1][1].equals("O") ||
                        board[2][0].equals("X") && board[1][1].equals("O") ||
                        board[0][0].equals("O") && board[1][1].equals("X") ||
                        board[2][0].equals("O") && board[1][1].equals("X")) {
                    return true;
                }
            }
            return false;
    }
}


import java.util.Scanner;

public class TicTacToeWithComputer {
    private char[][] board; 
    private char currentPlayer;

    public TicTacToeWithComputer() {
        board = new char[3][3];
        currentPlayer = 'x';
        initializeBoard();
    }
    
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void changePlayer() {
        if (currentPlayer == 'x') {
            currentPlayer = 'o';
        } else {
            currentPlayer = 'x';
        }
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && col >= 0 && row < 3) {
            if (board[row][col] == '-') {
                board[row][col] = currentPlayer;
                return true;
            }
        }

        return false;
    }

    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || checkRowCol(board[0][2], board[1][1], board[2][0]) == true);
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToeWithComputer game = new TicTacToeWithComputer();
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay) {
            System.out.println("Welcome to Tic Tac Toe! You are going to go against the computer. You are player X.");
            game.initializeBoard();
            System.out.println("Here is the current board:");
            game.printBoard();
            while (!game.checkForWin()) {
                if (game.currentPlayer == 'x') {
                    System.out.println("Player " + game.currentPlayer + ", enter an empty row and column to place your mark!");
                    int row = scan.nextInt();
                    int col = scan.nextInt();
                    game.placeMark(row, col);
                    game.changePlayer();
                } else {
                    int row = (int) (Math.random() * 3);
                    int col = (int) (Math.random() * 3);
                    if(game.placeMark(row, col)) {
                        System.out.println("The computer placed a mark in row " + row + ", in column " + col);
                        game.changePlayer();
                    }
                }
                game.printBoard();
            }
            if (game.checkForWin()) {
                System.out.println("Looks like we have a winner! Congrats!");
                System.out.println("Would you like to play again? Enter true for yes and false for no.");
                doYouWantToPlay = scan.nextBoolean();
            }
        }
        scan.close();
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
}

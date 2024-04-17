import java.util.Scanner;

public class TicTacToeWithTwoPlayers {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeWithTwoPlayers() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
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

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWin() {
        char symbol = (currentPlayer == 'X') ? 'O' : 'X';
        return (checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol));
    }

    private boolean checkRows(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2], symbol)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i], symbol)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char symbol) {
        return (checkRowCol(board[0][0], board[1][1], board[2][2], symbol) || checkRowCol(board[0][2], board[1][1], board[2][0], symbol));
    }

    private boolean checkRowCol(char c1, char c2, char c3, char symbol) {
        return ((c1 == symbol) && (c1 == c2) && (c2 == c3));
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }	

    private void placeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            switchPlayer();
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    public static void main(String[] args) {
        TicTacToeWithTwoPlayers game = new TicTacToeWithTwoPlayers();
        Scanner scanner = new Scanner(System.in);
        int row, col;
        System.out.println("Welcome to Tic Tac Toe!");
        
        while (!game.checkWin() && !game.isBoardFull()) {
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + ", enter your move (row[1-3] col[1-3]): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            game.placeMove(row, col);
        }
        
        game.printBoard();
        
        if (game.checkWin()) {
            System.out.println("Player " + ((game.currentPlayer == 'X') ? 'O' : 'X') + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
        
        scanner.close();

        
    }
}

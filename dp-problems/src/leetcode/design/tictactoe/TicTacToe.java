package leetcode.design.tictactoe;

import java.util.Arrays;

class TicTacToe {
    char p1;
    char p2;
    char[][] board;
    char prev;
    boolean winner;
    /** Initialize your data structure here. */
    public TicTacToe() {
        p1 = 'X';
        p2 = 'O';
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], '1');
        }
       // Arrays.fill(board)
        prev = '1';
        winner = false;
    }
    
    public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
        if (board[row][col] != '1') {
            throw new AlreadyTakenException();
        }

        if (winner) {
            throw new GameEndException();
        }

        board[row][col] = prev == '1' || prev == 'O' ? 'X' : 'O';
        prev = board[row][col];
        winner = isWinner(board, row, col);
        if (winner) {
            return true;
        }
        boolean draw = checkIfAllFilled(board);
        if (draw) {
            System.out.println("draw");
        }

        return false;
        
    }

    private boolean checkIfAllFilled(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '1') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWinner(char[][] board, int row, int col) {
        boolean winner = false;
        //row wise
        char c = board[row][col];
        for (int i = 0; i < 3; i++) {
            if (board[row][i] == c && board[row][i] != '1') {
                winner = true;
                continue;
            }

            winner = false;
            break;
        }

        if (winner) return true;

        for (int i = 0; i < 3; i++) { //col
            if (board[i][col] == c && board[i][col] != '1') {
                winner = true;
                continue;
            }

            winner = false;
            break;
        }
        if (winner) return true;

        int i = 1, j = 1;
        while (i < 3 && j < 3) { //diagonal
            if (board[i][j] == board[i - 1][j - 1] && board[i][j] != '1') {
                winner = true;
                i++;
                j++;
                continue;
            }

            winner = false;
            break;

        }
        if (winner) return true;

        i = 1;
        j = 1;
        while (i >= 0 && j >= 0) { //diagonal
            if (board[i][j] == board[i + 1][j + 1] && board[i][j] != '1') {
                winner = true;
                i--;
                j--;
                continue;
            }

            winner = false;
            break;

        }
        if (winner) return true;

        return false;
    }

    public static void main(String[] args) throws GameEndException, AlreadyTakenException {
        TicTacToe ticTacToe = new TicTacToe();
        boolean ans = ticTacToe.move(0, 0);
        ans = ticTacToe.move(1, 0);
        ans = ticTacToe.move(1, 1);
        ans = ticTacToe.move(2, 0);
        ans = ticTacToe.move(2, 2);
        System.out.println(ans);
    }
}
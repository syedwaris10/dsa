package com.backtrack.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

    List<List<String>> result = new ArrayList<>();

    /**
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
     *
     * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
     *
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(0, 0, board);
        return result;
    }

    private void helper(int row, int col, char[][] board) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(String.valueOf(board[i]));
            }

            result.add(list);
            return;
        }

        for (int i = col; i < board.length; i++) {
            if (isValid(row, i, board)) {
                board[row][i] = 'Q';
                helper(row + 1, 0, board);
                board[row][i] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] board) {
        //vertical
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //horizontal
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        //diagonal right top
        int i = row;
        int j = col;
        for (i = row; i >= 0 && j < board.length; i--) {
            if (board[i][j] == 'Q') {
                return false;
            }
            j++;
        }
        //diagonal left top
        i = row;
        j = col;
        for (i = row; i >= 0 && j >= 0; i--) {
            if (board[i][j] == 'Q') {
                return false;
            }
            j--;
        }

        //diagonal right bottom
        i = row;
        j = col;
        for (i = row; i < board.length && j < board.length; i++) {
            if (board[i][j] == 'Q') {
                return false;
            }
            j++;
        }

        //diagonal left bottom
        i = row;
        j = col;
        for (i = row; i < board.length && j >= 0; i++) {
            if (board[i][j] == 'Q') {
                return false;
            }
            j--;
        }

        return true;
    }
}

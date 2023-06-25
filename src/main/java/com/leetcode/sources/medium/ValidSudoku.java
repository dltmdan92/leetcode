package com.leetcode.sources.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        /*
        row 0,1,2 col 0,1,2
        row 0,1,2 col 3,4,5
        row 0,1,2 col 6,7,8
        row 3,4,5 col 0,1,2
        row 3,4,5 col 3,4,5
        row 3,4,5 col 6,7,8
        row 6,7,8 col 0,1,2
        row 6,7,8 col 3,4,5
        row 6,7,8 col 6,7,8

        row 0~8, col 1
        row 0~8, col 2
        ---
        row 0~8, col 8

        col 0~8, row 1
        col 0~8, row 2
        ---
        col 0~8, row 8
         */

        // 3x3
        System.out.println("3x3");
        for (int row = 0; row <= 6; row+=3) {
            for (int col = 0; col <= 6; col+=3) {
                set.clear();
                int[] rows = {row, row+1, row+2};
                int[] cols = {col, col+1, col+2};

                System.out.printf("rows: %s, cols: %s\n", Arrays.toString(rows), Arrays.toString(cols));

                for (int eachRow = 0; eachRow < rows.length; eachRow++) {
                    for (int eachCol = 0; eachCol < cols.length; eachCol++) {
                        if (board[rows[eachRow]][cols[eachCol]] != '.') {
                            System.out.printf("rows[eachRow]: %d, cols[eachCol]: %d, board[rows[eachRow]][cols[eachCol]]: %s\n", rows[eachRow], cols[eachCol], board[rows[eachRow]][cols[eachCol]]);
                            if (set.contains(board[rows[eachRow]][cols[eachCol]])) {
                                return false;
                            }
                            set.add(board[rows[eachRow]][cols[eachCol]]);
                        }
                    }
                }
            }
        }

        // 9x1
        System.out.println("9x1");
        for (int col = 0; col < 9; col++) {
            set.clear();
            for (int row = 0; row < 9; row++) {
                if (board[row][col] != '.') {
                    System.out.printf("row: %d, col: %d, board[row][col]: %s\n", row, col, board[row][col]);
                    if (set.contains(board[row][col])) {
                        return false;
                    }
                    set.add(board[row][col]);
                }
            }
        }

        // 1x9
        System.out.println("1x9");
        for (int row = 0; row < 9; row++) {
            set.clear();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    System.out.printf("row: %d, col: %d, board[row][col]: %s\n", row, col, board[row][col]);
                    if (set.contains(board[row][col])) {
                        return false;
                    }
                    set.add(board[row][col]);
                }
            }
        }

        return true;
    }

}

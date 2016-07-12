package com.algos.string;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/11/2016
 * Time: 6:42 PM
 */
public class WordSearchInMatrix {
    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'r', 'd', 'q', 'e'}
        };

        /*char[][] matrix = {
                { 't', 'z', 'x', 'c', 'd' },
                { 'a', 'h', 'n', 'z', 'x' },
                { 'h', 'w', 'o', 'i', 'o' },
                { 'o', 'r', 'n', 'r', 'n' },
                { 'a', 'b', 'r', 'i', 'n' }
        };*/
        WordSearchInMatrix w = new WordSearchInMatrix(matrix.length);
        w.searchWord(matrix, "bcced"); //found
        w.searchWord(matrix, "abce"); //found
        w.searchWord(matrix, "bccde"); //NOT found
        w.searchWord(matrix, "rsfb"); //found
        w.searchWord(matrix, "fcseq"); //found
        w.searchWord(matrix, "seecsee"); //found

    }

    public int[][] solution;
    int path = 1;

    // initialize the solution matrix in constructor.
    public WordSearchInMatrix(int N) {
        solution = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution[i][j] = 0;
            }
        }
    }

    public boolean searchWord(char[][] matrix, String word) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (search(matrix, word, i, j, 0, len)) {
                    System.out.println("String " + word + " FOUND in matrix");
                    return true;
                }
            }
        }
        System.out.println("String " + word + " NOT FOUND in matrix");
        return false;
    }

    public boolean search(char[][] matrix, String word, int row, int col, int index, int len) {

        // check if current cell not already used or character in it is not not
        if (solution[row][col] != 0 || word.charAt(index) != matrix[row][col]) {
            return false;
        }

        if (index == word.length() - 1) {
            // word is found, return true
            solution[row][col] = path++;
            return true;
        }

        // mark the current cell as 1
        solution[row][col] = path++;

        // check if cell is already used
        if (row + 1 < len && search(matrix, word, row + 1, col, index + 1, len)) { // go down
            return true;
        }
        if (row - 1 >= 0 && search(matrix, word, row - 1, col, index + 1, len)) { // go up
            return true;
        }
        if (col + 1 < len && search(matrix, word, row, col + 1, index + 1, len)) { // go right
            return true;
        }
        if (col - 1 >= 0 && search(matrix, word, row, col - 1, index + 1, len)) { // go left
            return true;
        }
        if (row - 1 >= 0 && col + 1 < len && search(matrix, word, row - 1, col + 1, index + 1, len)) { // go diagonally up right
            return true;
        }
        if (row - 1 >= 0 && col - 1 >= 0 && search(matrix, word, row - 1, col - 1, index + 1, len)) { // go diagonally up left
            return true;
        }
        if (row + 1 < len && col - 1 >= 0 && search(matrix, word, row + 1, col - 1, index + 1, len)) {// go diagonally down left
            return true;
        }
        if (row + 1 < len && col + 1 < len && search(matrix, word, row + 1, col + 1, index + 1, len)) { // go diagonally down right
            return true;
        }

        // if none of the option works out, BACKTRACK and return false
        solution[row][col] = 0;
        path--;
        return false;
    }

    public void print() {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print(" " + solution[i][j]);
            }
            System.out.println();
        }
    }

}

package chess;

public class NQueenProblem {
    static int []negative = new int[30];
    static int []row = new int[30];
    static int []column = new int[30];

    public static void main(String[] args) {
        solveNQ();
    }

    //TODO adjust to size of board
    /*
     * solves N Queen problem using Backtracking. It mainly uses solveNQUtil()
     * to solve the problem. Note that there can be more than one solution.
     */
    static int boardSize = 8;
    static boolean solveNQ() {
        int board[][] = {
                { 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        if (solveNQUtil(board, 0) == false) {
            System.out.printf("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    static void printSolution(int board[][]) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++)
                System.out.printf(" %d ", board[i][j]);
            System.out.printf("\n");
        }
    }

    /* A recursive function to solve N Queen problem */
    static boolean solveNQUtil(int board[][], int col) {

        /* base case: If all queens are placed then return true */
        if (col >= boardSize) {
            return true;
        }

        /* Consider this column and try placing this queen in all rows one by one */
        for (int i = 0; i < boardSize; i++) {

        /* Check if the queen can be placed on board */
            if ((negative[i - col + boardSize - 1] != 1 && row[i + col] != 1) && column[i] != 1) {

                /* Place this queen in board */
                board[i][col] = 1;
                negative[i - col + boardSize - 1] = row[i + col] = column[i] = 1;

                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1)) {
                    return true;
                }

                /* If placing queen in board doesn't lead to a solution, then remove queen from board */
                board[i][col] = 0; // BACKTRACK
                negative[i - col + boardSize - 1] = row[i + col] = column[i] = 0;
            }
        }
        return false;
    }

}

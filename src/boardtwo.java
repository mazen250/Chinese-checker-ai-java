import java.util.ArrayList;

public class boardtwo {
    int col = 13;
    int row = 17;
    int[][] board = new int[row][col];
    int[] index = {
            0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
            0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
            0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,
            0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,
            0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,
            0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0,
    };

    // fill board with same index as above
    public void intializeBoard() {
        for (int i = 0; i < index.length; i++) {
            if (index[i] == 1) {
                board[i / col][i % col] = 1;
            } else if (index[i] == 2) {
                board[i / col][i % col] = 2;
            } else if (index[i] == 3) {
                board[i / col][i % col] = 3;
            } else {
                board[i / col][i % col] = 0;
            }
        }
        System.out.println("board initialized");

    }

    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int checkWinner() {
        if (board[0][6] == 2 && board[1][5] == 2 && board[1][6] == 2 && board[2][5] == 2 && board[2][6] == 2
                && board[2][7] == 2 && board[3][4] == 2 && board[3][5] == 2 && board[3][6] == 2
                && board[3][7] == 2) {
            return 2; // computer wins
        } else if (board[16][6] == 3 && board[15][5] == 3 && board[15][6] == 3 && board[14][5] == 3 && board[14][6] == 3
                && board[14][7] == 3 && board[13][4] == 3 && board[13][5] == 3 && board[13][6] == 3
                && board[13][7] == 3) {
            return 3; // human wins
        } else {
            return 0; // no winner - tie
        }
    }

    public void set(int x, int y, int val) {
        board[x][y] = val;
    }

    public int get(int x, int y) {
        return board[x][y];
    }

    public static void main(String[] args) {
        boardtwo b = new boardtwo();
        b.intializeBoard();
        b.print();

    }

    // get all available moves for point row and col
    public ArrayList<Integer> getAvailableMoves(int row, int col) {
        ArrayList<Integer> availableMoves = new ArrayList<Integer>();
        if (row == 0) {
            if (col == 0) {
                if (board[row][col + 1] == 0) {
                    availableMoves.add(col + 1); // right
                }
                if (board[row + 1][col] == 0) {
                    availableMoves.add(row + 1); // down
                }
                if (board[row + 1][col + 1] == 0) {
                    availableMoves.add(row + 1); // down right
                    availableMoves.add(col + 1); // right
                }
            } else if (col == col - 1) {
                if (board[row][col - 1] == 0) {
                    availableMoves.add(col - 1); // left
                }
                if (board[row + 1][col] == 0) {
                    availableMoves.add(row + 1); // down
                }
                if (board[row + 1][col - 1] == 0) {
                    availableMoves.add(row + 1); // down left
                    availableMoves.add(col - 1); // down left
                }
            } else {
                if (board[row][col - 1] == 0) {
                    availableMoves.add(col - 1); // left
                }
                if (board[row][col + 1] == 0) {
                    availableMoves.add(col + 1); // right
                }
                if (board[row + 1][col] == 0) {
                    availableMoves.add(row + 1); // down
                }
                if (board[row + 1][col - 1] == 0) {
                    availableMoves.add(row + 1); // down left
                    availableMoves.add(col - 1); // down left
                }
                if (board[row + 1][col + 1] == 0) {
                    availableMoves.add(row + 1); // down right
                    availableMoves.add(col + 1); // right
                }
            }
        } else if (row == row - 1) {
            if (col == 0) {
                if (board[row - 1][col] == 0) {
                    availableMoves.add(row - 1); // up
                }

            }
        }
        return availableMoves;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    // chinese checkers mini-max algorithm return the best move in array with
    // heuristic function
    // public static int[] miniMax(int[][] board, int depth, int player, int alpha,
    // int beta) {
    // int[] bestMove = new int[2];
    // int bestScore = Integer.MIN_VALUE;
    // int score;
    // ArrayList<int[]> moves = new ArrayList<int[]>();
    // for (int i = 0; i < board.length; i++) {
    // for (int j = 0; j < board[0].length; j++) {
    // if (board[i][j] == 0) {
    // moves.add(new int[] { i, j });
    // }
    // }
    // }
    // for (int[] move : moves) {
    // int[][] newBoard = new int[board.length][board[0].length];
    // for (int i = 0; i < board.length; i++) {
    // for (int j = 0; j < board[0].length; j++) {
    // newBoard[i][j] = board[i][j];
    // }
    // }
    // newBoard[move[0]][move[1]] = player;
    // if (player == 2) {
    // score = miniMax(newBoard, depth + 1, 3, alpha, beta)[0];
    // } else {
    // score = miniMax(newBoard, depth + 1, 2, alpha, beta)[0];
    // }
    // if (player == 2) {
    // if (score > bestScore) {
    // bestScore = score;
    // bestMove = move;
    // alpha = bestScore;
    // }
    // } else {
    // if (score < bestScore) {
    // bestScore = score;
    // bestMove = move;
    // beta = bestScore;
    // }
    // }
    // if (beta <= alpha) {
    // break;
    // }
    // }
    // return new int[] { bestScore, bestMove[0], bestMove[1] };
    // }
    // heuristic function
    public static int heuristic(int[][] board, int player) { // player = 2 for computer , player = 3 for human
        int score = 0;
        for (int i = 0; i < board.length; i++) { // check for each row
            for (int j = 0; j < board[0].length; j++) { // check for each column
                if (board[i][j] == player) { // if the player has a piece in the current position
                    score += (i + 1) * (j + 1); // add the heuristic value of the current position
                }
            }
        }
        return score;
    }

    // minimax algorithm with heuristic function
    public static int[] miniMax(int[][] board, int depth, int player, int alpha, int beta) {
        int[] bestMove = new int[2];
        int bestScore = Integer.MIN_VALUE;
        int score;
        ArrayList<int[]> moves = new ArrayList<int[]>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    moves.add(new int[] { i, j });
                }
            }
        }
        for (int[] move : moves) {
            int[][] newBoard = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    newBoard[i][j] = board[i][j];
                }
            }
            newBoard[move[0]][move[1]] = player;
            if (player == 2) {
                score = miniMax(newBoard, depth + 1, 3, alpha, beta)[0];
            } else {
                score = miniMax(newBoard, depth + 1, 2, alpha, beta)[0];
            }
            if (player == 2) {
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = move;
                    alpha = bestScore;
                }
            } else {
                if (score < bestScore) {
                    bestScore = score;
                    bestMove = move;
                    beta = bestScore;
                }
            }
            if (beta <= alpha) {
                break;
            }
        }
        return new int[] { bestScore, bestMove[0], bestMove[1] };
    }

    public static void main(String[] args) {
        String difficulty = "";
        int depth = 0;
        System.out.println("Welcome to the game of Chinese Checkers!");
        System.out.println("Please select a difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {
            difficulty = "Easy";
            depth = 2;
        } else if (choice == 2) {
            difficulty = "Medium";
            depth = 3;
        } else if (choice == 3) {
            difficulty = "Hard";
            depth = 4;
        } else {
            System.out.println("Invalid choice. Please try again.");
            System.exit(0);
        }
        Scanner scanner = new Scanner(System.in);
        boardtwo board = new boardtwo();
        board.intializeBoard();
        System.out.println("board initialized");
        System.out.println("human will be 3 and computer will be 2 , kindly note that indexes 0 is not playable");
        // board.print();
        System.out.println("\n");
        int player = 3;
        int ai = 2;
        int winner = board.checkWinner();
        int turn = player; // player starts
        boolean game = true;
        boolean validChoice = false;
        ArrayList<int[]> currentPlayerPecies = new ArrayList<>();
        while (game) {
            // player available moves
            ArrayList<Integer> availableMoves = new ArrayList<Integer>();
            if (turn == player) {
                // check winner
                if (winner == player) {
                    System.out.println("player wins");
                    break;
                } else if (winner == ai) {
                    System.out.println("computer wins");
                    break;
                } else if (winner == 1) {
                    System.out.println("tie");
                    break;
                }
                System.out.println("----------------------------------------");
                System.out.println("player turn");
                board.print();
                System.out.println("player turn");
                System.out.println("your current pecies is at ");
                for (int i = 0; i < board.row; i++) {
                    for (int j = 0; j < board.col; j++) {
                        if (board.board[i][j] == 3) {

                            int[] temp = { i, j };
                            currentPlayerPecies.add(temp);
                            temp = null;

                        }
                    }

                }
                // print all current player pecies
                for (int x = 0; x < currentPlayerPecies.size(); x++) {
                    // check if there is any duplicated pecies
                    for (int y = x + 1; y < currentPlayerPecies.size(); y++) {
                        if (currentPlayerPecies.get(x)[0] == currentPlayerPecies.get(y)[0]
                                && currentPlayerPecies.get(x)[1] == currentPlayerPecies.get(y)[1]) {
                            currentPlayerPecies.remove(y);
                        }
                    }

                    System.out.print("[" + currentPlayerPecies.get(x)[0] + "," + currentPlayerPecies.get(x)[1] + "]");
                }

                System.out.println("\n");
                System.out.println("enter your peice you want to move");
                System.out.println("enter row");
                int row = scanner.nextInt();
                System.out.println("enter col");
                int col = scanner.nextInt();
                // check if the peice is in the current player peices
                for (int x = 0; x < currentPlayerPecies.size(); x++) {
                    if (currentPlayerPecies.get(x)[0] == row && currentPlayerPecies.get(x)[1] == col) {
                        validChoice = true;
                        // get out of the loop
                        break;
                    }

                }
                if (!validChoice) {
                    System.out.println("invalid choice");
                    // enter again
                    continue;
                } else {
                    System.out.println("enter direction");
                    System.out.println("1 for right");
                    System.out.println("2 for down");
                    System.out.println("3 for down right");
                    System.out.println("4 for down left");
                    System.out.println("5 for up");
                    System.out.println("6 for up right");
                    System.out.println("7 for up left");
                    int direction = scanner.nextInt();

                    switch (direction) {
                        case 1:
                            if (col + 1 < board.col) {
                                if (board.board[row][col + 1] == 1) {
                                    // availableMoves.add(col + 1); // right
                                    System.out.println("right");
                                    board.set(row, col + 1, 3);
                                    board.set(row, col, 1);
                                    board.print();
                                    turn = ai;
                                    // remove the peice from current player peices
                                    for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                        if (currentPlayerPecies.get(x)[0] == row
                                                && currentPlayerPecies.get(x)[1] == col) {
                                            currentPlayerPecies.remove(x);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                // check if the next move has same peice as current player peices , if so
                                // jump
                                // to next peice
                                if (board.board[row][col + 1] == 3) {
                                    for (int i = col + 1; i < board.col; i++) {
                                        if (board.board[i][col] == 1) {
                                            board.set(row, i, 3);
                                            board.set(row, col, 1);
                                            board.print();
                                            turn = ai;
                                            for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                                if (currentPlayerPecies.get(x)[0] == row
                                                        && currentPlayerPecies.get(x)[1] == col) {
                                                    currentPlayerPecies.remove(x);
                                                    break;
                                                }
                                            }
                                            break;
                                        } else if (board.board[row][i] == 2) {
                                            System.out.println("there is a piece in the way");
                                            continue;
                                        } else {
                                            System.out.println("invalid move");
                                            // enter again
                                            continue;
                                        }

                                    }

                                }

                                if (board.board[row + 1][col - 1] == 2) {
                                    System.out.println("there is a piece in the way");
                                    continue;
                                } else {
                                    System.out.println("invalid move");
                                    // enter again
                                    continue;
                                }
                            }
                            break;
                        case 2:
                            if (row + 1 < board.row) {
                                if (board.board[row + 1][col] == 1) {
                                    // availableMoves.add(row + 1); // down
                                    System.out.println("down");
                                    board.set(row + 1, col, 3);
                                    board.set(row, col, 1);
                                    board.print();
                                    turn = ai;
                                    for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                        if (currentPlayerPecies.get(x)[0] == row
                                                && currentPlayerPecies.get(x)[1] == col) {
                                            currentPlayerPecies.remove(x);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                if (board.board[row + 1][col] == 3) {
                                    for (int i = row + 1; i < board.row; i++) {
                                        if (board.board[i][col] == 1) {
                                            board.set(i, col, 3);
                                            board.set(row, col, 1);
                                            board.print();
                                            turn = ai;
                                            for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                                if (currentPlayerPecies.get(x)[0] == row
                                                        && currentPlayerPecies.get(x)[1] == col) {
                                                    currentPlayerPecies.remove(x);
                                                    break;
                                                }
                                            }
                                            break;
                                        } else if (board.board[row][i] == 2) {
                                            System.out.println("there is a piece in the way");
                                            continue;
                                        } else {
                                            System.out.println("invalid move");
                                            // enter again
                                            continue;
                                        }

                                    }

                                } else if (board.board[row + 1][col - 1] == 2) {
                                    System.out.println("there is a piece in the way");
                                    continue;
                                } else {
                                    System.out.println("invalid move");
                                    continue;
                                }
                            }
                            break;
                        case 3:
                            if (row + 1 < board.row && col + 1 < board.col) {
                                if (board.board[row + 1][col + 1] == 1) {
                                    // availableMoves.add(row + 1); // down right
                                    System.out.println("down right");
                                    board.set(row + 1, col + 1, 3);
                                    board.set(row, col, 1);
                                    board.print();
                                    turn = ai;
                                    for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                        if (currentPlayerPecies.get(x)[0] == row
                                                && currentPlayerPecies.get(x)[1] == col) {
                                            currentPlayerPecies.remove(x);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                if (board.board[row + 1][col + 1] == 3) {
                                    for (int i = row + 1; i < board.row; i++) {
                                        if (board.board[i][col + 1] == 1) {
                                            board.set(i, col + 1, 3);
                                            board.set(row, col, 1);
                                            board.print();
                                            turn = ai;
                                            for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                                if (currentPlayerPecies.get(x)[0] == row
                                                        && currentPlayerPecies.get(x)[1] == col) {
                                                    currentPlayerPecies.remove(x);
                                                    break;
                                                }
                                            }
                                            break;
                                        } else if (board.board[row][i] == 2) {
                                            System.out.println("there is a piece in the way");
                                            continue;
                                        } else {
                                            System.out.println("invalid move");
                                            // enter again
                                            continue;
                                        }

                                    }
                                }

                                else if (board.board[row + 1][col - 1] == 2) {
                                    System.out.println("there is a piece in the way");
                                    continue;
                                } else {
                                    System.out.println("invalid move");
                                    continue;
                                }
                            }
                            break;
                        case 4:
                            if (row + 1 < board.row && col - 1 > 0) {
                                if (board.board[row + 1][col - 1] == 1) {
                                    availableMoves.add(row + 1); // down left
                                    System.out.println("down left");
                                    board.set(row + 1, col - 1, 3);
                                    board.set(row, col, 1);
                                    board.print();
                                    turn = ai;
                                    for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                        if (currentPlayerPecies.get(x)[0] == row
                                                && currentPlayerPecies.get(x)[1] == col) {
                                            currentPlayerPecies.remove(x);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                if (board.board[row + 1][col - 1] == 3) {
                                    for (int i = row + 1; i < board.row; i++) {
                                        if (board.board[i][col - 1] == 1) {
                                            board.set(i, col - 1, 3);
                                            board.set(row, col, 1);
                                            board.print();
                                            turn = ai;
                                            for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                                if (currentPlayerPecies.get(x)[0] == row
                                                        && currentPlayerPecies.get(x)[1] == col) {
                                                    currentPlayerPecies.remove(x);
                                                    break;
                                                }
                                            }
                                            break;
                                        } else if (board.board[row][i] == 2) {
                                            System.out.println("there is a piece in the way");
                                            continue;
                                        } else {
                                            System.out.println("invalid move");
                                            // enter again
                                            continue;
                                        }

                                    }
                                }

                                // else if (board.board[row + 1][col + 1] == 2) {
                                // System.out.println("there is a piece in the way");
                                // continue;
                                // } else {
                                // System.out.println("invalid move");
                                // continue;
                                // }}

                                else if (board.board[row + 1][col - 1] == 2) {
                                    System.out.println("there is a piece in the way");
                                    continue;
                                }

                                else {
                                    System.out.println("invalid move");
                                    continue;
                                }
                            }
                            break;
                        case 5:
                            if (row - 1 > 0) {
                                if (board.board[row - 1][col] == 1) {
                                    availableMoves.add(row - 1); // up
                                    System.out.println("up");
                                    board.set(row - 1, col, 3);
                                    board.set(row, col, 1);
                                    board.print();
                                    turn = ai;
                                    for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                        if (currentPlayerPecies.get(x)[0] == row
                                                && currentPlayerPecies.get(x)[1] == col) {
                                            currentPlayerPecies.remove(x);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                if (board.board[row - 1][col] == 3) {
                                    for (int i = row - 1; i > 0; i--) {
                                        if (board.board[i][col] == 1) {
                                            board.set(i, col, 3);
                                            board.set(row, col, 1);
                                            board.print();
                                            turn = ai;
                                            for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                                if (currentPlayerPecies.get(x)[0] == row
                                                        && currentPlayerPecies.get(x)[1] == col) {
                                                    currentPlayerPecies.remove(x);
                                                    break;
                                                }
                                            }
                                            break;
                                        } else if (board.board[row][i] == 2) {
                                            System.out.println("there is a piece in the way");
                                            continue;
                                        } else {
                                            System.out.println("invalid move");
                                            // enter again
                                            continue;
                                        }

                                    }
                                }

                                // else if (board.board[row - 1][col + 1] == 2) {
                                // System.out.println("there is a piece in the way");
                                // continue;
                                // } else {
                                // System.out.println("invalid move");
                                // continue;

                                // }
                                else if (board.board[row + 1][col - 1] == 2) {
                                    System.out.println("there is a piece in the way");
                                    continue;
                                } else {
                                    System.out.println("invalid move");
                                    continue;
                                }
                            }
                            break;
                        case 6:
                            if (row - 1 > 0 && col + 1 < board.col) {
                                if (board.board[row - 1][col + 1] == 1) {
                                    availableMoves.add(row - 1); // up right
                                    System.out.println("up right");
                                    board.set(row - 1, col + 1, 3);
                                    board.set(row, col, 1);
                                    board.print();
                                    turn = ai;
                                    for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                        if (currentPlayerPecies.get(x)[0] == row
                                                && currentPlayerPecies.get(x)[1] == col) {
                                            currentPlayerPecies.remove(x);
                                            break;
                                        }
                                    }
                                    break;
                                }

                                if (board.board[row - 1][col + 1] == 3) {
                                    for (int i = row - 1; i > 0; i--) {
                                        if (board.board[i][col + 1] == 1) {
                                            board.set(i, col + 1, 3);
                                            board.set(row, col, 1);
                                            board.print();
                                            turn = ai;
                                            for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                                if (currentPlayerPecies.get(x)[0] == row
                                                        && currentPlayerPecies.get(x)[1] == col) {
                                                    currentPlayerPecies.remove(x);
                                                    break;
                                                }
                                            }
                                            break;
                                        } else if (board.board[row][i] == 2) {
                                            System.out.println("there is a piece in the way");
                                            continue;
                                        } else {
                                            System.out.println("invalid move");
                                            // enter again
                                            continue;
                                        }

                                    }
                                }

                                else if (board.board[row + 1][col - 1] == 2) {
                                    System.out.println("there is a piece in the way");
                                    continue;
                                } else {
                                    System.out.println("invalid move");
                                    continue;
                                }
                            }
                            break;
                        case 7:
                            if (row - 1 > 0 && col - 1 > 0) {
                                if (board.board[row - 1][col - 1] == 1) {
                                    availableMoves.add(row - 1); // up left
                                    System.out.println("up left");
                                    board.set(row - 1, col - 1, 3);
                                    board.set(row, col, 1);
                                    board.print();
                                    turn = ai;
                                    for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                        if (currentPlayerPecies.get(x)[0] == row
                                                && currentPlayerPecies.get(x)[1] == col) {
                                            currentPlayerPecies.remove(x);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                // check if the left peice is the same color as the current player
                                // if so, check for the up left peice for the up left peice

                                if (board.board[row - 1][col - 1] == 3) {
                                    for (int i = row - 1; i > 0; i--) {
                                        if (board.board[i][col - 1] == 1) {
                                            board.set(i, col - 1, 3);
                                            board.set(row, col, 1);
                                            turn = ai;
                                            for (int x = 0; x < currentPlayerPecies.size(); x++) {
                                                if (currentPlayerPecies.get(x)[0] == row
                                                        && currentPlayerPecies.get(x)[1] == col) {
                                                    currentPlayerPecies.remove(x);
                                                    break;
                                                }
                                            }
                                            break;
                                        } else if (board.board[row][i] == 2) {
                                            System.out.println("there is a piece in the way");
                                            continue;
                                        } else {
                                            System.out.println("invalid move");
                                            // enter again
                                            continue;
                                        }

                                    }
                                }

                                else if (board.board[row + 1][col - 1] == 2) {
                                    System.out.println("there is a piece in the way");
                                    continue;
                                }

                                else {
                                    System.out.println("invalid move");
                                    continue;
                                }
                            }
                            break;
                        default:
                            System.out.println("invalid direction");
                            break;
                    }
                }

            } else if (turn == ai) {
                // check winner
                if (winner == player) {
                    System.out.println("player wins");
                    break;
                } else if (winner == ai) {
                    System.out.println("computer wins");
                    break;
                } else if (winner == 1) {
                    System.out.println("tie");
                    break;
                }
                System.out.println(
                        "--------------------------------------------------------------------------------------");
                System.out.println("ai turn");
                // use minimax function above
                // int[][] currentBoard = new int[8][8];
                // for (int i = 0; i < 8; i++) {
                // for (int j = 0; j < 8; j++) {
                // currentBoard[i][j] = board.board[i][j];
                // }
                // }
                // int[] move = miniMax(currentBoard, depth, ai, Integer.MIN_VALUE,
                // Integer.MAX_VALUE);
                // System.out.println("move: " + move[0] + " " + move[1]);

                turn = player;
            }
        }

    }
}

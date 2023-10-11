package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    static int whoseMove = 0;
    static int row;
    static int columns;
    public static void coord(char[][] temp) {

        Scanner scanner = new Scanner(System.in);
        try {
            row = scanner.nextInt();
            columns = scanner.nextInt();
            if (row > 3 || row < 1 || columns > 3 || columns < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                coord(temp);
            } else {
                if (temp[row - 1][columns - 1] == 'X' || temp[row - 1][columns - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    coord(temp);
                } else {
                    if (whoseMove % 2 != 0) {
                        temp[row - 1][columns - 1] = 'X';
                        printField(temp);
                    } else {
                        temp[row - 1][columns - 1] = 'O';
                        printField(temp);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            coord(temp);
        }
    }

    public static void printField(char[][] temp) {
        whoseMove++;
        System.out.println("---------");
        for (char[] chars : temp) {
            System.out.print("| ");
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        whoWins(temp);
        coord(temp);
    }

    public static void whoWins(char[][] temp) {
        int countX = 0;
        int countO = 0;
        boolean winX = false;
        boolean winO = false;

        for (char[] chars : temp) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    countX++;
                } else if (aChar == 'O') {
                    countO++;
                }
            }
        }

        int sumRow;
        int sumColumns;
        int sumDiagonals = 0;
        int sumBackDiagonals = 0;

        for (int i = 0; i < temp.length; i++) {
            sumRow = 0;
            sumColumns = 0;
            sumDiagonals += temp[i][i];
            sumBackDiagonals += temp[i][temp.length - 1 - i];
            for (int j = 0; j < temp[i].length; j++) {
                sumRow += temp[i][j];
                sumColumns += temp[j][i];
            }
            if (sumRow == 264 || sumColumns == 264 || sumDiagonals == 264 || sumBackDiagonals == 264) {
                winX = true;
            } else if (sumRow == 237 || sumColumns == 237 || sumDiagonals == 237 || sumBackDiagonals == 237) {
                winO = true;
            }
        }

        if (winX && winO || Math.abs(countO - countX) > 1) {
            System.out.println("Impossible");
            System.exit(0);
        } else if (winX) {
            System.out.println("X wins");
            System.exit(0);
        } else if (winO) {
            System.out.println("O wins");
            System.exit(0);
        } else if (countO + countX == 9) {
            System.out.println("Draw");
            System.exit(0);
        } else {
            System.out.println("Game not finished");
        }
    }

    public static void main(String[] args) {

        String line = "         ";
        int count = 0;
        char[][] field = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = line.charAt(count++);
            }
        }
        printField(field);
    }
}

package tictactoe;

import java.util.Scanner;

public class Main {

    public static int count = 0;

    public static void board(StringBuilder line) {
        count++;

        System.out.println("---------");
        int a = 0;
        char[][] arr = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = line.charAt(a++);
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        whoWins(line);
        cord(line);
    }

    public static void whoWins(StringBuilder line) {
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'X') {
                countX++;
            } else if (line.charAt(i) == 'O') {
                countO++;
            }
        }

        char ch0 = line.charAt(0);
        char ch1 = line.charAt(1);
        char ch2 = line.charAt(2);
        char ch3 = line.charAt(3);
        char ch4 = line.charAt(4);
        char ch5 = line.charAt(5);
        char ch6 = line.charAt(6);
        char ch7 = line.charAt(7);
        char ch8 = line.charAt(8);

        boolean winX = ch0 + ch1 + ch2 == 264 || ch3 + ch4 + ch5 == 264 || ch6 + ch7 + ch8 == 264 || ch0 + ch3 + ch6 == 264 ||
                ch1 + ch4 + ch7 == 264 || ch2 + ch5 + ch8 == 264 || ch0 + ch4 + ch8 == 264 || ch2 + ch4 + ch6 == 264;
        boolean winO = ch0 + ch1 + ch2 == 237 || ch3 + ch4 + ch5 == 237 || ch6 + ch7 + ch8 == 237 || ch0 + ch3 + ch6 == 237 ||
                ch1 + ch4 + ch7 == 237 || ch2 + ch5 + ch8 == 237 || ch0 + ch4 + ch8 == 237 || ch2 + ch4 + ch6 == 237;

        if (winX && winO || Math.abs(countX - countO) > 1) {
            System.out.println("Impossible");
            System.exit(0);
        } else if (winX) {
            System.out.println("X wins");
            System.exit(0);
        } else if (winO) {
            System.out.println("O wins");
            System.exit(0);
        } else if (countX + countO == 9) {
            System.out.println("Draw");
            System.exit(0);
        } else if (line.equals(" ") || line.equals("_")) {
            System.out.println("Game not finished");
            cord(line);
        }
    }

    public static void cord(StringBuilder temp) {

        int[] userInput = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");

        try {
            userInput[0] = scanner.nextInt();
            userInput[1] = scanner.nextInt();
            if (userInput[0] > 3 || userInput[0] < 1 || userInput[1] > 3 || userInput[1] < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                cord(temp);
            } else {
                line(userInput, temp);
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            cord(temp);
        }
    }

    public static void line(int[] cord, StringBuilder temp1) {
        StringBuilder stringBuilder = new StringBuilder(temp1);
        String cord1 = "" + cord[0] + cord[1];
        String ch = "X";
        if (count % 2 == 0) {
            ch = "O";
        }
        int temp = Integer.parseInt(cord1);
        if (temp == 11 && stringBuilder.charAt(0) == ' ') {
            stringBuilder.replace(0, 1, ch);
            board(stringBuilder);
        } else if (temp == 12 && stringBuilder.charAt(1) == ' ') {
            stringBuilder.replace(1, 2, ch);
            board(stringBuilder);
        } else if (temp == 13 && stringBuilder.charAt(2) == ' ') {
            stringBuilder.replace(2, 3, ch);
            board(stringBuilder);
        } else if (temp == 21 && stringBuilder.charAt(3) == ' ') {
            stringBuilder.replace(3, 4, ch);
            board(stringBuilder);
        } else if (temp == 22 && stringBuilder.charAt(4) == ' ') {
            stringBuilder.replace(4, 5, ch);
            board(stringBuilder);
        } else if (temp == 23 && stringBuilder.charAt(5) == ' ') {
            stringBuilder.replace(5, 6, ch);
            board(stringBuilder);
        } else if (temp == 31 && stringBuilder.charAt(6) == ' ') {
            stringBuilder.replace(6, 7, ch);
            board(stringBuilder);
        } else if (temp == 32 && stringBuilder.charAt(7) == ' ') {
            stringBuilder.replace(7, 8, ch);
            board(stringBuilder);
        } else if (temp == 33 && stringBuilder.charAt(8) == ' ') {
            stringBuilder.replace(8, 9, ch);
            board(stringBuilder);
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            cord(stringBuilder);
        }
    }

    public static void main(String[] args) {

        board(new StringBuilder("         "));

    }
}

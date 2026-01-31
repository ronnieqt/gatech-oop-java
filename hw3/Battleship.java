import java.util.Scanner;

public class Battleship
{
    public static void main(String[] args)
    {
        // Print out the message Welcome to Battleship!
        System.out.print("Welcome to Battleship!\n\n");
        // Prompt each user to enter coordinates for five ships of length one.
        final int N_SHIPS = 5;
        final int N_ROWS = 5;
        final int N_COLS = 5;
        // Create two 5x5 grids in the form of 2D arrays using the coordinates entered by the players.
        // These Location Boards store each player's ship locations ('@') 
        //   and will be used to keep track of the damage states ('X') of each player's ships,
        //   as well as any misses ('O').
        char[][][] locationBoards = new char[2][N_ROWS][N_COLS];
        for (int player = 0; player < 2; ++player) {
            for (int i = 0; i < N_ROWS; ++i) {
                for (int j = 0; j < N_COLS; ++j) {
                    locationBoards[player][i][j] = '-';
                }
            }
        }
        Scanner input = new Scanner(System.in);
        for (int player = 0; player < 2; ++player) {
            System.out.println(String.format("PLAYER %d, ENTER YOUR SHIPS' COORDINATES.", player + 1));
            int n = 0;
            do {
                System.out.println(String.format("Enter ship %d location:", n + 1));
                // You can expect the user input will be two ints (row_nb col_nb) separated by a space.
                int x = input.nextInt(), y = input.nextInt();
                if (x < 0 || y < 0 || x >= locationBoards[player].length || y >= locationBoards[player][0].length) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                } else if (locationBoards[player][x][y] == '@') {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                } else {
                    locationBoards[player][x][y] = '@';
                    n += 1;
                }
            } while (n < N_SHIPS);
            printBattleShip(locationBoards[player]);
            System.out.print("\n".repeat(100));
        }
        // Additionally, you must generate two more 5x5 grids in the form of 2D arrays.
        // These Target History Boards will allow each player to visually track their hits and misses.
        char[][][] tgtHistBoards = new char[2][N_ROWS][N_COLS];
        for (int player = 0; player < 2; ++player) {
            for (int i = 0; i < N_ROWS; ++i) {
                for (int j = 0; j < N_COLS; ++j) {
                    tgtHistBoards[player][i][j] = '-';
                }
            }
        }
        // Game loop
        boolean done = false;
        while (!done) {
            // Prompt players to enter a coordinate to fire upon.
            for (int player = 0; player < 2; ++player) {
                int opponent = (player + 1) % 2;
                int x = -1, y = -1;
                do {
                    System.out.println(String.format("Player %d, enter hit row/column:", player + 1));
                    // You can expect the user input will be two ints separated by a space.
                    x = input.nextInt();
                    y = input.nextInt();
                    if (x < 0 || y < 0 || x >= tgtHistBoards[player].length || y >= tgtHistBoards[player][0].length) {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                    } else if (tgtHistBoards[player][x][y] != '-') {
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                    } else {
                        break;
                    }
                } while (true);
                if (locationBoards[opponent][x][y] != '@') {
                    System.out.println(String.format("PLAYER %d MISSED!", player + 1));
                    locationBoards[opponent][x][y] = 'O';
                    tgtHistBoards[player][x][y] = 'O';
                } else {
                    System.out.println(String.format("PLAYER %d HIT PLAYER %d's SHIP!", player + 1, opponent + 1));
                    locationBoards[opponent][x][y] = 'X';
                    tgtHistBoards[player][x][y] = 'X';
                }
                printBattleShip(tgtHistBoards[player]);
                // The program must terminate gracefully after a player wins.
                if (allSunk(locationBoards[opponent])) {
                    System.out.println(String.format("PLAYER %d WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!", player + 1));
                    done = true;
                }
                System.out.println("");
                if (done) {
                    break;
                }
            }
        }
        input.close();
        // Print both players' Location Boards in order to verify the results of the game to the players.
        System.out.println("Final boards:");
        for (int player = 0; player < 2; ++player) {
            System.out.println("");
            printBattleShip(locationBoards[player]);
        }
    }

    private static boolean allSunk(char[][] board)
    {
        boolean hasShip = false;
        for (char[] row : board) {
            for (char c : row) {
                if (c == '@') {
                    hasShip = true;
                    break;
                }
            }
            if (hasShip) {
                break;
            }
        }
        return !hasShip;
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) 
    {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
}

package lastpencil;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String player1;
    static String player2;


    public static void main(String[] args) {

        //1.Read the number
        int pencilNumbers = readNumberOfPencils();

        //2.who goes first from the two possible players.
        Player player = chooseFirstPlayer();
        //printBars(pencilNumbers);
        printStartMessage(player, pencilNumbers);
    }

    private static void printStartMessage(Player player, int pencilNumbers) {
        player1 = player.getPlayer1();
        player2 = player.getPlayer2();

        int totalPencils = pencilNumbers;
        String actualPlayer = player1;
        int removedPencils;
        while (totalPencils > 0) {
            printBars(totalPencils);
            System.out.printf("""
                    \n%s turn:
                    """, actualPlayer);

            boolean exit = false;
            while (true) {
                if (actualPlayer.equals(player2)) {
                    if (totalPencils % 4 == 1) {
                        removedPencils = (int) (Math.random() * 3) + 1;
                    } else {
                        removedPencils = (totalPencils - 1) % 4;
                    }
                } else {
                    String removePencilString = String.valueOf(sc.nextLine());
                    if (!removePencilString.matches("\\d+")) { //avisar si no es digito
                        System.out.println("Possible values: '1', '2' or '3'");
                        continue;
                    }
                    removedPencils = Integer.parseInt(removePencilString);
                    if (removedPencils < 1 || removedPencils > 3) {//avisar si no es numero en 1 y 3
                        System.out.println("Possible values: '1', '2' or '3'");
                    }
                }

                if (removedPencils > totalPencils) { // avisar si se toman mas lapices que lo existentes
                    if (actualPlayer.equals(player1)) { //gana el jugador opuesto al que tomo lapices demas.
                        System.out.printf("%s won!", player2);
                        exit = true;
                        break;
                    } else {
                        System.out.printf("%s won!", player1);
                        exit = true;
                        break;
                    }
                } else {
                    totalPencils -= removedPencils;
                    if (totalPencils == 0) {
                        System.out.printf("%s won!", actualPlayer);
                    }
                    actualPlayer = (actualPlayer.equals(player1) ? player2 : player1);
                    break;
                }
            }
            if (exit) break;
        }
    }

    private static int readNumberOfPencils() {
        int pencils;

        while (true) {
            try {
                System.out.println("How many pencils would you like to use:");
                String input = sc.nextLine();
                if (!input.matches("\\d+")) {
                    System.out.println("The number of pencils should be numeric");
                    continue;
                }

                pencils = Integer.parseInt(input);
                if (pencils == 0){
                    System.out.println("The number of pencils should be positive");
                    continue;
                }
                if (pencils < 0) {
                    System.out.println("The number of pencils should be numeric");
                    continue;
                }
                return pencils;
            } catch (Exception e) {
                System.out.println("The number of pencils should be numeric");
                sc.nextLine();//Cuando ocurre InputMismatchException, el valor inválido sigue dentro del Scanner.
//Entonces el loop volverá a leer el mismo input inválido infinitamente. Debés consumirlo con:  sc.nextLine();
            }
        }
    }

    private static Player chooseFirstPlayer() {
        String player1;
        String player2;

        while (true) {
            System.out.println("Who will be the first (John, Jack):");
            player1 = sc.next();
            sc.nextLine();
            if ((player1.equals("John")) || (player1.equals("Jack"))) {
                player2 = (player1.equals("John")) ? "Jack" : "John";
                break;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }
        return new Player(player1, player2);
    }

    private static void printBars(int b) {
        for (int i = 0; i < b; i++) {
            System.out.print("|");
        }
    }
}

class Player {
    String player1, player2;

    public Player(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPlayer2() {
        return player2;
    }

    public String getPlayer1() {
        return player1;
    }

}
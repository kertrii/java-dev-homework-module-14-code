import java.util.Scanner;

public class App {
    public static final char PLAYER_MARK = 'X';
    public static final char COMPUTER_MARK = 'O';

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {
            printBox(box);

            if(!boxEmpty){
                for(byte i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }

            if(isWinner(box, PLAYER_MARK)){
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
            if(isWinner(box, COMPUTER_MARK)){
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
            if(isBoxFull(box)){
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }

            playerMove(scan, box);

            if (isWinner(box, PLAYER_MARK) || isBoxFull(box)) {
                continue;
            }

            computerMove(box);
        }
    }

    private static boolean isBoxFull(char[] box) {
        for (byte i = 0; i < 9; i++) {
            if(box[i] != 'X' && box[i] != 'O'){
                return false;
            }
        }
        return true;
    }

    private static void playerMove(Scanner scan, char[] box) {
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            }
            else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private static void computerMove(char[] box) {
        while (true) {
            byte rand = (byte) (Math.random() * 9 + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private static boolean isWinner(char[] box, char mark) {
        return (box[0] == mark && box[1] == mark && box[2] == mark) ||
                (box[3] == mark && box[4] == mark && box[5] == mark) ||
                (box[6] == mark && box[7] == mark && box[8] == mark) ||
                (box[0] == mark && box[3] == mark && box[6] == mark) ||
                (box[1] == mark && box[4] == mark && box[7] == mark) ||
                (box[2] == mark && box[5] == mark && box[8] == mark) ||
                (box[0] == mark && box[4] == mark && box[8] == mark) ||
                (box[2] == mark && box[4] == mark && box[6] == mark);
    }

    private static void printBox(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EasyAI extends PlayerOnlyGuess {

    public EasyAI() {
        this.result = new ArrayList<>();
    }


    public void start() {
        configurations();
        int[] playerSecreteNumber = setPlayerSecreteNumber();
        int[] computerSecreteNumber = setComputerSecreteNumber();
        game(computerSecreteNumber, playerSecreteNumber);
    }


    private void configurations() {
        System.out.println("Please choose maximum turns of guesses 7 or 10:  ");
        while (true) {
            try {

                max_turn = Integer.parseInt(Keyboard.readInput());
                if (max_turn == 7 || max_turn == 10) {
                    break;
                } else {
                    System.out.println("Choose 7 or 10! Try again >> ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number! Try again >> ");
            }
        }

        System.out.println("Please choose maximum digits 4 or 6: ");
        while (true) {
            try {

                max_digit = Integer.parseInt(Keyboard.readInput());
                if (max_digit == 4 || max_digit == 6) {
                    break;
                } else {
                    System.out.println("Choose 4 or 6! Try again >> ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number! Try again >> ");
            }
        }

    }


    public int[] setPlayerSecreteNumber() {
        System.out.println("Please enter your secrete number: ");
        int[] playerSecreteNumber = getPlayerGuess();
        System.out.println("----------");
        return playerSecreteNumber;
    }


    public void game(int[] computerSecreteNumber, int[] playerSecreteNumber) {
        boolean win = false;
        boolean winCom = false;
        int counter = 0;
        while (counter < max_turn) {
            System.out.print("Enter your guess > ");
            int[] playerGuess = getPlayerGuess();
            counter++;
            int bulls = super.getBulls(playerGuess, computerSecreteNumber);
            int cows = super.getCows(playerGuess, computerSecreteNumber);
            int[] computerGuess = setComputerSecreteNumber();
            int bullsComputer = getBulls(computerGuess, playerSecreteNumber);
            int cowsComputer = getCows(computerGuess, playerSecreteNumber);
            printEachResult(counter, bulls, cows, playerGuess, bullsComputer, cowsComputer, computerGuess);
            win = winPlayer(playerGuess, computerSecreteNumber);
            winCom = winComputer(computerGuess, playerSecreteNumber);
            if (win) {
                System.out.println("Congratulation! You win!");
                break;
            } else if (winCom) {
                System.out.println("Computer win!");
                break;
            }

        }
        if ((!win) && (!winCom)) {
            System.out.println("Draw! You and computer didn't get it!");
        }

    }


    public boolean winComputer(int[] computerGuess, int[] playerSecreteNumber) {
        return super.winPlayer(computerGuess, playerSecreteNumber);
    }


    public List<String> printEachResult(int counter, int bulls, int cows, int[] playerGuess, int bullsComputer, int cowsComputer, int[] computerGuess) {
        String a = "Turn " + counter + " -Your guess: ";
        String b = "";
        for (int i = 0; i < max_digit; i++) {
            b += playerGuess[i];
        }
        String c = "Results: " + bulls + " bulls " + cows + " cows ";
        String d = "Computer guess: ";
        String e = "";
        for (int i = 0; i < max_digit; i++) {
            e += computerGuess[i];
        }
        String f = "Results: " + bullsComputer + " bulls " + cowsComputer + " cows ";
        String g = "------------------------";
        String s = "";
        s = a+b+"\r\n"+c+"\r\n"+d+e+"\r\n"+f+"\r\n"+g;
        System.out.println(s);
        result.add(s);
        return result;
    }
}

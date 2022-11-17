import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EasyAI extends PlayerOnlyGuess {
    protected List<String> result;


    public EasyAI() {
        this.result = new ArrayList<>();

    }


    @Override
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
        System.out.println("Turn " + counter + " -Your guess: ");
        for (int i = 0; i < max_digit; i++) {
            System.out.print(playerGuess[i]);

        }
        System.out.println();
        System.out.println("Results: " + bulls + " bulls " + cows + " cows ");
        System.out.println("Computer guess: ");
        for (int i = 0; i < max_digit; i++) {
            System.out.print(computerGuess[i]);

        }
        System.out.println();
        System.out.println("Results: " + bullsComputer + " bulls " + cowsComputer + " cows ");
        System.out.println("----------");

        //The above print out is duplicate with the following String s.
        //I tried to reduce duplication while keeping the format of my print out.
        //So far, I couldn't achieve both but clear format is important for user experience.
        //So I keep the duplication.

        String s = "";

        if (max_digit == 4) {
            s = ("Turn " + counter + " -Your guess: " + playerGuess[0] + playerGuess[1] + playerGuess[2] + playerGuess[3] +
                    " Results: " + bulls + " bulls " + cows + " cows " +
                    " Computer guess: " + computerGuess[0] + computerGuess[1] + computerGuess[2] + computerGuess[3] +
                    " Results: " + bullsComputer + " bulls " + cowsComputer + " cows ");
        }
        if (max_digit == 6) {
            s = ("Turn " + counter + " -Your guess: " + playerGuess[0] + playerGuess[1] + playerGuess[2] + playerGuess[3] +
                    playerGuess[4] + playerGuess[5] +
                    " Results: " + bulls + " bulls " + cows + " cows " +
                    " Computer guess: " + computerGuess[0] + computerGuess[1] + computerGuess[2] + computerGuess[3] +
                    computerGuess[4] + computerGuess[5] +
                    " Results: " + bullsComputer + " bulls " + cowsComputer + " cows ");

        }

        //I also tried to improve the duplication in the if, else if for String s.
        //It caused exception, so I didn't change.

        result.add(s);


        return result;

    }


    public int getBullsComputer(int[] computerGuess, int[] playerSecreteNumber) {
        int bullsComputer = 0;
        for (int i = 0; i < max_digit; i++) {
            if (computerGuess[i] == playerSecreteNumber[i]) {
                bullsComputer++;
            }
        }
        return bullsComputer;
    }


    public int getCowsComputer(int[] computerGuess, int[] playerSecreteNumber) {
        int cowsComputer = 0;
        for (int i = 0; i < max_digit; i++) {
            for (int j = 0; j < max_digit; j++) {
                if ((i != j) && computerGuess[i] == playerSecreteNumber[j]) {
                    cowsComputer++;
                }

            }

        }
        return cowsComputer;
    }


}

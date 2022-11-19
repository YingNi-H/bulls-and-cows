import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HardAI extends MediumAI {
    protected boolean autoPlay;
    protected String fileName;
    protected int[] playerGuess;
    protected List<int[]> autoGuess;


    public HardAI() {
        this.fileName = "";
        this.playerGuess = new int[4];
        this.autoGuess = new ArrayList<>();
        this.result = new ArrayList<>();
        max_digit = 4;
        max_turn = 7;
    }


    @Override
    public void start() {
        int[] playerSecreteNumber = setPlayerSecreteNumber();
        int[] computerSecreteNumber = setComputerSecreteNumber();
        playerAuto();
        List<int[]> combinations = printUnique();
        game(computerSecreteNumber, playerSecreteNumber, combinations, autoGuess);
    }

    public boolean playerAuto() {
        System.out.println("Do you want the computer to guess for you? Y/N");
        String t = Keyboard.readInput().toLowerCase();
        if (t.equals("n")) {
            autoPlay = false;
        } else if (t.equals("y")) {
            System.out.println("Enter a file name among \"auto1\", \"auto2\", \"auto3\", \"auto4\", \"auto5\", \"auto6\", and \"auto7\": ");
            while (true) {
                fileName = Keyboard.readInput().toLowerCase();
                getAutoGuess(fileName);
                if ((!fileName.equals("auto1")) && (!fileName.equals("auto2")) && (!fileName.equals("auto3")) && (!fileName.equals("auto4")) &&
                        (!fileName.equals("auto5")) && (!fileName.equals("auto6")) && (!fileName.equals("auto7"))) {
                    System.out.println("Invalid file name! Try again > ");

                } else {
                    break;
                }
            }
            autoPlay = true;
        }
        return autoPlay;
    }


    public List<int[]> getAutoGuess(String fileName) {
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                playerGuess = new int[4];
                for (int i = 0; i < line.length(); i++) {
                    playerGuess[i] = Integer.parseInt(line.substring(i, i + 1));
                }
                autoGuess.add(playerGuess);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return autoGuess;
    }


    public List<int[]> printUnique() {
        List<int[]> combinations = new ArrayList<>();
        int[] computerCalculations;

        //This code was referred to https://www.geeksforgeeks.org/numbers-unique-distinct-digits/
        //and modified majorly by Jenny Wang. One line was modified by Ying-Ni Huang.
        int l = 99, r = 10000;
        for (int i = l; i <= r; i++) {
            int num = i;
            boolean[] visited = new boolean[10];
            while (num != 0) {
                if (visited[num % 10]) {
                    break;
                }
                visited[num % 10] = true;
                num = num / 10;
            }
            if (num == 0) {
                int counter = 3;
                int a = i;
                computerCalculations = new int[4];
                for (counter = 3; counter >= 0; counter--) {
                    computerCalculations[counter] = a % 10;
                    a = a / 10;
                }
                combinations.add(computerCalculations);
            }
        }
        return combinations;
    }


    public int[] getComputerGuess(List<int[]> combinations) {
        int[] computerGuess;
        Collections.shuffle(combinations);
        computerGuess = combinations.get(0);
        return computerGuess;
    }


    public List<int[]> getComputerStrategy(int[] computerGuess, List<int[]> combinations, int[] playerSecreteNumber) {
        int[] bullAndCowComputerGuess = new int[2];
        bullAndCowComputerGuess[0] = getBulls(computerGuess, playerSecreteNumber);
        bullAndCowComputerGuess[1] = getCows(computerGuess, playerSecreteNumber);

        Iterator<int[]> bullCowAnalysis = combinations.iterator();
        while (bullCowAnalysis.hasNext()) {
            int[] element = bullCowAnalysis.next();
            int[] bullAndCow = new int[2];
            bullAndCow[0] = getBulls(element, computerGuess);
            bullAndCow[1] = getCows(element, computerGuess);
            if (!(Arrays.equals(bullAndCow, bullAndCowComputerGuess))) {
                bullCowAnalysis.remove();
            }
        }
        return combinations;
    }


    public void game(int[] computerSecreteNumber, int[] playerSecreteNumber, List<int[]> combinations, List<int[]> autoGuess) {
        boolean win = false;
        boolean winCom = false;
        int counter = 0;
        while (counter < 7) {
            System.out.println("Enter your guess > ");
            if (autoPlay) {
                try {
                    playerGuess = autoGuess.get(counter);
                } catch (IndexOutOfBoundsException e) {
                    playerGuess = getPlayerGuess();
                }
            } else {
                playerGuess = getPlayerGuess();
            }
            int bulls = getBulls(playerGuess, computerSecreteNumber);
            int cows = getCows(playerGuess, computerSecreteNumber);
            int[] computerGuess = getComputerGuess(combinations);
            int bullsComputer = getBulls(computerGuess, playerSecreteNumber);
            int cowsComputer = getCows(computerGuess, playerSecreteNumber);
            combinations = getComputerStrategy(computerGuess, combinations, playerSecreteNumber);
            counter++;
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
}


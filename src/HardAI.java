import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HardAI extends MediumAI{
    public HardAI() {
        super();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public int[] setComputerSecreteNumber() {
        return super.setComputerSecreteNumber();
    }

    @Override
    public int[] setPlayerSecreteNumber() {
        return super.setPlayerSecreteNumber();
    }

    @Override
    public int[] getPlayerGuess() {
        return super.getPlayerGuess();
    }

    public int[] getComputerGuess() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }

        Collections.shuffle(list);

        int[] computerGuess = new int[4];
        for (int i = 0; i < 4; i++) {
            computerGuess[i] = list.get(i);
        }

        for(Integer element : computerGuess){
            System.out.println(element);
        }



        return computerGuess;

    }


    public void game(int[] computerSecreteNumber, int[] playerSecreteNumber) {
        boolean win = false;
        boolean winCom = false;
        int counter = 0;

        while (counter < 7 ) {
            System.out.print("Enter your guess > ");
            int [] playerGuess = getPlayerGuess();
            counter++;
            int bulls = getBulls(playerGuess, computerSecreteNumber);
            int cows= getCows(playerGuess, computerSecreteNumber);
            int [] computerGuess = getComputerGuess();

            int[] computerCalculations = getComputerStrategy(computerGuess);

            int bullsComputer = getBulls(computerGuess, playerSecreteNumber);
            int cowsComputer= getCows(computerGuess, playerSecreteNumber);

            int bullsComputerStrategy = getBulls(computerCalculations, playerSecreteNumber);
            int cowsComputerStrategy= getCows(computerCalculations, playerSecreteNumber);

            printEachResult(bulls, cows, playerGuess, bullsComputer, cowsComputer, computerGuess, bullsComputerStrategy, cowsComputerStrategy, computerCalculations);

            win = winPlayer(playerGuess, computerSecreteNumber);
            winCom = winComputer(computerGuess, computerCalculations, playerSecreteNumber);

            if(win){
                System.out.println("Congratulation! You win!");
                break;
            }else if(winCom){
                System.out.println("Computer win!");
                break;
            }

        }
        if((!win) && (!winCom) ){System.out.println("Draw! You and computer didn't get it!");}

    }

    private int[] getComputerStrategy(int[] computerGuess) {
        List<Integer> allPossibles = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            allPossibles.add(computerGuess[i]);
//        }
//        System.out.println("allPossibles: ");
//        for(Integer element : allPossibles){
//            System.out.print( element);
//        }

        int[] combinations = computerGuess;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                combinations[i] = computerGuess[j];


            }

        }
        for(Integer in : combinations){
            System.out.println(in);
        }

        int[] computerCalculations = new int[0];




//        for(int i= 0; i< cG.size()-1; i++){
//            if(Arrays.equals(cG.get(i), cG.get(i+1))){
//                cG.remove(cG.get(i+1));
//
//            }
//        }
//        cG.add(computerGuess);
//
//        for(int i = 0; i < cG.size(); i++){
//            int[] cGuess = cG.get(i);
//            for (int j = 0; j < cGuess.length; j++) {
//                System.out.print(cGuess[j] );
//            }
//            System.out.println( "size:" + cG.size());
//
//        }
        return computerCalculations;
    }

    @Override
    public boolean winPlayer(int[] playerGuess, int[] computerSecreteNumber) {
        return super.winPlayer(playerGuess, computerSecreteNumber);
    }


    public boolean winComputer(int[] computerGuess, int[] computerCalculations, int[] playerSecreteNumber) {
        return Arrays.equals(computerGuess, playerSecreteNumber) || Arrays.equals(computerCalculations, playerSecreteNumber);
    }


    public void printEachResult(int bulls, int cows, int[] playerGuess, int bullsComputer, int cowsComputer, int[] computerGuess, int bullsComputerStrategy, int cowsComputerStrategy, int[] computerCalculations) {
        System.out.println("Your guess: " );
        for (int i = 0; i < 4; i++) {
            System.out.print(playerGuess[i]);

        }
        System.out.println();
        System.out.println("Results: " + bulls + " bulls " + cows + " cows") ;
        System.out.println("Computer guess: " );
        for (int i = 0; i < 4; i++) {
            System.out.print(computerGuess[i]);
        }
        System.out.println();
        System.out.println("Results: " + bullsComputer + " bulls " + cowsComputer + " cows ") ;
        System.out.println("----------");

    }

    @Override
    public int getBulls(int[] playerGuess, int[] computerSecreteNumber) {
        return super.getBulls(playerGuess, computerSecreteNumber);
    }

    @Override
    public int getCows(int[] playerGuess, int[] computerSecreteNumber) {
        return super.getCows(playerGuess, computerSecreteNumber);
    }

    @Override
    public int getBullsComputer(int[] computerGuess, int[] playerSecreteNumber) {
        return super.getBullsComputer(computerGuess, playerSecreteNumber);
    }


    public int getBullsComputerStrategy(int[] computerCalculations, int[] playerSecreteNumber) {
        return super.getBullsComputer(computerCalculations, playerSecreteNumber);
    }

    @Override
    public int getCowsComputer(int[] computerGuess, int[] playerSecreteNumber) {
        return super.getCowsComputer(computerGuess, playerSecreteNumber);
    }

    public int getCowsComputerStrategy(int[] computerCalculations, int[] playerSecreteNumber) {
        return super.getCowsComputer(computerCalculations, playerSecreteNumber);
    }
}

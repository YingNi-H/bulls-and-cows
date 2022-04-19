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


        //cG.add(cG.size(), computerGuess);


        for(int i= 0; i< cG.size()-1; i++){
            if(Arrays.equals(cG.get(i), cG.get(i+1))){
                cG.remove(cG.get(i+1));

            }
        }
        cG.add(computerGuess);

        for(int i = 0; i < cG.size(); i++){
            int[] cGuess = cG.get(i);
            for (int j = 0; j < cGuess.length; j++) {
                System.out.print(cGuess[j] );
            }
            System.out.println( "size:" + cG.size());

        }



        return computerGuess;

    }


    @Override
    public void game(int[] computerSecreteNumber, int[] playerSecreteNumber) {
        super.game(computerSecreteNumber, playerSecreteNumber);
    }

    @Override
    public boolean winPlayer(int[] playerGuess, int[] computerSecreteNumber) {
        return super.winPlayer(playerGuess, computerSecreteNumber);
    }

    @Override
    public boolean winComputer(int[] computerGuess, int[] playerSecreteNumber) {
        return super.winComputer(computerGuess, playerSecreteNumber);
    }

    @Override
    public void printEachResult(int bulls, int cows, int[] playerGuess, int bullsComputer, int cowsComputer, int[] computerGuess) {
        super.printEachResult(bulls, cows, playerGuess, bullsComputer, cowsComputer, computerGuess);
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

    @Override
    public int getCowsComputer(int[] computerGuess, int[] playerSecreteNumber) {
        return super.getCowsComputer(computerGuess, playerSecreteNumber);
    }
}


import java.util.*;

public class HardAI extends MediumAI{


    private int bullsComputer;
    private int cowsComputer;

    public HardAI() {

        super();
        this.bullsComputer= bullsComputer;
        this.cowsComputer= cowsComputer;
    }


    public void start() {
        int[] playerSecreteNumber =setPlayerSecreteNumber();

        int[] computerSecreteNumber = setComputerSecreteNumber();

        List<int[]> combinations = printUnique ();

        //int[] computerGuess = getComputerStrategy(combinations, computerCalculations, playerSecreteNumber);

        game(computerSecreteNumber, playerSecreteNumber,combinations);


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


    public List<int[]> printUnique () {

        List<int[]> combinations = new ArrayList<>();
        int[] computerCalculations = new int[4];

        int l = 999, r = 10000;
        int i = 0;
        for (i = l; i <= r; i++) {
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


    public int[] getComputerGuess(List<int[]> combinations){
        int[] computerGuess = new int[0];


        Collections.shuffle(combinations);

        computerGuess = combinations.get(0);
        return computerGuess;


    }

    public List<int[]> getComputerStrategy(int bullsComputer , int cowsComputer, List<int[]> combinations, int[] playerSecreteNumber){



        int[] bullAndCowComputerGuess = new int[]{bullsComputer, cowsComputer};
//        bullAndCowComputerGuess[0] = getBullsComputer(computerGuess,playerSecreteNumber);
//        bullAndCowComputerGuess[1] = getCowsComputer(computerGuess,playerSecreteNumber);


        //combinations.remove(computerGuess);
        //System.out.println("Size: " + combinations.size());


        Iterator<int[]> bullCowAnalysis = combinations.iterator();
        while(bullCowAnalysis.hasNext()){
            int[] element = bullCowAnalysis.next();
            int[] bullAndCow = new int[2];
            bullAndCow[0] = getBullsComputer(element,playerSecreteNumber);
            bullAndCow[1] = getCowsComputer(element,playerSecreteNumber);
            if(!(Arrays.equals(bullAndCow, bullAndCowComputerGuess))){
                bullCowAnalysis.remove();
            }

        }

        System.out.println("Combinations size: " + combinations.size());


        return combinations;

    }




    public void game(int[] computerSecreteNumber, int[] playerSecreteNumber, List<int[]> combinations) {
        boolean win = false;
        boolean winCom = false;
        int counter = 0;


        while(counter < 7 ){
            System.out.print("Enter your guess > ");
            int [] playerGuess = getPlayerGuess();
            counter++;
            int bulls = getBulls(playerGuess, computerSecreteNumber);
            int cows= getCows(playerGuess, computerSecreteNumber);

            int [] computerGuess = getComputerGuess(combinations);


            int bullsComputer = getBulls(computerGuess, playerSecreteNumber);
            int cowsComputer= getCows(computerGuess, playerSecreteNumber);
            printEachResult(bulls, cows, playerGuess, bullsComputer, cowsComputer, computerGuess);

            win = winPlayer(playerGuess, computerSecreteNumber);
            winCom = winComputer(computerGuess, playerSecreteNumber);
            if(win){
                System.out.println("Congratulation! You win!");
                break;
            }else if(winCom){
                System.out.println("Computer win!");
                break;
            }
            getComputerStrategy(bullsComputer ,cowsComputer,combinations, playerSecreteNumber);
            System.out.println(combinations.size());


        }
        if((!win) && (!winCom) ){System.out.println("Draw! You and computer didn't get it!");}




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
    public List<String> printEachResult(int bulls, int cows, int[] playerGuess, int bullsComputer, int cowsComputer, int[] computerGuess) {
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


        return null;
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
        int bullsComputer = 0;
        for (int i = 0; i < 4; i++) {
            if(playerGuess[i] == computerSecreteNumber[i]){
                bullsComputer++;
            }
        }
        return bullsComputer;
    }




    @Override
    public int getCowsComputer(int[] computerGuess, int[] playerSecreteNumber) {
        return super.getCowsComputer(computerGuess, playerSecreteNumber);
    }


}



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HardAI extends MediumAI{
    protected List<String> result;
    protected boolean autoPlay;
    protected String fileName;
    protected int[] playerGuess;
    protected List<int[]> autoGuess;


    public HardAI() {
        this.fileName = "";
        this.playerGuess = new int[4];
        this.autoGuess = new ArrayList<>();

        this.result = new ArrayList<>();



    }


    public void start() {
        int[] playerSecreteNumber =setPlayerSecreteNumber();

        int[] computerSecreteNumber = setComputerSecreteNumber();

        playerAuto();


        List<int[]> combinations = printUnique ();


        game(computerSecreteNumber, playerSecreteNumber,combinations, autoGuess);


    }

    public boolean playerAuto(){

        System.out.println("Do you want the computer to guess for you? Y/N");
        String t = Keyboard.readInput().toLowerCase();
        if(t.equals("n")){
          autoPlay = false;

        }else if(t.equals("y")){
            System.out.println("Enter a file name among \"auto1\", \"auto2\", \"auto3\", \"auto4\", \"auto5\", \"auto6\", and \"auto7\": ");

            while(true) {
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


    public List<int[]> getAutoGuess(String fileName){
            String line = "";
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    System.out.println(line.length());
                    playerGuess = new int[4];
                    for (int i = 0; i < line.length(); i++) {
                        playerGuess[i] = Integer.parseInt(line.substring(i,i+1));
                        System.out.print(playerGuess[i]);

                    }
                    autoGuess.add(playerGuess);
                    System.out.println(autoGuess.size());
                }

            }catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
//        playerGuess= autoGuess.get(2);
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println(playerGuess[i]);
//
//        }



        return autoGuess;
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

        //This code was referred to https://www.geeksforgeeks.org/numbers-unique-distinct-digits/
        //and modified majorly by Jenny Wang. One line was modified by Ying-Ni Huang.
        int l = 99, r = 10000;
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
        System.out.println("computerGuess: "+combinations.size());

        Collections.shuffle(combinations);

        computerGuess = combinations.get(0);
        return computerGuess;

    }

    public List<int[]> getComputerStrategy(int[] computerGuess, List<int[]> combinations, int[] playerSecreteNumber){
        //System.out.println("Before each remove: "+combinations.size());

        int[] bullAndCowComputerGuess = new int[2];
        bullAndCowComputerGuess[0] = getBullsComputer(computerGuess,playerSecreteNumber);
        bullAndCowComputerGuess[1] = getCowsComputer(computerGuess,playerSecreteNumber);

        Iterator<int[]> bullCowAnalysis = combinations.iterator();
        while(bullCowAnalysis.hasNext()){
            int[] element = bullCowAnalysis.next();
            int[] bullAndCow = new int[2];
            bullAndCow[0] = getBullsComputer(element,computerGuess);
            bullAndCow[1] = getCowsComputer(element,computerGuess);
            if(!(Arrays.equals(bullAndCow, bullAndCowComputerGuess))){
                 bullCowAnalysis.remove();
            }

        }
        //System.out.println("Combinations size after remove: " + combinations.size());
        return combinations;

    }




    public void game(int[] computerSecreteNumber, int[] playerSecreteNumber, List<int[]> combinations, List<int[]> autoGuess) {
        boolean win = false;
        boolean winCom = false;
        int counter = 0;

        for(counter = 0; counter < 7; counter++ ){
            System.out.print("Enter your guess > ");
            if(autoPlay){

                try{playerGuess = autoGuess.get(counter);

                }catch(IndexOutOfBoundsException e){
                    playerGuess = getPlayerGuess();
                }

            }else {
                playerGuess = getPlayerGuess();

            }

            int bulls = getBulls(playerGuess, computerSecreteNumber);
            int cows= getCows(playerGuess, computerSecreteNumber);

            int[] computerGuess = getComputerGuess(combinations);

            int bullsComputer = getBulls(computerGuess, playerSecreteNumber);
            int cowsComputer= getCows(computerGuess, playerSecreteNumber);
            printEachResult(counter, bulls, cows, playerGuess, bullsComputer, cowsComputer, computerGuess);

            win = winPlayer(playerGuess, computerSecreteNumber);
            winCom = winComputer(computerGuess, playerSecreteNumber);
            if(win){
                System.out.println("Congratulation! You win!");
                break;
            }else if(winCom){
                System.out.println("Computer win!");
                break;
            }
            combinations= getComputerStrategy(computerGuess ,combinations, playerSecreteNumber);

            //System.out.println(combinations.size());

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





    public List<String> printEachResult(int counter, int bulls, int cows, int[] playerGuess,int bullsComputer, int cowsComputer, int[] computerGuess) {
        System.out.println("Turn "+ (counter +1 ) + " -Your guess: ");
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

        String s = ("Turn "+ (counter + 1) + " -Your guess: " + playerGuess[0] + playerGuess[1] + playerGuess[2] + playerGuess[3] +
                "Results: " + bulls + " bulls " + cows + " cows" +
                "Computer guess: "+ computerGuess[0] + computerGuess[1] + computerGuess[2] + computerGuess[3] +
                "Results: " + bullsComputer + " bulls " + cowsComputer + " cows ");

        result.add(s);

        return result;

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


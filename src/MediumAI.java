import java.util.*;


public class MediumAI extends EasyAI{
    protected List<int[]> cG;
    protected List<String> result;

    public MediumAI(){
        this.result = new ArrayList<>();
        this.cG = new ArrayList<>();
        this.max_turn = 7;
        this.max_digit = 4;
    }


    public void start() {

            int[] playerSecreteNumber =setPlayerSecreteNumber();

            int[] computerSecreteNumber = setComputerSecreteNumber();

            game(computerSecreteNumber, playerSecreteNumber);

        }


//      public int[] setComputerSecreteNumber(): Reuse easyAI code
//      public int[] setPlayerSecreteNumber(): Reuse easyAI code, it doesn't need to appear.
//      public int[] getPlayerGuess(): Reuse easyAI code w/ max_turn and max_digit initialized in constructor


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

//        for(Integer element : computerGuess){
//            System.out.println(element);
//        }


        for(int i= 0; i< cG.size()-1; i++){
            if(Arrays.equals(cG.get(i), cG.get(i+1))){
                cG.remove(cG.get(i+1));

            }
        }
        cG.add(computerGuess);

//        for(int i = 0; i < cG.size(); i++){
//            int[] cGuess = cG.get(i);
//            for (int j = 0; j < cGuess.length; j++) {
//                System.out.print(cGuess[j] );
//            }
//            System.out.println( "size:" + cG.size());
//
//        }

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

            }
            if((!win) && (!winCom) ){System.out.println("Draw! You and computer didn't get it!");}

        }


        @Override
        public boolean winPlayer(int[] playerGuess, int[] computerSecreteNumber) {
            return super.winPlayer(playerGuess, computerSecreteNumber);
        }

        public boolean winComputer(int[] computerGuess, int[] playerSecreteNumber) {
            return super.winPlayer(computerGuess, playerSecreteNumber);
        }


        public List<String> printEachResult(int counter, int bulls, int cows, int[] playerGuess,int bullsComputer, int cowsComputer, int[] computerGuess) {
            System.out.println("Turn "+ counter + " -Your guess: ");
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

            String s = ("Turn "+ counter + " -Your guess: " + playerGuess[0] + playerGuess[1] + playerGuess[2] + playerGuess[3] +
                    " Results: " + bulls + " bulls " + cows + " cows " +
                    " Computer guess: "+ computerGuess[0] + computerGuess[1] + computerGuess[2] + computerGuess[3] +
                    " Results: " + bullsComputer + " bulls " + cowsComputer + " cows ");


            result.add(s);

            return result;

        }

        public int getBulls(int[] playerGuess, int[] computerSecreteNumber){
            int bulls = 0;
            for (int i = 0; i < 4; i++) {
                if(playerGuess[i] == computerSecreteNumber[i]){
                    bulls++;
                }
            }
            return bulls;
        }

        public int getCows(int[] playerGuess, int[] computerSecreteNumber){
            int cows = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if((i != j) && playerGuess[i] == computerSecreteNumber[j]){
                        cows++;
                    }

                }

            }
            return cows;
        }



        public int getBullsComputer(int[] computerGuess, int[] playerSecreteNumber) {
            int bullsComputer = 0;
            for (int i = 0; i < 4; i++) {
                if(computerGuess[i] == playerSecreteNumber[i]){
                    bullsComputer++;
                }
            }
            return bullsComputer;
        }


        public int getCowsComputer(int[] computerGuess, int[] playerSecreteNumber) {
            int cowsComputer = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if((i != j) && computerGuess[i] == playerSecreteNumber[j]){
                        cowsComputer++;
                    }

                }

            }
            return cowsComputer;
        }


    }

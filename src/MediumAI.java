import java.util.*;


public class MediumAI extends EasyAI{
    private List<int[]> cG;

    public MediumAI(){
         this.cG = new ArrayList<>();
    }


    public void start() {

            int[] playerSecreteNumber =setPlayerSecreteNumber();

            int[] computerSecreteNumber = setComputerSecreteNumber();

            game(computerSecreteNumber, playerSecreteNumber);


        }




        public int[] setComputerSecreteNumber() {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                list.add(i);
            }

            Collections.shuffle(list);

            int[] computerSecreteNumber = new int[4];
            for (int i = 0; i < 4; i++) {
                computerSecreteNumber[i] = list.get(i);
            }

        for(Integer element : computerSecreteNumber){
            System.out.println(element);
        }

            return computerSecreteNumber;

        }



        public int[] setPlayerSecreteNumber(){
            System.out.println("Please enter your secrete number: ");
            int[] playerSecreteNumber = getPlayerGuess();
            System.out.println("----------");
            return playerSecreteNumber;
        }


        public int[] getPlayerGuess(){
            String playerGuessstr = "" ;
            boolean valid = false;
            while(!valid) {
                try {
                    playerGuessstr = Keyboard.readInput();

                    int temp = Integer.parseInt(playerGuessstr);

                    if ((playerGuessstr.length()) != 4) {
                        throw new StringIndexOutOfBoundsException(4 + " digits numbers!");
                    }

                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if( (i != j) && playerGuessstr.charAt(i) == playerGuessstr.charAt(j)){

                                throw new SameNumberException("No same numbers!");
                            }
                        }

                    }
                    valid = true;

                } catch ( NumberFormatException | StringIndexOutOfBoundsException | SameNumberException e) {
                    System.out.println("Error: " + e.getMessage() + " Try a valid number >> ");

                }
            }
            int[] playerGuess = new int[4];
            for (int j = 0; j < 4; j++) {
                playerGuess[j] = Integer.parseInt(playerGuessstr.substring(j, j + 1));

            }

            return playerGuess;
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




        for(int i= 0; i< cG.size(); i++){
            if(Arrays.equals(cG.get(i), cG.get(i+1))){
                cG.remove(cG.get(i+1));
                //cG.add(computerGuess);

            }
        }
        cG.add(computerGuess);
        System.out.println(cG.get(0) + "size:" + cG.size());



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


        public void printEachResult(int bulls, int cows, int[] playerGuess,int bullsComputer, int cowsComputer, int[] computerGuess) {
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
                if(playerGuess[i] == computerSecreteNumber[i]){
                    bullsComputer++;
                }
            }
            return bullsComputer;
        }


        public int getCowsComputer(int[] computerGuess, int[] playerSecreteNumber) {
            int cowsComputer = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if((i != j) && playerGuess[i] == computerSecreteNumber[j]){
                        cowsComputer++;
                    }

                }

            }
            return cowsComputer;
        }


    }

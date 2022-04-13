public class EasyAI extends PlayerOnlyGuess {
    public EasyAI() {

    }

    @Override
    public void start() {
        int[] playerSecreteNumber =setPlayerSecreteNumber();

        int[] computerSecreteNumber = setComputerSecreteNumber();

        game(computerSecreteNumber, playerSecreteNumber);


    }

    @Override
    public int[] setComputerSecreteNumber() {
        return super.setComputerSecreteNumber();
    }

    public int[] setPlayerSecreteNumber(){
        System.out.println("Please enter your secrete number: ");
        int[] playerSecreteNumber = super.getPlayerGuess();
        System.out.println("-----");
        return playerSecreteNumber;
    }

    @Override
    public int[] getPlayerGuess() {
        return super.getPlayerGuess();
    }


    public void game(int[] computerSecreteNumber, int[] playerSecreteNumber) {
        boolean win = false;
        boolean winCom = false;
        int counter =0;

        while (counter < 3 ) {
            System.out.println(">");
            int [] playerGuess = getPlayerGuess();
            counter++;
            int bulls = getBulls(playerGuess, computerSecreteNumber);
            int cows= getCows(playerGuess, computerSecreteNumber);
            int [] computerGuess = super.setComputerSecreteNumber();

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
        if(!win){System.out.println("Time's up. You didn't get it!");
        }else if(!winCom){
            System.out.println("Computer didn't get it!");
        }



    }


    @Override
    public boolean winPlayer(int[] playerGuess, int[] computerSecreteNumber) {
        return super.winPlayer(playerGuess, computerSecreteNumber);
    }

    public boolean winComputer(int[] computerGuess, int[] playerSecreteNumber) {
        return super.winPlayer(computerGuess, playerSecreteNumber);
    }

    //@Override
    public void printEachResult(int bulls, int cows, int[] playerGuess,int bullsComputer, int cowsComputer, int[] computerGuess) {
        super.printEachResult(bulls, cows, playerGuess);
        System.out.println();
        System.out.println("Computer guess: " + computerGuess[0] + "" + computerGuess[1] + "" + computerGuess[2] + "" + computerGuess[3]);
        System.out.println("Results: " + bullsComputer + " bulls " + cowsComputer + " cows ") ;
        System.out.println("-----");

    }

    @Override
    public int getBulls(int[] playerGuess, int[] computerSecreteNumber) {
        System.out.println(playerGuess+ ""+computerSecreteNumber);
        return super.getBulls(playerGuess, computerSecreteNumber);
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

    @Override
    public int getCows(int[] playerGuess, int[] computerSecreteNumber) {
        return super.getCows(playerGuess, computerSecreteNumber);
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

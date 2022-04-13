public class EasyAI extends PlayerOnlyGuess {
    public EasyAI() {

    }

    @Override
    public void start() {
        int[] playerSecreteNumber =setPlayerSecreteNumber();
        //super.start();
        int[] computerSecreteNumber = setComputerSecreteNumber();
        int[] playerGuess = getPlayerGuess();
        game(computerSecreteNumber);
        int [] computerGuess = setComputerSecreteNumber();
        gameComputer(playerSecreteNumber);
        int bulls = getBulls(playerGuess, computerSecreteNumber);
        int cows = getCows(playerGuess, computerSecreteNumber);
        int bullsComputer = getBullsComputer(computerGuess, playerSecreteNumber);
        int cowsComputer = getCowsComputer(computerGuess, playerSecreteNumber);
        printEachResult(bulls, cows, playerGuess, bullsComputer, cowsComputer, computerGuess);

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

    @Override
    public void game(int[] computerSecreteNumber) {
        boolean win = false;
        int counter =0;

        while (counter < 3 ) {
            int [] playerGuess = getPlayerGuess();
            counter++;
            int bulls = getBulls(playerGuess, computerSecreteNumber);
            int cows= getCows(playerGuess, computerSecreteNumber);
            printEachResult(bulls, cows, playerGuess);
            win = winPlayer(playerGuess, computerSecreteNumber);
            if(win){
                System.out.println("Congratulation! You win!");
                break;
            }

        }
        if(!win){System.out.println("Time's up. You didn't get it!");}


    }

    public void gameComputer(int[] playerSecreteNumber){
        boolean winCom = false;
        int counter =0;

        while (counter < 3 ) {
            int [] computerGuess = super.setComputerSecreteNumber();
            counter++;
            int bulls = getBulls(computerGuess, playerSecreteNumber);
            int cows= getCows(computerGuess, playerSecreteNumber);
            printEachResult(bulls, cows, computerGuess);
            winCom = winComputer(computerGuess, playerSecreteNumber);
            if(winCom){
                System.out.println("Computer win!");
                break;
            }

        }
        if(!winCom){System.out.println("Computer didn't get it!");}




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
        System.out.println("Results: " + bulls + " bullsComputer " + cows + " cowsComputer") ;
        System.out.println("-----");

    }

    @Override
    public int getBulls(int[] playerGuess, int[] computerSecreteNumber) {
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

    /*public static void main(String[] args) {
        new EasyAI().start();
    }*/
}

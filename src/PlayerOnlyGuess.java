import java.util.*;


public class PlayerOnlyGuess {
    protected int[] computerSecreteNumber;
    protected int[] playerGuess;
    protected int bulls;
    protected int cows;


    public void start(){

        int[] computerSecreteNumber = setComputerSecreteNumber();
        game(computerSecreteNumber);

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

        //for(Integer element : computerSecreteNumber){
            //System.out.println(element);
        //}

        return computerSecreteNumber;

    }

    public int[] getPlayerGuess(){
        String playerGuessstr = "" ;
        boolean valid = false;
        while(!valid) {
            try {
                playerGuessstr = Keyboard.readInput();

                if (playerGuessstr.length() < 4) {
                    System.out.println("4 digits numbers!");
                    valid = true;
                }
                break;

            } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());

            }
        }
        int[] playerGuess = new int[4];
        for (int j = 0; j <4; j++) {
            playerGuess[j] = Integer.parseInt(playerGuessstr.substring(j, j + 1));}
        return playerGuess;
    }


    public void game(int[] computerSecreteNumber) {
        boolean win = false;
        int counter =0;
        System.out.println("Please enter your guess: ");
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

    public boolean winPlayer(int[] playerGuess, int[] computerSecreteNumber){

        return Arrays.equals(playerGuess, computerSecreteNumber);
    }

    public void printEachResult(int bulls, int cows, int[] playerGuess){
        System.out.println("Your guess: " + playerGuess[0] + "" + playerGuess[1] + "" + playerGuess[2] + "" + playerGuess[3]);
        System.out.println("Results: " + bulls + " bulls " + cows + " cows") ;
        System.out.println("-----");
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




}

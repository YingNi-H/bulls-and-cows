import java.util.*;


public class PlayerOnlyGuess {
    protected int[] computerSecreteNumber;
    protected int[] playerGuess;
    protected int[] eachResult;
    protected int bulls;
    protected int cows;



    public PlayerOnlyGuess() {



    }
    public void start(){

        int[] computerSecreteNumber = setComputerSecreteNumber();
        compare(computerSecreteNumber);

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
            System.out.print(element);
        }

      return computerSecreteNumber;

    }





    public void compare(int[] computerSecreteNumber) {

        System.out.print("Please enter your guess: ");

        int counter =0;
            while (counter < 7 ) {
                String playerGuessstr = Keyboard.readInput();
                int[] playerGuess = new int[4];
                for (int j = 0; j <4; j++) {
                    playerGuess[j] = Integer.parseInt(playerGuessstr.substring(j, j + 1));
                }

                counter++;

                int bulls = getBulls(playerGuess, computerSecreteNumber);
                int cows= getCows(playerGuess, computerSecreteNumber);
                printEachResult(bulls, cows, playerGuess);

                if(Arrays.equals(playerGuess, computerSecreteNumber)){
                    System.out.println("Congradulation! You win!");
                }

            }
            System.out.println("Time's up. You didn't get it!");







    }
    public void printEachResult(int bulls, int cows, int[] playerGuess){
        System.out.println("Your guess: " + playerGuess[0] + "" + playerGuess[1] + "" + playerGuess[2] + "" + playerGuess[3]);
        System.out.println("Results: "+ bulls + " bulls " + cows + " cows") ;
        System.out.print(">>");
    }





    public int getBulls(int[] playerGuess, int[] computerSecreteNumber){
        int bulls = 0;
        for (int i = 0; i < 4; i++) {
            if(playerGuess[i]== computerSecreteNumber[i]){
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


    public static void main(String[] args){
        new PlayerOnlyGuess().start();

    }




}

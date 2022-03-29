import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;



public class PlayerOnlyGuess {
    protected int[] computerSecreteNumber;
    protected int[] playerGuess;
    protected int[] eachResult;
    protected String finalResult;
    protected int numberOfBulls;
    protected int numberOfCows;


    /*public PlayerOnlyGuess(int[]playerGuess,int[]eachResult){
        this.playerGuess= new int[4];

        this.eachResult = new int[7];
    }*/

    public PlayerOnlyGuess() {
        //this.numberOfBulls= numberOfBulls;
        //this.numberOfCows= numberOfCows;
        this.playerGuess= new int[4];

        this.eachResult = new int[7];

    }


    public void compare() {
        computerSecreteNumber = new int[4];

        for (int i = 0; i < 4; i++) {
            computerSecreteNumber[i] = (int) (Math.random() * 10);

        }

        while (computerSecreteNumber[0] == computerSecreteNumber[1]) {
            computerSecreteNumber[0] = (int) (Math.random() * 10);

        }
        while (computerSecreteNumber[0] == computerSecreteNumber[2]) {
            computerSecreteNumber[0] = (int) (Math.random() * 10);
        }
        while (computerSecreteNumber[0] == computerSecreteNumber[3]) {
            computerSecreteNumber[0] = (int) (Math.random() * 10);
        }
        while (computerSecreteNumber[1] == computerSecreteNumber[2]) {
            computerSecreteNumber[1] = (int) (Math.random() * 10);
        }
        while (computerSecreteNumber[1] == computerSecreteNumber[3]) {
            computerSecreteNumber[1] = (int) (Math.random() * 10);
        }
        while (computerSecreteNumber[2] == computerSecreteNumber[3]) {
            computerSecreteNumber[2] = (int) (Math.random() * 10);
        }

        System.out.println(computerSecreteNumber[0] + "" + computerSecreteNumber[1] + "" + computerSecreteNumber[2] + "" + computerSecreteNumber[3]);

        System.out.println("Please enter your guess: ");

        int count=0;

        for (int i = 0; i < eachResult.length; i++) {

            while (!Arrays.equals(playerGuess, computerSecreteNumber)) {
                String playerGuessstr = Keyboard.readInput();
                i++;
                playerGuess = new int[4];
                for (int j = 0; j <4; j++) {
                    playerGuess[j] = Integer.parseInt(playerGuessstr.substring(j, j + 1));
                }


                for (int k = 0; k < 4; k++) {
                    if (playerGuess[k] == computerSecreteNumber[k]) {
                        numberOfBulls++;
                    }
                }

                if ((playerGuess[0] != computerSecreteNumber[0]) && ((playerGuess[0] == computerSecreteNumber[1])
                        || (playerGuess[0] == computerSecreteNumber[2]) || (playerGuess[0] == computerSecreteNumber[3]))) {
                    numberOfCows++;
                }
                if ((playerGuess[1] != computerSecreteNumber[1]) && ((playerGuess[1] == computerSecreteNumber[2])
                        || (playerGuess[1] == computerSecreteNumber[3])) || (playerGuess[1] == computerSecreteNumber[0])) {
                    numberOfCows++;
                }
                if ((playerGuess[2] != computerSecreteNumber[2]) && (playerGuess[2] == computerSecreteNumber[3])
                        || (playerGuess[2] == computerSecreteNumber[1]) || (playerGuess[2] == computerSecreteNumber[0])) {
                    numberOfCows++;
                }
                if ((playerGuess[3] != computerSecreteNumber[3]) && ((playerGuess[3] == computerSecreteNumber[1])
                        || (playerGuess[3] == computerSecreteNumber[2]) || (playerGuess[3] == computerSecreteNumber[0]))) {
                    numberOfCows++;
                }

                System.out.println("Your guess: " + playerGuess[0] + "" + playerGuess[1] + "" + playerGuess[2] + "" + playerGuess[3]);
                System.out.println("Results: " + numberOfBulls + " bulls and " + numberOfCows + " cows");



            }
            //eachResult= numberOfBulls+","+numberOfCows;
            eachResult[i]=(numberOfBulls, numberOfCows);

            System.out.println("You win!");
            break;

        }
        if(!Arrays.equals(playerGuess, computerSecreteNumber)){
           System.out.println("You didn't get it.");}
    }




    public int[] getEachResult(){return eachResult;}


    public String getFinalResult() {return finalResult;}

    public static void main(String[] args){
        PlayerOnlyGuess eachResult= new PlayerOnlyGuess();
        eachResult.compare();

    }




}

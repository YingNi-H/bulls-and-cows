import java.lang.reflect.Array;

public class PlayerOnlyGuess {
    protected int[] computerSecreteNumber;
    protected int[] playerGuess;
    protected String eachResult;
    protected String finalResult;
    protected int numberOfBulls=0;
    protected int numberOfCows=0;


    public void compare(){
        computerSecreteNumber= new int[4];

        /*while(computerSecreteNumber[0]!=computerSecreteNumber[1]&&computerSecreteNumber[0]!=computerSecreteNumber[2]&&
                    computerSecreteNumber[0]!=computerSecreteNumber[3]&&computerSecreteNumber[1]!=computerSecreteNumber[2]&&
                    computerSecreteNumber[1]!=computerSecreteNumber[3]&&computerSecreteNumber[2]!=computerSecreteNumber[3]){*/
        for (int i = 0; i < 4 ; i++) {
           computerSecreteNumber[i]= (int)(Math.random()*10);

        }


        System.out.println("0: "+computerSecreteNumber[0]+" 1: "+computerSecreteNumber[1]+" 2: "+computerSecreteNumber[2]+" 3: "+computerSecreteNumber[3]);
        System.out.println(computerSecreteNumber[0]+""+computerSecreteNumber[1]+""+computerSecreteNumber[2]+""+computerSecreteNumber[3]);


        System.out.println("Please enter your guess: ");
        playerGuess= new int[4];
        String playerGuessstr= Keyboard.readInput();
        for (int i = 0; i < 4; i++) {
            playerGuess[i]= Integer.parseInt(String.valueOf(i));
        }

        System.out.println(playerGuess.length);



        for (int i = 0; i < 4; i++) {
            if(playerGuess[i]==computerSecreteNumber[i]){
                numberOfBulls++;
                System.out.println(playerGuess[i]);
            }

        }



/* if((playerGuess.equals(computerSecreteNumber))){
            numberOfBulls=4;
            System.out.println("playerGuess[1]==computerSecreteNumber[1]");
        }
        if((playerGuess[0]==computerSecreteNumber[0])){
            numberOfBulls=numberOfBulls+1;
            System.out.println("playerGuess[0]==computerSecreteNumber[0]");
        }

        if((playerGuess[2]==computerSecreteNumber[2])){
            numberOfBulls=numberOfBulls+1;
            System.out.println("playerGuess[2]==computerSecreteNumber[2]");
        }
        if((playerGuess[3]==computerSecreteNumber[3])){
            numberOfBulls=numberOfBulls+1;
            System.out.println("playerGuess[3]==computerSecreteNumber[3]");
        }

*/

        /*if((playerGuess[0]!=computerSecreteNumber[0])&&((playerGuess[0]==computerSecreteNumber[1])
                ||(playerGuess[0]==computerSecreteNumber[2])||(playerGuess[0]==computerSecreteNumber[3]))){
            numberOfCows++;
        }
        if((playerGuess[1]!=computerSecreteNumber[1])&&((playerGuess[1]==computerSecreteNumber[2])
                ||(playerGuess[1]==computerSecreteNumber[3]))){
            numberOfCows++;
        }
        if((playerGuess[2]!=computerSecreteNumber[2])&&(playerGuess[2]==computerSecreteNumber[3])
                || (playerGuess[1]==computerSecreteNumber[2])){
            numberOfCows++;
        }
        if((playerGuess[3]!=computerSecreteNumber[3])&&((playerGuess[3]==computerSecreteNumber[1])
                ||(playerGuess[3]==computerSecreteNumber[2])||(playerGuess[3]==computerSecreteNumber[0]))){
            numberOfCows++;
        }
*/


        System.out.println("Your guess: "+playerGuessstr);
        System.out.println("Results: "+numberOfBulls+" bulls and "+numberOfCows+" cows");


    }
    public String getEachResult(){return eachResult;}

    public String getFinalResult() {
        return finalResult;
    }

    public static void main(String[] args) {
        PlayerOnlyGuess player= new PlayerOnlyGuess();
        player.compare();

    }




}

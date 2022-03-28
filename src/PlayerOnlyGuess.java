
public class PlayerOnlyGuess {
    protected int[] computerSecreteNumber;
    protected int[] playerGuess;
    protected String eachResult;
    protected String finalResult;
    protected int numberOfBulls=0;
    protected int numberOfCows=0;







    public void compare(){
        computerSecreteNumber= new int[4];
        computerSecreteNumber[0]= (int)(Math.random()*10);
        computerSecreteNumber[1]= (int)(Math.random()*10);
        computerSecreteNumber[2]= (int)(Math.random()*10);
        computerSecreteNumber[3]= (int)(Math.random()*10);

        System.out.println("0: "+computerSecreteNumber[0]+" 1: "+computerSecreteNumber[1]+" 2: "+computerSecreteNumber[2]+" 3: "+computerSecreteNumber[3]);
        System.out.println(computerSecreteNumber[0]+""+computerSecreteNumber[1]+""+computerSecreteNumber[2]+""+computerSecreteNumber[3]);


        System.out.println("Please enter your guess: ");
        playerGuess= new int[4];
        String playerGuessstr= Keyboard.readInput();
        playerGuess[0]= Integer.parseInt(playerGuessstr.valueOf(0));
        playerGuess[1]= Integer.parseInt(playerGuessstr.valueOf(1));
        playerGuess[2]= Integer.parseInt(playerGuessstr.valueOf(2));
        playerGuess[3]= Integer.parseInt(playerGuessstr.valueOf(3));



        for (int i = 0; i < 4; i++) {
            if(playerGuess[i]==computerSecreteNumber[i]){
                numberOfBulls++;
            }
        }
        if(playerGuess[0]!=computerSecreteNumber[0]&&playerGuess[0]==computerSecreteNumber[1]
                ||playerGuess[0]==computerSecreteNumber[2]||playerGuess[0]==computerSecreteNumber[3]){
            numberOfCows++;
        }
        if(playerGuess[1]!=computerSecreteNumber[1]&&playerGuess[1]==computerSecreteNumber[2]
                ||playerGuess[1]==computerSecreteNumber[3]){
            numberOfCows++;
        }
        if(playerGuess[2]!=computerSecreteNumber[2]&&playerGuess[2]==computerSecreteNumber[3]){
            numberOfCows++;
        }
        if(playerGuess[3]!=computerSecreteNumber[3]&&playerGuess[3]==computerSecreteNumber[4]){
            numberOfCows++;
        }


        System.out.println("Your guess: "+playerGuessstr);
        System.out.println("Results: "+numberOfBulls+" bulls and "+numberOfCows+"cows");


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

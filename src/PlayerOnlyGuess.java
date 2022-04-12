import java.util.*;


public class PlayerOnlyGuess {
    private Integer computerSecreteNumber;
    protected int[] playerGuess;
    protected int[] eachResult;
    protected String finalResult;
    protected int numberOfBulls;
    protected int numberOfCows;



    public PlayerOnlyGuess() {



    }
    public void start(){

        setComputerSecreteNumber();
        //compare(Set<Integer> computerSecreteNumber);
        compare();
    }


    public void setComputerSecreteNumber() {
        Set<Integer> computerSecreteNumber = new HashSet<Integer>(4);

        for (int i = 0; i < 4; i++) {
            computerSecreteNumber.add((int) (Math.random() * 10));

        }

        for(Integer element : computerSecreteNumber){
            System.out.print(element);

        }

    }

    //public void compare(Set<Integer> computerSecreteNumber) {
        public void compare() {
        System.out.println("Please enter your guess: ");
        String playerGuessstr = Keyboard.readInput();

        playerGuess = new int[4];
        for (int j = 0; j <4; j++) {
            playerGuess[j] = Integer.parseInt(playerGuessstr.substring(j, j + 1));
        }
        Set<Integer> playerGuessSet = Arrays.(playerGuess);





        int counter=0;
            while (counter<7 &&(!Arrays.equals(playerGuess, computerSecreteNumber))) {

            System.out.println("Your guess: " + playerGuess[0] + "" + playerGuess[1] + "" + playerGuess[2] + "" + playerGuess[3]);








    }





    public int[] getEachResult(){return eachResult;}


    public String getFinalResult() {return finalResult;}

    public static void main(String[] args){
        new PlayerOnlyGuess().start();


    }




}

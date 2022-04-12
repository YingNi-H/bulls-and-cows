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
        compare(Integer computerSecreteNumber);
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

    public void compare(Integer computerSecreteNumber) {
        System.out.println("Please enter your guess: ");
        Set<Integer> playerGuess = new HashSet<Integer>(4);
        playerGuess.add(Integer.parseInt(Keyboard.readInput()));



        int count=0;

        System.out.println("Your guess: " + playerGuess);








    }





    public int[] getEachResult(){return eachResult;}


    public String getFinalResult() {return finalResult;}

    public static void main(String[] args){
        new PlayerOnlyGuess().start();


    }




}

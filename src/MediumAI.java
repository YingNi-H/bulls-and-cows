import java.util.*;


public class MediumAI extends EasyAI {
    protected List<int[]> cG;


    public MediumAI() {
        this.result = new ArrayList<>();
        this.cG = new ArrayList<>();
        this.max_turn = 7;
        this.max_digit = 4;
    }

    @Override
    public void start() {
        int[] playerSecreteNumber = setPlayerSecreteNumber();
        int[] computerSecreteNumber = setComputerSecreteNumber();
        game(computerSecreteNumber, playerSecreteNumber);

    }


    public int[] getComputerGuess() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        int[] computerGuess = new int[4];
        for (int i = 0; i < 4; i++) {
            computerGuess[i] = list.get(i);
        }

//        for(Integer element : computerGuess){
//            System.out.println(element);
//        }


        for (int i = 0; i < cG.size() - 1; i++) {
            if (Arrays.equals(cG.get(i), cG.get(i + 1))) {
                cG.remove(cG.get(i + 1));

            }
        }
        cG.add(computerGuess);

//        for(int i = 0; i < cG.size(); i++){
//            int[] cGuess = cG.get(i);
//            for (int j = 0; j < cGuess.length; j++) {
//                System.out.print(cGuess[j] );
//            }
//            System.out.println( "size:" + cG.size());
//
//        }

        return computerGuess;

    }


    public void game(int[] computerSecreteNumber, int[] playerSecreteNumber) {
        boolean win = false;
        boolean winCom = false;
        int counter = 0;

        while (counter < 7) {
            System.out.print("Enter your guess > ");
            int[] playerGuess = getPlayerGuess();
            counter++;
            int bulls = getBulls(playerGuess, computerSecreteNumber);
            int cows = getCows(playerGuess, computerSecreteNumber);
            int[] computerGuess = getComputerGuess();

            int bullsComputer = getBulls(computerGuess, playerSecreteNumber);
            int cowsComputer = getCows(computerGuess, playerSecreteNumber);
            super.printEachResult(counter, bulls, cows, playerGuess, bullsComputer, cowsComputer, computerGuess);
            win = winPlayer(playerGuess, computerSecreteNumber);
            winCom = winComputer(computerGuess, playerSecreteNumber);
            if (win) {
                System.out.println("Congratulation! You win!");
                break;
            } else if (winCom) {
                System.out.println("Computer win!");
                break;
            }

        }
        if ((!win) && (!winCom)) {
            System.out.println("Draw! You and computer didn't get it!");
        }

    }





}

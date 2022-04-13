public class GameControl {
    private PlayerOnlyGuess only;
    private EasyAI easy;
    private String level;

    public GameControl(){
        only = new PlayerOnlyGuess();
        easy = new EasyAI();
    }

    public void chooseLevel(){
        System.out.println("Please choose level among \"PlayerONly, Easy, Medium, Hard\": ");
        String level = Keyboard.readInput();

        switch (level){
            case "playeronly":
                new PlayerOnlyGuess().start();
                break;
            case "easy":
                new EasyAI().start();
            /*case "medium":
                new MediumAI();
            case "hard":
                new HardAI();*/

        }


    }

    /*public static void main(String[] args) {
        new GameControl().chooseLevel();

    }*/
}

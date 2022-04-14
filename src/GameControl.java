import java.util.Locale;

public class GameControl {
    private PlayerOnlyGuess only;
    //private EasyAI easy;
    //private MediumAI medium;
    //private HardAI hard;
    private String level;



    public void chooseLevel(){
        System.out.println("Welcome to Bulls and Cows game!");
        System.out.println("Please choose level: ");
        System.out.println("1 - PlayerOnly");
        System.out.println("2 - Easy");
        System.out.println("3 - Medium");
        System.out.println("4 - Hard");
        System.out.print(">>");

        boolean valid = false;

        while(!valid) {

            try {

                level = Keyboard.readInput().toLowerCase();
                switch (level) {
                    case "playeronly":
                    case "1":
                        only = new PlayerOnlyGuess();
                        break;
                    case "easy":
                    case "2":
                        only = new EasyAI();
                        break;
                    case "medium":
                    case "3":
                        only = new MediumAI();
                        break;
                    case "hard":
                    case "4":
                        only = new HardAI();
                        break;
                }
                valid = true;

                /*if (num <= 4 && num > 0){
                    valid = true;
                }else{
                    System.out.println("Choose between 1-4 or proper level! ");
                }*/


            } catch (NullPointerException e) {
                System.out.println("Unrecognized command, please enter again!");
                valid = false;
            }


        }
        only.start();


    }

    public static void main(String[] args) {
        new GameControl().chooseLevel();

    }
}

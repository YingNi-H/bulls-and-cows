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

        boolean validInput = false;

        while(!validInput) {

                level = Keyboard.readInput().toLowerCase();

            switch (level) {
                case "playeronly":
                case "1":
                    only = new PlayerOnlyGuess();
                    only.start();
                    break;
                case "easy":
                case "2":
                    only = new EasyAI();
                    only.start();
                    break;
                case "medium":
                case "3":
                    only = new MediumAI();
                    only.start();
                    break;
                case "hard":
                case "4":
                    only = new HardAI();
                    only.start();
                    break;

            }

            try {int num = Integer.parseInt(level);
                if (num <= 4 && num > 0){
                    validInput = true;
                }else{
                    System.out.println("Choose between 1-4 or proper level! ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Unrecognized command, please enter again!");
            }


        }



    }

    public static void main(String[] args) {
        new GameControl().chooseLevel();

    }
}

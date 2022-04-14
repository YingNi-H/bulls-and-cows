import java.util.InputMismatchException;
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
        System.out.print(">> ");

        boolean valid = false;

        while(!valid) {

                level = Keyboard.readInput().toLowerCase();
                switch (level) {
                    case "playeronly":
                    case "1":
                        only = new PlayerOnlyGuess();
                        valid = true;
                        break;
                    case "easy":
                    case "2":
                        only = new EasyAI();
                        valid = true;
                        break;
                    case "medium":
                    case "3":
                        only = new MediumAI();
                        valid = true;
                        break;
                    case "hard":
                    case "4":
                        only = new HardAI();
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid command! Try again >>");

                }

        }
        only.start();



    }

    public static void main(String[] args) {
        new GameControl().chooseLevel();

    }
}

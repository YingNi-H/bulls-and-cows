import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class GameControl {
    private PlayerOnlyGuess only;
    private EasyAI easy;
    private MediumAI medium;
    private HardAI hard;
    private String level;
    private int bulls;
    private int cows;
    private int[] playerGuess;
    private int bullsComputer;
    private int cowsComputer;
    private int[] computerGuess;
    private String s;




    public void start(){
        chooseLevel();
        saveFile();

    }




    public void saveFile() {

        System.out.println("Do you want to save result? Y/N");
        String str = Keyboard.readInput();
        while(true){
        if(str.toLowerCase().equals("n")){
            System.out.println("Bye~");
            break;
        }else if(str.toLowerCase().equals("y")) {
            System.out.println("Enter a file name: ");
            String fileName = Keyboard.readInput();


            File myFile = new File(fileName);
            try (BufferedWriter bW = new BufferedWriter(new FileWriter(myFile))) {
                //bW.write(easy.printEachResult(bulls, cows, playerGuess, bullsComputer, cowsComputer, computerGuess));
                Iterator<String> resultIterator = easy.result.iterator();
                while(resultIterator.hasNext()){
                    bW.write(easy.s);
                }





            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            break;
        }


        }
    }







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
                        only.start();
                        break;
                    case "easy":
                    case "2":
                        easy = new EasyAI();
                        valid = true;
                        easy.start();
                        break;
                    case "medium":
                    case "3":
                        medium = new MediumAI();
                        valid = true;
                        medium.start();
                        break;
                    case "hard":
                    case "4":
                        hard = new HardAI();
                        valid = true;
                        hard.start();
                        break;
                    default:
                        System.out.println("Invalid command! Try again >>");

                }

        }


    }



    public static void main(String[] args) {
        new GameControl().start();

    }
}

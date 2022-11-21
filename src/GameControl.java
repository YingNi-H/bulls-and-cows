import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class GameControl {
    private PlayerOnlyGuess only;
    private EasyAI easy;
    private MediumAI medium;
    private HardAI hard;
    private String level;


    public void start(){
        level = chooseLevel();
        saveFile(level);
    }


    public void saveFile(String level) {
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
                    switch (level) {
                        case "1":
                        case "playeronly":
                            for (int i = 0; i < only.result.size(); i++) {
                                bW.write(only.result.get(i));
                                bW.newLine();
                            }
                            break;
                        case "2":
                        case "easy":
                            for (int i = 0; i < easy.result.size(); i++) {
                                bW.write(easy.result.get(i));
                                bW.newLine();
                            }
                            break;
                        case "3":
                        case "medium":
                            for (int i = 0; i < medium.result.size(); i++) {
                                bW.write(medium.result.get(i));
                                bW.newLine();
                            }
                            break;
                        case "4":
                        case "hard":
                            for (int i = 0; i < hard.result.size(); i++) {
                                bW.write(hard.result.get(i));
                                bW.newLine();
                            }
                            break;
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            }
        }
    }


    public String chooseLevel(){
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
        return level;
    }


    public static void main(String[] args) {
        new GameControl().start();
    }
}

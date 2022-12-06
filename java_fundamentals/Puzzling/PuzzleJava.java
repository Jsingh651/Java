import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleJava {
    public  ArrayList<Integer> getTenRolls() {
    ArrayList<Integer> random10 = new ArrayList<Integer>();
    Random randMachine = new Random();
    for (int i = 0; i < 10; i++){
        random10.add(randMachine.nextInt(20)+1);
    }
    return random10; 
    } 

    public String getRandomLetter(){
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random randMachine = new Random();
        String random = alpha[randMachine.nextInt(26)];
        return random;
    }
    public String generatePassword(){
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random randMachine = new Random();
        String passwordgen = " ";
        for (int i = 0; i < 9; i++){
        passwordgen += alphabet[randMachine.nextInt(26)];
        }
        return passwordgen;
    }
    public String[] getNewPasswordSet(int length){
        String[] newstring = new String[length];
        for (int i = 0; i < length; i++){
            newstring[i] = generatePassword();
        }
        return newstring;

    }
}

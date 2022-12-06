import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class TestJava{
    public static void main (String[] args){
        PuzzleJava appTest = new PuzzleJava();
        ArrayList<Integer> random10 = appTest.getTenRolls();
        System.out.println(random10);
        System.out.println(appTest.getRandomLetter());
        System.out.println(appTest.generatePassword());
        String[] passwordset = appTest.getNewPasswordSet(400);
        System.out.println(Arrays.toString(passwordset));
    }
}



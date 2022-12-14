package coding.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day03 {

    static ArrayList<String> input = new ArrayList<>();
    static String half1 = null;
    static String half2 = null;
    static HashMap<Character, Integer> charValue = new HashMap<>();
    static int sumA = 0;
    static int sumB = 0;

    public static void main(String[] args)
    {
        try {
            File inputFile = new File("src/coding/day03/input.txt");
            Scanner s = new Scanner(inputFile);
            while (s.hasNextLine()) {
                input.add(s.nextLine());
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error");
            e.printStackTrace();
        }
        solveA();
        System.out.println("A) Sum: " + sumA);
        solveB();
        System.out.println("B) Sum: " + sumB);
    }

    public static void initcharMap()
    {
        int j = 1;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < alphabet.length(); i++) {
            charValue.put(alphabet.charAt(i), j);
            j += 1;
        }
    }

    public static void solveA()
    {
        initcharMap();
        char save = '0';
        for (String line : input) {
            half1 = line.substring(0, line.length() / 2);
            half2 = line.substring(line.length() / 2);
            for (int i = 0; i < half1.length(); i++) {
                for (int j = 0; j < half2.length(); j++) {
                    if (half1.charAt(i) == half2.charAt(j)) {
                        save = half2.charAt(j);
                    }
                }
            }
            sumA += charValue.get(save);
        }
    }

    public static void solveB()
    {
        char save = '0';
        for (int i = 0; i < input.size(); i += 3) {
            for (int x = 0; x < input.get(i).length(); x++) {
                for (int y = 0; y < input.get(i + 1).length(); y++) {
                    for (int z = 0; z < input.get(i + 2).length(); z++) {
                        char l1 = input.get(i).charAt(x);
                        char l2 = input.get(i + 1).charAt(y);
                        char l3 = input.get(i + 2).charAt(z);
                        if (l1 == l2 && l2 == l3) {
                            save = l1;
                            break;
                        }
                    }
                }
            }
            sumB += charValue.get(save);
        }
    }
}

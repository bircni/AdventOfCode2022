package coding.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day01 {

    static final ArrayList<Integer> elves = new ArrayList<>();
    static int elf = 0;

    public static void main(String[] args)
    {
        try {
            File input = new File("src/coding/day01/input.txt");
            Scanner s = new Scanner(input);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (data.matches("[0-9]+")) {
                    elf = elf + Integer.parseInt(data);
                } else {
                    elves.add(elf);
                    elf = 0;
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error");
            e.printStackTrace();
        }
        String result = "A) Maximum: " + Collections.max(elves) + " --> Elf: " + elves.indexOf(Collections.max(elves));
        System.out.println(result);
        // Exercise b
        int max3 = 0;
        int[] elves3 = new int[3];
        ArrayList<Integer> elvesCopy = new ArrayList<>(elves);
        for (int i = 0; i < 3; i++) {
            max3 = max3 + Collections.max(elvesCopy);
            elves3[i] = elves.indexOf(Collections.max(elvesCopy));
            elvesCopy.remove(Collections.max(elvesCopy));
        }
        System.out.println("B) Maximum: " + max3 + " --> Elves: " + elves3[0] + ", " + elves3[1] + ", " + elves3[2]);
    }

}

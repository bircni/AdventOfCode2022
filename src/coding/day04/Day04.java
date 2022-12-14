package coding.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04 {
    static ArrayList<String[]> input = new ArrayList<>();
    static int sumA = 0;
    static int sumB = 0;
    static ArrayList<Integer> Range1 = new ArrayList<>(), Range2 = new ArrayList<>();

    public static void main(String[] args)
    {
        try {
            File inputFile = new File("src/coding/day04/input.txt");
            Scanner s = new Scanner(inputFile);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] parsed = line.split(",");
                input.add(parsed);
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

    private static void solveA()
    {
        for (String[] strings : input) {
            createRange(strings);
            if (Range1.size() < Range2.size() && Range2.containsAll(Range1)) sumA += 1;
            if (Range1.size() > Range2.size() && Range1.containsAll(Range2)) sumA += 1;
            else if (Range1.containsAll(Range2)) sumA += 1;
            Range1.clear();
            Range2.clear();
        }
    }

    private static void solveB()
    {
        for (String[] strings : input) {
            createRange(strings);
            if (Range1.size() < Range2.size()) {
                for (int a = Range2.get(0); a < Range2.size() + Range2.get(0); a++) {
                    if ((Range1.contains(a))) {
                        sumB += 1;
                        break;
                    }
                }
            } else if (Range1.size() > Range2.size()) {
                for (int a = Range1.get(0); a < Range1.size() + Range1.get(0); a++) {
                    if ((Range2.contains(a))) {
                        sumB += 1;
                        break;
                    }
                }
            } else {
                if (Range1.get(0) < Range2.get(0)) {
                    for (int a = Range2.get(0); a < Range1.size() + Range1.get(0); a++) {
                        if (Range2.contains(a)) {
                            sumB += 1;
                            break;
                        }
                    }
                } else {
                    for (int a = Range1.get(0); a < Range2.size() + Range1.get(0); a++) {
                        if (Range2.contains(a)) {
                            sumB += 1;
                            break;
                        }
                    }
                }
            }
            Range1.clear();
            Range2.clear();
        }
    }

    private static void createRange(String[] strings)
    {
        String[] firstElf = strings[0].split("-");
        String[] secondElf = strings[1].split("-");
        for (int j = Integer.parseInt(firstElf[0]); j <= Integer.parseInt(firstElf[1]); j++) Range1.add(j);
        for (int j = Integer.parseInt(secondElf[0]); j <= Integer.parseInt(secondElf[1]); j++) Range2.add(j);
    }
}

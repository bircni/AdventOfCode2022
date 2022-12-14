package coding.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day05 {
    static int res = 0;
    static ArrayList<String> boxes = new ArrayList<>();
    static ArrayList<Integer> dox = new ArrayList<>();
    static ArrayList<String> arr = new ArrayList<>();
    static List<String> input;
    static String[] split;
    static String chars;
    static int swap, from, to;
    static String solA = "";
    static String solB = "";

    public static void main(String[] args) throws IOException
    {
        Path p = Paths.get("src/coding/day05/input.txt");
        input = Files.readAllLines(p);
        solveA();
        System.out.println("A) Solution: " + solA);
        solveB();
        System.out.println("B) Solution: " + solB);
    }

    private static void solveA()
    {
        solve1();
        for (int i = res + 1; i < input.size(); i++) {
            solve2(i);
            StringBuilder reverse = new StringBuilder(chars);
            reverse.reverse();
            arr.set(from - 1, arr.get(from - 1).substring(0, arr.get(from - 1).length() - swap));
            arr.set(to - 1, arr.get(to - 1) + reverse);
        }
        for (String s : arr) {
            solA = solA.concat(s.substring(s.length() - 1));
        }
    }

    private static void solveB()
    {
        clear();
        solve1();
        for (int i = res + 1; i < input.size(); i++) {
            solve2(i);
            arr.set(from - 1, arr.get(from - 1).substring(0, arr.get(from - 1).length() - swap));
            arr.set(to - 1, arr.get(to - 1) + chars);
        }
        for (String s : arr) {
            solB = solB.concat(s.substring(s.length() - 1));
        }
    }

    private static void solve1()
    {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals("")) {
                res = i;
                break;
            }
            boxes.add(input.get(i));
        }
        for (int i = boxes.size() - 1; i >= 0; i--) {
            if (i == boxes.size() - 1) {
                for (int a = 0; a < boxes.get(i).length(); a++) {
                    if ((int) boxes.get(i).charAt(a) >= 49 && (int) boxes.get(i).charAt(a) <= 57) {
                        dox.add(a);
                        arr.add("");
                    }
                }
            }
            for (int u = 0; u < dox.size(); u++) {
                if (boxes.get(i).charAt(dox.get(u)) != ' ') {
                    arr.set(u, arr.get(u) + boxes.get(i).charAt(dox.get(u)));
                }
            }
        }
    }

    private static void solve2(int i)
    {
        split = input.get(i).replaceAll("[^\\d.]", " ").strip().split("\\W+");
        swap = Integer.parseInt(split[0]);
        from = Integer.parseInt(split[1]);
        to = Integer.parseInt(split[2]);
        chars = arr.get(from - 1);
        chars = chars.substring(chars.length() - swap);
    }

    private static void clear()
    {
        boxes.clear();
        dox.clear();
        arr.clear();
    }
}

package coding.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02 {
    static ArrayList<String> data = new ArrayList<>();
    private static int scoreA = 0;
    private static int scoreB = 0;

    public static void main(String[] args)
    {
        try {
            File input = new File("src/coding/day02/input.txt");
            Scanner s = new Scanner(input);
            while (s.hasNextLine()) {
                data.add(s.nextLine());
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error");
            e.printStackTrace();
        }
        solve();
        System.out.println("A) Score: " + scoreA);
        solveB();
        System.out.println("B) Score: " + scoreB);

    }

    static void solveB()
    {
        for (String dat : data) {
            String[] line = dat.split(" ");
            switch (line[0]) {
                case "A" -> {
                    //lose
                    if (line[1].equals("X")) {
                        //select Scissors
                        scoreB = scoreB + 3;
                    }
                    //draw
                    if (line[1].equals("Y")) {
                        scoreB = scoreB + 3;
                        //select Rock
                        scoreB = scoreB + 1;
                    }
                    //win
                    if (line[1].equals("Z")) {
                        scoreB = scoreB + 6;
                        //select Paper
                        scoreB = scoreB + 2;
                    }
                }
                case "B" -> {
                    //lose
                    if (line[1].equals("X")) {
                        //select Rock
                        scoreB = scoreB + 1;
                    }
                    //draw
                    if (line[1].equals("Y")) {
                        scoreB = scoreB + 3;
                        //select Paper
                        scoreB = scoreB + 2;
                    }
                    //win
                    if (line[1].equals("Z")) {
                        scoreB = scoreB + 6;
                        //select Scissors
                        scoreB = scoreB + 3;
                    }
                }
                case "C" -> {
                    //lose
                    if (line[1].equals("X")) {
                        //select Paper
                        scoreB = scoreB + 2;
                    }
                    //draw
                    if (line[1].equals("Y")) {
                        scoreB = scoreB + 3;
                        //select Scissors
                        scoreB = scoreB + 3;
                    }
                    //win
                    if (line[1].equals("Z")) {
                        scoreB = scoreB + 6;
                        //select Rock
                        scoreB = scoreB + 1;
                    }
                }
                default -> {
                }
            }
        }
    }

    // A = Rock , B = Paper , C = Scissors
    // X = Rock , Y = Paper , Z = Scissors
    static void solve()
    {
        for (String dat : data) {
            String[] line = dat.split(" ");
            switch (line[0]) {
                case "A" -> {
                    //draw
                    if (line[1].equals("X")) {
                        scoreA = scoreA + 3;
                    }
                    //win
                    if (line[1].equals("Y")) {
                        scoreA = scoreA + 6;
                    }
                }
                case "B" -> {
                    //draw
                    if (line[1].equals("Y")) {
                        scoreA = scoreA + 3;
                    }
                    //win
                    if (line[1].equals("Z")) {
                        scoreA = scoreA + 6;
                    }
                }
                case "C" -> {
                    //win
                    if (line[1].equals("X")) {
                        scoreA = scoreA + 6;
                    }
                    //draw
                    if (line[1].equals("Z")) {
                        scoreA = scoreA + 3;
                    }
                }
                default -> {
                }
            }
            if (line[1].equals("X")) scoreA = scoreA + 1;
            if (line[1].equals("Y")) scoreA = scoreA + 2;
            if (line[1].equals("Z")) scoreA = scoreA + 3;
        }
    }
}


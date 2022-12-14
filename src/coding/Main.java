package coding;

public class Main {

    /**
     * Used to run the code for all done days
     *
     * @param args not used
     */
    public static void main(String[] args)
    {
        for (int i = 1; i <= 24; i++) {
            String day = "Day0" + (i);
            String dayURL = "coding." + day.toLowerCase() + "." + day;
            try {
                Class.forName(dayURL).getName();
                System.out.println(day + " :");
                Class.forName(dayURL).getMethod("main", String[].class).invoke(null, (Object) args);
                System.out.println();
            } catch (Exception e) {
                break;
            }
        }
    }
}

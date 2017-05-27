/**
 * Created by princ on 26/05/2017.
 */

import java.util.Scanner;

public class UserInput {
    /**
     * Convenience class for getting input from a user
     */

    public UserInput(){}

    public static String getString() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    /**
     * Returns the next line.
     *
     * @return returns the next line.
     */
    public static String getLine() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    /**
     * Returns the next double.
     *
     * @return returns the next double.
     */
    public static double getDouble() {
        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }

    /**
     * Returns the next int.
     *
     * @return returns the next int.
     */
    public static int getInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    /**
     * Returns the next boolean.
     *
     * @return returns the next boolean.
     */
    public static boolean getBoolean() {
        Scanner in = new Scanner(System.in);
        return in.nextBoolean();
    }
}


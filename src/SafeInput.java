import java.util.Scanner;

public class SafeInput
{
    /**
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

            if (retString.isEmpty())
            {
                System.out.println("You must enter at least one character");
            }

        } while (retString.isEmpty());

        return retString;
    }

    /**
     * a method that prompts for and returns an integer value
     * @param pipe the scanner to use for input
     * @param prompt the prompt to display to the user to indicate what to input
     * @return any integer value
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println("\n" + prompt + "\n");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("you must enter a valid integer, not: " + trash);
            }
        } while (!done);

        return retInt;
    }

    /**
     * a method that prompts for and returns a double value
     * @param pipe the scanner to use for input
     * @param prompt the prompt to display to the user to indicate what to input
     * @return any double value
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println("\n" + prompt + "\n");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("you must enter a valid double, not: " + trash);
            }

        } while (!done);

        return retVal;
    }

    /**
     * a method that prompts for and returns an integer value within range
     * @param pipe the scanner to use for input
     * @param prompt the prompt to display to the user to indicate what to input
     * @param low lowest accepted int, inclusive
     * @param high highest accepted int, inclusive
     * @return any int value inclusive
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println("\n" + prompt + " [" + low + " - " + high + "]" + "\n");
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();

                if (retInt < low || retInt > high)
                {
                    System.out.println("You must enter a number between: " + low + " - " + high + ", not: " + retInt);
                }
                else
                {
                    done = true;
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("you must enter a valid integer, not: " + trash);
            }
        } while (!done);

        return retInt;
    }

    /**
     * a method that prompts for and returns a double value within range
     * @param pipe the scanner to use for input
     * @param prompt the prompt to display to the user to indicate what to input
     * @param low lowest accepted double, inclusive
     * @param high highest accepted double, inclusive
     * @return any double value inclusive
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println("\n" + prompt + " [" + low + " - " + high + "]" + "\n");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();

                if (retVal < low || retVal > high)
                {
                    System.out.println("You must enter a number between: " + low + " - " + high + ", not: " + retVal);
                }
                else
                {
                    done = true;
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("you must enter a valid double, not: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * gets a Yes or No [Y/N] confirmation from the user
     * @param pipe the scanner to use for input
     * @param prompt the prompt to display to the user
     * @return true for Yes, false for No
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";
        boolean done = false;
        boolean retVal = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim();

            if (response.equalsIgnoreCase("Y"))
            {
                retVal = true;
                done = true;
            }
            else if (response.equalsIgnoreCase("N"))
            {
                retVal = false;
                done = true;
            }
            else
            {
                System.out.println("You must enter Y or N.");
            }
        } while (!done);

        return retVal;
    }

    /**
     * gets a String input that matches a supplied RegEx pattern
     * @param pipe the scanner to use for input
     * @param prompt the prompt to display to the user
     * @param regEx the regex pattern the input must match
     * @return a string that matches the given regex
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String response = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx))
            {
                done = true;
            } else
            {
                System.out.println("Input does not match the required pattern: " + regEx);
            }
        } while (!done);

        return response;
    }
    /**
     * prints a centered message within a decorative 60-character-wide header
     * @param msg the message to display
     */
    public static void prettyHeader(String msg)
    {
        final int WIDTH = 60;
        int stars = 3;
        int msgLen = msg.length();
        int spaces = (WIDTH - (stars * 2) - msgLen) / 2;


        for (int i = 0; i < WIDTH; i++) System.out.print("*");
        System.out.println();


        for (int i = 0; i < stars; i++) System.out.print("*");

        for (int i = 0; i < spaces; i++) System.out.print(" ");
        System.out.print(msg);

        for (int i = 0; i < (WIDTH - (stars * 2) - spaces - msgLen); i++) System.out.print(" ");

        for (int i = 0; i < stars; i++) System.out.print("*");
        System.out.println();


        for (int i = 0; i < WIDTH; i++) System.out.print("*");
        System.out.println();
    }

}

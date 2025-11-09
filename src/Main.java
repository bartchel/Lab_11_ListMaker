import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();


        boolean done = false;
        String cmd;

        do {
            displayList(list);
            cmd = SafeInput.getRegExString(in, "\nEnter a command [A=Add, D=Delete, I=Insert, P=Print, Q=Quit]: ", "[AaDdIiPpQq]");

            switch (cmd.toUpperCase()) {
                case "A":
                    addItem(in, list);
                    break;
                case "D":
                    deleteItem(in, list);
                    break;
                case "I":
                    insertItem(in, list);
                    break;
                case "P":
                    printList(list);
                    break;
                case "Q":


                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?"))
                    {
                        done = true;
                    }
                    break;
            }

        } while (!done);

        System.out.println("Goodbye!");
    }

    private static void addItem(Scanner in, ArrayList<String> list)
    {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to add: ");
        list.add(item);
        System.out.println("Item added!");
    }

    private static void deleteItem(Scanner in, ArrayList<String> list)
    {
        if (list.isEmpty())
        {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        printNumberedList(list);
        int choice = SafeInput.getRangedInt(in, "Enter the number of the item to delete: ", 1, list.size());
        list.remove(choice - 1);
        System.out.println("Item deleted!");
    }

    private static void insertItem(Scanner in, ArrayList<String> list)
    {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to insert: ");

        if (list.isEmpty())
        {
            list.add(item);
            System.out.println("List was empty. Item added at position 1.");
            return;
        }

        int position = SafeInput.getRangedInt(in, "Enter position to insert (1 - " + (list.size() + 1) + "): ", 1, list.size() + 1);
        list.add(position - 1, item);
        System.out.println("Item inserted!");
    }

    private static void printList(ArrayList<String> list)
    {
        System.out.println("\n----- Current List -----");

        if (list.isEmpty())
        {
            System.out.println("(Empty List)");

        }
        else
        {

            for (String item : list)
            {
                System.out.println("- " + item);
            }

        }

        System.out.println("------------------------");
    }

    private static void printNumberedList(ArrayList<String> list)
    {
        System.out.println("\n----- Numbered List -----");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.printf("%3d: %s%n", i + 1, list.get(i));
        }

        System.out.println("-------------------------");

    }

    private static void displayList(ArrayList<String> list)
    {
        System.out.println("\n---------- List Maker ----------");

        if (list.isEmpty())
        {
            System.out.println("Your list is currently empty.");

        }
        else
        {

            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d: %s%n", i + 1, list.get(i));
            }

        }

        System.out.println("--------------------------------");

        System.out.println(); //Testing commit
    }
}

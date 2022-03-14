# VarnitDataStructuresT3
```java

import src.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main - entry point class for this project
 * 1.'C' and Java have a main function/method that is the ENTRY into code
 * execution. Both languages need a file to contain that ENTRY method/function.
 * Common convention for 'C': main.c. Convention for Java: Main.java.
 * 2. Replit requires a "Main.java" file and a main class ("public Class Main").
 * Inside the class it expects a method named "public static void main(String[]
 * args)"."
 * 3. Conventions and structures are part of a programming language and the
 * tools you use. Python people like to pick on these Java conventions, saying
 * they are difficult. What do you think?
 */
public class Main { // Everything in Java is inside a class, Squigs, Squigalies, or Curly brackets
    // denote a code block in Java. This is the beginning of class code block.

    /**
     * main - entry point method for this project
     * main is the entry or pri·mor·di·al code block for Java
     */

    static public void main(String[] args) { // open squig begins the method
        ArrayList<Blueprint> options = new ArrayList<Blueprint>();
        options.add(new Sample("sample"));
        options.add(new Sample("sample2"));
        options.add(new Swap("swap"));
        options.add(new Matrix("matrix"));
        options.add(new Exit("exit"));

        while (true) {
            menu(options);
        }
    } // close squig ends the method. What did this method do?

    /**
     * menu - method that is activated by main, this will perform Java code
     */
    public static void menu(ArrayList<Blueprint> options) {
        System.out.println("Please choose something");
        for (int i = 0; i < options.size(); i++)
            System.out.println("Option " + (int) (i + 1) + ": " + options.get(i).getTitle());

        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            options.get(choice - 1).run();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

        if (scanner != null)
            scanner.close();
    }

}
```

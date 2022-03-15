# VarnitDataStructuresT3

https://github.com/VarnitGupta24/VarnitGupta24.github.io/issues/1 - Review Ticket

blueprint:
```java
package src;

public abstract class Blueprint {
    String optionTitle;

    public Blueprint(String optionTitle) {
        this.optionTitle = optionTitle;
    }

    public abstract void run();

    public String getTitle() {
        return this.optionTitle;
    }
}


exit:
```java 
package src;

public class Exit extends Blueprint {
    public Exit(String optionTitle) {
        super(optionTitle);
    }

    public void run() {
        System.exit(0);
    }

}

```
matrix:
```java
package src;

import java.util.HashMap;

public class Matrix extends Blueprint {
    HashMap<Integer, String> hexValues = new HashMap<Integer, String>();

    public Matrix(String optionTitle) {
        super(optionTitle);

        hexValues.put(10, "a");
        hexValues.put(11, "b");
        hexValues.put(12, "c");
        hexValues.put(13, "d");
        hexValues.put(14, "e");
        hexValues.put(15, "f");
    }

    // declare and initialize a matrix for a keypad
    private static int[][] keypad() {
        return new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };
    }

    // declare and initialize a random length arrays
    private static int[][] numbers() {
        return new int[][] { { 0, 1 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
    }

    private void print(int[][] m) {
        System.out.println();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != -1 && m[i][j] < 10)
                    System.out.print(m[i][j]);
                else if (m[i][j] > 9)
                    System.out.print(hexValues.get(m[i][j]));
                else
                    System.out.print(" ");
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = m.length - 1; i >= 0; i--) {
            for (int j = m[i].length - 1; j >= 0; j--) {
                if (m[i][j] != -1 && m[i][j] < 10)
                    System.out.print(m[i][j]);
                else if (m[i][j] > 9)
                    System.out.print(hexValues.get(m[i][j]));
                else
                    System.out.print(" ");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void run() {
        print(keypad());
        print(numbers());
    }

}

```
sample:
```java
package src;

public class Sample extends Blueprint {
    public Sample(String optionTitle) {
        super(optionTitle);
    }

    public void run() {
        System.out.println("This is the sample yo");
    }
}

```
swap:
```java
package src;

import java.util.Scanner;

public class Swap extends Blueprint {
    public Swap(String optionTitle) {
        super(optionTitle);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter 2 numbers to demonstrate swap");
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println("BEFORE: a is: " + a + " b is: " + b);
            int temp = b;
            b = a;
            a = temp;
            System.out.println("AFTER: a is: " + a + " b is: " + b);
        } catch (Exception e) {
            System.out.println("Invalid input, try again");
            run();
        }

    }
}

```
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

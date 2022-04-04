//InsertionSort

import com.sun.tools.javac.Main;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[517];
        for(int i = 0; i<a.length; i++)
            a[i] = (int)(Math.random()*a.length);

        Main b = new Main();
        b.printArray(a);
        b.sort(a);
        b.printArray(a);


    }

    void sort(int arr[])
    {
        int compare = 0 ;
        int swap = 0;
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
            compare++;
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                swap++;
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }

        System.out.println("Compare:  " + compare);
        System.out.println("Swaps:  " + swap);
        System.out.println("Total:  " + (swap+compare));
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

}
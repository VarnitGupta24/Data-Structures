
//BubbleSort

import java.util.Arrays;

public class BubbleSort
{
    static void bubbleSort(int arr[])
    {
        //write code here
        for(int j = 0; j < arr.length - 1; j++)
        {
            System.out.println();
            for(int i = 0; i < arr.length - 1 - j; i++)
            {
                if(arr[i] > arr[i+1])
                {
                    //salient feature: side-by-side swap
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    static void bubbleSortString(String words[])
    {
        //write code here
        for(int j = 0; j < words.length - 1; j++)
        {
            System.out.println();
            for(int i = 0; i < words.length - 1 - j; i++)
            {
                //  1 - 4 = -3  (ASCII 97 - 100 = -3)
                // "apple".compareTo("dog") --> -3
                if(words[i+1].compareTo(words[i]) < 0 )
                {
                    //salient feature: side-by-side swap
                    String temp = words[i];
                    words[i] = words[i+1];
                    words[i+1] = temp;
                }
                System.out.println(Arrays.toString(words));
            }
        }
    }

    // Driver method to test above
    public static void main(String args[])
    {
        int arr[] = {1,2,3,6,4,5};
        System.out.println("Unsorted array");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));

        String w[] = {"cat", "farm", "apple", "dog", "barn"};
        System.out.println("\nUnsorted array");
        System.out.println(Arrays.toString(w));
        bubbleSortString(w);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(w));
    }
}
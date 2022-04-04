//SelectionSort

public class Selection Sort
{
    public static void main(String[] args)
    {
        // an integer array of length 10 (initially all zeroes)
        int[] numbers = new int[10];
        // fill the array with random values [1,100]
        for(int i = 0; i < numbers.length; i++)
            numbers[i] = (int)(Math.random()*100 + 1);

        // display the original array
        System.out.println("Original numbers:");
        displayIntArray(numbers);
        // sort the numbers array
        SelectionSortAscending(numbers);
        // display the sorted array
        System.out.println("\nAscending order:");
        displayIntArray(numbers);
    }


    // rearranges the elements of the given int[] into ascending order
    public static void SelectionSortAscending(int[] arr)
    { // each iteration of this outer for loop is one "pass" over the array
        for (int i = 0; i < arr.length - 1; i++)
        {
            int min = i; // assume first value is "minimum so far"
            System.out.println("\nSorting for index "+i+", current min: "+arr[min]);
            for (int k = i + 1; k < arr.length; k++) // Loop through remaining values
            {
                if (arr[k] < arr[min]) // look for a smaller value
                {
                    min = k; // update your min index to the smaller value
                    System.out.println("Found new min value "+arr[min]+" at index "+min);
                }
            }
            System.out.println("Swapping value at index "+i+" with value at index "+min);
            // Swap minimum value of remaining with value at current position
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            displayIntArray(arr);
        }
    }


    // displays the given int[]
    public static void displayIntArray(int[] arr)
    {
        System.out.print("["+arr[0]);
        for(int i = 1; i < arr.length; i++)
            System.out.print(", "+arr[i]);
        System.out.println("]");
    }
}
//MergeSort
public class MergeSortCode
{
    public static int[] numList/*= {20,17,17,20} */;

    /**
     The tester is done for you.
     */
    public static void main(String[] args)
    {

        numList = new int[8];

        for(int i = 0; i < numList.length; i++)
        {
            numList[i] = (int)(Math.random() * 100);
        }

        System.out.println(printArray(numList));

        System.out.println("List after sorting...");
        MergeSort.sort(numList, 0, numList.length -1);
        System.out.println(printArray(numList));

    }

    public static String printArray(int[] list)
    {
        String result = "Here is your List:\n"+ String.format("%10s","Index: ");
        for(int i = 0; i < list.length; i++)
            result += String.format("%02d ",i);
        result += "\nElements: ";
        for(int element : list)
            result += String.format("%02d ",element);
        result += "\n";
        return result;
    }
}
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;

//SelectionSort
public class SelectionSort
{
    // tester
    public static void main(String[] args) {
        int TESTSIZE = 5000, SAMPLESIZE = 12;
        testSelectSort(TESTSIZE, SAMPLESIZE);
    }

    public int[] arr;
    private int swaps = 0;
    private int comparisions = 0;

    public int getSwaps() {
        return swaps;
    }

    public int getComparisions() {
        return comparisions;
    }

    // convert nano seconds to seconds
	public static double nanoToSeconds(long nano) {
		return nano / 1000000000.0;
	}

	public static double nanoToSeconds(double nano) {
		return nano / 1000000000.0;
	}


    // rearranges the elements of the given int[] into ascending order
    public SelectionSort(int size) {
        arr = new int[size];
        for(int i = 0; i<arr.length; i++)
            this.arr[i] = (int)(Math.random()*arr.length);
    }

    public static void testSelectSort(int TESTSIZE, int SAMPLESIZE) {
        Instant startTime, endTime;
        Duration duration;
        long totalTime = 0, totalComparisions = 0, totalSwaps = 0;
        double averageTime = 0.0;

        for(int i = 0; i < SAMPLESIZE; i++) {
            System.out.println("Test #" + i + ": adding " + TESTSIZE + " random numbers to the queue");

            SelectionSort b = new SelectionSort(TESTSIZE);

            startTime = Instant.now();
            b.SelectionSort();
            endTime = Instant.now();
            duration = Duration.between(startTime, endTime);
            totalComparisions += b.getComparisions();
            totalSwaps += b.getSwaps();
            totalTime += (long) duration.getNano();
            averageTime += (double) duration.getNano() / SAMPLESIZE;
        }

        System.out.println("Selection Sort");
        System.out.println("average time: " + nanoToSeconds(averageTime) + " seconds");
        System.out.println("total time: " + nanoToSeconds(totalTime) + " seconds");
        System.out.println("comparisions per sample: " + totalComparisions / SAMPLESIZE + ". Swap per sample: " + totalSwaps / SAMPLESIZE);
    }

    public void SelectionSort() {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int k = i + 1; k < arr.length; k++) {
                if(arr[k] < arr[min]) {
                    min = k;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            swaps++;
            comparisions++;
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
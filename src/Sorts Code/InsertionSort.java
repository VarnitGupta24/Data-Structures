import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;

//InsertionSort
public class InsertionSort {
    // tester
    public static void main(String[] args) {
        int TESTSIZE = 5000, SAMPLESIZE = 12;
        testInsertionSort(TESTSIZE, SAMPLESIZE);
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

    public InsertionSort(int size) {
        arr = new int[size];
        for(int i = 0; i<arr.length; i++)
            this.arr[i] = (int)(Math.random()*arr.length);
    }

    // convert nano seconds to seconds
	public static double nanoToSeconds(long nano) {
		return nano / 1000000000.0;
	}

	public static double nanoToSeconds(double nano) {
		return nano / 1000000000.0;
	}


    public static void testInsertionSort(int TESTSIZE, int SAMPLESIZE) {
		Instant startTime, endTime;
		Duration duration;
		long totalTime = 0, totalComparisions = 0, totalSwaps = 0;
		double averageTime = 0.0;

        for (int i = 0; i < SAMPLESIZE; i++) {
            System.out.println("Test #" + i + ": adding " + TESTSIZE + " random numbers to the queue");
            InsertionSort b = new InsertionSort(TESTSIZE);

            startTime = Instant.now();
            b.sort();

            endTime = Instant.now();
            duration = Duration.between(startTime, endTime);
            totalComparisions += b.getComparisions();
            totalSwaps += b.getSwaps();
            totalTime += (long) duration.getNano();
            averageTime += (double) duration.getNano() / SAMPLESIZE;
        }

		System.out.println("insertion sort");
		System.out.println("average time: " + nanoToSeconds(averageTime) + " seconds");
		System.out.println("total time: " + nanoToSeconds(totalTime) + " seconds");
		System.out.println("comparisions per sample: " + totalComparisions / SAMPLESIZE + ". Swap per sample: " + totalSwaps / SAMPLESIZE);
		System.out.println("total comparisions: " + totalComparisions + ". Total swaps: " + totalSwaps);
	}

    void sort()
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
            comparisions++;
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && arr[j] > key) {
                swaps++;
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
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
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;

//MergeSort
public class MergeSortCode {
    // tester
    public static void main(String[] args) {
        int TESTSIZE = 5000, SAMPLESIZE = 12;
        testMergeSort(TESTSIZE, SAMPLESIZE);
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

    public MergeSortCode(int size) {
        arr = new int[size];
        for(int i = 0; i<arr.length; i++)
            this.arr[i] = (int)(Math.random()*arr.length);
    }

    	// test for merge sort
	public static void testMergeSort(int TESTSIZE, int SAMPLESIZE) {
		Instant startTime, endTime;
		Duration duration;
		long totalTime = 0, totalComparisions = 0, totalSwaps = 0;
		double averageTime = 0.0;

		for(int i = 0; i < SAMPLESIZE; i++) {
			System.out.println("Test #" + i + ": adding " + TESTSIZE + " random numbers to the queue");

            MergeSortCode b = new MergeSortCode(TESTSIZE);

			startTime = Instant.now();
			b.mergeSort();
			endTime = Instant.now();
			duration = Duration.between(startTime, endTime);
			totalComparisions += b.getComparisions();
			totalSwaps += b.getSwaps();
			totalTime += (long) duration.getNano();
			averageTime += (double) duration.getNano() / SAMPLESIZE;
		}

		System.out.println("merge sort");
		System.out.println("average time: " + nanoToSeconds(averageTime) + " seconds");
		System.out.println("total time: " + nanoToSeconds(totalTime) + " seconds");
		System.out.println("comparisions per sample: " + totalComparisions / SAMPLESIZE + ". Swap per sample: " + totalSwaps / SAMPLESIZE);
		System.out.println("total comparisions: " + totalComparisions + ". Total swaps: " + totalSwaps);
	}

    // merge sort
    public void mergeSort() {
        mergeSort(0, arr.length - 1);
    }

    private void mergeSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        int[] temp = new int[arr.length];
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            comparisions++;
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                swaps++;
            }
            k++;
        }
        while (i <= middle) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= high) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        for (int l = low; l <= high; l++) {
            arr[l] = temp[l];
        }
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
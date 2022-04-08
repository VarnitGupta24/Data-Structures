//BubbleSort
import java.util.ArrayList;
import java.util.Arrays;

import java.time.Duration;
import java.time.Instant;

public class BubbleSort {

    public static double nanoToSeconds(long nano) {
		return nano / 1000000000.0;
	}

	public static double nanoToSeconds(double nano) {
		return nano / 1000000000.0;
	}

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

    public static int swaps = 0;
    public static int comparisions = 0;

    static void bubbleSort(ArrayList<Integer> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = 0; j < words.size() - 1 - i; j++) {
                if (words.get(j) > words.get(j + 1)) {
                    int temp = words.get(j);
                    words.set(j, words.get(j + 1));
                    words.set(j + 1, temp);
                }
            }
        }
    }

    public static void testBubbleSort(int TESTSIZE, int SAMPLESIZE) {
		Instant startTime, endTime;
		Duration duration;
		long totalTime = 0, totalComparisions = 0, totalSwaps = 0;
		double averageTime = 0.0;

		for(int i = 0; i < SAMPLESIZE; i++) {
			ArrayList<Integer> q = new ArrayList<Integer>();
			System.out.println("Test #" + i + ": adding " + TESTSIZE + " random numbers to the queue");

			for (int j = 0; j < TESTSIZE; j++) {
				// q.add random number between 0 and 1000
				q.add((int) (Math.random() * 1000));
			}
			startTime = Instant.now();
            bubbleSort(q);
			endTime = Instant.now();
			duration = Duration.between(startTime, endTime);
			totalComparisions += comparisions;
			totalSwaps += swaps;
			totalTime += (long) duration.getNano();
			averageTime += (double) duration.getNano() / SAMPLESIZE;
		}

		System.out.println("bubble sort");
		System.out.println("average time: " + nanoToSeconds(averageTime) + " seconds");
		System.out.println("total time: " + nanoToSeconds(totalTime) + " seconds");
		System.out.println("comparisions per sample: " + totalComparisions / SAMPLESIZE + ". Swap per sample: " + totalSwaps / SAMPLESIZE);
		System.out.println("total comparisions: " + totalComparisions + ". Total swaps: " + totalSwaps);
	}


    // Driver method to test above
    public static void main(String args[]) {
            int TESTSIZE = 5000,
                SAMPLESIZE = 12;

        testBubbleSort(TESTSIZE, SAMPLESIZE);
    }
}
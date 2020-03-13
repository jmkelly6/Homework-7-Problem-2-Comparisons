import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestHeapComplexity {
    public static final int INCREMENT = 10;
    public static final int MAX_TEST_SIZE = 8 * INCREMENT;

    // tests for research purposes
    public void testRunTimes() {
        Integer[][] testInts = new Integer[8][];
        Random r = new Random();
        for(int i = 0; i < MAX_TEST_SIZE; i += INCREMENT) {
            int heapSize = i * INCREMENT;
            testInts[i/INCREMENT] = new Integer[heapSize];
            for(int j = 0; j < testInts[i/INCREMENT].length; j++) {
                testInts[i/INCREMENT][j] = r.nextInt(100);
            }
            Arrays.sort(testInts[i/INCREMENT]);
            System.out.println("Time required to run MaxHeapLogN with size " + heapSize + ": " + testMaxHeapLogNTime(testInts[i/INCREMENT], testInts[i/INCREMENT].length));
            System.out.println("Time required to run MaxHeapN with size " + heapSize + ": " + testMaxHeapNTime(testInts[i/INCREMENT], testInts[i/INCREMENT].length));
        }
    }

    // To test run time for MaxHeapLogN
    public long testMaxHeapLogNTime(Integer[] ints, int size) {

        MaxHeap heap = new MaxHeap(size);

        long startTime = System.nanoTime();

        heap.MaxHeapLogN(ints);

        long endTime = System.nanoTime();

        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }

    // To test run time for MaxHeapN
    public long testMaxHeapNTime(Integer[] ints, int size) {

        MaxHeap heap = new MaxHeap(size);

        long startTime = System.nanoTime();

        heap.MaxHeapN(ints);

        long endTime = System.nanoTime();

        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }
}

package org.sfkulyk;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations=10, time=10, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations=10, time=10, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Thread)
public class MyBenchmark {
    public static int arrayLength = 10000;
    public static int randomArray[] = new int[arrayLength+1];
    public static int decremArray[] = new int[arrayLength+1];
    public static int incremArray[] = new int[arrayLength+1];
    public static ArrayUtils bubbleClassic=new ArrayUtils(randomArray);
    public static ArrayUtils quickSort=new ArrayUtils(randomArray);;
    public static ArrayUtils bubbleAdvanced=new ArrayUtils(randomArray);;
    public static ArrayUtils javaQuickSort=new ArrayUtils(randomArray);;

    @Benchmark
    public static void fillRandom() {
        for (int count=0; count < arrayLength; count++) {
            randomArray[count] = (int)(Math.random()*100);
        }
    }
 
    public static void fillDecremental() {
        for (int count=0; count < arrayLength; count++) {
            decremArray[count] = arrayLength-count;
        }
    }

    public static void fillIncremental() {
        for (int count=0; count < arrayLength; count++) {
            incremArray[count] = count;
        }
        for (int count=arrayLength/2; count < arrayLength/2+5; count++)
            incremArray[count]=(int)Math.random()*100;
    }

    @Benchmark
    public static void emptySortProcedure() {
        fillRandom();
	bubbleClassic=new ArrayUtils(randomArray);
    }

    @Benchmark
    public static void sortBubbleClassic() {
        fillRandom();
	bubbleClassic=new ArrayUtils(randomArray);
	bubbleClassic.sortBubbleClassic();
    }

    @Benchmark
    public static void sortBubbleAdvanced() {
        fillRandom();
	bubbleAdvanced=new ArrayUtils(randomArray);
	bubbleAdvanced.sortBubbleAdvanced();
    }

    @Benchmark
    public static void sortQuickSort() {
        fillRandom();
	quickSort=new ArrayUtils(randomArray);
	quickSort.sortQuickSort();
    }

    @Benchmark
    public static void sortJavaQuickSort() {
        fillRandom();
	javaQuickSort=new ArrayUtils(randomArray);
	javaQuickSort.sortJavaQuickSort();
    }

    public static void main(String[] args) throws RunnerException {
        fillRandom();
        fillDecremental();
        fillIncremental();

	Options opt = new OptionsBuilder()
		.include(MyBenchmark.class.getSimpleName())
		.build();
        new Runner(opt).run();
    }
}

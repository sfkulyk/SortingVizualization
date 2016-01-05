import java.util.Arrays;

public class Run {    
	static public void FillRandom(int[] array) {
		for (int count=0; count < array.length; count++) {
			array[count] = (int)(Math.random()*100);
		}
	}
 
	static public void FillDecremental(int[] array) {
		for (int count=0; count < array.length; count++) {
			array[count] = array.length-count;
		}
	} 

	static public void FillIncremental(int[] array) {
		for (int count=0; count < array.length; count++) {
			array[count] = count;
		}
		for (int count=array.length/2; count < array.length/2+5; count++)
		array[count]=(int)Math.random()*100;
	}
	
	public static void main(String[] args)
	{
		int N = 10000;
		int random[] = new int[N+1];
		int decremental[] = new int[N+1];
		int incremental[] = new int[N+1];
		FillRandom(random);
		FillDecremental(decremental);
		FillIncremental(incremental);
     
		ArrayUtils bubbleClassic = new ArrayUtils(Arrays.copyOf(random,random.length));
		bubbleClassic.sortBubbleClassic();
		bubbleClassic.results("Bubble Classic, random array");
     
		bubbleClassic = new ArrayUtils(Arrays.copyOf(decremental,decremental.length));
		bubbleClassic.sortBubbleClassic();
		bubbleClassic.results("Bubble Classic, decremental array");
     
		bubbleClassic = new ArrayUtils(Arrays.copyOf(incremental,incremental.length));
		bubbleClassic.sortBubbleClassic();
		bubbleClassic.results("Bubble Classic, incremental array");

		System.out.print("\n");
		ArrayUtils quickSort = new ArrayUtils(Arrays.copyOf(random,random.length));
		quickSort.quickSort();
		quickSort.results("QuickSort, random array");
     
		quickSort = new ArrayUtils(Arrays.copyOf(decremental,decremental.length));
		quickSort.quickSort();     
		quickSort.results("QuickSort, decremental array");
     
		quickSort = new ArrayUtils(Arrays.copyOf(incremental,incremental.length));
		quickSort.quickSort();
		quickSort.results("QuickSort, incremental array");

		
		System.out.print("\n");
		ArrayUtils bubbleAdvanced = new ArrayUtils(Arrays.copyOf(random,random.length));
		bubbleAdvanced.sortBubbleAdvanced();      
		bubbleAdvanced.results("Bubble Advanced, random array");

		bubbleAdvanced = new ArrayUtils(Arrays.copyOf(decremental,decremental.length));
		bubbleAdvanced.sortBubbleAdvanced();      
		bubbleAdvanced.results("Bubble Advanced, decremental array");

		bubbleAdvanced = new ArrayUtils(Arrays.copyOf(incremental,incremental.length));
		bubbleAdvanced.sortBubbleAdvanced();      
		bubbleAdvanced.results("Bubble Advanced, шncremental array");
	}
}

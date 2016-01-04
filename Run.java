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
		array[array.length-45]=5;
	} 

	public static void main(String[] args)
	{
		int N = 100;
		int random[] = new int[N+1];
		int decremental[] = new int[N+1];
		int incremental[] = new int[N+1];
		FillRandom(random);
		FillDecremental(decremental);
		FillIncremental(incremental);
     
		System.out.println("Bubble Sorting classic");
		ArrayUtils bubbleClassic = new ArrayUtils(Arrays.copyOf(random,random.length));
		bubbleClassic.sortBubbleClassic();      
     
		bubbleClassic = new ArrayUtils(Arrays.copyOf(decremental,decremental.length));
		bubbleClassic.sortBubbleClassic();     
     
		bubbleClassic = new ArrayUtils(Arrays.copyOf(incremental,incremental.length));
		bubbleClassic.sortBubbleClassic();

		System.out.println("QuickSort");
		ArrayUtils quickSort = new ArrayUtils(Arrays.copyOf(random,random.length));
		quickSort.quickSort();      
     
		quickSort = new ArrayUtils(Arrays.copyOf(decremental,decremental.length));
		quickSort.quickSort();     
     
		quickSort = new ArrayUtils(Arrays.copyOf(incremental,incremental.length));
		quickSort.quickSort();

		
		System.out.println("Bubble Sorting Advanced");
		ArrayUtils bubbleAdvanced = new ArrayUtils(Arrays.copyOf(random,random.length));
		bubbleAdvanced.sortBubbleAdvanced();      

		bubbleAdvanced = new ArrayUtils(Arrays.copyOf(decremental,decremental.length));
		bubbleAdvanced.sortBubbleAdvanced();      

		bubbleAdvanced = new ArrayUtils(Arrays.copyOf(incremental,incremental.length));
		bubbleAdvanced.sortBubbleAdvanced();      
	}
}

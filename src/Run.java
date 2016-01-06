public class Run {    
	static public void fillRandom(int[] array) {
		for (int count=0; count < array.length; count++) {
			array[count] = (int)(Math.random()*100);
		}
	}
 
	static public void fillDecremental(int[] array) {
		for (int count=0; count < array.length; count++) {
			array[count] = array.length-count;
		}
	} 

	static public void fillIncremental(int[] array) {
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
		fillRandom(random);
		fillDecremental(decremental);
		fillIncremental(incremental);
     
		ArrayUtils bubbleClassic = new ArrayUtils(random);
		ArrayUtils quickSort = new ArrayUtils(random);
		ArrayUtils bubbleAdvanced = new ArrayUtils(random);
		ArrayUtils javaQuickSort = new ArrayUtils(random);

		bubbleClassic.sortBubbleClassic();
		bubbleClassic.results("Bubble Classic, random array");
     
		quickSort.quickSort();
		quickSort.results("QuickSort, random array");

		bubbleAdvanced.sortBubbleAdvanced();      
		bubbleAdvanced.results("Bubble Advanced, random array");
		
		javaQuickSort.javaQuickSort();
		javaQuickSort.results("Java sort, random array");

		System.out.print("\n");
		bubbleClassic = new ArrayUtils(decremental);
		quickSort = new ArrayUtils(decremental);
		bubbleAdvanced = new ArrayUtils(decremental);
		javaQuickSort = new ArrayUtils(decremental);

		bubbleClassic.sortBubbleClassic();
		bubbleClassic.results("Bubble Classic, decremental array");
     
		quickSort.quickSort();     
		quickSort.results("QuickSort, decremental array");

		bubbleAdvanced.sortBubbleAdvanced();      
		bubbleAdvanced.results("Bubble Advanced, decremental array");

		javaQuickSort.javaQuickSort();
		javaQuickSort.results("Java sort, decremental array");

		System.out.print("\n");
		bubbleClassic = new ArrayUtils(incremental);
		quickSort = new ArrayUtils(incremental);
		bubbleAdvanced = new ArrayUtils(incremental);
		javaQuickSort = new ArrayUtils(incremental);
		
		bubbleClassic.sortBubbleClassic();
		bubbleClassic.results("Bubble Classic, incremental array");
     
		quickSort.quickSort();
		quickSort.results("QuickSort, incremental array");

		bubbleAdvanced.sortBubbleAdvanced();      
		bubbleAdvanced.results("Bubble Advanced, incremental array");

		javaQuickSort.javaQuickSort();
		javaQuickSort.results("Java sort, incremental array");
	}
}

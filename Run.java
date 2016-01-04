public class Run {
	static ArrayUtils myArray = new ArrayUtils();
	
	public static void main(String[] args){
		long startTime, endTime;
		
		System.out.println("Bubble Sorting classic: random, fixed random, decremental");
		myArray.FillRandom();
		startTime = System.nanoTime();
		myArray.sortBubbleClassic();
		endTime = System.nanoTime();
		myArray.ShowResult(String.format("%, 12d",endTime-startTime));

		myArray.FillDecremental();
		startTime = System.nanoTime();
		myArray.sortBubbleClassic();
		endTime = System.nanoTime();
		myArray.ShowResult(String.format("%, 12d",endTime-startTime));

		System.out.println("Bubble Sorting advanced1: random, fixed random, decremental");
		myArray.FillRandom();
		startTime = System.nanoTime();
		myArray.sortBubbleAdvanced1();
		endTime = System.nanoTime();
		myArray.ShowResult(String.format("%, 12d",endTime-startTime));

		myArray.FillDecremental();
		startTime = System.nanoTime();
		myArray.sortBubbleAdvanced1();
		endTime = System.nanoTime();
		myArray.ShowResult(String.format("%, 12d",endTime-startTime));

		System.out.println("Bubble Sorting advanced2: random, fixed random, decremental");
		myArray.FillRandom();
		startTime = System.nanoTime();
		myArray.sortBubbleAdvanced2();
		endTime = System.nanoTime();
		myArray.ShowResult(String.format("%, 12d",endTime-startTime));

		myArray.FillDecremental();
		startTime = System.nanoTime();
		myArray.sortBubbleAdvanced2();
		endTime = System.nanoTime();
		myArray.ShowResult(String.format("%, 12d",endTime-startTime));
	}
}
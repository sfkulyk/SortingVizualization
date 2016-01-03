public class Run {
	static ArrayUtils myArray = new ArrayUtils();
	
	public static void main(String[] args){
		
		System.out.println("Bubble Sorting classic: fixed random, decremental");
		myArray.FillFixed();
		myArray.sortBubbleClassic();
		myArray.ShowResult();

		myArray.FillDecremental();
		myArray.sortBubbleClassic();
		myArray.ShowResult();

		System.out.println("Bubble Sorting advanced: fixed random, decremental");
		myArray.FillFixed();
		myArray.sortBubbleAdvanced();
		myArray.ShowResult();

		myArray.FillDecremental();
		myArray.sortBubbleAdvanced();
		myArray.ShowResult();
	}
}

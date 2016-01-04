/* Simple array sorting realization
 * 
 */
public class ArrayUtils {
	private static final int ARRAYSIZE=100000;
	static private int[] array=new int[ARRAYSIZE+1];
	private long switchCount=0, compareCount=0;
	
	public void FillRandom() {
		int count;
		for (count=0;count<=ARRAYSIZE;count++) {
			array[count]=(int)(Math.random()*100);
		}
	}
	
	public void FillDecremental() {
		for (int count=0;count<=ARRAYSIZE;count++) {
			array[count]=ARRAYSIZE-count;
		}
	}

	public void ShowArray() {
		int count;
		for (count=0;count<=ARRAYSIZE;count++) {
			System.out.println(count+"	"+array[count]);
		}
	}

	public void ShowResult(String message) {
		System.out.println("=-=-= Total: arraySize:"+ARRAYSIZE+",	switch:"+switchCount+",	compare:"+compareCount+"	"+message);
	}
	
	public void sortBubbleClassic(){
		int currentPosition=0;
		int maxPosition;
		int temp;
		switchCount=0;
		compareCount=0;
		
		for (maxPosition=ARRAYSIZE;maxPosition>=0;maxPosition--)
		{
			for (currentPosition=0;currentPosition<maxPosition;currentPosition++)
			{
				compareCount++;
				if (array[currentPosition] > array[currentPosition+1]){
					temp=array[currentPosition];
					array[currentPosition]=array[currentPosition+1];
					array[currentPosition+1]=temp;
					switchCount++;
				}
			}
		}
	}

	public void sortBubbleAdvanced1(){
		int currentPosition=0;
		int maxPosition;
		int temp;
		switchCount=0;
		compareCount=0;
		boolean changed;
		
		for (maxPosition=ARRAYSIZE;maxPosition>=0;maxPosition--)
		{
			changed=false;
			for (currentPosition=0;currentPosition<maxPosition;currentPosition++)
			{
				compareCount++;
				if (array[currentPosition] > array[currentPosition+1]){
					temp=array[currentPosition];
					array[currentPosition]=array[currentPosition+1];
					array[currentPosition+1]=temp;
					switchCount++;
					changed=true;
				}
			}
			if (changed==false) { return; }
		}
	}
	
	public void sortBubbleAdvanced2(){
		int currentPosition;
		int maxPosition;
		int minPosition=0;
		boolean changed;
		int temp;
		switchCount=0;
		compareCount=0;
		
		for (maxPosition=ARRAYSIZE;maxPosition>=0;maxPosition--)
		{
			changed=false;
			for (currentPosition=minPosition;currentPosition<maxPosition;currentPosition++)
			{
				if (array[currentPosition] > array[minPosition]){
					temp=array[minPosition];
					array[minPosition]=array[currentPosition]=temp;
					array[currentPosition]=temp;
					switchCount++;
					changed=true;
				}
				if (array[currentPosition] > array[currentPosition+1]){
					temp=array[minPosition];
					array[minPosition]=array[currentPosition]=temp;
					array[currentPosition]=temp;
					switchCount++;
					changed=true;
				}
				if (array[currentPosition+1] > array[maxPosition]){
					temp=array[minPosition];
					array[minPosition]=array[currentPosition]=temp;
					array[currentPosition]=temp;
					switchCount++;
					changed=true;
				}
				compareCount+=3;
			}
			if (changed==false) { return; }
			minPosition++;
		}
	}
}


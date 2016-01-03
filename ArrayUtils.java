public class ArrayUtils {
	private static final int ARRAYSIZE=100;
	static private int[] array=new int[ARRAYSIZE+1];
	
	private int switchCount=0, compareCount=0;
	public Boolean debug=false;
	
	private int compareValue(int index1, int index2)	{
        if (debug) { System.out.println("PROCESS: compare   array["+index1+"]("+array[index1]+") and array["+index2+"]("+array[index2]+")"); }
		compareCount++;
		if (array[index1]>array[index2]) {return 1;}
		if (array[index1]<array[index2]) {return -1;}
		return 0;
	}
	
	private void switchValue(int index1, int index2)	{
		int temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
		switchCount++;
		if (debug) { System.out.println("PROCESS: switch    array["+index1+"]("+temp+") and array["+index2+"]("+array[index1]+")");}
	}
	
	public void FillRandom() {
		int count;
		for (count=0;count<=ARRAYSIZE;count++) {
			array[count]=(int)(Math.random()*100);
		}
		switchCount=compareCount=0;
	}
	
	public void FillFixed() {
		int temp[] = {20, 71, 73, 2, 92, 24, 94, 68, 26, 82, 10, 39, 86, 33, 89, 77, 21, 53, 75, 62, 94, 23, 81, 74, 6, 64, 29, 14, 82, 20, 50, 69, 6, 80, 60, 91, 74, 39, 71, 86, 64, 95, 80, 78, 21, 28, 31, 46, 60, 99, 39, 24, 72, 53, 5, 17, 79, 48, 12, 40, 16, 88, 4, 37, 57, 51, 43, 67, 15, 39, 38, 66, 1, 67, 40, 43, 50, 19, 49, 21, 53, 97, 53, 91, 39, 58, 16, 0, 41, 9, 80, 79, 23, 6, 39, 6, 41, 29, 84, 38, 9};
		int count;
		for (count=0;count<=ARRAYSIZE;count++){
			array[count]=temp[count];
		}
		switchCount=compareCount=0;
	}
	
	public void FillWith(int value) {
		for (int count=0;count<=ARRAYSIZE;count++) {
			array[count]=value;
		}
		switchCount=compareCount=0;
	}
	
	public void FillDecremental() {
		for (int count=0;count<=ARRAYSIZE;count++) {
			array[ARRAYSIZE-count]=count;
		}
		switchCount=compareCount=0;
	}

	public void FillIncremental() {
		int count;
		for (count=0;count<=ARRAYSIZE;count++) {
			array[count]=count;
		}
		switchCount=compareCount=0;
	}
	
	public void ShowArray() {
		int count;
		for (count=0;count<=ARRAYSIZE;count++) {
			System.out.println(count+"	"+array[count]);
		}
	}

	public void ShowResult() {
		System.out.println("=-=-= Total: arraySize:"+ARRAYSIZE+",	switch:"+switchCount+",	compare:"+compareCount);
	}
	
	public void sortBubbleClassic(){
		int currentPosition=0;
		int maxPosition;
		boolean changed;
		
		for (maxPosition=ARRAYSIZE;maxPosition>=0;maxPosition--)
		{
			changed=false;
			for (currentPosition=0;currentPosition<maxPosition;currentPosition++)
			{
				if (compareValue(currentPosition, currentPosition+1)>0){
					switchValue(currentPosition, currentPosition+1);
					changed=true;
				}
			}
			if (changed==false) { return; }
		}
	}
	
	public void sortBubbleAdvanced(){
		int currentPosition;
		int maxPosition;
		int minPosition=0;
		boolean changed;
		
		for (maxPosition=ARRAYSIZE;maxPosition>=0;maxPosition--)
		{
			changed=false;
			for (currentPosition=minPosition;currentPosition<maxPosition;currentPosition++)
			{
				if (compareValue(minPosition, currentPosition)>0){
					switchValue(minPosition, currentPosition);
					changed=true;
				}
				if (compareValue(currentPosition, currentPosition+1)>0){
					switchValue(currentPosition, currentPosition+1);
					changed=true;
				}
				if (compareValue(currentPosition+1, maxPosition)>0){
					switchValue(currentPosition+1, maxPosition);
					changed=true;
				}
			}
			if (changed==false) { return; }
			minPosition++;
		}
	}
}


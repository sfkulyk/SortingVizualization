package org.sfkulyk;
import java.util.Arrays;

public class ArrayUtils {
	final private int[] array;
	final private int[] sortedArray;
	long switchCount, compareCount, timeAmount;
 
	public ArrayUtils(int[] array) {
		this.array = Arrays.copyOf(array,array.length);
		this.sortedArray=Arrays.copyOf(array,array.length);     
		Arrays.sort(sortedArray);
	}
 
	void results(String text)
	{
		System.out.println(String.format("%-35s Compares: %, 15d, Switches: %, 15d, Time: %, 15d", text, compareCount, switchCount, timeAmount));
	}
	
	boolean validate() 
	{
		if (Arrays.equals(array,sortedArray))
				return true;
		return false;
	}
 
	public void sortBubbleClassic() {
		int currentPosition;
		int maxPosition;
		int temp;
		switchCount=0;
		compareCount=0;
//		timeAmount = System.nanoTime();  
  
		for (maxPosition=array.length - 1; maxPosition >= 0;maxPosition--)
		{
			for (currentPosition = 0; currentPosition < maxPosition; currentPosition++)
			{
				compareCount++;
				if (array[currentPosition] > array[currentPosition+1]){
					temp = array[currentPosition];
					array[currentPosition] = array[currentPosition+1];
					array[currentPosition+1] = temp;
					switchCount++;
				}
			}
		}
//		timeAmount = System.nanoTime() - timeAmount;
		assert(validate());
		return;
	}

	public void sortBubbleAdvanced(){
		int currentPosition;
		int maxPosition;
		int changedMaxPosition = array.length - 1;
		int minPosition = 0;
		boolean changed;
		int temp;
		switchCount = 0;
		compareCount = 0;
//		timeAmount = System.nanoTime();
		
		for (maxPosition = array.length - 1; maxPosition >= 0; minPosition++)
		{
			changed=false;
			for (currentPosition = minPosition; currentPosition < maxPosition; currentPosition++)
			{
				if (array[currentPosition] > array[currentPosition+1]){
					temp = array[currentPosition+1];
					array[currentPosition+1] = array[currentPosition];
					array[currentPosition] = temp;
					switchCount++;
					changed=true;
					changedMaxPosition = currentPosition;
				}
				if (array[currentPosition] < array[minPosition]){
					temp = array[minPosition];
					array[minPosition] = array[currentPosition];
					array[currentPosition] = temp;
					switchCount++;
					changed=true;
				}
				if (array[currentPosition] > array[maxPosition]){
					temp = array[maxPosition];
					array[maxPosition] = array[currentPosition];
					array[currentPosition] = temp;
					switchCount++;
					changed=true;
				}
				compareCount+=3;
			}
			if (!changed) {
				timeAmount=System.nanoTime()-timeAmount;
				assert(validate());
				return;
			}
			compareCount++;
			maxPosition = changedMaxPosition;
		}
//		timeAmount=System.nanoTime()-timeAmount;
		assert(validate());
		return;
	}

	public void sortJavaQuickSort() {
//    	timeAmount = System.nanoTime();
    	Arrays.sort(array);
//	timeAmount = System.nanoTime() - timeAmount;
        assert(validate());
    }

	public void sortQuickSort() {
//    	timeAmount = System.nanoTime();
		switchCount = 0;
		compareCount = 0;
        doQuickSort(0, array.length - 1);
//        timeAmount = System.nanoTime() - timeAmount;
        assert(validate());
    }

    private void doQuickSort(int startPosition, int lastPosition) {
        if (startPosition >= lastPosition) {
        	compareCount++;
            return;
        }
        int tempStartPosition = startPosition, tempLastPosition = lastPosition;
        int currentPosition = tempStartPosition - (tempStartPosition - tempLastPosition) / 2;
        while (tempStartPosition < tempLastPosition) {
            while (tempStartPosition < currentPosition && (array[tempStartPosition] <= array[currentPosition])) {
            	compareCount++;
            	tempStartPosition++;
            }
            while (tempLastPosition > currentPosition && (array[currentPosition] <= array[tempLastPosition])) {
            	compareCount++;
            	tempLastPosition--;
            }
            if (tempStartPosition < tempLastPosition) {
                int temp = array[tempStartPosition];
                array[tempStartPosition] = array[tempLastPosition];
                array[tempLastPosition] = temp;
                switchCount++;
                if (tempStartPosition == currentPosition)
                	currentPosition = tempLastPosition;
                else if (tempLastPosition == currentPosition){
                	currentPosition = tempStartPosition;
                	compareCount++;
                }
                compareCount++;
            }
            compareCount++;
        }
        doQuickSort(startPosition, currentPosition);
        doQuickSort(currentPosition + 1, lastPosition);
    }
}
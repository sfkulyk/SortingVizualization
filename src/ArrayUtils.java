
import java.util.Arrays;

public class ArrayUtils {
	final private int[] array;
	final private int[] sortedArray;
	long switchCount, compareCount, time;
 
	public ArrayUtils(int[] array) {
		this.array = array;
		this.sortedArray=Arrays.copyOf(array,array.length);     
		Arrays.sort(sortedArray);
	}
 
	void results(String text)
	{
		System.out.println(String.format("%-40s Compares: %, 12d, Switches: %, 12d, Time: %, 12d", text, compareCount, switchCount, time));
	}
	
	boolean validate() 
	{
		for (int i = 1; i < array.length; ++i) {
			if (array[i] != sortedArray[i]) {
				System.out.println(Arrays.toString(array));
				return false;
			}
		}
		return true;
	}
 
	public void sortBubbleClassic() {
		int currentPosition;
		int maxPosition;
		int temp;
		switchCount=0;
		compareCount=0;
		time = System.nanoTime();  
  
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
		time = System.nanoTime() - time;
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
		time = System.nanoTime();
		
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
				time=System.nanoTime()-time;
				assert(validate());
				return;
			}
			compareCount++;
			maxPosition = changedMaxPosition;
		}
		time=System.nanoTime()-time;
		assert(validate());
		return;
	}

    public void quickSort() {
    	time = System.nanoTime();
		switchCount = 0;
		compareCount = 0;
        doQuickSort(0, array.length - 1);
        time = System.nanoTime() - time;
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
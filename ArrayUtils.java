import java.util.Arrays;

public class ArrayUtils {
	final private int ARRAYSIZE; 
	final private int[] array;
	long switchCount, compareCount;
	
	public ArrayUtils(int[] array) {
		this.array = array;
		this.ARRAYSIZE = array.length;     
	}
 
	boolean validate() 
	{
		int prev = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (prev > array[i]) {
				print();
				return false;
			}
			prev=array[i];
		}
		return true;
	}
 
	void print() 
	{
		System.out.println(Arrays.toString(array));
	}
	
	void results(long startTime)
	{
		System.out.println(String.format("Compares: %15d, Switches: %15d, Time: %, 12d",compareCount, switchCount, System.nanoTime()-startTime));
	}
	
	public void sortBubbleClassic() {
		int currentPosition;
		int maxPosition;
		int temp;
		switchCount=0;
		compareCount=0;
		long startTime = System.nanoTime();  
  
		for (maxPosition=ARRAYSIZE - 1; maxPosition >= 0;maxPosition--)
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
		results(startTime);
		assert(validate());
		return;
	}

	public void sortBubbleAdvanced(){
		int currentPosition;
		int maxPosition;
		int changedMaxPosition=ARRAYSIZE - 1;
		int minPosition=0;
		boolean changed;
		int temp;
		switchCount=0;
		compareCount=0;
		long startTime = System.nanoTime();
		
		for (maxPosition = ARRAYSIZE - 1; maxPosition >= 0; minPosition++)
		{
			changed=false;
			for (currentPosition = minPosition; currentPosition < maxPosition; currentPosition++)
			{
				if (array[currentPosition] > array[currentPosition+1]){
					temp=array[currentPosition+1];
					array[currentPosition+1]=array[currentPosition];
					array[currentPosition]=temp;
					switchCount++;
					changed=true;
					changedMaxPosition=currentPosition;
				}
				if (array[currentPosition] < array[minPosition]){
					temp=array[minPosition];
					array[minPosition] = array[currentPosition];
					array[currentPosition] = temp;
					switchCount++;
					changed=true;
				}
				if (array[currentPosition] > array[maxPosition]){
					temp=array[maxPosition];
					array[maxPosition]=array[currentPosition];
					array[currentPosition]=temp;
					switchCount++;
					changed=true;
				}
				compareCount+=3;
			}
			if (!changed) {
				results(startTime);
				assert(validate());
				return;
			}
			compareCount++;
			maxPosition=changedMaxPosition;
		}
		results(startTime);
		assert(validate());
		return;
	}

	
    public void quickSort() {
    	long startTime = System.nanoTime();
		switchCount=0;
		compareCount=0;
        doQuickSort(0, array.length - 1);
        results(startTime);
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
            	tempStartPosition++;
            }
            while (tempLastPosition > currentPosition && (array[currentPosition] <= array[tempLastPosition])) {
            	tempLastPosition--;
            }
            if (tempStartPosition < tempLastPosition) {
                int temp = array[tempStartPosition];
                array[tempStartPosition] = array[tempLastPosition];
                array[tempLastPosition] = temp;
                switchCount++;
                if (tempStartPosition == currentPosition)
                	currentPosition = tempLastPosition;
                else if (tempLastPosition == currentPosition)
                	currentPosition = tempStartPosition;
                compareCount++;
            }
            compareCount++;
        }
        doQuickSort(startPosition, currentPosition);
        doQuickSort(currentPosition + 1, lastPosition);
    }
}
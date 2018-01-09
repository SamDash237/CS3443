import java.util.Arrays;

/**
 * This class synchronizes and sorts threads by value
 * @author eeo072
 *
 */
public class SortingThread implements Runnable{
	private int threadNum;
	private int[] arrayVal;
	private SortingBuffer buf;
	
	public SortingThread(int i, int[] array, SortingBuffer buf){
		threadNum = i;
		arrayVal = array;
		this.buf = buf;
	}
	/**
	 * This method prints out unsynchronized thread values, then it prints out synchronized thread values
	 */
	public void run(){
		Arrays.sort(arrayVal);
		for(int j : arrayVal)
			System.out.printf("%d unsynchronized %d\n",threadNum, j);
		try{
			for(int a : arrayVal){
				buf.waitUntilMinimum(threadNum, a);
				System.out.printf("%d synchronized %d\n",threadNum, a);
			}
			buf.finished(threadNum);
	} catch(InterruptedException e){
		System.err.println(e);
	}
}
}

import java.util.ArrayList;

/**
 * ThreadCheckArray implements the logic for finding a subset sum in a 
 * multithreaded environment. Each instance runs as a separate thread 
 * exploring a specific branch of the recursion tree.
 * @author Adi
 * @version 1.0
 */
public class ThreadCheckArray implements Runnable 
{
	private boolean flag;
	private boolean [] winArray;
	SharedData sd;
	ArrayList <Integer> array; //changed to Arraylist
	int b;
	
	/**
	 * @param sd the SharedData object
	 * constructor - copy the array and target from SharedData
	 */
	public ThreadCheckArray(SharedData sd) 
	{
		this.sd = sd;	
		synchronized (sd) 
		{
			array = sd.getArray(); 
			b = sd.getB();
		}		
		winArray = new boolean[array.size()]; 
	}
	
	/**
	 * Recursively searches for a subset of elements that sums up to the target value 'b'.
	 * @param n - The current number of element in the array
	 * @param b - The remaining target sum to search
	 */
	void rec(int n, int b)
	{
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		if (n == 1)
		{
			if(b == 0 || b == array.get(n-1))
			{
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}			
			}
			if (b == array.get(n-1))
				winArray[n-1] = true;
			return;
		}
		
		rec(n-1, b - array.get(n-1));
		if (flag)
			winArray[n-1] = true;
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		rec(n-1, b);
	}

	/**
	 * Executes the subset sum search in a separate thread.
	 * The search space is divided based on the thread name:
	 * "thread1" starts the recursion including the last element,
	 * while other threads start by excluding it.
	 * Results and early termination flags are synchronized via SharedData.
	 */
	public void run() {
		if (array.size() != 1)
			if (Thread.currentThread().getName().equals("thread1"))
				rec(array.size()-1, b - array.get(array.size() - 1));
			else 
				rec(array.size()-1, b);
		if (array.size() == 1)
			if (b == array.get(0) && !flag)
			{
				winArray[0] = true;
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}
			}
		if (flag)
		{
			if (Thread.currentThread().getName().equals("thread1"))
				winArray[array.size() - 1] = true;
			synchronized (sd) 
			{
				sd.setWinArray(winArray);
			}	
		}
	}
}

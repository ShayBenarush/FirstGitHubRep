import java.util.ArrayList; //imported arraylist 

/**
 * hold the shared data for the threads
 * has an array to process and a target value to search
 * flag signals completion and result array
 * 
 * @author Ron
 * @version 1.0
 */
public class SharedData 
{
	private ArrayList <Integer> array; //changed to arraylist
	private boolean [] winArray;
	private boolean flag;
	private final int b;
	
	//updated constructor
	/**
	 * @param array the list of integers to process
	 * @param b the target value to search for
	 */
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b;
	}

	/**
	 * @return the winArray of solution found
	 */
	public boolean[] getWinArray() 
	{
		return winArray;
	}

	/**
	 * @param winArray boolean array indicating which elements of the input array are part of the solution
	 */
	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}

	/**
	 * @return the array as an ArrayList of Integer
	 */
	public ArrayList<Integer> getArray() //updated to arraylist
	{
		return array;
	}

	/**
	 * @return the target integer b
	 */
	public int getB() 
	{
		return b;
	}

	/**
	 * @return true if the target value was found, false otherwise
	 */
	public boolean getFlag() 
	{
		return flag;
	}

	/**
	 * @param flag true if the target value was found, false otherwise
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}

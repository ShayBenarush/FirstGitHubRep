import java.util.ArrayList; //imported arraylist 

public class SharedData 
{
	private ArrayList <Integer> array; //changed to arraylist
	private boolean [] winArray;
	private boolean flag;
	private final int b;
	
	//updated constructor
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b;
	}

	public boolean[] getWinArray() 
	{
		return winArray;
	}

	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}

	public ArrayList<Integer> getArray() //updated to arraylist
	{
		return array;
	}

	public int getB() 
	{
		return b;
	}

	public boolean getFlag() 
	{
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}

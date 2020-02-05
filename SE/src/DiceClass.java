import java.util.Random; 

public class DiceClass {
	
	private int dieFace;			//The face that the user "rolls"
	public static int dieSides = 6;		//The amount of sides on the die
	Random rand = new Random(); 	//New random 
	
	public void roll()
	{
		//Generate random dice value from 1 - 6
		dieFace = rand.nextInt(dieSides) + 1; 
	}
	
	public int getDieFace()
	{
		return dieFace; 
	}
	

}

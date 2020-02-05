public class SetOfDice {
	
	public static int totalDice = 5;							//Total dice used in Yahtzee
	//private int playerChoice;
	private int[] setDice = new int[totalDice]; 		//Set of 5 dice
	DiceClass die = new DiceClass(); 
	
	//Roll first set of dice 
	public void rollDice()
	{
		for (int i = 0; i < totalDice; i++)
		{
			die.roll();
			setDice[i] = die.getDieFace(); 
		}
	}
	
	//Print out rolled set for user to see
	public void printSet()
	{
		for (int i = 0; i <totalDice; i++)
		{
			System.out.print(setDice[i] + " "); 
		}
		
		System.out.println(); 
	}
	
	//Re-roll any dice that the user wants to re-roll 
	public void rerollDice(String[] splitChoice)
	{
		for (int i = 0; i < totalDice; i++)
		{
			//If there is an 'R' in the array passed in, re-roll that specific die 
			if (splitChoice[i].equals("R"))
			{
				die.roll(); 
				setDice[i] = die.getDieFace();
			}
		}
	}
	
	public int[] getSet()
	{
		return setDice; 
	}
}

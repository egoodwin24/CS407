
public class ScoreCard {
	private int numChoices = 13;							
	private int[] scores = new int[numChoices]; 
	private int[] diceValueCounter = {0,0,0,0,0,0}; 
	private boolean[] cardFilled = new boolean[numChoices]; 					//make 13 length 
	
	public void validate(int choice, int[] setDice)
	{
		
		//add for loop to count how many 1-6s rolled 
		for (int i = 0; i < SetOfDice.totalDice; i++)
		{
			if (setDice[i] == 1)
			{
				diceValueCounter[0]++; 
			}
			
			else if (setDice[i] == 2)
			{
				diceValueCounter[1]++; 
			}
			
			else if (setDice[i] == 3)
			{
				diceValueCounter[2]++; 
			}
			
			else if (setDice[i] == 4)
			{
				diceValueCounter[3]++; 
			}
			
			else if (setDice[i] == 5)
			{
				diceValueCounter[4]++; 
			}
			
			else if (setDice[i] == 6)
			{
				diceValueCounter[5]++; 
			}
		}
		
		if (Choices.values()[choice -1].equals(Choices.ONES))	
		{
			//CHECK IF ITS ALREADY BEEEN ENTERED
			/*if (cardFilled[choice-1] != true)
			{
				cardFilled[choice-1] = true; 
			}*/ 
			
			scores[choice-1] = diceValueCounter[choice-1] * choice; 
			
		}
		
		else if (Choices.values()[choice -1].equals(Choices.TWOS))	
		{
			//CHECK IF ITS ALREADY BEEEN ENTERED
			scores[choice-1] = diceValueCounter[choice-1] * choice; 
		}
		
		else if (Choices.values()[choice -1].equals(Choices.THREES))	
		{
			//CHECK IF ITS ALREADY BEEEN ENTERED
			scores[choice-1] = diceValueCounter[choice-1] * choice; 
		}
		
		else if (Choices.values()[choice -1].equals(Choices.FOURS))	
		{
			//CHECK IF ITS ALREADY BEEEN ENTERED
			scores[choice-1] = diceValueCounter[choice-1] * choice; 
		}
		
		else if (Choices.values()[choice -1].equals(Choices.FIVES))	
		{
			//CHECK IF ITS ALREADY BEEEN ENTERED
			scores[choice-1] = diceValueCounter[choice-1] * choice; 
		}
		
		else if (Choices.values()[choice -1].equals(Choices.SIXES))	
		{
			//CHECK IF ITS ALREADY BEEEN ENTERED
			scores[choice-1] = diceValueCounter[choice-1] * choice; 
		}
		
		else if (Choices.values()[choice -1].equals(Choices.THREE_OF_KIND))	
		{
			for (int i = 0; i < diceValueCounter.length; i++)
			{
				if (diceValueCounter[i] >= 3)
				{
					scores[choice-1] = setDice[0] + setDice[1] + 
							setDice[2] + setDice[3] + setDice[4];
				}
				
				else
				{
					scores[choice-1] = 0;
				}
			}
			
		}
		
		else if (Choices.values()[choice -1].equals(Choices.FOUR_OF_KIND))	
		{
			for (int i = 0; i < diceValueCounter.length; i++)
			{
				if (diceValueCounter[i] >= 4)
				{
					scores[choice-1] = setDice[0] + setDice[1] + 
							setDice[2] + setDice[3] + setDice[4];
				}
				
				else
				{
					scores[choice-1] = 0;
				}
			}
			
		}
		
		else if (Choices.values()[choice -1].equals(Choices.FULL_HOUSE))	
		{
			if (diceValueCounter[0] == 3 || diceValueCounter[1] == 3 || diceValueCounter[2] == 3 ||
					diceValueCounter[3] == 3 || diceValueCounter[4] == 3 || diceValueCounter[5] == 3 
					&& (diceValueCounter[0] == 2 || diceValueCounter[1] == 2 || diceValueCounter[2] == 2
					|| diceValueCounter[3] == 2 || diceValueCounter[4] == 2 || diceValueCounter[5] == 2))
			{
				scores[choice-1] = 25;
				System.out.println("reached"); 
			}
			
			else
			{
				scores[choice-1] = 0;
			}
		}
		
		else if (Choices.values()[choice -1].equals(Choices.SMALL_STRAIGHT))
		{
			if (diceValueCounter[0] >= 1 && diceValueCounter[1] >= 1 && diceValueCounter[2] >= 1 &&
					diceValueCounter[3] >= 1 || (diceValueCounter[1] >= 1 && diceValueCounter[2] >= 1 
					&& diceValueCounter[3] >= 1 && diceValueCounter[4] >= 1 ) || (diceValueCounter[2] >= 
					1 && diceValueCounter[3] >= 1 && diceValueCounter[4] >= 1 && diceValueCounter[5] >= 1))
			{
				scores[choice-1] = 30;
			}
			
			else
			{
				scores[choice-1] = 0;
			}
		}
		
		else if (Choices.values()[choice -1].equals(Choices.LARGE_STRAIGHT))
		{
			if (diceValueCounter[0] == 1 && diceValueCounter[1] == 1 && diceValueCounter[2] == 1 &&
					diceValueCounter[3] == 1 && diceValueCounter[5] == 1 && diceValueCounter[5] == 1)
			{
				scores[choice-1] = 40;
			}
			
			else
			{
				scores[choice-1] = 0;
			}
		}
		
		else if (Choices.values()[choice -1].equals(Choices.YAHTZEE))
		{
			for (int i = 0; i < diceValueCounter.length; i++)
			{
				if (diceValueCounter[i] >= 5)
				{
					scores[choice-1] = 50; 
				}
				
				else
				{
					scores[choice-1] = 0;
				}
			}
		}
		
		else if (Choices.values()[choice -1].equals(Choices.CHANCE))
		{
			scores[choice-1] = setDice[0] + setDice[1] + 
					setDice[2] + setDice[3] + setDice[4];
		}
		
		
		
	}
	
	public void printCard()
	{
		for (int i = 0; i < numChoices; i++)
		{
			System.out.println("SC" + scores[i]);
		}
	}
}

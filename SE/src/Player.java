import java.util.Scanner;			//Eventually move to main 
public class Player {
	
	SetOfDice sod = new SetOfDice();
	ScoreCard sc = new ScoreCard(); 
	Scanner s = new Scanner(System.in);
	private int maxRerolls = 2;					//Amount of times a user can reroll in Yahtzee per turn
	private String playerChoice;				//User input to hold if they want to reroll or hold	
	private boolean validate;					//Boolean used to validate if user's input is correct 
	private String[] splitChoice; 				//Array to hold split string to get user input
	private int choice; 
	private int[] setofDice; 
	
	//Roll first set of dice 
	public void rollDice()
	{
		sod.rollDice();
		sod.printSet();
		System.out.println("You have 2 rerolls remaining"); 
	}
	
	//Ask user if they would like to re-roll and validate that input
	public void askReroll()
	{
		//playerChoice = null; 
		System.out.print("What dice would you like to reroll?");
		System.out.println(" Enter H for Hold and R for Reroll, sperated by ,");
		playerChoice = s.nextLine();
		splitChoice = playerChoice.split(",");
		
		//Validate user input to see if they entered H for Hold or
		//R for Re-roll
		for (int i = 0; i < 5; i++)
		{
			if (splitChoice[i].equals("H") || (splitChoice[i].equals("R")))
			{
				validate = true;
			}
			
			//If a wrong char is entered, break validation loop and re-prompt for a valid input
			else
			{
				validate = false;
				System.out.println("Please enter a valid response");
				System.out.print("What dice would you like to reroll?");
				System.out.println(" Enter H for Hold and R for Reroll, sperated by ,");
				playerChoice = s.nextLine();
				splitChoice = playerChoice.split(",");
			}
		}
		
		rerollDice(splitChoice);
	}
	
	//Re-roll any dice user chose to re-roll
	public void rerollDice(String[] splitChoice)
	{
			//pass array to Set of Dice class to re-roll dice
			sod.rerollDice(splitChoice);
			sod.printSet();
	}
	
	public void makeChoice()
	{
		setofDice = sod.getSet(); 
		System.out.println("What do you want to enter your set of dice as?"); 
		choice = s.nextInt();
		
		sc.validate(choice, setofDice); 
		sc.printCard();
	}
}


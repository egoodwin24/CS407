
public class YahtzeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p = new Player(); 
		
		for (int i = 0; i < 13; i++)
		{
			p.rollDice();
			
			for (int j = 0; j < 2; j++)
			{
				p.askReroll();
				System.out.println("You have " + (1-j) + " reroll(s) remaining"); 
			}
			
			p.makeChoice(); 
		}
	}

}

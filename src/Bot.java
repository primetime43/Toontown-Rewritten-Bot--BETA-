import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
public class Bot extends Gardening
{
	public Bot() throws AWTException 
	{
		robot = new Robot();
		createGardeningMap();
	}

	public void startBot()
	{
		showMessageBox("Starting login process 5 seconds after OK is clicked!");
		makeBotSleep(5);
		startGameAndLogin();//searches the game and opens it to login
		robot.delay(10000);//after login; needs to load
		maximizeWindow();
		selectToon();
	}
	
	public void keepToonAwake()
	{
		String sleep = "";
		showMessageBox("This will prevent your toon from falling asleep!");
		int min = requestInput("How many minutes do you wish to keep your toon awake for?");
		BotFunctions.writeToLogFile("Making bot sleep for " + min + " minutes");
		showMessageBox("Starting bot 5 seconds after OK is clicked!");
		makeBotSleep(5);
		while(!sleep.equals("QUIT"))
		{
			robot.keyPress(KeyEvent.VK_CONTROL);
			makeBotSleep(min*60);
			sleep = "QUIT";
		}
	}
	
	public void spam()
	{
		showMessageBox("This will spam the screen with whatever message you enter! (Please don't abuse others with this!)");
		String message = requestSpamInput();
		int count = requestInput("How many times do you wish to spam your message?");
		
		showMessageBox("Starting spam bot 5 seconds after OK is clicked!");
		writeToLogFile("Spamming " + message + " " + count + " times ");
		makeBotSleep(5);
		for(int i = 0; i < count; i++)
		{
			typeSentenceInGame(message);
			makeBotSleep(1);//time between each message
		}
	}

	public void goGardening()
	{
		showMessageBox("Make sure you are at a flower pot before starting the bot!");
		String[] act = {"PLANT FLOWER", "REMOVE FLOWER", "JUST WATER"};
		String selectedAct = (String) JOptionPane.showInputDialog(null, "Choose an activity...", "Select an activity", JOptionPane.PLAIN_MESSAGE, null, act, act[0]);
		if(selectedAct != null)
		{
			writeToLogFile("Activity chosen: " + selectedAct);
			createGardeningMenu(selectedAct);
		}
		else
			return;
	}

	public void goFishing()
	{
		showMessageBox("Make sure you are in the correct dock with your fishing rod out and your bucket is empty before starting fishing bot!");
		String[] fishingLocations = {"TOONTOWN CENTRAL PUNCHLINE PLACE", "DONALD DREAM LAND LULLABY LANE", "BRRRGH POLAR PLACE", "BRRRGH WALRUS WAY", "BRRRGH SLEET STREET", "MINNIE'S MELODYLAND TENOR TERRACE", "DONALD DOCK LIGHTHOUSE LANE", "DAISY'S GARDEN ELM STREET", "FISH ANYWHERE"};
		String selectedLocation = (String) JOptionPane.showInputDialog(null, "Choose a fishing dock...", "Select a location to fish", JOptionPane.PLAIN_MESSAGE, null, fishingLocations, fishingLocations[0]);
		if(selectedLocation != null)
		{
			writeToLogFile("Fishing at : " + selectedLocation);
			createFishingMenu(selectedLocation);
		}
		else
			return;
	}

	private void createGardeningMenu(String activity)
	{
		switch(activity)
		{
		case "PLANT FLOWER":
			startPlanting();
			break;
		case "REMOVE FLOWER":
			removePlant();
			break;
		case "JUST WATER":
			waterPlant();
			break;
		default:
			return;
		}
	}

	private void createFishingMenu(String location)
	{
		int numberOfTimesToSellToFisherman = 0;
		int numberOfCasts = requestInput("How many times would you like to cast your rod?");
		if(!location.equals("FISH ANYWHERE"))
			numberOfTimesToSellToFisherman = requestInput("How many times would you like to sell to the fisherman while fishing?");
		writeToLogFile("Casting fishing rod " + numberOfCasts + " times\n" + "Selling to fisherman " + numberOfTimesToSellToFisherman + " times");
		while(numberOfCasts <= 0 || numberOfCasts > 20)
		{
			showMessageBox("You must enter a number greater than 0 and a number no greater than 20! (1-20)");
			numberOfCasts = requestInput("How many times would you like to cast your rod?");
		}
			fishByNumberOfCasts(numberOfCasts, numberOfTimesToSellToFisherman, location);
		writeToLogFile("Done Fishing!");
	}

	private void fishByNumberOfCasts(int numberOfCasts, int numberOfTimesToSellToFisherman, String location)
	{
		switch(location)
		{
		case "TOONTOWN CENTRAL PUNCHLINE PLACE":
			showMessageBox("Fishes in the first dock when you walk in");
			for(int i = 0; i < numberOfTimesToSellToFisherman; i++)
				fishTTCPunchlinePlace(numberOfCasts);
			break;
		case "DONALD DREAM LAND LULLABY LANE":
			showMessageBox("Fishes in the dock to the left of the box");
			for(int i = 0; i < numberOfTimesToSellToFisherman; i++)
				fishDDLLullabyLane(numberOfCasts);
			break;
		case "BRRRGH POLAR PLACE":
			showMessageBox("Fishes in the top right dock");
			for(int i = 0; i < numberOfTimesToSellToFisherman; i++)
				fishBrrrghPolarPlace(numberOfCasts);
			break;
		case "MINNIE'S MELODYLAND TENOR TERRACE":
			showMessageBox("Fishes in the top left dock");
			for(int i = 0; i < numberOfTimesToSellToFisherman; i++)
				fishMMTenorTerrace(numberOfCasts);
			break;
		case "DONALD DOCK LIGHTHOUSE LANE":
			showMessageBox("Fishes in the 2nd one on the right");
			for(int i = 0; i < numberOfTimesToSellToFisherman; i++)
				fishDDLighthouseLane(numberOfCasts);
			break;
		case "BRRRGH WALRUS WAY":
			showMessageBox("Fishes in the top left dock");
			for(int i = 0; i < numberOfTimesToSellToFisherman; i++)
				fishBrrrghWalrusWay(numberOfCasts);
			break;
		case "BRRRGH SLEET STREET":
			showMessageBox("Fishes in the first dock when you walk in");
			for(int i = 0; i < numberOfTimesToSellToFisherman; i++)
				fishBrrrghSleetSt(numberOfCasts);
			break;
		case "DAISY'S GARDEN ELM STREET":
			showMessageBox("Fishes in the first dock on the left");
			for(int i = 0; i < numberOfTimesToSellToFisherman; i++)
				fishDaisyGardenElmSt(numberOfCasts);
			break;
		case "FISH ANYWHERE":
			showMessageBox("When fishing anywhere, the bot will only fish for you, it will not sell to the fisherman!");
			fishAnywhere(numberOfCasts);
			break;
		default:
			JOptionPane.showMessageDialog(parent, "There's been an error. Exiting the application.");
			System.exit(0);
		}
	}
}

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
public class Fishing extends StartToonTownRewritten
{
	/*
	 * To begin fishing, step onto the desired fishing platform and start the correct fishing location method.
	 */
	private int countCasts = 0;

	//Fishing location 1
	protected void fishTTCPunchlinePlace(int numberOfCasts)//fishes in the first dock when you walk in
	{
		castLineToFish(numberOfCasts);//cast line at dock to begin fishing
		goSellFishTTCPunchlinePlace();//leave dock to go to fisherman and sell the fish
		goBackToTTCPunchlinePlaceFishingDock();//leave fisherman to go back to fishing dock
		return;
	}

	//Fishing location 2
	protected void fishDDLLullabyLane(int numberOfCasts)//fishes in the dock to the left of the box
	{
		castLineToFish(numberOfCasts);
		goSellFishDDLLullabyLane();
		goBackToDDLLullabyLaneFishingDock();
		return;
	}

	//Fishing location 3
	protected void fishBrrrghPolarPlace(int numberOfCasts)//fishes in the top right dock
	{
		castLineToFish(numberOfCasts);
		goSellFishBrrrghPolarPlace();
		goBackToBrrrghPolarPlaceFishingDock();
		return;
	}

	//Fishing location 4
	protected void fishMMTenorTerrace(int numberOfCasts)//fishes in the top left dock
	{
		castLineToFish(numberOfCasts);
		goSellFishMMTenorTerrace();
		goBackToMMTenorTerraceFishingDock();
		return;
	}

	//Fishing location 5
	protected void fishDDLighthouseLane(int numberOfCasts)//fishes in the 2nd one on the right
	{
		castLineToFish(numberOfCasts);
		goSellFishDDLighthouseLane();
		goBackToDDLighthouseLaneFishingDock();
		return;
	}

	//Fishing location 6
	protected void fishBrrrghWalrusWay(int numberOfCasts)//fishes in the top left dock
	{
		castLineToFish(numberOfCasts);
		goSellFishBrrrghWalrusWay();
		goBackToBrrrghWalrusWayFishingDock();
		return;
	}

	//Fishing location 7
	protected void fishBrrrghSleetSt(int numberOfCasts)//fishes in the first dock when you walk in
	{
		castLineToFish(numberOfCasts);
		goSellFishBrrrghSleetSt();
		goBackToBrrrghSleetStFishingDock();
		return;
	}

	//Fishing location 8
	protected void fishDaisyGardenElmSt(int numberOfCasts)//fishes in the bottom left dock
	{
		castLineToFish(numberOfCasts);
		goSellFishDGElmStFishingDock();
		goBackToDGElmStFishingDock();
		return;
	}

	//Fish at any pond
	protected void fishAnywhere(int numberOfCasts)//fishes for you anywhere, but will only fish, will not sell fish etc
	{
		castLineToFish(numberOfCasts);
	}

	private boolean checkIfFishCaught()
	{
		Rectangle size = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage image = robot.createScreenCapture(size);
		int clr =  image.getRGB(944,189); 
		int  red   = (clr & 0x00ff0000) >> 16;
		int  green = (clr & 0x0000ff00) >> 8;
		int  blue  =  clr & 0x000000ff;
		String hex = String.format("#%02x%02x%02x", red, green, blue);

		switch(hex)
		{
		case "#ffffbe"://fish
			writeToLogFile("Fish caught!");
			return true;
		case "#948d58"://boot
			writeToLogFile("Boot caught!");
			return true;
		default:
			return false;
		}
	}

	private boolean checkDock()
	{
		Rectangle size = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage image = robot.createScreenCapture(size);
		int clr =  image.getRGB(956,766); 
		int  red   = (clr & 0x00ff0000) >> 16;
		int  green = (clr & 0x0000ff00) >> 8;
		int  blue  =  clr & 0x000000ff;
		String hex = String.format("#%02x%02x%02x", red, green, blue);

		switch(hex)
		{
		case "#fd0000"://red fishing button
			writeToLogFile("In fishing dock, ready to fish!");
			return true;
		default:
			writeToLogFile("Not in fishing dock!");
			return false;
		}
	}

	private boolean bucketFull()
	{
		Rectangle size = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage image = robot.createScreenCapture(size);
		int clr =  image.getRGB(954,672); 
		int  red   = (clr & 0x00ff0000) >> 16;
		int  green = (clr & 0x0000ff00) >> 8;
		int  blue  =  clr & 0x000000ff;
		String hex = String.format("#%02x%02x%02x", red, green, blue);

		switch(hex)
		{
		case "#ca8786"://check for the button if the bucket is full
			writeToLogFile("Bucket full, going to sell fish!");
			robot.mouseMove(954, 672);
			leftClick();
			makeBotSleep(1);
			return true;
		default:
			writeToLogFile("Bucket not full, continuing to fish!");
			return false;
		}
	}

	private boolean checkSellButton()//check blue sell button at fisherman
	{
		makeBotSleep(2);
		Rectangle size = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage image = robot.createScreenCapture(size);
		int clr =  image.getRGB(1260, 825); 
		int  red   = (clr & 0x00ff0000) >> 16;
		int  green = (clr & 0x0000ff00) >> 8;
		int  blue  =  clr & 0x000000ff;
		String hex = String.format("#%02x%02x%02x", red, green, blue);

		switch(hex)
		{
		case "#8c8da6"://blue sell fish button
			writeToLogFile("At the fisherman, selling fish!");
			return true;
		default:
			writeToLogFile("Not able to locate fisherman to sell fish!");
			return false;
		}
	}

	private static boolean firstPass = true;
	private int countNotInDocks = 0;
	private void castLineToFish(int numberOfCasts)//can be used at all fishing docks
	{
		if(numberOfCasts == 0 || countCasts >= 20)
		{
			countCasts = 0;
			return;
		}
		else
		{
			if(countCasts == 0 && firstPass == true)
			{
				showMessageBox("Beginning to fish 5 seconds after OK is clicked!");
				firstPass = false;
			}
			makeBotSleep(5);
			if(!checkDock())//if not in the dock, show message
			{
				showMessageBox("Not in fishing dock!");
				countNotInDocks++;
				if(countNotInDocks <= 4)//try again
					castLineToFish(numberOfCasts - 1);
				else//quit fishing if it cant find the dock after 3 attempts
				{
					showMessageBox("Haven't found the dock in " + countNotInDocks + " attempts, quiting fishing.");
					return;
				}
			}
			countCasts++;
			writeToLogFile("Casting number " + countCasts);
			robot.mouseMove(957, 771);//grab the cast button
			robot.mousePress(InputEvent.BUTTON1_MASK);//click the cast button
			robot.delay(200);
			robot.mouseMove(962, 928);//pull the cast back
			robot.delay(200);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);//release the cast button
			if(bucketFull())//bucket full message check
				return;
			long t = System.currentTimeMillis();
			long end = t+30000;
			while(System.currentTimeMillis() < end && !checkIfFishCaught()) 
			{
				checkIfFishCaught();
			}
			castLineToFish(numberOfCasts - 1);
		}
	}

	private void talkToFisherman(int sell)
	{
		writeToLogFile("Selling fish");
		makeBotSleep(1);
		switch(sell)
		{
		case 0: //cancel fish sell
			robot.mouseMove(1106, 824);
			break;
		case 1: //sell fish
			robot.mouseMove(1260, 825);
		}
		leftClick();
		countCasts = 0;
	}

	private void exitFishing()
	{
		robot.mouseMove(1551, 980);
		leftClick();
		makeBotSleep(2);
	}

	//methods here are for individual fishing docks
	//TTC
	private void goSellFishTTCPunchlinePlace()
	{
		//exit fishing
		exitFishing();
		//go to fisherman
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.delay(800);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(700);
		robot.keyRelease(KeyEvent.VK_UP);
		//fisherman talk
		if(checkSellButton())
			talkToFisherman(1);
	}

	private void goBackToTTCPunchlinePlaceFishingDock()
	{
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(700);
		robot.keyRelease(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(750);
		robot.keyRelease(KeyEvent.VK_LEFT);

		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	//DDL
	private void goSellFishDDLLullabyLane()
	{
		//exit fishing
		exitFishing();
		//go to fisherman
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(4000);
		robot.keyRelease(KeyEvent.VK_UP);
		//fisherman talk
		if(checkSellButton())
			talkToFisherman(1);
	}

	private void goBackToDDLLullabyLaneFishingDock()
	{
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(6500);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	//Brrrgh
	private void goSellFishBrrrghPolarPlace()
	{
		//exit fishing
		exitFishing();
		//go to fisherman
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.delay(800);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_UP);
		//fisherman talk
		if(checkSellButton())
			talkToFisherman(1);
	}

	private void goBackToBrrrghPolarPlaceFishingDock()
	{
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	private void goSellFishBrrrghWalrusWay()
	{
		//exit fishing
		exitFishing();
		//go to fisherman
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_UP);
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(730);
		robot.keyRelease(KeyEvent.VK_LEFT);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_UP);
		//fisherman talk
		if(checkSellButton())
			talkToFisherman(1);
	}

	private void goBackToBrrrghWalrusWayFishingDock()
	{
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(2100);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.delay(700);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	private void goSellFishBrrrghSleetSt()
	{
		//exit fishing
		exitFishing();
		//go to fisherman
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(600);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.delay(850);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_UP);
		//fisherman talk
		if(checkSellButton())
			talkToFisherman(1);
	}

	private void goBackToBrrrghSleetStFishingDock()
	{
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(1700);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(850);
		robot.keyRelease(KeyEvent.VK_LEFT);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(600);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	//Minnie's Melodyland
	private void goSellFishMMTenorTerrace()
	{
		//exit fishing
		exitFishing();
		//go to fisherman
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(1090);
		robot.keyRelease(KeyEvent.VK_LEFT);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(2200);
		robot.keyRelease(KeyEvent.VK_UP);
		//fisherman talk
		if(checkSellButton())
			talkToFisherman(1);
	}

	private void goBackToMMTenorTerraceFishingDock()
	{
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(3000);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	//Donald's Dock
	private void goSellFishDDLighthouseLane()
	{
		//exit fishing
		exitFishing();
		//go to fisherman
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.delay(330);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(2200);
		robot.keyRelease(KeyEvent.VK_UP);
		//fisherman talk
		if(checkSellButton())
			talkToFisherman(1);
	}

	private void goBackToDDLighthouseLaneFishingDock()
	{
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(4500);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	//Daisy's Garden
	private void goSellFishDGElmStFishingDock()
	{
		//exit fishing
		exitFishing();
		//go to fisherman
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(80);
		robot.keyRelease(KeyEvent.VK_LEFT);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_UP);
		//fisherman talk
		if(checkSellButton())
			talkToFisherman(1);
	}

	private void goBackToDGElmStFishingDock()
	{
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(4500);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
}
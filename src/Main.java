import java.awt.AWTException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.IOException;
public class Main{
	private static Bot bot;
	public static void main(String[] args) throws AWTException, IOException, InterruptedException
	{
		/*if(!BotFunctions.getScreenSize())//if the screen size isn't 1080x1920, don't run the bot.
		{
			BotFunctions.showMessageBox("Screen size not 1080x1920\n Some features may not work due to this!");
			//BotFunctions.showMessageBox("Screen size not 1080x1920\n exiting...");
			//System.exit(0);
		}*/
		BotFunctions.createLogFile();
		bot = new Bot();
		BotFunctions.writeToLogFile("Bot started");
		BotFunctions.showMessageBox("Starting bot 5 seconds after OK is clicked!");
		bot.makeBotSleep(5);
		createMainMenuDialog();
		
		
		/*if(BotFunctions.checkForSettingsFile() == false) //not sure if I want to do this or not.
			BotFunctions.createSettingsFile();
		else*/
			
	}

	private static void createMainMenuDialog() throws IOException
	{
		String input = "";
		BotFunctions.writeToLogFile("Main Menu created");
		String[] activities = {"FISHING", "RACING", "GARDENING", "SPAM MESSAGE", "STAY AWAKE", "QUIT"};
		
		while(!input.equals("QUIT"))
		{
			input = (String) JOptionPane.showInputDialog(null, "Choose an activity...", "Select an activity", JOptionPane.PLAIN_MESSAGE, null, activities, activities[0]);
			
			if(input != null)
			{
				BotFunctions.writeToLogFile("Activity chosen: " + input);
				selectedActivity(input);
			}
			//make panel close here
			else
			{
				BotFunctions.showMessageBox("Cya later!");
				System.exit(0);
			}
		}
	}

	private static void selectedActivity(String activity)
	{
		switch(activity)
		{
		case "DO LOGIN"://finished                         //remove from released version
			//bot.startBot();
			//createMainMenuDialog();
			break;
		case "FISHING"://finished (add more locations)
			//BotFunctions.writeToSettingsFile("FISHING SETTINGS");
			bot.goFishing();
			break;
		case "RACING"://needs worked on (BETA)
			BotFunctions.showMessageBox("Still being worked on!");
			break;
		case "GARDENING"://finished
			//BotFunctions.writeToSettingsFile("GARDENING SETTINGS");
			bot.goGardening();
			break;
		case "SPAM MESSAGE"://finished
			//BotFunctions.writeToSettingsFile("TEXT SETTINGS");
			bot.spam();
			break;
		case "STAY AWAKE"://finished
			bot.keepToonAwake();
			break;
		case "QUIT":
			BotFunctions.showMessageBox("Cya later!");
			BotFunctions.writeToLogFile("Exiting Application");
			System.exit(0);
			break;
		default:
			JFrame parent = new JFrame();
			JOptionPane.showMessageDialog(parent, "There's been an error. Exiting the application.");
			System.exit(0);
		}
	}
}

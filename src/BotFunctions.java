import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class BotFunctions 
{
	protected Robot robot;

	protected void makeBotSleep(int numberOfSeconds)
	{
		try 
		{
			Thread.sleep((numberOfSeconds * 1000));	
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	protected void leftClick()
	{
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(200);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(200);
	}

	protected void type(int i)//i is the ascii value of the desired letter to be typed
	{
		robot.delay(40);
		robot.keyPress(i);
		robot.keyRelease(i);
	}

	protected void typeSentenceInGame(String s)//types sentence in game
	{
		byte[] bytes = s.getBytes();
		for (byte b : bytes)
		{
			int code = b;
			// keycode only handles [A-Z] (which is ASCII decimal [65-90])
			if (code > 96 && code < 123) 
			{
				code = code - 32;
				robot.delay(40);
				robot.keyPress(code);
				robot.keyRelease(code);
			}
			else
				pressUnicode(code);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	private void pressUnicode(int key_code)//is for anything not A-Z
	{
		robot.keyPress(KeyEvent.VK_ALT);

		for(int i = 3; i >= 0; --i)
		{
			int numpad_kc = key_code / (int) (Math.pow(10, i)) % 10 + KeyEvent.VK_NUMPAD0;

			robot.keyPress(numpad_kc);
			robot.keyRelease(numpad_kc);
		}

		robot.keyRelease(KeyEvent.VK_ALT);
	}

	protected void typeSentence(String s)//types sentence not in game (for login)
	{
		byte[] bytes = s.getBytes();
		for (byte b : bytes)
		{
			int code = b;
			// keycode only handles [A-Z] (which is ASCII decimal [65-90])
			if (code > 96 && code < 123) code = code - 32;
			robot.delay(40);
			robot.keyPress(code);
			robot.keyRelease(code);
		}
		robot.mouseMove(216, 167);
	}

	protected final static JFrame parent = new JFrame();
	protected static void showMessageBox(String message)
	{
		JOptionPane.showMessageDialog(parent, message);
	}

	protected static int requestInput(String message)
	{
		if(message != null)
			return Integer.parseInt(JOptionPane.showInputDialog(parent, message, null));
		else
			return 0;
	}

	protected static String requestSpamInput()
	{
		return JOptionPane.showInputDialog(parent, "Enter the message you wish to spam", null);
	}

	/*private static File settingsFile = new File("settings.txt");

	protected static boolean checkForSettingsFile()
	{
		if(settingsFile.exists())
			return true;
		else
			return false;
	}

	protected static void createSettingsFile()
	{
		try
		{
			if(!settingsFile.exists())
				settingsFile.createNewFile(); // if file already exists will do nothing 
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static FileWriter fw;
	protected static void writeToSettingsFile(String text)
	{
		try
		{
			fw = new FileWriter(settingsFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}*/

	private static String getTime()
	{
		DateFormat df = new SimpleDateFormat("[MM/dd/yy hh:mm:ss a]");
		Date dateobj = new Date();
		return df.format(dateobj);
	}

	protected static boolean getScreenSize()//check if the screen is 1080 1920
	{
		if(Toolkit.getDefaultToolkit().getScreenSize().getHeight() == 1080 && Toolkit.getDefaultToolkit().getScreenSize().getWidth() == 1920)
			return true;
		else
			return false;
	}

	private static File logFile = new File(new SimpleDateFormat("MM-dd-yyyy; hh mm a'.txt'").format(new Date()));
	protected static void createLogFile()
	{
		try
		{
			logFile.createNewFile(); // if file already exists will do nothing 
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static FileWriter writeLog;
	protected static void writeToLogFile(String text)
	{
		try
		{
			writeLog = new FileWriter(logFile.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(writeLog);
			bw.write(getTime() + " " + text + "\n");
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}

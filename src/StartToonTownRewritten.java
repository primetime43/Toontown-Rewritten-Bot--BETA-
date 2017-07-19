import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class StartToonTownRewritten extends BotFunctions
{
	protected void startGameAndLogin()
	{
		robot.mouseMove(108, 1054);
		leftClick();
		typeSentence("Toontown Rewritten");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		makeBotSleep(10);
		askForUsernameAndPass();
	}
	
	private void login(String username, String password)
	{
		robot.mouseMove(1046, 535);
		leftClick();
		typeSentence(username);
		robot.keyPress(KeyEvent.VK_TAB);
		typeSentence(password);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	protected void maximizeWindow()
	{
		robot.mouseMove(739, 14);
		leftClick();
	}

	protected void selectToon()
	{
		robot.delay(5000);
		robot.mouseMove(495, 290);	
		leftClick();
		robot.delay(20000);//loading screen
		typeSentenceInGame("Welcome to ToonTown Rewritten");
	}
	
	private void askForUsernameAndPass()
	{
        String username = JOptionPane.showInputDialog(parent,"What is your username?", null);
        String password = JOptionPane.showInputDialog(parent,"What is your password?", null);
        while(username == null || password == null)
        {
        	JOptionPane.showMessageDialog(parent, "You enter a null value!");
        	username = JOptionPane.showInputDialog(parent,"What is your username?", null);
            password = JOptionPane.showInputDialog(parent,"What is your password?", null);
        }
        login(username, password);
	}
}

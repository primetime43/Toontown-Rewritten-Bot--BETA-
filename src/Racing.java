import java.awt.event.KeyEvent;


public class Racing extends Fishing//needs worked on
{
	protected void raceScrewballStadium()
	{
		//for(int i = 0; i < 3; i++)
		//{
			makeFirstBendScrewball();//first bend

			makeSecondBendScrewball();//second bend

			makeThirdBendScrewball();//third bend
		//}
	}

	private void makeFirstBendScrewball()//work on this one!
	{
		//straight away
		robot.keyPress(KeyEvent.VK_UP);
		makeBotSleep(6);
		robot.keyRelease(KeyEvent.VK_UP);

		//turn left
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_UP);

		//turn left more
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_UP);

		//turn left more
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(800);
		robot.keyRelease(KeyEvent.VK_UP);

		//turn left more
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_UP);

		//short turn left
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_UP);

		//short turn left
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(450);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//straight away
		robot.keyPress(KeyEvent.VK_UP);
		makeBotSleep(7);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	private void makeSecondBendScrewball()
	{
		//straight away
		robot.keyPress(KeyEvent.VK_UP);
		makeBotSleep(6);
		robot.keyRelease(KeyEvent.VK_UP);

		//turn left
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(800);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_UP);

		//turn left more
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(800);//changed
		robot.keyRelease(KeyEvent.VK_LEFT);

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_UP);

		//turn left more
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(600);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(800);
		robot.keyRelease(KeyEvent.VK_UP);

		//turn left more
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_UP);

		/*//short turn left
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_LEFT);*/

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(500);//changed
		robot.keyRelease(KeyEvent.VK_UP);

		//short turn left
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//straight away
		robot.keyPress(KeyEvent.VK_UP);
		makeBotSleep(7);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	private void makeThirdBendScrewball()
	{
		robot.delay(1300);
		//short turn left
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(700);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//straight away
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_UP);

		//turn left
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.delay(700);
		robot.keyRelease(KeyEvent.VK_LEFT);

		//go straight more
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	protected void raceCorkScrewStadium()
	{

	}
}

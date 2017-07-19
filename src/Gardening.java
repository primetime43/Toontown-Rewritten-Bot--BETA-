import java.util.HashMap;
import javax.swing.JOptionPane;
public class Gardening extends Racing
{//key,value
	//Name of bean, coordinates to click
	private HashMap<String,String> map = new HashMap<String,String>();
	private String[] beanColor = {"red", "green", "orange", "violet", "blue", "pink", "yellow", "cyan", "silver"};//keys
	protected void startPlanting()
	{
		showMessageBox("Beginning to garden 5 seconds after OK is clicked!");
		makeBotSleep(5);
		robot.mouseMove(56, 261);
		leftClick();
		requestPlantCombination();
		makeBotSleep(3);
	}

	private void requestPlantCombination()
	{
		String[] numOfBeans = {"1", "2", "3", "4", "5", "6", "7", "8"};
		String selectedNum = (String) JOptionPane.showInputDialog(null, "Select the number of beans your desired flower requires...", "Select a number of beans", JOptionPane.PLAIN_MESSAGE, null, numOfBeans, numOfBeans[0]);
		if(selectedNum == null)
			return;

		switch(selectedNum)
		{
		case "1":
			oneBeanFlowers();
			break;
		case "2":
			twoBeanFlowers();
			break;
		case "3":
			threeBeanFlowers();
			break;
		case "4":
			fourBeanFlowers();
			break;
		case "5":
			fiveBeanFlowers();
			break;
		case "6":
			sixBeanFlowers();
			break;
		case "7":
			sevenBeanFlowers();
			break;
		case "8":
			eightBeanFlowers();
			break;
		default:
			JOptionPane.showMessageDialog(parent, "There's been an error. Exiting the application.");
			System.exit(0);
		}
	}

	private void oneBeanFlowers()
	{
		String[] flower = {"Laff-o-dil", "Dandy Pansy", "What-in Carnation", "School Daisy", "Lily-of-the-Alley"};
		String selectedNum = (String) JOptionPane.showInputDialog(null, "Select the flower you wish to plant:", "Select a flower to plant", JOptionPane.PLAIN_MESSAGE, null, flower, flower[0]);
		if(selectedNum == null)
			return;
		makeBotSleep(3);

		switch(selectedNum)
		{
		case "Laff-o-dil": //g
			beginPlantingProcess("green");
			plant();
			break;
		case "Dandy Pansy": //o
			beginPlantingProcess("orange");
			plant();
			break;
		case "What-in Carnation": //p
			beginPlantingProcess("pink");
			plant();
			break;
		case "School Daisy": //y
			beginPlantingProcess("yellow");
			plant();
			break;
		case "Lily-of-the-Alley": //c
			beginPlantingProcess("cyan");
			plant();
			break;
		default: return;
		}
	}

	private void twoBeanFlowers()
	{
		String[] flower = {"Daffy Dill", "Chim Pansy", "Instant Carnation", "Lazy Daisy", "Lily Pad"};
		String selectedNum = (String) JOptionPane.showInputDialog(null, "Select the flower you wish to plant:", "Select a flower to plant", JOptionPane.PLAIN_MESSAGE, null, flower, flower[0]);
		if(selectedNum == null)
			return;
		makeBotSleep(3);

		switch(selectedNum)
		{
		case "Daffy Dill": //gc
			beginPlantingProcess("green");
			beginPlantingProcess("cyan");
			plant();
			break;
		case "Chim Pansy": //oc
			beginPlantingProcess("orange");
			beginPlantingProcess("cyan");
			plant();
			break;
		case "Instant Carnation": //py
			beginPlantingProcess("pink");
			beginPlantingProcess("yellow");
			plant();
			break;
		case "Lazy Daisy": //yr
			beginPlantingProcess("yellow");
			beginPlantingProcess("red");
			plant();
			break;
		case "Lily Pad": //cg
			beginPlantingProcess("cyan");
			beginPlantingProcess("green");
			plant();
			break;
		default: return;
		}
	}

	private void threeBeanFlowers()
	{
		String[] flower = {"Summer's Last Rose", "Potsen Pansy", "Hybrid Carnation", "Midsummer Daisy", "Tiger Lily"};
		String selectedNum = (String) JOptionPane.showInputDialog(null, "Select the flower you wish to plant:", "Select a flower to plant", JOptionPane.PLAIN_MESSAGE, null, flower, flower[0]);
		if(selectedNum == null)
			return;
		makeBotSleep(3);

		switch(selectedNum)
		{
		case "Summer's Last Rose": //rrr
			beginPlantingProcess("red");
			beginPlantingProcess("red");
			beginPlantingProcess("red");
			plant();
			break;
		case "Potsen Pansy": //orr
			beginPlantingProcess("orange");
			beginPlantingProcess("red");
			beginPlantingProcess("red");
			plant();
			break;
		case "Hybrid Carnation": //prr
			beginPlantingProcess("pink");
			beginPlantingProcess("red");
			beginPlantingProcess("red");
			plant();
			break;
		case "Midsummer Daisy": //yrg
			beginPlantingProcess("yellow");
			beginPlantingProcess("red");
			beginPlantingProcess("green");
			plant();
			break;
		case "Tiger Lily": //coo
			beginPlantingProcess("cyan");
			beginPlantingProcess("orange");
			beginPlantingProcess("orange");
			plant();
			break;
		default: return;
		}
	}

	private void fourBeanFlowers()
	{
		String[] flower = {"Corn Rose", "Giraff-o-dil", "Marzi Pansy", "Freshasa Daisy", "Livered Lily"};
		String selectedNum = (String) JOptionPane.showInputDialog(null, "Select the flower you wish to plant:", "Select a flower to plant", JOptionPane.PLAIN_MESSAGE, null, flower, flower[0]);
		if(selectedNum == null)
			return;
		makeBotSleep(3);

		switch(selectedNum)
		{
		case "Corn Rose": //ryoy
			beginPlantingProcess("red");
			beginPlantingProcess("yellow");
			beginPlantingProcess("orange");
			beginPlantingProcess("yellow");
			plant();
			break;
		case "Giraff-o-dil": //gpyy
			beginPlantingProcess("green");
			beginPlantingProcess("pink");
			beginPlantingProcess("yellow");
			beginPlantingProcess("yellow");
			plant();
			break;
		case "Marzi Pansy": //oyyr
			beginPlantingProcess("orange");
			beginPlantingProcess("yellow");
			beginPlantingProcess("yellow");
			beginPlantingProcess("red");
			plant();
			break;
		case "Freshasa Daisy": //yrco
			beginPlantingProcess("yellow");
			beginPlantingProcess("red");
			beginPlantingProcess("cyan");
			beginPlantingProcess("orange");
			plant();
			break;
		case "Livered Lily": //coop
			beginPlantingProcess("cyan");
			beginPlantingProcess("orange");
			beginPlantingProcess("orange");
			beginPlantingProcess("pink");
			plant();
			break;
		default: return;
		}
	}

	private void fiveBeanFlowers()
	{
		String[] flower = {"Time and a half-o-dil", "Onelip", "Side Carnation", "Whoopsie Daisy", "Chili Lily"};
		String selectedNum = (String) JOptionPane.showInputDialog(null, "Select the flower you wish to plant:", "Select a flower to plant", JOptionPane.PLAIN_MESSAGE, null, flower, flower[0]);
		if(selectedNum == null)
			return;
		makeBotSleep(3);

		switch(selectedNum)
		{
		case "Time and a half-o-dil": //gpbpp
			beginPlantingProcess("green");
			beginPlantingProcess("pink");
			beginPlantingProcess("blue");
			beginPlantingProcess("pink");
			beginPlantingProcess("pink");
			plant();
			break;
		case "Onelip": //prbpp
			beginPlantingProcess("purple");
			beginPlantingProcess("red");
			beginPlantingProcess("blue");
			beginPlantingProcess("purple");
			beginPlantingProcess("purple");
			plant();
			break;
		case "Side Carnation": //prgbr
			beginPlantingProcess("pink");
			beginPlantingProcess("red");
			beginPlantingProcess("green");
			beginPlantingProcess("blue");
			beginPlantingProcess("red");
			plant();
			break;
		case "Whoopsie Daisy": //yrooo
			beginPlantingProcess("yellow");
			beginPlantingProcess("red");
			beginPlantingProcess("orange");
			beginPlantingProcess("orange");
			beginPlantingProcess("orange");
			plant();
			break;
		case "Chili Lily": //crrrr
			beginPlantingProcess("cyan");
			beginPlantingProcess("red");
			beginPlantingProcess("red");
			beginPlantingProcess("red");
			beginPlantingProcess("red");
			plant();
			break;
		default: return;
		}
	}

	private void sixBeanFlowers()
	{
		String[] flower = {"Tinted Rose", "Smarty Pansy", "Twolip", "Upsy Daisy", "Silly Lily"};
		String selectedNum = (String) JOptionPane.showInputDialog(null, "Select the flower you wish to plant:", "Select a flower to plant", JOptionPane.PLAIN_MESSAGE, null, flower, flower[0]);
		if(selectedNum == null)
			return;
		makeBotSleep(3);

		switch(selectedNum)
		{
		case "Tinted Rose": //rporop
			beginPlantingProcess("red");
			beginPlantingProcess("pink");
			beginPlantingProcess("orange");
			beginPlantingProcess("red");
			beginPlantingProcess("orange");
			beginPlantingProcess("pink");
			plant();
			break;
		case "Smarty Pansy": //oppobp
			beginPlantingProcess("orange");
			beginPlantingProcess("pink");
			beginPlantingProcess("pink");
			beginPlantingProcess("orange");
			beginPlantingProcess("blue");
			beginPlantingProcess("pink");
			plant();
			break;
		case "Twolip": //prrrpp
			beginPlantingProcess("purple");
			beginPlantingProcess("red");
			beginPlantingProcess("red");
			beginPlantingProcess("red");
			beginPlantingProcess("purple");
			beginPlantingProcess("purple");
			plant();
			break;
		case "Upsy Daisy": //ybcpbb
			beginPlantingProcess("yellow");
			beginPlantingProcess("blue");
			beginPlantingProcess("cyan");
			beginPlantingProcess("purple");
			beginPlantingProcess("blue");
			beginPlantingProcess("blue");
			plant();
			break;
		case "Silly Lily": //crpppp
			beginPlantingProcess("cyan");
			beginPlantingProcess("red");
			beginPlantingProcess("purple");
			beginPlantingProcess("purple");
			beginPlantingProcess("purple");
			beginPlantingProcess("purple");
			plant();
			break;
		default: return;
		}
	}

	private void sevenBeanFlowers()
	{
		String[] flower = {"Stinking Rose", "Car Petunia", "Model Carnation", "Crazy Daisy", "Indubitab Lily"};
		String selectedNum = (String) JOptionPane.showInputDialog(null, "Select the flower you wish to plant:", "Select a flower to plant", JOptionPane.PLAIN_MESSAGE, null, flower, flower[0]);
		if(selectedNum == null)
			return;
		makeBotSleep(3);

		switch(selectedNum)
		{
		case "Stinking Rose": //rcoppcc
			beginPlantingProcess("red");
			beginPlantingProcess("cyan");
			beginPlantingProcess("orange");
			beginPlantingProcess("pink");
			beginPlantingProcess("purple");
			beginPlantingProcess("cyan");
			beginPlantingProcess("cyan");
			plant();
			break;
		case "Car Petunia": //bpbpcbb
			beginPlantingProcess("blue");
			beginPlantingProcess("purple");
			beginPlantingProcess("blue");
			beginPlantingProcess("purple");
			beginPlantingProcess("cyan");
			beginPlantingProcess("blue");
			beginPlantingProcess("blue");
			plant();
			break;
		case "Model Carnation": //pggggyg
			beginPlantingProcess("pink");
			beginPlantingProcess("green");
			beginPlantingProcess("green");
			beginPlantingProcess("green");
			beginPlantingProcess("green");
			beginPlantingProcess("yellow");
			beginPlantingProcess("green");
			plant();
			break;
		case "Crazy Daisy": //ygroggg
			beginPlantingProcess("yellow");
			beginPlantingProcess("green");
			beginPlantingProcess("red");
			beginPlantingProcess("orange");
			beginPlantingProcess("green");
			beginPlantingProcess("green");
			beginPlantingProcess("green");
			plant();
			break;
		case "Indubitab Lily": //cpcbcbb
			beginPlantingProcess("cyan");
			beginPlantingProcess("purple");
			beginPlantingProcess("cyan");
			beginPlantingProcess("blue");
			beginPlantingProcess("cyan");
			beginPlantingProcess("blue");
			beginPlantingProcess("blue");
			plant();
			break;
		default: return;
		}
	}

	private void eightBeanFlowers()
	{
		String[] flower = {"Istilla Rose", "Threelip", "Platoonia", "Hazy Dazy", "Dilly Lilly"};
		String selectedNum = (String) JOptionPane.showInputDialog(null, "Select the flower you wish to plant:", "Select a flower to plant", JOptionPane.PLAIN_MESSAGE, null, flower, flower[0]);
		if(selectedNum == null)
			return;
		makeBotSleep(3);

		switch(selectedNum)
		{
		case "Istilla Rose": //rbppbbpb
			beginPlantingProcess("red");
			beginPlantingProcess("blue");
			beginPlantingProcess("purple");
			beginPlantingProcess("purple");
			beginPlantingProcess("blue");
			beginPlantingProcess("blue");
			beginPlantingProcess("pink");
			beginPlantingProcess("blue");
			plant();
			break;
		case "Threelip": //pyypyopy
			beginPlantingProcess("purple");
			beginPlantingProcess("yellow");
			beginPlantingProcess("yellow");
			beginPlantingProcess("purple");
			beginPlantingProcess("yellow");
			beginPlantingProcess("orange");
			beginPlantingProcess("purple");
			beginPlantingProcess("yellow");
			plant();
			break;
		case "Platoonia": //bppbroyy
			beginPlantingProcess("blue");
			beginPlantingProcess("pink");
			beginPlantingProcess("pink");
			beginPlantingProcess("blue");
			beginPlantingProcess("red");
			beginPlantingProcess("orange");
			beginPlantingProcess("yellow");
			beginPlantingProcess("yellow");
			plant();
			break;
		case "Hazy Dazy": //ybpcprop
			beginPlantingProcess("yellow");
			beginPlantingProcess("blue");
			beginPlantingProcess("purple");
			beginPlantingProcess("cyan");
			beginPlantingProcess("purple");
			beginPlantingProcess("red");
			beginPlantingProcess("orange");
			beginPlantingProcess("purple");
			plant();
			break;
		case "Dilly Lilly": //cbyycbyy
			beginPlantingProcess("cyan");
			beginPlantingProcess("blue");
			beginPlantingProcess("yellow");
			beginPlantingProcess("yellow");
			beginPlantingProcess("cyan");
			beginPlantingProcess("blue");
			beginPlantingProcess("yellow");
			beginPlantingProcess("yellow");
			plant();
			break;
		default: return;
		}
	}

	private void beginPlantingProcess(String beanColor)
	{
		String coordinates = map.get(beanColor);
		int x = Integer.parseInt(coordinates.substring(0, coordinates.indexOf(",")));
		int y = Integer.parseInt(coordinates.substring(coordinates.indexOf(",")+1, coordinates.length()));
		robot.mouseMove(x, y);
		leftClick();
	}

	protected void createGardeningMap()//locations of colors
	{
		String[] coordinates = {"747,481", "799,481", "854,479", "909,482", "960,483", "1013,479", "1069,478", "1118,477", "1172,479"};
		for(int i = 0; i < beanColor.length; i++)
			map.put(beanColor[i], coordinates[i]);
	}

	private void clickOKAfterPlant()
	{
		robot.mouseMove(953, 654);
		leftClick();
	}

	protected void waterPlant()
	{
		for(int i = 0; i < 2; i++)
		{
			robot.mouseMove(58, 356);
			leftClick();
			makeBotSleep(4);
		}
	}

	protected void removePlant()
	{
		makeBotSleep(2);
		robot.mouseMove(56, 261);
		leftClick();
		robot.mouseMove(899, 722);
		leftClick();
	}

	private void plant()
	{
		robot.mouseMove(1107, 706);//click plant button
		leftClick();
		makeBotSleep(8);
		clickOKAfterPlant();
		waterPlant();
	}
}

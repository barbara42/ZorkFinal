import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZorkWorld
{
	public static boolean gameWon = false; 
	public static BitcoinCounter counter = new BitcoinCounter(); 
	public static DownloadTracker downloadTracker = new DownloadTracker(); 
	
	public static void main (String [] args) throws IOException
	{ 	
		/*accesses file and fills the map*/
		FileInputStream inFile; 
    	inFile = new FileInputStream("C:/Users/duckworth.barbara/Desktop/ZorkData.txt");
    	PlaceMap myPlaceMap = new PlaceMap(); 
    	myPlaceMap.fillMap(initFile(inFile));
    	inFile.close();
    	
    	/*accesses map*/
    	Map zorkWorld = new HashMap <String, Place>();
    	zorkWorld = myPlaceMap.getPlaceMap(); 
    	
    	//test
    	System.out.println("facebook is in map: " + zorkWorld.containsKey("facebook"));
    	Place facebook = (Place) zorkWorld.get("facebook");
    	String test = facebook.getClick();
    	System.out.println("Timeline1 can be accessed by clicking fb: " + zorkWorld.containsKey(test));
    	System.out.println("facebook click returns: " + test);

		/*for reading user input*/
		Scanner in = new Scanner (System.in);
		String input = "";
		
		/*Introduction and directions*/
		System.out.println("Welcome and stuff"); 
		
		/*the user starts on facebook*/
		String currentPage = "facebook";
		
		while (gameWon == false)
		{
			Action action = new Action (zorkWorld, currentPage);

			/*keeps track of which bitcoins have been found already*/
			if (downloadTracker.getIfDownloaded(currentPage) == true)
				counter.incrementBitcoins();
			
			/*displays text for the current place the user is*/
			action.displayCurrentPage();
			System.out.println("Bitcoins: " + counter.foundBitcoins());
			
			/*if the bitcoin has already been downloaded, alerts the user
			 * and won't download it again*/
			if (input.equals("download") && downloadTracker.getIfDownloaded(currentPage) == false)
				System.out.println("You've already downloaded this bitcoin.");
			downloadTracker.updateDownload(currentPage);
			
			/*reads user input*/
			input = in.nextLine().toLowerCase().trim();
			
			if (input.equals("scroll") || input.equals("click")|| input.equals("back")|| input.equals("download"))
			{
				/*determines what page the user will be going 
				 * to next depending on their input*/
				currentPage = action.getNext(input);
			}
			else
			{
				System.out.println("What are you doing, that's not how the internet works." +
						" Please perform a real action.");
			}
			
			/*if five bitcoins are found, the game is won ->
			 * Exits the while loop*/
			if (counter.foundBitcoins() == 5)
				gameWon = true; 
		}
		
		System.out.println("FOUND ALL FIVE BITCOINS. GO SAVE YOUR NEOPET!");
		//CONGRATS FOR BEATING THE INTERNET 
	}
	
	/*prepares ZorkData file to be read*/
	public static BufferedReader initFile(FileInputStream newFile) throws IOException
	{
		InputStreamReader inReader = new InputStreamReader(newFile);
		BufferedReader reader = new BufferedReader (inReader);
		return reader; 
	}
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PlaceMap {
	
	/*holds all places attached to a key*/ 
	private Map placeMap = new HashMap <String, Place>(); 
	
	/*constructor*/
	public PlaceMap(){}
	
	/*Precondition: mySplit is an array of 6 strings
	 *Postcondition: placeMap has had new <key, place> added to it*/
	private void addPlace(String [] mySplit)
	{
		/*name of the place the player is currently in*/
		String key = mySplit[0];
		
		/*information about the page*/
		String myContent = mySplit [1];
		
		/*paths to different places different actions will take the player to*/
		String myScroll = mySplit [2]; 
		String myClick = mySplit [3];
		String myBack = mySplit [4];
		String myDownload = mySplit [5];
		
		Place myPlace = new Place (myContent, myScroll, myClick, myBack, myDownload);
		
		/*key: name of place
		 *myPlace: information about place */
		placeMap.put(key, myPlace);

	}
	
	/*Splits ZorkData file into 6 strings
	 *Adds entire file to the map*/
	public void fillMap(BufferedReader read) throws IOException 
	{
		String [] split; 
		String partString = "<sep>";
		String line = read.readLine();
		while (line != null) 
		{
			split = line.split(partString);
			line = read.readLine();
			this.addPlace(split);
		}
	}
	
	public Map<String, Place> getPlaceMap (){ return placeMap; }

}

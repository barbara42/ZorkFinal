import java.util.Map;

public class Action
{
	Map<String, Place> placeMap; 
	String currentPage;
	Place currentPlace;

	public Action (Map<String, Place> myMap, String myCurrentPage)
	{
		placeMap = myMap; 
		currentPage = myCurrentPage;
		
		/*retrieves the info for the current page the user is on*/
		currentPlace = placeMap.get(currentPage);
	}
	
	public void displayCurrentPage()
	{
		//check for download 
		//if (currentPlace.getContent().equals("You've found a bitcoin! Do something to continue searching for more."))
		//	ZorkWorld.counter.incrementBitcoins();
		
		/*prints out the text for the page*/
		System.out.println(currentPlace.getContent());
	}
	
	public String getNext(String myInput)
	{
		if (myInput.equals("scroll"))
			return currentPlace.getScroll();
		if (myInput.equals("click"))
			return currentPlace.getClick();
		if (myInput.equals("back"))
			return currentPlace.getBack();
		if (myInput.equals("download"))
			return currentPlace.getDownload();
		
		/*if input isn't a real action, the user is returned to the same page*/
		return currentPage; 
	}
	
	public String downloaded(String currentPage)
	{
		//check stuff
		return ("(download for +1 bitcoin)");
	}
}

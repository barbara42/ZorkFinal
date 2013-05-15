
public class Place {
	
	/*text that shows up for the current place the player is in*/
	private String content; 
	
	/*depending on the action, the player will be taken to a different place*/
	/*keys are held in the String variables*/
	private String scroll; 
	private String click; 
	private String back; 
	private String download; 
	
	public Place (String myContent, String myScroll, String myClick, String myBack, String myDownload)
	{
		content = myContent; 
		scroll = myScroll; 
		click = myClick; 
		back = myBack; 
		download = myDownload; 
	}
	
	/*returns the key for the next place the player will be taken to*/
	public String getContent(){ return content;}
	public String getScroll(){ return scroll;} 
	public String getClick(){ return click;}
	public String getBack(){ return back;}
	public String getDownload(){ return download;} 
	
	

}

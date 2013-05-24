
public class DownloadTracker
{
	/*false if downloaded, true if not*/
	boolean download1 = true;
	boolean download2 = true;
	boolean download3 = true;
	boolean download4 = true;
	boolean download5 = true;
	
	public DownloadTracker()
	{
		
	}
	
	/*false if downloaded, true if not*/
	public boolean getIfDownloaded(String currentPage)
	{
		if (currentPage.equals("download1"))
			return download1; 
		else if (currentPage.equals("download2"))
			return download2; 
		else if (currentPage.equals("download3"))
			return download3; 
		else if (currentPage.equals("download4"))
			return download4; 
		else if (currentPage.equals("download5"))
			return download5; 
		
		return false; 
		
	}
	/*If a bitcoin is found, it changes the download to false
	 *so it can't be downloaded again*/
	public void updateDownload(String currentPage)
	{
		if (currentPage.equals("download1"))
		{
			download1 = false;
		}
		else if (currentPage.equals("download2"))
		{
			download2 = false;
		}
		else if (currentPage.equals("download3"))
		{
			download3 = false;
		}
		else if (currentPage.equals("download4"))
		{
			download4 = false;
		}
		else if (currentPage.equals("download5"))
		{
			download5 = false;
		}
		
	}
}

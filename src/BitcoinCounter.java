
public class BitcoinCounter
{
	int bitcoins; 
	/*constructor*/
	public BitcoinCounter()
	{
		bitcoins = 0; 
	}
	
	public void incrementBitcoins(){ bitcoins++;}
	
	public int foundBitcoins(){ return bitcoins;}
}

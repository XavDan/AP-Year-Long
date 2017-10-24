
public class Order 
{
	private String[] order;
	
	public Order(String[] o)
	{
		//this.order
		order = o;
	}
	
	//toString
	public String toString()
	{
		String e = "ORDER: ";
		for(int counter = 0; counter < order.length; counter ++)
		{
			e +="\n\t" + order[counter];
		}
		return e;
	}
	
}

public class Device 
{
	
	private String sku; // stores the Stock Keeping Unit of each device, usually consisting of around 8 characters
	private String name; // stores the name of each device
	private boolean availabilityStatus = true; // determines whether a device is checked in (true) or checked out (false)
	
	public Device() // empty Device constructor
	{
		
	}
	
	// start getter and setter methods
	
	public String getSku() // getter for String sku
	{
		return sku;
	}

	public void setSku(String sku) // setter for String sku
	{
		this.sku = sku;
	}

	public String getName() // getter for String name
	{
		return name;
	}

	public void setName(String name) // setter for String name
	{
		this.name = name;
	}

	public boolean getAvailabilityStatus() // getter for boolean availabilityStatus
	{
		return availabilityStatus;
	}

	public void setAvailabilityStatus(boolean availabilityStatus) // setter for boolean availabilityStatus
	{
		this.availabilityStatus = availabilityStatus;
	}
	
	// end getter and setter methods

} // end class
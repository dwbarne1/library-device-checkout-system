import java.util.Scanner;
import java.util.ArrayList;

public class LibraryDeviceCheckoutSystem 
{
	
	private ArrayList<Device> devices; // contains all created Device objects
	private Scanner scan = new Scanner(System.in); // Scanner object initialization
	
	public static void main(String[] args) // main method
	{
	
		LibraryDeviceCheckoutSystem ldcs = new LibraryDeviceCheckoutSystem();
		ldcs.LibraryDeviceMenu();
		// class object invokes LibraryDeviceMenu to start program
	
	} // end main method
	
	public void LibraryDeviceMenu() // contains menu of all other methods
	{
		devices = new ArrayList<>(); // creation of devices ArrayList to store all created Device objects
		boolean runMenu = true; // determines whether to stay in (true) or exit the menu (false)
		
		// do-while loop navigates through the menu, invokes the respective methods in the switch statement, and exits the program with case 7
		do
		{
			int menuOption = 0; // takes in user input to navigate through the LibraryDeviceMenu
			
			System.out.println("\t\tLibrary Device Checkout System\n");
			System.out.println("1. List Devices by Title");
			System.out.println("2. Add New Devices");
			System.out.println("3. Edit Device Information");
			System.out.println("4. Search by Device Name");
			System.out.println("5. Check Out Devices");
			System.out.println("6. Check In Devices");
			System.out.println("7. Exit\n\n");
			System.out.print("Select menu options 1-7: ");
					
			try 
			{
				menuOption = Integer.parseInt(scan.nextLine()); // user must enter a menu option (1-7)
				if(menuOption < 1 || menuOption > 7);
			}
			
			catch(Exception e)
			{
				
			} // try-catch checks for any input exceptions
		
			switch(menuOption)
			{
				case 1:
					listDevices();
					break;
				case 2:
					addNewDevices();
					break;
				case 3:
					editDeviceInfo();
					break;
				case 4:
					searchByDeviceName();
					break;
				case 5:
					checkOutDevices();
					break;
				case 6:
					checkInDevices();
					break;
				default:
					break;
			}
			
			if(menuOption != 7)
			{
				System.out.println("\n\n\n\n\n\n");
			}
			
			else if(menuOption == 7)
			{
				runMenu = false;
			}
			
		} while(runMenu == true);
		
	} // end LibraryDeviceMenu method
	
	public void listDevices() // lists the device #, SKU, name, and availability of all Device objects
	{
		System.out.println("\n\n\n\n\n\n\n\t\tLibrary Device Checkout System - List\n");
		
		String availability = "";
		System.out.println("#  SKU        Name");
		for(int i = 0; i < devices.size(); i++)
		{
			if(devices.get(i).getAvailabilityStatus() == true) // checking whether Device is available
			{
				availability = "Available";
			}
			else if(devices.get(i).getAvailabilityStatus() == false)
			{
				availability = "Checked Out";
			}
			
			System.out.printf("%1d  %-10s %-28s	%s\n", i+1, devices.get(i).getSku(), devices.get(i).getName(), availability); // displaying attributes of each Device object
		}
		
		System.out.print("\n\nPress Enter to continue...");
		scan.nextLine();
	} // end listDevices method
	
	public void addNewDevices() // adds a new Device into the devices ArrayList, taking in user input for the SKU and name
	{
		
		System.out.println("\n\n\n\n\n\n\n\t\tLibrary Device Checkout System - Add New Devices\n");
		
		// data to be entered using Scanner
		String sku = "";
		String name = "";
		
		System.out.print("Enter SKU: ");
		sku = scan.nextLine();
		
		System.out.print("Enter name: ");
		name = scan.nextLine();
		
		// creating a new tmpDev object an adding it to the devices ArrayList every time this method is invoked
		Device tmpDev = new Device();
		tmpDev.setSku(sku);
		tmpDev.setName(name);
		
		devices.add(tmpDev);
		
		System.out.printf("\nAdded %s to catalog.\n", sku);
		System.out.print("Press Enter to continue...");
		scan.nextLine();
	} // end addNewDevices method
	
	public void editDeviceInfo() // edits Device object information (SKU and name)
	{
		System.out.println("\n\n\n\n\n\n\n\t\tLibrary Device Checkout System - Edit Devices");
		System.out.println("\n\n\n\n\n\n\n\t\tLibrary Device Checkout System - List\n"); // displaying the list of Device objects and their attributes
		
		String availability = "";
		System.out.println("#  SKU        Name");
		for(int i = 0; i < devices.size(); i++)
		{
			if(devices.get(i).getAvailabilityStatus() == true) // checking the availability status of each Device object
			{
				availability = "Available";
			}
			else if(devices.get(i).getAvailabilityStatus() == false)
			{
				availability = "Checked Out";
			}
			
			System.out.printf("%1d  %-10s %-28s	%s\n", i+1, devices.get(i).getSku(), devices.get(i).getName(), availability);
		}
		
		int deviceNumber = 0;
		System.out.print("\nEnter Device number to edit (1-5): "); // user enters Device number to be edited
				
		try 
		{
			deviceNumber = Integer.parseInt(scan.nextLine());
		}
		
		catch (Exception e)
		{
			
		} // try-catch checks for any input mismatch or out-of-bounds exceptions when entering data
		
		if (deviceNumber <= devices.size() && deviceNumber > 0)
		{
			System.out.print("Enter SKU: ");
			String sku = scan.nextLine();
			
			System.out.print("Enter name: ");
			String name = scan.nextLine();
			
			devices.get(deviceNumber - 1).setSku(sku);
			devices.get(deviceNumber - 1).setName(name);
			
			System.out.println("Device information updated.");
			System.out.print("\nPress Enter to continue...");
		} // Device information is updated as long as a valid device number is entered; otherwise it goes back to the menu, as in the following else if statement
		
		else if (deviceNumber > devices.size() || deviceNumber <= 0) {
			System.out.println("Invalid Input");
			System.out.print("\nPress Enter to continue...");
		}

		scan.nextLine();
	} // end editDeviceInfo method
		
	
	public void searchByDeviceName() // searches for Device in the ArrayList by its name
	{
		System.out.println("\n\n\n\n\n\n\n\t\tLibrary Device Checkout System - Search\n\n");
		System.out.print("Enter Device to search for: ");
		String deviceName = scan.nextLine(); // user enters input to search for the name of a device
		
		System.out.printf("\nListings for '%s'\n", deviceName);
		System.out.println("#  SKU        Name");		
		for(int i = 0; i < devices.size(); i++)
		{
			if(devices.get(i).getName().toLowerCase().contains(deviceName))
			{
				System.out.printf("%1d  %-10s %-28s\n", i+1, devices.get(i).getSku(), devices.get(i).getName());

			}
		} // this loop compares the String entered by the user to any part of the device names containing that String and shows results that contain it
		
		System.out.print("\n\nPress Enter to continue...");
		scan.nextLine();
	} // end searchByDeviceName method
	
	public void checkOutDevices() // checks out Device object from the ArrayList (sets its availability to false)
	{
		System.out.println("\n\n\n\n\n\n\n\t\tLibrary Device Checkout System - Check Out Devices");
		System.out.println("\n\nAvailable Devices\n");
		
		System.out.println("#  SKU        Name");
		for(int i = 0; i < devices.size(); i++)
		{
			if(devices.get(i).getAvailabilityStatus())
			{
				System.out.printf("%1d  %-10s %-28s\n", i+1, devices.get(i).getSku(), devices.get(i).getName());
			}
		} // loop prints all devices from the ArrayList that can be checked out (where availabilityStatus == true)
		
		System.out.print("\n\nEnter device number: "); // user enters a device number to check out
		
		try 
		{
			int deviceNumber = Integer.parseInt(scan.nextLine());
			
			if(devices.get(deviceNumber - 1).getAvailabilityStatus() == false)
			{
				System.out.println("This device is already checked out.");
			}
			
			else
			{
				devices.get(deviceNumber - 1).setAvailabilityStatus(false);
				System.out.println("Device checked out.");
			} // if/else statements check whether a device is already checked out
		}
		
		catch(Exception e)
		{
			System.out.println("Invalid Input");
		} // try-catch checks whether there are any input mismatches or out-of-bounds exceptions
		
		System.out.print("\nPress Enter to continue...");
		scan.nextLine();
	} // end checkOutDevices method
	
	public void checkInDevices() // checks in Device object from the ArrayList (sets its availability to true)
	{
		System.out.println("\n\n\n\n\n\n\n\t\tLibrary Device Checkout System - Check In Devices");
		System.out.println("\n\nChecked Out Devices\n");
		
		System.out.println("#  SKU        Name");
		for(int i = 0; i < devices.size(); i++)
		{
			if(!devices.get(i).getAvailabilityStatus())
			{
				System.out.printf("%1d  %-10s %-28s\n", i+1, devices.get(i).getSku(), devices.get(i).getName());
			}
		} // loop prints all devices from the ArrayList that can be checked out (where availabilityStatus == true)
		
		System.out.print("\n\nEnter device number: ");
		
		try 
		{
			int deviceNumber = Integer.parseInt(scan.nextLine());
			
			if(devices.get(deviceNumber - 1).getAvailabilityStatus() == true)
			{
				System.out.println("This device is already checked in.");
			}
			
			else
			{
				devices.get(deviceNumber - 1).setAvailabilityStatus(true);
				System.out.println("Device checked in.");
			} // if/else statements check whether a device is already checked in
		}
		
		catch(Exception e)
		{
			System.out.println("Invalid Input");
		} // try-catch checks whether there are any input mismatches or out-of-bounds exceptions
		
		System.out.print("\nPress Enter to continue...");
		scan.nextLine();
	} // end checkInDevices method
	
} // end class
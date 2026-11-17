
public class animalRescueCenter02 {

	public static void main(String[] args) {
		
		Animal animal1 = new Animal("Max", "Cat", 15, 3.1);
		
		
		displayOverview();
		
		animal1.displayAnimalAnalysis();

	}
	
	public static void displayOverview() 
	{
		System.out.println("**************************************");
		System.out.println("        Animal Rescue Analysis");
		System.out.println("**************************************");
		System.out.println(" ");
		System.out.println("In this program the system will:");
		System.out.println("- Read animal information from a text file");
		System.out.println("- Display each animal's weight category and weekly food");
		System.out.println("- Calculate average daily and total weekly food");
		System.out.println("- Write rescue information and analysis to a file");
		System.out.println(" ");
	}

}

class Animal
{
	/** Instance variables (properties) of the object */
	private String name;
	private String species;
	private double weight;
	private double dailyAmount;
	
	/** Constructor for the variables */
	Animal(String name, String species, double weight, double dailyAmount)
	{
		this.name = name;
		this.species = species;
		this.weight = weight;
		this.dailyAmount = dailyAmount;
	}
	
	/** Getters for each instance variable */
	public String getName() 
	{
		return name;
	}
	
	public String getSpecies() 
	{
		return species;
	}
	
	public double getWeight() 
	{
		return weight;
	}
	
	public double getDailyAmount() 
	{
		return dailyAmount;
	}
	
	/** Method for getting the animal's weight category */
	public String determineWeightCategory() 
	{
		String category = null;
		
		if (weight > 0 && weight < 20) 
		{
			category = "Small";
		}
		else if (weight >= 20 && weight < 50) 
		{
			category = "Medium";
		}
		else if (weight >= 50 && weight < 100) 
		{
			category = "Large";
		}
		else if (weight >= 100) 
		{
			category = "Extra Large";
		}
		else 
		{
			category = "Invalid";
		}
		
		return category;
	}
	
	/** Method for getting the animal's weekly amount */
	public double calculateWeeklyFood() 
	{
		final int WEEKLY_MULTIPLIER = 7;
		double weeklyAmount = dailyAmount * WEEKLY_MULTIPLIER;
		
		return weeklyAmount;
	}
	
	/** method for displaying the animal's details */
	public void displayAnimalAnalysis() 
	{
		System.out.println("Name: " + name);
		System.out.println("Species: " + species);
		System.out.printf("Weight: %.1f lbs \n", weight);
		System.out.println("Weight Category: " + determineWeightCategory());
		System.out.printf("Daily food amount: %.2f \n", dailyAmount);
		System.out.printf("Weekly food amount: %.2f", calculateWeeklyFood());
	}
}

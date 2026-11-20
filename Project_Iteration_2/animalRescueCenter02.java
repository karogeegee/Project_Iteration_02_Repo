
public class animalRescueCenter02 {

	public static void main(String[] args) {
		
		Animal animal1 = new Animal("Max", "Cat", 15, 3.1);
		Animal animal2 = new Animal("Filip", "Dog", 32, 6.3);
		Animal animal3 = new Animal("Emile", "Bird", 4.2, 1.54);
		
		RescueCenter kCenter = new RescueCenter("KCenter", 3);
		kCenter.addAnimal(animal1);
		kCenter.addAnimal(animal2);
		kCenter.addAnimal(animal3);
		
		displayOverview();
		
		displayProgramSummary(kCenter);

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

	
	public static void displayProgramSummary(RescueCenter kCenter) 
	{
		System.out.printf("\n======== %s Summary =========", kCenter.getRescueName());
		System.out.println(" ");
		
		System.out.println(" ");
		
		System.out.println("Rescue Name: " + kCenter.getRescueName());
		System.out.println("Maximum amount of animals: " + kCenter.animals.length);
		System.out.println("Current number of animals: "+ kCenter.getAnimalCount());
		
		System.out.println(" ");
		
		kCenter.displayAnimalResults();
		
		System.out.println(" ");
		
		System.out.printf("======== %s Food Analysis ========\n", kCenter.getRescueName());
		System.out.println(" ");
		System.out.println("Total amount of animals: " + kCenter.animals.length);
		System.out.printf("Total weekly food required: %.2f cups\n", kCenter.calculateTotalWeeklyFood());
		System.out.printf("Average daily food amount: %.2f cups\n", kCenter.calculateAverageDailyFood());
		System.out.println("Animals at or above the average daily food amount: ");
		kCenter.displayAnimalsAtOrAboveAverageDailyFood();
		
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


class RescueCenter 
{
	private String rescueName;
	Animal[] animals;
	private int animalCount;
	
	/** Constructor for the 'RescueCenter' class. 'animalCount' isn't 
	 * in the parameter due to starting at 0 and increases as each animal is added  */
	RescueCenter(String rescueName, int maxAnimals)
	{
		this.rescueName = rescueName;
		animalCount = 0;
		animals = new Animal[maxAnimals];
		
	}
	
	/** Getters for 'recueName' and 'animalCount'. The array of objects doesn't have
	 * a getter because of  */
	public String getRescueName() 
	{
		return rescueName;
	}
	
	public int getAnimalCount() 
	{
		return animalCount;
	}
	
	/** Method for adding an animal */
	public void addAnimal(Animal animal) 
	{
		if (animalCount < animals.length) 
		{
			animals[animalCount] = animal;
			animalCount++;
		}
		else 
		{
			System.out.println("Error: Animal limit exceeded");
		}
	}
	
	/** Method for displaying current animals */
	public void displayAnimalResults() 
	{
		int difference = animals.length - animalCount;
		for (int index = 0; index < animals.length - difference; index ++) 
		{
			System.out.printf("------ Animal %d Summary ------ \n", index + 1);
			
			animals[index].displayAnimalAnalysis();
			System.out.println(" ");
			System.out.println(" ");
		}
	}
	
	/** Method for getting the total weekly food amount among current animals */
	public double calculateTotalWeeklyFood() 
	{
		double totalWeekly = 0;
		int difference = animals.length - animalCount;
		
		for (int index = 0; index < animals.length - difference; index ++) 
		{
			totalWeekly = totalWeekly + animals[index].calculateWeeklyFood();
		}
		
		return totalWeekly;
	}
	
	/** Method for getting the average daily food among current animals */
	public double calculateAverageDailyFood() 
	{
		double sum = 0;
		int difference = animals.length - animalCount;
		
		for (int index = 0; index < animals.length - difference; index ++) 
		{
			sum = sum + animals[index].getDailyAmount();
		}
		double average = sum / (animals.length - difference);
		
		return average;
	}
	
	/** Method for displaying animals at or above the average daily food amount */
	public void displayAnimalsAtOrAboveAverageDailyFood() 
	{
		int difference = animals.length - animalCount;
		
		for (int index = 0; index < animals.length - difference; index ++) 
		{
			if (animals[index].getDailyAmount() >= calculateAverageDailyFood())
			{
				System.out.printf("- %s: %.2f cups \n", animals[index].getName(), animals[index].getDailyAmount());
			}
		}
	}
}
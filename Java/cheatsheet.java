
/* using IDE Eclopse and JDK 1.8*/

// single line comment
/* multilime comment */

import java.util.Scanner;		// import libraries, Scanner - user input
import java.util.*;				// import whole library

public class Animal {		// create public class
	// public - available to every one
	// static - shared by every animal object created
	// final - constant, can't be changed
	// double - variable type
	// protected - can be only accessed within this package
	public static final double FAVNUMBER = 1.6.180;

	// private - can be only accessed by other method in the field
	private String name;
	private int weight;					// int -2^31 to 2^31
	private boolean hasOwner = false;
	private byte age;					// -128 to 127;
	private long uniqueID;
	private char favoriteChar;			// one character
	private double speed;				// 64 bit number
	private float height;				// 32 bit number, not very accurate

	protected static int numberOfAnimal = 0;		// can only be access from package

	static Scanner userInput = new Scanner(System.in);			// create (instance of ?)scanner object, System.in - data from keyboard

	// Arrays
	int[] myArray = {1,3,5};
	// or 
	// declares an array of integers
    int[] anArray;
 	// allocates memory for 10 integers
    anArray = new int[10];
    // initialize first element
    anArray[0] = 100;
    // initialize second element
    anArray[1] = 200;
    // and so forth
    anArray[2] = 300;
    anArray[3] = 400;
    anArray[4] = 500;
    anArray[5] = 600;
    anArray[6] = 700;
    anArray[7] = 800;
    anArray[8] = 900;
    anArray[9] = 1000;

    //You can also place the brackets after the array's name
    // this form is discouraged
	float anArrayOfFloats[];

	// ArrayLists
	// don't forget to inport ArrayList library
	ArrayList<String> myArrayList = new ArrayList<String>();

	myArrayList.add("String");
	myArrayList.isEmpty();
	myArrayList.get(0);
	myArrayList.remove(0);
	myArrayList.remove("String");

	// loop though arraylist
	for (String item : myArrayList) {}

	// HashMaps - key-value pairs
	// need to import
	HashMap myHashMap = new HashMap();
	myHashMap.put("Lady", "Bonni");		// insert key-value pair
	myHashMap.get("Lady");				// get by key
	myHashMap.values();					// print all values
	myHashMap.containsKey("Lady");		// return bool
	myHashMap.size();					// get size of HashMap



	/* Constructor */
	/* Right click - Source - Generate constructor using Fields */
	public Animal(){
		//super();					// supper() calls super class. eg: for dog class, Animal is supper class
		numberOfAnimal++;			// increment

		int sumOfNum = 5 + 1; 		// just math example
		System.out.println("5 + 1 =" + sumOfNum);		// print out with line break
		System.out.print("Enter name: \n");

		// ways to return data and get right data types
		// hasNextInt, hasNextFloat, hasNextDouble, hasNextBoolean, hasNextByte
		// NextInt, NextFloat, NextDouble, NextBoolean, NextByte
		if(userInput.hasNextLine()) {						// did they enter a STRING
			this.setName(userInput.nextLine());				// this - referens to object created, setName doesn't exist as setters and getters not generated
		}
	}


	/* Generate setters and Getters!*/
	/* Right click - Source -  Generate setters and Getters */
	public void setUniqueID(long uniqueID) {
		this.uniqueID = uniqueID;
		System.out.println("Unique ID Set to " + this.uniqueID);
	}
	
	// method overload
	public void setUniqueID() {
		long minNumber = 1;
		long maxNumber = 100000;
		
		this.uniqueID = minNumber + (long)(Math.random() * ((maxNumber - minNumber) + 1)); 	// (long) - cast
		String stringNumber = Long.toString(maxNumber);		// convert to string
		int numberString = Integet.parseInt(stringNumber);
	}




	public static void main(String[] args) {
		Animal theAnimal = new Animal();
	}

}




// Inheritance - Every field and method from Animal will be 
// available for subclass
public class Dog extends Animal {		// create sub class class for Animal

	
}
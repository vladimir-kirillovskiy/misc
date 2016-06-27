// getting user input 

import java.util.Scanner;

// create Scanner object
Scanner input = new Scanner(System.in);

System.out.println("Enter a line of text:");
String line = input.nextLine();	// can be text
String value = input.nextInt(); // can be int
								// can be float and etc

System.out.println("You entered: " + line);


// string arrays
String[] fruits = {"apple", "banana", "pear", "kiwi"};

for(String fruit: fruits) {};

// multidimential arrays
// can be also strings
int [][] grid = {
	{3, 5, 7},
	{1, 2},
	{2, 4, 6, 7}
};

int i = grid[1][1];

// incapsulations & setters/getters

private String name;
private int age;

public String getName() {
	return name;
}
public int getAge() {
	return age;
}
public void setName(String name) {
	this.name = name;	// local variable name mask class variable name, that is why we use this.name
}
public void setAge(String age) {
	this.age = age;
}

// StringBuilder

// inefficient
String info = "";
info += "Hi";
info += " ";
info += "there";

// better way, more efficient
StringBuilder sb = new StringBuilder();

sb.append("Hi");
sb.append(" ");
sb.append("World");

System.out.println(sb.toString());

// wildcards

ArrayList<?> list;  // <?> - wildcard, is type is not known
ArrayList<? extends Machine> list;  // can get Machine type values  
ArrayList<? Super Camera> list;  // camera or super class of camera  

// anonymous classes
class Machine {
	public void start(){
		System.out.println("starting ...");
	}
}

public class App {
	public static void main(String[] args) {
		Machine machine1 = new Machine() {		// that is annonimous class that it is a sub class of Machine
			@Override
			System.out.println("override");
		};
	}
}

// reading text file

public static void main(String[] args) throws FileNotFoundException {	// error handling
	String fileName = "C:/Users/Vladk/file.txt";	// can put into working directory
	File textFile = new File(fileName);

	Scanner in = new Scanner(textFile);		// can put as try/cache or use throws FileNotFoundException
	while(in.hasNextLine()) {
		String line = in.nextLine();
	}

	in.close();	// close this file
}
 
// reading using filereader 
File file = new File("text.txt");
FileReader fr = new FileReader(file);		// use try/cache
BufferReader dr = new BufferReader(fr);
String line = br.readLine();

// try with resourses
// and write into file
File file = new File("text.txt");  // will create in project folder
try (BufferWriter br = new BufferWriter(new FileWriter(file))) {
	br.write("Line one");
	br.newLine();
	br.write("Line two");
	br.newLine();
	br.write("Line last");

	// don't need br.close()

} cache (IOException e) {
	System.out.println("Unable to write file " + file.toString());
}

// .equals works better than == 

// Enums

// recursion
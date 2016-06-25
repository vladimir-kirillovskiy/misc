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


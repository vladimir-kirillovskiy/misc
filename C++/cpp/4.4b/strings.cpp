#include <iostream>
#include <string>

/*
* just random example of references
*/

void func(int& a)
{
	a = 100;
}



int main()
{
	/*
	* just random example of references
	*/
	{
		int a = 67;

		func(a);

		// a == 100
	}

	std::string myName("Vlad");
	std::cout << "My name is: " << myName << std::endl;

	std::cout << "Enter your full name: ";
	std::string yourName;
	std::getline(std::cin, yourName); // read a full line of text into name

	std::string text("Your name is: ");

	std::cout << text + yourName << std::endl;	// text and yourName will be appended, not added

	std::cout << "your name is " << yourName.length() << " charecters long\n";		// get length of a string

	return 0;
}

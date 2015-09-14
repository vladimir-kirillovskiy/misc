#include <iostream>

// Definition of function doPrint()
// void means the function does not return a value to the caller
void doPrint()	
{
	std::cout << "doPrint()" << std::endl;
}

// int means the function returns an integer value to the caller
int return5()
{
	return 5;
}


int main()
{
	
	std::cout << "main start" << std::endl;
	doPrint();
	std::cout << "main end" << std::endl;
	return 0;
}



// !!! Functions can not be defined inside other functions (called nesting) in C++
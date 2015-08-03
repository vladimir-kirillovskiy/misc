#include <iostream>

int readNumber()
{
	int x = 0;
	std::cin >> x;

	return x;
}

void writeAnswer(int x)
{
	std::cout << "Answer: " << x << std::endl; 
}
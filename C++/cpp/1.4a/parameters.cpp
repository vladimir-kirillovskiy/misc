#include <iostream>

int add(int x, int y)
{
	return x + y;
}

int multiply(int x, int y)
{
	return x * y;
}

int main()
{
	std::cout << add(3,4) << std::endl;
	return 0;
}
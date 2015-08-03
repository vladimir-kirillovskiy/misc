#include <iostream>
#include "io.h"

int main() 
{
	using namespace std;
	int x = 0, y = 0, z = 0;

	cout << "Enter First Number: ";
	x = readNumber();
	cout << "Enter Second Number: ";
	y = readNumber();

	z = x + y;
	writeAnswer(z);

	return 0;
}


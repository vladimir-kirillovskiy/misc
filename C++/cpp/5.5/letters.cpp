#include <iostream>

int main()
{

/*
	int i = 0;
	while (i < 26)
	{
		int iChar = 97 + i;
		std::cout << "ASCII code for " 
			<< static_cast<char>(iChar) << " is: "<< iChar << std::endl;
		i++;
	}*/

	using namespace std;
 
    char chValue = 'a';
    while (chValue <= 'z')
    {
        cout << chValue << " " << static_cast<int>(chValue) << endl;
        chValue++;
    }


	return 0;
}
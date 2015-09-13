#include <iostream>
#include <fstream>

using namespace std;

int main() 
{
	ifstream fileIn("TheTextFile.txt");
	if(!fileIn)
		return 1;

	int count = 0;		// count all characters
	char dummyChar;		// to store a character from a file


	while (!fileIn.eof())
	{
		fileIn >> dummyChar;
		count++;
	}

	cout << "There are " << count << " characters in \"TheTextFile.txt\"" << endl;

	char *letters = new char[count];

	fileIn.clear();
	fileIn.seekg(NULL, ios::beg);

	count = 0;

	while (!fileIn.eof())
	{
		fileIn >> letters[count];
		count++;
	}

	letters[count - 1] = NULL;
	cout << letters << endl;

	delete[] letters;		//free the memory

	fileIn.close();

	return 0;
}
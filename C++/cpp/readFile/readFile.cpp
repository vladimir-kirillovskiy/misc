#include <iostream>
#include <string>
#include <fstream>


using namespace std;

int main() 
{
	ifstream fin;
	string strLine = "";								
	string strWord = "";	
	fin.open("Stats.txt");

	if(fin.fail())
	{
		cout << "File doesn't exist" << endl;
		return 1; 
	}


	while(fin >> strWord)
		cout << strWord << endl;

	fin.clear();
	fin.seekg(NULL, ios::beg); // go to begining
								// first parameter can be wrong as compiler gives warning 

	while (getline(fin, strLine))
		cout << strLine << endl;

	fin.clear();
	fin.seekg(NULL, ios::beg);

	fin.close();

	return 0;
}
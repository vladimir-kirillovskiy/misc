#include <iostream>


int getUserInput()
{
	using namespace std;
	int x = 0;
	cout << "Enter Number: ";
	cin >> x;

	return x;
}

int getMathOperation()
{
	using namespace std;
	int nOperator;
	
	cout << "Please enter which operator you want (1 = +, 2 = -, 3 = *, 4 = /): ";
    cin >> nOperator;
 
    return nOperator;
}

int calcResult(int nInput1, int nOperator, int nInput2)
{
	int result = 0;

	if (nOperator == 1) 
	{
		result = nInput1 + nInput2; 
	}
	if (nOperator == 2) 
	{
		result = nInput1 - nInput2; 
	}
	if (nOperator == 3) 
	{
		result = nInput1 * nInput2; 
	}
	if (nOperator == 4) 
	{
		result = nInput1 / nInput2; 
	}

	return result;
}


void printResult(int nResult)
{
	std::cout << "Result: " << nResult << std::endl;
}

int main()
{
	int nInput1 	= getUserInput();
	int nOperator 	= getMathOperation();
	int nInput2		= getUserInput();
	int nResult 	= calcResult(nInput1, nOperator, nInput2);
	printResult(nResult);

	return 0;
}
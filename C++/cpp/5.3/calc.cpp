#include <iostream>
#include <cstdlib>

int main()
{
	using namespace std;
	cout << "Enter first digit\n";

	int digit1;
	cin >> digit1;

	cout << "Enter operator(+,-,*,/)\n";
	char cOperator;
	cin >> cOperator;

	
	cout << "Enter second digit\n";

	int digit2;
	cin >> digit2;

	switch (cOperator)
	{
		case '+':
			cout << "result: " << digit1 + digit2 << endl;
			break;
		case '-':
			cout << "result: " << digit1 - digit2 << endl;
			break;
		case '*':
			cout << "result: " << digit1 * digit2 << endl;
			break;
		case '/':
			cout << "result: " << digit1 / digit2 << endl;
			break;
		default:
			cout << "Error" << endl;
			exit(1);
			break;
	}


	return 0;
}
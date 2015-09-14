#include <iostream>

int main()
{
	using namespace std;

	double x, y;
	char cOperator;

	cout << "Enter a double value: ";
	cin >> x;
	cout << "Enter a second double value: ";
	cin >> y;
	cout << "Enter one of the following: +, -, *, or /: ";
	cin >> cOperator;

	if(cOperator == '+')
	{
		cout << x << " + " << y << " is " <<  x + y << endl;
	}
	if(cOperator == '-')
	{
		cout << x << " - " << y << " is " <<  x - y << endl;
	}
	if(cOperator == '*')
	{
		cout << x << " * " << y << " is " <<  x * y << endl;
	}
	if(cOperator == '/')
	{
		cout << x << " / " << y << " is " <<  x / y << endl;
	}


}

#include <iostream>

int doubleNumber(int x)
{
	return x * 2;
}

int main()
{
	using std::cout;
	using std::cin;
	using std::endl;

	int x = 0;
	cout << "enter a number: ";
	cin >> x;

	cout << "you entered: " << x << endl;
	cout << "double value is: " << doubleNumber(x) << endl;

	return 0;
}
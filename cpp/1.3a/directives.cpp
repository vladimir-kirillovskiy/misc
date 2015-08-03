#include <iostream>

/*int main()
{
	std::cout << "Enter a number:";
	int x = 0;
	std::cin >> x;
	std::cout << "You entered " << x << std::endl;
	return 0; 
}
*/
int main()
{
	using std::cout;	// this using declaration tells the compiler that cout should resolve to std::cout
	using std::cin;
	using std::endl;

	cout << "Enter a number:";
	int x = 0;
	cin >> x;
	cout << "You entered " << x << endl;
	return 0; 
}

/*int main()
{
	using namespace std;	// this using directive tells the compiler that we're using everything in the std namespace!
	cout << "Enter a number:";
	int x = 0;
	cin >> x;
	cout << "You entered " << x << endl;
	return 0; 
}*/
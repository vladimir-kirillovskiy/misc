#include <iostream>

struct Employee //  By convention, struct names start with a capital letter to distinguish them from variable names.
{
	short id;
	int age;
	double wage;
};			// don't forget semicolon

void printInformation(Employee employee)
{
	std::cout << "ID: " << employee.id << "\n";
	std::cout << "Age: " << employee.age << "\n";
	std::cout << "Wage: " << employee.wage << "\n";
}

int main()
{
	Employee joe = {1, 32, 24.50};
	Employee frank = {2, 30, 34.50};
	Employee vlad;
	vlad.id = 3;
	vlad.age = 26;

	printInformation(joe);
	printInformation(frank);
	printInformation(vlad);

	return 0;
}
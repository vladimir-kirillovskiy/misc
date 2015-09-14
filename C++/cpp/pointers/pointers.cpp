#include <iostream>

using namespace std;

void IncreaseNumber(int Number);
void IncreaseNumber2(int *pNumber);

void IncreaseNumber(int Number)
{
	Number+=5;
}

void IncreaseNumber2(int *pNumber)
{
	*pNumber+=5;
}

int main()
{
	int num = 5;

	IncreaseNumber(num);
	cout << num << endl;
	IncreaseNumber2(&num);
	cout << num << endl;

	return 0;

}
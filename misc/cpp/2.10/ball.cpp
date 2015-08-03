#include <iostream>
#include "constants.h"

void doPrint(int sec, double dHeight)
{
	double distance;

	distance = myConstants::gravity * sec * sec /2;

	if((dHeight - distance) < 0.0) 
	{
		distance = 0.0;
	} 
	else 
	{
		distance = dHeight - distance;
	}
	std::cout << "At " << sec << " seconds, the ball is at height: " 
		<< distance << " meters" << std::endl;

}

int main()
{
	using namespace std;
 	double dHeight;
	cout << "Set height of the tower in meters: ";
	cin >> dHeight;

	doPrint(0, dHeight);
	doPrint(1, dHeight);
	doPrint(2, dHeight);
	doPrint(3, dHeight);
	doPrint(4, dHeight);
	doPrint(5, dHeight);


}

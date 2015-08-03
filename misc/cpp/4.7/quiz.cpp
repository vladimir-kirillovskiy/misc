#include <iostream>

struct Advertise
{
	int adQty;
	double userPer;
	double avEarn;
};

void printOut(Advertise adv)
{
	std::cout << "how many ads you’ve shown to readers: " << adv.adQty << "\n";
	std::cout << "what percentage of users clicked on ads: " << adv.userPer << "\n";
	std::cout << "how much you earned on average from each ad: " << adv.avEarn << "\n";

	std::cout << "how much you made for that day: " <<  adv.adQty * adv.userPer * adv.avEarn << std::endl;
}

int main()
{
	Advertise adv;

	std::cout << "How many ads were shown today? ";
    std::cin >> adv.adQty;
    std::cout << "What percentage of users clicked on the ads? ";
    std::cin >> adv.userPer;
    std::cout << "What was the average earnings per click? ";
    std::cin >> adv.avEarn;

	printOut(adv);

	return 0;
}
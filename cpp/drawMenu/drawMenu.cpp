#include <iostream>

using namespace std;

void DrawMenu();	// declare method

void DrawMenu()
{
	cout << "\t\t ****************Game Menu**************** \n";
	cout << "\t\t *                                       * \n";	// This is our game menu, comprised of cout's :)
	cout << "\t\t *   1) New Game                         * \n";	// Beautiful isn't it?  hehe.
	cout << "\t\t *   2) Load Game                        * \n";	// You can obviously find more creative ways to display a menu than this.
	cout << "\t\t *   3) Save Game                        * \n";	// Just, somehow we have to let the user know their options
	cout << "\t\t *   4) Inventory                        * \n";	// You'll notice the "\t".  this is like "\n", but it means TAB.  It's just so you
	cout << "\t\t *   5) Options                          * \n";	// Don't have to press space bar 5 times... I am just expanding your C++ vocabulary :)
	cout << "\t\t *   6) Quit                             * \n";
	cout << "\t\t *                                       * \n";
	cout << "\t\t ***************************************** \n";	
}

int main()
{
	bool bStillPlaying = true;
	int choice = 0;

	while (bStillPlaying)
	{
		DrawMenu();

		cout << "Your choice: ";
		cin >> choice;

		switch(choice)						
		{
			case 1: cout << "You chose a New Game!\n";		// if (choice == 1)
					break;									// break - breaks out of the switch statement. 
			case 2: cout << "You chose to Load a Game!\n";	// if (choice == 2)
					break;									// Print the choice and break;
			case 3: cout << "You chose to Save a Game!\n";	// if (choice == 3)
					break;									// Print the choice and break;
			case 4: cout << "You chose your Inventory!\n";	// if (choice == 4)
					break;									// Print the choice and break;
			case 5: cout << "You chose Options!\n";			// if (choice == 5)
					break;									// Print the choice and break;
			case 6: bStillPlaying = false;					// if (choice == 6)
					cout << "Game over already?\n";			// bStillPlaying is set to false.  This means, when the code goes back up to the top, while(bStillPlaying) will NOT be true and fail.
					break;									// A weird thing about switch statements, you don't need brackets {} for more than one line.
		}	


	}

	return 0;
}
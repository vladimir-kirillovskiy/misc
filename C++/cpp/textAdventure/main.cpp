
using namespace std;


#include "main.h" 		// move all declarations to a header file


void debug(string strMsg)
{
	cout << "\n" << strMsg << endl;
}

void GetMonsterInfo(ifstream &fin, tRoom &room, string strMonsterName)
{
	// Create a string to hold the contents of each line that we read in
	string strLine = "";								

	// Set the file pointer at the beginning of the file and clear() the EOF (End of File) flag 
	fin.seekg(NULL,ios::beg);						
	fin.clear();

	// It seems like a good idea to set the name of the new monster here, since we
	// obviously know there is a monster in the current room now, and we have it's name.
	room.monster.SetName(strMonsterName);

	// Here we want read in a line at a time from the file until we find the desired room
	while(getline(fin, strLine, '\n'))	
	{
		// Just like the look header, we check for the monster header the exact same way.
		// Below we check if the current line we read in was the header we desire.
		// An example header would be: <Right|goblin>
		// The room name is "Right" and the monster's name is "goblin".  In steps it becomes:
		//
		// "<" + room.strCurrentRoom + "|" + strMonsterName + ">" = 
		// "<room.strCurrentRoom|strMonsterName>" = 
		// "<Right|goblin>"
		//
		
		// Check if the current line read in is the monster header
		if(strLine == "<" + room.strCurrentRoom + "|" + strMonsterName + ">")
		{
			// One of the differences from getting the monster info and getting the look
			// descriptions is that the monsters have 3 blocks of information.
			// Let's look at a full monster block:
			//
			// <Right|goblin>   - This is the header we search for
			// <Health> 125     - This is the health of the monster
			// <Damage> 12      - This is the damage the monster inflicts on the player
			// <Attack> The goblin claws your face.*    - This is the attack message
			//
			// If you know how to read in a room block, this works just the same.
			//
			
			// Create an integer to store the health and damage
			int data = 0;

			// Read in the health of the monster
			fin >> strLine >> data;

			// Pass in the data to our monster member function, SetHealth(), to store the health
			room.monster.SetHealth(data);

			// read in the damage of the monster and assign it to the monster
			fin >> strLine >> data;
			room.monster.SetDamage(data);

			// Read past the "<Attack>" word
			fin >> strLine;

			// Read the attack description until we hit a '*'
			getline(fin, strLine, '*');

			// Assign the attack message to our monster
			room.monster.SetAttackMessage(strLine);

			return;
		}
	}
}

void GetPlayerInfo(ifstream &fin, CPlayer &player)
{
	// Create some local variables to store what we read in from the file
	string strWord;
	int data = 0;

	// Unlike the other Get*Info() functions, we don't need to search for the
	// player data.  We know that it's right at the beginning of the file:
	//
	// <Name>   Troy		- This is the player's name
	// <health> 275			- This is the player's health
	// <weapon> dagger		- This is the player's weapon
	// <damage> 21			- This is the players IQ, .. oh, I mean weapon's damage.
	//
	// Just like every block of data in the text file, the player data is read the same.
	// You will want to read past the first word, then store what's after it.
	//
		
	// Set the file pointer at the beginning of the file and clear() the EOF (End of File) flag 
	fin.seekg(NULL,ios::beg);
	fin.clear();
	
	// Read in the player's name
	fin >> strWord >> strWord;

	// Set the player's name by it's data access member function
	player.SetName(strWord);

	// Store the first word, then use the integer to store the health.
	fin >> strWord >> data;

	// To set the player's health, pass it into SetHealth()
	player.SetHealth(data);

	// Read in and store the player's weapon name
	fin >> strWord >> strWord;
	player.SetWeapon(strWord);

	// Read in and store the players damage
	fin >> strWord >> data;
	player.SetDamage(data);
}

void DisplayPlayer(const CPlayer &player)
{
	// When we hit "status", it will call this function to print out our player's details.
	// Notice that the data access functions are being used, instead of player.strName.
	// This might seem silly now, but it is a safer way to program.  A "const" is also
	// put in front of the parameter "CPlayer &player" to ensure that we don't accidentally
	// change anything.  References are being used so that the player structure is not 
	// copied onto the stack, but a pointer or "reference" to the data is used instead.

	// Display our player's status to the screen
	cout << "Name: "   << player.GetName()   << endl;
	cout << "Health: " << player.GetHealth() << endl;
	cout << "Weapon: " << player.GetWeapon() << endl;
	cout << "Damage: " << player.GetDamage() << endl;
}


bool CheckLook(tRoom &room, string strLook)
{
	for (int i = 0; i <= MAX_LOOKS; i++)
	{
		if (strLook == room.strLookArray[i])
			return true;
	}
	return false;
}

void DisplayLook(string strLookDescription)
{
	cout << strLookDescription << endl;
}

void GetLookInfo(ifstream &fin, tRoom &room, string strLook)
{
	string strLine = "";

	fin.seekg(NULL, ios::beg);
	fin.clear();

	while (getline(fin, strLine, '\n'))
	{
		if (strLine == "<" + room.strCurrentRoom + "|" + strLook + ">")
		{
			getline(fin, room.strLookDescription, '*');
			return;
		}
	}
}


void DisplayRoom(tRoom &room)
{
	cout << room.strRoomDescription << endl;// Store the current keyword
}

void GetRoomInfo(ifstream &fin, tRoom &room)
{
	string strLine = "";
	string strTemp = "";

	string strRoom = "<" + room.strCurrentRoom + ">";

	fin.seekg(NULL, ios::beg);
	fin.clear();

	while (getline(fin, strLine, '\n'))
	{
		if(strLine == strRoom)
		{
			// Read in the room description until we hit the '*' symbol, telling us to stop
			getline(fin, room.strRoomDescription, '*');
			
			fin >> strTemp >> room.strRoomNorth;				
			fin >> strTemp >> room.strRoomEast;				
			fin >> strTemp >> room.strRoomSouth;				
			fin >> strTemp >> room.strRoomWest;		

			int count = 0, i = 0;

			fin >> strTemp >> count;
			for (i = 0; i < MAX_LOOKS; i++)
				room.strLookArray[i] = "";	// Initialize the current index to nothing

			for (i = 0; i < count % MAX_LOOKS; i++)
				fin >> room.strLookArray[i];	// Store the current keyword


				// With a new "<enemy>" block added to our room block, more data will need
			// to be read in each time we enter a new room.  This is read just like the
			// directions: <enemy> goblin
			// We will read past the first word, then read and store the next word "goblin".
			// When there is not a monster in the room, "none" will substitute the monster's name.
			// Once we determine if there is a monster in the room, we need to read in it's
			// data immediately afterwards because he is probably going to clobber us.

			// Read in the monsters name, if any
			fin >> strTemp >> strTemp;

			// If there was no monster in the room, strTemp will have read "None"
			if(strTemp == "None")
			{
				// Set our monster flag to false and return from the function
				room.bMonsterInRoom = false;
				return;
			}
			
			// We must have a monster in the room, so let's set the monster flag to true
			room.bMonsterInRoom = true;

			// Next, a call to GetMonsterInfo() with the monster name passed in will
			// search for the monster header, then read in the monster's info.
			GetMonsterInfo(fin, room, strTemp);



			return;

		}
	}
}

void Move(ifstream &fin, tRoom &room, string strRoom)
{
	if (strRoom == "None")
	{
		cout << "You can't go that way!" << endl;
		return;
	}

	room.strCurrentRoom = strRoom;
	GetRoomInfo(fin, room);
	DisplayRoom(room);
} 

int GetInput(ifstream &fin, tRoom &room, CPlayer &player)
{
	string strInput = "";
	cout << "\n:";
	cin >> strInput;

	if(strInput == "look")									// Check if the user typed "look"
	{
		DisplayRoom(room);									// Display the current room's description
	}
	else if(strInput == "view") 
	{
		cout << "What do you want to look at? \n:";
		cin >> strInput;

		if (CheckLook(room, strInput))
		{
			GetLookInfo(fin, room, strInput);
			DisplayLook(room.strLookDescription);
		}
		else 
		{
			cout << "I don't see anything like that... " << endl;
		}
	}
	else if(strInput == "status")							// Check if the user typed "status"
	{
		DisplayPlayer(player);								// Display the player's current status
	}
	else if(strInput == "north")							// Check if the user typed "north"
	{
		Move(fin, room, room.strRoomNorth);					// Move to the room that is to the north (if it's a valid move)
	}
	else if(strInput == "east")								// Check if the user typed "east"
	{
		Move(fin, room, room.strRoomEast);					// Move to the room that is to the east (if it's a valid move)
	}
	else if(strInput == "south")							// Check if the user typed "south"
	{
		Move(fin, room, room.strRoomSouth);					// Move to the room that is to the south (if it's a valid move)
	}
	else if(strInput == "west")								// Check if the user typed "west"
	{
		Move(fin, room, room.strRoomWest);					// Move to the room that is to the west (if it's a valid move)
	}
	else if(strInput == "quit")								// Check if the user typed "quit"
	{
		cout << "Did you give up already?" << endl;			// Display a quit message
		return QUIT;										// Return QUIT to stop the game and end the program
	}
	else if(strInput == "help" || strInput == "?")			// Check if the user typed "help" or "?"			
	{														// Display a list of commands
		cout << endl << "Commands: look north south help quit" << endl;
	}
	else													// Otherwise we didn't recognize the command typed in
	{
		cout << endl << "Huh???" << endl;					// Display a message indicating we didn't understand what the user wants
	}

	return STILL_PLAYING;
}

int AttackPlayer(tRoom &room, CPlayer &player)
{
	// This is probably the most important and complicated function in this tutorial.
	// In order to simplify the tutorial so no one will get lost, the battle sequence 
	// is NOT random and does NOT take off random damages.  Though this would have been 
	// pretty easy to add, I chose to leave it out.  It will give you something to do 
	// yourself that isn't too hard.  Let's go over the algorithm that is used for battle:

	// while(there is a monster in the room)
	// { 
	//    - The monster attacks first and subtracts their damage from the player's health
	//    - The player then attacks and subtracts his/her damage from the monster's health
	//  
	//	  - Now we check: if(the player is dead), we return PLAYER_IS DEAD and the game is over
	//    - Otherise, we check:  if(the monster is dead), display a victory message and stop
	//    - If the player and monster are still alive, we want to loop again from the top
	// }
	//
	// Pretty simple huh?  It doesn't get any easier than that.  It should be fun to see what
	// you guys come up with for your fighting sequences.
	//

	// Check if there is a monster in the room
	while(room.bMonsterInRoom)
	{
		// Display the attack message of the monster, right before it attacks us
		cout << room.monster.GetAttackMessage() << endl;

		// Subtract the monster's damage from our health because we just got hit.
		// The result of "player.GetHealth() - room.monster.GetDamage()" will be then
		// passed into SetHealth(), which will change the players health to a lower number.
		player.SetHealth(player.GetHealth() - room.monster.GetDamage());
		
		// Display our current health
		cout << "You now have " << player.GetHealth() << " health." << endl;

		// Display our attack message before we pound the enemy
		cout << "You attack the "  << room.monster.GetName() 
			 << " with your "      << player.GetWeapon() << " for " 
			 << player.GetDamage() << " hit points!"     << endl;

		// Subtract our damage from the monster's health
		room.monster.SetHealth(room.monster.GetHealth() - player.GetDamage());

		// Displa the monsters status
		cout << "It now has " << room.monster.GetHealth() << " health." << endl;

		// We our health is less than 0 (we died)...
		if(player.GetHealth() <= 0)
		{
			// Display a defeating message and quit the game
			cout << "You are dead!" << endl;
			return PLAYER_IS_DEAD;
		}
		// Else if the monster is dead...
		else if(room.monster.GetHealth() <= 0)
		{
			// Display our victory and set the monster flag to false (no more monster)
			cout << "You killed the " << room.monster.GetName() << "!" << endl;
			room.bMonsterInRoom = false;		
		}

		// Put in a delay between each round
		sleep(1);
	}

	// The monster didn't stand a chance, so we return a flag that says we are still alive
	return PLAYER_STILL_ALIVE;
}


int main()
{
	ifstream fin;
	tRoom room;

	fin.open(GAME_FILE);

	if (fin.fail())
	{
		cout << "Unable to find World.txt" << endl;
		return -1;
	}

	// Create an instance of our player class to hold our player's data
	CPlayer player;

	// Since the player's data is stored at the beginning of the text file,
	// there is no searching to be done.  We can just read it in immediately.
	GetPlayerInfo(fin, player);

	// We better initialize the monster flag to be false.  It's a
	// good idea to memset()/initialize the room structure in the beginning.
	room.bMonsterInRoom = false;


	fin >> room.strCurrentRoom >> room.strCurrentRoom;
	GetRoomInfo(fin, room);
	DisplayRoom(room);

	while (1)
	{
		if (GetInput(fin, room, player) == QUIT)
			break;

		// This function is called to handle the battle scenes.  If there is
		// a monster in the current room, this function will loop continuously
		// until either the player or monster are dead.  If you die, the game is over,
		// otherwise you keep on truckin'.
		if(AttackPlayer(room, player) == PLAYER_IS_DEAD)
			break;
	}

	fin.close();

	sleep(1);

	return 0;

}
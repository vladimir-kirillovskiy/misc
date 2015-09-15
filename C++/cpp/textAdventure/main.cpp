#include <iostream>
#include <fstream>
#include <string>
#include <unistd.h> 		// sleep function for linux. windows.h for windows
using namespace std;

void debug(string strMsg)
{
	cout << "\n" << strMsg << endl;
}

#define GAME_FILE 		"World.txt"
#define STILL_PLAYING 	1
#define QUIT			0
#define MAX_LOOKS		3

struct tRoom
{
	string strCurrentRoom;
	string strRoomDescription;
	string strRoomNorth;
	string strRoomEast;
	string strRoomSouth;
	string strRoomWest;
	string strLookArray[MAX_LOOKS];
	string strLookDescription;
};

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

	debug(room.strCurrentRoom);
	debug(strRoom);

	room.strCurrentRoom = strRoom;
	GetRoomInfo(fin, room);
	DisplayRoom(room);
} 

int GetInput(ifstream &fin, tRoom &room)
{
	string strInput = "";
	cout << "\n:";
	cin >> strInput;

	debug(strInput);

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

	fin >> room.strCurrentRoom >> room.strCurrentRoom;
	GetRoomInfo(fin, room);
	DisplayRoom(room);

	while (1)
	{
		if (GetInput(fin, room) == QUIT)
			break;
	}

	fin.close();

	sleep(3);

	return 0;

}
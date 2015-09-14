#include <iostream>

using namespace std;

enum Color
{
	COLOR_BLACK,
	COLOR_RED
};

int main()
{
	Color paint = COLOR_RED;
	cout << paint << endl;

}

/* enums useful for code documentation and readability purposes
enum ParseResult
{
    SUCCESS = 0,
    ERROR_OPENING_FILE = -1,
    ERROR_READING_FILE = -2,
    ERROR_PARSING_FILE = -3,
};
 
ParseResult readFileContents()
{
    if (!openFile())
        return ERROR_OPENING_FILE; 		// will return -1
    if (!readFile())
        return ERROR_READING_FILE; 		// will return -2
    if (!parsefile())
        return ERROR_PARSING_FILE; 		// will return -3
 
    return SUCCESS; 					// will return 0
}
*/
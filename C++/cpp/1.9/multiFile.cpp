#include <iostream>
#include "add.h"

int main()
{
	using namespace std;
    cout << "The sum of 3 and 4 is: " << add(3, 4) << endl;
    return 0;
}


// build using: g++ -o multiFile multiFile.cpp multiFileAdd.cpp 
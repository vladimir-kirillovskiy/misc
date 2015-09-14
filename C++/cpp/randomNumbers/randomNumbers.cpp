// #include <windows.h> 	//	windows library to call the function GetTickCount()
#include <iostream>
#include <stdlib.h>     	// srand, rand
#include <sys/time.h>		// to make GetTickCount() for linux
using namespace std;

unsigned GetTickCount()
{
        struct timeval tv;
        if(gettimeofday(&tv, NULL) != 0)
                return 0;

        return (tv.tv_sec * 1000) + (tv.tv_usec / 1000);
}

int main()
{
	int num1 = rand();

	cout << num1 << endl;

	cout << rand()%15 << endl;
	cout << rand()%10 << endl;
	cout << rand()%100 << endl;

	srand(GetTickCount());

	cout << rand()%100 << endl;
	

	return 0;
}
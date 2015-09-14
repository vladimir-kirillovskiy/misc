#include <iostream>
#include <string>

using namespace std;

void cPrint(string strMessage)
{
	cout << strMessage << endl;
}

int main() 
{
	string mesg = "";
	cPrint("type in anything");
	cin >> mesg;

	if(mesg == "Hello")
		cPrint("Hello to you too!");
	else 
		cPrint("where is my \"Hello\"?");

	return 0;
}


int main(int argc, char const *argv[])
{
	/* code */
	return 0;
}
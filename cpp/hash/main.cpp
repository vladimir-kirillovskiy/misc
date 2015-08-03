/*
* hash function since C++11, so compile as c++11
* g++ -std=c++11 -o hash hash.cpp -lssl -lcrypto
*/

#include <iostream>
#include "hash.h"

int main(int argc, char const *argv[])
{
	using namespace std;

	Hash cHash;
	
	cout << ((argc == 1) ? "please pass string to hash" : cHash.sha256(argv[1])) << endl;

	return 0;
}


#include "hash.h"

#include <iostream>
#include <string>
#include <sstream>
#include <iomanip>	
#include <openssl/sha.h>

using namespace std;

std::string Hash::sha256(const std::string str)
{
	unsigned char hash[SHA256_DIGEST_LENGTH];
	SHA256_CTX sha256;
	SHA256_Init(&sha256);
	SHA256_Update(&sha256, str.c_str(), str.size());
	SHA256_Final(hash, &sha256);
 	stringstream ss;
 	for(int i = 0; i < SHA256_DIGEST_LENGTH; i++)
 	{
    	ss << hex << setw(2) << setfill('0') << (int)hash[i];
	}
	return ss.str();
}

std::string Hash::sha512(const std::string str)
{
	unsigned char hash[SHA512_DIGEST_LENGTH];
	SHA512_CTX sha512;
	SHA512_Init(&sha512);
	SHA512_Update(&sha512, str.c_str(), str.size());
	SHA512_Final(hash, &sha512);
 	stringstream ss;
 	for(int i = 0; i < SHA512_DIGEST_LENGTH; i++)
 	{
    	ss << hex << setw(2) << setfill('0') << (int)hash[i];
	}
	return ss.str();
}
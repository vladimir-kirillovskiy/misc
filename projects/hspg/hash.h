#ifndef HASH_H
#define HASH_H
	
	#include <string>

	using namespace std;
	
	class Hash 
	{		
		public:
			std::string sha256(const std::string str);
			std::string sha512(const std::string str);

	};	// important semicolon 
#endif

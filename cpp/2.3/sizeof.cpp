#include <iostream>
 
int main()
{
    using namespace std;
    cout << "bool:\t\t" << sizeof(bool) << " bytes" << endl;
    cout << "char:\t\t" << sizeof(char) << " bytes" << endl;
    cout << "wchar_t:\t" << sizeof(wchar_t) << " bytes" << endl;
    cout << "char16_t:\t" << sizeof(char16_t) << " bytes" << endl; // C++11, may not be supported by your compiler
    cout << "char32_t:\t" << sizeof(char32_t) << " bytes" << endl; // C++11, may not be supported by your compiler
    cout << "short:\t\t" << sizeof(short) << " bytes" << endl;
    cout << "int:\t\t" << sizeof(int) << " bytes" << endl;
    cout << "long:\t\t" << sizeof(long) << " bytes" << endl;
    cout << "float:\t\t" << sizeof(float) << " bytes" << endl;
    cout << "long long:\t\t" << sizeof(long long) << " bytes" << endl; // C++11, may not be supported by your compiler
    cout << "double:\t\t" << sizeof(double) << " bytes" << endl;
    cout << "long double:\t" << sizeof(long double) << " bytes" << endl;
    return 0;
}


// to run C++11 add -std=c++11
// g++ -o name -std=c++11 name.cpp
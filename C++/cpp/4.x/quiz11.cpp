// c++11 version
// g++ -std=c++11 -o quiz11 quiz11.cpp 

#include <iostream>
#include <string>

enum class MonsterType
{
	MT_OGRE,
	MT_DRAGON,
	MT_ORC,
	MT_GIANT_SPIDER,
	MT_SLIME
};

struct Monster
{
	MonsterType type;
	std::string name;
	int health;
};

std::string GetMonstertypeString(Monster monster)
{

	// use switch for a change
	switch (monster.type)
	{
		case MonsterType::MT_OGRE :
			return "Ogre";
			break;
		case MonsterType::MT_DRAGON :
			return "Dragon";
			break;
		case MonsterType::MT_ORC :
			return "Orc";
			break;
		case MonsterType::MT_GIANT_SPIDER :
			return "Giant spider";
			break;
		case MonsterType::MT_SLIME :
			return "Slime";
			break;
		default:
			return "Unknown";
			break;
	}
	
}


void PrintMonster(Monster monster)
{
	std::cout << "This " << GetMonstertypeString(monster) << 
		" is named " << monster.name << " and has "
		<< monster.health << " health" << std::endl;  
}


int main()
{
	std::cout << "\n***This is C++11 variation***\n\n";

	Monster torg = {MonsterType::MT_OGRE, "Torg", 145};
	Monster blurp = {MonsterType::MT_SLIME, "Blurp", 23};

	PrintMonster(torg);
	PrintMonster(blurp);

	return 0;	
}

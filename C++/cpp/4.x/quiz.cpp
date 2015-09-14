// non c++11 version

#include <iostream>
#include <string>

enum MonsterType
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
	if (monster.type == MT_OGRE)
		return "Ogre";
	else if (monster.type == MT_DRAGON)
		return "Dragon";
	else if (monster.type == MT_ORC)
		return "Orc";
	else if (monster.type == MT_GIANT_SPIDER)
		return "Giant spider";
	else if (monster.type == MT_SLIME)
		return "Slime";
	else 
		return "Unknown";
}


void PrintMonster(Monster monster)
{
	std::cout << "This " << GetMonstertypeString(monster) << 
		" is named " << monster.name << " and has "
		<< monster.health << " health\n";  
}


int main()
{
	std::cout << "\n***This is non-C++11 variation***\n\n";

	Monster torg = {MT_OGRE, "Torg", 145};
	Monster blurp = {MT_SLIME, "Blurp", 23};

	PrintMonster(torg);
	PrintMonster(blurp);

	return 0;	
}

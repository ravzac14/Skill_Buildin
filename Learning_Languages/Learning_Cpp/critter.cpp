//Testing initializer lists

#include <iostream>
#include <string>
#include <vector>

using namespace std;

//THIS WOULD NORMALLY GO IN CRITTER_H
class Critter{
  public:
    Critter(string name, int hunger = 100,int meals = 0, bool etd = false);
    void Greet();
    void setHunger(int newHunger);
    void Eat(Critter& lunch);
    string getName();
    bool getIsEaten();

  private:
    int m_Hunger;
    int m_Meals;
    bool m_IsEaten;
    string m_Name;
    string m_Friend;
};

Critter::Critter(string name, int hunger = 100, int meals = 0, bool etd = false):
                 m_Name {name},
                 m_Hunger {hunger},
                 m_Meals {meals},
                 m_IsEaten {etd},
                 m_Friend {"No"}
{ }

void Critter::Greet(){
  if (!m_IsEaten){
    cout << "I'm " << m_Name << " and my hunger is " << m_Hunger << " and I've eaten " << m_Meals << " meals in my life!" << endl; 
  } else {
    cout << "I've been eaten by " << m_Friend << " and I had eaten " << m_Meals << " in my life!" << endl;
  }
}

void Critter::setHunger(int newHunger){m_Hunger = newHunger;}
bool Critter::getIsEaten(){ return m_IsEaten; }

void Critter::Eat(Critter& lunch){
  //Set the new hunger based on how many meals the lunch had eaten
  int hp = (lunch.m_Meals + 1) * 10;
  if ((hp + m_Hunger) > 100){ this.setHunger(0);
  } else if ((hp + m_Hunger) < 0) { this.setHunger(100);  
  } else { this.setHunger(100 - (hp + m_Hunger)); }

  //Set lunch's m_IsEaten to true
  lunch.m_IsEaten = true;
  lunch.m_Friend = m_Name;

  //increment meals
  ++m_Meals;
}

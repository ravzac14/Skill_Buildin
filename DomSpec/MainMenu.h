#ifndef MAIN_MENU_H
#define MAIN_MENU_H

#include "SFML/Window.hpp"
#include "SFML/Graphics.hpp"
#include "stdafx.h"

class MainMenu
{
  public: 
    enum MenuResult {NOTHING,EXIT,HIGHSCORE,PLAY};

    class MenuItem {
      public:
        sf::Rect<int> mRect;
        MenuResult mAction;
        
        MenuItem (sf::Rect<int> r, MenuResult a) : mRect {r}, mAction {a} 
        { }
        
        ~MenuItem () {
          delete &mRect;
        }
    };

    MenuResult show(sf::RenderWindow& window);

  private:
    MenuResult getMenuResponse(sf::RenderWindow& window);
    MenuResult handleClick(int x, int y);
    MenuResult handleKey(sf::Keyboard::Key code, sf::RenderWindow& window);
    MenuResult handleHover(int x, int y, sf::RenderWindow& window);
    std::list<MenuItem> mMenuItems;
    void updateImage(sf::RenderWindow& window);
    MenuItem* currentButton;
};

#endif

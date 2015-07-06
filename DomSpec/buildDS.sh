#!/bin/bash

#Just builds DS so i don't have to write it every time

g++ -std=c++11 DominantSpecies.cpp Game.cpp MainMenu.cpp SplashScreen.cpp stdafx.cpp -o DominantSpecies -lsfml-graphics -lsfml-window -lsfml-system

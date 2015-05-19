//This is just to test my vector class

#include "my_vector.h"
#include <iostream>

int main (){
  
  Vector<int> wat;
  Vector<int> doo(10);

  std::cout << "wat size = " << wat.size() << " and capacity = " << wat.capacity() << std::endl;
  std::cout << "doo size = " << doo.size() << " and capacity = " << doo.capacity() << std::endl;
}

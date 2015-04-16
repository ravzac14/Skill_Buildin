//Just testing mylist

#include "my_list.h"
#include "printer.h"
#include <iostream>

int main () {

  List<int> wat;
  print(wat);
  
  wat.push_front((int)55);
  print(wat);
  wat.push_front((int)65);
  print(wat);
  wat.push_back((int)75);
  print(wat);
  wat.push_back((int)85);

  print(wat);

}

//Zack Raver, testing the MemoryCell class

#include <vector>
#include <iostream>
#include "findmax.h"
#include "memorycell.h"
using namespace std;

int main (){

  vector<MemoryCell<int>> v = {MemoryCell<int> {1}, MemoryCell<int> {2}, MemoryCell<int> {3}};

  cout << "Max is : " << findMax(v) << endl;

  return 0;
}

//Zack Raver; ravzac14
//testing out my BTree class

#include <iostream>
#include "BST.h"

using namespace std;

int main ( ) {
  BTree<int> b1;
  cout << "Inserting into b1" << endl;
  b1.insert(5);
  b1.insert(2);
  b1.insert(44);
  b1.insert(1);
  b1.printTree();

  cout << "\ncontains in b1" << endl;
  cout << "5: " << b1.contains(5) << endl;
  cout << "2: " << b1.contains(2) << endl;
  cout << "13: " << b1.contains(13) << endl;
  cout << "-1: " << b1.contains(-1) << endl;
  
  cout << "\nFinding min and max" << endl;
  cout << "Min: " << b1.findMin() << endl;
  cout << "Max: " << b1.findMax() << endl;

  cout << "\nRemoving 5,44 from b1" << endl;
  b1.remove(5);
  b1.remove(44);
  b1.remove(22); //doesnt exist
  b1.printTree();

  cout << "making clones with constructor" << endl;
  BTree<int> b2 {b1};
  b2.printTree();

  cout << "making clones with op==" << endl;
  BTree<int> b3;
  b3 = b1;
  b3.printTree();

  cout << "making them empty" << endl;
  b1.makeEmpty();
  b2.makeEmpty();
  b3.makeEmpty();

  return 0;
}

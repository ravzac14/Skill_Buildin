/* 
 * Complete the hea pfrom the testbook and test it
 *
 * Implement an indexed bst. a tree that can be used as a list, so we can ask for the nth elemnt w/o traversing the list. 
 *
 * An IndexedValue has two pieces: the value stores and the leftSize, which says how many element are to the left of that node inorder.
 * Ie, go down the tree until the leftSize is relebvant to N
 */

#include <vector>
#include <exception>

using namespace std;

struct HeapException : public exception 
{
  const char* what() const throw()
  {
    return "Empty Heap";
  }
};

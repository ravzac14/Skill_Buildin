#ifndef MY_SET_H
#define MY_SET_H

#include "BST.h"

//Need to include; Union, Interesection, Diff, Subset (is S a subset of T), element(contains), empty, size
//iterator, enumerate (set to list), build(listofvalues->set), add(), remove(), 

template <typename Comparable>
class Set
{
  public:
    class const_iterator 
    {
      protected:
        Comparable* current;
        const_iterator (Comparable* p) : current {p} { }

        friend class Set<Comparable>;
      
      public:
        const_iterator () : current {nullptr} { }
        
        const_iterator& operator++ () 
        {
          current = current
    };
    class iterator : public const_iterator
    {
      protected:

        friend class Set<Comparable>;

    };
    
    Set ( ) : set = { }, size {0} { }
    Set (const Set& rhs) : set {rhs.set}, size {rhs.size} { }
    
    ~Set ( ) 
    {
      delete size;
      delete set;
    }

    Set& union (const Set& rhs)
    { 
       
    }

  private:
    BTree<Comparable> set;
    int size;
};

#endif

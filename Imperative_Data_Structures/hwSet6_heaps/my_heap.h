#ifndef MY_HEAP_H
#define MY_HEAP_H

//#include "BST.h"
#include <vector>

template <typename Comparable>
class BHeap
{
  private:
    int mCurrentSize;
    vector<Comparable> mArray;

    void buildHeap ()
    {
      for (int i = mCurrentSize / 2; i > 0; --i)
        percolateDown(i);
    }

    void percolateDown (int hole)
    {
      int child;
      Comparable tmp = std::move(mArray[hole]);

      for ( ; hole*2 <= mCurrentSize; hole = child) {
        child = hole * 2;
        if (child != mCurrentSize && mArray[child + 1] < mArray[child])
          ++child;
        if (mArray[child] < tmp)
          mArray[hole] = std::move(mArray[child]);
        else
          break;
      }
      mArray[hole] = std::move(tmp);
    }

  public:
    explicit BHeap (int capacity = 100)
      : mArray {capacity}, mCurrentSize {0} { }

    explicit BHeap (const vector<Comparable>& items)
      : mArray {items.size() + 10}, mCurrentSize {items.size()} 
    {
      for (int i = 0; i < items.size(); ++i)
        mArray[i+1] = items[i];
      buildHeap();
    }

//TODO    bool isEmpty () const;
    const Comparable& findMin ();

    //insert allows dupes
    void insert (const Comparable& x)
    {
      if (mCurrentSize == mArray.size() - 1)
        mArray.resize(mArray.size() * 2);
      
      //Percolate up
      int hole = ++mCurrentSize;
      Comparable copy = x;

      mArray[0] = std::move(copy);
      for ( ; x < mArray[hole/2]; hole /= 2)
        mArray[hole] = std::move(mArray[hole/2]);
      mArray[hole] = std::move(mArray[0]);
    }

 //TODO:   void insert (Comparable&& x);
    void deleteMin ()
    {
      if (isEmpty())
        throw UnderflowException{ };
      mArray[1] = std::move(mArray[mCurrentSize--]);
      percolateDown();
    }

    void deleteMin (Comparable& minItem)
    {
      if (isEmpty())
        throw UnderflowException{ };
      minItem = std::move(mArray[1]);
      mArray[1] = std::move(mArray[mCurrentSize--]);
      percolateDown();
    }

 //TODO:   void makeEmpty ();
};

#endif

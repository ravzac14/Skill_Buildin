#ifndef FINDMAX_H
#define FINDMAX_H

#include <vector>
using std::vector;

template <typename Comparable>
const Comparable & findMax( const vector<Comparable> & a ){

  int maxIndex = 0;

  for (int i = 1; i < a.size(); ++i){
    if (a[maxIndex] < a[i]){
      maxIndex = i;
    }
  } 

  return a[maxIndex];
}

#endif

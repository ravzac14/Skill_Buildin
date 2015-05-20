//Testing shellsort

#include <ctime>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

//note the arrays should have an appropriate n, given the increment list

template <typename Comparable>
void shellsort (vector<Comparable>& a, vector<int>& incs)
{
  for (int i = 0; i < incs.size(); i++) {
    for (int j = incs[i]; j < a.size(); ++j)
    {
      Comparable tmp = std::move (a[j]);
      int k = j;

      for (; k >= incs[i] && tmp < a[k-incs[i]]; k -= incs[i]) {
        a[k] = std::move (a[k - incs[i]]);
      }
      a[k] = std::move(tmp);
    }
  }
}


std::string printArray (const vector<int>& a)
{
  string s = "";
  s += "[";
  for (int i : a) {
    s += to_string(i);
    s += ",";
  }
  s += "]";
  return s;
}

int main () 
{
  vector<int> sortMe {10,20,5,1,16,2,12,7,3,9,11,0,15,13,8,6,17,19,18,4};
  
  //shells things for use with 20
  vector<int> shells {10,4,2,1}; 
  //hibbards things for use iwth 20
  vector<int> hibbards {15,7,3,1};
  //knuths things .5(3^k + 1)
  vector<int> knuths {14,5,2,1};
  //gsedgewicks things 
  vector<int> sedges1 {19,5,1};


  cout << "Before sorting: " << printArray(sortMe) << endl;
  cout << "Sedgewickss: " << endl;

  clock_t begin = clock();
  shellsort(sortMe,sedges1);
  clock_t end = clock();

  double elapsed = double(end-begin) / CLOCKS_PER_SEC;

  cout << "Time taken: " << elapsed << endl;
  cout << "After sorting: " << printArray(sortMe) << endl;
}

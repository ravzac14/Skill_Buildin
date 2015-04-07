//Zack Raver
//1.5
// Write a rec. function that returns a binary representation of an int
// Use the fact that this is equal to the number of l in the repr. of n/2 + 1 if n is odd

#include <iostream>
#include <math.h>
#include <string>
#include <vector>
using namespace std;

vector<int> TWOS = {9992,4096,2048,1024,512,256,128,64,32,16,8,4,2,1,0};

string intToBin(int n, int ind){
  string bits = "0";
 
  if (n > TWOS[ind]) 
    n %= TWOS[ind];
    bits = "1";

  if (ind >= (TWOS.size() - 1)){
    return bits;  
  } else {    
    return (bits + intToBin(n, ++ind));
  }
}

int main (){
  vector<int> ns = {10,200,3000};
  string bin = "";
  
  for (int n : ns){
    bin = intToBin(n, 0);
    cout << "For n: " << n << " you get: " << bin << endl;
  }
}

/*  Zack Raver
 *  hw1-2; 1.4
 *
 * Read in a file and output the file as modified by the include
 */

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main (){
  string line;
  ifstream infile;
  ofstream outfile;
  
  outfile.open("output1.txt");
  infile.open("sample.h");
  
  //Check before we include it
  while (getline(infile,line)){
    outfile << line << '\n';
  }
  infile.close();
  outfile.close();

#include "sample.h"
  infile.open("sample.h");
  outfile.open("output2.txt");

  //check after we include it
  while (getline(infile, line)){
    outfile << line << '\n';
  }
  infile.close();
  outfile.close();

  return 0;

}

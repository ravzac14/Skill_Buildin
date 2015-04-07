#include <cstdlib>
using namespace std;

int main (int argc, char* argv[]){
  int n = atoi(argv[1]);
  int sum = 0;
  for (int i = 0; i < n; ++i){
    ++sum;
  }
  return 0;
}

//Defining some cool stuff for intcell


#include <vector>
#include <iostream>
#include "findmax.h"

using namespace std;

class IntCell{
  private:
    int storedValue;
  
  public:
    explicit IntCell (int initValue = 0) : storedValue {initValue} { }
    
    int read( ) const{
      return storedValue;
    }
    void write (int x){
      storedValue = x;
    }

    IntCell operator+ (const IntCell& rhs) const{
      return IntCell(read() + rhs.read());
    }
    void operator+ (const IntCell& rhs){
      write(read() + rhs.read());
    }

    IntCell operator- (const IntCell& rhs) const{
      return IntCell(read() - rhs.read());
    }
    void operator- (const IntCell& rhs){
      write(read() - rhs.read());
    }

    ostream& print (ostream& out = cout) {
      out << "IntCell: " << storedValue;
    }
};



int main(){
  int size = 0;
  IntCell a[size];
  
  for (int i = 0; i < size; ++i){
    a[i] = IntCell(i*i);
    cout << a[i].print(cout) << endl;
  }


}

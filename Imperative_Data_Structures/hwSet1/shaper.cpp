//Zack Raver
//define a Rectangle class with getLength and get Width. Using the findMax routines, write a main that creates and aray of Rectangle and fins the Rectangle first on the 
//basis of area, then perimeter

#include <iostream>
#include "findmax.h"
#include <vector>
using std::vector;
using std::ostream;
using std::cout;

class Rectangle {
  private:
    double length;
    double width;

  public:
    explicit Rectangle( double l = 0.0, double w = 0.0 ): length{ l }, width{ w } { }
  
    double getLength( ) const{
      return length;
    }
    double getWidth( ) const{
      return width;
    }
    double getArea( ) const{
      return (length * width);
    }
    double getPerimeter( ) const{
      return (length + length + width + width);
    }

    void print( ostream & out = cout ) const{
      out << "(Rect, len: " << length << ", width: " << width;
    }
    bool operator< (const Rectangle & rhs) const{
      if (getArea() != rhs.getArea()){
        return (getArea() < rhs.getArea());
      } else {
        return (getPerimeter() < rhs.getPerimeter());
      }
    }
};

ostream & operator<< (ostream & out, const Rectangle& rhs){
  rhs.print(out);
  return out;
}

int main(){
  vector<Rectangle> v = {Rectangle{2.0,4.0}, Rectangle{3.0,3.0}, Rectangle{8.0,1.0}, Rectangle{4.0,2.25}};

  cout << "Largest Rect: " << findMax(v) << std::endl;

  return 0;
}

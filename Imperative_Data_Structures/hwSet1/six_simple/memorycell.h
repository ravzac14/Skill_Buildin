#ifndef MEMORYCELL_H
#define MEMORYCELL_H

using namespace std;

template <typename Object>
class MemoryCell{

  private:
    Object storedValue;

  public:
    explicit MemoryCell (const Object& initValue = Object { })
      : storedValue {initValue} { }
    const Object& read() const{
      return storedValue;
    }
    void write (const Object& x){
      storedValue = x;
    }
    void print (ostream& out = cout){
      out << "Stored value: " << storedValue << endl;
    }

    bool operator< (const MemoryCell<Object>& rhs) const{
      return (read() < rhs.read());
    }
    
    bool operator<= (const MemoryCell<Object>& rhs) const{
      return (read() <= rhs.read());
    }
    
    bool operator== (const MemoryCell<Object>& rhs) const{
      return (read() == rhs.read());
    }

    bool operator!= (const MemoryCell<Object>& rhs) const{
      return (read() != rhs.read());
    }
 
};

ostream& operator<< (ostream& out, const MemoryCell<Object>& rhs){
  rhs.print(out);
  return out;
}

/*
ostream& operator<< (ostream& out, const MemoryCell& rhs) friend MemoryCell{
  out << "Stored value: " << rhs.storedValue << endl;
  return out;
}
*/

#endif 

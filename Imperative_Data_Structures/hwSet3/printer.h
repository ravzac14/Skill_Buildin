#ifndef PRINTER_H
#define PRINTER_H

#include <iostream>

template <typename Container>
void print (const Container& c, std::ostream& out = std::cout) {
  if (c.empty())
    out << "Empty!" << std::endl;
  else {
    auto itr = c.begin();

    out << "[ " << *itr++;
    while (itr != c.end())
      out << ", " << *itr++;
    out << " ]" << std::endl;
  }
}

#endif

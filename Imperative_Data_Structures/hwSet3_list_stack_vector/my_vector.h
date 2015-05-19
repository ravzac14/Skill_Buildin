#ifndef MY_VECTOR_H
#define MY_VECTOR_H

#include <algorithm>

template <typename Object>
class Vector{

  private:
    Object* objects;
    int m_Size;
    int m_Capacity;

  public:
    static const int SPARE_CAPACITY = 16;

    explicit Vector (int initSize = 0) : m_Size {initSize}, m_Capacity {initSize + SPARE_CAPACITY} {
      objects = new Object[m_Capacity]; }

    Vector (const Vector& rhs) : m_Size {rhs.size}, m_Capacity {rhs.capacity}, objects {nullptr}{
      objects = new Object[m_Capacity];
      for (int i = 0; i < m_Size; ++i)
        objects[i] = rhs.objects[i];
    }

    Vector (Vector&& rhs) : m_Size {rhs.size}, m_Capacity {rhs.capacity}, objects {rhs.objects} {
      rhs.m_Size = 0;
      rhs.m_Capacity = 0;
      rhs.objects = nullptr;
    }

    Vector& operator= (const Vector& rhs){
      Vector copy = rhs;
      std::swap(*this, copy);
      return *this;
    }

    Vector& operator= (Vector&& rhs) {
      std::swap (m_Size, rhs.m_Size);
      std::swap (m_Capacity, rhs.m_Capacity);
      std::swap (objects, rhs.objects);
    
      return *this;
    }

    int size () const {
      return m_Size; }
    int capacity () const {
      return m_Capacity; }
    bool empty () const{
      return (size() == 0); }

    void resize (int newSize) {
      if (newSize > m_Capacity) 
        reserve ((newSize+1) * 2);
      m_Size = newSize;
    }

    void reserve (int newCapacity) {
      if (newCapacity < m_Size)
        return;
      
      Object *newArray = new Object[newCapacity];
      for (int i = 0; i < m_Size; ++i)
        newArray[i] = std::move(objects[i]);

      m_Capacity = newCapacity;
      std::swap(objects, newArray);
      delete [] newArray;
    }

    Object& operator[] (int index){
      return objects[index]; }
    const Object& operator[] (int index) const{
      return objects[index]; }

    void push_back (const Object& x) {
      if (m_Size == m_Capacity) 
        reserve(2 * (m_Capacity + 1));
      objects[m_Size++] = x;
    }
  
    void pop_back (){
      --m_Size;
    }

    const Object& back (){
      return objects[m_Size - 1];
    }

    typedef Object* iterator;
    typedef const Object* const_iterator;

    iterator begin (){
      return &objects[0]; }
    const_iterator begin () const{
      return &objects[0]; }
    iterator end (){
      return &objects[size()]; }
    const_iterator end () const{
      return &objects[size()]; }
      

    ~Vector (){
      delete [] objects;}

};

#endif

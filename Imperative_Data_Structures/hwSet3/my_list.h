#ifndef MY_LIST_H
#define MY_LIST_H

#include <iostream>

template <typename Object>
class List{
  
  private:
    struct Node{
      Object value;
      Node* next;
      Node* previous;

      Node (const Object& v = Object { }, Node* p = nullptr, Node* n = nullptr)
        : value {v}, previous {p}, next {n} { }

      Node (Object&& v, Node* p = nullptr, Node* n = nullptr)
        : value {std::move(v)}, previous {p}, next {n} { }
    };

    int m_Size;
    Node* head;
    Node* tail;

    void init () {
      m_Size = 0;
      head = new Node;
      tail = new Node;
      head->next = tail;
      tail->previous = head;
    }

  public:
    class const_iterator{
      protected:
        Node* current;
        
        Object& retrieve () const {
          return current->value; }
        const_iterator (Node* p) : current {p} { }
        
        friend class List<Object>;

      public:
        const_iterator () : current {nullptr} { }
        
        const Object& operator* () const {
          return this->retrieve(); }//TEST

        const_iterator& operator++ () {
          current = current->next;
          return *this; 
        }
        const_iterator& operator++ (int) {
          const_iterator old = *this;//TEST
          ++(*this);
          return old;
        }
        bool operator== (const const_iterator& rhs) const {
          return (current == rhs.current); }
        bool operator!= (const const_iterator& rhs) const {
          return !(*this == rhs); }
    };
    class iterator : public const_iterator{
      protected:
        iterator (Node* p) : const_iterator {p} { }

        friend class List<Object>;

      public:
        iterator () { }
        
        Object& operator* () {
          return this->retrieve(); }//TEST
        const Object& operator* () const {
          return const_iterator::operator*(); }

        iterator& operator++ () {
          this->current = this->current->next;
          return *this;
        }
        iterator& operator++ (int) {
          iterator old = *this;
          ++(*this);
          return old;
        }
    };

    List () { 
      init();
    }
    List (const List<Object>& rhs) {
      init();
      for (auto& x : rhs)
        push_back(x);
    }
    List (List<Object>&& rhs) 
      : m_Size {rhs.m_Size}, head {rhs.head}, tail {rhs.tail} {
      rhs.m_Size = 0;
      rhs.head = nullptr;
      rhs.tail = nullptr;
    }

    List& operator= (const List<Object>& rhs) {
      List copy = rhs;
      std::swap(*this, copy);
      return *this;
    }
    List& operator= (List<Object>& rhs) {
      std::swap(m_Size, rhs.m_Size);
      std::swap(head, rhs.head);
      std::swap(tail, rhs.tail);

      return *this;
    }

    iterator begin () {
      return {head->next}; }
    const_iterator begin () const {
      return {head->next}; }
    iterator end () {
      return {tail}; }
    const_iterator end () const {
      return {tail}; }

    int size() const {
      return m_Size; }
    bool empty () const {
      return (m_Size == 0); }

    void clear () {
      while (!empty())
        pop_front();
    }

    Object& front () {
      return *begin(); }
    const Object& front () const {
      return *begin(); }
    Object& back () {
      return *--end(); }
    const Object& back () const {
      return *--end(); }

    void push_front (const Object& x) {
      insert(begin(), x); }
    void push_front (Object&& x) {
      insert(begin(), std::move(x)); }
    void push_back (const Object& x) {
      insert(end(), x); }
    void push_back (Object&& x) {
      insert(end(), std::move(x)); }
    void pop_front () {
      erase(begin()); }
    void pop_back () {
      erase(--end()); }

    iterator insert (iterator itr, const Object& x) {
      Node* p = itr.current; 
      m_Size++;
      return {p->previous = p->previous->next = new Node {x, p->previous, p}};
    }
    iterator insert (iterator itr, Object&& x) {
      Node* p = itr.current;
      m_Size++;
      return {p->previous = p->previous->next = new Node {std::move(x), p->previous, p}};
    }

    iterator erase (iterator itr) {
      Node* p = itr.current;
      iterator retVal {p->next};
      p->previous->next = p->next;
      p->next->previous = p->previous;
      delete p;
      m_Size--;

      return retVal;
    }

    iterator erase (iterator from, iterator to) {
      for (iterator itr = from; itr!= to;)
        itr = erase(itr);

      return to;
    }

    ~List (){
      clear();
      delete head;
      delete tail;
    }
};

#endif

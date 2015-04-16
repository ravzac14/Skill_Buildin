//Zack Raver; ravzac14

//This is the first midterm for the data structures ILC, Spring 2015

#include "my_list.h"
#include <iostream>



/*
1)
[15 points] (Linked Linear List) Write a function to reverse a list using the linked list implementation. Your algoritm should not allocate any additional space to store the list (ie you should not use malloc.) Do this in 2 ways: one as a "member" function and one as a "non-member" function. In the non-member version you can only use the interface functions specified in the template for list. NOTE! In the non-member function even if you don't allocate any addition space in your function, when
you use insert INSERT does a malloc (via a new). This is a HIDDEN cost (which you should reflect in your big-O analysis). If you want to truly NOT allocate any additional space, then you have to add a new method to your linked list implementation. Extra credit if you come up with the new function for this problem ([5 extra credit points]). In the member version you can use the representation.

What is the big-O of your two functions? 

The member function has two pointers that work down the list towards eachother. The loop happens (n/2) times, and each time through it has 8 assignments take place
The bigO would just be O(n/2)


The non member function is awful..Mine goes through the list 3 times, each time doing n inserts or erases..2n inserts n erases
which means this list takes 2x the space of the original list.

*/

List::void reverse ( ) 
{
  //Init some pointers
  front = begin();
  back = end();
  Node* swapper = nullptr;
  
  //find stopping place
  int stop; 
  bool middle;
  if (m_Size % 2 == 1) {
    stop = (m_Size / 2) - 1;
    middle = true; }

  else {
    stop = m_Size / 2;
    middle = false; }

  //Do the swaps
  for (int i = 0; i < stop; i++)
  {
    swapper->next = front.current->next;
    swapper->prev = front.current->prev;
    front.current->next = back.current->next;
    front.current->prev = back.current->prev;
    back.current->next = swapper->next;
    back.current->prev = swapper->prev;
    ++front;
    --back;
  }
  //If there's a middle node, swap its next and previous
  if (middle) {
    swapper->next = front.current->prev;
    front.current->prev = front.current->next;
    front.current->next = swapper->next;
  }
}

void reverse (List<Object>& l) 
{
  iterator front = l.begin();
  iterator back = l.end();
  iterator deleter = l.begin();
  iterator ender = l.end();

  //get to the middle
  for (int i = 0; i < (ceiling(mSize/2)); i++) 
  {
    ++front;
    --back;
  }
  
  //push all the new reversed stuff
  while (front != l.begin()) && (back != l.end())
  {
    l.push_back(front.current());
    l.push_front(back.current());
    --front;
    ++back ;
  }

  //delete all the old stuff
  while (deleter != ender) 
  {
    erase(deleter.current);
    ++deleter;
  }
}

/*
2)
[25 points] (Stack) Implement a simple stack (ie just push, pop, top, isEmpty). You may use either a vector or a list. Assume there is no max size. Do not implement an iterator. Your stack should be templated and should implement the big-3. Use your stack to write a simple paren-matching program. 
*/
#include "my_vector.h"

template <typename Object>
class Stack 
{
  private:
    Vector<Object> stack;

  public:
    Stack () { }

    ~Stack () 
    {
      delete stack;
    }

    Stack& operator= (Stack& rhs)
    {
      stack = rhs.stack;
    }
    void push (Object& x) { stack[size++] = x; }
    void pop ( ) { stack.pop_back; }
    Object top ( ) { return stack[size]; }
    bool isEmpty ( ) { return (size == 0); }
};

bool matchParens (char[] s) 
{
  
  Stack<char> stack;
  for (int i = 0; i < sizeof(s); i++) 
  {
    if (s[i] == ')' && !stack.isEmpty())
      stack.pop();
    else if (s[i] == ')')
      return false; //right paren before a matching left
    else if (s[i] == '(')
      stack.push(s[i]);
  }

  return stack.isEmpty();
}

/*
[10 points] (Queue) Assume that you have a queue implementation (with enqueue, dequeue, isEmpty). Add a "member" method to the queue datstructure to combine two queues by merging every other element of the queue. Ie. if Q1 = [a1, a2, a3] and Q2 = [b1, b2, b3] with a1 and b1 the fronts of their respective queues, the result queue should be R = [a1, b1, a2, b2, a3, b3, ...].
*/

Queue::zip (Queue& rhs)
{
  //assuming dequeue returns the element that deqs
  int size = if (mSize < rhs.Size) mSize ? rhs.mSize;  //is that right? haha
  // zip up to the size of the shorter queue
  for (int i = 0; i < size; i++) 
  {
    if (i % 2 == 0)
      enqueue(dequeue( ));
    else
      enqueue(rhs.dequeue( ));
  }
}

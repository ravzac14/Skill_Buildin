#ifndef STACK_H
#define STACK_H

// This would change based on what you wanted your stack to hold
typedef char element;

typedef struct {
  element* contents;
  int maxSize;
  int top;
} stack_t;

//make a new stack
void emptyStack (stack_t* p, int maxSize);

//destroy a stack
void deleteStack (stack_t* stack_p);

//pop returns the variable (instead of also making a top)
void pushStack (stack_t* p, element e);
element popStack (stack_t* stack_p);

//1 if true, 0 if false
int isEmptyStack (stack_t* stack_p);
int isFullStack (stack_t* stack_p);

#endif

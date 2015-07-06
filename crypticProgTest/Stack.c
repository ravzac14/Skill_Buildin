#include <stdio.h>
#include <stdlib.h>
#include "Stack.h"

void emptyStack (stack_t* p, int maxSize)
{
  element* newContents;

  //Allocate a new array to hold the contents
  newContents = (element*)malloc(sizeof(element) * maxSize);

  if (newContents == NULL) {
    printf ("something broke in stack alloc");
    exit(1);
  }

  p->contents = newContents;
  p->maxSize = maxSize;
  p->top = -1; //empty
}

void deleteStack (stack_t* p)
{
  free(p->contents);
  p->contents = NULL;
  p->maxSize = 0;
  p->top = -1;
}

void pushStack (stack_t* p, element e)
{
  if (isFullStack(p)) {
    printf("stack is full, cant push");
    exit(1);
  }

  p->contents[++p->top] = e;
}

element popStack (stack_t* p)
{
  if (isEmptyStack(p)) {
    printf("stack is empty, cant pop");
    exit(1);
  }

  return p->contents[p->top--];
}

int isEmptyStack (stack_t* p)
{
  return p->top < 0;
}

int isFullStack (stack_t* p)
{
  return p->top >= (p->maxSize - 1);
}

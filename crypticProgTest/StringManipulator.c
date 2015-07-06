/* Write a function that accepts a string of digits and a target value. The output
  should be the two input values folled by a string with +s and *s the digits, such that
  the resulting expression evaluates to the target value. 

  Ex.
  "1231231234",11353-> "12*3+1+23*123*4"
  "3456237490",1185-> "3*4*56+2+3*7+490"
  "3456237490",9191-> "no solution"
*/


#include <stdio.h>
#include <stdlib.h>

//just to get the size of array as an int
int sizeC (char p[])
{
  int o = 0;
  int c = 0;

  while (*(p + o) != '\0') {
    ++c;
    ++o;
  }
  printf("Out of sizeC");
  return c;
}

int sizeI (int p[])
{
  int o = 0;
  int c = 0;

  while (*(p + o) != '\0') {
    ++c;
    ++o;
  }
  printf("Out of sizeI");
  return c;
}

//1 is true, 0 is false
int isDigit (char e)
{
  int i = e - '0';
  return ( (i == 0) || (i == 1) || (i == 2) || (i == 3) 
        || (i == 4) || (i == 5) || (i == 6) || (i == 6)
        || (i == 7) || (i == 8) || (i == 9));
}

int isAdd (char e)
{
  return (e == '+');
}

int isMult (char e)
{
  return (e == '*');
}

int isOp (char e)
{
  return (isAdd(e) || isMult(e));
}

//A simplified version of the Shunting-yard alg.
// Note: I realize that all these new arrays are gross..i was kind of panicking about time
int evaluate (char cs[])
{
  printf("in eval");
  int i = 0; //index
  int nums[sizeC(cs)];
  int numsI = 0;
  char ops[sizeC(cs)];
  int opsI = 0;

  //separate the nums and the ops
  while (cs[i] != '\0') 
  {
    //new chunk of digits (could be just 1)
    char thisNum[sizeC(cs)];
    int thisI = 0;

    while (isDigit(cs[i]))
    {
      thisNum[thisI++] = cs[i++];
    }
    printf("Out of first digit parse");
    nums[numsI++] = atoi(thisNum);
    
    while (isOp(cs[i]))
    {
      ops[opsI++] = cs[i++];
    }
    printf("Out of firs op parse");
  }
  
  printf("Parsed the initial list");

  //evaluate with proper precedence
  if (sizeI(nums) != (sizeC(ops) + 1)) {
    printf("something went wrong when separating ops and nums");
    //exit(1);
  }
  
  i = 0;
  int newNums[sizeI(nums)];
  numsI = 0;
  int newNumsI = 0;
  
  while (ops[i] != '\0')
  {
    while (isAdd(ops[i])) {
      newNums[newNumsI++] = nums[numsI++]; //pushes the numbers that use + into the new array
      ++i;
    }
    
    newNums[newNumsI++] = nums[numsI++] * nums[numsI++];
    ++i;
  }

  int total = 0;
  i = 0;
  while (newNums[i] != '\0')
    total += newNums[i];

  return total;
}


int main ()
{
  char exp[] = "12*3+1+23*123*4";
  printf("started tho?");
  int result = evaluate(exp);
 // printf("Should be 11353, you got: %d\n", result);

  return 0;
}

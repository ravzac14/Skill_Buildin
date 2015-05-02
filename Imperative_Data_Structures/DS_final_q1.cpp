/* Zack Raver; ravzac14
 
 1) Show that the maximum number of nodes in a btree of height h, is 2^h+1 - 1

 bc: h = 0, just the root node, so the max number of nodes is N = 1

 IH: for a tree of height h, the maximum number of nodes is 2^h+1 - 1. 
 RC: for a tree of height h+1, the number N is 2^(h+1)+1 - 1. You would be adding the next power of two, to 
 attain the next fullest tree (from h that is), therefor 2^h+1 - 1 -> 2^(h+1)+1 - 1


 2) Suppose you have a binary tree whose data fields are single characters. When the data fields of the nodes
 are ouput in order, the output is BCAFEDIHGJ, and when they are output in preorder the output is ABCDEFGHIJ. Draw the binary tree showing 
 the data in each node and the pointers between nodes.


Well the preorder would have me think that A is the root, and B is its left child. 
C must be Bs right child, in order for the first bit of the inorder to work
D must be As right child, according to the preorder
E must be D's left child
F must be E's left child, for them to agree 
G must be Ds right child from the pre order
G's left child is H, whose left child is I..
Gs right child is J


         A
    B         D
      C     E   G
           F   H j
              I

3) Use linear probing, a hash table with b=13 buckets, and the hash function f(k) = k % b. Start with an empty hash table and insert
7,42,25,73,14,38,8,22,34,11

a)
[x.x.x.x.x.x.x.x.x.x.x.x.x]
[x.x.x.x.x.7.x.x.x.x.x.x.x]
[x.x.42.x.x.7.x.x.x.x.x.x.x]
[x.x.42.x.x.7.x.x.x.x.x.12.x]
[x.x.42.x.x.7.x.73.x.x.x.25.x]
[14.x.42.x.x.7.x.73.x.x.x.25.x]
[14.x.42.x.x.7.x.73.x.x.x.25.38] collision here
[14.x.42.x.x.7.x.73.8.x.x.25.38] collision here
[14.x.42.x.x.7.x.73.8.22.x.25.38]
[14.x.42.x.x.7.x.73.8.22.34.25.38] collision here
[14.11.42.x.x.7.x.73.8.22.34.25.38] collision here

b) now delete 73, 22 show after each deletion:
[14.11.42.x.x.7.x._73_.8.22.34.25.38]
[14.11.42.x.x.7.x._73_.8._22_.34.25.38]



4) a) Write a c member function that computes the shortest path (to an external node) for each node in a binary tree


int computeS(TreeNode* root)
{
  if (!(root->leftChild && root->rightChild) //If both children are empty, then root is an external node
     root->value = 0;
  else if (!(root->leftChild)) //If one child is empty, then roots value is the value of the other path + 1
      root->value = computeS(root->rightChild) + 1;
  else if (!(root->rightChild)) //If one child is empty, then roots value is the value of the other path + 1
      root->value = computeS(root->leftChild) + 1;
  else 
      root->value = min(compuseS(root->leftChild),computeS(root->rightChild)) + 1;

  return root->value;
}


b) What is the time complexity of your code as a function of the number of nodes in the binary tree?

n log n...it computes it for every n, but the worst case for each node is log n calls, the heights


5) a) Label the tree, is it an AVL tree?

                          30
            25(-1)                          50
    10(+1)            27(-1)       40(-1)          60( 0)
5(0)      15(-1)   26( 0)      35( 0)           55( 0)      70( 0)
      12( 0)

It is an AVL tree

b) add [13,14,36]

13 becomes the right child of 12, requiring a rotation
    13 becomes the right child of 10
    12 is left child of 13, 15 is the right child
14 becomes left child of 15, mkaing the weight of 10 +2..requiring a rotation
    13 becomes the left child of 25
    10 is the left child of 13, with children 5 and 12
    15 is the right child 13, with children 14 and null
36 becomes the right child of 35, requiring a rotation
    36 becomes the left child of 50
    35 is its left child, 40 is its right


6) For the following keys 10,9,8,7,6,5,4,3,2,1
a) Give the 2-3-4 tree after insertion

    10
N       N

        9 10
    N    N      N

        8 9 10
    N     N     N

            9
        7 8     10
    N   N   N   N N

            7 9
    6        8      10
  N  N      N N    N  N

            7 9
    5 6      8      10
  N N N     N N    N  N

            7 9
  4 5 6      8      10
N N N N     N N    N  N
 
                5 7 9
    3 4     6    8       10

                5 7 9
  2 3 4     6    8       10

                5 7 9
1 2 3 4     6    8       10


EC b) either convert it to a RB tree, or insert them directly into an empty RB tree

c) Delete the keys 10,9,8,7 

                5 7 
1 2 3 4     6    8 9 

                5 7 
1 2 3 4     6    8  

                5  
1 2 3 4     6 7 

                5  
1 2 3 4     6 

EC d) Delete the keys 10,9,8,7 from the RB tree


7) Start with a splay tree that is a 15 node full binary tree with keys 1-15
a) Search for the keys 15,14,13,12

After two zig zigs to get 15 to the top
15 has only left child 14
    who has children 12 and 13
    12 has children 8 and 10
    8 has childre 4 and 6
    10 has children 9 and 11
    4 has children 2 and null
    2 has children 1 and 3
    6 has children 5 and 7
After a zig zig, 14 becomes the root
    with left child 12 (same structure as above)
    and right child 15, with left child 13
After a zig zag, 13 becomes the root
    with left child 12 (same structure as above)
    and right child 15, with left child 14
After a zig zig, 12 becomes the root
    with left child 8 (same structure as above)
    and right child 13 whose children are 10 and 14
    10s children are 9 and 11
    14s children are 15 and null

8) A myList has: hasNext, next, remove, an iterator

a) Write non-member equal.

bool equal (MyList& a, MyList& b)
{
  iterator<MyList> itrA = a.begin(); 
  iterator<MyList> itrB = b.begin(); 

  for (itrA; itrA != a.end(); itrA++)
  {
    for (itrB; itrB != b.end(); itrB++)
    {
      if (a.current != b.current)
        return false;
    }
    if (!(itrA.hasNext()) && (itrB.hasNext()) // if A is longer than B
      return false;
  }
  if (!(itrB.hasNext()) && (itrA.hasNext())) //if B is longer than B
    return false;

  return true;
}

b) The time complexity is N, where N is the length of the shortest list (or the length of both, if equal)


9) We hadn't covered X-Matrices, but I'll give these a shot

a) Give a sample 5x5 X-Matrix and its compact representation

x x x x x
- x - x -
- - x - -
- x - x -
x x x x x
 (0,J) (I,J) (I,-J) (N,J)
[xxxxx,xxxxx,xxxxx,xxxxx]

b) Suppose that we define a ds XMatrix, in a one-d array element. Besides element the class
has data members n and zero. Write code for the member method get(i,j) which returns the value of the element in position i,j. 
1<= i <= n and 
1 <= j <= n...be sure to verify this

value get(int i, int j)
{
  if (i > 1 && i < n &&
      j > 1 && j < n)
  {
    iterator<value> itr = begin();
    if (J == 0)
    {
      pass;
    } else if (J == N)
    {
      for n
        ++itr;
    } else if (I == J)
    {
      for n*2
        ++itr;
    } else
    { 
      for n*3
        ++itr;
    }

    for (int k = 0); k < i; k++)
      ++itr;

    return itr->current;
  }
  return null;
}



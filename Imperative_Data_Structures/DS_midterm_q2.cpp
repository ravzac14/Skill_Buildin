
/*
 1.
  Draw the trie with digit numbers for the keys aabbbbaaa, bbbaaabb, aaabaabb, aaaaabaaa,
  bbbaabaa, and aabba. (Assume these are strings, with a termination character.)
  
                                                            . (root)
                                        /                                              \
                                  aa                                                    bbbaa
                /                 |                    \                             /                 \
              bb                abaabb              aaabaaa                      baa                  abb
        /           \             |                     |                         |                    |
     bbaaa          a           /0 2                   /0 3                     /0 4                  /0 1
      |             |
    /0 0           /0 5


2.
   Prove or disprove: A perfectly balanced tree forms if keys 1 to 2^k - 1 are inserted 
   in order into an empty leftist heap

BC: k = 1, a one node tree is balanced.
IH: Inserting keys 1 to 2^k -1 into an empty leftist tree will be balanced

RC: Inserting keys 1 to 2^(k+1) -1 into an empty leftist tree will be balanced 

Because leftist trees are still binary, and insertion into them is balanced based on rotations, 
if a tree with 2^k nodes is balanced, adding and additional 2*k+1 nodes will maintain the balance,

unfortuantely, you cant assume its balanced, because it doesnt update every insert as with this ex:

    with the bc,  k =1 is balanced
    k = 2, is a 3 nodes tree with lchild 2, and 2s lchild 3

        1
    2
3

Unbalanced! Therefore this does not hold


3.
   Prove or disprove: A perfectly balanced tree forms if keys 1 to 2^k - 1 are inserted 
   in order into an empty skew heap
 
As with the leftist trees the heap order property is managed by merges, not per insert, and
not every merge requires a rotation
Therefore you can't assume that a skew heap is balanced, as you could with a binarytree or binary heap


4.
 For the binomial queue:
 (a)
  Modify the merge routine to terminate merging if there are no trees left in Hsub2 and the carry
  tree is NULL.

In the case where only the left tree has items left, you would break;

 (b)
   Modify the merge so that the smaller tree is always merged into the larger.
   
In the calls to combineTrees, you would check which is smaller, and alter the function call thusly
ie

assuming function call looks like this combineTrees(BQ smaller, BQ larger);

if (t1.size() < t2.size())
    combineTrees(t1,t2);
else
    combineTrees(t2,t1);

 (c)
    What impact do these changes have?
    
Makes it a little more efficient, dont have to run through the rest of t1 checking for an empty t2 every time.

The 2nd lets you resize less often, and takes up less space with the carry tree
    
5.
     Consider the following input with 10 keys (each is a letter) to QuickSort.
     K; G; I; K; N; V; S; S; W; Q
     Assume the leftmost element is the partitioning element. Show the array after the parti-
     tioning step is complete
     

Pivot = K
[K,G,I,K,N,V,S,S,W,Q]
   i               j
Before 1st swap (dupes)
[K,G,I,K,N,V,S,S,W,Q]
       ij      
After1st swap (dupes)
[K,G,I,K,N,V,S,S,W,Q]
       ij      
Stop to swap, but i and j have passed eachother
[K,G,I,K,N,V,S,S,W,Q]
     j   i      
so we swap j and pivot
[I,G,K,K,N,V,S,S,W,Q]
j    pv  i
left      right
Done

6.
    (a)
        Prove that any comparison-based algorithm to sort 4 elements requires 5 comparisons.
        
        -you will be comparing each element log n times, resulting in nlogn compares
        -since n = 4. floor(4log4) = 5


    (b)
        Give an algorithm to sort 4 elements in 5 comparisons.

[4,3,2,1]
 p i   j
[4,3,2,1]
 p     ji
[1,3,2,4]
   p i j
[1,3,2,4]
   p j i
[1,2,3,4]   Done, 5 compares, Quicksort is an algorithm to do that ^
   j p i 
 

7.
          Suppose we implement the median-of-three routine as follows: Find the median of
                a[left],a[center],a[right] 
          and swap it with a[right]. Proceed with the normal partitioning step with i at left 
          and j at right-1
    
    a) input is 2,3,4..n-1,n what is the runtime?

-every time the pivot will be exactly in the center of the array, evenly splitting the partitions
-- resulting in logn splits
-each time setting partitions you will check n elements,
-- n (checks per) 
-each time setting the partitions you will preform the 2 swaps putting the element at the end, and back in place
-- 2*(n/2) (swaps) total

    total result is:  nlogn + 2*(n/2), or O(nlogn)


    b) input is in reverse order what is runtime?)

-every time the pivot will be exactly in the center of the array, evenly splitting the partitions
-- resulting in logn splits
-each time setting partitions you will check n elements,
-- n (checks per) 
-each time setting the partitions you will preform the n/2 + 2 swaps (+2 is putting the element at the end, and back in place)
-- logn * (n/2 + 2) (swaps) total

    total result is:  nlogn + (n/2 + 2)logn, or O(nlogn)


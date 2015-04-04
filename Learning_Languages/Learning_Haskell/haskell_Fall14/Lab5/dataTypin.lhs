Zack Raver; ravzac14
for lab5 

define bit2int; define Bit type

bit2int :: [Bit] -> Int



define int2bit

int2bit :: Int -> [Bit]


Rewrite bin2int as a fold. (I seem to recall you might need to reverse the list; not sure).

A higher-order function unfold defined as follows captures a recursion pattern for producing a list, a kind of dual to folding.

unfold p h t x | p x       = []
               | otherwise = h x : unfold p h t (t x)

Rewrite unfold as a simple composition of some other higher-order functions in the Prelude. You may need to invent some examples to see how unfold works.

Redefine the function int2bit as an unfold.

Redefine the function map f as an unfold.

Redefine the Prelude function iterate f as an unfold.

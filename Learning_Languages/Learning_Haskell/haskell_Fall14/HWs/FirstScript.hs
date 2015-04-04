{- First Script.hs
 - Used for Assigment1 in Fall14 Haskell -}

module FirstScript where

--	The Value size is an int defined to be the sum of 12 and 13

size :: Integer
size = 12 + 13

--	The function to square an int

square :: Integer -> Integer
square n = n * n

--	The function to double an int

double :: Integer -> Integer
double n = 2 * n

--	An Example using these guys

example :: Integer
example = double (size - square (2 + 2))


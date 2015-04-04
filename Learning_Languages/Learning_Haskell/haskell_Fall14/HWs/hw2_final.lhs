Zack Raver; ravzac14
10/9/14 due week 3

Finished all of hw2, had some problems with MaxFN (find the max of a function mapped over a list)
The shapes class was mostly from something i found on stack overflow (or the wiki)


Read Ch3-5.1, 5.3
4.17, 4.18, 4.19, 4.20, 4.21, 4.31, 4.32, 5.5, 5.7, 5.9
Tim Sheard's Ass 1 wksht

>	import Data.List
>	import Data.Char

*************************BOOK EXCERCISE*************************S

4.17) Define rangeProduct which given m and n, return m*(m+1)...*(n-1)*n

>	rangeProduct m n 
>		| n == m	= n
>		| n > m		= multRange m n 1
>		| otherwise = multRange n m 1
>		where
>			multRange lil big sum
>				| lil <= big 	= (multRange (lil + 1) big (sum * lil)) 
>				| otherwise 	= sum 
 

4.18) write a fac that uses rangeProduct

>	rangeFac = rangeProduct 1 

4.19) Give a recursive def of multiplication of integers, using addition

>	recMult x 0 = 0
>	recMult x y = x + (recMult x (y - 1))

4.20) Define intSquareRoot which returns the largest int <= n which is the sqrt of 
m (your given int)

>	intSqrt n = max $ [xs | xs <- (take n [0,1..]), xs <= (round (sqrt (fromIntegral n)))]

4.21) this one is unclear...given n return the max of f 0, f 1, f 2...f n, where
f is an Int -> Int function

	maxFN = max . makeList
		where
			makeList n = reverse $ rangeFac n :(makeList (n - 1))

4.31) Define a recursive function to find the highest common factor of two pos ints

>	compareLists ls@(x:xs) list@(y:ys) = max $ ls `intersect` list

>	gcd' 0 0 		= undefined
>	gcd' x 0 		= abs x
>	gcd' 0 y 		= abs y
>	gcd' x y
>		| x < 0		= gcd' (-x) y
>		| y < 0		= gcd' x (-y)
>		| x == y	= x
>		| x < y		= gcd' y x
>		| otherwise	= gcd' y (x `rem` y)


4.32) Define a funct to calc 2^n, using:
n is even: 2^n = 2^2*m = 2^m^2
n is odd: 2^n = 2^2*(m+1) = 2^m^2 * 2

This one is dumb haha


5.5) Define a funct to give the length of the perimeter of a geometrical shape, of
type Shape. What is the type of this function

>	{-# LANGUAGE ExistentialQuantification #-}

>	class Shape' s 
>		where
>			per 	:: a -> Double
>			area	:: a -> Double

>	data Shape'' 	= forall a . Shape' a => Shape'' a

>	type Radius 	= Double
>	type Side		= Double
>	type Base		= Double
>	type Height		= Double

>	data Circle		= Circle Radius
>	data Rectangle	= Rectangle Side Side
>	data Square		= Square Side
>	data Triangle	= Triangle Side Side Side

>	instance Shape' Circle where
>		per	(Circle r) 	= 2 * pi * r
>		area (Circle r)	= pi * r * r

>	instance Shape' Rectangle where
>		per (Rectangle x y)		= 2 * (x + y)
>		area (Rectangle x y)	= x * y

>	instance Shape' Square where
>		per (Square s)	= 4 * s
>		area (Square s)	= s * s

>	instance Shape' Triangle where
>		per (Triangle x y z)	= x + y + z
>		area (Triangle x y z)	= (1/2) * x * ( y * ( sin ( atan ( z / y))))

5.7) Add an extra constructor to Shape for triangles, and extend the functions isRound, area 
and perimeter to include triangles.

5.9) Look at Move and Shape and what form do show take?


That ^ 


**********************TIM SHEARD'S ASSIGNMENT 1**********************************

1) Prelude> :t 3
3 :: (Num t) => t
Prelude> :t even
even :: (Integral a) => a -> Bool
Prelude> :t (even 3)
(even 3) :: Bool
Prelude> :t [1,2,3]
[1,2,3] :: (Num t) => [t]
Prelude> :t head
head :: [a] -> a
Prelude> :t (head [1,2,3])
(head [1,2,3]) :: (Num t) => t

2) a) func1 :: (Float -> Float) -> Float

>	func1 n = 3
>	func1' = func1 


b) func2 :: Float -> (Float -> Float)

>	func2 n = n `div` 3

c) func3 :: (Float -> Float) -> (Float -> Float)

>	func3 n = func2 n `div` func1' n

3) write a strLength funct

>	strLen []		= 0
>	strLen (x:xs)	= 1 + (strLen xs)

4) Write a fac function

>	fac'' = rangeProduct 1	

5) Write an nCopies function

>	nCopies i 0 = []
>	nCopies i n = i:(nCopies i (n - 1))


6) write the powers' function

>	powers' i 0 = 1
>	powers' i n = i * (powers' i (n - 1))

7) Write a funct which converts a string of digits into an int...
ord 'l' --> 49

>	digitsToInt [] 		= []
>	digitsToInt (x:xs) 	= ord x : (digitsToInt xs)


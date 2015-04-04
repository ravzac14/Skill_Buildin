Zack Raver; ravzac14
due wk 6

Did most of hw5, skipped the transmission (of bitstrings) section..and the Either section


>	import Data.List
>	import Data.Maybe
>	import Data.Char

Read Ch14 of CRFP on Algebraic Data Types

A transmission simulator

Write the function bin2int :: [Bit] -> Int that converts a list of 0s and 1s representing a binary number into the corresponding integer. You get to decide how to represent the type Bit.

>	data Bit 	= Zero| One
>		deriving (Show, Eq)

>	eval Zero	= 0
>	eval One	= 1

>	bitEval 0	= Zero
>	bitEval 1	= One

	
bin2int 		:: [Bit] -> Int

>	bin2int []		= 0
>	bin2int (x:xs) 	= (if x == One then 2^indexValue else 0) + (bin2int xs)
>		where
>			indexValue = length xs 


Write the inverse function int2bin :: Int -> [Bit] that converts an integer into a binary representation as list of 0s and 1s.

int2bin 	:: Int -> [Bit]

>	int2bin 0	= []
>	int2bin x	= [One] ++ (makeZeros nextX (tail (twos x))) ++ (int2bin (nextX)) 
>		where 
>			twos y = reverse [xs | xs <- [2^ys | ys <- [0..20]], xs <= y] 
>			nextX = x - (head (twos x))
>			makeZeros x [] 			= []
>			makeZeros x (y:ys)
>				| x < y				= [Zero] ++ (makeZeros x ys)
>				| otherwise			= []

The next series of exercises are from Hutton's textbook. The code is simpler if you assume bit strings with higher order positions on the right instead of the left. The goal is to simulate binary transmission of strings as in the following functions

  transmit :: String -> String
  transmit = deocde . channel . encode

  channel :: [Bit] -> [Bit]   -- simulates a transmission channel.
  
>	channel = id

so
  transmit "hi there Robo 432!"

prints

"hi there Robo 432!"


Code make8 :: [Bit] -> [Bit] that pads or truncates to make exactly 8 bits.


>	make8					:: [Bit] -> [Bit]
>	make8 xs
>		| length xs == 8	= xs
>		| length xs < 8		= make8 (Zero:xs)
>		| otherwise			= drop ((length xs) - 8) xs


Code encode :: String -> [Bit] that encodes a string of characters as a list of bits that encode the 8-bit ascii representations.

>	encode []		= []
>	encode (s:ss)	= bitEval (digitToInt s):(encode ss)

Code chop8 :: [Bit] -> [[Bit]] that chops up a long list of bits into a list of 8-bit binary numbers.

>	chop8 []		= []
>	chop8 list	
>		| len' == 0				= (take 8 list):(chop8 (drop 8 list))
>		| otherwise				= (make8 (take len' list)):(chop8 (drop len' list))
>		where
>			len' = (length list) `mod` 8

Code decode :: [Bit] -> String that decodes a list of bits into the corresponding string of characters.

>	decode []		= []
>	decode (s:ss)	= intToDigit (eval s):(decode ss)


Folds and unfolds

Rewrite bin2int as a fold. (I seem to recall you might need to reverse the list; not sure).

	bin2int []		= 0
	bin2int (x:xs) 	= (if x == One then 2^indexValue else 0) + (bin2int xs)
		where
			indexValue = length xs 
foldl f z xs = f z' x1 ( f z'' x2...

>	bin2int' = foldr twoPower 0
>		where
>			twoPower z x 
>				| x == One		= z + 2^z
>				|otherwise		= z


A higher-order function unfold defined as follows captures a recursion pattern for producing a list, a kind of dual to folding.

unfold p h t x | p x       = []
               | otherwise = h x : unfold p h t (t x)

Rewrite unfold as a simple composition of some other higher-order functions in the Prelude. You may need to invent some examples to see how unfold works.

>	ana unspool finished state =
>	  if finished state
>	     then []
>	     else value : (ana unspool finished state')
>	          where (value, state') = unspool state


Redefine the function int2bit as an unfold.

int2bin 0	= []
int2bin x	= [One] ++ (makeZeros nextX (tail (twos x))) ++ (int2bin (nextX)) 
	where 
		twos y = reverse [xs | xs <- [2^ys | ys <- [0..20]], xs <= y] 
		nextX = x - (head (twos x))
		makeZeros x [] 			= []
		makeZeros x (y:ys)
			| x < y				= [Zero] ++ (makeZeros x ys)
			| otherwise			= []

>	int2bit x	= unfold checkZero x 0 0
>		where
>			twos y = reverse [xs | xs <- [2^ys | ys <- [0..20]], xs <= y] 
>			nextX = x - (head (twos x))
>			checkZero 

Redefine the function map f as an unfold.

>	map' f xs 		= unfoldr (\x -> Just (f (head xs), tail xs)) xs

Redefine the function iterate f as an unfold.

>	iterate' f	= unfoldr (\x -> Just (x, f x))

Redefine the function chop8 as an unfold.

>	chop8' xs	= unfoldr (\y -> if ((length xs) `mod` 8 != 0) then (makeZeros ((length xs) `mod` 8)) ++ 

CRFP exercises Ch 14: 14.4, 14.5, 14.6, 14.8, 14.10, 14.13, 14.15 on simple integer expression trees. Be sure your evaluator handles divide by zero exceptions somehow.

14.14) 

data Person = 	Adult Name Address Bio |
				Child Name

data Bio =		Parent String [Person] |
				NonParent String

showPerson (Adult nm ad bio)
	= show nm ++ show ad ++ showBio bio

showBio (Parent st perList)
	= st ++ concat (map showPerson perList)

14.15) Extend Expr to contain conditional exprss...If b e1 e2, where e1 and e2 are expressions, and b is a boolean expr, a member of type BExpr

b1 if true, b2 if false

>	data Expr = Lit Integer | 
>				Op Ops Expr Expr |
>				If BExpr Expr Expr

>	data BExp = BoolLit Bool |
>				And BExp BExp | 
>				Not BExp |
>				Equal Expr Expr |
>				Greater Expr Expr

14.4) size :: Expr -> Integer which counts the number of operators 

>	data Expr = Lit Integer |
>				Expr :+: Expr |
>				Expr :-: Expr |
>				Expr :~: Expr |
>				Expr :*: Expr |
>				Expr :/: Expr

14.5) Add mult and div. for expr; redefine eval, show and size

eval (Lit 67) ...evaulates and expr
shows an expr

>	eval' expr 


14.6) Show how eval show and size are define for (14.15)'s expr def with:

>	data Ops = Add | Sub | Mul | Div


14.8) Complete the redefiniton of functions over Expr after it has been defined using infix constructors :+: and :-:


14.10) Define a function to decide whether a number is an element of NTree

>	data NTree = 	NilT |
>					Node Integer NTree Ntree

The null tree is given by NilT

>	sumTree Nilt			= 0
>	sumTree (Node n t1 t2) 	= n + sumTree t1 + sumTree t2

>	depth NilT				= 0
>	depth (Node n t1 t2)	= 1 + max (depth t1) (depth t2)

>	occurs NilT p			= 0
>	occurs (Node n t1 t2) p
>		| n == p			= 1 + occurs t1 p + occurs t2 p
>		| otherwise			= occurs t1 p + occurs t2 p

14.13) Define collapse and sort..which turns a tree into a list (enum left add node enum right) 

>	collapse' NilT 			= []
>	collapse' Node n t1 t2	= collapse t1 ++ Node n ++ collapse t2

>	sortTree NilT			= []
>	sortTree Node n t1 t2	= map addNode (quicksort' (map stripNode (collapse Node n t1 t2)))
>		where
>			quicksort' []		= []
>			quicksort' (x:xs)	= (quicksort' [a | a <- xs, a <= x]) ++ [x] ++ (quicksort' [b | b <- xs, b > x])

>	stripNode Node n		= n

>	addNode n				= Node n



CFRP exercises 14.19, 14.20 on the Either type.

14.19) Show that any function of type a -> b can be transformed into functions of type:

a -> Either b c
a -> Either c b

I mean, even if it were id you could retrun Either x x


14.20) How could you generalize either to join so that it has type

join :: (a -> c) -> (b -> d) -> Either a b -> Either c d

join (Either a b) (Either c d)	= a or b or c or d?


CFRP exercises 14.23, 14.25, 14.26, 14.27 on the Maybe type.

14.23) Using the functions mapMaybe and maybe or otherwise define

process :: [Int] -> Int -> Int -> Int

so that process xs n m takes the nth and mth items of the list of xs and returns their sums. Your func should return 0 if either nth or mth nums are not in the list

>	process xs n m = mapMaybe sum ((maybe 0 (n !! xs)):[(maybe 0 (m !! xs))])


14.25) What are the values of type Maybe (Maybe a)? Define a funct:

squashMaybe :: Maybe (Maybe a) -> Maybe a

which will squash Just (Just x) to Just x and all other values to Nothin

>	squashMaybe x	= if isJust(isJust x) then fromJust x else Nothing

14.26) similar to mapMaybe, define:

composeMaybe :: (a -> Maybe b) ->
				(b -> Maybe c) ->
				(a -> Maybe c)

composes to error raising functions. How could you use mapMaybe the func composition operator and the squash func to define this

>	composeMaybe f g x	= if isJust x then f . g (fromJust x) else Nothing


14.27) The Maybe type could be generalized to allow messages to be carried in the Nothing part, thus:

data Err a = OK a | Error String

How to mapMaybe, maybe and composeMaybe have to be modified to accomodate this new def?

>	newMapMaybe f [] s		= []
>	newMapMaybe f (x:xs) s 	= if isJust (f x) then (f x):(newMapMaybe f xs s) else Error s

>	maybe d f m s			= if isJust (f m) then f m	else Error s ++ ", resulting in " ++ d

>	composeMaybeNew f g x s	= if isJust x then f . g x else Error s



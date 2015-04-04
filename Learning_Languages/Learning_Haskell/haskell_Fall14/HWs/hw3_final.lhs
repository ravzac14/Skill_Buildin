Zack Raver; ravzac14
due week 4

Answered all the qs and did the exercises for hw3 (the database was fun)


>	import Data.Char
> 	import Data.List

Read Ch5, Ch6, Ch7 of CRFP

CRFP exercises 5.15, 5.16, 5.17, 5.18, 5.19, 5.20, 5.21, 5.22 (whew! but mostly short)

CRFP exercise 5.28. Don't skip this more interesting one. You'll need the rest of the code from the book.


Write a function groupByN with the type:
groupByN :: Int -> [a] -> [[a]]

This function splits the given list in sub-lists (which result in a list of lists), where the sublists have a given length. Only the last sub-list may be shorter, if necessary. An example application of the function is:
groupByN 3 [1,2,3,4,5,6,7,8,9,10]
[[1,2,3], [4,5,6], [7,8,9], [10]]

>	groupByN	::	Int -> [t] -> [[t]]
>	groupByN 0 _		= []
>	groupByN _ []		= []
>	groupByN n xs 		= (take n xs):(groupByN n (drop n xs))


Write a function listTrim with two lists as parameters that deletes the first occurrence of every element of the second list from the first list.

>	listTrim xs []					= xs
>	listTrim [] _					= []
>	listTrim xs (y:ys)				= listTrim xs' ys
>		where
>			xs' 
>				| y `notElem` xs	= xs
>				| otherwise			= comp xs y
>			comp (z:zs) w 		
>				| z == w			= zs
>				| otherwise			= z:comp zs w

>	listTrim' xs []					= xs
>	listTrim' [] xs					= []
>	listTrim' xs (y:ys)				= listTrim' (delete y xs) ys

>	fancyTrim xs ys = [zs | zs <- listTrim' xs ys]

Now write a function listDiff with two lists as parameters that deletes every occurrence of every element of the second list from the first list. This is analogous to a set difference

>	listDiff 	::	(Eq a) => [a] -> [a] -> [a]
>	listDiff xs []			= xs
>	listDiff [] _			= []
>	listDiff xs (y:ys)		= listDiff xs' ys
>		where
>			xs' 			= filter (/= y) xs


5.15) Value of [0,0.1,...,1]

is a list of tenths..with trailing 0s


5.16) [2,3] has two items, [[2,3]] has 1 item and is of list of lists of integers


5.17) What does [2 .. 2] evaluate to? What about [2,7..4]? [2,2..2]? 

The first two are just a list holding only 2, the last is an infinite list of 2s


5.18) 

doubleAll :: [Integer] -> [Integer]

>	doubleAll xs = [(y * 2) | y <- xs]


5.19)

capitalize :: String -> String

>	capitalize xs = [toUpper c | c <- xs]


capitalizaLetters :: String -> String but removes all non letters

>	capLetters xs = [c | c <- (capitalize xs), c `elem` ['A'..'Z']]


5.20)

divisors :: Integer -> [Integer]

>	divisors x = [y | y <- [1..x] , x `mod` y == 0]


isPrime :: Integer -> Bool

>	isPrime z 
>		| length (divisors z) > 2		= False
>		| otherwise						= True


5.21) 

matches :: Integer -> [Integer] -> [Integer] ie matches 1 [1,2,1] -> [1,1]

>	matches x (y:ys)
>		| ys == []	= []
>		| x == y 	= x:matches x ys
>		| otherwise = matches x ys


elem :: Integer -> [Integer] -> Bool

>	elem'' x ys = any (==x) ys


5.22)

onSeparateLines :: [String] -> String

	onSeparateLines (x:xs)	 
		| xs == []			= xs
		| otherwise			= x ++ ["\n"] ++ (onSeparateLines xs)


5.28)

>	type Person 	= String
>	type Book 		= String

>	data Loan 		= Loan Person Book
>	type Database	= [(Person, Book)]

>	exampleBase 	= [("Alice", "Tintin"),("Anna","Little Women"),("Alice", "Asterix"),("Rory","Tintin")]


Define books, borrowers, borrowed, and numBorrowed

books			:: Database -> Person -> [Book]

>	books db p	= [snd bs | bs <- db, (fst bs) == p]

borrowers		:: Database -> Book -> [Person]

>	borrowers db b = [fst ps | ps <- db, (snd ps) == b]

borrowed		:: Database -> Book -> Bool

>	borrowed (db:dbs) b | snd db == b		= True
>						| dbs == []			= False
>						| otherwise			= borrowed dbs b

numBorrowed		:: Database -> Person -> Int

>	numBorrowed db p = length (books db p)



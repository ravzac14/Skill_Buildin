Zack Raver; ravzac14
due wk 5 

Did all the exercises for hw4 except uncurrylist..which confused me (the receipt project was fun)


>	import Test.QuickCheck

Define composeList that composes a list of functions into a single functions


>	compList []	f n		= f $ n
>	compList (x:xs) f n	= compList xs (x . f) n


Rewrite composeList as a fold

>	fl 	= [(+1),(*2),(/2),((-)1)]
>	fl'	= [(+1),(+1),(+1)]

>	foldComp xs n		= foldr (.) id  xs $ n


Write a function called group that groups neighboring elements by the standard
equality predicate (==). Not this is not the same as groupByN...This one takes
a lit and returns a list of lists such that the concat of the result is equal
to the argument. Moreover each sublist in the result contains only equal elements

ie

group "Mississippi" = ["M","i","ss","i","ss","i","pp","i"]

>	groupBy p []			= []
>	groupBy p list@(x:xs)	= [oneGroup] ++ (groupBy p zs)
>		where
>			oneGroup = takeWhile (p x) list
>			zs = drop (length oneGroup) list


Write groupBY :: (a -> a -> Bool) -> [a] -> [[a]]...which groups by a given predicate
which must be refl, trans, and sym

Did that ^


Ch 7; 7.8, 7.9 : as reg and folds, 7.10 
Ch 10; 10.9...rewrite as unfold
Ch 11; 11.17, 11.18
Ch 6; 6.44


7.8) Using primitive recursion

elemNum :; Integer -> [Integer] -> Integer
num times n is in xs

>	elemNum n []		= 0
>	elemNum n (x:xs)	
>		| n == x		= 1 + (elemNum n xs)
>		| otherwise		= elemNum n xs



7.9) unique :: [Integer] -> [Integer]

all xs that only show up once

>	unique []							= []
>	unique (x:xs)
>		| not (x `elem` xs)				= x:(unique xs) 
>		| otherwise						= unique [zs | zs <- xs, zs /= x]


7.10) write a property that links 7.8 and 7.9

elemNum x xs == 1, is unique


10.9) define iter n f x = f (f (f...(f x)))...where f occurs n times on the right hand side of the equation

ie iter 3 f x = f (f (f x))

>	iter 0 f x	= x
>	iter n f x	= iter (n-1) f (f x)


11.17) curry3 :: ((a,b,c) -> d) -> (a -> b -> c -> d)
		uncurry3 :: (a -> b -> c -> d) -> ((a,b,c) -> d)

>	curry3' f (a,b,c)		= f a b c

>	uncurry3' f a b c		= f (a,b,c)


11.18) currylist :: ([a] -> d) -> (a -> [a] -> d)
	uncurryList :: (a -> [a] -> d) -> ([a] -> d)

>	currylist' f (x:[])			= x
>	currylist' f (x:y:xs)		= currylist' f ((f x y): xs)

	uncurrylist' f = f 
	uncurrylist' f zs		


6.44)

this##############TYPES FOR BILL Q'S#################################


>	type Name = String
>	type Price = Integer
>	type BarCode = Integer

> 	type Database = [(BarCode,Name,Price)]
>	codeIndex :: Database
>	codeIndex = [	(4719, "Fish Fingers", 121),
>					(5643, "Nappies", 1010),
>					(3814, "Orange Jelly", 56),
>					(1111, "Hula Hoops", 21),
>					(1112, "Hula Hoops (Giant)", 133),
>					(1234, "Dry Sherry", 540)]
>	type TillType = [BarCode]
>	type BillType = [(Name,Price)]

>	lineLength :: Int
>	lineLength = 30


gets##########HELPER FUNCTIONS FOR THE BILL Q'S#######################

Triple -> t1 | t2 | t3

>	fst' (a,_,_)	= a
>	snd' (_,b,_)	= b
>	trd' (_,_,c)	= c

Triple -> Tuple

>	pullTup (a,b,c)  	= (b,c)

If it hits the end of the database it's an unknown item..so thats base case

>	pullTrp t []		= (t, "Unknown Item", 0)
>	pullTrp t (d:ds)
>		| t == fst' d	= d
>		| otherwise		= pullTrp t ds

Prints '.'s based on line length in formatting the bill

>	printDots 0			= ""
>	printDots n 		= '.': printDots (n-1)




ignored##########ACTUAL BILL FUNCTIONS####################################


makeBill :: TillType -> BillType

>	makeBill []	db		= []
>	makeBill (t:ts) db 	= (pullTup (pullTrp t db)):(makeBill ts db)

formatBill :: BillType -> String

>	formatBill (b:[])	= ""
>	formatBill (b:bs) 	= (fst b ++ printDots (25 - length (fst b)) ++ show(snd b) ++ "\n") ++ (formatBill bs)

produceBill :: TillType -> Srting

>	produceBill ts db = formatBill $ makeBill ts db


formatPence :: Price -> String

>	formatPence ps	= show(ps)

formatLine :: (Name,Price) -> String
formatBill does this

formatLines :: [(Name,Price)] -> String
formatBill does this

makeTotal :: BillType -> Price

>	makeTotal bs = foldr (sum . snd) 0


formatTotal :: Price -> String

>	formatTotal t = "Total" ++ printDots 20 ++ show(t)


6.44) using those ^ define formatBill :: BillType -> String
so 

>	sampTill = [1234, 4719, 3814, 1112, 7777, 1234]


>	sampBill = [("Dry Sherry", 540), ("Fish Fingers", 121), ("Orange Jelly", 56), ("Hula Hoops (Giant)", 133), ("Unknown Item", 0), ("Dry Sherry", 540)]


produces -> 

	Haskell Stores

Dry Sherry..............5.40
Fish Fingers............1.21
Orange Jelly............0.56
Hula Hoops (Giant)......1.33
Unknown Item............0.00
Dry Sherry..............5.40

Total..................13.90





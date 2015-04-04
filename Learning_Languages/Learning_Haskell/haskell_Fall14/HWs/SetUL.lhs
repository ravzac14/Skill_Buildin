Zack Raver;ravzac14

****IS FINISHED***

this is the unordered set module

>	module SetUL (Set, null, member, empty, fromList, toList, insert, delete)
>	     where

>	import Prelude hiding (null)

>	newtype Set a = Set [a]

>	instance (Eq z) => Eq (Set z) where
>		(Set a) == (Set b) = (setEqual a b)

>	instance (Show a) => Show (Set a) where
>		show (Set a)	= "Set " ++ (show a)


>	setEqual [] []	= True
>	setEqual (a:as) (b:bs) 
>		| a == b		= setEqual as bs
>		| a `elem` bs	= setEqual as ((takeWhile (/=a) bs) ++ (tail (dropWhile (/=a) bs)))
>		| otherwise		= False

------------------------------ Specification----------------------------------
-- Set ADT Signature consistent with Data.Set
-- Note the name clashes with Prelude require qualified references

null :: Eq a => Set a -> Bool                     -- is this the empty set?

>	null (Set as) 		= if as == [] 	then True 	else False

>	member  :: Ord a => a -> Set a -> Bool    -- is this a member of the set?
>	member a (Set xs)	= if a `elem` xs	then True	else False

>	empty 	:: Set a                            -- create and empty set.
>	empty	= (Set [])

>	fromList :: Ord a => [a] -> Set a         -- create a set from a list
>	fromList []			= Set ([])
>	fromList (x:xs)	
>		| x `elem` xs	= fromList xs
>		| otherwise 	= Set (x:(toList (fromList xs)))

>	toList :: Set a -> [a]                    -- convert a set to a list
>	toList (Set as)		= as

>	insert  :: Ord a => a -> Set a -> Set a
>	insert n (Set xs)	= if member n (Set xs)	then Set xs 	else Set (n:xs)

>	delete  :: Ord a => a -> Set a -> Set a
>	delete n (Set xs)	= if (member n (Set xs))	then (Set (filter (/=n) xs))	else (Set xs)



Zack Raver; ravzac14
week 4 lab

>	import Data.Char


ch5) 

>	pythag n = [(a,b,c) | a <- [1..n], b <- [a..n], c <- [b..n], a^2 + b^2 == c^2]

>	perfect' n 	| sum (factor n) == n	= True
>				| otherwise				= False
>				where
>					factor x = [xs | xs <- [1..x], xs `mod` x == 0] 

>	listPerfect n = [xs | xs <- [1..n], perfect' n == True]

>	scalarProduct xs ys = zipWith (*) xs ys

>	concatLists xss = foldr (++) [] xss

11-20 of 99 haskell problems:

11) encodeModified "aaaabccaadeee" -> [Multiple 4 'a', Single 'b', Multiple 2 'c', Multiple 2 'a', Single 'd', Multiple 3 'c']

>	encodeModified [] xs		= xs
>	encodeModified sss@(s:ss) xs	| howMany s sss == 1		= xs ++ (encodeModified (drop ((howMany s sss) - 1) ss) ["Single '" ++ [s] ++ "'"])
>									| howMany s sss >= 2 		= xs ++ (encodeModified (drop ((howMany s sss) - 1) ss) ["Multiple " ++ [intToDigit (howMany s sss)] ++ " '" ++ [s] ++ "'"])
>								where	
>									howMany x xs = length $ takeWhile (==x) xs

>	encode' xs = encodeModified xs []



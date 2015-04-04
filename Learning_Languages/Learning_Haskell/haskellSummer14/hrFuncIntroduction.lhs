This is just a practice program comprised of the challenges found on
hackerrank.com


This one filters the odd indices out of a list

>	filterOdd lst
>		| lst == []	|| tail lst == [] 	= lst
>		| tail (tail lst) == []			= lst' 
>		| otherwise 					= head lst:filterOdd (tail (tail lst))
>		where
>			lst' 						= reverse (tail ( reverse lst)) 



This should take an input from a file on integers on newlines
The first number (X) is the delimiter and the rest are filtered out if >= X

	f :: Int -> [Int] -> [Int]

>	filterGTE n arr	
>		| arr == [] 					= arr  
>		| otherwise 					= next
>			where
>				next
>					| head arr < n		= head arr:(filterGTE n (tail arr))
>					| otherwise			= filterGTE n (tail arr)



Update the values of a list with their absolute values

>	filterAbs arr 
>		| tail arr == []	= [] 
>		| otherwise 		= abs (head arr):(filterAbs (tail arr))



Count the # of elements in an array w/o using count, size or length equivalents. 

	len :: [a] -> Int

>	len' lst = sum [1 | _ <- lst]



Given a list repeat each element of the list N times

>	repeat' n arr 
>		| arr == []	= arr
>		| otherwise	= take n (repeat (head arr))++(repeat' n (tail arr))



Given a list return a sum of the odd elements 


>	sumOdd arr = sum [x | x <- arr, (x `mod` 2) /= 0]



Create an array of N integers, where n is specified on input. ie n=4, could be [1,1,1,1] or [1,2,3,4]


>	makeArray n = take n (repeat 1)



Reverse a list without using 'reverse'

>	reverse' lst 
>		| lst == []		= lst
>		| otherwise		= reverse' (tail lst)++((head lst):[])



Print hello world n times

>	hello_worlds n 	
>		| n > 0		= putStrLn "Hello World" >>
>		  				hello_worlds (n - 1)
>		| otherwise = putStrLn "Done"


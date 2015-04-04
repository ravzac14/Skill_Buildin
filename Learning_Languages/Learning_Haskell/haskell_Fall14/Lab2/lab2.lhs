Zack Raver; ravzac14
10/7/14

Testing do notation and IO monads

>	main = do
>		putStrLn "Please enter your face"
>		name <- getLine
>		putStrLn ("Hello, " ++ name ++ "face..shush")


This is from the PINH ch2 slides:

1) I did those
2) div needs back quotes. N needs to be lower case. a and xs need to be on the same block.

3)

>	last' (x:[])	= x
>	last' (x:xs)	= last' xs

4) is nothing

5)

>	init' (xs:x:[])	= xs
>	init' (x:xs)	= ([]:x) ++ init' xs

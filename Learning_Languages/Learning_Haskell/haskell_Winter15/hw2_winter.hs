--Zack Raver; ravzac14
--1/13/15

import Control.Monad
import Data.Char

--In CRFP do exercises 8.10 to 8.13 p188 (Note it's Chapter 8 not 18).
--8.10, Write an I/O program which will read a line of input and test whether the input is a palindrom
--      The program should "prompt" for input and also output and appropriate message after testing

--main = do
--    putStrLn "Enter a word and hit enter: "
--    word <- getLine
--    if (isPalindrome word) then putStrLn "That's a palindrome!" else putStrLn "That's not a palindrome!"

isPalindrome s = str == (reverse str) where
    str = map toUpper [xs | xs <- s, xs /= ' ']


--8.11, Write an I/O which will read two integers, each on a separate line, and return their sum.
--      The program should prompt for input and explain output

{-main = do
    putStrLn "Enter an integer and hit enter: "
    int1 <- getLine
    putStrLn "Enter another integer and hit enter: "
    int2 <- getLine
    putStrLn ("The sum of those #s is: " ++ (show (sum' int1 int2)))
-}

sum' :: String -> String -> Int
sum' str1 str2 = (read str1) + (read str2)


--8.12, Define a functio, which outputs the string N times

putNtimes :: Integer -> String -> IO ()
putNtimes n str 
    | n >= 0    =   do
                        putStrLn (str)
                        putNtimes (n-1) str
    | otherwise =   do
                        putStrLn "Done"


--8.13, Write an I/O program which will first read a pos. int., n say, and then read n integers and write their sum
--      Prompt for input and explain its output

{-
main = do
    putStrLn "Enter a positive integer (this will be how many ints you plan to sum): "
    n <- getLine
    summer <- forM [1..(read n)] (\a -> do
        putStrLn "Enter a number and hit enter: "
        m <- getLine
        return (read m)) 
    putStrLn ("The sum of those is: " ++ show (sum summer))
-}

--In CRFP do exercises 8.14 to 8.19 pp190-191 
--8.14, Define a 'wc' function which copies input to output until an empty line is read. Should then output the # of lines
--      words and characters that have been copied

wc = interact (analyze) where
    analyze str = "The input has: "++(numLines 0 str)++" lines, "++(numWords str)++" words, and "++(numChars 0 str)++" characters!\n"
    numLines i []           = (show i)
    numLines i ('\n':xs)    = numLines (i+1) xs 
    numLines i (_:xs)       = numLines i xs 
    numWords ys = show $ length $ words ys
    numChars j []           = show j
    numChars j (' ':xs)     = numChars j xs
    numChars j (_:xs)       = numChars (j+1) xs

{-
main = do
    putStrLn "Hit Ctrl-D to end wordcount:"
    wc
-}

--8.15, Define an interactive palindrome checker. You should neglect capitalization, white space and punctuation
--      Madam I'm Adam is a palindrome with this

{-
main = do
    putStrLn "Enter a word or phrase to be checked for palindromativity!: "
    phrase <- getLine
    if (isPalindrome phrase) then (putStrLn (phrase++" is a palindrome!\n")) else (putStrLn ("Nah dude\n"))
-}

--8.16, Write a program which repeatedly reads lines and tests whether they are palindrome until an empty line is read
--      The program should explain clearly what input is expected, and explain the output

manyPals = do
    putStrLn "Gimme words:"
    line <- getLine
    let whilee chimmi = do
        if (chimmi == "")
        then (putStrLn "Okay done")
        else do
            if (isPalindrome chimmi) then putStrLn "Yea that was" else putStrLn "Nah"
            meow <- getLine
            whilee meow
    whilee line

--8.17, Write a program which repeatedly reads ints (one per line) until finding a zero value and outputs the sum 

manySums = do
    putStrLn "Gimme numbers:"
    line <- getLine
    let whilee chimmi cach= do
        if ((read chimmi) == 0)
        then (putStrLn ("The sum: "++(show cach)))
        else do
            meow <- getLine
            whilee meow (cach + (read chimmi))
    whilee line 0 

--8.18, Write a program which repeatedly reads ints (one per line) until finding a zero value and outputs a sorted version of the inputs read.
--      Which sorting algorithm is most appropriate in such a case?

manySort = do
    putStrLn "Gimme numbers:"
    line <- getLine
    let whilee chimmi cach = do
        if (chimmi == 0)
        then (putStrLn ("The sorted list of those: "++(show (sort cach))))
        else do
            meow <- getLine
            whilee meow (chimmi:cach)
    whilee (read line) []

sort []     =   []
sort (x:[]) =   [x]
sort (x:xs) =   [y | y <- xs, y <= x] ++ [x] ++ [z | z <- xs, z > x]

--8.19, Explain the behaviour of this 'copy' program, where the definition of whileCopy is modelled on a while loop in a 
--      procedural language.

--It defines a method that outputs the input line, and if it's "" it returns null, otherwise it calls itself with a new getline..the initial call is at the bottom of the outer do

-- copy :: IO ()
-- copy =
--      do
--          line <- getLine
--          let whileCopy =
--                  do
--                      if (line == "")
--                          then (return ())
--                          else
--                              do putStrLn line
--                                  line <- getLine
--                                  whileCopy
--          whileCopy

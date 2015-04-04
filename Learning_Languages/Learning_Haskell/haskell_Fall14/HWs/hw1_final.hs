-- Zack Raver; ravzac14
-- 9/30/14 
-- Week 1 Haskell Assignment

import Data.Char
import Test.QuickCheck

--Finished all of hw1 problems
--Am resubmitting all my homeworks with summaries at the top for easier speed-grading

{- After reading through the first 3 chapters of CRFP I got a decent understanding
 - of some more formal Haskell..because I have worked through Learn you A Haskell
 - already a bit. 
 -
 - Below are the exercise #s 3.9, 3.11, 3.12, 3.17, 3.18, 3.20 3.21, 3.22 -}

-- 3.9
-- threeDifferent :: Integer -> Integer -> Integer -> Boolean 

threeDifferent m n p 
	| (m == n || m == p || n == p) 	= False
	| otherwise							= True


-- 3.11
-- threeEqual (2+3) 5 (11 `div` 2)
-- threeEqual (2+3) 5 5.5
-- threeEqual 5 5 5.5
-- False


-- 3.12
-- test' = quickCheck (threeDifferent m n p :: Integer -> Integer -> Integer -> Bool) 


-- 3.17

charToNum :: Char -> Int
charToNum x = ord x


-- 3.18
-- onThreeLines :: String -> String -> String -> String

onThreeLines s1 s2 s3 = putStrLn (s1 ++ ['\n'] ++ s2 ++ ['\n'] ++ s3)


-- 3.20 
-- avgThree :: Integer -> Integer -> Integer -> Float

avgThree x y z = (x * y * z) / 3


howManyAboveAvg :: Int -> Int -> Int -> Int
howManyAboveAvg x y z 
	| (x > avg) && (y > avg) && (z > avg)	= 3
	| (x > avg) && ((y > avg) || (z > avg))	= 2
	| (y > avg) && ((z > avg) || (x > avg))	= 2
	| (z > avg) && ((y > avg) || (x > avg))	= 2
	| (x > avg) || (y > avg) || (z > avg) 	= 1
	| otherwise								= 0
	where
		avg = avgThree x y z


-- 3.21


-- test'' = quickCheck (\s -> (howManyAboveAvg x y z) <= 3)
	

-- 3.22

--numberNDroots :: Integer -> Integer -> Integer -> Integer

numberNDroots a b c 
	| (a >= b) && (a >= c)	= a
	| (b >= a) && (b >= c)	= b
	| otherwise 			= c	

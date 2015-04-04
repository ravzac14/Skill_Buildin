--Zack Raver; ravzac14
--1/20/14; due wk 4

import Prelude hiding (Maybe(..))

{- MORE ON FUNCTORS
*Give an appropriate Haskell code for a map function over the (a,b) type.
*Make the type constructor ((,) a) an instance of functor class. Note some newer versions of ghci will give you a "multiple instance declaration" error because the system has already defined ((,) a) as an instance of the functor class. You can use the newtype workaround discussed below for the IO type constructor.

    > newtype Pair a b = Pair (a,b)

*Give an appropriate Haskell code for a map function over the ((->) r) type.
*Make the type constructor ((->) r) an instance of functor class. Note you might need to use the newtype workaround here also, depending on your version of ghci.
*Use the newtype facility in Haskell to define your own MyIO type as follows

    > newtype MyIO a = MyIO (IO a)

*Give an appropriate Haskell code for a map function over your MyIO a type. Don't forget to unwrap the MyIO on the input action and wrap the MyIO around the output action sequence.
*Make your type constructor MyIO an instance of functor. 
-}

newtype Pair a b = Pair (a,b) deriving (Show)

mapPair f (Pair (x,y)) = Pair (x, (f y))

instance Functor (Pair a) where
    fmap = mapPair

--newtype MyIO a = MyIO (IO a)

mapIO f action = do
    result <- action
    return (f result)

instance Functor MyIO where
    fmap = mapIO

--instance Functor ((->) e) where
--    fmap f g = f . g

{- ONTO POINTED
*Define a class called Pointed following the Typeclassopedia paper. You'll need to define Pointed with Functor as a context.
*Define an instance of Pointed for the type constructor ((->) r).
*Define an instance of Pointed for the type constructor Maybe given in Hw1. Remember you'll need to import Prelude hiding Maybe(..) and define the Maybe data type as you did in Hw1. You'll also have to include your instance Functor Maybe from Hw1.
*Explain the purpose of the Pointed class.
*Explain why you can't make ((,) a) an instance of the Pointed class
-}

class Functor f => Pointed f where
    pure :: a -> f a

instance Pointed IO where
    pure = do
        return ()

instance Pointed ((->) e) where
    pure = id 

data Maybe a = Nothing | Just a deriving (Show)

mapMaybe f Nothing  = Nothing
mapMaybe f (Just a) = Just (f a)

instance Functor Maybe where
    fmap = mapMaybe

instance Pointed Maybe where
    pure = Just

--The pointed class helps find a base case...and initialize types

--in (e,a) the type of e has not bounds..so making a 'singleton' for it is impossible

Zack Raver; ravzac14

>   import Prelude hiding (Maybe(..))


Stuff from hw3:

>   newtype Pair a b = Pair (a,b) deriving (Show)
  
>   mapPair f (Pair (x,y)) = Pair (x, (f y))
 
>   instance Functor (Pair a) where
>       fmap = mapPair
        
>   mapIO f action = do
>           result <- action
>           return (f result)
            
>   instance Functor MyIO where
>       fmap = mapIO

>   class Functor f => Pointed f where
>       pure :: a -> f a

>   instance Pointed IO where
>       pure = do
>           return ()

>   instance Pointed ((->) e) where
>       pure = id

>   data Maybe a = Nothing | Just a deriving (Show)
    
>   mapMaybe f Nothing  = Nothing
>   mapMaybe f (Just a) = Just (f a)

>   instance Functor Maybe where
>       fmap = mapMaybe
                 
>   instance Pointed Maybe whe
>       pure = Just

Stuff from hw4:

>   class (Pointed f) => Applicative f where
>       <*> :: f (a -> b) -> f a -> f b

>   instance Applicative (Either a) where
>       pure = Left
>       (Right b) <*> _ = Right b
>       (Left b) <*> something = fmap b something

>   instance Applicative [] where
>       pure x = [x]
>       fs <*> xs = [f x | f <- fs, x <- xs]

>   instance Applicative ((->) e) where
>       f <*> g = \x -> f x (g x)


* Prove the Functor laws for the Maybe type constructor. This will be proofs of the two laws. You'll use equational reasoning based on your fmap definition. The posted example for the proof of the Functor laws for Tree can give you an idea of how to do the proof, but you will not need to use induction because the (Maybe a) is not infinite.

Maybe Functors must obey:
fmap id (Maybe a) = id (Maybe a) and
fmap (f . g) (Maybe a) = fmap f (fmap g (Maybe a))

LAW 1:
CASE 0:
LHS: fmap id (Nothing) = Nothing

RHS: id (Nothing) = Nothing     Good.

CASE 1:
LHS: fmap id (Just x) = Just (id x)
    = Just x

RHS: id (Just x) 
    = Just x

LAW 2:
CASE 0:
LHS: fmap (f . g) Nothing =
    = Nothing

RHS: fmap f (fmap g Nothing) =
    = fmap f (Nothing)
    = Nothing

CASE 1:
LHS: fmap (f . g) (Just x) =
    = Just ((f . g) x)
    = Just (f (g x))

RHS: fmap f (fmap g (Just x)) =
    = fmap f (Just (g x))
    = Just (f (g x))
    
They're equal! So the laws hold for Maybe.


* Prove the Pointed law for the Maybe type constructor holds for the definitions of fmap and pure you gave for your (Maybe e) type constructor. No induction needed.

Maybe Pointed's must obey the Functor laws and:
fmap g . pure (Maybe a) = pure . g

CASE 0:
LHS: fmap g . pure Nothing =
    = fmap g Nothing 
    = Nothing

RHS: pure . g Nothing
    = pure Nothing
    = Nothing

CASE 1:
LHS: fmap g . pure (x)
    = fmap g (Just x)
    = Just (g x)

RHS: pure . g (x)
    = pure . (g x)
    = Just (g x)


* Prove the Applicative law given in the TCOP paper for the (Maybe a) type constructor using the definitions of fmap and pure you gave for your (Maybe e) type constructor. No induction needed

Maybe Applicative must obey the functor laws and:
fmap g x = pure g <*> x

CASE 0:
LHS: fmap g Nothing
    = Nothing

RHS: pure g <*> Nothing
    = Just g <*> Nothing
    = Nothing

CASE 1:
LHS: fmap g (Just x)
    = Just (g x)

RHS: pure g <*> (Just x)
    = (Just g) <*> (Just x)
    = Just (g x)

All equal! 


fmap f ((,) a) = ((,) f a)

* Prove the Functor laws for the ((,) a) type constructor. No induction needed. 
((,) a) Functor must obey:
fmap id ((,) a) = id ((,) a)
fmap (f . g) ((,) a) = fmap f (fmap g ((,) a))

LAW 1:
LHS: fmap id ((,) x)
    = ((,) id x)
    = ((,) x)

RHS: id ((,) x)
    = ((,) x)

LAW 2:
LHS: fmap (f . g) ((,) x) 
    = ((,) (f.g) x)
    = ((,) f (g x))

RHS: fmap f (fmap g ((,) x))
    = fmap f ((,) g x)
    = ((,) f (g x))

Equal!


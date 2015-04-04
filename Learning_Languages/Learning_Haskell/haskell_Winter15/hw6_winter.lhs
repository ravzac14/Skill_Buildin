Zack Raver
ravzac14
due wk 8

>  import Prelude hiding (Maybe(..))


-----------------------MONAD----------------------------

class Monad m where
  return :: a -> m a
  (>>=) :: m a -> (a -> m b) -> m b
  (>>) :: m a -> m b -> m b
  x >> y = x >>= \_ -> y
  fail :: String -> m a
  fail msg = error msg

>  data Maybe a = Just a | Nothing deriving (Show)

>  instance Monad Maybe where
>    return x = Just x
>    Nothing >>= f = Nothing
>    Just x >>= f = f x
>    fail _ = Nothing

>  instance Monad (Either a) where
>    return x = Left x
>    Right a >>= f = Right a
>    Left a >>= f = f a
>    fail x = Right x

instance Functor ((->) e) where
  fmap f ((->) e) = ((->) f e)
instance Pointed ((->) e) where
  pure = id
instance Applicative ((->) e) where
  f <*> g = \x -> f x (g x)

>  instance Monad ((->)r) where
>    return = (.)
>    ((->) r) >>= f = \w -> f (((->) r) w) w

      fail, not sure
The applicative operator <*>

>  myap :: Monad m => m (a -> b) -> m a -> m b
>  myap f a = do
>    x <- f
>    y <- a
>    return (x y)

the sequence op, generalization of accumulate.

>  mysequence :: Monad m => [m a] -> m [a] 
>  mysequence ms = myMapM (join) ms

the monadic version of list map

>  mymapM :: Monad m => (a -> m b) -> [a] -> m [b]
>  mymapM f ls = return (map f ls)

the (>=>) op described in tcop. you may alt choose to do the right to left fish (<=<) discussed in lyah. 

>  (fish) :: Monad m => (a -> m b) -> (b -> m c) -> (a -> m c)
>  (fish) f g = (\x -> g x >>= f)

>  (fish)' f g = (\x -> (g x >>= f))

join op

>  (join) :: Monad m => (m (m a) -> m a)
>  (join) m a = a

-----------------JOIN MONAD-------------------

>  class (Monad m) => JoinMonad m where
>    join :: m (m a) -> m a  

  return :: a -> m a
  (>>=) :: m a -> (a -> m b) -> m b
  (>>) :: m a -> m b -> m b
  x >> y = x >>= \_ -> y
  fail :: String -> m a
  fail msg = error msg

>  instance JoinMonad Maybe where
>    return x = Just x
>    Nothing >>= f = Nothing
>    Just x >>= f = f x
>    fail _ = Nothing
>    join (Just (Just x)) = Just x
>    join _ = Nothing

>  instance JoinMonad (Either a) where
>    return x = Left x
>    Right a >>= f = Right a
>    Left a >>= f = f a
>    fail x = Right x
>    join (Left _) = _
>    join (Right (_ a) = Right a

>  instance JoinMonad ((->)r) where
>    return = (.)
>    ((->) r) >>= f = \w -> f (((->) r) w) w
>    join ((->) ((->) r)) = ((->) r) >>= id


ap :: JoinMonad m => m (a -> b) -> m a -> m b, the applicative operator of the applicative class.

>  myap f a = do
>    x <- f
>    y <- a
>    return . join (x y)  

sequence :: JoinMonad m => [m a] -> m [a], the sequence operator.

>  mysequence :: JoinMonad m => [m a] -> m [a] 
>  mysequence ms = myMapM join ms

mapM :: JoinMonad m => (a -> m b) -> [a] -> m [b], the monadic version of list map.

>  mymapM :: JoinMonad m => (a -> m b) -> [a] -> m [b]
>  mymapM f ls = return (map (f . join) ls)

(bind) :: JoinMonad m => m b -> (a -> m b) -> m b, the (>>=) operator described in TCOP.

>  (bind) m ftm = join (fmap ftm m)

(fish) :: JoinMonad m => (a -> m b) -> (b -> m c) -> (a -> m c), the (>=>) operator described in TCOP. 

>  (fish) :: JoinMonad m => (a -> m b) -> (b -> m c) -> (a -> m c)
>  (fish) f g = (\x -> g x (bind) f)

>  (fish)' f g = (\x -> (g x (bind) f))

---------------------FISH MONAD-----------------------------------

>  class FishMonad m where
>    return :: a -> m a
>    fail :: String -> m a
>    fail msg = error msg
>    fish :: FishMonad m => (a -> m b) -> (b -> m c) -> a -> m c

>  instance FishMonad Maybe where
>    return x = Just x
>    Nothing >>= f = Nothing
>    Just x >>= f = f x
>    fail _ = Nothing
>    join (Just (Just x)) = Just x
>    join _ = Nothing
>    fish atmb btmc (Just x) = return (btmc (atmb x))
>    fish atmb btmc Nothing  = Nothing

>  bind m ftm = fish return (fmap ftm m)

>  join (m (m a)) = m a

>  instance FishMonad (Either a) where
>    return x = Left x
>    Right a >>= f = Right a
>    Left a >>= f = f a
>    fail x = Right x
>    join (Left _) = _
>    join (Right (_ a) = Right a
>    fish atmb btmc (Left x) = return (btmc (atmb x))
>    fish atmb btmc (Right x) = Right x

>  instance JoinMonad ((->)r) where
>    return = (.)
>    ((->) r) >>= f = \w -> f (((->) r) w) w
>    join ((->) ((->) r)) = ((->) r) >>= id
>    fish atmb btmc ((->) r) = return (btmc . atmb . ((->) r))


---------------------------PROOFS---------------------------------------

instance Monad (Either a) where
  return x = Left x
  Right a >>= f = Right a
  Left a >>= f = f a
  fail x = Right x

Monad laws for Either a Monda

LAW 1: return a >>= k = ka
LAW 1 LHS:
return a >>= k
Left a >>= k
k a

Law 1 RHS:
k a     EQUALS

LAW 2: m >>= return = m
LAW 2 LHS:
m >>= return
Left a >>= return = return a = Left a = m
or
Right a >>= return = Right a = m

LAW 2 RHS:
m       EQUALS

LAW 3: m >>= (\x -> k x >>= h) = (m >>= k) >>= h
LAW 3 LHS:
m >>= (\x -> k x >>= h)
Left a >>= (\x -> k x >>= h) = k a >>= h 
or Right a >>= (\x -> k x >>= h) = Right a

LAW 3 RHS:
(m >>= k) >>= h
(Left a >>= k) >>= h
k a >>= h
or 
(Right a >>= k) >>= h
Right a >>= h 
Right a     EQUALS

JOINMonad laws for Either a JoinMonad

LAW 1: join . fmap join = join . join
LAW 1 LHS:
join . fmap join (Left (Left a) = join . Left a = a

LAW 1 RHS: join . join (Left (Left a)) = join . Left a = a      EQUALS, and similarly for any other case of L/R

LAW 2: join . fmap return = join . return = id
LAW 2:
join . fmap return
join . Left a 
a = join Left a =
a = id a = a

LAW 3: join . fmap (fmap f) = fmap f . join
LAW 3 LHS:
join . fmap (fmap f) Left a = join . fmap (Left (f a)) = join . (Left (f a)) = f a
or
join . fmap (fmap f) Right a = join . fmap Right a = Right a = Right a

LAW 3 RHS:
fmap f . join Left a = fmap f a = f a
or
fmap f . join Right a = Right a = Right a       EQUALS


FISHMonad laws for Either a FishMonad

fish atmb btmc (Left x) = return (btmc (atmb x))
fish atmb btmc (Right x) = Right x

LAw 1: return `fish` g = g

return `fish` g a = g (Left a) = g (Left a)

LAW 2: g `fish` return = g 

g `fish` return a = return (g a) = Left (g a) EQUALS 

LAW 3: (g `fish` h) `fish` k = g `fish` (h `fish` k)
LHS: 
(g `fish` h) `fish` k a
k . (g `fish` h) 
k . h . g a

RHS:
g `fish` (h `fish` k) a
(h `fish` k) . g a
k . h .g a EQUALS


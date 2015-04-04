Zack Raver
ravzac14
due wk7

Part 1:

>  data Exp v = Var v | Val Int | Add (Exp v) (Exp v) deriving (Show)
>  data Env v = Env [(Var v, Int)] 

>  eval :: Exp v -> Env v -> Int
>  eval (Var x) (Env v) = fetch v x
>  eval (Val i) (Env v) = i
>  eval (Add p q) (Env v) = eval p v + eval q v

>  fetch :: Var v -> Env v -> Maybe Int
>  fetch x (Env v) = if x `elem` (map fst v) then Just y else Nothing 
>    where
>      (x',y) = filter (fst x) v

>  data Exp v = Var v | Val Int | BinOp Op (Exp v) (Exp v) deriving (Show)
>  data Op = (*) | (+) | (-) | (`div`) 

>  eval' (Exp v) (Env s) = fmap (eval v s) 

>  eval'' Nothing (Env v) = error "Var not found"
>  eval'' (Var x) (Env v) = fetch x v
>  eval'' (Val i) (Env v) = i
>  eval'' (BinOp op e1 e2) (Env v) = lift2 op (eval'' e1 v) (eval'' e2 b)

Applicative class stuff

>  infix 4 <*>
>  class Functor f => Applicative f where
>    pure  :: a -> f a
>    (<*>) :: f (a -> b) -> f a -> f b

The Reader instance of the Applicative class for evaluation in an environment env.

>  instance Functor ((->) env) where
>    fmap = (.)

>  instance Applicative ((->) env) where
>    pure g = \env -> g
>    eg <*> ex = \env -> (eg env) (ex env)

--The maybe instance of the Applicative class for failure pro.
--This functor instance for Maybe is already in the Prelude

instance Functor Maybe where
  fmap g Nothing = Nothing
  fmap g (Just x) = Just (g x)

>  instance Applicative Maybe where
>    pure = Just
>    Nothing <*> _ = Nothing
>    (Just g) <*> x = fmap g x

Applicative lift2 

>  liftA2 :: (Int -> Int -> Int) -> Maybe Int -> Maybe Int -> Maybe Int
>  liftA2 g x y = pure g <*> x <*> y

or                g <$> x <*> y
or                fmap g x <*> y

The maybe evaluator as applicative functors

>  evalM :: Expr -> Env -> Maybe Int
>  eval (Val x)  =
>  eval (Var v)  =
>  eval (BinOp op e1 e2) =


Tests

>  e1 = Val 3
>  e2 = BinOp (+) (Val 3) (Val 4)
>  e3 = BinOp (*) (BinOp (-) (Val 9) (Val 4)) (BinOp (-) (Val 7) (Val 2))

PROOFS:

instance Functor ((->) env) where
  fmap = (.)

Prv the Functor laws for ((->) a)
fmap id ((->) a) = id ((->) a) and
fmap (f . g) ((->) a) = fmap f (fmap g ((->) a))

LHS Rule 1: 
fmap id ((->) e) 
(.) id ((->) e)
id . ((->) e)
((->) e)

RHS Rule 1:
id ((->) e)
((->) e) EQUAL

LHS Rule 2:
fmap (f .g) ((->) e) 
(.) (f . g) ((->) e)
(f . g) . ((->) e)
f . g . ((->) e)

RHS Rule 2:
fmap f (fmap g ((->) a))
(.) f (fmap g ((->) a))
(.) f ((.) g ((->) a))
f . g . ((->) a) EQUAL


instance Pointed ((->) e) where
  pure = id

Prv the Pointed laws for ((->) a)
the functor laws and
fmap g . pure ((->) a) = pure . g

LHS:
fmap g . pure ((->) a)
(.) g . pure ((->) a)
g . pure . ((->) a)
g . id .((->) a)
g . ((->) a)

RHS: 
pure . g ((->) a)
id . g ((->) a)
g ((->) a)


instance Applicative ((->) env) where
  pure g = \env -> g
  eg <*> ex = \env -> (eg env) (ex env)

Prv the Applicative laws for ((->) a)
fmap g x = pure g <*> x

LHS:
fmap g x
(.) g x
g . x

RHS:
pure g <*> x
id g <*> x
id \env -> (g env) (x env)
g . x

instance Functor (Either a) where
  fmap f (Left a) = Left f a
  fmap f (Right a) = Right a

instance Pointed (Either a) where
  pure = Left

Prv the Functor laws for the Either a type
fmap id (Either a) b = id (Either a) b and
fmap (f . g) (Either a) b = fmap f (fmap g (Either a) b)

LHS Rule 1:
fmap id Either a 
Left (id a)
or
Right a

RHS RUle 1:
id (Either a)
id Left a = Left a
or id Right A = Right a EQUAl

LHS Rule 2:
fmap (f . g) (Either a) 
Left (f . g a)
or Right a

RHS Rule 2:
fmap f (fmap g (Either a))
fmap f (Left (g a)
or fmap f (Right a)
Left (f.g a)
or Right a  EQUAL

Prv the Pointed laws for the Either a type
the functor laws and
fmap g . pure (Either a) b = pure . g

LHS:
fmap g . pure (Either a) 
fmap g (Left a)
Left (g a)

RHS:
pure . g a
Left (g a) EQUAL


instance Applicative (Either a) where
  pure = Left
  (Right b) <*> _ = Right b
  (Left b) <*> something = fmap b something

Prv the Applicative laws for the Either a type
fmap g x = pure g <*> x

LHS:
fmap g x
Left (g x)
or Right x

RHS:
pure g <*> x
Left g <*> x
fmap g x EQUAL

-- file: StateAM-exprs.hs
-- 2015.02.20


-- Contents
-- 1. Expressions with Assignment
-- 2. The State functor
-- 3. Type Class Definitions
-- 4. Simple Evaluators using State a = Env -> (Env, a)
-- (a) Raw evaluator without the State Applicative or State Monad
-- (b) State evaluator using home-grown Applicative class
-- (c) State Monad evaluator using home-grown MonadBind class
-- (d) State Monad evaluator using the builtin Monad class
-- 5. Testing


------------------------------------------------------------------------------
-- 1. Expressions with Assignment
------------------------------------------------------------------------------

-- The evaluator now assumes abstract expressions have write as well as read
-- variables and only binary Int operators.

-- The expression language has the somewhat quirky (but not uncommon)
-- characteristic that assignments can be used just like any other expression,
-- but they have side effects. The value of an assignment is the value of the
-- right-hand-side expression, along with the side effect on the
-- state, of course.

-- For example the expression  3 + (Asn "a" 5)  in the empty environment []
--     returns the pair (env, val) = ([("a",5)], 8)


-- Abstract Syntax
data ExprAsn = Val Int
             | Var String
             | BinOp (Int -> Int -> Int) ExprAsn ExprAsn
             | Asn String ExprAsn

-- Environment mapping variables to values
type Env = [(String, Int)]

-- A simple environment lookup with abrupt termination on lookup failure
fetch :: String -> Env -> Int
fetch x env = head [b | (a,b) <- env, x == a ]

-- A simple environment update
store :: String -> Int -> Env -> Env
store var val env = (var, val) : env


------------------------------------------------------------------------------
-- 2. The State functor
------------------------------------------------------------------------------

-- We need the newtype so the functor can be single-parameter as required
-- As a composition:  State a = ((->) Env ) . ((,) Env)
newtype State a = State (Env -> (Env, a))

instance Functor State where
  fmap f (State s) =  State $ \env -> let (ns,a) = (applyS s env) in (ns, f a)
                                        


-- The State functor lookup that we actually need for the Applicative functor
fetchS :: String -> State Int
fetchS var = State (\env -> (env, fetch var env) )

-- The State functor update that we actually need for the Applicative functor
storeS :: String -> State Int -> State Int
storeS var (State s) = State ( \env -> let (env', val) = s env
                                       in (store var val env', val) )

-- The general apply function for the State functor (more commonly runST)
applyS :: State Int -> Env -> (Env, Int)
applyS (State s) env = s env


------------------------------------------------------------------------------
-- 3. Type Class Definitions
------------------------------------------------------------------------------

-- The Applicative Class
infixl 4 <*>
class Functor f => Applicative f where
  pure  :: a -> f a
  (<*>) :: f (a -> b) -> f a -> f b

-- The MonadBind class
infixl 1 >>>=
class Applicative f => MonadBind f where
  (>>>=) :: f a -> (a -> f b) -> f b          -- (>>=) is already taken


------------------------------------------------------------------------------
-- 4. Fill in code for class instances and the various evaluators
------------------------------------------------------------------------------

instance Applicative State where
  pure a = State $ \env -> (env,a)
  (<*>) (State sf) (State sv) = State $ \env -> let (env1, f) = (applyS sf env)
                                                    (env2, a) = (applyS sv env1)
                                                in (env2, f a)

stateEval (Val x) (State s) = pure x
stateEval (Var x) (State s) = fetchS x
stateEval (BinOp op e1 e2) (State s) = stateEval e1 (State s) <*> (stateEval e2 (State s) <*> pure op)
stateEval (Asn s e1) (State st) = storeS s (State st) 


instance MonadBind State where
  (>>>=) (State s) f = State $ \env let (env1, a) = (applyS s env)
                                        (env2, b) = (applyS (f a) env1)
                                    in (env2, b)

stateEval (Val x) (State s) = pure x
stateEval (Var x) (State s) = fetchS x
stateEval (BinOp op e1 e2) (State s) = stateEval e1 (State s) >>>= stateEval e2 (State s) >>>= op
stateEval (Asn s e1) (State st) = storeS s (State st) 

------------------------------------------------------------------------------
-- 5. Some expressions for testing
------------------------------------------------------------------------------

e1 = Val 3
e2 = BinOp (+) (Val 3) (Val 4)
e3 = BinOp (*) (BinOp (-) (Val 9) (Val 4)) (BinOp (-) (Val 7) (Val 2)) 
e4 = BinOp (+) (BinOp (*) (Val 9) (Val 4)) (BinOp (div) (Val 7) (Val 2)) 
e5 = BinOp (-) (Val 3) (BinOp (-) (Val 4) (Val 6)) 
e6 = Var "a" 
e7 = BinOp (+) (Var "a") (Var "b")
e8 = BinOp (*) (BinOp (-) (Var "a") (Val 4)) (BinOp (-) (Val 7) (Var "b")) 
e9 = BinOp (+) (BinOp (*) (Val 9) (Var "a")) (BinOp (div) (Var "b") (Var "c")) 

-- For assignment tests
e10 = BinOp (+) (BinOp (*) (Asn "a" (Val 6)) (Var "b"))
                (BinOp (+) (Var "a") (BinOp (*) (Asn "b" (Val 3)) (Var "b")))



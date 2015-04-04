--Zack Raver; ravzac14	due wk 8

--I declared most of the abstract syntax for clite here...and began writing a showAST functions (which just called the other show functions, much like the display()'s..never finished..too long and too behind for the whole thing




--In this assignment you will build an Abstract Syntax module for the Clite language in Haskell.

--The Clite Abstract Syntax module in this assignment corresponds with the AbstractSyntax.java code in the Clite programming language design project.

--Build a Haskell module for the Abstract Syntax of Clite as an algebraic data type.
--Write a showAST function in your module that displays a Clite Abstract Syntax tree using indentation for tree levels.
--Write a test program that displays the Abstract Syntax Tree for the clone.cpp program. You'll need to hand code the abstract syntax tree for the clone.cpp program, at least until you get a Haskell parser working for Clite!

clone.cpp = 
	"int main () {\n"		++ 
	"\tint a,b,c,d;\n"	++
	"\tb = a;\n"			++
	"\tb = 5;\n"			++
	"\td = c;\n"			++
	"\tc = 7;\n"			++
	"}"

minLexemes = [(intTok,"int"),(mainTok,"main"),(leftParenTok,"("),(rightParenTok,")"),(leftBraceTok,"{"),
			(iden,"a"),(assignTok,"="),(int,"2"),(semicolonTok,";"),(rightBraceTok,"}")]


--Abstract Syntax of CLite

type Program 		= 	(Declarations, Statements)

showAST (decs,states)	= 	"Declarations:\n" ++
								showDeclarations decs ++ 
							"Block:\n" ++
								showStatements states

type Declarations 	= [Declaration]

showDeclarations decs	= 	"Declarations = {\n" ++ 
								map showDeclaration decs

data Declaration 	= VariableDecl | ArrayDecl
					deriving (Show)	
type VariableDecl 	= (Variable, Type)

type ArrayDecl 		= (Variable, Type, Size)


showDeclaration (v,t)	=	"  <" ++ showVar v ++ ", " ++ showType t ++ ">\n"
showDeclaration (v,t,s) =	"  <" ++ showVar v ++ ", " ++ showType t ++ ", " ++ showSize s ++ ">\n"

data Type			= Int | Bool | Float | Char
					deriving(Show)


showType t = show t

type Statements 	= [Statement]

showStatements sts	= 	"Block:\n" ++
							map showStatement sts

data Statement		= Skip | Block | Assignment | Conditional | Loop

showStatement "Skip"		= ""
showStatement sts			= showStatements sts
showStatement (vref,expr) 	= "Assignment:\n" ++
								showVariableRef vref ++
								showExpression expr
showStatement Conditional SiConditional scond	= showSiConditional scond
showStatement Conditional BiConditional bcond	= showBiConditional bcond
showStatement (expr,st)		= "Loop:\n" ++
								showExpression expr ++
								showStatement st

type Skip			= "Skip"
--Skip's show is handled in st.

type Block 			= Statements
--Block's show is same as sts.

data Conditional 	= SiConditional | BiConditional
					deriving(Show)
type SiConditional	=	(Expression, Statement) 
type BiConditional	=	(Expression, Statement, Statement)

showSiConditional (expr,st)	= 	"If:\n" ++
									showExpression expr ++
							 	"Then:\n" ++
									showStatement st

showBiConditional (expr,st,st2) = 	"If:\n" ++
										showExpression expr ++
									"Then:\n" ++
										showStatement st ++
									"Else:\n" ++
										showStatement st2

type Loop			= 	(Expression, Statement)
--Loop's show handled in st.

type Assignment 	= (VariableRef, Expression)
--Assignment's show is handled in st.

data Expression 	= VariableRef | Value | Binary | Unary

showExpression VariableRef Variable	v 	= showVariable v
showExpression Value IntValue v			= showIntValue v
showExpression Value BoolValue v		= showBoolValue v
showExpression Value FloatValue v 		= showFloatValue v
showExpression Value CharValue v		= showCharValue v
showExpression (bOp,expr,expr2)			= "Binary:\n" ++
											showBinaryOp bOp ++
											showExpression expr ++
											showExpression expr2
showExpression (uOp,expr)				= "Unary:\n" ++
											showUnaryOp	uOp ++
											showExpression expr

data VariableRef 	= Variable | ArrayRef

type Binary 	= (BinaryOp, Expression, Expression)

type Unary		= (UnaryOp, Expression)


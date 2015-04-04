This is a compilation of the "recursion" challenges in the functional
programming secion of hackerrank.com


********************************************************
Given a list of N ints you have to find those ints which are repeated
at least K times. In case no such elements exists you have to print -1

If there are multiple elements then print them ordered by their first 
occurence in a list

ie 	filtRepeat 2 [1,1,2,3,3,4] would yield [1,3]
	filtRepeat 4 [1,2,3] would yield -1

	filtRepeat k lst



>	let l1 = [1,2,1,2,3,4,5]
>	let l2 = [1,1,1,2,3,4,4,4,4,5]
>	let l3 = [1,2,3,4,4,4,4,4,4,4,4,4]

*********************************************************
Compute the number of ways to place N super-queens on an N x N chessboard
such that none of the super-queens are in conflict, ignore that some of them
are reflections and rotations of each other

N < 15

ie 	superQueen 10 would yield 4

	superQueen n


*********************************************************
Find the # of ways in which a given integer X, can be expressed as the sum
of the Nth power of unique natural numbers (no repeating #s)

1<=X<1000; 1<=N<=10

ie	sumOfPowers 10 2 would yield 1 (because 1^2 + 3^2 = 10)
	sumOfPowers 100 3 would yield 1 (because 1^3 + 2^3 + 3^3 + 4^3 = 100)
	sumOfPowers 100 2 would yield 3 (100=10^2=6^2 + 8^2=1^2 + 3^2 + 4^2 + 5^2 + 7^2)

	sumOfPowers x n



**********************************************************
A 10 x 10 crossword grid is provided to you, along with a set of words 
which need to be filled in

the cells are either '+' or '-' (the blanks spots)..

getLine = semicolon separated words




>	let s1 = ["red","blue","yellow","green","orange","gray","black","white"]
>	let s2 = ["london","prague","paris","tijuana","moscow","sydney","olympia","athens","assembly","mouse","sven","stall","shit"]
>	let c1 = 
>		"++-+++-+++
>		 ++-+++-+++
>		 ++-+++-+++
>		 ++-+++-+++
>		 ++-----+++
>		 ++-+++-+++
>		 ++-+++-+++
>		 ++++_____+
>		 ++++-+++++
>		 ++++-+++++"
>	let c2 = 
>		"-------+++
>		 +++-++-+++
>		 +++-++-+++
> 		 +++-++-+++
>		 +----+-+++
>		 ++++++-+++
>		 ++-----+++
>		 ++-+++-+++
>		 ++-+++++++
>		 ++-+++++++"

************************************************************
Given a set of N points find the perimeter of the convex hull (the shape 
caused by edges connecting each of the outermost nodes.

3 <= N <= 10000
0 <= xi yi <= 10000


	hullPerimeter n lst




>	let p1 = [(1,2),(1,5),(2,4),(2,7),(4,0),(6,9),(6,3),(8,5),(8,1)]
>	let p2 = [(1,1),(1,6),(6,6),(6,1)]

*************************************************************
Given a an even length string swap the elements at every two nodes 

ie 	swapEO abcdef yields badcfe

	swapEO str


>	let str1 = "abcdef"
>	let str2 = "htsiiwllamekessnse"

**************************************************************
In a 63 rows by 100 columns matrix, produce N iterations of fractal trees
in ASCII art..underscores and 1s

N <= 5

ie N=1 would yield a single Y shaped tree
	N=2 would yield a Double Y shaped tree (obv smaller, to fit in the same)


	fractalTree n




*****************************************************************
In 32 rows and 63 columns...sierpinski triangles

N <= 5

	sierpinski' n




*****************************************************************
Given 2 ints calculate their GCD using the euclidean algorithm

1<=n<=10^6

if x = y then; GCD(x,y) = GCD(x,x) = x
if x > y then; GCD(x,y) = GCD(x-y,y)





*****************************************************************
Show K levels of Pascal's triangle

ie K=3 would yield
1 
1 1
1 2 1





*****************************************************************
Return the Nth fibonnaci number
N0 = 0
ie n=3 yields 1
ie n=4 is 2
ie n=5 is 3


>	fib' n = doit n 0 0 
>		where
>			doit n i sum
>			| n == 0		= sum				
>			| otherwise		= sum + i + (doit (n - 1) (i + 1))



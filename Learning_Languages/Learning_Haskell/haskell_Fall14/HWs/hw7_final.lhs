Zack Raver; ravzac14
due wk 9


So I finished all of SetUL and SetOL and tested with this class, pretty straightforward. Learned a lot about instance declarations! Didn't trade with anyone though. They did work when i swapped them transparently as Set





	import Data.Set	as Set

	import SetUL as Set

>	import SetOL as Set

-------------------QUESTIONS_-------------------------------------------

**Using a type synonym for Set a, build an implementation of the Set ADT using unordered lists . Call this implementation SetUL. You won't be able to make this version of your module an instance of the Show or Eq class, so some tests in setTest.lhs won't work. Comment them out for now.

**Now build an implementation of the Set ADT using ordered lists. Use a type synonym for Set a. Call this implementation SetOL. You won't be able to make this version of your module an instance of the Show or Eq class, so some tests in setTest.lhs won't work. Comment them out for now.

**Upgrade both the SetUL.lhs file and your SetOL.lhs file to use the newtype construction rather than the type synonym facility of Haskell. This allows the internal representation of sets to be hidden from the user. The newtype construction also enforces a stronger type constraint: it is not possible to confuse just any list with a set. Every set must be properly constructed using a function in the Set interface or it will not be a set. Here's a SetUL skeleton

**Upgrade both the SetUL.lhs file and your SetOL.lhs file to make the Set abstract data type an instance of the Eq class and an instance of the Show class. Modify the setTest.lhs file to include Set equality tests and tests of the show function. Re-run your test cases on both modules to make sure the modules still work identically as before.

**Demonstrate that you can transparently use your Set module in place of the Haskell Data.Set module. Do this by running your test scipt with only changing the import line of the script. For example,

**import Data.Set as Set
when you use the Haskell Set module, and

**import MySet as Set
when you use your own Set module.

**Now swap your Set modules with another student and make sure your Set modules work with their testing script, and their Set modules work with your testing script changing only the import line. Don't blindly use exactly the same testing script, add some clever boundary testing. Note that if the modules do not appear to be transparently swapable, then it could be that your testing script assumes something about Sets that is not allowed. For example, you cannot presume that toList will produce any particular order of the set elements in a list.

**Put your SetUL and your SetOL along with your setTest in a single directory with a README.txt file and be prepared to show this to the faculty.


-------------------------------------TestCases-----------------

>	s1 = fromList [2,1,4,5,3]
>	s2 = delete 4 s1
>	s3 = insert 7 s2
>	s4 = insert 7 s3


> -- Empty sets need to explicitly give the element type

>	s5 :: Set Int
>	s5 = fromList []

> -- Hmmm, that's probably what Data.Set.empty is for.

>	s5' = Set.empty

>	s7 = insert 5 s4
>	s8 = fromList [2,1,4]
>	s9 = fromList [1,4,2]

>	t1 = sort (toList s1) == [1,2,3,4,5]
>	t2 = sort (toList s2) == [1,2,3,5]
>	t3 = sort (toList s3) == [1,2,3,5,7]
>	t4 = sort (toList s4) == [1,2,3,5,7]
>	t5 = Set.null s4 == False
>	t6 = Set.null s5 == True
>	t6' = Set.null s5' == True
>	t7 = sort (toList s7) == [1,2,3,5,7]
>	t8 = sort (toList s8) == [1,2,4]
>	t9 = sort (toList s9) == [1,2,4]
>	t10 = member 7 s2 == False
>	t11 = member 7 s3 == True
>	t12 = member 4 s4 == False

These won't work unless Set is an instance of the Eq class

>	t13 = s8 == s9
>	t14 = s3 == s4
>	t15 = s1 /= s2

These won't work unless Set is an instance of the Show class and the
show function works just like the Data.Set show function.

>	t16 = show s1 == "fromList [1,2,3,4,5]"
>	t17 = show s3 == "fromList [1,2,3,5,7]"
>	t18 = show s4 == "fromList [1,2,3,5,7]"


>	testlist = [t1,t2,t3,t4,t5,t6,t6',t7,t8,t9
>	            ,t10,t11,t12,t13,t14,t15,t16,t17,t18]
>	test = and testlist

> -- toList does not insist that the set is converted to a sorted list

>	sort = foldr ins [] where
>	  ins x [] = [x]
>	  ins x as@(y:ys) | x > y     = y : ins x ys
>	                  | otherwise = x : as

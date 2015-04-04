# Name: ...
# Evergreen Login: ...
# Computer Science Foundations
# Programming as a Way of Life
# Homework 2

# You may do your work by editing this file, or by typing code at the
# command line and copying it into the appropriate part of this file when
# you are done.  When you are done, running this file should compute and
# print the answers to all the problems.


###
### Problem 1
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 1 solution follows:"

from hw2_test import n     #Gives Gauss and test-case value for n

Sum = 0
i = 1

while (i <= n):
   Sum = i + Sum             #Adds the next number to the previously Sum'd numbers
   i += 1
   
print Sum 

###
### Problem 2
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 2 solution follows:"

i = 2.00
dec = 0.00

#Looking for dec of 1/2-1/10 (10-2+1=9) need 9 loops
for x in range(0, 8):
    dec = 1 / i
    i += 1
    print dec

###
### Problem 3
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 3 solution follows:"

n = 10
triangular = 0

for i in range(1, n + 1):
    triangular = triangular + i

print "Triangular number", n, "via loop:", triangular
print "Triangular number", n, "via formula:", n*(n+1)/2

###
### Problem 4
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 4 solution follows:"

n = 10
factorial = 1

for i in range(1, n + 1):
    factorial = factorial * i
    
print factorial

###
### Problem 5
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 5 solution follows:"

numlines = 10
n = 0

for i in range (1, numlines + 1):
    n = numlines
    numlines -= 1
    factorial = 1
    for x in range (1, n +1):
        factorial = factorial * x
    print factorial

###
### Problem 6
###

# DO NOT CHANGE THE FOLLOWING LINE
print "Problem 6 solution follows:"

Sum = 0.00
n = 0.00

for i in range(1, 10):
    n = i
    factorial = 1.00
    recFact = 0.00
    
    for x in range(1, n + 1):
        factorial = factorial * x
    
    recFact = 1 / factorial
    Sum = Sum + recFact
    print "Factorial in loop: ", factorial             #Debugging Factorial loop
    print "Reciprocal of factorial in loop: ", recFact #Debugging recFact function

Sum = 1 + Sum    
print "Sum of Reciprocals, or definition of e: ", Sum

###
### Reflection
###

#The assignment took about an hour to finish up, with minimum debgugging. 
#The readings didn't take long, maybe one evening. The ICUPIP book is a much tougher read.
#The lecture did not quite get to FOR loops, so we had to use ICUPIP, but the assignment did build off itself.

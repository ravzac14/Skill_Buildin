# Name: ...
# Evergreen Login: ...
# Computer Science Foundations
# Programming as a Way of Life
# Homework 1

# You may do your work by editing this file, or by typing code at the
# command line and copying it into the appropriate part of this file when
# you are done.  When you are done, running this file should compute and
# print the answers to all the problems.

import math                     # makes the math.sqrt function available
import sys                      # makes System.exit function available

###
### Problem 1
###

print "Problem 1 solution follows:"

a = 0
a = input("Enter co-efficient value for a: ")
b = 0
b = input("Enter co-efficient value for b: ")
c = 0
c = input("Enter co-efficient value for c: ")

if (4*a*c) > (b**2):
    print str("You are attempting to create an unreal number! System will now exit")
    sys.exit(0)

root1 = (-b + math.sqrt((b**2) - (4*a*c))) / (2*a)
root2 = (-b - math.sqrt((b**2) - (4*a*c))) / (2*a)
print str("\nYour two roots for your quadratic equation are: \n")
print root1
print root2

###
### Problem 2
###

print "\n\nProblem 2 solution follows: \n"

from hw1_test import a, b, c, d, e, f  #Changes the variable definitions above to the values from hw1_test

a = str(a)
b = str(b)
c = str(c)
d = str(d)
e = str(e)
f = str(f)
print a
print b
print c
print d
print e
print f

###
### Problem 3
###

print "\n\nProblem 3 solution follows: \n"

newValue = ((a and b) or (not c) and not (d or e or f))
print newValue

###
### Collaboration
###

# Kyle S. -> Various syntax error-related questions.

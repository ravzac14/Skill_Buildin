# lab3.py
# Zack Raver; ravzac14
#Program to calcuate nth value of 2 functions

import sys
word = raw_input("Enter which function you would like to use (fibonacci or sum): ")
n = input("Enter an 'n' value for which you would like to find in the function above: ")

if (word == "fibonacci"):
    x = 0
    y = 1
    for i in range(n):
        x, y = y, x + y
    print x
         
elif (word == "sum"):
    total = 0
    for i in range(n+1):
        total += (3*i)
    print total

else:
    print "Invalid Function Selected!"
    sys.exit(0)
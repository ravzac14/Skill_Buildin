"""Zack Raver
ravzac14
Architecture Lab 1
1/7/14"""

import sys

binNum = raw_input("Enter a 32 bit binary number\n")

def binToInt(binaryNum):
    temp = 0
    newInt = 0
    
    if len(binaryNum) != 32:
        return 0
    
    for i in range (1, len(binaryNum)) :
            if binaryNum[i] == "1":
                temp = 2**((len(binaryNum) - 1) - i)
                newInt += temp
            
    if binaryNum[0] == "1":
        newInt = newInt - 2**32        
    return newInt
        
print binToInt(binNum)

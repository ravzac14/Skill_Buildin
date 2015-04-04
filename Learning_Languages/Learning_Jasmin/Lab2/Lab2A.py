"""Zack Raver, ravzac14, Arch Lab2A"""

def jvm(expr = raw_input("Give a number in RPN in quotes seperated by whitespace\n")):
    stack = []
    tokens = expr.split()
    operations = "+-*/"
    index = -1
    for t in tokens:
        if t  in operations:
            x = int(stack[index])
            y = int(stack[index -1])
            stack.pop()
            stack.pop()
            if t == "+":
                new = x + y
                stack.append(new)
            elif t == "-":
                new = y - x
                stack.append(new)
            elif t == "*":
                new = x*y
                stack.append(new)
            else:
                new = y/x
                stack.append(new)
            index -= 1
        else:
            stack.append(t)
            index += 1
    print tokens
    print stack

jvm()

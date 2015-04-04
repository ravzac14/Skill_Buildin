;Zack Raver
;ravzac14
;This time use a while-loop to run the method until a is 1


.class public Lab4B
.super java/lang/Object

.method public <init>()V
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method

.method public evOddWhile(I)I
	.limit stack 4
	.limit locals 3

While:

;Check if even, do div or sub after
	iload_1
	iconst_2
	irem
	ifne Else
	iload_1
	iconst_2
	idiv
	istore_1
	goto Continue
Else:
	iload_1
	iconst_1
	isub
	istore_1

;Compares it to one and jumps
Continue:
	iload_1
	iconst_1
	if_icmpne While
	
;Go on to return to test class
Return:
	iload_1
	ireturn
.end method	

;Zack Raver
;ravzac14

.class public Lab4A
.super java/lang/Object

.method public <init>()V
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method

.method public evenOrOdd(I)I
	.limit stack 4
	.limit locals 3

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
Continue:
	iload_1
	ireturn
.end method	

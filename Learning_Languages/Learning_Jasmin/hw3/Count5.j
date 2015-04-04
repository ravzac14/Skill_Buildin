;Zack Raver, ravzac14
;Count from 1 to 5

.class public Count5
.super java/lang/Object

.method public <init>()V
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V
	.limit stack 6
	.limit locals 4

	ldc 5
	istore_1
	ldc 1
	istore_2
LoopTop:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload_2
	invokevirtual java/io/PrintStream/println(I)V

	;Adding to the count
	iload_2
	iconst_1
	iadd
	istore_2
	
	;Subtracting from the index	
	iload_1
	iconst_m1
	iadd
	istore_1
	iload_1
	ifgt LoopTop

	return
.end method

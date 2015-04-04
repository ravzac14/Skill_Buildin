;Zack Raver, ravzac14
;Loop from i = 0 to i =5 adding to total each iteration, then print final total

.class public CountUp5Lab4
.super java/lang/Object

.method public <init>()V
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V
	.limit stack 6
	.limit locals 4

	ldc 0 		;This is i
	istore_0
	ldc 0 		;This is total
	istore_1

LoopTop:
	iload_1	
	iload_0
	iadd		;Add i and total, store in total
	istore_1
	iload_0
	ldc 1
	iadd 		;increment i
	istore_0
	iload_0
	ldc 5
	if_icmplt LoopTop

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload_1
	invokevirtual java/io/PrintStream/println(I)V

	return
.end method

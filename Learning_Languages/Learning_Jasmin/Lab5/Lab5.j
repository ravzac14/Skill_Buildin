.class public Lab5
.super java/lang/Object

.method public <init>()V
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V
	.limit stack 6
	.limit locals 6
	
	;#0 is reserved
	;#1 is loop counter i
	;#2 is number of iterations initially 5

	iconst_0
	istore_1
	iconst_5
	istore_2

Loop:
	iload_1
	iconst_1
	iadd
	istore_1
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "*****"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	iload_1
	iload_2
	if_icmpne	Loop

	iconst_0
	istore_3

TimesThang:
	iinc 3 1
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload_3	
	dup 
	imul
	invokevirtual java/io/PrintStream/println(I)V
	
	iload_3
	iload_2
	if_icmpne	TimesThang
	
	return
.end method


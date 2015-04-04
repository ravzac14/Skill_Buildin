;Zack Raver, ravzac14
;How many birthdays from 1980-2013 on leap year

.class public LeapYear
.super java/lang/Object

.method public <init>()V
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V
	.limit stack 5
	.limit locals 4

	ldc 2013 
	;istore_1
	ldc 1980
	;istore_2
	isub
	;istore_1
	ldc 4
	;istore_2
	idiv
	;istore_1

	ldc 1
	;istore_2
	iadd
	istore_1

	
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload_1
	invokevirtual java/io/PrintStream/println(I)V
	return

.end method

.class public Lab3A
.super java/lang/Object

.method public <init>()V
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V
	.limit stack 5
	.limit locals 3
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 0xF0
	ldc 0xAA
	iand
	invokevirtual java/io/PrintStream/println(I)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 0xF0
	ldc 0xAA
	ior
	invokevirtual java/io/PrintStream/println(I)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 0xF0
	ldc 0xAA
	ixor
	invokevirtual java/io/PrintStream/println(I)V
	
	return
.end method

;zack raver 
;first jasmin program
.class public Lab1B
.super java/lang/Object

.method public <init>()V
	aload_0
	
	invokespecial java.lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V
	;number of stack elements dictates how many things in main i think
	.limit stack 2

	;find System.out (an object of type PrintStream)
	;and put it back in stack
	getstatic java/lang.System/out Ljava/io/PrintStream;

	;find the string (characters) to be printed
	;and put it on the stack
	ldc "Hello World!"

	;invoke the PrintSteam/println method
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	return
.end method

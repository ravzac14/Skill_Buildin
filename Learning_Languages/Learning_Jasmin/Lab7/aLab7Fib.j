.class public aLab7Fib
.super java/lang/Object

.method public <init>()V
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V
	.limit stack 8
	.limit locals 5
	
	;0 is reserved
	;1 is loop counter i 
	;2 is number of iterations = 12
	;3 is address of the array
	;4 is temp

	bipush 12
	newarray int
	astore_3
	
	iconst_0
	istore_1

	bipush 10
	istore_2

	;Initialize and print the first two elements (0 and 1)

	aload_3
	iconst_0
	iconst_0
	iastore

	aload_3
	iconst_1
	iconst_1
	iastore

	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload_3
	iconst_0
	iaload
	invokevirtual java/io/PrintStream/println(I)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload_3
	iconst_1
	iaload
	invokevirtual java/io/PrintStream/println(I)V

	;fib[i] = fib[i-1] + fib[i-2]
	;Loop to print the next ten elements of the fib numbers

Loop:
	aload_3
	iload_1
	iconst_2
	iadd		;gives indice of i + 2
	
	aload_3
	iload_1
	iaload
	aload_3
	iload_1
	iconst_1
	iadd		;gives indice of i + 1
	iaload
	iadd		;add f(i) + f(i+1)
	
	iastore

	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload_3
	iload_1
	iconst_2
	iadd
	iaload
	invokevirtual java/io/PrintStream/println(I)V

	iinc 1 1

	iload_1
	iload_2
	if_icmplt Loop

	return
.end method


		

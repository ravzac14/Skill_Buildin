.class public EmployeeJas
.super java/lang/Object

.field public id I
.field public name Ljava/lang/String;

.method public<init>()V
	aload_0
	invokespecial java/lang/Object/<init>()V
	return
.end method

.method public<init>(ILjava/lang/String;)V
	.limit locals 5
	.limit stack 5
	aload_0
	invokespecial java/lang/Object/<init>()V
	;aload_0
	;iload_1
	;putfield EmployeeJas/id I
	;aload_0
	;aload_2
	;putfield EmployeeJas/name Ljava/lang/String;
	return
.end method

.method public static main([Ljava/lang/String;)V
	.limit stack 20
	.limit locals 20
	
	new EmployeeJas
	dup
	
	;bipush 20
	;ldc "Hank"
	invokespecial EmployeeJas/<init>()V
	astore 3

	return
.end method

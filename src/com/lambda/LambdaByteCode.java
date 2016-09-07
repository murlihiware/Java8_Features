package com.lambda;
class LambdaByteCode
{
	public static void main(String[] a)
	{	
		Thread t = new Thread(()->System.out.print("hello there"));
		t.start();
	}
}

/*
class LambdaByteCode {
  LambdaByteCode();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class java/lang/Thread
       3: dup
       
       4: invokedynamic #3,  0              // InvokeDynamic #0:run:()Ljava/lang/Runnable;
       
       9: invokespecial #4                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
      12: astore_1
      13: aload_1
      14: invokevirtual #5                  // Method java/lang/Thread.start:()V
      17: return
}
*/
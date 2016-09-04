package com.lambda;

interface Executable{
	int execute(int a,int b);
}

interface StringExecutable{
	String execute(String a);
}

class Runner
{
	public void run(Executable e)
	{
		System.out.println("Hi Starting run method ");
		int value = e.execute(12,13);
		System.out.println("Value returned is "+value);
	}
	
	/*public void run(StringExecutable e)
	{
		System.out.println("Hi Starting run method ");
		String value = e.execute("Hi");
		System.out.println("Value returned is "+value);
	}*/
}

//		  () -> System.out.println("Hello there....")

/*
	      () -> {
					System.out.println("Executing lambda body.....");
					System.out.println("Hello there....");
				}
 
 */

/*
	 	  () -> {
				   System.out.println("Executing lambda body.....");
				   System.out.println("Hello there....");
				   return 8;
			    }
 */

/*
 		() -> {
			return 8;
		}
 */

// 		() -> 8     //we can have method call which returns int in place of 8

//      (int n) -> 8+n

//      n -> 8 + n

/*
 		(int n) ->  {
			System.out.println("Hello there....");
			return 8+n;
		}
 */

/* java can infer type.
 
 		n ->  {
			System.out.println("Hello there....");
			return 8+n;
		}
 */

/*
 		(n1, n2) -> {
			System.out.println("Hello there....");
			return n1 + n2;
		}
 */



public class AppDemo {

	public static void main(String[] args) {
		int count = 100;
		//count = count +4; can't do this. This is called effectively final.
		
		int d = 200;
		
		Runner runner = new Runner();
		runner.run(new Executable() {
			public int execute(int n1, int n2) {
				System.out.println("Hello there....");
				//int d = 8; can do this. no issue.
				return count + n1 + n2;
			}
		});

		System.out.println("=============================");

		runner.run((n1, n2) -> {
			System.out.println("Hello there....");
			// int d = 8; can't do this. This has scope as per the method
			return n1 + n2 + count;
		});
		
		/*Executable ex= (n1, n2) -> {
			System.out.println("Hello there....");
			// int d = 8; can't do this. This has scope as per the method
			return n1 + n2 + count;
		};
		
		Object o = (Executable)(n1, n2) -> {
			System.out.println("Hello there....");
			// int d = 8; can't do this. This has scope as per the method
			return n1 + n2 + count;
		};*/
		
		//small example for method reference
		runner.run(Utility::sum);
		

	}

}

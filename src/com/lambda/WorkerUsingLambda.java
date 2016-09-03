package com.lambda;
public class WorkerUsingLambda {

	public static void main(String[] args) {
		new Thread(WorkerUsingLambda::test).start();
	}

	public static void test() {
		System.out.println("Now thread is running in this");
	}

}

class Worker implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread is running");
	}
}

package test;

import java.util.Map;

/*
 * Thread Test Class
*/

// How to generate thread
// 1. use java.lang.Thread Class
// 2. use java.lang.Runnable Interface.

// 1. using java.lang.Thread Class
public class TTC01 extends Thread {
	// run commands when thread is on running.
	public void run() {

		// returns numbers of thread running on current thread group.
		int a = activeCount();
		System.out.println("activeCount() : " + a);

		// returns thread instance which is currently on running.
		Thread b = currentThread();
		System.out.println("currentThread() : " + b);

		// returns stack traces map of every running thread.
		Map<Thread, StackTraceElement[]> c = getAllStackTraces();
		System.out.println("getAllStackTraces()" + c);

		// returns identifier of a thread that currently on running.
		long d = getId();
		System.out.println("getId() : " + d);

		// returns Thread's name.
		String e = getName();
		System.out.println("getName() : " + e);

		// returns thread's priority.
		int f = getPriority();
		System.out.println("getPriority() : " + f);
		
		// returns thread's state.
		Thread.State g = getState();
		System.out.println("getState() : " + g);
		
		// stops other running threads and run.
		// void join();
		
		// thread scheduler calls this method when thread runs.
		// void run();
		
		// It changes thread's name with transfered parameter.
		// void setName(String name);
		
		// it modifies thread's priority with transfered parameter.
		// void setPriority(int new Priority);
		
		// It makes thread to sleep for transfered parameter.
		// static void sleep(long milis);
		
		// a running thread informs scheduler that it changes to waiting status.
		// static void yield();

	}

}

// one way to start thread
class Runner extends Thread {
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println("Hello " + i);

			Thread.sleep(100);		// put it into try/cache block with InterruptedException
		}
	}
}

// 2 runners will run simultaniously
Runner runner1 = new Runner();
runner1.start();


Runner runner2 = new Runner();
runner2.start();

// another way to start threads
class Runner implements Runnable {
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println("Hello " + i);

			Thread.sleep(100);		// put it into try/cache block with InterruptedException
		}
	}
}

Thread t1 = new Thread(new Runner());
Thread t2 = new Thread(new Runner());

t1.start();
t2.start();

// using anonimous class

Thread t1 = new Thread(new Runner() {
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println("Hello " + i);

			Thread.sleep(100);		// put it into try/cache block with InterruptedException
		}
	}
});

t1.start();
package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CachedThreadPoolExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		ExecutorService cachedPool = Executors.newCachedThreadPool();
		
		cachedPool.submit(new PrintTask());
		Future<String> future = cachedPool.submit(new PrintCallable());
		
		System.out.println(future.get());
			
		cachedPool.shutdown();
		
		
		System.out.println("All done...");
		
		

	}
	
	

}

class PrintTask implements Runnable {

	@Override
	public void run() {
		System.out.println("PrintTask implements Runnable");
		
	}
	
	
}

class PrintCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Print Callable";
	}
	
}

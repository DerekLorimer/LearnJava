package sys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SynchronizedMethodTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//fail("Not yet implemented");
		System.out.println("SUCCESS");
		
		SynchronizedMethod sum = new SynchronizedMethod();
		
		IntStream.range(0,1000).forEach(i -> {
			sum.calculate();
			
		});
		
		assertEquals(1000,sum.getSum());
		
	}
	
	@Test
	public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
	    ExecutorService service = Executors.newFixedThreadPool(3);
	    SynchronizedMethod summation = new SynchronizedMethod();
	 
	    IntStream.range(0, 1000)
	      .forEach(count -> service.submit(summation::calculate));
	    service.awaitTermination(1000, TimeUnit.MILLISECONDS);
	 
	    assertEquals(1000, summation.getSum());
	}

}

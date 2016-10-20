package icici_v2;

import java.util.concurrent.*;

public class FutureExample {

	public static void main(String[] args) {
		
		
		MyCallable task1=new MyCallable(10);
		//MyCallable task2=new MyCallable(15);

		ExecutorService service = Executors.newFixedThreadPool(4);
		System.out.println(Thread.currentThread().getName()+"------Submiitings to executor");
		Future<Integer> future1 = service.submit(task1);
		//Future<Integer> future2 = service.submit(task2);
		try {
			int result = future1.get(2000, TimeUnit.MILLISECONDS);
			System.out.println("Result is ************"+result);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			future1.cancel(true);
			e.printStackTrace();
		}
		try {
			System.out.println(future1.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
class MyCallable implements Callable<Integer> {

private Integer max;
public MyCallable(Integer m)
{
max=m;
}
@Override
public Integer call() throws Exception {
Integer sum=0;
for(int i=0;i<=max;i++)
{
sum+=i;
System.out.println(Thread.currentThread().getName()+"------- Intermediate sum="+sum);
//adding sleep
Thread.sleep(1000);
}
return sum;
}

}

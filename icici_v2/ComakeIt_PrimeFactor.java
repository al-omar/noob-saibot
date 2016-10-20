package icici_v2;


import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ComakeIt_PrimeFactor {
	 static List<Integer> primeList= new ArrayList<Integer>();

	public static void main(String[] args)throws Exception {/*
	
		
		Collections.sort(primeList);
	/*	for(Integer i:primeList)
			System.out.println(i);*/
		generateList();
		Type1 t1=new Type1();
		Type1 t2=new Type1();
		Type1.primeList=primeList;
		Scanner scan=new Scanner(System.in);
		int N = scan.nextInt();
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i=0;i<N;i++){
			int input=scan.nextInt();
			t1.num=input;
			t2.num=input;
			int minPrimeFactor=0;
			Future<Integer> futureResp1=null;
					Future<Integer> futureResp2=null;
			futureResp1 = executor.submit(new Type1());
			 futureResp2 = executor.submit(new Type2());
			 while(futureResp1 == null && futureResp2==null);
			 if(futureResp1!=null)
				 	minPrimeFactor =futureResp1.get();
			 if(futureResp2!=null)
				 	minPrimeFactor =futureResp2.get();
			int diff=input-minPrimeFactor;
			System.out.println(diff+" "+minPrimeFactor);
		}
		
	}
	
	
	public static void generateList()
	{int n=(int) Math.pow(10, 6);
	boolean primes[]=new boolean[(int) Math.pow(10, 6)];
	for(int i=0;i<primes.length;i++)
	{
		primes[i]=true;
	}
		 for (int i=2; i*i<n; i++)
		    {
		       if (primes[i] == true)
		        {   for (int j=i*2; j<n; j += i)
		                primes[j] = false;		        
		        }
		    }
		 primeList.add(2);
		 for(int i=3;i<n;i=i+2){
			 if(primes[i])
			 {
				 primeList.add(i);
			 }
		 }
		 
	}

}
class Type1 implements Callable<Integer>{
	 static List<Integer> primeList= new ArrayList<Integer>();
	 int num;
	 public static int process2(int input)
		{
			for(Integer p:primeList)
			{
				if(input%p==0)
					return p;
			}
			return input;
		}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return process2(num);
	}
	
}
class Type2 implements Callable<Integer>{
	 int num;
	 public static int process(int input){
			if(input%2==0)
				return 2;
			for(int i=3;i<=Math.sqrt(input);i=i+2){
				if( (input%i==0) && isPrime(i))
					return i;
			}
			return input;
		}
		public static boolean isPrime(int n)
		{
			if (n==2)
				return true;
			for(int i=3;i<=Math.sqrt(n);i=i+2)
			{
				if(n%i==0)
					return false;
			}
			return true;
		}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return process(num);
	}
	
}

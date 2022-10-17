import java.util.*;
class Thread1 extends Thread {
	public Thread1(String name){
		super(name);
	}
		public void run(){
			Scanner sc = new Scanner(System.in);
   
			System.out.print("Input first number: ");
			int n = sc.nextInt();
			 
			System.out.print("Input second number: ");
			int m = sc.nextInt();
			int addition = n+m;
			int substraction = n-m;
			int multiplication = n*m;
			float division = (float) n/m;

			int num=0;
			if(num<5){
				if ("add" == getName())
		    System.out.println(getName() + " is executed and the result is " + addition );
			
			if ("sub" == getName())
			System.out.println(getName() + " is executed and the result is " + substraction );
			
			if ("mul" == getName())
			System.out.println(getName() + " is executed and the result is " + multiplication );
			
			if ("div" == getName())
			System.out.println(getName() + " is executed and the result is " + division );
			
			if ("oth" == getName())
			System.out.println(getName() + " is executed and the result is " + "No valid operation");
			
		}
	}
}

public class Task_1{
	public static void main(String[] args){

  Thread1 add = new Thread1("add");
  Thread1 sub = new Thread1("sub");
  Thread1 mul = new Thread1("mul");
  Thread1 div = new Thread1("div");
  Thread1 oth = new Thread1("oth");

  add.run();
  sub.run();
  mul.run();
  div.run();
  oth.run();
	}
}

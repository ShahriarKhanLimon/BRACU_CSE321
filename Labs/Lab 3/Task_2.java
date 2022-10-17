class Thread2 extends Thread {
	public Thread2(String name){
		super(name);
	}
		public void run(){
			System.out.println("The house is : " + getName());
		}
	}
	

public class Task_2 {
	public static void main(String[] args){

  Thread2 stark = new Thread2("House Stark");
  Thread2 targaryen = new Thread2("House Targaryen");
  Thread2 lannister = new Thread2("House Lannister");
  Thread2 bolton = new Thread2("House Bolton");
  Thread2 tyrell = new Thread2("House Tyrell");

  stark.setPriority(Thread.MAX_PRIORITY);
  bolton.setPriority(Thread.MIN_PRIORITY);


try {
  stark.run();
  targaryen.run();
  lannister.run();
  bolton.run();

  stark.start();
  tyrell.start();
  lannister.start();
  bolton.start();
} catch (Exception e) {
	e.printStackTrace();
}

if(stark.isAlive()){
System.out.println("Not Today!");
}

if(!bolton.isAlive()){
	System.out.println("You know nothing!");
	}
	}
}

class Thread_3 extends Thread {
 public Thread_3(String name) {
 super(name);
 }
 public void run() {
    int n = 50;
    long f_term = 0;
    long s_term = 1;
    int f_h_o_count=1,s_h_o_count=0;
    long f_h_o_sum=1,s_h_o_sum=0;
    int f_h_e_count=1,s_h_e_count=0;
    long f_h_e_sum=0,s_h_e_sum=0;
    //System.out.print("The first 50th term of the Fibonacci series: ");
    //System.out.print(f_term + ", "+s_term+",");
    for (int i = 3; i <= n; ++i) {
    long n_term = f_term + s_term;
    if(i>25){
    if(n_term%2==0){
    s_h_e_sum+=n_term;
    s_h_e_count+=1;
    }
    else{
    s_h_o_sum+=n_term;
    s_h_o_count+=1;
    }
    }
    else{
    if(n_term%2==0){
    f_h_e_sum+=n_term;
    f_h_e_count+=1;
    }
    else{
    f_h_o_sum+=n_term;
    f_h_o_count+=1;
    }
    }
   // System.out.print(n_term + ", ");
    f_term = s_term;
    s_term = n_term;
    }

    //System.out.println();
    
    long mean_first_odds = f_h_o_sum/f_h_o_count;
    long mean_first_evens = f_h_e_sum/f_h_e_count;
    long mean_second_odds = s_h_o_sum/s_h_o_count;
    long mean_second_evens = s_h_e_sum/s_h_e_count;
    long avg_of_four_means = (mean_first_odds + mean_first_evens + mean_second_odds + mean_second_evens)/4;

    if (getName() == "Mean from the odd numbers of the first half of the series"){
        System.out.println(getName()+" is: " + mean_first_odds);
    }
    if (getName() == "Mean from the even numbers of the first half of the series"){
        System.out.println(getName()+" is: " + mean_first_evens);
    }
    if (getName() == "Mean from the odd numbers of the second half of the series"){
        System.out.println(getName()+" is: " + mean_second_odds);
    }
    if (getName() == "Mean from the even numbers of the second half of the series"){
        System.out.println(getName()+" is: " + mean_second_evens);
    }

    if (getName() == "Average of 4 Means"){
        System.out.println(getName()+" is: " + avg_of_four_means);
    }
}
}
public class Task_3 {
 public static void main(String args[]) {

    int n = 50;
    long f_term = 0;
    long s_term = 1;
    System.out.print("The first 50th term of the Fibonacci series: ");
    System.out.print(f_term + ","+s_term+",");
    for (int i = 3; i <= n; ++i) {
    long n_term = f_term + s_term;
    System.out.print(n_term);
    if (i<50){
    System.out.print(",");
    }
    f_term = s_term;
    s_term = n_term;
    }
    System.out.println();
    System.out.println();

 Thread_3 m_o_f_h = new Thread_3("Mean from the odd numbers of the first half of the series");
 Thread_3 m_e_f_h = new Thread_3("Mean from the even numbers of the first half of the series");
 Thread_3 m_o_s_h = new Thread_3("Mean from the odd numbers of the second half of the series");
 Thread_3 m_e_s_h = new Thread_3("Mean from the even numbers of the second half of the series");
 Thread_3 avg_o_means = new Thread_3("Average of 4 Means");

 m_o_f_h.run();
 m_e_f_h.run();
 m_o_s_h.run();
 m_e_s_h.run();
 avg_o_means.run();
 }
}

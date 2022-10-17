
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class BankersAlgorithm {

    public static void main(String[] args) throws FileNotFoundException {
        File in = new File("input.txt");
        Scanner sc = new Scanner(in);

        //declaring variables
        int processNumber = sc.nextInt();
        int resourceNumber = sc.nextInt();
        char[] processes = new char[processNumber];
        boolean flag[] = new boolean[processNumber];
        int[][] maxResource = new int[processNumber][resourceNumber];
        int[][] allocatedResource = new int[processNumber][resourceNumber];
        int[][] needResource = new int[processNumber][resourceNumber];
        int[][] availableResource = new int[processNumber + 1][resourceNumber];
        ArrayList<Character> safeSequence = new ArrayList();

        //initializing process names to processes array
        for (int i = 0; i < processNumber; i++) {
            processes[i] = sc.next().charAt(0);
        }

        //initializing maxResource array
        for (int i = 0; i < processNumber; i++) {
            for (int j = 0; j < resourceNumber; j++) {
                maxResource[i][j] = sc.nextInt();
            }
        }

        //initializing allocatedResource array and needResource array
        for (int i = 0; i < processNumber; i++) {
            for (int j = 0; j < resourceNumber; j++) {
                allocatedResource[i][j] = sc.nextInt();
                needResource[i][j] = maxResource[i][j] - allocatedResource[i][j];
            }
        }

        //initializing first row of availableResource array
        for (int i = 0; i < resourceNumber; i++) {
            availableResource[0][i] = sc.nextInt();
        }

        //implementing banker's algorithm
        int i = 0;
        int counter = 0;
        while (counter < processNumber) {
            i = i % processNumber;
            if (!flag[i]) {
                boolean possible = true;
                for (int j = 0; j < resourceNumber; j++) {
                    if (needResource[i][j] > availableResource[counter][j]) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    flag[i] = true;
                    counter++;
                    for (int j = 0; j < resourceNumber; j++) {
                        availableResource[counter][j] = allocatedResource[i][j] + availableResource[counter - 1][j];
                    }
                    safeSequence.add(processes[i]);
                }
            }
            i++;
        }
        
        
        //printing outputs

        System.out.println("Need Matrix:");
        for (i = 0; i < processNumber; i++) {
            for (int j = 0; j < resourceNumber - 1; j++) {
                System.out.print(needResource[i][j] + " ");
            }
            System.out.println(needResource[i][resourceNumber - 1]);
        }

        System.out.println("Safe sequence is:");
        for (char c : safeSequence) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("Change in available resource matrix:");
        for (i = 1; i < processNumber + 1; i++) {
            for (int j = 0; j < resourceNumber - 1; j++) {
                System.out.print(availableResource[i][j] + " ");
            }
            System.out.println(availableResource[i][resourceNumber - 1]);
        }
    }
}

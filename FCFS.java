/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiqueuescheduler;

/**
 * @author Omar Mohamed Adel Elsabaawy
 *
*/
public class FCFS {
    
    private final int [] process;
    private final double [] arrival_time;
    private final double [] brust_time;
    private final double [] waiting_time;
    private double average_time;
    private double time_now;
    
    public FCFS(int[] process, double[] arrival_time, double[] brust_time) {
        this.process = process;
        this.arrival_time = arrival_time;
        this.brust_time = brust_time;
        this.waiting_time = new double[process.length];
        this.time_now = 0.0;
        this.average_time = 0.0;
    }
    
    private void makeCalculations(){
        // Firstly we get the waiting time of each process in queue.
        for (int i = 0; i < arrival_time.length; i++) {
            if (arrival_time[i] >= time_now) {
                waiting_time[i] = 0;
                time_now += brust_time[i];
            }else{
                waiting_time[i] = time_now - arrival_time[i];
                time_now += brust_time[i];
            }
        }
        
        // Secondly we calculate the average time
        double totaltime = 0;
        for (int i = 0; i < waiting_time.length; i++) {
            totaltime += waiting_time[i];
        }
        average_time = totaltime / waiting_time.length;
    }
    
    public void returnAnswer(){
        makeCalculations();
        System.out.println("Process"+" Arrival Time"+" Brust Time");
        for (int i = 0; i < process.length; i++) {
            System.out.println(process[i]+"     "+arrival_time[i]+"          "+brust_time[i]);
        }
        
        System.out.println("");
        for (int i = 0; i < waiting_time.length; i++) {
            System.out.println("Waiting time of process number "+process[i]+": "+waiting_time[i]);
        }
        System.out.println("");
        System.out.println("Average time = "+average_time);
    }
    
}

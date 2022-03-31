/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiqueuescheduler;

/**
 *
 * @author Omar Mohamed Adel Elsabaawy
 */
public class SRTF {
    private final process [] processes;
    private final double [] waiting_time;
    private final int quantamSize;
    private double average_time;
    private double time;
    private final list queue;
    private int index = 1;

    public SRTF(process[] processes, int quantamSize) {
        this.processes = processes;
        waiting_time = new double[processes.length];
        this.quantamSize = quantamSize;
        queue = new list();
        time = 0;
        average_time = 0.0;
    }
    
    private void calculations(){
        queue.sortedInsert(new Node(processes[0]));
        while(!queue.isEmpty()){
            if (queue.head.process.brust_time > quantamSize) {
                time += quantamSize;
                queue.head.process.brust_time -= quantamSize;
                if (index != processes.length) {
                    for (int i = index; i < processes.length; i++) {
                        if (processes[i].arrival_time <= time) {
                            queue.sortedInsert(new Node(processes[i]));
                            index++;
                        }else{
                            break;
                        }
                    }
                    process reEnterProcess = queue.head.process;
                    queue.deleteFront();
                    queue.sortedInsert(new Node(reEnterProcess));
                }
            }else{
                time += queue.head.process.brust_time;
                queue.head.process.complete_time = time;
                queue.deleteFront();
                if (index != processes.length) {
                    for (int i = index; i < processes.length; i++) {
                        if (processes[i].arrival_time <= time) {
                            queue.sortedInsert(new Node(processes[i]));
                            index++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        int i = 0;
        for(process process : processes){
            waiting_time[i] = process.complete_time - process.arrival_time - process.bt;
            average_time += waiting_time[i++];
        }
        average_time /= waiting_time.length;
    }
    public void returnAns(){
        calculations();
        System.out.println("Using the Short Remaining Time first Algorithm: ");
        System.out.println("");
        for (int i = 0; i < waiting_time.length; i++) {
            System.out.println("The Waiting Time of process "+processes[i].process_number+": "+waiting_time[i]);
        }
        
        System.out.println("");
        System.out.println("The Average Time: "+average_time);
        
    }
}


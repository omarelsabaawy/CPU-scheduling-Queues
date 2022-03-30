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
public class MultiQueueScheduler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] process = {0, 1, 2, 3};
        double [] arrival_time = {0, 1, 2, 3};
        double [] brust_time = {5, 3, 8, 6};
        double quantamSize = 2;

        FCFS f = new FCFS(process, arrival_time, brust_time);
        f.returnAnswer();
        
        System.out.println("-------------------------------------------");
        
//        process p0 = new process(0, 0, 5);
//        process p1 = new process(1, 1, 4);
//        process p2 = new process(2, 2, 2);  
//        process p3 = new process(3, 3, 1); 
//        
//        process p4 = new process(1, 0, 8);
//        process p5 = new process(2, 0.4, 4);  
//        process p6 = new process(3, 1, 1); 
//        
        process p7 = new process(1, 0, 4);
        process p8 = new process(2, 1, 3);
        process p9 = new process(3, 2, 1);
        process p10 = new process(4, 3, 2);
        process p11 = new process(5, 4, 6);
        
//        process pro1 [] = {p0, p1, p2, p3};
//        
//        process pro2 [] = {p4, p5, p6};
//        
        process pro3 [] = {p7, p8, p9, p10, p11};
                
        int quantamSize1 = 2;
        int quantamSize2 = 3;
        
//        RoundRobin rr = new RoundRobin(pro1, quantamSize1);
//        rr.returnAns();
//        
//        System.out.println("-------------------------------------------");
////        
//        SRTF srtf = new SRTF(pro2, quantamSize2);
//        srtf.returnAns();
//        
//        System.out.println("-------------------------------------------");
//        
        SJF sjf = new SJF(pro3);
        sjf.returnAns();
//        
//        System.out.println("-------------------------------------------");
    }
    
}

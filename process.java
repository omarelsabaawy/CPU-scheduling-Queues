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
public class process {
    int process_number;
    double arrival_time;
    double brust_time;
    double complete_time;
    double bt;

    public process(int process_number, double arrival_time, double brust_time) {
        this.process_number = process_number;
        this.arrival_time = arrival_time;
        this.brust_time = brust_time;
        complete_time = 0;
        bt = brust_time;
    }
    
}
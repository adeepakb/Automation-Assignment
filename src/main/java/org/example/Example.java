package org.example;

import java.util.PriorityQueue;
import java.util.Stack;

public class Example {

    public static void main(String[] args) {

        /*Given a set of conferences with their start and end times, the task is to find the minimum number of conference rooms required to schedule all conferences without any overlap. We are given two arrays that represent the start and end times of each conference.
 Input 1: 
        start[] = {900, 940, 950, 1100, 1500, 1800},
 end[] = {910, 1200, 1120, 1130, 1900, 2000}
 Output = 3  

        Input 2:
        Input: start[] = {900, 905, 950, 1100, 1500, 1800}
  end[] = {910, 1200, 1120, 1130, 1900, 2000} 
        Output = 3*/

        int start[] = {900, 905, 950, 1100, 1500, 1800};
        int end[] = {910, 1200, 1120, 1130, 1900, 2000};

        int sp=0;
        int ep=0;
        int rooms =0;
        int minroom=0;

        while (sp<start.length){
            if(start[sp]<end[ep]){
                rooms++;
                sp++;

            }else {
                rooms--;
                ep++;
            }minroom= Math.max(minroom,rooms);
        }
        System.out.println(minroom);


    }
}

/*
 * Edit history:
 *   Greyson, 4/1: created
 *   
 *
*/
package boids;


import mvc.AppPanel;
import simstation.Agent;
import simstation.SimStationFactory;
import simstation.SimStationPanel;
import simstation.Simulation;

public class Flocking extends Simulation {

    public Flocking(){
        super();
    }

    protected void populate(){
        for(int i = 0; i < 50; i++){
            Agent newAgent = new Bird("bird",this);
            agents.add(newAgent);
        }
        changed();
    }
    
    public static void main(String[] args){
        AppPanel panel = new SimStationPanel(new BoidsFactory());
        panel.display();
    }
}

package boids;


import mvc.Model;
import mvc.View;
import simstation.SimStationFactory;

public class BoidsFactory extends SimStationFactory {
//    @Override
//    public View getView(Model model) {
//        return new PlagueView((PlagueSimulation) model);
//    }

    @Override
    public Model makeModel() {
        return new Flocking();
    }

    @Override
    public String toString() {
        return "Flocking Simulation";
    }
    
    @Override
    public String getTitle() {
    	return "Flocking Simulation";
    }
    
    @Override
    public String about() {
    	return "Flocking Simulation. Copyright 2020 by Mario Bros";
    }
}

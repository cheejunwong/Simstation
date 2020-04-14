/*
 * Edit history:
 *   Greyson, 4/1: created
 *   
 *
*/
package simstation;

import java.awt.Color;
import java.awt.Graphics;

import mvc.Model;
import mvc.View;

public class SimulationView extends View{

	public SimulationView(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	public void paintComponent(Graphics gc) {
		
		Simulation sim = (Simulation) model;
		Color oldColor = gc.getColor();
		gc.setColor(Color.BLACK);

		Integer dotSize = 5;
		gc.fillOval(sim.getAgent().getX(), sim.getAgent().getY(), dotSize/2, dotSize/2);

		gc.setColor(oldColor);
		
	}

}

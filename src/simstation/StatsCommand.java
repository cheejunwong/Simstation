/*
 * Edit history:
 *   Greyson, 4/1: created
 *   
 *
*/
package simstation;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class StatsCommand extends Command {

	public StatsCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation) model;
		
//		String[] str = new String[5];
//		str[0] = "**Command**";
//		str[1] = "Start: Start the simulation";
//		str[2] = "Suspend: Suspend the simulation";
//		str[3] = "Resume: Resume the simulation";
//		str[4] = "Stop: Resume the simulation";
//		str[5] = "Stats: Display stats for the simulation";
//		
//		Utilities.inform(str);
			
		
	}

}

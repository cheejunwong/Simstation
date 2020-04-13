package simstation;

import java.awt.GridLayout;
//import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import mvc.AppFactory;
import mvc.AppPanel;

public class SimStationPanel extends AppPanel{

	private static final long serialVersionUID = 1L;
	private JButton start, suspend, stop, resume, stats;

	public SimStationPanel(AppFactory factory) {
		super(factory);

		this.setLayout(new GridLayout(1, 2));

		start = new JButton("Start");
		start.addActionListener(this);
		suspend = new JButton("Suspend");
		suspend.addActionListener(this);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		resume = new JButton("Resume");
		resume.addActionListener(this);
		stats = new JButton("Stats");
		stats.addActionListener(this);

		JPanel buttonPanel = new JPanel();

		JPanel startButton = new JPanel();
		startButton.add(start);
		JPanel suspendButton = new JPanel();
		suspendButton.add(suspend);
		JPanel stopButton = new JPanel();
		stopButton.add(stop);
		JPanel resumeButton = new JPanel();
		resumeButton.add(resume);
		JPanel statsButton = new JPanel();
		statsButton.add(stats);

		buttonPanel.add(startButton);
		buttonPanel.add(suspendButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(resumeButton);
		buttonPanel.add(statsButton);
		
		buttonPanel.setLayout(new GridLayout(5, 1));
		add(buttonPanel);

		JPanel viewPanel = new JPanel();
		viewPanel.add(new SimulationView((Simulation) model));
		this.add(viewPanel);
	}

//	public void actionPerformed(ActionEvent ae) {
//			Object source = ae.getSource();
//
//			if (source == "Turn") {
//				Command cmmd = new TurnCommand(model);
//				CommandProcessor.execute(cmmd);
//			} else if (source == "Move") {
//				Command cmmd = new MoveCommand(model);
//				CommandProcessor.execute(cmmd);
//			} else if (source == "Clear") {
//				Command cmmd = new ClearCommand(model);
//				CommandProcessor.execute(cmmd);
//			} else {
//				super.actionPerformed(ae);
//			}
//
//	}
	
}

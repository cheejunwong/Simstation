package simstation;

import java.io.Serializable;
import java.util.Random;

public abstract class Agent implements Runnable, Serializable{

	
	private static final long serialVersionUID = 1L;
	protected int xc;
	protected int yc;
	protected Heading heading;
	protected Simulation world;
	protected Random rng = new Random();
	protected int speed = rng.nextInt(10);
	protected Thread thread = new Thread();
	protected AgentState state = AgentState.READY;
	
	
	
	public void move(int steps) {
		switch(heading) 
		{
			case NORTH:
			{
				if(yc - steps < 0)
				{
					yc = world.SIZE + (yc - steps);
				}
				yc -= steps;
			}
			case SOUTH:
			{
				if(yc + steps > world.SIZE)
				{
					yc = world.SIZE - steps;
				}
				yc += steps;
			}
			case EAST:
			{
				if(xc + steps < world.SIZE)
				{
					xc = world.SIZE - steps;
				}
				xc += steps;
			}
			case WEST:
			{
				if(xc - steps < 0)
				{
					xc = world.SIZE - (xc - steps);
				}
				xc -= steps;
			}
		}
			world.changed();
	}
	

	public void turn(Heading heading) {
		this.heading = heading;
	}
	
	public abstract void update();
	
	public int getX() {return xc;}
	
	public int getY() {return yc;}

	@Override
	public void run()
	{
		state =  AgentState.RUNNING;
		thread = Thread.currentThread();
		world.changed();
		while(state != AgentState.STOPPED)
		{
			update();
			try {
				Thread.sleep(50);
				synchronized(this)
				{
					while(state == AgentState.SUSPENDED)
					{
						wait();
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}

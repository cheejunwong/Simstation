package simstation;

import mvc.Model;

public class Simulation extends Model{

	protected String name;
	protected Long clock = 0L;
	protected AgentState state = AgentState.READY;
	Thread thread = new Thread();
	
	
	public Long getClock(){
		return clock;
	}
	
	public Simulation() 
	{
		super();
		state = AgentState.READY;
		thread = new Thread(this);
	}
	
	public void run()
	{
		state =  AgentState.RUNNING;
		thread = Thread.currentThread();
		changed();
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
	public void start()
	{
		if(state == AgentState.READY)
		{
			state = AgentState.RUNNING;
			thread.start();
			changed();
		}
	}
	
	public void stop()
	{
		if(state == AgentState.RUNNING || state == AgentState.SUSPENDED)
		{
			state = AgentState.STOPPED;
			changed();
			notify();
		}
	}
	
	public void suspend()
	{
		if(state == AgentState.RUNNING)
		{
			state = AgentState.SUSPENDED;
			changed();
		}
		
	}
	
	public void resume()
	{
		if(state == AgentState.SUSPENDED)
		{
			state = AgentState.RUNNING;
			changed();
			notify();
		}
	}
	
	public void readyUp()
	{
		state = AgentState.READY;
		thread = new Thread();
	}
	


	public void update() 
	{
		clock++;//increase clock
		changed();//update clock
	}
	
}

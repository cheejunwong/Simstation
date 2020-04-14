package simstation;

import mvc.Model;

public class Simulation extends Model{

	
	private static final long serialVersionUID = 1L;
	protected String name;
	protected Long clock = 0L;
	final static int SIZE = 300;
	private Agent ag;
	
	public Long getClock(){
		return clock;
	}
	
	public Simulation() 
	{
		super();
		ag.state = AgentState.READY;
		ag.thread = new Thread();
	}
	
	public void run()
	{
		ag.state =  AgentState.RUNNING;
		ag.thread = Thread.currentThread();
		changed();
		while(ag.state != AgentState.STOPPED)
		{
			update();
			try {
				Thread.sleep(50);
				synchronized(this)
				{
					while(ag.state == AgentState.SUSPENDED)
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
		if(ag.state == AgentState.READY)
		{
			ag.state = AgentState.RUNNING;
			ag.thread.start();
			changed();
		}
	}
	
	public void stop()
	{
		if(ag.state == AgentState.RUNNING || ag.state == AgentState.SUSPENDED)
		{
			ag.state = AgentState.STOPPED;
			changed();
			notify();
		}
	}
	
	public void suspend()
	{
		if(ag.state == AgentState.RUNNING)
		{
			ag.state = AgentState.SUSPENDED;
			changed();
		}
		
	}
	
	public void resume()
	{
		if(ag.state == AgentState.SUSPENDED)
		{
			ag.state = AgentState.RUNNING;
			changed();
			notify();
		}
	}
	
	public void readyUp()
	{
		ag.state = AgentState.READY;
		ag.thread = new Thread();
	}
	


	public void update() 
	{
		clock++;
		changed();
	}
	

	public Agent getNeighbor(Agent seeker) {
		return null;
		
	}
	
}

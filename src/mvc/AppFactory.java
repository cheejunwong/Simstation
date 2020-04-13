package mvc;

public interface AppFactory {
	
	public Model makeModel();
	
	public String[] getEditCommands();

	public String getTitle();

	public String about();

	public String[] getHelp();

	public Command makeEditCommand(Model model, String cmmd);

}

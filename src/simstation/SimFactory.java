package simstation;

import mvc.AppFactory;
import mvc.Model;
import mvc.View;

public interface SimFactory extends AppFactory{

	public View getView(Model m);
	
}

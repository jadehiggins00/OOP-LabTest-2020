package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.*;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>();



	public void loadTask(){
		Table t = loadTable("tasks.csv", "header");
		for(TableRow row:t.rows()){
			
			Task task = new Task(row);
			tasks.add(task);
		}
	}

	public void printTasks(){
		for(Task t:tasks){
			println(t);
		}
	}
	
	
	public void settings()
	{
		size(800, 600);

	
		
	}







	

	

	public void setup() 
	{
		loadTask();
		printTasks();
	}
	
	public void draw()
	{			
		
	}
}

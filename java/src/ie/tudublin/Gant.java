package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.*;

public class Gant extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 600);

		loadTasks();
		printTasks();
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");

		for(TableRow row:table.rows())
		{
			Task task = new Task(row);
			tasks.add(task);
		}
	}

	public void printTasks()
	{
		for(Task t:tasks)
		{
			println(t);
		}
	}

	private boolean isEnd = false;
	private int whichTask = -1;

	private float border = 40;
	private float rowHeight = 40;
	float namesPart = 150;

	public void mousePressed()
	{
		for(int i = 0 ; i < tasks.size() ; i ++)
		{
			float y1 = (border + border + rowHeight * i) - 15;
			float y2 = (border + border + rowHeight * i) + 20;

			float x1 = map(tasks.get(i).getStart(), 1, 30, namesPart, width - border);
			float x2 = map(tasks.get(i).getEnd(), 1, 30, namesPart, width - border);
			
			if (mouseX >= x1 && mouseX <= x2 && mouseY >= y1 && mouseY <= y2)
			{
				whichTask = i;
				println(whichTask);
				break;
			}

		}
			
	}

	public void mouseDragged()
	{

	}

	void displayTasks()
	{
		
		textSize(14);
		textAlign(LEFT,CENTER);
		
		
		textAlign(CENTER, CENTER);
		stroke(128);
		for(int i = 1 ; i <= 30 ; i ++)
		{
			float x = map(i, 1, 30, namesPart, width - border);
			line(x, border, x, height - border);
			fill(255);
			text(i, x, border * 0.5f);
		}

		textAlign(LEFT, CENTER);
		for(int i = 0 ; i < tasks.size() ; i ++)
		{
			float y = border + border + rowHeight * i;
			fill(255);
			text(tasks.get(i).getName(), border, y);

			// Print the task
			noStroke();
			fill(0, 255, 0);
			float x1 = map(tasks.get(i).getStart(), 1, 30, namesPart, width - border);
			float x2 = map(tasks.get(i).getEnd(), 1, 30, namesPart, width - border);
			rect(x1, y - 15, x2 - x1, rowHeight - 5, 5.0f);
		}

	}

	public void setup() {
	}

	/*
	public void draw() {
		background(0, 0, 255);
		stroke(255, 0, 0);
		fill(255, 255, 0);
		line(10, 10, 100, 100);		// x1, y1, x2, y2
		point(50, 50); // x, y
		ellipse(100, 200, 50, 150); // cx, cy, w, h
		fill(0, 255, 0);
		rect(50, 10, 100, 200); // tlx, tly, w, h
		triangle(10, 10, 100, 90, 200, 200); // vertices	
	}	
	*/

	int x = 0; // 4 bytes
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}

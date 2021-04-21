package ie.tudublin;

import processing.data.TableRow;

public class Task {
    private String task;
    private int start;
    private int end;

    //getters and setters
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

     //constructor
    public Task(String task, int start, int end) {
        this.task = task;
        this.start = start;
        this.end = end;
    }//end constructor



    // constructor chaining
    public Task(TableRow row){
        this(row.getString("Task"), row.getInt("Start"), row.getInt("End"));
    }

    // toString method
    @Override
    public String toString() {
        return "Task [end=" + end + ", start=" + start + ", task=" + task + "]";
    }

    

   
    
}// end class
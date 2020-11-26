package SchedulePrinter;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.FileWriter;
import java.io.IOException;


public class printer {
	
	private ArrayList<String> ScheduleLog;
	
	public printer() {
		ScheduleLog = new ArrayList<String>();
	}
	
	private String generateFileName()
	{
	    Date date = (Date) Calendar.getInstance().getTime();  
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd_hh-mm-ss");  
	    String strDate = "Schedule_" + dateFormat.format(date) + ".txt";  
	    return strDate;
	}
	public void addLog(String log) {
		if (log != null)
			this.ScheduleLog.add(log);
	}
	
	public void printSchedule() throws IOException
	{
		System.out.println("printing schedule");
		String filename = this.generateFileName();
		String path = "./src/SchedulePrinter/" + filename;
		FileWriter writer = new FileWriter(path);
		for (String str: this.ScheduleLog) {
			writer.write(str + System.lineSeparator());
		}
		writer.close();
	}

}

package testdata;

import java.util.LinkedList;

public class LeadsExpectedDropDownList {
	
	public LinkedList<String> expectedList() {
		LinkedList<String> expectedList=new LinkedList<String>();
		 expectedList.add("All Open Leads");
		 expectedList.add("My Unread List");
		 expectedList.add("Recently Viewed Leads");
		 expectedList.add("Todays Leads");
		 expectedList.add("View - Custom1");
		 expectedList.add("view - Custom2");
		 return expectedList;
	}
	

}

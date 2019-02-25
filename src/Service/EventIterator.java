package Service;

import java.util.List;

import model.Event;

public interface EventIterator  {
      boolean moveNext();

	   
     Event current (List<Event> events, int index);
	    
	  void remove(List<Event> events,int index);
}

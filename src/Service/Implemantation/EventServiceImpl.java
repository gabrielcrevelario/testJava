package Service.Implemantation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import Service.EventIterator;
import Service.EventService;
import model.Event;

public class EventServiceImpl implements EventService{
    private EventIterator eventIterator;
   
    public EventServiceImpl() {
    	
    }
    public EventServiceImpl(EventIterator eventIterator) {
    	this.eventIterator = eventIterator;
    }
	@Override
	public synchronized  void  createEvent(List<Event> eventList, Event event) {
		eventList.add(event);
	}

	@Override
	public synchronized  void deleteEvent(List<Event> eventList,int index) {
	   eventList.remove(index);
	}

	@Override
	public synchronized void deleteAll(List<Event> eventList) {
	 eventList.removeAll(eventList);
	}

	@Override
	public synchronized  List<Event> query(List<Event> eventsList,String type, long startTime, long endTime, int option, EventIterator eventIterator, int positionCurrent){
 
		List<Event> listevents = new ArrayList<Event>();
		for (Event event : eventsList) {		
				if(event.getType() == type && event.getTimestamp() == startTime && event.getTimestamp() <  endTime )
					listevents.add(event);			
		}		
    	  
		if(option == 1) {
			 eventIterator.current( listevents, positionCurrent);
			 return listevents;
		};
		if(option == 2) {
			eventIterator.moveNext();
			positionCurrent = positionCurrent + 1;
			 eventIterator.current( listevents, positionCurrent);
			 return listevents;
			
		} else {
			positionCurrent = positionCurrent - 1;
			eventIterator.remove(listevents, positionCurrent);
			return listevents;
		}/*	} else {
		
		return listevents;
		}*/
		
     
		
	}

}

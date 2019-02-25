package Service;

import java.util.List;
import Service.EventIterator;
import Service.EventService;
import model.Event;


public interface EventService {

	void createEvent(List<Event> eventList,Event event);
	void deleteEvent(List<Event> eventList,int index);
	void deleteAll(List<Event> eventList);
	List<Event> query(List<Event> events,String type, long startTime, long endTime, int option,EventIterator eventIterator, int positionCurrent);
}

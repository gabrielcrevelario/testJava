package controller;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

//import Service.EventIterator;
import Service.EventService;
import Service.Implemantation.EventIteratorImpl;
import Service.Implemantation.EventServiceImpl;
import model.Event;
public class EventController extends Thread {

	private EventService service;
	private String state;
	private List<Event> events;
	
	public String getStates() {
		return state;
	}
	public List<Event> getEvents() {
		return this.events;
	}
	public void setState(String state) {
		this.state = state;
	}
	public EventController(List<Event> events) {
		this.events = events;
	}
	public EventController(EventService service) {
		this.service = service;
	}
	public  synchronized List<Event> getAll(String type,long startTime,long endTime, int option, EventService service, List<Event> events, int positionEvent) {
		this.state = "get";
		return service.query(events, type, startTime, endTime, option, new EventIteratorImpl(),positionEvent);
	}
	public  synchronized  void create(Event eventList, EventService service,List<Event> events) {
		this.state = "create";
		service.createEvent( events, eventList);
	}
	public  synchronized void delete(int index, EventService service, List<Event> events) {
		this.state = "delete";
		service.deleteEvent(events,index);
	}
	public boolean isNumber( String number ) {
		if(number.matches("[0-9]+")) {
			return true;
				} else {
		return false;
				}
	}
	@Override
	public void run() {
		
			while(true) {
				try {
					if(this.getEvents() == null && this.getEvents().isEmpty()) {
						Event event1 = new Event("teste1", 1);
						Event event2 =  new Event("teste2", 2);
						Event event3 = new Event("teste3", 3);
						Event event4 = new Event("teste4", 4);
						
						events.add(event1);
						events.add(event2);
						events.add(event3);
						events.add(event4);
						
						System.out.print(this.getAll(event1.getType(), event2.getTimestamp(), event4.getTimestamp(),1, new EventServiceImpl(),  events,  events.indexOf(event1)));
					} else {
						System.out.print(this.getAll(events.get(0).getType(), events.get(0).getTimestamp(), events.get(0).getTimestamp(),1, new EventServiceImpl(),  events,  events.indexOf(events.get(0))));
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}		
			
			
		}
	}

}

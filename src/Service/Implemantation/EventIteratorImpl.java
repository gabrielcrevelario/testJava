package Service.Implemantation;

import java.util.List;

import Service.EventIterator;
import model.Event;

public class EventIteratorImpl implements EventIterator {



	@Override
	public synchronized  Event current (List<Event> events, int index) {
		return events.get(index);
	}

	@Override
	public synchronized  boolean moveNext() {
		return true;
	}



	@Override
	public  synchronized  void remove(List<Event> events, int index) {
		events.remove(index);
		
	}

}

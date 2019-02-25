package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import model.Event;
import Service.EventIterator;
import Service.EventService;
import Service.Implemantation.EventIteratorImpl;
import Service.Implemantation.EventServiceImpl;
import controller.EventController;
public class Program {

	public static void main(String[] args) {
        
		
		List<Event> eventList = new ArrayList<Event>(); 
		int num = 1;
		Scanner input = new Scanner(System.in);
		while( num > 0) {
			
			/*Event event1 = new Event("teste1", 1);
			Event event2 =  new Event("teste2", 2);
			Event event3 = new Event("teste3", 3);
			Event event4 = new Event("teste4", 4);
			Random rand = new Random();
			eventList.add(event1);
			eventList.add(event2);
			eventList.add(event3);
			eventList.add(event4);*/

			System.out.print("Writer:");
			String resp = input.nextLine();
			int timestamp = input.nextInt();
			Event ev = new Event(resp, timestamp++);
			eventList.add(ev);
			EventController controller = new EventController(eventList);
			controller.start();

		   while(controller.isAlive())  {
				System.out.print("Writer Type:");
				String resp2 = input.nextLine();
				System.out.print("Writer Timestamp:");
				int timestamp2 = input.nextInt();
				Event ev2 = new Event(resp2, timestamp2++);
				eventList.add(ev2);
			
				
		   }
			System.out.print("The end!");
			
			/*System.out.print("Write Timestamp:");
			Integer timestamp = input.nextInt();
			System.out.print("Write Limit:");
			Integer limit = input.nextInt();
			Event ev = new Event(resp, timestamp);
			eventList.add(ev);
			System.out.println(controller.getAll(resp, timestamp, limit, 1, new EventServiceImpl(), eventList, eventList.indexOf(ev)));
			System.out.println("Writer Option");
			Integer option = input.nextInt();*/



		}



	}

}

package model;

public class Event {
	  public Event(String type, long timestamp) {
	        this.type = type;
	        this.timestamp = timestamp;
	    }
	  
	private  String type;
    private  long timestamp;

  

    public String getType() {
  		return type;
  	}

  	public long getTimestamp() {
  		return timestamp;
  	}
  	@Override
  	public String toString () {
  		return type.toString() +  timestamp;
  	}

}

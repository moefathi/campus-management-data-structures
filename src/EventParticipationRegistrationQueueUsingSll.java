package cms;

public class EventParticipationRegistrationQueueUsingSll {
	private EventParticipationRegistrationSll data;

	EventParticipationRegistrationQueueUsingSll() {
		setData(new EventParticipationRegistrationSll());
	}
	
	//O(1)
	public void enqueue(EventParticipationRegistration participationRequest) {
		getData().addLast(participationRequest);
		
	}

	//O(1)
	public void dequeue() {
		 getData().removeFirst();
	}

	
	//O(n)
	public void printAllRequests() {
		getData().printAll();
	}
	
	//O(1)
	public int requestCount(){
		return getData().getSize();
	}


	public void removeSpecific(EventParticipationRegistration registration) {
		getData().removeSpecific(registration);
	}

	public EventParticipationRegistrationSll getData() {
		return data;
	}

	public void setData(EventParticipationRegistrationSll data) {
		this.data = data;
	}
}

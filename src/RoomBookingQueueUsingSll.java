package cms;

public class RoomBookingQueueUsingSll {
	private RoomBookingSll data;

	RoomBookingQueueUsingSll() {
		setData(new RoomBookingSll());
	}
	
	//O(1)
	public void enqueue(RoomBooking bookingRequest) {
		getData().addLast(bookingRequest);
	}

	//O(1)
	public void dequeue() {
		getData().removeFirst();
	}


	//O(N)
	public void printAllRequests() {
		getData().printAll();
	}
	
	//O(1)
	public int requestCount(){
		return getData().getSize();
	}
	
	public void removeSpecific(RoomBooking booking) {
	    getData().removeSpecific(booking);
	}

	public RoomBookingSll getData() {
		return data;
	}

	public void setData(RoomBookingSll data) {
		this.data = data;
	}
	
}

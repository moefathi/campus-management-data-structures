package cms;

public class RoomBookingNode {
	RoomBooking data;
	RoomBookingNode next;

	public RoomBookingNode(RoomBooking data) {
		this.data = data;
		this.next = null;
	}
}

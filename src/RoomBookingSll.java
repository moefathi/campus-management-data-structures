package cms;

public class RoomBookingSll {

	private RoomBookingNode head;
	private RoomBookingNode tail;
	private int size;

	public RoomBookingSll() {
		head = null;
		tail = null;
		size = 0;
	}

	//O(1)
	public void addLast(RoomBooking data) {
		RoomBookingNode newNode = new RoomBookingNode(data);

		if (data == null || data.getStudentId() == null || data.getRoomId() == null ||
				data.getStudentId().isEmpty() || data.getRoomId().isEmpty()) {
			System.out.println("Please Enter Valid Data!");
		} else {
			if (isEmpty()) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			size++;
			System.out.println("Room booking request for: " + data.getStudentId() + " in room: " + data.getRoomId());
		}
	}

	//O(1)
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("There are no requests to approve!!");
			return;
		} else {
			RoomBookingNode tmp = head;
			System.out.println("Request Approved for : " + head.data.getStudentId() + " in room: " + head.data.getRoomId());
			head = head.next;
			if (head == null) {
				tail = null;
			}
			tmp.next = null;
			size--;
		}
	}
	

	//O(n)
	public void printAll() {
		if (isEmpty()) {
			System.out.println("There are no requests!!");
			return;
		}

		RoomBookingNode current = head;
		while (current != null) {
			System.out.println("Student ID: " + current.data.getStudentId() + " Room ID: " + current.data.getRoomId());
			current = current.next;
		}
	}

	//O(1)
	private boolean isEmpty() {
		return head == null;
	}

	//O(1)
	public int getSize() {
		return size;
	}

	public void removeSpecific(RoomBooking booking) {
	    if (head == null) return;
	    if (head.data.getStudentId().equals(booking.getStudentId())) {
	        head = head.next;
	        size--;
	        if (head == null) tail = null;
	        return;
	    }
	    RoomBookingNode prev = head;
	    RoomBookingNode curr = head.next;
	    while (curr != null) {
	        if (curr.data.getStudentId().equals(booking.getStudentId())) {
	            prev.next = curr.next;
	            if (curr == tail) tail = prev;
	            size--;
	            return;
	        }
	        prev = curr;
	        curr = curr.next;
	    }
	}
}

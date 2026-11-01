package cms;

public class EventParticipationRegistrationSll {
	
	private EventParticipationRegistrationNode head;
	private EventParticipationRegistrationNode tail;
	private int size;

	public EventParticipationRegistrationSll() {
		head = null;
		tail = null;
		size = 0;
	}

	//O(1)
	public void addLast(EventParticipationRegistration data) {
		EventParticipationRegistrationNode newNode = new EventParticipationRegistrationNode(data);

		if (data == null || data.getStudentId() == null || data.getEventId() == null ||
				data.getStudentId().isEmpty() || data.getEventId().isEmpty()) {
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
			System.out.println("Event participation request registration for: " + data.getStudentId() + " for event: " + data.getEventId());
		}
	}

	//O(1)
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("There are no requests to approve!!");
			return;
		} else {
			EventParticipationRegistrationNode tmp = head;
			System.out.println("Event participation request Approved for : " + head.data.getStudentId() + " for event: " + head.data.getEventId());
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

		EventParticipationRegistrationNode current = head;
		while (current != null) {
			System.out.println("Student ID: " + current.data.getStudentId() + " Event ID: " + current.data.getEventId());
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
	
	public void removeSpecific(EventParticipationRegistration reg) {
	    if (head == null) return;
	    if (head.data.getStudentId().equals(reg.getStudentId())) {
	        head = head.next;
	        size--;
	        if (head == null) tail = null;
	        return;
	    }
	    EventParticipationRegistrationNode prev = head;
	    EventParticipationRegistrationNode curr = head.next;
	    while (curr != null) {
	        if (curr.data.getEventId().equals(reg.getStudentId())) {
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

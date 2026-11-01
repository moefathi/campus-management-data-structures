package cms;

public class EventParticipationRegistration {
	private String studentId;
	private String eventId;
	
	public EventParticipationRegistration(String studentId, String eventId) {
		this.studentId = studentId;
		this.eventId = eventId;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getEventId() {
		return eventId;
	}
	
	
}

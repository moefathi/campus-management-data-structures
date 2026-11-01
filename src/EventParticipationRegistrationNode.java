package cms;

public class EventParticipationRegistrationNode {

	EventParticipationRegistration data;
	EventParticipationRegistrationNode next;

	public EventParticipationRegistrationNode(EventParticipationRegistration data) {
		this.data = data;
		this.next = null;
	}
}

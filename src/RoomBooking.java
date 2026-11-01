package cms;

public class RoomBooking {
	String studentId;
	String roomId;
	
	public RoomBooking(String studentId, String roomId) {
		this.studentId = studentId;
		this.roomId = roomId;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getRoomId() {
		return roomId;
	}
	
	
}

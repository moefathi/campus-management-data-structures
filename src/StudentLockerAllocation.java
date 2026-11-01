package cms;

public class StudentLockerAllocation {

	private int studentId;
	private String lockerId;
	
	public StudentLockerAllocation(int studentId, String lockerId) {
		this.studentId = studentId;
		this.lockerId = lockerId;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getLockerId() {
		return lockerId;
	}
			
}

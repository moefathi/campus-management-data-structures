package cms;

public class StudentLockerNode {
	StudentLockerAllocation data;
	StudentLockerNode left;
	StudentLockerNode right;
	
	public StudentLockerNode(StudentLockerAllocation data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	
}

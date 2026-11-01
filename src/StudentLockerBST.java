package cms;

public class StudentLockerBST {

	StudentLockerNode root;

	//O(logn)
	public void insert(StudentLockerAllocation data) {
		if (data == null || data.getLockerId() == null || data.getLockerId().isEmpty() || data.getStudentId() <= 0) {
			System.out.println("Error, Try again!!");
			return;
		}
		root = insertRecursive(root, data);
	}

	private StudentLockerNode insertRecursive(StudentLockerNode node, StudentLockerAllocation data) {
		if (node == null) {
			System.out.println(
					"The " + data.getLockerId() + " is reserved to student: " + data.getStudentId() + " Successfully");
			return new StudentLockerNode(data);
		}
		if (data.getStudentId() < node.data.getStudentId()) {
			node.left = insertRecursive(node.left, data);
		} else if (data.getStudentId() > node.data.getStudentId()) {
			node.right = insertRecursive(node.right, data);
		} else {
			System.out.println(
					"The student " + data.getStudentId() + " already reserved locker " + data.getLockerId() + "!");
		}
		return node;
	}
	
	//O(logn)
	public void search(int studentId) {

		if (studentId <= 0) {
			System.out.println("Error, Try again!!");
			return;
		}

		StudentLockerNode node = searchRecursive(root, studentId);

		if (node != null) {
			System.out.println("Student " + studentId + " has locker " + node.data.getLockerId());
		} else {
			System.out.println("Student " + studentId + "has no locker reserved!");
		}
	}

	private StudentLockerNode searchRecursive(StudentLockerNode node, int studentId) {
		if (node == null)
			return null;
		if (studentId == node.data.getStudentId()) {
			return node;
		}
		if (studentId > node.data.getStudentId()) {
			return searchRecursive(node.right, studentId);
		} else
			return searchRecursive(node.left, studentId);
	}
	
	//O(logn)
	public void remove(int studentId) {
		if (studentId <= 0) {
			System.out.println("Error, Try again!!");
			return;
		}

		root = removeRecursive(root, studentId);
	}

	private StudentLockerNode removeRecursive(StudentLockerNode node, int studentId) {
		if (node == null) {
			System.out.println("Student Not Found");
			return null;
		}

		if (studentId > node.data.getStudentId()) {
			node.right = removeRecursive(node.right, studentId);
		} else if (studentId < node.data.getStudentId()) {
			node.left = removeRecursive(node.left, studentId);
		} else {
			if (node.left == null) {
				System.out.println("Locker " + node.data.getLockerId() + " for student " + node.data.getStudentId()
						+ " successfully removed");
				return node.right;
			}

			if (node.right == null) {
				System.out.println("Locker " + node.data.getLockerId() + " for student " + node.data.getStudentId()
						+ " successfully removed");
				return node.left;
			}

			StudentLockerNode least = findLeastValue(node.right);
			node.data = least.data;
			node.right = removeRecursive(node.right, least.data.getStudentId());
		}

		return node;
	}

	private StudentLockerNode findLeastValue(StudentLockerNode node) {
		StudentLockerNode current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	//O(n)
	public void printAll() {

		if (root == null) {
			System.out.println("There are no locker reserved");
		}

		printAllRecursive(root);
	}

	private void printAllRecursive(StudentLockerNode node) {
		if (node != null) {
			printAllRecursive(node.left);
			System.out.println("Student " + node.data.getStudentId() + " has locker " + node.data.getLockerId());
			printAllRecursive(node.right);
		}
	}
}

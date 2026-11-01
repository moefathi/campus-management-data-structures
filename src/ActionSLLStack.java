package cms;

public class ActionSLLStack {
	private ActionSLLNode head;
	private int size;

	public ActionSLLStack() {
		head = null;
		size = 0;
	}

	public void addFirst(ActionDetermine data) {
		ActionSLLNode newNode = new ActionSLLNode(data);
		newNode.next = head;
		head = newNode;
		size++;
	}

	public ActionDetermine removeFirst() {
		if (head != null) {
			ActionDetermine temp = head.data;
			head = head.next;
			size--;
			return temp;
		} else {
			System.out.println("No action to perform");
			return null;
		}
	}
}

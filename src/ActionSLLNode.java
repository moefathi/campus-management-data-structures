package cms;

public class ActionSLLNode {
	ActionDetermine data;
	ActionSLLNode next;

	public ActionSLLNode(ActionDetermine data) {
		this.data = data;
		this.next = null;
	}
}

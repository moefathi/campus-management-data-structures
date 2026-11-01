package cms;

public class ActionRedoStack {
	private ActionSLLStack s;

	ActionRedoStack() {
		s = new ActionSLLStack();
	}


	public void push(ActionDetermine x) {
		s.addFirst(x); // first and last are correct but first is better because O(1) but last has
						// O(n)]
	}


	public ActionDetermine pop() {
		return s.removeFirst();

	}
}

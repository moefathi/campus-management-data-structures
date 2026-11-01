package cms;

public class LostFoundRecordArrayList {

	private LostFoundRecord arr[];
	private int top;
	private final int DEF_CAP = 20;

	LostFoundRecordArrayList() {
		arr = new LostFoundRecord[DEF_CAP];
		top = -1;
	}

	//O(1)
	public void insert(LostFoundRecord item) {
		if (isFull()) {
			reSize();

		}
		if (item == null || item.getDescription() == null || item.getDate() == null || item.getLocation() == null || 
				item.getDescription().isEmpty() || item.getDate().isEmpty() || item.getLocation().isEmpty()) {
			System.out.println("Please Enter Valid Data!!!");
			return;
		} else {
			top++;
			arr[top] = item;
			System.out.println("Added " + item.getDescription() +" Successfully");
		}
	}

	//O(n)
	public void itemIsFound(LostFoundRecord item) {
		int searchRes = search(item.getDescription(), item.getLocation(), item.getDate());
		if (!isEmpty() && searchRes != -1) {
			arr[searchRes].setFound(true);
			System.out.println(item.getDescription() + " is set as FOUND!");
		}
	}

	//O(n)
	public int search(String description, String location, String date) {
		if (!isEmpty()) {
			if (description.isEmpty() || location.isEmpty() || date.isEmpty()) {
				System.out.println("Please Enter Valid Data!!!");
				return -1;
			} else {
				for (int i = 0; i <= top; i++) {
					if (arr[i].getDescription().equalsIgnoreCase(description) && arr[i].getDate().equalsIgnoreCase(date)
							&& arr[i].getLocation().equalsIgnoreCase(location)) {
						System.out.println("The item is found in the list with data: ");
						System.out.println("Describtion: " + arr[i].getDescription());
						System.out.println("Date Lost: " + arr[i].getDate());
						System.out.println("Location Lost: " + arr[i].getLocation());
						System.out.println("Found? " + arr[i].isFound());
						System.out.println("----------------------------------------");
						return i;
					}
				}
				System.out.println("The item is not found in the list");
			}
		}
		return -1;
	}

	//O(n)
	public void printAllList() {
		System.out.println("All lost/found records");
		for (int i = 0; i <= top; i++) {
			System.out.println("Describtion: " + arr[i].getDescription());
			System.out.println("Date Lost: " + arr[i].getDate());
			System.out.println("Location Lost: " + arr[i].getLocation());
			System.out.println("Found? " + arr[i].isFound());
			System.out.println("----------------------------------------");

		}
	}

	//O(1)
	private boolean isFull() {
		if (top == arr.length - 1) {
			return true;
		}
		return false;
	}

	//O(n)
	private void reSize() {
		LostFoundRecord tempArr[] = new LostFoundRecord[arr.length * 2];
		for (int i = 0; i <= top; i++) {
			tempArr[i] = arr[i];
		}
		arr = tempArr;
	}

	//O(1)
	private boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

}

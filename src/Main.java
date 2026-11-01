package cms;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			
			 RoomBookingQueueUsingSll bookingQueue = new RoomBookingQueueUsingSll();
			
			EventParticipationRegistrationQueueUsingSll eventQueue = new EventParticipationRegistrationQueueUsingSll();
			
			LostFoundRecordArrayList itemsList = new LostFoundRecordArrayList();
			
			ActionUndoStack undo = new ActionUndoStack();
			ActionRedoStack redo = new ActionRedoStack();

			
			StudentLockerBST bst = new StudentLockerBST();
			
			String buildings[] = {"Red Building", "Blue building", "W building", "Iman Lab", "Workshops"};
			StudentOrientationGraph graph = new StudentOrientationGraph(buildings);
			graph.addEdge(0, 1, 4);
			graph.addEdge(0, 2, 10);
			graph.addEdge(0, 4, 50);
			graph.addEdge(1, 2, 10);
			graph.addEdge(1, 3, 67);
			graph.addEdge(2, 3, 12);
			graph.addEdge(2, 4, 30);
			graph.addEdge(3, 4, 10);

			
			while(true) {
				System.out.println("--- Campus Management System ---");
				System.out.println("What Is Your Role?");
				System.out.println("1. Student");
				System.out.println("2. Staff services");
				System.out.println("3. Undo last action");
				System.out.println("4. Redo last action");
				System.out.println("5. Quit");
				int choice = scanner.nextInt();
				scanner.nextLine();
				
				if(choice == 1) {
					System.out.println("What do you want to do?");
					System.out.println("1. Track lost/found items");
					System.out.println("2. Add Room Booking Request");
					System.out.println("3. Add Event Participation Registration Request");
					System.out.println("4. Search Locker");
					System.out.println("5. Find Shortest Path Between Buildings");


					int choiceFunctionality = scanner.nextInt();
					scanner.nextLine();
					
					if(choiceFunctionality == 1) {
						
						System.out.println("Enter The Describition Of The Lost Item: ");
						String description = scanner.nextLine();
						System.out.println("Enter The Date When The Item Is Lost: ");
						String date = scanner.nextLine();
						System.out.println("Enter The Location Where The Item Was Lost: ");
						String location = scanner.nextLine();
						LostFoundRecord item = new LostFoundRecord(description, date, location);
						itemsList.search(description, location, date);
						
						
					}else if(choiceFunctionality == 2) {
						
					System.out.println("Enter your ID: ");
					String studentID = scanner.nextLine();
					System.out.println("Enter Room ID: ");
					String roomID = scanner.nextLine();
					RoomBooking booking = new RoomBooking(studentID, roomID);
					bookingQueue.enqueue(booking);
					undo.push(new ActionDetermine("Room", "Add", booking));
					redo = new ActionRedoStack();
					
					}else if(choiceFunctionality == 3){
						
						System.out.println("Enter your ID: ");
						String studentID = scanner.nextLine();
						System.out.println("Enter Event ID: ");
						String eventId = scanner.nextLine();
						EventParticipationRegistration request = new EventParticipationRegistration(studentID, eventId);
						eventQueue.enqueue(request);
						undo.push(new ActionDetermine("Event", "Add", request));
						redo = new ActionRedoStack();

					}else if(choiceFunctionality == 4){
						System.out.println("Enter your ID");
						int studentId = scanner.nextInt();
						scanner.nextLine();
						bst.search(studentId);
						
					}else if(choiceFunctionality == 5){
						System.out.println("Enter Source Building as number");
						System.out.println("1. Red Building");
						System.out.println("2. Blue building");
						System.out.println("3. W building");
						System.out.println("4. Iman Lab");
						System.out.println("5. Workshops");
						int source = scanner.nextInt() - 1;
						scanner.nextLine();
						graph.bellManFord(source);
						
					}else {
						System.out.println("Invalid Choice");
						return;
					}
		
				}else if(choice == 2) {
					
					System.out.println("What do you want to do?");
					System.out.println("1. Add lost items");
					System.out.println("2. Set item as \"found\"");
					System.out.println("3. View all lost/found records");
					System.out.println("4. Approve Room Booking Request");
					System.out.println("5. View Room Booking Requests Count");
					System.out.println("6. View All Booking Requests");
					System.out.println("7. Approve Event Participation Request");
					System.out.println("8. View Event Participation Requests Count");
					System.out.println("9. View All Event Participation Requests");
					System.out.println("10. Assign Locker to student");
					System.out.println("11. Remove Locker from student");
					System.out.println("12. View all reserved lockers");
					System.out.println("13. Undo last action");
					System.out.println("14. Redo last action");
				
					int choiceFunctionality = scanner.nextInt();
					scanner.nextLine();
					
					if(choiceFunctionality == 1) {
						
						System.out.println("Enter The Describition Of The Lost Item: ");
						String description = scanner.nextLine();
						System.out.println("Enter The Date When The Item Is Lost: ");
						String date = scanner.nextLine();
						System.out.println("Enter The Location Where The Item Was Lost: ");
						String location = scanner.nextLine();
						LostFoundRecord item = new LostFoundRecord(description, date, location);
						itemsList.insert(item);
						
					}else if(choiceFunctionality == 2) {
						
						System.out.println("Enter The Describition Of The Lost Item: ");
						String description = scanner.nextLine();
						System.out.println("Enter The Date When The Item Is Lost: ");
						String date = scanner.nextLine();
						System.out.println("Enter The Location Where The Item Was Lost: ");
						String location = scanner.nextLine();
						LostFoundRecord item = new LostFoundRecord(description, date, location);
						itemsList.itemIsFound(item);
						
					}else if(choiceFunctionality == 3) {
						itemsList.printAllList();
						
					}else if(choiceFunctionality == 4){
						bookingQueue.dequeue();

					}else if(choiceFunctionality == 5){
						System.out.println("There are " + bookingQueue.requestCount() + " room booking requests");
						
					}else if(choiceFunctionality == 6){
						bookingQueue.printAllRequests();
						
					}else if(choiceFunctionality == 7){
						eventQueue.dequeue();
						
					}else if(choiceFunctionality == 8){
						System.out.println("There are " + eventQueue + " event participation requests");
						
					}else if(choiceFunctionality == 9){
						eventQueue.printAllRequests();
						
					}else if(choiceFunctionality == 10){
						System.out.println("Enter student ID ");
						int studentId = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter locker ID to reserve for the student ");
						String lockerId = scanner.nextLine();
						StudentLockerAllocation student = new StudentLockerAllocation(studentId, lockerId);
						bst.insert(student);
						undo.push(new ActionDetermine("Locker", "Assign", student));
						redo = new ActionRedoStack();
						
					}else if(choiceFunctionality == 11){
						System.out.println("Enter student ID to remove his reservetion for locker ");
						int studentId = scanner.nextInt();
						scanner.nextLine();
						bst.remove(studentId);
		
					}else if(choiceFunctionality == 12){
						bst.printAll();
						
					}else {
						System.out.println("Invalid Choice");
						return;
					}

				}else if(choice == 3) {
				    ActionDetermine a = undo.pop();
				    if (a != null) {
				        if (a.feature.equals("Room")) 
				        	bookingQueue.getData().removeSpecific((RoomBooking)a.data);
				        else if (a.feature.equals("Event")) 
				        	eventQueue.getData().removeSpecific((EventParticipationRegistration)a.data);
				        else if (a.feature.equals("Locker")) 
				        	bst.remove(((StudentLockerAllocation)a.data).getStudentId());
				        redo.push(a);
				    } else {
				        System.out.println("Nothing to undo.");
				    }
				}else if(choice == 4) {
				    ActionDetermine a = redo.pop();
				    if (a != null) {
				        if (a.feature.equals("Room"))
				        	bookingQueue.enqueue((RoomBooking)a.data);
				        else if (a.feature.equals("Event")) 
				        	eventQueue.enqueue((EventParticipationRegistration)a.data);
				        else if (a.feature.equals("Locker")) 
				        	bst.insert((StudentLockerAllocation)a.data);
				        undo.push(a);
				    } else {
				        System.out.println("Nothing to redo.");
				    }
				}else if(choice == 5) {
					System.out.println("Exit");
					return;
				}else {
					System.out.println("Invalid Choice");
					return;
				}

			}
	}
}

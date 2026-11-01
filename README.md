# Campus Management System
In my project, I designed and implemented a console-based Java application for managing different campus services, where each service is built on a data structure that I implemented myself. The system covers lost and found records, room booking requests, event participation requests, student locker allocation, finding distances between campus buildings, and undoing and redoing user actions.

## System Menu
When the program starts, the user chooses a role from the main menu in the Main class: student, staff services, undo last action, redo last action, or quit. A student can track lost items, add a room booking request, add an event participation registration request, search for a locker, and find the shortest distances between buildings.

Staff services include adding lost items, setting items as found, viewing all lost and found records, approving room booking and event participation requests, viewing the requests, and assigning, removing, and viewing lockers.

## Lost and Found Records
For this feature, I implemented my own ArrayList using an array with an initial capacity of 20. When the array is full, I create a new array with double the size and copy the elements to it. Each record stores a description, a date, a location, and whether the item is found.

Students can search for an item by its description, location, and date, and the search compares these values while ignoring the letter case. Staff can add items, set an item as found, and print all records. Searching and setting an item as found take O(n), while insert takes O(1) except when resizing is needed.

## Room Booking and Event Participation Requests
I used a queue for both features because the first student who sends a request should be the first one to get approved. I implemented the queue over a singly linked list that keeps both a head and a tail, so enqueue and dequeue take O(1).

A room booking request stores the student ID and the room ID, while an event participation request stores the student ID and the event ID. Staff can approve the request at the front of the queue, print all the requests, and view the number of requests.

## Student Locker Allocation
Another thing I implemented is a binary search tree that stores locker assignments using the student ID as the key. Staff can assign a locker to a student, remove a locker assignment, and print all reserved lockers in order of student ID, while a student can search for their locker.

Inserting, searching, and removing take O(log n), and printing takes O(n). When I remove a node that has two children, I replace it with the smallest value in its right subtree.

## Student Orientation Help
For this feature, I represented the campus as a weighted graph using an adjacency matrix, where each building is a vertex and each edge is the distance in meters between two buildings. In Main, I defined five buildings, which are the Red Building, Blue building, W building, Iman Lab, and Workshops, with eight edges between them.

I used the Bellman-Ford algorithm, and it takes O(n^3) because of the three nested loops over the matrix. The student chooses a source building, and the system prints the distance from it to every building.

## Undo and Redo
I implemented two stacks over a singly linked list, one for undo and one for redo. Each action is stored in an ActionDetermine object that holds the feature, the action, and the data, so the system knows how to reverse it.

The undo and redo support adding a room booking request, adding an event participation request, and assigning a locker. Undoing an action moves it to the redo stack, and performing a new action clears the redo stack. Both operations take O(1).

## Project Documentation
I have also included a PDF containing an edited version of my original university project report. It includes the class diagrams, the used ADT and operations for each feature, the time complexity analysis, the Bellman-Ford trace on the campus graph, and a comparison with alternative data structures. I removed the assignment instructions and unnecessary details while keeping the main technical documentation.

## Technologies Used
- Java

## Project Information
- **Type:** Academic Project
- **Course:** Data Structures & Algorithms
- **Semester:** Spring 2025

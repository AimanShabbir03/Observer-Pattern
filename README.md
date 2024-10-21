# Observer-Pattern
This pattern is commonly used when changes to one object require updating other objects, but the specific objects that need to be updated are not known in advance or may change over time.
# Key Components:
1. Subject: The object that holds the state and manages the list of observers. It provides methods to add, remove, and notify observers.
2. Observer: The interface or abstract class that defines the method for receiving updates from the subject.
3. Concrete Subject: Implements the subject interface and keeps track of its observers. When its state changes, it calls the notify method to update all registered observers.
4. Concrete Observer: Implements the observer interface and defines how it reacts to updates from the subject.
# How It Works:
1. Observers register themselves with a subject to receive updates.
2. When the state of the subject changes, it sends a notification to all registered observers.
3. Each observer can take action based on the update it receives from the subject.
# Example Use Cases:
1. Event Handling Systems: In GUI frameworks, when a user interacts with a UI component (e.g., a button), the listeners (observers) are notified of the event.
2. Data Binding: In frameworks like React, the UI (observers) updates automatically when the state (subject) changes.
3. Notification Systems: A newsletter system where users subscribe to notifications, and whenever there is an update, the users receive the new information.
# Advantages:
1. Loose Coupling: The subject and observers are loosely coupled, as they interact through interfaces. The subject does not need to know the concrete class of the observer.
2. Scalability: Easily add new observers without modifying the subject.
# Disadvantages:
1. Performance: Can be resource-intensive if there are many observers, as each change in the subject triggers updates to all observers.
2. Complexity: Managing observers and ensuring that they are updated correctly can introduce additional complexity.
# Code or Project 1 Explanation:
The program above demonstrates the Observer Design Pattern in Java. This pattern is used when there is a one-to-many relationship between objects, meaning when the state of one object (called the Subject) changes, all dependent objects (Observers) should be notified and updated automatically.
# 1. Key Classes and Their Roles:
1. Subject:
Manages a list of observers and notifies them of any changes in its state.
A. Has methods to attach and detach observers:
B. attach(Observer observer): Adds an observer to the list.
C. detach(Observer observer): Removes an observer from the list.
D. notifyAllObservers(): Calls the update() method on each observer when the subject's state changes.
E. setState(int state): Sets the new state of the subject and calls notifyAllObservers() to inform all attached observers about the state change.
2. Observer (abstract class):
A. Represents a generic observer. Any specific observer will extend this class.
B. Contains a reference to the Subject and an abstract method update() that each observer must implement.
3. BinaryObserver, OctalObserver, and HexaObserver:
A. These are concrete implementations of the Observer class.
B. They each observe the Subject and display the state in different formats when the state is updated:
C. BinaryObserver displays the state in binary.
D. OctalObserver displays the state in octal.
E. HexaObserver displays the state in hexadecimal.
F. Each observer is attached to the Subject during its creation and registers itself to receive updates.
# Code or Project 2 Explanation:
The provided Java code demonstrates the Observer pattern, which allows a system to notify multiple subscribers about events or changes. This example involves managing events related to file operations (like opening and saving files). 
# 1. EventManager Class
1. Purpose: Manages the subscription and notification process for different event types.
2. Fields:
A. listeners: A Map where the keys are event types (like "open" or "save") and the values are lists of EventListener objects (subscribers).
3. Constructor:
Takes one or more event types (operations) and initializes the listeners map with an empty list for each event type.
4. Methods:
A. subscribe(String eventType, EventListener listener): Adds a listener to the list of listeners for a given event type.
B.  unsubscribe(String eventType, EventListener listener): Removes a listener from the list of listeners for a given event type.
C. notify(String eventType, File file): Notifies all listeners subscribed to a specific event type by calling their update method with the event type and the file.
# 2. Editor Class
1. Purpose: Represents a text editor that can open and save files, and notifies listeners when these actions occur.
2. Fields:
A. events: An instance of EventManager that manages "open" and "save" events.
B. file: A File object representing the file being worked on.
3. Constructor:
Initializes events with two event types: "open" and "save".
4. Methods:
A. openFile(String filePath): Opens a file using the given filePath and notifies listeners that the "open" event has occurred.
B. saveFile(): Notifies listeners that the "save" event has occurred if a file has been opened; throws an exception if no file is open.
# 3. EventListener Interface
1. Purpose: Represents the observer in the pattern.
2. Method:
A. update(String eventType, File file): A method that will be called when an event occurs, passing the event type and the file.
# 4. EmailNotificationListener Class
1. Purpose: A concrete implementation of EventListener that sends an email notification when an event occurs.
2. Fields:
A. email: The recipient's email address.
3. Methods:
A. update(String eventType, File file): Prints a message simulating sending an email about the event.
# 5. LogOpenListener Class
1. Purpose: A concrete implementation of EventListener that logs events to a file.
2. Fields:
A. log: A File object representing the log file.
3. Methods:
A. update(String eventType, File file): Prints a message simulating logging the event to a file.
# 6. SMSSupportListener Class
1. Purpose: A concrete implementation of EventListener that simulates sending an SMS when an event occurs.
2. Fields:
A. phoneNumber: The recipient's phone number.
B. message: The message template to be sent.
C. SMS_MAX_LENGTH: The maximum allowed length for an SMS (160 characters).
3. Methods:
A. update(String eventType, File file): Replaces %s in the message with the file name and checks if the message length is within the SMS character limit. If it's too long, it prints a warning; otherwise, it simulates sending the SMS.
# 7. Demo Class
1. Purpose: Demonstrates how to use the Editor and EventListener classes.
2. main Method:
A. Creates an instance of Editor.
B. Subscribes a LogOpenListener to the "open" event and an EmailNotificationListener to the "save" event.
C. Subscribes a SMSSupportListener to the "save" event, which will simulate sending an SMS when a file is saved.
D. Tries to open and save a file named "test.txt".
E. Handles any exceptions that may occur during the file operations.

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.List;

class Subject {
    
   private List<Observer> observers = new ArrayList<>();
   private int state;

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   public void attach(Observer observer) {
      observers.add(observer);        
   }

   public void detach(Observer observer) {
      observers.remove(observer);
   }

   public void notifyAllObservers() {
      for (Observer observer : observers) {
         observer.update();
      }
   }     
}

abstract class Observer {
   protected Subject subject;
   public abstract void update();
}

class BinaryObserver extends Observer {

   public BinaryObserver(Subject subject) {
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println("Binary String: " + Integer.toBinaryString(subject.getState())); 
   }
}

class OctalObserver extends Observer {

   public OctalObserver(Subject subject) {
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println("Octal String: " + Integer.toOctalString(subject.getState())); 
   }
}

class HexaObserver extends Observer {

   public HexaObserver(Subject subject) {
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase()); 
   }
}

public class ObserverPatternDemo {
   public static void main(String[] args) {
      Subject subject = new Subject();

      HexaObserver hexaObserver = new HexaObserver(subject);
      OctalObserver octalObserver = new OctalObserver(subject);
      BinaryObserver binaryObserver = new BinaryObserver(subject);

      System.out.println("First state change: 15");    
      subject.setState(15);

      // Detaching the OctalObserver
      System.out.println("\nDetaching OctalObserver");
      subject.detach(octalObserver);

      // Adding a new BinaryObserver
      System.out.println("Adding a new BinaryObserver");
      BinaryObserver newBinaryObserver = new BinaryObserver(subject);

      System.out.println("\nSecond state change: 10");    
      subject.setState(10);
   }
}


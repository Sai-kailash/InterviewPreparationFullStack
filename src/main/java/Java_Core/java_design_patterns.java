package Java_Core;// Java Design Patterns Cheat Sheet

import java.util.ArrayList;
import java.util.List;

// 1. Java_Core.Singleton
class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// 2. Java_Core.Factory Method
interface Product {
    void use();
}
class ConcreteProduct implements Product {
    public void use() { System.out.println("Using product"); }
}
class Factory {
    public Product createProduct() { return new ConcreteProduct(); }
}

// 3. Builder
class User {
    private String name, email;
    public static class Builder {
        private String name, email;
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public User build() { return new User(this); }
    }
    private User(Builder b) { this.name = b.name; this.email = b.email; }
}

// 4. Java_Core.Strategy
interface Strategy {
    void execute();
}
class StrategyA implements Strategy {
    public void execute() { System.out.println("Java_Core.Strategy A"); }
}
class Context {
    private Strategy strategy;
    public void setStrategy(Strategy s) { this.strategy = s; }
    public void perform() { strategy.execute(); }
}

// 5. Java_Core.Observer
interface Observer {
    void update(String msg);
}
class ConcreteObserver implements Observer {
    public void update(String msg) { System.out.println("Received: " + msg); }
}
class Subject {
    List<Observer> observers = new ArrayList<>();
    void addObserver(Observer o) { observers.add(o); }
    void notifyObservers(String msg) {
        for (Observer o : observers) o.update(msg);
    }
}

// 6. Java_Core.Decorator
interface Component {
    void operation();
}
class ConcreteComponent implements Component {
    public void operation() { System.out.println("Base Operation"); }
}
class Decorator implements Component {
    private Component component;
    public Decorator(Component c) { this.component = c; }
    public void operation() {
        component.operation();
        System.out.println("Extended Operation");
    }
}

// 7. Java_Core.Command
interface Command {
    void execute();
}
class Receiver {
    void action() { System.out.println("Action executed"); }
}
class ConcreteCommand implements Command {
    private Receiver receiver;
    public ConcreteCommand(Receiver r) { this.receiver = r; }
    public void execute() { receiver.action(); }
}
class Invoker {
    private Command command;
    public void setCommand(Command cmd) { this.command = cmd; }
    public void invoke() { command.execute(); }
}

// 8. Proxy
interface Service {
    void request();
}
class RealService implements Service {
    public void request() { System.out.println("Real service request"); }
}
class ProxyService implements Service {
    private RealService realService;
    public void request() {
        if (realService == null) realService = new RealService();
        System.out.println("Proxy delegating");
        realService.request();
    }
}

// 9. Java_Core.Facade
class SubsystemA {
    void doA() { System.out.println("Subsystem A"); }
}
class SubsystemB {
    void doB() { System.out.println("Subsystem B"); }
}
class Facade {
    private SubsystemA a = new SubsystemA();
    private SubsystemB b = new SubsystemB();
    void operate() {
        a.doA();
        b.doB();
    }
}

package mediator_pattern;

public abstract class User {
    protected String name;
    protected ChatMediator mediator;

    public User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.mediator = chatMediator;
    }

    public abstract void send(String message);

    public abstract void receive(String message);

}

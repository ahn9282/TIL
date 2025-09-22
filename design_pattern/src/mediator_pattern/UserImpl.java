package mediator_pattern;

public class UserImpl extends User {

    public UserImpl(String name, ChatMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " : Sending Message = " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " : Received Message = " + message);

    }
}

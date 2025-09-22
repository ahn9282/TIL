package mediator_pattern;

public class Main {
    public static void main(String[] args) {
        ChatMediatorImpl mediator = new ChatMediatorImpl();

        UserImpl user1 = new UserImpl( "John", mediator);
        UserImpl user2 = new UserImpl( "Jane", mediator);
        UserImpl user3 = new UserImpl( "Bob", mediator);
        UserImpl user4 = new UserImpl("Alice", mediator);

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hello All");
    }
}

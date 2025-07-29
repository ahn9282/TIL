package study.optional.model;

public class Order {

    private Long id;
    private Delivery delivery;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Order(Long id, Delivery delivery) {
        this.id = id;
        this.delivery = delivery;
    }
}

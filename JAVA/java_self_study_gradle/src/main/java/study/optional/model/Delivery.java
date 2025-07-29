package study.optional.model;

public class Delivery {
    private String status;
    private boolean cancelled;

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public Delivery(String status, boolean cancelled) {
        this.status = status;
        this.cancelled = cancelled;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Delivery(String status) {
        this.status = status;
    }
}

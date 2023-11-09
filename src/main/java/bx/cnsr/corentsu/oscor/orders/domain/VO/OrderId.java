package bx.cnsr.corentsu.oscor.orders.domain.VO;


public class OrderId {
    private String id;
    public OrderId(String id) {
        this.id = id;
    }

    public boolean equals(String id) {
        return this.id == id;
    }

    public OrderId getIdFromString(String id) {
        if(id.length() > 10)
            return new OrderId(id.substring(5,10));
        else
            return new OrderId(id);
    }

}

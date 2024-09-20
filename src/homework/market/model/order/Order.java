package homework.market.model.order;

import homework.market.model.product.Product;
import homework.market.model.user.User;

import java.util.Date;
import java.util.Objects;

public class Order {
    private String id;
    private User user;
    private Product product;
    private Date date;
    private double price;
    private OrderStatus orderStatus;
    private int qty;
    private PaymentMethod paymentMethod;

    public Order() {

    }

    public Order(String id, User user, Product product, Date date, double price, OrderStatus orderStatus, int qty, PaymentMethod paymentMethod) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.date = date;
        this.price = price;
        this.orderStatus = orderStatus;
        this.qty = qty;
        this.paymentMethod = paymentMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(price, order.price) == 0 && qty == order.qty && Objects.equals(id, order.id) && Objects.equals(user, order.user) && Objects.equals(product, order.product) && Objects.equals(date, order.date) && orderStatus == order.orderStatus && paymentMethod == order.paymentMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, product, date, price, orderStatus, qty, paymentMethod);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", product=" + product +
                ", date=" + date +
                ", price=" + price +
                ", orderStatus=" + orderStatus +
                ", qty=" + qty +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}

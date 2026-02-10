package domain.order;

public class Order {
  private final OrderId id;
  private final Client client;
  private final ArrayList<OrderItem> items;
  private OrderState state;

  public Order(OrderId id, Client client) {
    if (id == null) {
      throw new IllegalArgumentException("ID não pode ser nulo.");
    }
    if (client == null) {
      throw new IllegalArgumentException("Cliente não pode ser nulo.")
    }
    this.id = id;
    this.client = client;
    this.state = new CreatedState();
    this.items = new ArrayList<>();
  }

  public void addItem(Product product, int quantity) {
    if (product == null) {
      throw new IllegalArgumentException("Produto não pode ser nulo.");
    }
    Money unitPrice = product.currentPrice();
    OrderItem item = new OrderItem(product, quantity, unitPrice);
    state.addItem(this, item);
  }

  public void pay() {
    state.pay(this);
  }

  public void cancel() {
    state.cancel(this);
  }

  public Money total() {
    return items.stream()
        .map(OrderItem::total)
        .reduce(Money.zero(), Money::add);
  }

  protected void internalAddItem(OrderItem item) {
    items.add(item);
  }

  protected void changeState(OrderState newState) {
    this.state = newState;
  }
}

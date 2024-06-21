package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the jewellery database table.
 * 
 */
@Entity
@NamedQuery(name="Jewellery.findAll", query="SELECT j FROM Jewellery j")
public class Jewellery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_jewellery")
	private int idJewellery;

	private BigDecimal height;

	private String material;

	private BigDecimal price;

	private int stock;

	private String type;

	private BigDecimal weight;

	private BigDecimal width;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="jewellery")
	private List<Order> orders;

	public Jewellery() {
	}

	public int getIdJewellery() {
		return this.idJewellery;
	}

	public void setIdJewellery(int idJewellery) {
		this.idJewellery = idJewellery;
	}

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getWidth() {
		return this.width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setJewellery(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setJewellery(null);

		return order;
	}

}
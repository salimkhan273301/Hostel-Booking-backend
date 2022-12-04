package com.example.model;




import javax.persistence.*;




import javax.persistence.Table;

@Entity
	@Table(name = "room")
	public class Room  {

	
	

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	   @OneToOne
	@JoinColumn(name = "CATEGORY_ID")
	    private Categorys categorys;

	    @Column(name = "number")
	    private String number;

	    @Column(name = "price")
	    private double price;

	    @Column(name = "available")
	    private int available;

	    public Room() {

	    }

	    public Room(long id, Categorys categorys, String number, double price, int available) {
	        this.id = id;
	        this.categorys = categorys;
	        this.number = number;
	        this.price = price;
	        this.available = available;
	    }

	    public Room(Categorys categorys, String number, double price, int available) {
	        this.categorys = categorys;
	        this.number = number;
	        this.price = price;
	        this.available = available;
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getNumber() {
	        return number;
	    }

	    public void setNumber(String number) {
	        this.number = number;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public int getAvailable() {
	        return available;
	    }

	    public void setAvailable(int available) {
	        this.available = available;
	    }

	    public Categorys getCategory() {
	        return categorys;
	    }

	    public void setCategory(Categorys categorys) {
	        this.categorys = categorys;
	    }

	    @Override
	    public String toString() {
	        return String.format("Room [id = '%d', category = '%s', number = '%s', price = '%8.2f', avaible = '%d']",
	                id, categorys.toString(), number, price, available);
	    }
	}
	


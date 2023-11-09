package com.demo.entities;
// Generated Aug 18, 2023, 2:33:02 PM by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {

	private Integer id;
	private Category category;
	private String name;
	private double price;
	private int quantity;
	private boolean status;
	private String description;
	private String photo;
	private Set<ProductLanguage> productLanguages = new HashSet<ProductLanguage>(0);
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date created;
	
	private Set<InvoiceDetails> invoiceDetailses = new HashSet<InvoiceDetails>(0);

	public Product() {
	}

	public Product(Category category, String name, double price, int quantity, boolean status, String description,
			String photo, Date created) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.description = description;
		this.photo = photo;
		this.created = created;
	}

	public Product(Category category, String name, double price, int quantity, boolean status, String description,
			String photo, Date created, Set<InvoiceDetails> invoiceDetailses) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.description = description;
		this.photo = photo;
		this.created = created;
		this.invoiceDetailses = invoiceDetailses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "photo", nullable = false, length = 250)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 10)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<InvoiceDetails> getInvoiceDetailses() {
		return this.invoiceDetailses;
	}

	public void setInvoiceDetailses(Set<InvoiceDetails> invoiceDetailses) {
		this.invoiceDetailses = invoiceDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<ProductLanguage> getProductLanguages() {
		return this.productLanguages;
	}

	public void setProductLanguages(Set<ProductLanguage> productLanguages) {
		this.productLanguages = productLanguages;
	}

}

package com.example.Tech4Good.MODELOS;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "descriptionProduct", nullable = false)
    private String descriptionProduct;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "productIsNew", nullable = false)
    private Boolean productIsNew;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "idCategory", nullable = false)
    private Long idCategory;

    @Column(name = "donationDate", nullable = false)
    private LocalDate donationDate;

    @Column(name = "idDonor", nullable = false)
    private Long idDonor;

    public Product() {
    }

    public Product(Long idProduct, String productName, String descriptionProduct, Integer quantity, Boolean productIsNew, String location, Long idCategory, LocalDate donationDate, Long idDonor) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.descriptionProduct = descriptionProduct;
        this.quantity = quantity;
        this.productIsNew = productIsNew;
        this.location = location;
        this.idCategory = idCategory;
        this.donationDate = donationDate;
        this.idDonor = idDonor;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getProductIsNew() {
        return productIsNew;
    }

    public void setProductIsNew(Boolean productIsNew) {
        this.productIsNew = productIsNew;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public Long getIdDonor() {
        return idDonor;
    }

    public void setIdDonor(Long idDonor) {
        this.idDonor = idDonor;
    }
}

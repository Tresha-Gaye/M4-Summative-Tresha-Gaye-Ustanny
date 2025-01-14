package com.company.Group2GameStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="tshirt")
public class Tshirt {
    @Id
    @Column(name="tshirt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tshirtId;

    @NotEmpty(message = "Tshirt must not be empty")
    private String tshirt;

    @NotEmpty(message = "Color must not be empty")
    private String color;

    @NotEmpty(message = "Size must not be empty")
    private String size;

    @NotEmpty(message = "Description must not be empty")
    private String description;

    @DecimalMin("1.00")
    @NotNull(message = "Price can't be less than 1.00")
    private BigDecimal price;

    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    public Tshirt(Integer tshirtId, String tshirt, String color, String size, String description, BigDecimal price, Integer quantity) {
        this.tshirtId = tshirtId;
        this.tshirt = tshirt;
        this.color = color;
        this.size = size;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Tshirt() {
    }

    public Integer getTshirtId() {
        return tshirtId;
    }

    public void setTshirtId(Integer tshirtId) {
        this.tshirtId = tshirtId;
    }

    public String getTshirt() {
        return tshirt;
    }

    public void setTshirt(String tshirt) {
        this.tshirt = tshirt;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tshirt)) return false;
        Tshirt tshirt1 = (Tshirt) o;
        return Objects.equals(tshirtId, tshirt1.tshirtId) && Objects.equals(tshirt, tshirt1.tshirt) && Objects.equals(color, tshirt1.color) && Objects.equals(size, tshirt1.size) && Objects.equals(description, tshirt1.description) && Objects.equals(price, tshirt1.price) && Objects.equals(quantity, tshirt1.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tshirtId, tshirt, color, size, description, price, quantity);
    }

    @Override
    public String toString() {
        return "Tshirt{" +
                "tshirtId=" + tshirtId +
                ", tshirt='" + tshirt + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}


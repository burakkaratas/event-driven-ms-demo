package net.burakkaratas.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "product")
public class ProductEntity implements Serializable
{
    @Id
    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}

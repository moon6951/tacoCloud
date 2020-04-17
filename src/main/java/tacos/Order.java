package tacos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    public Date placedAt;

    @NotBlank(message="Delivery name is required")
    public String deliveryName;

    @NotBlank(message="Street is required")
    public String deliveryStreet;

    @NotBlank(message="City is required")
    public String deliveryCity;

    @NotBlank(message="State is required")
    public String deliveryState;

    @NotBlank(message="Zip code is required")
    public String deliveryZip;

    //@CreditCardNumber(message="Not a valid credit card number")
    public String ccNumber;

    //@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            //message="Must be formatted MM/YY")
    public String ccExpiration;

    //@Digits(integer=3, fraction=0, message="Invalid CVV")
    public String ccCVV;

    @ManyToMany(targetEntity=Taco.class)
    public List<Taco> taco = new ArrayList<>();

    public void addDesign(Taco design) {
        this.taco.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

}
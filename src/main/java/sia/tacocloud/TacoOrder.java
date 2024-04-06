package sia.tacocloud;

import java.util.List;
import java.util.ArrayList;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.CreditCardNumber;
import lombok.Data;

@Data
public class TacoOrder {
    @NotBlank(message="Delivery name is required")
    private String deliveryName;
    
    @NotBlank(message="Delivery street is required")
    private String deliveryStreet;
    
    @NotBlank(message="Delivery city is required")
    private String deliveryCity;
    
    @NotBlank(message="Delivery state is required")
    private String deliveryState;
    
    @NotBlank(message="Delivery zip is required")
    private String deliveryZip;
    
    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    
    @NotNull
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

}

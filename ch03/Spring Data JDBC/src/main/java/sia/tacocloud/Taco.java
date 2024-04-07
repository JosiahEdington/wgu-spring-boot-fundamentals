package sia.tacocloud;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table
public class Taco {
    @Id
    private Long id;
    private Date createdAt = new Date();

    @NotNull
    @Size(min=4, message="Name must be at least 4 characters long.")
    private String name;

	@NotNull
	@Size(min=1, message="You must choose at least 1 ingedient")
	private List<Ingredient> ingredients;

}

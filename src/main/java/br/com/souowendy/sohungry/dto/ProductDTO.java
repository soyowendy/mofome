package br.com.souowendy.sohungry.dto;

import br.com.souowendy.sohungry.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Long id;
	private String name;
	private Double price;
	private String description;
	private String imageUri;

	public ProductDTO(Product product) {
		id = product.getId();
		name = product.getName();
		price = product.getPrice();
		description = product.getDescription();
		imageUri = product.getImageUri();
	}
}

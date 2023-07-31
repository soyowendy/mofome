package br.com.souowendy.sohungry.dto;

import br.com.souowendy.sohungry.constants.OrderStatus;
import br.com.souowendy.sohungry.models.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	private Long id;
	private String address;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus status;
	private Double total;
	private List<ProductDTO> products = new ArrayList<>();

	public OrderDTO(Order order) {
		id = order.getId();
		address = order.getAddress();
		latitude = order.getLatitude();
		longitude = order.getLongitude();
		moment = order.getMoment();
		status = order.getStatus();
		total = order.getTotal();
		products = order.getProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
	}
}

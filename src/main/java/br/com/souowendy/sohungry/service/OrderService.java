package br.com.souowendy.sohungry.service;

import br.com.souowendy.sohungry.constants.OrderStatus;
import br.com.souowendy.sohungry.dto.OrderDTO;
import br.com.souowendy.sohungry.dto.ProductDTO;
import br.com.souowendy.sohungry.models.Order;
import br.com.souowendy.sohungry.models.Product;
import br.com.souowendy.sohungry.repository.OrderRepository;
import br.com.souowendy.sohungry.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		return orderRepository.findOrdersWithProducts().stream().map(OrderDTO::new).collect(Collectors.toList());
	}

	@Transactional
	public OrderDTO insert(OrderDTO orderDTO) {
		Order order = new Order(
				null,
				orderDTO.getAddress(),
				orderDTO.getLatitude(),
				orderDTO.getLongitude(),
				Instant.now(),
				OrderStatus.PENDING
		);

		for (ProductDTO p : orderDTO.getProducts()) {
			Product product = productRepository.getReferenceById(p.getId());
			order.getProducts().add(product);
		}

		order = orderRepository.save(order);
		return new OrderDTO(order);
	}

	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = orderRepository.getReferenceById(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = orderRepository.save(order);
		return new OrderDTO(order);
	}
}

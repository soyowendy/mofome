package br.com.souowendy.sohungry.service;

import br.com.souowendy.sohungry.dto.OrderDTO;
import br.com.souowendy.sohungry.dto.ProductDTO;
import br.com.souowendy.sohungry.repository.OrderRepository;
import br.com.souowendy.sohungry.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		return orderRepository.findOrdersWithProducts().stream().map(OrderDTO::new).collect(Collectors.toList());
	}
}

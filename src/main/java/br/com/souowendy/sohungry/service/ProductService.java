package br.com.souowendy.sohungry.service;

import br.com.souowendy.sohungry.dto.ProductDTO;
import br.com.souowendy.sohungry.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		return productRepository.findAllByOrderByNameAsc().stream().map(ProductDTO::new).collect(Collectors.toList());
	}
}

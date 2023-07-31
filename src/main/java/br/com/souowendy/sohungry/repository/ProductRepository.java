package br.com.souowendy.sohungry.repository;

import br.com.souowendy.sohungry.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

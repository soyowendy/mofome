package br.com.souowendy.sohungry.repository;

import br.com.souowendy.sohungry.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

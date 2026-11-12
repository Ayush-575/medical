package com.example.Medical_store.Repository;
import com.example.Medical_store.Entity.AddToCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddToCartRepository
        extends JpaRepository<AddToCart, Long> {

    List<AddToCart> findByUserId(Long userId);
}

package com.example.Medical_store.Service;

import com.example.Medical_store.Entity.AddToCart;
import com.example.Medical_store.Exception.CartItemNotFoundException;
import com.example.Medical_store.Repository.AddToCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddToCartService {

    private final AddToCartRepository addToCartRepository;

    public AddToCartService(AddToCartRepository addToCartRepository) {
        this.addToCartRepository = addToCartRepository;
    }

    public AddToCart addToCart(AddToCart cart) {

        return addToCartRepository.save(cart);
    }

    public List<AddToCart> getAllCartItems() {

        return addToCartRepository.findAll();
    }

    public AddToCart getCartItemById(Long id) {

        return addToCartRepository.findById(id)
                .orElseThrow(() ->
                        new CartItemNotFoundException(
                                "Cart Item not found with id : " + id));
    }

    public void deleteCartItem(Long id) {

        AddToCart item = getCartItemById(id);

        addToCartRepository.delete(item);
    }
}

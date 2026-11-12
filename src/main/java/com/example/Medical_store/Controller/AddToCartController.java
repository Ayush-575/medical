package com.example.Medical_store.Controller;
import com.example.Medical_store.Entity.AddToCart;
import com.example.Medical_store.Service.AddToCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class AddToCartController {

    private final AddToCartService addToCartService;

    public AddToCartController(AddToCartService addToCartService) {
        this.addToCartService = addToCartService;
    }

    @PostMapping("/add")
    public AddToCart addToCart(
            @RequestBody AddToCart cartItem) {

        return addToCartService.addToCart(cartItem);
    }

    @GetMapping("/all")
    public List<AddToCart> getAllCartItems() {

        return addToCartService.getAllCartItems();
    }

    @GetMapping("/{id}")
    public AddToCart getCartItem(
            @PathVariable Long id) {

        return addToCartService.getCartItemById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCartItem(
            @PathVariable Long id) {

        addToCartService.deleteCartItem(id);

        return "Cart Item Deleted Successfully";
    }
}

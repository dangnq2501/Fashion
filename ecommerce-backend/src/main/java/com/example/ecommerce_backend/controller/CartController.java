package com.example.ecommerce_backend.controller;

import com.example.ecommerce_backend.dto.request.CartItemRequest;
import com.example.ecommerce_backend.dto.response.ApiResponse;
import com.example.ecommerce_backend.dto.response.CartResponse;
import com.example.ecommerce_backend.dto.response.CartItemResponse;
import com.example.ecommerce_backend.service.CartService;
import com.example.ecommerce_backend.service.CartItemService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal = true)
public class CartController {
    CartService cartService;
    CartItemService cartItemService;
    @PostMapping("/user/{userId}/cart/increase")
    ApiResponse<CartResponse> increaseCartItem(@PathVariable("userId") UUID userId,
                                          @RequestBody @Valid CartItemRequest cartItemRequest){
        CartResponse cartResponse = cartService.increaseCartItem(userId, cartItemRequest);
        ApiResponse<CartResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartResponse);
        return apiResponse;
    }

    @PostMapping("/user/{userId}/cart/add")
    ApiResponse<CartResponse> addCartItem(@PathVariable("userId") UUID userId,
                                          @RequestBody @Valid CartItemRequest cartItemRequest){
        CartResponse cartResponse = cartService.addCartItem(userId, cartItemRequest);
        ApiResponse<CartResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartResponse);
        return apiResponse;
    }
    @DeleteMapping("/user/{userId}/cart/delete")
    ApiResponse<CartResponse> deleteCartItem(@PathVariable("userId") UUID userId,
                                             @RequestBody @Valid CartItemRequest cartItemRequest){
        CartResponse cartResponse = cartService.deleteCartItem(userId, cartItemRequest);
        ApiResponse<CartResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartResponse);
        return apiResponse;
    }

    @DeleteMapping("/user/{userId}/cart/decrease")
    ApiResponse<CartResponse> decreaseCartItem(@PathVariable("userId") UUID userId,
                                               @RequestBody @Valid CartItemRequest cartItemRequest){
        CartResponse cartResponse = cartService.decreaseCartItem(userId, cartItemRequest);
        ApiResponse<CartResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartResponse);
        return apiResponse;
    }
    @GetMapping("/user/{userId}/cart")
    ApiResponse<CartResponse> getCart(@PathVariable("userId") UUID userId){
        CartResponse cartResponse = cartService.getCart(userId);
        ApiResponse<CartResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartResponse);
        return apiResponse;
    }

    @DeleteMapping("/user/{userId}/cart/deleteAll")
    ApiResponse<CartResponse> deleteAllCartItem(@PathVariable("userId") UUID userId){
        CartResponse cartResponse = cartService.deleteAllCartItem(userId);
        ApiResponse<CartResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartResponse);
        return apiResponse;
    }

    @PutMapping("/cartItem")
    ApiResponse<CartItemResponse> updateCartItem(@RequestBody @Valid CartItemRequest cartItemRequest){
        CartItemResponse cartItemResponse = cartItemService.updateCartItem(cartItemRequest);
        ApiResponse<CartItemResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartItemResponse);
        return apiResponse;
    }

    @GetMapping("/cart/{cartId}")
    ApiResponse<CartResponse> getById(@PathVariable("cartId") UUID cartId){
        CartResponse cartResponse = cartService.getMyCart(cartId);
        ApiResponse<CartResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartResponse);
        return apiResponse;
    }



}

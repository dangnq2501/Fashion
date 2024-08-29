package com.example.ecommerce_backend.service;

import com.example.ecommerce_backend.dto.response.CartItemResponse;
import com.example.ecommerce_backend.dto.request.CartItemRequest;

import com.example.ecommerce_backend.exception.AppException;
import com.example.ecommerce_backend.exception.ErrorCode;
import com.example.ecommerce_backend.mapper.CartItemMapper;
import com.example.ecommerce_backend.models.CartItem;
import com.example.ecommerce_backend.repository.CartItemRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.UUID;
@Service
@RequiredArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal = true)
public class CartItemService {
    CartItemMapper cartItemMapper;
    CartItemRepository cartItemRepository;
    public CartItemResponse getById(UUID id){
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.CART_ITEM_NOT_EXISTED));
        return cartItemMapper.toCartItemResponse(cartItem);
    }

    public CartItemResponse updateCartItem(CartItemRequest cartItemRequest){
        UUID cartItemId = cartItemRequest.getId();
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(() -> new AppException(ErrorCode.CART_ITEM_NOT_EXISTED));
        return update(cartItem, cartItemRequest);
        
    }

    private CartItemResponse update(CartItem cartItem, CartItemRequest cartItemRequest){
        cartItemMapper.updateCartItem(cartItem, cartItemRequest);
        return cartItemMapper.toCartItemResponse(cartItemRepository.save(cartItem));
    }
}

package com.hef.service;

import com.hef.domain.ProductItem;

import java.util.List;

public interface ProductService {

    void insertProductItem(ProductItem productItem);

    List<ProductItem> findProductItemList();

    void deleteProductItemById(Long piId);

    void updateProductItem(ProductItem productItem);


}

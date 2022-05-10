package com.hef.controller;

import com.hef.domain.ProductItem;
import com.hef.service.ProductService;
import com.hef.service.impl.ProductServiceImpl;

import java.util.List;

/**
 * @Date 2022/5/10
 * @Author lifei
 */
public class ProductMain {

    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
//        productService.insertProductItem(new ProductItem.Builder().productName("p01").productVersion("p01 v01").builder());
//        productService.insertProductItem(new ProductItem.Builder().productName("p0").productVersion("p01 v02").builder());

        productService.deleteProductItemById(2l);

        productService.updateProductItem(new ProductItem.Builder().piId(1l).productName("pt01").productVersion("pt01_v01").builder());

        List<ProductItem> productItemList = productService.findProductItemList();
        System.out.println(productItemList);
    }
}

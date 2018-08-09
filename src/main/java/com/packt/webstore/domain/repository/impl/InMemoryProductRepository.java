package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<>();

    public InMemoryProductRepository() {

        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem o rozdzielczości 640×1136 i 8-megapikselowym aparatem");
        iphone.setCategory("smartfon");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product huawei = new Product("P1237", "Huawei", new BigDecimal(1300.25));
        huawei.setDescription("Huawei P10 Light, smartfon z 5-calowym ekranem o rozdzielczości 333×444 i najlepszym 18-megapikselowym aparatem");
        huawei.setCategory("smartfon");
        huawei.setManufacturer("Huawei");
        huawei.setUnitsInStock(300);

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorami Intel Core 3. generacji");
        laptop_dell.setCategory("laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1500);

        Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon™ S4 Pro");
        tablet_Nexus.setCategory("tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(800);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
        listOfProducts.add(huawei);
    }


    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }


    @Override
    public Product getProductById(String productId) {
        Product productById = null;
        for (Product p : listOfProducts) {
            if (p != null && p.getProductId() != null && p.getProductId().equals(productId)) {
                productById = p;
                break;
            }
        }
        if (productById == null) {
            throw new IllegalArgumentException("Brak produktu o wskazanym id:" + productId);
        }
        return productById;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product p : listOfProducts) {
            if (category.equalsIgnoreCase(p.getCategory())) {
                productsByCategory.add(p);
            }
        }
        return productsByCategory;
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();

        Set<String> criterias = filterParams.keySet();

        if (criterias.contains("brand")) {
            for (String brandName : filterParams.get("brand")) {
                for (Product product : listOfProducts) {
                    if (brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }

        if (criterias.contains("category")) {
            for (String category : filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }

        productsByCategory.retainAll(productsByBrand);

        return productsByCategory;
    }
}

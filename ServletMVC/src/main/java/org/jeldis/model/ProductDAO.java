/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jeldis.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge.gonzalez
 */
public class ProductDAO {

    public List<Product> lista() {

        List<Product> products = new ArrayList<Product>();

        Product product = new Product();
        product.setId(1);
        product.setName("MESA");
        product.setDescription("LINEA MARRON");
        product.setPrice(10.99);
        products.add(product);

        product = new Product();
        product.setId(2);
        product.setName("SILLAS");
        product.setDescription("LINEA MARRON");
        product.setPrice(12.99);
        products.add(product);

        System.out.println("crea lista");

        return products;

    }
}

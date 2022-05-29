package com.example.pa;

public class CartItem {
    private String name;
    private Double price;
    private Integer quantity;

    public CartItem(String name, Double price, Integer quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName()
    {
        return this.name;
    }

    public Double getPrice()
    {
        return this.price;
    }

    public Integer getQuantity()
    {
        return this.quantity;
    }
    
    public void addQuantity(Integer quantity)
    {
        this.quantity += quantity;
    }
    
}

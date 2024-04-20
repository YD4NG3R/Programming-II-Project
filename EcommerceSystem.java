/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ecommercesystem;
import java.lang.Math;
import java.util.Scanner;

class Product {
    private int productId;
    private String name;
    private float price;

    public Product(int productId, String name, float price) {
        this.productId = Math.abs(productId);
        this.name = name;
        this.price = Math.abs(price);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = Math.abs(productId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = Math.abs(price);
    }
}

class ElectronicProduct extends Product {
    private String brand;
    private int warrantyPeriod;

    public ElectronicProduct(int productId, String name, float price, String brand, int warrantyPeriod) {
        super(productId, name, price);
        this.brand = brand;
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }
}

class ClothingProduct extends Product {
    private String size;
    private String fabric;

    public ClothingProduct(int productId, String name, float price, String size, String fabric) {
        super(productId, name, price);
        this.size = size;
        this.fabric = fabric;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }
}

class BookProduct extends Product {
    private String author;
    private String publisher;

    public BookProduct(int productId, String name, float price, String author, String publisher) {
        super(productId, name, price);
        this.author = author;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

class Customer {
    private int customerId;
    private String name;
    private String address;

    public Customer(int customerId, String name, String address) {
        this.customerId = Math.abs(customerId);
        this.name = name;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class Cart {
    private int customerId;
    private int nProducts;
    public Product[] products;
    public Cart(int clientId,int totalItems){
        customerId = Math.abs(clientId);
        nProducts = totalItems;
        products = new Product[totalItems];
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }
   
    public Product[] getProducts() {
        return products;
    }
    
    public void addProduct(Product product){
        // First let's search how many elements in product are set to "Zero"
        int FoundaZero = 0;
        for(int I=0;I < nProducts;I++){
            if(products[I] == null){
                products[I] = product;
                FoundaZero++;
                break;
            }
        }
        if(FoundaZero <= 0){
            System.out.println("You can not add more products, you exceeds the maximum number you have entered :) ");
        }
    }
    
    public void removeProduct(Product product){
        // It will remove only one product per time
        for(int I=0;I < nProducts;I++){
            if(products[I] == product){
                products[I] = null;
                break;
            }
        }
    }
    
    public float calculatePrice() {
        float totalPrice = 0;
        for (Product product : products) { // I have got this from the internet :)
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}

class Order {
    private int customerId;
    private int orderId;
    public Product[] products;
    private float totalPrice;

    public Order(int customerId, int orderId ,Product[] products , float totalPrice) {
        this.customerId = Math.abs(customerId);
        this.orderId = Math.abs(orderId);
        this.products = products;
        this.totalPrice = Math.abs(totalPrice);
    }

    public void printOrderInfo() {
        System.out.println("Here is your order summary: ");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
        System.out.println("Total Price: $" + totalPrice);
    }
}

public class EcommerceSystem {

    public static void main(String[] args) {
        Product smartPhone = new ElectronicProduct(1, "Smart Phone", 599.9f, "Samsung", 1);
        Product tshirt = new ClothingProduct(2, "T Shirt", 19.99f, "Medium", "Cotton");
        Product oop = new ClothingProduct(3, "OOP", 39.99f, "O’Reilly", "X Publications");
        System.out.println("Welcome to Ecommerce System!");
        Scanner input = new Scanner(System.in);
        int customerId;
        String customerName;
        String customerAddress;
        int cartSize;
        int confirm;
        System.out.println("Please enter your name:");
        customerName = input.nextLine();
        System.out.println("Please enter your address:");
        customerAddress = input.nextLine();
        System.out.println("Please enter your ID:");
        customerId = input.nextInt();
        System.out.println("How many products you want to add in your cart?");
        cartSize = input.nextInt();
        Cart cart = new Cart(customerId,cartSize);
        int ChosenProduct;
        for(int I=0; I < cartSize;I++){
            System.out.println("Which product would you like to add? 1- SmartPhone 2- T-shirt 3- OOP");
            ChosenProduct = input.nextInt();
            switch(ChosenProduct){
                case 1:
                    cart.addProduct(smartPhone);
                    break;
                case 2:
                    cart.addProduct(tshirt);
                    break;
                case 3:
                    cart.addProduct(oop);
                    break;
            }  
        }
        System.out.println("Your total is " + cart.calculatePrice() + ". Would you like to place the order? 1- Yes 2- No");
        confirm = input.nextInt();
        if(confirm == 1){
            Order order = new Order(customerId, 1, cart.getProducts(), cart.calculatePrice());
            order.printOrderInfo();
        }else{
            System.out.println("Thank you for stopping by <3");
        }
    }
}

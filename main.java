import java.util.Scanner;

import java.util.ArrayList;

class Product{

    private String productName;
    private String productID;
    private double productPrice;

    public Product(String productName, String productID, double productPrice){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productID = productID;
    }

    public double getProductPrice(){
        return this.productPrice;
    }

    public String getProductName(){
        return this.productName;
    }

    public String getProductID(){
        return this.productID;
    }
}

class Customer{
    private String customerID;

    public String userInput(){
        String pID;
        Scanner myScan = new Scanner(System.in);
        pID = myScan.next();
        return pID;
    }

    public String addProduct(){
        System.out.print("Enter Product ID to add: ");
        return this.userInput();
    }

    public String removeProduct(){
        System.out.print("Enter Product ID to remove: ");
        return this.userInput();
    }

    public Customer(String customerID){
        this.customerID = customerID;
    }
}

class Cart{
    private double totalCost;
    private int numberOfItems;
    private ArrayList<Product> productList;

    public void addToCart(Product product){
        this.productList.add(product);
        this.numberOfItems += 1;
        this.totalCost += product.getProductPrice();
    }

    public boolean removeFromCart(String userInput){
        for (int i = 0; i < this.productList.size(); i++){
            Product p = productList.get(i);
            if (p.getProductID().equalsIgnoreCase(userInput)){
                this.productList.remove(p);
                this.numberOfItems -= 1;
                this.totalCost -= p.getProductPrice();
                return true;
            }
        }
        return false;
    }

    public Cart(){
        this.totalCost = 0;
        this.numberOfItems = 0;
        this.productList = new ArrayList<>();
    }

    public ArrayList<Product> getproductList(){
        return this.productList;
    }

    public void displayCart(){
        System.out.println("Total items: "+ this.numberOfItems);
        System.out.println("Current total: $"+this.totalCost);
    }

    public void checkOut(){
        for(int i = 0; i < numberOfItems; i++){
            System.out.println(productList.get(i).getProductName() + "\t$" + productList.get(i).getProductPrice());
        }
        System.out.println("Total: $"+totalCost);
    }
}

class main{

    public static void main(String[] args){
        Product p1 = new Product("Keyboard", "1", 250.5);
        Product p2 = new Product("Mouse", "2", 70);
        Product p3 = new Product("PS5", "3", 1250);

        Customer myCustomer = new Customer("001");
        Cart myCart = new Cart();
        boolean exitCode = false;
        while (exitCode == false){ 
            myCart.displayCart();
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Check Out");
            System.out.print("\n" + "Option: ");
            switch(myCustomer.userInput()){
                case "1":
                    System.out.println("1. Keyboard - $250.5");
                    System.out.println("2. Mouse - $70");
                    System.out.println("3. PS5 - $1250");
                    System.out.println("0. Back");
            
                    switch(myCustomer.addProduct()){
                        case "1":
                            myCart.addToCart(p1);
                            break;
                        case "2":
                            myCart.addToCart(p2);
                            break;
                        case "3":
                            myCart.addToCart(p3);
                            break;
                        case "0":
                            break;
                        default:
                            System.out.println("Wrong Product ID!");
                    }
                    break;
                case "2":
                    if(myCart.removeFromCart(myCustomer.removeProduct())){
                        System.out.println("Product removed from cart!");
                    }
                    else{
                        System.out.println("This product doesn't exist in your cart");
                    }
                    break;
                case "3":
                    myCart.checkOut();
                    exitCode = true;
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }
}
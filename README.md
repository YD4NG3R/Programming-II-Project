# Programming-II-Project
 
**This code is coded/designed specifically for FCDS Programming II Project.**
This project is based on OOP(Object Orianted Programming).
The code uploaded in **EcommerceSystem.java** has the following classes:

- Product: This class is a super class and it's responsible for assigning main information about the product.

- ElectronicProduct: This class is a sub class and it has two addition variables (brand, warrantyPeriod).

- BookProduct: This class is a sub class and it has two addition variables (author, publisher).

- Customer: This class is responsible for saving/assigning customer data, such as customerId, name and address.

- Cart: This class is responsible for saving customer shopping cart, the following will be an explaination for addProduct method
**The method is will search for any "null" object, as we have an array with name "products" and by default all object-based-array values are initialized as null, afterward it will assign the object to the specific index**

- Order: This class is generally responsible for printing order info, such as OrderId, Total Price, etc..

- EcommerceSystem: This is the public class which has the main method, it will take the data as requested in the project, and will print in the end order info.

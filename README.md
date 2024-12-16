# **Nimap Java Machine Test**

## **Overview**
This is a Spring Boot application that demonstrates CRUD (Create, Read, Update, Delete) operations on a MySQL database. The project is built using Hibernate for ORM, JPA for data persistence, and is configured to use a Orcale database.

---

## **Features**
- Implements CRUD operations.
- Follows RESTful API principles.
- Uses Spring Data JPA for database interaction.
- Configurable database connectivity using `application.properties`.

---

## **Technologies Used**
- **Backend**: Spring Boot 3.3.6, Hibernate, JPA  
- **Database**: MySQL  
- **Tools**: Maven, H2 Console, Postman (for API testing)

---

## **Requirements**
- **Java**: JDK 17 or higher  
- **Database**: Oracle 21c or higher  
- **Build Tool**: Maven 3.8 or higher  
- **IDE**: IntelliJ IDEA / Eclipse / Spring Tool Suite  

---

## **Setup Instructions**

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```
### 2. Configure the Database
Create a MySQL database:
```sql
Copy code
CREATE DATABASE machine_test;
```
## Update the application.properties file according to your setup:
```properties
Copy code
spring.application.name=NimapJavaMachineTest


# Oracle Database Configuration
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.username=c##hr
spring.datasource.password=hr
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# Hibernate JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect

# Server Configuration
server.port=8080

```
### 3. Build the Application
Open the project in your IDE.
Run the following Maven command to build:
```bash
Copy code
mvn clean install
```
### 4. Run the Application
-Start the Spring Boot application:
```bash
Copy code
mvn spring-boot:run
The application will run on http://localhost:8080.
```



## Database Initialization

Run the server and execute the following SQL queries to add initial records:

### Categories
```sql
INSERT INTO category (CATEGID, CATEG_NAME) VALUES (category_seq.NEXTVAL, 'Electronics');
INSERT INTO category (CATEGID, CATEG_NAME) VALUES (category_seq.NEXTVAL, 'Clothing');
INSERT INTO category (CATEGID, CATEG_NAME) VALUES (category_seq.NEXTVAL, 'Home Appliances');
INSERT INTO category (CATEGID, CATEG_NAME) VALUES (category_seq.NEXTVAL, 'Toys');
INSERT INTO category (CATEGID, CATEG_NAME) VALUES (category_seq.NEXTVAL, 'Books');

```

### Products
```sql
INSERT INTO product (PRICE, PROD_NAME, CATEGID) VALUES (499.99, 'T-Shirt', 2);
INSERT INTO product (PRICE, PROD_NAME, CATEGID) VALUES (1500.00, 'Smartphone', 1);
INSERT INTO product (PRICE, PROD_NAME, CATEGID) VALUES (2500.00, 'Microwave Oven', 3);
INSERT INTO product (PRICE, PROD_NAME, CATEGID) VALUES (1200.00, 'Jeans', 2);
INSERT INTO product (PRICE, PROD_NAME, CATEGID) VALUES (199.00, 'Toy Car', 4);
INSERT INTO product (PRICE, PROD_NAME, CATEGID) VALUES (4000.00, 'Refrigerator', 3);
INSERT INTO product (PRICE, PROD_NAME, CATEGID) VALUES (800.00, 'Novel', 5);
INSERT INTO product (PRICE, PROD_NAME, CATEGID) VALUES (100.00, 'Crayons Set', 5);
INSERT INTO product (PRICE, PROD_NAME, CATEGID) VALUES (8999.00, 'Air Conditioner', 3);
INSERT INTO product (PRICE, PROD_NAME, CATEGID) VALUES (50.00, 'Coloring Book', 5);

```

---

## API Endpoints

### Category CRUD Operations

1. **GET All Categories**
   ```
   GET http://localhost:8080/api/categories?page=0
   ```

2. **Create a New Category**
   ```
   POST http://localhost:8080/api/categories
   Body (JSON):
   {
       "categName": "Utilities"
   }
   ```

3. **GET Category by ID**
   ```
   GET http://localhost:8080/api/categories/{id}
   ```

4. **Update Category by ID**
   ```
   PUT http://localhost:8080/api/categories/{id}
   Body (JSON):
   {
       "categName": "Most Sold"
   }
   ```

5. **Delete Category by ID**
   ```
   DELETE http://localhost:8080/api/categories/{id}
   ```

### Product CRUD Operations

1. **GET All Products**
   ```
   GET http://localhost:8080/api/products?page=1
   ```

2. **Create a New Product**
   ```
   POST http://localhost:8080/api/products
   Body (JSON):
   {
       "prodName": "Jeans",
       "price": 3000,
       "category": {
           "categId": 3
       }
   }
   ```

3. **GET Product by ID**
   ```
   GET http://localhost:8080/api/products/{id}
   ```

4. **Update Product by ID**
   ```
   PUT http://localhost:8080/api/products/{id}
   Body (JSON):
   {
       "prodName": "Fan",
       "price": 2000.0,
       "category": {
           "categId": 1,
           "categName": "Electronic Devices"
       }
   }
   ```

5. **Delete Product by ID**
   ```
   DELETE http://localhost:8080/api/products/{id}
   ```

---

## Testing Instructions

### Using Postman or REST Client

1. Import the API endpoints and test each operation.
2. Use the following sample payloads:

### Pagination

- Add `?page={page_number}` to GET endpoints for paginated responses.

---

## Notes

- Ensure the database is running before starting the application.
- Use proper IDs for GET, PUT, and DELETE operations.
- Error handling is implemented for invalid requests and database constraints.

## License

This project is licensed under the MIT License.

---

## Author

**Tejas Dudhe**  
Email: [tejasdudhe12@gmail.com](mailto:tejasdudhe12@gmail.com)  
GitHub: [tejasdudhe](https://github.com/tejasdudhe)  
LinkedIn: [Tejas Dudhe](https://linkedin.com/in/tejasdudhe)

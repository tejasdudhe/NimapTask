# 🛒 Nimap Task - Product & Category CRUD (Spring Boot)

This project is a **Spring Boot REST API** that performs full CRUD operations for **Product** and **Category** entities.  
It demonstrates the use of **Hibernate**, **JPA**, and **Oracle Database**, with a **one-to-many** relationship between `Category` and `Product`.

---

## ✅ Feedback Implementation from Nimap InfoTech

As per the feedback received:

> ❗"While fetching single product details, the response should be populated with respective category details."

This has been implemented using the following field in the `Product` entity:

```java
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "categID")
@JsonIgnoreProperties("products")
private Category category;

//This maps your Product to a Category, and due to FetchType.EAGER, it ensures category is automatically fetched when you get a product.

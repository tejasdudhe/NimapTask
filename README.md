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

## ✅ Implementation Proof

The below image shows that the **Product API response** is correctly populated with **Category details** as per the requirement.

![image](https://github.com/user-attachments/assets/fbed41e2-e84c-417a-a2cf-9804888235aa)

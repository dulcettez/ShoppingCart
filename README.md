# Shopping Cart REST API

A simple RESTful web service that simulates a shopping cart using Spring Boot, Java 21, and MySQL. This project covers basic product management and shopping cart operations.

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven

---

## ⚙️ Database Configuration

- **Database name:** `ShoppingCartDB`
- **Username:** `root`
- **Password:** (leave blank)
- **JPA:** Tables auto-generated on startup
- **Tables prefix:** `firstname_lastname_` (e.g., `john_doe_product`)

---

## 📁 API Endpoints

### 🛍️ Products

| Method | Endpoint                         | Description                       |
|--------|----------------------------------|-----------------------------------|
| GET    | `/api/products`                  | List all products                 |
| GET    | `/api/products/search?keyword=x` | Search for products by keyword    |
| GET    | `/api/products/{id}`             | View product details by ID        |

---

### 🛒 Shopping Cart

| Method | Endpoint                                           | Description                        |
|--------|----------------------------------------------------|------------------------------------|
| GET    | `/api/cart/new`                                    | Generate a new cart ID (UUID)     |
| POST   | `/api/cart/{cartId}/add?productId=X&quantity=Y`    | Add a product to the cart         |
| GET    | `/api/cart/{cartId}`                               | Show cart contents                |
| GET    | `/api/cart/{cartId}/total`                         | Show total price with tax         |
| DELETE | `/api/cart/{cartId}/empty`                         | Empty the shopping cart           |

---

## 🧪 Example Data Inserted

At startup, the system auto-loads sample products such as:

- T-shirt
- Juice
- Dress
- Coffee
- Chips

You can add more via the database or extend the code.

---

## 📝 Assumptions

- No user login/authentication
- Product quantities are tracked and updated when added to cart
- Carts are identified by UUIDs and stored in the database
- Tax is applied per product and included in total cost

---

## 🚀 How to Run

1. Create the MySQL database manually:
   ```sql
   CREATE DATABASE ShoppingCartDB;

 

# ATM Backend Project

This is a simple ATM backend application built using **Spring Boot**.  
It provides basic REST APIs for ATM operations like deposit, withdrawal, and balance check.

---

## 🚀 Getting Started

### 1. Generate Project with Spring Initializr
1. Go to [Spring Initializr](https://start.spring.io/).
2. Fill in the details:
   - **Project**: Maven
   - **Language**: Java
   - **Spring Boot Version**: (latest stable, e.g., 3.x.x)
   - **Group**: com.example
   - **Artifact**: atm-backend
   - **Name**: atm-backend
   - **Packaging**: Jar
   - **Java**: 17 (or your installed version)
3. Add dependencies:
   - **Spring Web**
4. Click **Generate**, and extract the downloaded project.

---

### 2. Open in IntelliJ IDEA
1. Open IntelliJ IDEA.
2. Import the project by selecting the extracted folder.
3. Wait until Maven builds the project and dependencies are downloaded.

---

### 3. Run the Application
1. Locate the main class:  
   `src/main/java/com/example/atmbackend/AtmBackendApplication.java`
2. Right-click and select **Run 'AtmBackendApplication'**.
3. The application will start on **http://localhost:8080** by default.

---

### 4. Testing the APIs
You can use **Postman** or **curl** to test the APIs.  
For example:
- Check balance:  
  `GET http://localhost:8080/api/atm/balance`
- Deposit:  
  `POST http://localhost:8080/api/atm/deposit`
- Withdraw:  
  `POST http://localhost:8080/api/atm/withdraw`

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot**
- **Maven**
- **REST API**

---

# ATM API Endpoints  

This project simulates an **ATM machine workflow** where a user can:  
- Insert a card  
- Enter a PIN  
- Perform banking operations (Check Balance, Withdraw, Deposit)  

---

## API Endpoints  

### 1. Insert Card  
**POST** `http://localhost:8080/atm/insert-card?cardNumber=1234-5678-9012-3456`  

- Simulates inserting an ATM card.  
- Requires a **card number** as a query parameter.  
  <img width="1366" height="768" alt="Screenshot (337)" src="https://github.com/user-attachments/assets/d4ec8579-4752-4ad1-a1bd-b163160c705c" />

---

### 2. Enter PIN  
**POST** `http://localhost:8080/atm/enter-pin?pin=1234`  

- Used after inserting a card.  
- Validates the **PIN** for the given card.  
<img width="1366" height="768" alt="Screenshot (336)" src="https://github.com/user-attachments/assets/7dffd3e6-6aba-44fb-aca0-e9cbb6dbbf00" />

---

### 3. Check Balance  
**POST** `http://localhost:8080/atm/operation?operation=CHECK_BALANCE`  

- Returns the **current balance** of the account linked to the inserted card.  
 <img width="1366" height="768" alt="Screenshot (338)" src="https://github.com/user-attachments/assets/fdf2368e-804f-4eeb-97a6-df4115d633bb" />

---

### 4. Withdraw Cash  
**POST** `http://localhost:8080/atm/operation?operation=WITHDRAW_CASH&amount=570`  
- Deducts the requested **amount** from the account balance if funds are sufficient.  
  <img width="1366" height="768" alt="Screenshot (339)" src="https://github.com/user-attachments/assets/82a96eba-db3d-4fe4-800b-97836c8c0051" />

---

### 5. Deposit Cash  
**POST** `http://localhost:8080/atm/operation?operation=DEPOSIT_CASH&amount=200`  

- Adds the given **amount** to the account balance.  
 <img width="1366" height="768" alt="Screenshot (340)" src="https://github.com/user-attachments/assets/cb9404e7-12bd-4b38-8fc6-05eac9f96d94" />

---



# 🏨 Hotel Management Application
A web-based system designed to help hotel chain managers manage and assign staff across multiple hotels.

## ✨ Features

- 🧾 **Staff & Hotel Management**
  - Create, view, and update hotel staff
  - Assign staff to hotels based on performance
  - Display sorted list of staff by department

- 🔐 **Login Authentication**
  - Secure access using Spring Security

- 🌐 **Microservices Architecture**
  - Staff and Hotel services communicate via REST APIs
  - Service discovery via Eureka Server

- 📦 **Backend with JPA & MySQL**
  - Entities and repositories using Spring Data JPA
  - Custom queries and validation annotations

- 🎨 **Frontend with Spring MVC + Thymeleaf**
  - Manager-friendly UI for interaction



## ⚙️ Technologies Used

- 💻 Java  
- 🌱 Spring Boot  
- 🔐 Spring Security  
- 🧩 Spring Data JPA  
- 📚 Spring MVC (Thymeleaf)  
- 🧭 Eureka Server 
- 🗄️ MySQL  
- 🛠️ Maven  

## 🗄️ Database Structure

### 🏨 Hotel Table
| Column      | Type    | Description                                               |
|-------------|---------|-----------------------------------------------------------|
| hotel_id    | String  | Must follow pattern `Xxxx1234` (e.g., Hote1234)           |
| hotel_name  | String  | Required                                                  |
| star_rating | Integer | Must be between 1 to 5                                    |

### 👨‍💼 Staff Table
| Column            | Type    | Description                                                      |
|-------------------|---------|------------------------------------------------------------------|
| staff_id          | Long    | Auto-generated                                                   |
| staff_name        | String  | Required                                                         |
| department        | Enum    | One of: Reception, Cleaning, Management, Restaurant              |
| performance_rating| Integer | Default = 3; Between 1 to 5                                      |
| hotel_id (FK)     | String  | Foreign key reference to hotel                                   |


## 📋 Business Logic

- New staff default to **performance rating of 3**
- Staff with rating **≤ 3** can only be assigned to hotels with **≤ 3 stars**
- Staff with rating **≥ 4** can only be assigned to hotels with **≥ 4 stars**
- Staff list is sorted in the following department order:
  **Reception → Cleaning → Management → Restaurant**

## 🧑‍💻 How to Run

### ▶️ Step-by-step

1. **Run Eureka Server**  
   Start the Eureka Server module first to enable microservice discovery.

2. **Run Hotel Service**  
   Launch the hotel service to manage hotel data.

3. **Run Staff Service**  
   Start the staff service to handle staff management and assignments.

4. **Run Frontend Web App**  
   Launch the MVC + Thymeleaf frontend to interact with the system via browser.

## 📸 UI & Usage Highlights

- ✅ Login with credentials  
- ✅ View staff list, sorted by department  
- ✅ Add new staff with validations  
- ✅ Assign staff to hotels (rules enforced by performance/star rating)  
- ✅ Update staff performance rating  
- ✅ View hotel list and star ratings

## 🎥 Demo 

- 🎥 [YouTube Demo Link](https://youtu.be/aaS5V4769wA?si=z7s3SlmH3snKDltm)







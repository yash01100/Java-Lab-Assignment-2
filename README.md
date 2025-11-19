from docx import Document

doc = Document()
doc.add_heading('Online Shopping System — Java OOP Project', level=1)

content = """
Student: Yash Raj
Roll No: 2401010008
Program: B.Tech CSE Core
Faculty: Lucky Verma

Project Overview
This Java project implements a console-based Online Shopping System using:
- Object-Oriented Programming (OOP)
- Inheritance
- Polymorphism
- Collections Framework (HashMap, ArrayList)
- File Handling (Serialization)
- Menu-driven user interface

Features
- Product System: Electronics and Clothing categories
- Shopping Cart: Add, Remove, View items
- Orders: Checkout, Generate Order ID, Save History
- File Handling: Save/Load orders using serialization
- Console-based Menu System

Project Structure
ShoppingSystem.java
Product.java
Electronics.java
Clothing.java
ShoppingCart.java
CartItem.java
Order.java
orders.dat (auto-generated)
README.docx

How to Run:
1. Compile all Java files:
   javac *.java

2. Run the main system:
   java ShoppingSystem

Sample Menu:
1. Add to Cart
2. View Cart
3. Remove from Cart
4. Checkout
5. View Orders
6. Save Orders
7. Load Orders
8. Exit

OOP Concepts Used:
- Inheritance (Product → Electronics, Clothing)
- Polymorphism
- Encapsulation
- Collections
- File Handling (Serialization)

Author:
Yash Raj
Roll No: 2401010008
B.Tech CSE Core — Section D
"""

for line in content.split("\n"):
    doc.add_paragraph(line)

output_path = "/mnt/data/ShoppingSystem_README.docx"
doc.save(output_path)

output_path

# 🧮 Modular Calculator (Java Swing)

## 🚀 Project Overview

This project is a **professional modular calculator** built using **Java Swing**, designed with a clean architecture and enhanced user experience.

Unlike basic calculators, this project focuses on:

* Structured code (UI → Service → Logic separation)
* Keyboard interaction support
* Modern UI styling
* Scalable design for future upgrades (scientific functions, history, etc.)

---

## ✨ Features

### 🔢 Core Functionality

* Basic arithmetic operations:

  * Addition (+)
  * Subtraction (-)
  * Multiplication (*)
  * Division (/)
  * Modulus (%)
* Real-time calculation
* Error handling for invalid inputs

---

### 🎨 UI Features

* Modern dark theme interface
* Clean grid-based button layout
* Styled display screen
* Responsive button interactions

---

### ⌨️ Keyboard Support (Advanced Feature 🔥)

The calculator supports full keyboard input using **Key Bindings (industry-level approach)**:

| Key       | Action                |
| --------- | --------------------- |
| 0–9       | Input numbers         |
| + - * / % | Operators             |
| Enter     | Calculate result      |
| Backspace | Delete last character |
| C / Esc   | Clear display         |
| .         | Decimal input         |

---

## 🧠 Architecture (Professional Design)

The project follows a modular layered structure:

```
UI Layer (CalculatorUI.java)
        ↓
Service Layer (CalculatorService.java)
        ↓
Logic Layer (ExpressionEvaluator.java)
```

#### 📌 Explanation:

* **UI Layer** → Handles user interaction and display
* **Service Layer** → Processes input and manages logic flow
* **Logic Layer** → Performs actual calculations

---

## ⚙️ Java Version & Engine Decision (Important 🔥)

This project is built using:

👉 **JDK 23 (Latest Java Version)**

---

### ❌ Why ScriptEngine was NOT used?

Initially, the plan was to use:

```java
ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
```

However:

* The **Nashorn JavaScript Engine was removed after Java 15**
* In **JDK 23**, this returns:

```
Engine NOT available ❌
```

---

### 🚨 Problem with ScriptEngine

* Deprecated and removed in modern Java versions
* Not reliable for production systems
* Adds unnecessary dependency on external engine
* Limited control over expression parsing

---

### ✅ Final Solution (Used in this Project)

Instead of using ScriptEngine, a **custom expression evaluator** was built using:

✔ Stack-based parsing
✔ Operator precedence handling
✔ Function handling (sin, log, sqrt, etc.)
✔ Pure Java implementation

---

### 🚀 Benefits of Custom Evaluator

* ✅ Works on **any Java version (including JDK 23)**
* ✅ No deprecated APIs
* ✅ Full control over logic
* ✅ Better performance
* ✅ Scalable for scientific calculations
* ✅ Industry-level approach

---

## 🛠️ Technologies Used

| Technology    | Purpose                 |
| ------------- | ----------------------- |
| Java (JDK 23) | Core programming        |
| Java Swing    | GUI development         |
| IntelliJ IDEA | Development environment |
| Git & GitHub  | Version control         |

---

## 📂 Project Structure

```
calculator/
│
├── Main.java
├── ui/
│   └── CalculatorUI.java
├── service/
│   └── CalculatorService.java
└── utils/
    └── ExpressionEvaluator.java
```

---

## ▶️ How to Run

### 🔹 Option 1: Run via IDE

1. Open project in IntelliJ IDEA
2. Ensure **JDK 23 is selected**
3. Run `Main.java`

---

### 🔹 Option 2: Run via Terminal

```bash
javac Main.java ui/CalculatorUI.java service/CalculatorService.java utils/ExpressionEvaluator.java
java Main
```

---

## 🧪 Example Usage

### Basic Calculation

Input:

```
12 + 5 * 2
```

Output:

```
22
```

---

### Scientific Examples

```
sin(90) = 1
log(100) = 2
sqrt(16) = 4
2^3 = 8
```

---

## 🎯 Learning Objectives

This project helped in understanding:

* Java Swing GUI design
* Event handling in Java
* Clean code architecture
* Keyboard interaction using Key Bindings
* Stack-based expression evaluation
* Handling real-world Java version compatibility issues
* Building custom parsers instead of relying on deprecated APIs

---

## 🚀 Future Enhancements

Planned upgrades for next versions:

* Full scientific calculator UI (CASIO-style)
* Degree/Radian toggle UI indicator
* Calculation history panel
* Memory operations (M+, M-, MR)
* Graph plotting
* Animations and sound effects

---

## 💡 Key Highlight

> This project demonstrates how to build a **clean, scalable, and future-proof calculator application using Java 23 without relying on deprecated technologies.**

---

## 👨‍💻 Author

Developed as part of a **Java learning journey and project-based practice**.

---

## ⭐ Support

If you like this project, feel free to:

* ⭐ Star the repository
* 🔁 Share it
* 💬 Give feedback

---

## 📌 Note

✔ Built using **JDK 23**
✔ No use of deprecated ScriptEngine
✔ Fully future-proof implementation

---

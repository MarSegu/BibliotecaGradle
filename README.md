# 📚 BibliotecaGradle

<p align="center">
  <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License: MIT" />
  <img src="https://img.shields.io/badge/Java-100%25-blue" alt="Main Language" />
  <img src="https://img.shields.io/badge/status-active-brightgreen" alt="Status" />
</p>

---

## ✨ Overview

**BibliotecaGradle** is a REST API built with Spring Boot that simulates the process of borrowing books from a library. The project includes comprehensive unit tests using JUnit, and is designed to demonstrate best practices in API development, modularity, and automated testing in Java.

---

## 🎨 Tech Stack

<div align="center">

| Language / Tool                                        | Usage                                     |
|--------------------------------------------------------|-------------------------------------------|
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="24"/> Java | Main logic for API and library simulation |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="24"/> Spring Boot | RESTful API framework                    |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/gradle/gradle-original.svg" width="24"/> Gradle | Build automation and dependency management |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/junit/junit-original.svg" width="24"/> JUnit | Unit testing framework                   |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="24"/> GitHub Actions | CI/CD automation (optional)              |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" width="24"/> Docker | Containerization and deployment (optional) |

</div>

---

## 🗂️ Project Structure

```text
.
├── src/main/java/             # Main source code for the API
├── src/test/java/             # Unit tests for API logic (JUnit)
├── build.gradle               # Gradle dependencies and project config
├── Dockerfile                 # Containerization configuration (optional)
├── .github/workflows/         # CI/CD pipelines (GitHub Actions, if present)
└── README.md                  # Project documentation
```

---

## ⚡ Features

- RESTful API for library book loans: borrow, return, consult inventory
- Full CRUD operations for books and users
- Unit tests for main functionalities using JUnit
- Modular, maintainable Java code
- Optional containerization with Docker
- Optional CI/CD integration with GitHub Actions
- Well-documented for learning and experimentation

---

## 🛠️ Getting Started

> **Run the API in minutes.**

```bash
# Clone the repository
git clone https://github.com/MarSegu/BibliotecaGradle.git
cd BibliotecaGradle

# Build the project
./gradlew build

# Run the Spring Boot application
./gradlew bootRun
# or
java -jar build/libs/BibliotecaGradle-*.jar
```

---

## ⚙️ Main Configuration

| File / Variable         | Description                            | Example              |
|------------------------|----------------------------------------|----------------------|
| `application.properties`| Spring Boot configuration (DB, port)  | DB URL, server port  |
| `build.gradle`         | Gradle dependencies and plugins        | `spring-boot-starter-data-jpa`, `junit` |
| `Dockerfile`           | Containerization setup (if present)    | Build Docker image   |

---

## 🧪 Testing

> Run unit tests with JUnit.

```bash
./gradlew test
```

---

## 🚀 Deployment

- **Docker:**
  ```bash
  docker build -t biblioteca-gradle .
  docker run -p 8080:8080 biblioteca-gradle
  ```
- **CI/CD:** Automated via workflows in `.github/workflows/` (if configured).

---

## 📤 Outputs

| Output            | Description                    |
|-------------------|-------------------------------|
| `localhost:8080`  | API endpoint in development    |
| Test results      | Results from automated tests   |

---

## 🤝 Contributing

Contributions are welcome!  
Open an issue or pull request for suggestions and improvements.

---

## 📃 License

Distributed under the MIT License. See [LICENSE](LICENSE) for more details.

---

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=110&section=footer"/>
</p>

# MrBank Playwright Java Test Automation Framework

An end-to-end Web Automation Testing Framework built with **Playwright Java**, **TestNG**, **Page Object Model (POM)**, **Maven**, and **Allure Reports**.

---

## 🏗️ Project Architecture & Folder Structure

```
C:\Users\DELL\Mr.Bank Automation
├── pom.xml                                   # Maven dependencies & build plugins
├── README.md                                  # Setup & execution instructions
├── .gitignore                                 # Ignored files (target, allure-results)
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── mrbank
│   │               ├── factory                # PlaywrightFactory.java (Browser/Context/Page lifecycle)
│   │               ├── pages                  # Page Object Classes (LoginPage, DashboardPage, etc.)
│   │               └── utils                  # Helper utilities (ConfigReader, ScreenshotUtil)
│   └── test
│       ├── java
│       │   └── com
│       │       └── mrbank
│       │           ├── base                   # BaseTest.java (@BeforeMethod / @AfterMethod)
│       │           ├── listeners              # TestListener.java (Allure & failure attachments)
│       │           └── tests                  # TestNG Test Classes (LoginTest, DashboardTest, etc.)
│       └── resources
│           ├── config.properties             # Environment configuration (URL, Browser, Credentials)
│           ├── testdata                       # JSON Test data files
│           └── suites                         # testng.xml suite configuration
```

---

## 🚀 Environment Prerequisites

- **Java JDK**: 17 or higher (`JAVA_HOME` configured)
- **Maven**: 3.8+ (`MAVEN_HOME` configured in PATH)
- **Browsers**: Installed automatically by Playwright on first execution

---

## ⚙️ Running Tests

### 1. Execute All Tests via TestNG Suite
```cmd
mvn clean test
```

### 2. Run Headless / Headed via Command Line Override
```cmd
mvn clean test -Dheadless=true
```

### 3. Run a Specific Test Class
```cmd
mvn test -Dtest=LoginTest
```

---

## 📊 Allure Report Generation

### Generate and Serve Allure HTML Report:
```cmd
mvn allure:serve
```

---

## 🔑 Key Design Features

1. **Page Object Model (POM)**: Complete separation of page locators/actions from assertions and test logic.
2. **ThreadLocal Safety**: Playwright and Browser instances managed safely per thread for future parallel execution.
3. **Automatic Screenshots on Failure**: Captures full-page PNG screenshots and attaches them directly to Allure reports when a test fails.
4. **Environment Configuration**: Centralized `config.properties` supporting runtime environment variable overrides.
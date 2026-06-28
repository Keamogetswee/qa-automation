# Selenium Automation Practice Project

A structured UI test automation suite built with Selenium WebDriver, Java, TestNG, and the Page Object Model, targeting [AutomationExercise.com](https://automationexercise.com), a public e-commerce web application built for testing practice.

---

## Purpose

This project was built to develop and demonstrate practical automation engineering skills, specifically:
- Structuring a maintainable test suite using the Page Object Model
- Writing stable, reliable tests using explicit waits
- Implementing data-driven testing with external test data
- Applying real automation patterns used in professional QA engineering

---

## Project Structure

```
├── base/
│   └── BaseTest.java          # WebDriver setup and teardown shared across all tests
├── pages/
│   └── LoginPage.java         # Page Object for the login page — locators and actions
├── tests/
│   └── ui/
│       └── LoginTest.java     # Test cases for login functionality
├── utils/
│   └── JsonReader.java        # Utility to read test data from external JSON file
├── testdata/
│   └── testdata.json          # External test data — email and password combinations
└── README.md
```

---

## Key Design Decisions

### Page Object Model (POM)
Each page of the application has its own class that holds its locators and the actions that can be performed on it. Tests never interact with locators directly, they call methods on page classes. This means if a UI element changes, only the page class needs updating, not every test that uses it.

### Explicit Waits
Every element interaction uses `WebDriverWait` with `ExpectedConditions` — either `visibilityOfElementLocated` or `elementToBeClickable`, depending on what the interaction requires. No `Thread.sleep` is used anywhere. This keeps tests fast and eliminates timing-related flakiness.

### Data-Driven Testing
The invalid login test reads credentials from an external `testdata.json` file using a `@DataProvider`. This means the same test logic runs against multiple input combinations without duplicating any test code — making it easy to add new test scenarios without touching the test class.

### BaseTest
A shared `BaseTest` class handles WebDriver initialisation (`@BeforeMethod`) and teardown (`@AfterMethod`). Every test class inherits from BaseTest, ensuring each test gets a clean browser instance and the driver is properly closed after every test run.

---

## Test Coverage

| Test | Description |
|---|---|
| `openLoginPage` | Verifies the login page loads correctly and displays the expected heading |
| `invalidLoginTest` | Verifies that incorrect credentials produce the appropriate error message — runs for each set of test data |

---

## Technologies Used

| Tool | Purpose |
|---|---|
| Selenium WebDriver | Browser automation |
| Java | Programming language |
| TestNG | Test framework — annotations, assertions, data providers |
| ChromeDriver | Browser driver for Chrome |
| JSON (testdata.json) | External test data source |

---

## How to Run

1. Clone the repository
2. Ensure Java and Maven are installed
3. Run tests using your IDE (IntelliJ or Eclipse) or via Maven:
```
mvn test
```
4. TestNG will execute all tests and generate a report in the `target/surefire-reports` directory

---

## What I Learned Building This

- The practical difference between explicit and implicit waits — and why explicit waits produce more stable, trustworthy tests
- How POM makes a test suite maintainable at scale — one locator change, one place to update
- How data-driven testing with `@DataProvider` separates test logic from test data cleanly
- How `BaseTest` eliminates duplicated setup code and keeps tests focused on what they're actually testing

---

## Author

Keamogetswe Moseki — Junior QA Engineer transitioning into automation

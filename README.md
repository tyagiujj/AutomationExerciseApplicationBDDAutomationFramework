# Selenium + Cucumber + TestNG Automation Framework

A BDD-driven web automation framework built from scratch for [AutomationExercise.com](https://automationexercise.com), designed around scalability, maintainability, and real-world reliability rather than just passing a handful of demo tests.

---

## Tech stack

| Category | Tools |
|---|---|
| Language | Java 21 |
| Automation | Selenium WebDriver 4.x |
| BDD | Cucumber (Gherkin) |
| Test Runner | TestNG |
| Build Tool | Maven |
| Logging | Log4j2 |
| Reporting | Cucumber HTML + Masterthought Pie-Chart Dashboard |
| Test Data | Java Faker (DataFaker) |
| Driver Management | WebDriverManager (Bonigarcia) |

---

## Key features

- **Page Object Model (POM)** — every page has a dedicated class with its own locators and actions, keeping step definitions clean and UI changes isolated to a single file.
- **Singleton + ThreadLocal WebDriver management** — one driver instance per thread, making the framework safe for parallel execution without race conditions.
- **Config-driven execution** — URL, browser choice, credentials, and wait durations all live in `config.properties`; nothing is hardcoded.
- **Parallel execution** — Cucumber scenarios run concurrently via `@DataProvider(parallel = true)`, controlled through `testng.xml`.
- **Centralized wait strategy** — a `WaitUtils` class wraps Explicit Waits (visibility, clickability) so Page Objects never repeat wait logic.
- **Robust click handling** — `JavascriptExecutor`-based clicks bypass ad-overlay and dynamic-content click interception issues.
- **Automatic screenshot on failure** — captured via Cucumber's `Scenario` object inside `Hooks`, attached to the report and saved to disk.
- **Structured logging** — Log4j2 writes leveled, timestamped logs to both console and file.
- **Dynamic test data** — Java Faker generates realistic names, emails, addresses, and phone numbers; emails are guaranteed unique via a timestamp suffix.
- **Dual reporting** — Cucumber's built-in HTML report plus a Masterthought pie-chart dashboard generated from the Cucumber JSON output.

---

## Project structure

```
├── pom.xml
├── testng.xml
├── src/test/java/
│   ├── pageObjects/        # One class per web page
│   ├── stepDefinitions/    # Gherkin step implementations
│   ├── hooks/              # Setup, teardown, screenshot-on-failure
│   ├── runner/             # Cucumber-TestNG entry point
│   ├── listeners/          # TestNG lifecycle listener, report generation
│   └── utils/              # ConfigReader, DriverManager, WaitUtils, TestDataGenerator
├── src/test/resources/
│   ├── features/           # Gherkin .feature files
│   ├── config.properties   # Environment configuration
│   └── log4j2.xml          # Logging configuration
└── target/
    ├── cucumber-reports/   # HTML + JSON reports
    └── cucumber-pie-report/# Pie-chart dashboard report
```

---

## Design patterns and principles

- **Singleton Pattern** — `DriverManager` ensures a single, controlled WebDriver lifecycle.
- **Page Object Model** — UI structure abstracted away from test logic.
- **Observer Pattern** — `TestListener` reacts to TestNG lifecycle events.
- **Single Responsibility Principle** — each utility class does exactly one job (config reading, driver management, waiting, logging).
- **DRY** — shared logic (JS clicks, waits, common steps) centralized rather than duplicated.
- **Fail-Fast** — configuration and driver errors throw immediately with clear messages instead of failing silently downstream.

---

## Getting started

### Prerequisites
- Java 21
- Maven
- Chrome or Firefox installed

### Setup

```bash
git clone https://github.com/tyagiujjj/AutomationExerciseApplicationBDD.git
cd AutomationExerciseApplicationBDD
```

Update `src/test/resources/config.properties` with your own values:

```properties
url=http://automationexercise.com
browser=chrome
implicitWait=10
explicitWait=15
```

> Note: credential-based test cases (e.g. login) expect a pre-registered test account's email/password in this file — replace with your own before running.

### Run the tests

```bash
mvn clean test
```

Or run `testng.xml` directly from your IDE for parallel execution.

### View reports

After a run completes:
- `target/cucumber-reports/cucumber.html` — standard Cucumber report
- `target/cucumber-pie-report/cucumber-html-reports/overview-features.html` — pie-chart dashboard
- `logs/automation.log` — full execution log

---

## Test cases automated so far

- User registration (full form: personal details, address, checkboxes, account creation and deletion)
- User login with valid credentials

More scenarios from the AutomationExercise test suite are actively being added following the same Page Object + BDD pattern.

---

## Roadmap

- [ ] Data-driven testing with Cucumber Scenario Outline
- [ ] Excel/JSON-based external test data
- [ ] ExtentReports integration
- [ ] CI/CD pipeline (GitHub Actions)

---

## Author

**Ujjwal Tyagi**
QA Engineer | Automation & Manual Testing

[LinkedIn](www.linkedin.com/in/ujjwal-tyagi21) · [GitHub](https://github.com/tyagiujj)
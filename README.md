# Selenium Cucumber TestNG Automation Framework

[![Selenium Automation CI](https://github.com/tyagiujj/AutomationExerciseApplicationBDDAutomationFramework/actions/workflows/ci.yml/badge.svg)](https://github.com/tyagiujj/AutomationExerciseApplicationBDDAutomationFramework/actions/workflows/ci.yml)

A scalable BDD web automation framework built for [AutomationExercise.com](https://automationexercise.com). The project demonstrates practical test automation engineering using Selenium WebDriver, Cucumber, TestNG, Maven, Page Object Model, reporting, logging, parallel execution, and CI integration.

This framework is designed to keep test scenarios readable, page interactions reusable, and execution reliable across local and CI environments.

## Tech Stack

| Area | Tools / Libraries |
| --- | --- |
| Language | Java 21 |
| Automation | Selenium WebDriver 4 |
| BDD | Cucumber / Gherkin |
| Test Runner | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model |
| Driver Management | WebDriverManager |
| Test Data | DataFaker |
| Logging | Log4j2 |
| Reporting | Cucumber HTML, Cucumber JSON, Masterthought Cucumber Reporting |
| CI/CD | GitHub Actions |

## Key Highlights

- Page Object Model implementation for clean separation between test steps and page-level actions.
- Cucumber BDD feature files written in Given-When-Then format for better readability.
- TestNG runner with parallel scenario execution using `@DataProvider(parallel = true)`.
- Thread-safe WebDriver handling through `ThreadLocal`.
- Config-driven execution using `config.properties` for browser, URL, credentials, and wait settings.
- Centralized explicit wait utility for reusable synchronization.
- Automatic browser driver setup through WebDriverManager.
- Dynamic test data generation using DataFaker.
- Screenshot capture on scenario failure, attached to Cucumber reports and saved locally.
- Structured Log4j2 logging for console and file-based execution logs.
- HTML and dashboard-style reporting generated after every test run.
- GitHub Actions workflow for automated CI execution on push and pull request events.

## Project Structure

```text
.
+-- .github/workflows/
|   +-- ci.yml
+-- pom.xml
+-- testng.xml
+-- src/test/java/
|   +-- hooks/
|   |   +-- Hooks.java
|   +-- listeners/
|   |   +-- TestListener.java
|   +-- pageObjects/
|   |   +-- ContactUsFormPage.java
|   |   +-- HomePage.java
|   |   +-- LoginPage.java
|   |   +-- ProductPage.java
|   |   +-- RegistrationPage.java
|   +-- runner/
|   |   +-- TestRunner.java
|   +-- stepDefinitions/
|   |   +-- Step definition classes
|   +-- utils/
|       +-- ConfigReader.java
|       +-- DriverManager.java
|       +-- TestDataGenerator.java
|       +-- WaitUtils.java
+-- src/test/resources/
    +-- config.properties
    +-- features/
    |   +-- Cucumber feature files
    +-- log4j2.xml
```

## Automated Test Coverage

The framework currently covers the following AutomationExercise workflows:

- User registration with dynamic test data
- Login with valid credentials
- Login with invalid credentials
- User logout
- Registration attempt with an existing email address
- Contact Us form submission
- Test Cases page verification
- Negative login validation
- Products page and product detail page verification
- Product search functionality

## Framework Design

### Page Object Model

Each page has a dedicated class inside `pageObjects`. Locators and page actions are maintained in one place, making tests easier to read and reducing maintenance when UI changes occur.

### BDD With Cucumber

Feature files are stored under `src/test/resources/features`. Step definitions map business-readable Gherkin steps to Java automation logic.

### Driver Management

`DriverManager` creates browser instances using WebDriverManager and stores them in `ThreadLocal`, which supports parallel execution safely. Chrome and Firefox are supported through the browser value in `config.properties`.

### Hooks

`Hooks` manages setup and teardown before and after each scenario. On failure, it captures screenshots, attaches them to the Cucumber report, and saves them in the `screenshots` directory.

### Reporting

The framework generates:

- Cucumber HTML report
- Cucumber JSON report
- Masterthought dashboard report with visual execution summary
- Log4j2 execution logs

## CI/CD

GitHub Actions runs the automation suite automatically on:

- Push to `main`
- Pull request to `main`

The CI workflow:

1. Checks out the repository.
2. Sets up JDK 21.
3. Sets up Chrome.
4. Runs `mvn clean test`.
5. Uploads Cucumber and dashboard reports as workflow artifacts.

In CI, the browser runs in headless mode automatically using the `CI` environment variable check inside `DriverManager`.

## Getting Started

### Prerequisites

- Java 21
- Maven
- Chrome or Firefox
- Git

### Clone The Repository

```bash
git clone https://github.com/tyagiujj/AutomationExerciseApplicationBDDAutomationFramework.git
cd AutomationExerciseApplicationBDDAutomationFramework
```

### Configure Test Execution

Update `src/test/resources/config.properties` as needed:

```properties
url=http://automationexercise.com
browser=chrome
loginemail=your-email@example.com
loginpassword=your-password
implicitWait=10
explicitWait=15
```

Use a valid registered account for login-based scenarios.

### Run Tests

```bash
mvn clean test
```

You can also run `testng.xml` directly from an IDE such as IntelliJ IDEA or Eclipse.

## Reports And Logs

After execution, reports and logs are available at:

| Output | Path |
| --- | --- |
| Cucumber HTML Report | `target/cucumber-reports/cucumber.html` |
| Cucumber JSON Report | `target/cucumber-reports/cucumber.json` |
| Dashboard Report | `target/cucumber-pie-report/cucumber-html-reports/overview-features.html` |
| Execution Logs | `logs/automation.log` |
| Failure Screenshots | `screenshots/` |

CI reports are also available from the GitHub Actions run artifacts.

## Maven Dependencies

Major dependencies used in this project:

- Selenium Java
- TestNG
- Cucumber Java
- Cucumber TestNG
- WebDriverManager
- DataFaker
- Apache Commons IO
- Log4j2
- Masterthought Cucumber Reporting

## Future Enhancements

- Add more AutomationExercise end-to-end scenarios.
- Add data-driven execution using Cucumber Scenario Outline.
- Support external JSON or Excel-based test data.
- Add retry logic for flaky UI interactions.
- Add tag-based execution profiles for smoke, regression, and sanity suites.
- Strengthen CI with branch protection and required checks.

## Author

**Ujjwal Tyagi**  
QA Engineer | Automation Testing | Manual Testing

[LinkedIn](https://www.linkedin.com/in/ujjwal-tyagi21) | [GitHub](https://github.com/tyagiujj)

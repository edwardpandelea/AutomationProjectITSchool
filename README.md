### AutomationProjectITSchool — UI Test Automation (Selenium + Cucumber + JUnit 5)

A Java-based UI test automation project for SauceDemo (https://www.saucedemo.com/) using Selenium WebDriver, Cucumber (Gherkin), and JUnit 5, organized with the Page Object Model.

---

### Highlights
- Java 21, Maven, JUnit 5 (JUnit Platform)
- Cucumber 7 (BDD with Gherkin features)
- Selenium 4 with WebDriverManager (auto driver setup)
- Page Object Model: `pages` + small `utils` helpers
- Chrome runs in incognito, window maximized
- Sample flows: Login, Product sorting, Cart, Checkout, and basic UI checks

---

### Project Structure
```
AutomationProjectITSchool
├─ pom.xml
├─ src
│  └─ test
│     ├─ java
│     │  ├─ hooks
│     │  │  └─ hooks.java                 # WebDriver setup/teardown (@Before/@After)
│     │  ├─ pages                         # Page Objects
│     │  │  ├─ loginPage.java
│     │  │  ├─ homePage.java
│     │  │  ├─ productPage.java
│     │  │  ├─ cartPage.java
│     │  │  └─ checkoutPage.java
│     │  ├─ steps                         # Step Definitions
│     │  │  ├─ LoginSteps.java
│     │  │  ├─ SortSteps.java
│     │  │  ├─ CartSteps.java
│     │  │  ├─ CheckoutSteps.java
│     │  │  └─ UISteps.java
│     │  └─ runner
│     │     └─ RunCucumberTest.java       # JUnit Platform runner
│     └─ resources
│        └─ features                      # Gherkin Feature files
│           ├─ Login.feature
│           ├─ Sort.feature
│           ├─ Cart.feature
│           ├─ Checkout.feature
│           └─ UI.feature
└─ target
   └─ surefire-reports                    # JUnit/Cucumber XML outputs
```

---

### Tech Stack and Key Versions
- Java: `21`
- Maven Surefire Plugin: `3.2.5`
- Cucumber: `7.16.1` (`cucumber-java`, `cucumber-junit-platform-engine`)
- Selenium: `4.22.0`
- WebDriverManager: `6.3.2`
- JUnit 5: `5.10.2` (and `junit-platform-suite 1.10.2`)

See `pom.xml` for the full list and versions.

---

### Prerequisites
- Java JDK 21 installed and on `PATH`
- Maven 3.9+ installed and on `PATH`
- Google Chrome installed
- Internet access (tests run against the live SauceDemo site)

---

### How It Works
- `hooks.hooks` creates a ChromeDriver via WebDriverManager, sets timeouts, maximizes window, and navigates to SauceDemo.
- It performs an initial login with `standard_user` / `secret_sauce` in the `@Before` hook so most scenarios start authenticated.
- Page Objects in `pages` encapsulate locators and actions.
- Gherkin features under `src\test\resources\features` describe behavior; step definitions under `src\test\java\steps` implement them.
- JUnit Platform runs Cucumber via `RunCucumberTest`.

---

### Running the Tests
From the project root:
```
mvn test
```
Run a specific tag (example: only login scenarios):
```
mvn test -Dcucumber.filter.tags="@Login"
```
Run multiple tags with OR:
```
mvn test -Dcucumber.filter.tags="@Login or @CheckoutFlow"
```
Run with AND:
```
mvn test -Dcucumber.filter.tags="@CheckoutFlow and not @CancelCheckoutFlow"
```

Run from IDE:
- Open `RunCucumberTest.java` and run the JUnit suite.

---

### Reports and Outputs
- JUnit/Surefire XML: `target/surefire-reports/`
- Cucumber JUnit XML: `target/cucumber-junit.xml`
- Cucumber HTML report: `target/cucumber-report.html`

Note: The plugin configuration in `RunCucumberTest.java` currently has a small typo (`traget` instead of `target`) in the HTML report path. Update it to ensure the HTML report is generated under `target/`:
```
@ConfigurationParameter(
  key = PLUGIN_PROPERTY_NAME,
  value = "pretty, html:target/cucumber-report.html, junit:target/cucumber-junit.xml"
)
```

---

### Available Scenarios (examples)
- `Login.feature`
  - `@Login` Valid login
  - `@InvalidLogin` Invalid credentials show error
  - `@Logout` Logout from the home page
- `Sort.feature`
  - `@AZSort`, `@ZASort`, `@LowToHighPrice`, `@HighToLowPrice` verify sort options
- `Cart.feature`
  - `@NoProduct` Prevent checkout with empty cart
  - `@ExitCart` Continue shopping navigates home
  - `@CartNumberUpdate` Cart badge increments
  - `@AddProductToCart` Add specific product to cart
  - `@RemoveProductFromCart` Remove product from cart
- `Checkout.feature`
  - `@CheckoutFlow` Complete purchase flow
  - `@CheckoutFlowNoDetails` Validation on missing info
  - `@CancelCheckoutFlow` Cancel returns to cart
- `UI.feature`
  - `@ProductPage` Product details visible
  - `@CartPage` Cart shows quantities, descriptions, prices, titles

---


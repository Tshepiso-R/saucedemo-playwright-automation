# SauceDemo Playwright Automation

[![Playwright Tests](https://github.com/Tshepiso-R/saucedemo-playwright-automation/actions/workflows/playwright-tests.yml/badge.svg)](https://github.com/Tshepiso-R/saucedemo-playwright-automation/actions/workflows/playwright-tests.yml)

Automated testing framework for SauceDemo e-commerce application using Playwright, Java, and TestNG.

## Technology Stack

- **Automation Framework**: Playwright 1.40.0
- **Programming Language**: Java 11
- **Testing Framework**: TestNG 7.8.0
- **Build Tool**: Gradle
- **Design Pattern**: Page Object Model

## Supported Platforms

This framework runs on:
- **Windows** (Windows 10/11)
- **macOS** (Intel and Apple Silicon)
- **Linux** (Ubuntu, Debian, Fedora, etc.)

## Project Structure
```
src/
+-- main/java/com/sdet/
¦   +-- pages/              # Page Object classes
¦   ¦   +-- BasePage.java
¦   ¦   +-- LoginPage.java
¦   ¦   +-- ProductsPage.java
¦   ¦   +-- CartPage.java
¦   ¦   +-- CheckoutPage.java
¦   +-- utils/              # Utility classes
¦       +-- TestDataReader.java
¦
+-- test/
    +-- java/com/sdet/tests/  # Test classes
    ¦   +-- BaseTest.java
    ¦   +-- SauceDemoSmokeTests.java
    +-- resources/
        +-- testdata.properties  # Test data
        +-- smoke-tests.xml
        +-- testng.xml
```

## Features

- Page Object Model design pattern
- External test data management (Properties file)
- Cross-browser support (Chromium, Firefox, WebKit)
- Cross-platform support (Windows, macOS, Linux)
- Automated test reports (HTML)
- Reusable utility classes
- Clean code structure
- GitHub Actions CI/CD integration

## Prerequisites

Before you start, make sure you have:
- **Java 11 or higher** installed
  - Windows: Check with `java -version` in PowerShell or CMD
  - Mac/Linux: Check with `java -version` in Terminal
- **Internet connection** (to download dependencies and browsers)

Don't worry about installing Gradle - the project includes a Gradle wrapper that works on all platforms!

## Getting Started

### 1. Clone the Repository

**Windows (PowerShell or CMD):**
```bash
git clone https://github.com/Tshepiso-R/saucedemo-playwright-automation.git
cd saucedemo-playwright-automation
```

**Mac/Linux (Terminal):**
```bash
git clone https://github.com/Tshepiso-R/saucedemo-playwright-automation.git
cd saucedemo-playwright-automation
```

### 2. Build the Project

This will download all dependencies and Playwright browsers automatically.

**Windows:**
```bash
.\gradlew.bat clean build
```

**Mac/Linux:**
```bash
./gradlew clean build
```

**Note for Mac/Linux users:** If you get a "Permission denied" error, make the script executable first:
```bash
chmod +x gradlew
./gradlew clean build
```

**What happens during build?**
- Gradle downloads Playwright and TestNG
- Playwright downloads browser binaries for your platform
- All dependencies are cached for future runs
- Your code gets compiled

*First run takes 2-3 minutes. Subsequent runs are much faster!*

## Running the Tests

### Run All Tests

**Windows:**
```bash
.\gradlew.bat clean test
```

**Mac/Linux:**
```bash
./gradlew clean test
```

**Expected output:**
```
> Task :test
SauceDemo Test Suite > All Tests > testSuccessfulLogin PASSED
SauceDemo Test Suite > All Tests > testProductsDisplayed PASSED
SauceDemo Test Suite > All Tests > testAddProductToCart PASSED
SauceDemo Test Suite > All Tests > testCompleteCheckout PASSED

BUILD SUCCESSFUL in 18s
```

### Run in IDE (All Platforms)

**Eclipse:**
1. Import the project as a Gradle project
2. Navigate to `src/test/java/com/sdet/tests/SauceDemoSmokeTests.java`
3. Right-click and select **Run As > TestNG Test**

**IntelliJ IDEA:**
1. Open the project
2. Navigate to `src/test/java/com/sdet/tests/SauceDemoSmokeTests.java`
3. Right-click and select **Run 'SauceDemoSmokeTests'**

**VS Code:**
1. Install Java Extension Pack and TestNG extension
2. Open the project folder
3. Click "Run Test" above the test method

## Viewing Test Results

After running tests, you'll get a detailed HTML report.

**Report location:**
```
build/reports/tests/test/index.html
```

**Open the report:**

**Windows:**
```bash
start build\reports\tests\test\index.html
```

**Mac:**
```bash
open build/reports/tests/test/index.html
```

**Linux:**
```bash
xdg-open build/reports/tests/test/index.html
# or
firefox build/reports/tests/test/index.html
```

The report shows:
- Which tests passed or failed
- Execution time for each test
- Overall test statistics
- Detailed test descriptions

## Cross-Browser Testing

This framework supports running tests on multiple browsers. By default, tests run on Chromium.

### Available Browsers

- **Chromium** (default) - Chrome/Edge engine
- **Firefox** - Mozilla Firefox engine  
- **WebKit** - Safari engine

### Running Tests on Different Browsers

**Chromium (default):**
```bash
# Windows
.\gradlew.bat clean test

# Mac/Linux
./gradlew clean test
```

**Firefox:**
```bash
# Windows
.\gradlew.bat clean test -Dbrowser=firefox

# Mac/Linux
./gradlew clean test -Dbrowser=firefox
```

**WebKit:**
```bash
# Windows
.\gradlew.bat clean test -Dbrowser=webkit

# Mac/Linux
./gradlew clean test -Dbrowser=webkit
```

### Headless vs Headed Mode

By default, tests run in headless mode (no visible browser). The browser configuration is in `BaseTest.java`:
```java
.setHeadless(true)  // Change to false to see the browser
```

## Test Coverage

### Smoke Tests (4 test cases)

These tests cover the critical user journey through the SauceDemo app:

1. **testSuccessfulLogin** 
   - Verifies users can login with valid credentials
   - Checks that the products page loads correctly

2. **testProductsDisplayed** 
   - Confirms 6 products are shown on the inventory page
   - Validates product catalog is working

3. **testAddProductToCart** 
   - Tests adding a product to the shopping cart
   - Verifies cart badge updates to show "1"

4. **testCompleteCheckout** 
   - Full end-to-end checkout flow
   - Adds product, goes to cart, enters checkout info, completes order
   - Validates success message appears

## Test Data Management

All test data is stored separately in `src/test/resources/testdata.properties`, making it easy to update without touching the code.

**What's in there:**
- Valid user credentials (for successful login)
- Invalid user credentials (for negative testing)
- Locked user credentials (for error handling)
- Checkout information (name, address, etc.)

**Example:**
```properties
valid.username=standard_user
valid.password=secret_sauce
checkout.firstname=John
checkout.lastname=Doe
```

## System Under Test

**Application**: SauceDemo E-commerce Site  
**URL**: https://www.saucedemo.com/v1/

**Test Account:**
- Username: `standard_user`
- Password: `secret_sauce`

## Expected Test Results

When everything is working correctly, you should see:
```
BUILD SUCCESSFUL

Total tests: 4
Passed: 4
Failed: 0
Skipped: 0

Execution time: approximately 15-20 seconds
```

## Troubleshooting

### All Platforms

**Problem**: `java: command not found`  
**Solution**: Install Java 11 or higher from [Adoptium](https://adoptium.net/)

**Problem**: Tests fail with timeout errors  
**Solution**: Check your internet connection. Playwright needs to reach https://www.saucedemo.com

**Problem**: Browsers not found  
**Solution**: Run the build command again to download Playwright browsers

### Mac/Linux Specific

**Problem**: `Permission denied` when running `./gradlew`  
**Solution**: Make the wrapper executable:
```bash
chmod +x gradlew
```

### Windows Specific

**Problem**: PowerShell execution policy blocks scripts  
**Solution**: Use CMD instead, or update PowerShell policy:
```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

**Problem**: `.\gradlew.bat` not recognized  
**Solution**: Make sure you're in the project directory and use the full command with `.\`

## Browser Support

Playwright automatically downloads and manages browser binaries for:
- **Chromium** (default for tests)
- **Firefox**
- **WebKit** (Safari engine)

Browser binaries are platform-specific and stored in:
- **Windows**: `%USERPROFILE%\AppData\Local\ms-playwright`
- **Mac**: `~/Library/Caches/ms-playwright`
- **Linux**: `~/.cache/ms-playwright`

## Design Patterns & Best Practices

### Page Object Model (POM)
Instead of writing selectors directly in tests, we create a class for each page:
- **LoginPage** handles all login-related actions
- **ProductsPage** handles product browsing and cart actions
- **CartPage** handles shopping cart operations
- **CheckoutPage** handles the checkout flow

This makes tests easier to read and maintain.

### Test Data Separation
Test data lives in properties files, not in the code. Want to test with different users? Just update the properties file.

### Reusable Base Classes
- **BasePage** provides common methods all pages can use
- **BaseTest** handles browser setup and teardown automatically

## Continuous Integration

This project uses GitHub Actions for automated testing.

### What Runs Automatically

Every time you push code or create a pull request:
- Tests run on **3 browsers**: Chromium, Firefox, and WebKit
- Tests run on **Ubuntu Linux** (GitHub's free runner)
- Test reports are generated and saved as artifacts
- Build status is shown with a badge at the top of this README

### View Test Results

1. Go to the **Actions** tab in GitHub
2. Click on the latest workflow run
3. See test results for each browser
4. Download detailed HTML reports from artifacts

### Manual Trigger

You can also run tests manually:
1. Go to **Actions** tab
2. Click **Playwright Tests** workflow
3. Click **Run workflow**
4. Select branch and click **Run workflow**

### CI/CD Configuration

The workflow is defined in `.github/workflows/playwright-tests.yml`

**What it does:**
- Checks out your code
- Sets up Java 11
- Caches Gradle dependencies
- Builds the project
- Runs tests on all 3 browsers in parallel
- Uploads test reports

## CI/CD Integration

This framework works with continuous integration tools on any platform:
- **Jenkins** - Add a build step: `./gradlew clean test` (or `.\gradlew.bat clean test` on Windows)
- **GitHub Actions** - Already configured! See `.github/workflows/playwright-tests.yml`
- **GitLab CI** - Configure `.gitlab-ci.yml` for any platform
- **Azure DevOps** - Add Gradle task, supports all platforms

## Questions or Issues?

Found a bug or have suggestions? Feel free to open an issue on GitHub.

## Author

**Promise Raganya**  
SDET Assessment - 2025

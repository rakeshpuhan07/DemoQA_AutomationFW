DemoQA Automation Framework

OVERVIEW
========

This project is a Selenium Test Automation Framework built using:
- Java 11
- Selenium WebDriver 4
- TestNG
- Maven
- Page Object Model (POM)
- PageFactory
- Apache POI (Excel Data Provider)
- Extent Reports

The framework automates multiple functionalities available on DemoQA.

FEATURES COVERED
================

1. Form Automation
- First Name
- Last Name
- Email
- Mobile Number
- Gender Selection
- Hobbies Selection
- File Upload
- Form Submission
- Success Message Validation

2. File Upload & Download
- Upload using sendKeys()
- Download verification using File.exists()

3. Button Actions
- Double Click
- Right Click
- Dynamic Click

4. Checkbox Automation
- Expand All
- Parent Checkbox Selection
- Child Checkbox Selection
- Result Validation

5. Data Driven Testing
- TestNG DataProvider
- Apache POI
- Excel based test execution

FRAMEWORK ARCHITECTURE
======================

src/main/java
 - PageObjects
 - Utils
 - reports

src/test/java
 - tests
 - listeners
 - Base

src/test/resources
 - TestData.xlsx
 - UploadFiles

DESIGN PATTERNS
===============

Page Object Model (POM)
- Reusable page methods
- Better maintainability
- Separation of test logic and locators

RUNNING THE FRAMEWORK
=====================

Prerequisites:
- Java 11+
- Maven
- Edge/Chrome/Firefox Browser

Execute:

mvn clean test

or

mvn clean install

TEST DATA
=========

Location:

src/test/resources/TestData.xlsx

FILE UPLOADS
============

Store files in:

src/test/resources/UploadFiles

AI USAGE DECLARATION
====================

This project was developed using a combination of personal implementation and AI-assisted guidance.

Areas Where AI Was Used
-----------------------
- Framework design suggestions
- Selenium best practices guidance
- Sample Page Object generation
- Extent Report integration examples
- TestNG Data Provider examples
- Maven troubleshooting guidance
- Documentation assistance

Areas Implemented Manually
--------------------------
- Project setup and folder structure
- Maven configuration
- Package organization
- Browser configuration handling
- Excel test data creation
- Selenium locator validation
- Framework debugging
- Driver troubleshooting
- File upload path handling
- Test execution troubleshooting
- Error resolution and integration testing

FUTURE ENHANCEMENTS
===================
- Alerts
- Frames
- Windows Handling
- Web Tables
- Date Picker
- Drag and Drop
- Auto Complete
- Jenkins Integration
- Azure DevOps Integration

AUTHOR
======
Rakesh Ranjan Puhan

Automation Framework created for learning, demonstration, and practical implementation of Selenium Automation concepts using Java, TestNG, and Page Object Model architecture.

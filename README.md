<p align="center">
  <img alt="Selenium" src="https://qaautomationexpert.files.wordpress.com/2021/05/image-103.png?w=615">
</p>


[![Java Version](https://img.shields.io/badge/Java-8%2B-blue.svg)](https://www.java.com)
[![Gradle Version](https://img.shields.io/badge/gradle-8.1.1-green)](https://gradle.org/releases/)
[![Cucumber Version](https://img.shields.io/badge/cucumber-7.12.0-yellowgreen)](https://cucumber.io/docs/cucumber/)
[![RestAssured](https://img.shields.io/badge/RestAssured-5.3.0-green.svg)](https://rest-assured.io/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


# What is restassured-cucumber-project ?

This is a sample project that uses the RestAssured library to perform API testing in Java/Groovy with Cucumber and Gradle as build tool. RestAssured is a high-level Java API testing library that simplifies and speeds up the process of integration and functionality testing of APIs.

## 📋 Prerequisites

Before running this project, make sure you have the following installed in your development environment:

* Java JDK 8 or above.
* Gradle for dependency management.

## ⚙️ Project Setup 

Follow these steps to set up and run the project on your local machine:

1. Clone this repository to your local machine using the following command:
```sh
git clone https://github.com/aramirez5/restassured-cucumber-project.git
```
2. Navigate to the project's root directory:
```sh
cd restassured-cucumber-project
```
3. Make sure you have all the project dependencies downloaded and updated by running the following command:
```sh
gradle clean install
```
4. Once all the dependencies have been downloaded and the project has been successfully built, you can execute the API & TestNG teststests using the following command:
```sh
gradle test
```
5. Otherwise, you can execute the API & Cucumber tests using the following command:
```sh
gradle testsCucumber -Dcucumber.options="--tags @Brave"
```
This will run all the defined test cases in the project and display the results in the console.

## 📁 Project Structure 

The project follows a standard folder structure for Maven projects. Here's a quick overview of the structure and its purpose:

* src/main/java: Contains the project's source code classes.
* src/test/java: Contains the automated test classes.
* src/test/resources: Contains the configuration files and resource files required for the tests.

## 👥 Contribution 
If you would like to contribute to this project, feel free to open an issue or submit a pull request. Suggestions and improvements for the project are also appreciated.

## 📄 License 
This project is distributed under the MIT License. You can find more details in the LICENSE file.
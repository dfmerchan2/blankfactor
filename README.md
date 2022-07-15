# Automation of BlankFactor platform

* Automation of the scenario of subscription to blogs and generation of blog registered

## Tech Challenge Specifications

Next step of the assignment is to automate some parts of our website and send us the code as a .zip or .rar file.

1. Navigate to [blankfactor](http://blankfactor.com)
2. Open the “Blog” section
3. Scroll down to - “Why Fintech in Latin America Is Having a Boom” and click the post by Sofia Gonzalez
4. Make validation (that the script is on the correct page, by verifying the URL, and some of the text on the page)
5. Subscribe to the newsletter using the subscribe form
6. Go back to the Blog section and print a list of all post titles with related links.

## Tools implemented

* **Serenity BDD:** Is an open source library, Serenity BDD helps you write cleaner and more maintainable automated
  acceptance and regression tests faster.
* **Selenium:** Is a free (open-source) automated testing framework used to validate web applications across different
  browsers and platforms.
* **Cucumber:** is a testing tool that supports Behavior Driven Development (BDD). It offers a way to write tests that
  anybody can understand, regardless of their technical knowledge.
* **Junit:** JUnit is a unit testing open-source framework for the Java programming language

## Pattern design

* **Screenplay:** Is a design pattern to help write better tests, that can help you write more readable and maintainable
  tests, It is typically used for Acceptance or integration tests for complex systems such as Web application or Rest
  APIs.

## Programming language

* **Java:** Is a general-purpose, class-based, object-oriented programming language designed for having lesser
  implementation dependencies.

## Dependency manager

* **Gradle:** Is an open-source build automation tool that is designed to be flexible enough to build almost any type of
  software.

## Installation

* Have the [JDK](https://www.oracle.com/co/java/technologies/javase/javase8-archive-downloads.html) Java Development Kit
  at least version 1.8
* Have [GRADLE](https://gradle.org/releases/) configured for project build.
* Given that the automation runs in different browsers, it is required to have
  installed [Chrome](https://www.google.com/intl/es/chrome/), [Firefox](https://www.mozilla.org/es-ES/firefox/new/)
  , [Edge](https://www.microsoft.com/es-es/edge)

## Build and Run

* You can Run the **_"BlogRunner"_** class in's location in **_(co/com/blankfactor/runners/BlogRunner.class)_** or execute the command by console **_"gradle clean test aggregate -i"_**  to run the automation
* When the execution is finished enter the **_"target/site/serenity"_** folder and open the file **_index.html_** for to look the report of Serenity

## Author

* Diego Fernando Merchan Jimenez
    
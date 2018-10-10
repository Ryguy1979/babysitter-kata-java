# babysitter-kata-java

This kata simulates a babysitter working and getting paid for one night. The rules are pretty straight forward.

The babysitter:

    starts no earlier than 5:00PM
    leaves no later than 4:00AM
    gets paid $12/hour from start-time to bedtime
    gets paid $8/hour from bedtime to midnight
    gets paid $16/hour from midnight to end of job
    gets paid for full hours (no fractional hours)


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to run the program and how to install them:


[Java 8 JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Apache Maven](https://maven.apache.org/install.html)

[Git](https://git-scm.com/downloads)


### Installing

First ensure you follow the `Prerequisites` section above.

Then, open a command prompt to where you desire this kata to create its directory and paste the following within:

```
git clone https://github.com/Ryguy1979/babysitter-kata-java.git
```

Now, navigate to the directory just created by the above clone operation and type the following:

```
mvn test
```

Providing everything has been installed and cloned correctly, you should see output similar to this:

[Build output example](https://github.com/Ryguy1979/babysitter-kata-java/blob/master/readme-example.PNG)

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

The above `mvn test` command ran the automated tests for this project.

An example of what these test:

```
boolean validation checks on these scenarios:
    babysitter
        starts no earlier than 5:00PM
        leaves no later than 4:00AM
```

```
Equal assertion checks for these calculated scenarios:
    babysitter
        gets paid $12/hour from start-time to bedtime
        gets paid $8/hour from bedtime to midnight
        gets paid $16/hour from midnight to end of job
        gets paid for full hours (no fractional hours)
```

## Built With

* [IntelliJ](https://www.jetbrains.com/idea/) - The IDE used
* [Maven](https://maven.apache.org/) - Dependency and Build Management
* [JUnit5](https://junit.org/junit5/) - Testing Framework

## Authors

* **Rylan Van Wyk**

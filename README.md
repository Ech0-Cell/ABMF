# ABMF Project

ABMF gets information from Kafka and updates user's balance according to that. This project includes various functionalities such as handling Oracle databases, logging, and user management.

## Getting Started

### Dependencies

* Java
* Maven
* Oracle Database
* Kafka

### Installing

* Clone the repository
* Navigate to the project directory
* Run `mvn install` to install the dependencies

### Update User Balance

```
int userID = 0;
double newBalance = 1000;
OracleHandler oracleHandler = OracleHandler.getInstance();
oracleHandler.updateBalance(userID, newBalance);
```

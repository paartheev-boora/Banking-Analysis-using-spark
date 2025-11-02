# 🏦 Banking Analysis using Apache Spark

This project performs **real-time banking data analysis** using **Apache Spark Streaming**.
It analyzes customer demographics, account balance, and marketing campaign outcomes to derive insights such as success rates, customer quality, and demographic influence on subscription behavior.

## Table of Contents
- About the Project
- Features
- Technologies Used
- Project Structure
- Installation & Setup
- Running the Project
- Sample Queries
- Results
- Requirements
- Contributors
- License

## About the Project
The **Banking Analysis Project** uses Spark Structured Streaming to analyze marketing campaign data from a bank.

## Features
- Real-time CSV data ingestion via Spark Streaming
- Computation of marketing success and failure rates
- Demographic and balance analysis
- SQL-style query execution using Spark
- Console output for live analytical results

## Technologies Used
- Apache Spark 3.x
- Scala / Java 8+
- Hadoop / HDP (optional)
- Maven (for Java builds)

## Installation
https://medium.com/@dhirajmishra57/installing-spark-3-5-on-windows-e9bd183f84b9
Refer to the instructions for installing and configuring Spark in the documentation above.


## Running
### Scala
```
spark-shell -i project.scala
finalProject.main(Array("file:///user/maria_dev/finalProject/Bank.txt"))
```
### Java
```
spark-submit --class "com.example.bank.BankApplication" --master local ./target/data.jar
```

## Dataset
Use the **Bank Marketing Dataset** from [UCI Repository](https://archive.ics.uci.edu/ml/datasets/bank+marketing).

## License
Open-source under MIT License.

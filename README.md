# 🏦 Banking Analysis using Apache Spark

This project performs **real-time banking data analysis** using **Apache Spark Streaming**.
It analyzes customer demographics, account balance, and marketing campaign outcomes to derive insights such as success rates, customer quality, and demographic influence on subscription behavior.

## Table of Contents
- About the Project
- Features
- Technologies Used
- Installation & Setup
- Running the Project
- Queries
- Results
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
- https://medium.com/@dhirajmishra57/installing-spark-3-5-on-windows-e9bd183f84b9
- Refer to the instructions for installing and configuring Spark in the documentation above.


## Running
### Scala
```
spark-shell -i project.scala
finalProject.main(Array("file:///user/maria_dev/finalProject/Bank.txt"))
```
## Queries

| Analysis Goal          | Spark SQL Query                                                                         |
| ---------------------- | --------------------------------------------------------------------------------------- |
| Marketing Success Rate | `SELECT count(CASE y WHEN 'yes' THEN 1 END)/count(*)*100 AS success_rate FROM bankdata` |
| Marketing Failure Rate | `SELECT count(CASE y WHEN 'no' THEN 1 END)/count(*)*100 AS failure_rate FROM bankdata`  |
| Age Statistics         | `SELECT max(age), min(age), avg(age) FROM bankdata`                                     |
| Customer Quality       | `SELECT percentile_approx(balance, 0.5), avg(balance) FROM bankdata`                    |
| Age vs Subscription    | `SELECT age, y FROM bankdata GROUP BY age, y`                                           |
| Marital Status Impact  | `SELECT marital, y FROM bankdata GROUP BY marital, y`                                   |
| Combined Effect        | `SELECT age, marital, y FROM bankdata GROUP BY age, marital, y`                         |


## Results
#### Success and failure rates displayed in real-time console output
#### Aggregate insights such as:
- Average customer balance
- Median balance
- Impact of demographics on deposit subscription

## Contributors
- Mashir Nizami
- Anam Tamboli
- Piyush Bodhani
- Vrishali More
- Partheev Boora

## Dataset
Use the **Bank Marketing Dataset** from [UCI Repository](https://archive.ics.uci.edu/ml/datasets/bank+marketing).

## License
Open-source under MIT License.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.functions._

object finalProject {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Banking Analysis Project")
      .master("local[*]")
      .getOrCreate()

    val schema = StructType(List(
      StructField("age", IntegerType, true),
      StructField("job", StringType, true),
      StructField("marital", StringType, true),
      StructField("education", StringType, true),
      StructField("default", StringType, true),
      StructField("balance", IntegerType, true),
      StructField("housing", StringType, true),
      StructField("loan", StringType, true),
      StructField("contact", StringType, true),
      StructField("day", IntegerType, true),
      StructField("month", StringType, true),
      StructField("duration", IntegerType, true),
      StructField("campaign", IntegerType, true),
      StructField("pdays", IntegerType, true),
      StructField("previous", IntegerType, true),
      StructField("poutcome", StringType, true),
      StructField("y", StringType, true)
    ))

    val df = spark.readStream
      .schema(schema)
      .option("delimiter", ";")
      .csv("/user/maria_dev/finalProject/*")

    df.createOrReplaceTempView("bankdata")

    val queries = Seq(
      ("Marketing Success Rate", "SELECT count(CASE y WHEN 'yes' THEN 1 END)/count(*)*100 AS success_rate FROM bankdata"),
      ("Marketing Failure Rate", "SELECT count(CASE y WHEN 'no' THEN 1 END)/count(*)*100 AS failure_rate FROM bankdata"),
      ("Age Stats", "SELECT MAX(age), MIN(age), AVG(age) FROM bankdata"),
      ("Customer Balance", "SELECT percentile_approx(balance, 0.5), AVG(balance) FROM bankdata"),
      ("Age vs Subscription", "SELECT age, y AS subscription_status FROM bankdata GROUP BY age, y"),
      ("Marital vs Subscription", "SELECT marital, y AS subscription_status FROM bankdata GROUP BY marital, y"),
      ("Age+Marital vs Subscription", "SELECT age, marital, y AS subscription_status FROM bankdata GROUP BY age, marital, y")
    )

    queries.foreach { case (title, query) =>
      println(s"Running query: $title")
      val result = spark.sql(query)
      result.writeStream.outputMode("update").option("truncate", false).format("console").start().awaitTermination(10)
    }
  }
}

Order Processor - scala code, using Spark Session as per ZipCodeDataFrameExample.scala

input : orders-header.csv
timestamp,order_no,customer_id, amount,region,state,country,qty,purchase_mode
2020-02-02 10:00:00,2323232,1000,234,KA,IN,10,credit-card
2020-02-02 10:00:00,2323236,2000,10000,TN,IN,20,net-banking
2020-02-02 10:00:00,4343434,4000,100,CO,USA,5,credit-coupon

2020-02-02 10:00:00,4534343,1000,1000,KA,IN,10,credit-card
....
...

Data Frame with header
inferSchema  true

1. Filter by country = IN and add filter by purchase_mode = credit-card
2. Group by country, find the total amount spend per country
            IN - 10234
            USA - 100
3. Group by country, find the total amount spend per country on given day 
            Feb 02, 2020, how much amount spend per country
            2020-02-02, USA, 100
            2020-02-02, IN, 10234
            ..
            
4. Group by purchase_mode, find the total orders per purchase_mode
          
              credit-card, 2
              net-banking, 1
              credit-coupon, 1
              
5. For all 1, 2, 3, 4, write  data in csv, with header, to ouput directory, folder name should be unique

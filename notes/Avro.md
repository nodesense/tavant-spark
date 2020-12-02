
Apache Avro - Spark 2.4

credit card, transactions in below data format

dt - 2020-12-12 10:12:23
cardnumber: 4345 4543 4545 4567
amount: float/double: 100.85
customerid: 32323232
age: 30
balance: 343434
--
xml - 195 char per record

<record>
 <dt>2020-12-12 10:12:23</dt>
 <cardnumber>4345 4543 4545 4567</cardnumber>
 <amount>100.85</amount>
 <customerid>32323232</customerid>
 <age>30</age>
 <balance>10000</balance>
</record>

json - 134 char to represent in json per record

{
"dt": "2020-12-12 10:12:23",
"cardnumber":"4345 4543 4545 4567",
"amount":100.85,
"customerid":32323232
"age": 30,
"balance":10000
}


xml - 195 chars * 2 bytes -> unicode 390 bytes
json - 134 chars * 2 bytes -> 268 bytes

Store into HDD  - IO
Load from HDD - IO
transmit the data between cluster during cluster - network IO

Parse the XML/Json

100 * 10000000 = 100 million records ==> 390000000000 bytes in XML
363.215804100036621 GB data in XML
    SPACE - $$$$
    Loading - $$$$$
    Parsing - $$$$$
    
249 GB in JSON
    SPACE - $$$$
    Loading - $$$$$
    Parsing - $$$$$
    --
    
Structured data

{
field 1:  "dt": "2020-12-12 10:12:23",  string or in MILLIS [long] - 8 bytes
field 2: "cardnumber":"4345 4543 4545 4567", // string - 19 char * 2 bytes = 38 bytes
"amount":100.85, // float - 4 bytes
"customerid":32323232, long int, 8 bytes
"age": 30, // short int - 2 bytes
field 6..:   "balance":10000 // double - 8 bytes
}

Storing the data in avro, use the schema, what is first field, whether nullable not, 
data type, position,

df02ab4500110456........ [68 bytes]

count all bytes = 68 bytes

63.329935073852539 GB data




Objavro.schema�{
    "type":"record",
    "name":"topLevelRecord",
    "fields":[
    
      {"name":"firstname","type":["string","null"]},
      {"name":"middlename","type":["string","null"]},
      {"name":"lastname","type":["string","null"]},
      {"name":"dob_year","type":"int"},
      {"name":"dob_month","type":"int"},
      {"name":"gender","type":["string","null"]},
      {"name":"salary","type":"int"}]} 

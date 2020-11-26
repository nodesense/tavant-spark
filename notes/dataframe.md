What is RDD? Collection of objects
             No table structure
             no columns
             no row concepts
             only deals pojo classes and instances
             filters/sorting etc need extra effort
             very specific 
                order means, only contain order data
                Zip only contains zip code data
                
             Not friendly with Python, R script languages
             Good for Java/Scala - JVM Language
             
             
Data Frame
    Similar to table structure
    
    table - name - optional - type
    columns - each column has a meta data, column name, column type...
    rows - set of results items
    
    General Data Structure
    Even Python, R, Scala, Java all can benefits
    PRovide filters, map, ..... which can be applied to any dataset
    
 
spark-shell

Excercises

Load sales.csv file, 
    filter data using category [_c0, c_1....]

copy  sales.csv into sales-header.csv, add the headers on line 1
then load the sales-header.csv, 
    select only needed columns
    filter now, with category column
    
    
    
    
    
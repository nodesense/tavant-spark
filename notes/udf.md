
UDF - User Defined Function

Built in functions 

'select category, sum(qty) from table1 group by category'

sum is a built in function - correct

how do you built your own function and use in sql or spark analytics?

In scala,
    val convertCase = (s: String) => s.toUpperCase
    
    convertCase(record.name) to get capital text
    
    convertCase is user/Developer defined function
    
// how do i call scala from sql
    
    'select convertCase(firstname) from some table'
    
    how do you bring convertCase into sql?
    
 Spark UDF Function
    create a function 
    
    register the function in spark
        then execute the query that calls the function
        
    
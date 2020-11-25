Sales Number - 1 million sale records
5 minutes to complete the job - 1 computer

bring in 10 computers

Split the work amoung 10 computers

[
    {id: 1, amount: 1234, debt: 'retail'....}
    {id: 2, amount: 1234, debt: 'retail'....}
        
    .....
    .....
    {id: 1000000, amount: 1234, debt: 'retail'....}
        
]

Split the 10 laksh amoung 10 computers, 100000 per each 

Computer 1 - 100K - 30 sec
Computer 2 - 100K - 30 sec
...
Computer 10 - 100K - 30 sec

Map - each computers find their avg, sort, sum, min, max, median, mean.., filter.. based on 100K records - 30 seconds
Map - all the system done the computation in 30 records - partial result - 100K records

Reduce - collect all 10 results set, reduce 10 to 1 to get all average of 10000000 records
         merging of result



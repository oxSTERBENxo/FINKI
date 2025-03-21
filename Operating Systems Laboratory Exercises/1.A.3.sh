#Напишете командна процедура која ќе прима произволен број на влезни аргументи кои означуваат времиња на извршување на програма изразени во минути.
#пример - bash script.sh 5 7 15 8 22 6 
#Потребно е процедурата да пресмета и испечати просечно времетраење на програмата според првите три извршувања (5, 7, 15 во примерот) претставено во секунди, како и бројот на извршувања на програмата (број на направени/внесени мерења).
#Доколку бројот на влезни аргументи е поголем или еднаков на 5, потребно е да се испечати 'The testing is done', додека доколку е помал од 5 - 'More testing is needed'.
#Излезот на примерот треба да биде следниот:
#Average execution time: 540
#Count of executions: 6
#The testing is done
#------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------------------------------
#Write a command procedure that will receive an arbitrary number of input arguments representing execution times of a program expressed in minutes.
#Example - bash script.sh 5 7 15 8 22 6 
#The procedure should calculate and print the average duration of the program according to the first three executions (5, 7, 15 in the example) represented in seconds, as well as the number of program executions (the number of measurements made/entered).
#If the number of input arguments is grater than or equal to 5, it should print 'The testing is done', while if it is less than 5, it should print 'More testing is needed'.
#The output of the example should be as follows:
#Average execution time: 540
#Count of executions: 6
#The testing is done

#kako dopolnitelno baranje ni beshe dadeno namesto 3 vreminja, da bidat 5. iskomentiran e toj del od zadacata.
#!/bin/bash

time1=$1
time2=$2
time3=$3
# Uncomment these when you want to include them
# time4=$4
# time5=$5

# Calculate average (currently using 3 times)
average=$(((time1 + time2 + time3) * 60 / 3)) # To include more: add time4 + time5 and divide by 5 instead of 3

count=$#

echo "Average execution time: $average"
echo "Count of executions: $count"

if [ $count -ge 5 ]; then
    echo "The testing is done"
else
    echo "More testing is needed"
fi

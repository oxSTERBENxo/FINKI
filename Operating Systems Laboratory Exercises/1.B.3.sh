#Напишете командна процедура која ќе прима еден влезен аргумент кој ќе претставува име на фајл. Потребно е процедурата да го пополни наведениот фајл со содржините на сите .txt фајлови во истиот директориум за кои корисникот има пермисии за читање (нема пермисии за запишување и извршување). Така што содржината помеѓу два фајла ќе биде одделена со нов ред.
#Потребно е да проверите дали е наведен влезен аргумент, доколку не е, испечатете Insert name of file!
#Доколку се наведени повеќе од еден влезен аргумент, испечатете Too many input arguments!
#Во сите други ситуации, зачувувајте ја содржината на исфилтрираните датотеки во наведениот фајл.
#пример bash script.sh total.txt
#------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------------------------------
#Write a command procedure that will receive one input argument representing the name of a file. The procedure should populate the specified file with the contents of all .txt files in the same directory for which the user has read permissions (no write or execute permissions). So that the content between two files will be separated by a new line.
#You need to check if an input argument is provided. If not, print Insert name of file!
#If more than one input argument is provided, print Too many input arguments!
#In all other situations, save the contents of the filtered files in the specified file.

#!/bin/bash

# Check argument count
if [ $# -eq 0 ]; then
    echo "Insert name of file!"
    exit 1
fi

if [ $# -gt 1 ]; then
    echo "Too many input arguments!"
    exit 1
fi

# Clear the output file
> "$1"

# Loop through .txt files
for file in *.txt; do
    if [ -r "$file" ] && [ ! -w "$file" ] && [ ! -x "$file" ]; then
        cat "$file" >> "$1"
        echo "" >> "$1"  # Adds a newline
    fi
done

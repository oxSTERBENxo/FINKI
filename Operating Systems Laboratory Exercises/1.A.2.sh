#Креирајте директориум со име results и во него csv датотеки со име OS1.txt и OS2.txt / Create a folder with the name results and in it csv files named OS1.txt and OS2.txt.
#Пополнете ги креираните датотеки со податоци за студентите кои го полагале предметот во формат: индекс датум статус поени. (преземете ја содржината од линковите) / Fill in the files you created with data for the students that took the exam for the course using the format: index date status points. (get the content of the files from the links below)
#Прикажете ја на екран содржината на креираните датотеки одделно, но и заедно. / Show the content for these files on screen, separately and together.
#Креирајте датотека со име total.txt во која ќе ги ископирате податоците за сите студенти од сите предмети. / Create a file named total.txt that will have the data for all students from all courses.
#Преместете ја датотеката total.txt во директориумот кој е дете на results, а се вика results_2023. / Move the file total.txt in a folder that is a child of results and is named results_2023.
#Избројте колку редови, зборови и знаци има во датотеката results.txt. / Count the number of rows, words and signs in the file results.txt.
#Прикажете ги на екран податоците само за студентите кои го започнале студирањето во 2022та година. / Show on the screen the data for the students that have enrolled the Faculty in 2022.
#Прикажете ги на екран само индекс, датум, поени на студентите кои го започнале студирањето во 2023та година и имаат над 50 поени на полагањето. / Show on the screen the names of the students, date and points that have enrolled the Faculty in 2023 and have more than 50 points.
#Пребројте колку студенти го немаат завршено квизот од 14.03.2024 (статус in_progress). / Count how many students have not finished the quiz on 14.03.2024 with status in_progress

#Содржина на фајл OS1.txt / Contents of file OS1.txt - https://courses.finki.ukim.mk/pluginfile.php/269875/question/questiontext/711138/2/982584/OS1.txt?time=1710500609977
#Содржина на фајл OS2.txt / Contents of file OS2.txt - https://courses.finki.ukim.mk/pluginfile.php/269875/question/questiontext/711138/2/982584/OS2.txt?time=1710500632665

#!/bin/bash

# 1. Create 'results' directory and two text files
mkdir results
cd results
touch OS1.txt OS2.txt

# 2. Open CSV files for editing 
nano OS1.csv
nano OS2.csv

# 3. Display content of both CSVs
cat OS1.csv
cat OS2.csv
cat OS1.csv OS2.csv

# 4. Combine into total.txt
touch total.txt
cat OS1.csv OS2.csv >> total.txt

# 5. Move total.txt into a new folder
mkdir results_2023
mv total.txt results_2023

# 6. Count words/lines/chars in total.txt
cd ..
wc results/results_2023/total.txt

# 7. Filter lines starting with '22'
grep "^22" results/results_2023/total.txt

# 8. Use awk to filter: lines where column 1 starts with 23 and column 4 > 50
cd results
cd results_2023
awk '$1 ~ /^23/ && $4 > 50 {print $1, $2, $4}' total.txt

# 9. Count how many lines contain specific text
grep "14.03.2024 in_progress" total.txt | wc -l

#Како 10то барање ни беше дадено да ги испечатиме сите од 14ти, над 50 посто, се in_progress. Да се испечатат само 1 и 4 линија.
awk '$2=="14.03.2024" && $4>=50 && $3=="in_progress" { print $1,$4} ' total.txt

#se ova se pishuva vo terminal

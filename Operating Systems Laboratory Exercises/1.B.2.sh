#Креирајте директориум со име results и во него csv датотеки со име OS1.txt и OS2.txt / Create a folder with the name results and in it csv files named OS1.txt and OS2.txt.
#Пополнете ги креираните датотеки со податоци за студентите кои го полагале предметот во формат: индекс датум време(минути:секунди) група статус. (преземете ја содржината од линковите) / Fill in the files you created with data for the students that took the exam for the course using the format: index date time(minutes:seconds) group status. (get the content of the files from the links below)
#Прикажете ја на екран содржината на креираните датотеки одделно, но и заедно. / Show the content for these files on screen, separately and together.
#Креирајте датотека со име total.txt во која ќе ги ископирате податоците за сите студенти од двете датотеки. / Create a file named total.txt that will have the data for all students from both files.
#Преместете ја датотеката total.txt во директориумот кој е дете на results, а се вика results_2023. / Move the file total.txt in a folder that is a child of results and is named results_2023.
#Избројте колку редови, зборови и знаци има во датотеката results.txt. / Count the number of rows, words and signs in the file results.txt.
#Прикажете ги на екран податоците само за студентите кои го започнале студирањето во 2023та година. / Show on the screen the data for the students that have enrolled the Faculty in 2023.
#Прикажете ги на екран само индекс, датум, време на студентите кои го започнале студирањето во 2021та година и имаат статус submitted. / Show on the screen the names of the students, date and time that have enrolled the Faculty in 2021 and have status submitted.
#Пребројте колку студенти од група А го имаат прикачено (submitted) резултатот во помалку од 30 минути. / Count how many students have submitted the results in less than 30 minutes.

#Содржина на фајл OS1.txt / Contents of file OS1.txt - https://courses.finki.ukim.mk/pluginfile.php/269875/question/questiontext/711354/2/982581/OS1_B.txt
#Содржина на фајл OS2.txt / Contents of file OS2.txt - https://courses.finki.ukim.mk/pluginfile.php/269875/question/questiontext/711354/2/982581/OS2_B.txt

#ova se vo terminal
mkdir results

cd results

touch OS1.txt OS2.txt

nano OS1.txt  
nano OS2.txt  

cat OS1.txt  
cat OS2.txt  
cat OS1.txt OS2.txt  

touch total.txt  
cat OS1.txt OS2.txt > total.txt  

mkdir results_2023  
mv total.txt results_2023  

cd ..  
wc results/results_2023/total.txt  

grep "^23" results/results_2023/total.txt  

cd results  
cd results_2023  
awk '$1 ~ /^21/ && $5 == "submitted" { print $1, $2, $3 }' total.txt  

awk '$4 == "A" && $5 == "submitted" { split($3, t, ":"); if (t[1] < 30) print }' total.txt | wc -l #ova vaka mora da go splitnme vremeto bidejki e string


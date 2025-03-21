#Креирајте директориуми со име directory001 и додади датотека со име file123. / Create a directory with name directory001 and add a file named file123.
#Напишете команда со која ќе ја прочитате помошната документација за командата cat. / Write a command to read the manual for the command cat.
#Променете ги пермисиите на фајлот file123 така што истиот може да го читаат и запишуваат само корисникот и неговата група. / Change the file permissions for the file named file123 so that it can be read and written into by the user and the group.
#Направете го претходното барање на друг начин. / Do the previous request in another way.
#Напишете команда со која ќе добиете информација кој сé е тековно најавен на системот./ Write a command to get the info about the users which are currently logged in on the system.
#Креирај нов директориум directory002 и копирај ја датотеката file123 во него со ново име file234 / Create a new directory named directory002 and copy file123 into the new directory and change the name of the file to file234
#Избришете го директориумот directory001 кој го креиравте во рамки на оваа вежба заедно со целосната негова содржина. / Delete directory001 created in this exercise together with its content.

#pishuvate vo terminal

#!/bin/bash

# Create a directory and a file inside it
mkdir directory001
cd directory001
touch file123

# Open the manual for 'cat' 
man cat

# Set file permissions using symbolic mode 
chmod u=rx,g=rx,o= file123

# Set file permissions using numeric mode (read & write for user and group)
chmod 660 file123

# Show who is logged in
who

# Go up one directory
cd ..

# Create another directory and move the file there with a new name
mkdir directory002
mv directory001/file123 directory002/file234

# Remove the original directory
rm -r directory001

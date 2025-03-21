#Креирајте директориуми со име directory1 и directory2 и во првиот директориум додади датотека со име file123. / Create directories with names directory1 and directory2 and in the first directory add a file named file123.
#Напишете команда со која ќе ја прочитате помошната документација за командата ls. / Write a command to read the manual for the command ls.
#Променете ги пермисиите на фајлот file123 така што истиот може да го читаат и извршуваат само корисникот и неговата група. / Change the file permissions for the file named file123 so that it can be read and executed by the user and the group.
#Направете го претходното барање на друг начин. / Do the previous request in another way.
#Напишете команда со која ќе добиете информација кој сé е тековно најавен на системот./ Write a command to get the info about the users which are currently logged in on the system.
#Премести ја креираната датотека од directory1 во directory2 при што ќе го смените името на датотеката во file234 / Move the created file from directory1 to directory2 and change the name of the file to file234
#Избришете го директориумот directory1 кој го креиравте во рамки на оваа вежба заедно со целосната негова содржина. / Delete directory1 created in this exercise together with its content.

#!/bin/bash

# 1. Create directories and a file
mkdir directory1
mkdir directory2
cd directory1
touch file123
cd ..

# 2. Show the manual for 'ls'
man ls

# 3. Set permissions with chmod
chmod 550 directory1/file123

# 4. Another way to set permissions
chmod u=rx,g=rx,o= directory1/file123

# 5. Show who is logged in
who

# 6. Move file to another directory
mv directory1/file123 directory2/file234

# 7. Remove directory1
rm -r directory1

#ova se se komandi shto se pishuvaat vo terminal.

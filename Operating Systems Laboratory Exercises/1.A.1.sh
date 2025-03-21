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

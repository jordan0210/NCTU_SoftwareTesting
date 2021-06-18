sourceFile=$1.c

rm $1_valg $1_ASan

gcc -o $1_valg ${sourceFile}
gcc -fsanitize=address -o $1_ASan ${sourceFile}

echo -e "\n---valgrind---\n"
valgrind ./$1_valg
echo -e "\n---ASan---\n"
./$1_ASan
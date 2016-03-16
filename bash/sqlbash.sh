#! /bin/bash

# This script is to convert mysql dump to mssql compatble insert script
# make sure that insers don't have more than 1000 records per line, as mssql doesn't like it
# to use this script run it from command line 
# sqlcmd -S server -U User -P Password -d database -i input file -o output file


echo "Start Script" 

if [ $# -eq 0 ]
  then
    echo "No arguments supplied. There should be 3 arguments: 1) input file 2) old table name 3) new table name"
	exit 1
fi


if [ -z $1 ];	then
	echo "Gimme an input file"
	exit 1
fi
if [ -z $2 ];	then
	echo "Gimme an old table name"
	exit 1
fi
if [ -z $3 ];	then
	echo "Gimme a new table name"
	exit 1
fi

echo "All arguments supplied"

INPUT_FILE_NAME=$1
OLD_TABLE_NAME=$2
NEW_TABLE_NAME=$3

LINE_NUMBER=$(wc -l $INPUT_FILE_NAME | cut -f1 -d ' ')
FIRST_INSERT=$(awk '/INSERT/{ print NR; exit }' $INPUT_FILE_NAME)

REMOVE_TOP=$(expr $FIRST_INSERT - 1 )
REMOVE_BOTTOM=10

echo "Triming the file"
echo "Creating temp file"

tail -n `expr $LINE_NUMBER - $REMOVE_TOP ` $INPUT_FILE_NAME > temp_$INPUT_FILE_NAME
LINE_NUMBER=$(wc -l temp_$INPUT_FILE_NAME | cut -f1 -d ' ')
head -n `expr $LINE_NUMBER - $REMOVE_BOTTOM ` temp_$INPUT_FILE_NAME > new_$INPUT_FILE_NAME

echo "Removing temp file"
rm temp_$INPUT_FILE_NAME

echo "Rename tables"
sed -i -- 's/'$OLD_TABLE_NAME'/'$NEW_TABLE_NAME'/g' new_$INPUT_FILE_NAME
echo "Remove \" "
sed -i -- 's/\"//g' new_$INPUT_FILE_NAME
echo "Add Co batch"
sed -i -- 's/$/\nGo \n/' new_$INPUT_FILE_NAME


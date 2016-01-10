from sys import argv
# input variables when start the script
script, filename = argv
# open file whit entered name
txt = open(filename)

print ("Here's your file %r:" % filename)
# read from file
print (txt.read())

print ("Type the filename again:")
file_again = input("> ")

txt_again = open(file_again)
# read from file
print (txt_again.read())
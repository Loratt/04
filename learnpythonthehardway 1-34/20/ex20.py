from sys import argv

script, input_file = argv

# method with one input parameter
def print_all(f):
    print (f.read())
	
# method with one input parameter
def rewind(f):
    f.seek(0)

# method with two input parameters
def print_a_line(line_count, f):
# print one pointed line of the file
    print (line_count, f.readline())

# open file useing it's name
current_file = open(input_file)

print ("First let's print the whole file:\n")

# call method cheese_and_crackers and pass file to it 
print_all(current_file)

print ("Now let's rewind, kind of like a tape.")

# call method cheese_and_crackers and pass file to it 
rewind(current_file)

print ("Let's print three lines:")

current_line = 1
# call method cheese_and_crackers and pass file and int to it
print_a_line(current_line, current_file)

current_line = current_line + 1
# call method cheese_and_crackers and pass file and int to it
print_a_line(current_line, current_file)

current_line = current_line + 1
# call method cheese_and_crackers and pass file and int to it
print_a_line(current_line, current_file)
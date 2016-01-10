# put the variable int to the string
x = "There are %d types of people." % 10
# initialize variables Strings
binary = "binary"
do_not = "don't"
y = "Those who know %s and those who %s." % (binary, do_not)

print (x)
print (y)
# print the string including variable String 
print ("I said: %r." % x)
print ("I also said: '%s'." % y)
# initialize variables Boolean
hilarious = False
joke_evaluation = "Isn't that joke so funny?! %r"
# print the string including variable Boolean 
print (joke_evaluation % hilarious)

w = "This is the left side of..."
e = "a string with a right side."
# print two variables String
print (w + e)
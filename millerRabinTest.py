import random

n = int(input("\nEnter a number (>2): "))
if(n <= 2):
	print ("\nInvalid Input!!!\n")
	exit(0) 
q = n-1
k = 0
noOfLoops = 100

while(q % 2 == 0):
	q = int(q / 2)
	k = k + 1

print ("\nn = ", n)
print ("n-1 = 2^k * q")
print ("k = ", k)
print ("q = ", q)

def millerRabin(n, k, q):
	a = random.randint(2, n-1)
	x = pow(a, q, n) #pow calculates a^q % n
	if ( x == 1 or x == n-1 ):
		return 1 #inconclusive / probably prime
	for j in range(0, k):
		x = pow(x, 2, n) #pow calculates x^2 % n
		if ( x == 1 ):
			return 0 #not prime / composite
		if ( x == n-1 ):
			return 1 #inconclusive / probably prime
	return 0 #not prime / composite

yes=0
no=0	
for i in range(noOfLoops):
	temp = millerRabin(n, k, q)
	if ( temp == 1 ):
		yes = yes + 1
	elif ( temp == 0 ):
		no = no + 1

print ("\nProbability of PRIME: ", float(yes)/noOfLoops)
print ("Probability of not PRIME: ", float(no)/noOfLoops, "\n")

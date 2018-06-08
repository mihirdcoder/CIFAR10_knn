'''
Roll Number: 15U348
Assignment Number: B-5_D-3
'''

#Code without using pyCrypto library
import hashlib
import random
import socket

def isPrime(num):
	if(num == 2):
		return 1
	elif(num % 2 == 0):
		return 0
	for i in range(3, num, 2):
		if(num % i == 0):
			return 0
	return 1

socket = socket.socket()

socket.bind(('localhost',8888))

socket.listen(5)

c, addr = socket.accept()

print "Connected to client: ", addr

message = raw_input("Enter the Message: ")
hashOb = hashlib.sha1(message)
hashDig = hashOb.hexdigest()
hashInt = int(hashDig, 16)

#key generation
p = 0
q = 0
g = 0
A = 0
a = 0

q = random.randint(2, 1000)
while(isPrime(q) == 0):
	q = random.randint(2, 1000)

while True:
	p = random.randint(10000, 100000)
	while(isPrime(p) == 0):
		p = random.randint(2, 1000)
	if((p-1) % q == 0):
		break

while True:
	x = random.randint(1, p)
	g = pow(x, ((p-1)/q), p)
	if(g != 1):
		break
		
a = random.randint(0, q)
A = pow(g, a, p)

#public key = p, q, g, A
print "Generated Public key is: "
print "p = ", p
print "q = ", q
print "g = ", g
print "A = ", A

#private key = a
print "\nGenerated Private key is: "
print "a = ", a

#signature generation
r = 0
s = 0
k = 0
kInverse = 0

while True:
	k = random.randint(1, q)
	r = pow(g, k, p) % q
	if(r != 0):
		break

#finding kInverse
kInverse = random.randint(1, q)
while(k * kInverse % q != 1):
	kInverse = random.randint(1, q)

s = kInverse * ( hashInt + a * r ) % q

#signature is = r, s
print "\nDigital Signature Generated is: "
print "r = ", r
print "s = ", s

c.send(message + "\t" + str(p) + "\t" + str(q) + "\t" + str(g) + "\t" + str(A) + "\t" + str(r) + "\t" + str(s))

socket.close()

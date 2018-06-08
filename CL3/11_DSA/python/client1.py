'''
Roll Number: 15U348
Assignment Number: B-5_D-3
'''

#Code without using pyCrypto library
import socket
import random
import hashlib

socket = socket.socket()

socket.connect(('localhost', 8888))

data = socket.recv(4096)
message = data.split("\t")[:-6]
message = "\t".join(word for word in message)
hashOb = hashlib.sha1(message)
hashDig = hashOb.hexdigest()
hashInt = int(hashDig, 16)

p = int(data.split("\t")[-6])
q = int(data.split("\t")[-5])
g = int(data.split("\t")[-4])
A = int(data.split("\t")[-3])
r = int(data.split("\t")[-2])
s = int(data.split("\t")[-1])

print "Received Message is: "
print message

print "\nReceived Public Key is: "
print "p = ", p
print "q = ", q
print "g = ", g
print "A = ", A

print "\nReceived Digital Signature is: "
print "r = ", r
print "s = ", s

sInverse = random.randint(1, q)
while(s * sInverse % q != 1):
	sInverse = random.randint(1, q)
	
if((r>=1 and r<=q-1) and (s>=1 and s<=q-1)):
	u1 = sInverse * hashInt % q
	u2 = r * sInverse % q
	v = ( (pow(g, u1, p) * pow(A, u2, p)) % p) % q
	
	print "\nv = ", v
	
	if( v == r ):
		print "Here, v = r, hence, \nDigital Signature Verified and Accepted!!!\n"
	else:
		print "Invalid Digital Signature!!!\n"
else:
	print "Digital Signature is Invalid!!!\n"

socket.close()

import hashlib
import socket
import time

socket = socket.socket()
#host=socket.gethostname()
#port=12345
socket.bind(("localhost",8888))
socket.listen(5)
while(True):
	c, addr = socket.accept()
	print "Connection Established with Client: ", addr

	choice = int(c.recv(1))
	fileName = ""
	
	if(choice == 1):
		fileName = "text.txt"
		print "Client has requested for TEXT File"
	elif(choice == 2):
		fileName = "image.jpg"
		print "Client has requested for IMAGE File"
	
	f = open(fileName, 'rb')
	sendMessage = f.read()
	hashObject = hashlib.sha1(sendMessage)
	hashString = str(hashObject.hexdigest())
	c.send(hashString)

	c.send(sendMessage)
				
	print "Hash of Sent File: ", hashString
	c.close()

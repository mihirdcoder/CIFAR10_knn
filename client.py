import hashlib
import socket


s = socket.socket()
#host=socket.gethostname()
#port=12345
s.connect(("localhost",8888))

choice = int(raw_input("1. Text\n2. Image\nEnter Choice: "))
s.send(str(choice))

hashObject = hashlib.sha1()
receivedMessage = ""

receivedHash= s.recv(40)
fileName = ""

if(choice == 1):
	fileName = "received.txt"
	print "Received text is in 'received.txt'"
elif(choice == 2):
	fileName = "received.jpg"
	print "Received text is in 'received.jpg'"

fw = open(fileName, 'wb')	
receivedMessage = s.recv(1024)
while(receivedMessage):
	fw.write(receivedMessage)
	hashObject.update(receivedMessage)
	receivedMessage = s.recv(1024)

hashOfMessage = str(hashObject.hexdigest())

print "HASH OF RECEIVED MESSAGE: ", hashOfMessage

print "RECEIVED HASH: ", receivedHash
if(hashOfMessage == receivedHash):
		print "No Tampering!!!"
else:
		print "Tampering!!!"
s.close()

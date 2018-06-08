from pyDes import des

class Encryption:
    def ceaserCipher(self,input):
        shift = 3
        cipher_text = ''
        for i in input:
            ascii = ord(i)
            if(i == " "):
                continue
            elif(ascii < 97):
                encrypt = ((ascii-65+shift)%26)+65
                cipher_text += chr(encrypt)
            else:
                encrypt = ((ascii-97+shift)%26)+97
                cipher_text += chr(encrypt)
        print("\n ceaser text: ",cipher_text)
    def desEncrypt(self, input):
        k = des("MyITPUNE", pad='Z')
        d = k.encrypt(input)
        print("\n Cipher Text: %r" %d)
        print ("DES Decrypted Cipher Text: %r" %k.decrypt(d), "\n")

   
            
encrypt = Encryption()
while(1):
	choice = raw_input("1.Caesar Cipher \n2.Hill Cipher \n3.DES \n4.Exit \nEnter Option= ")
	if(choice == '1'):
		message=raw_input("Enter text: ")
		encrypt.ceaserCipher(message)	
	#elif(choice =='2'):
	#	message=raw_input("Enter text (all CAPS) : ")
	#	encrypt.hillCipher(message)
	elif(choice == '3'):
		message=raw_input("Enter text: ")
		encrypt.desEncrypt(message)
	else:
		exit(0)

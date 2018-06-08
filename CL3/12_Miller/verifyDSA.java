/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;
/**
 *
 * @author dypiemr-
 */
public class verifyDSA {
   
    public static void main(String ar[]) throws FileNotFoundException, IOException
    {
        File file = new File("ipfile.txt");
        FileInputStream fin = null;

        fin = new FileInputStream(file);

        byte data[] = new byte[(int) file.length()];
        // Reads up to certain bytes of data from this input stream into an array of bytes.
        fin.read(data);
        //create string from byte array
        String s = new String(data);
        System.out.println("File content: " + s);

           
        DSA ds = new DSA();
        Miller m = new Miller();
        System.out.println("Generating q,p,g: ");
        ds.generateKey();
        BigInteger r = ds.generateR();
        System.out.println("Generating Sign: ");
        BigInteger sign = ds.generateS(r, data);
        System.out.println(sign);
        System.out.println("Verifying Sign: ");
        boolean ver = ds.verify(data, r, sign);
        System.out.println(ver);
        System.out.println("................................Verifying Sign using Miller: ..............................................");
        System.out.println("\nEnter number of iterations");
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        boolean prime = m.isPrime(sign.longValue(), k);

        if (prime)

            System.out.println("\n"+ sign +" is prime");

        else

            System.out.println("\n"+ sign +" is composite");

    }
    
}

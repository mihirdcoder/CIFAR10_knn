/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package messagesha1;
import java.io.*;
import java.net.*;


/**
 *
 * @author dypiemr-
 */
public class Sender {
    
    private static Socket socket;
 
    public static void main(String args[])
    {
        try
        {
            String host = "localhost";
            int port = 2525;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
 
            //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            BufferedReader brr=new BufferedReader(new InputStreamReader(System.in));
            String s= brr.readLine();
            String sendMessage;
            try {
                String encryMsg = Sha1.SHA1(s);
                sendMessage = String.valueOf(encryMsg) + "\n";
                bw.write(sendMessage);
                bw.flush();
                System.out.println("Message sent : " + sendMessage);
            } catch (UnsupportedEncodingException e) {
                System.out.println(e);
            }
            
 
            //Get the return message from the server
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message received  : " +message);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            //Closing the socket
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/BoothsMultiplication")
public class BoothsMultiplication extends HttpServlet
{
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int i;
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        try {
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet Calculator</title>");
	            out.println("</head>");
	            out.println("<body>");
	            String num1 = request.getParameter("no1");
	            String num2 = request.getParameter("no2");
	            int n=Integer.parseInt(num1);
	            int n1=Integer.parseInt(num2);
	   		int k=mul(n,n1);
	   		out.println("Booths Multiplication Result:"+k);
	   		out.println("</body>");
            out.println("</html>");
	        }
	        
	      finally{}
	 }
	 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

	    /**
	     * Handles the HTTP <code>GET</code> method.
	     *
	     * @param request servlet request
	     * @param response servlet response
	     * @throws ServletException if a servlet-specific error occurs
	     * @throws IOException if an I/O error occurs
	     */
	   // @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    /**
	     * Handles the HTTP <code>POST</code> method.
	     *
	     * @param request servlet request
	     * @param response servlet response
	     * @throws ServletException if a servlet-specific error occurs
	     * @throws IOException if an I/O error occurs
	     */
	   // @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        processRequest(request, response);

	    }

	    /**
	     * Returns a short description of the servlet.
	     *
	     * @return a String containing servlet description
	     */
	    //@Override
	    public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>

	

	   	

public int mul(int n1,int n2)
{
	int m[]=binary(n1);
	int m1[]=binary(-n1);
	int r[]=binary(n2);
	int A[]=new int[9];
	int S[]=new int[9];
	int P[]=new int[9];
	for(int i=0;i<4;i++)
	{
		A[i]=m[i];
		S[i]=m1[i];
		P[i+4]=r[i];
	}
	display(A,'A');
	display(S,'S');
	display(P,'P');
	System.out.println();
	for (int i=0;i<4;i++)
	{
		if(P[7]==0 && P[8]==0);
		
		else if(P[7]==1 && P[8]==0)
			add(P,S);
		else if(P[7]==0 && P[8]==1)
			add(P,A);
		else if(P[7]==1 && P[8]==1);
		rightshift(P);
		display(P,'P');
	}
	return deci(P);
}
public void add(int A[],int B[])
{
	int carry=0;
	for(int i=8;i>=0;i--)
	{
		int temp=A[i]+B[i]+carry;
		A[i]=temp%2;
		carry=temp/2;
	}
}
public int[] binary(int n)
{
	int bin[]=new int[4];
	int ctr=3;
	int num=n;
	if(n<0)
	{
		num=16+n;
	}
	while(num!=0)
	{
		bin[ctr--] = num%2;
		num /= 2;
	}
		return bin;
}

public void rightshift(int[] A)
{
	for(int i=8;i>=1;i--){
	A[i]=A[i-1];}
}
public int deci(int B[])
{
	int p=0;
	int t=1;
	for(int i=7;i>=0;i--)
	{
		p=p+(B[i]*t);
		t=t*2;
	}
	if(p>64)
	{
		p=-(256-p);
	}
	return p;
}
public void display(int P[],char ch)
{
	System.out.println("\n"+ch+" :");
	for(int i=0;i<P.length;i++)
	{
		if(i==4)
			System.out.print(" ");
		if(i==8)
			System.out.print(" ");
		
		System.out.print(P[i]);
	}
}
	


	
	
}


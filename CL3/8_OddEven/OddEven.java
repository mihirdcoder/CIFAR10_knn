import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OddEven")
public class OddEven extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int i, n;
        int[] array = new int[6];
        try {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Oddevents</title>");
            out.println("</head>");
            out.println("<body>");

            for(i=0;i<6;i++)
            {
                String num=request.getParameter("no"+i);
                n=Integer.parseInt(num);
                array[i]=n;
            }
            out.println("Values Before the sort:\n\n");
            for (i = 0; i < array.length; i++) {
                out.println(array[i] + " \n ");
                
            }
            out.println();
            odd_even_srt(array, array.length);
            out.println("Values after the sort:\n\n");
            for (i = 0; i < array.length; i++) {
                out.println(array[i] + " \n ");
            }
            out.println();

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

     public static void odd_even_srt(int array[], int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j + 1 < n; j += 2) {
                if (array[j] > array[j + 1]) {
                    int T = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = T;
                }
            }
            for (int j = 1; j + 1 < array.length; j += 2) {
                if (array[j] > array[j + 1]) {
                    int T = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = T;
                }
            }
        }
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
    @Override
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


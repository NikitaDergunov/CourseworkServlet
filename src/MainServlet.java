import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {

             if (req.getParameter("button1") != null) {
                resp.sendRedirect(req.getContextPath() + "/OrganServlet");
            }
            else if(req.getParameter("button2") != null) {
                resp.sendRedirect(req.getContextPath() + "/DonorServlet");
            }
            else if(req.getParameter("button3") != null) {
                resp.sendRedirect(req.getContextPath() + "/MHServlet");
            }
            else if(req.getParameter("button4") != null) {
                resp.sendRedirect(req.getContextPath() + "/PatientServlet");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }




}

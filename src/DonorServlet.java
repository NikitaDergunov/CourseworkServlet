import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DonorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
        resp.setContentType("text/html");
        ServletContext context=getServletContext();
        DonorDao Donor = (DonorDao) context.getAttribute("Donor");
        Donor.init(req,resp, context);
            if(req.getParameter("DIns") != null) {
                String[] ins = new String[5];
                ins[0] = req.getParameter("DSex");
                ins[1] = "'" + req.getParameter("DBloodType") + "'";
                ins[2] = "'" + req.getParameter("DStatus") + "'";
                ins[3] = req.getParameter("DOrganID");
                ins[4] = req.getParameter("DDonorID");
                Donor.insertInto(ins);
               Donor.outputTable();
               resp.sendRedirect( req.getContextPath() + "/Donor");
            }

            else if (req.getParameter("DonorDel") != null) {
                int del = Integer.parseInt(req.getParameter("textarea1"));
                Donor.deleteByID(del);
                Donor.outputTable();
               resp.sendRedirect( req.getContextPath() + "/Donor");
            }
            else{
            Donor.outputTable();
            resp.sendRedirect(req.getContextPath() + "/Donor");}

        }
        catch (Exception e){
        }
    }
}
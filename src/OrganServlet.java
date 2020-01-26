import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrganServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("text/html");
            ServletContext context=getServletContext();
            OrganDao Organ = (OrganDao) context.getAttribute("Organ");
            Organ.init(req,resp, context);

            if(req.getParameter("OIns") != null) {
                String[] ins = new String[7];
                ins[0] = "'" + req.getParameter("OBloodType") + "'";
                ins[1] = req.getParameter("OSize");
                ins[2] = "'" + req.getParameter("OExpirationDAte") + "'";
                ins[3] = "'" + req.getParameter("OType") + "'";
                ins[4] = req.getParameter("OPatientID");
                ins[5] = req.getParameter("ODonorID");
                ins[6] = req.getParameter("OOrganID");
                Organ.insertInto(ins);
                Organ.outputTable();
                resp.sendRedirect( req.getContextPath() + "/Organ");
            }

            else if (req.getParameter("OrganDel") != null) {
                int del = Integer.parseInt(req.getParameter("textarea1"));
                Organ.deleteByID(del);
                Organ.outputTable();
                resp.sendRedirect( req.getContextPath() + "/Organ");
            }
            else{
                Organ.outputTable();
                resp.sendRedirect(req.getContextPath() + "/Organ");}

        }
        catch (Exception e){
        }
    }
}
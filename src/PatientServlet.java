import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PatientServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("text/html");
            ServletContext context=getServletContext();
            PatientsDao Patients = (PatientsDao) context.getAttribute("Patients");
            Patients.init(req,resp, context);

            if(req.getParameter("PIns") != null){
                String[] ins = new String[6];
                ins[0] = "'" + req.getParameter("PName") + "'";
                ins[1] = req.getParameter("PPatientID");
                ins[2] = req.getParameter("PSex");
                ins[3] = "'" + req.getParameter("PBT") + "'";
                ins[4] = req.getParameter("PSeverity") ;
                ins[5] = "'" + req.getParameter("POrganNeded") + "'";
                Patients.insertInto(ins);
                Patients.outputTable();
                resp.sendRedirect( req.getContextPath() + "/Patient");
            }

            else if (req.getParameter("PatientDel") != null) {
                int del = Integer.parseInt(req.getParameter("textarea1"));
                Patients.deleteByID(del);
                Patients.outputTable();
                resp.sendRedirect( req.getContextPath() + "/Patient");
            }
            else{
                Patients.outputTable();
                resp.sendRedirect(req.getContextPath() + "/Patient");}

        }
        catch (Exception e){
        }
    }
}
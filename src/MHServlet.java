import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MHServlet extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        }


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
            try {
                resp.setContentType("text/html");
                ServletContext context=getServletContext();
                MedicalHistoryDao MH = (MedicalHistoryDao) context.getAttribute("MH");
                MH.init(req,resp, context);

                if (req.getParameter("MHIns") != null){
                    String[] ins = new String[3];
                    ins[0] = "'" + req.getParameter("MHHistory") + "'";
                    ins[1] = req.getParameter("MHPatientID");
                    ins[2] ="'" + req.getParameter("MHDateOfAdmission") + "'";
                    MH.insertInto(ins);
                    MH.outputTable();
                    resp.sendRedirect( req.getContextPath() + "/MH");
                }

                else if (req.getParameter("MHDel") != null) {
                    int del = Integer.parseInt(req.getParameter("textarea1"));
                    MH.deleteByID(del);
                    MH.outputTable();
                    resp.sendRedirect( req.getContextPath() + "/MH");
                }
                else{
                    MH.outputTable();
                    resp.sendRedirect(req.getContextPath() + "/MH");}

            }
            catch (Exception e){
            }
        }
}
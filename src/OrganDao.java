import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import models.OrganModel;

public class OrganDao  implements DaoInterface{
    private String page= "WEB-INF/Organ.jsp";
    private List list = new ArrayList();
    private HttpServletRequest req;
    private HttpServletResponse resp;
    Statement statement;


  public void init(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws SQLException {
      req = request;
      resp = response;
        resp.setContentType("text/html");
        //ServletContext context=getServletContext();
        statement = ((Connection) (context.getAttribute("Connection"))).createStatement();
    }
    @Override
    public void outputTable() throws SQLException{
        list.clear();
        String query = "select * from public.\"Organs\"" ;
        ResultSet resultSet = statement.executeQuery(query);

        ResultSetMetaData rsmt = resultSet.getMetaData();
        String[] p = new String[rsmt.getColumnCount()];
        while(resultSet.next()){
            OrganModel organModel = new OrganModel();
            organModel.setBloodType(resultSet.getString(1));
            organModel.setSize(Integer.parseInt(resultSet.getString(2)));
            organModel.setExpirationDate(resultSet.getString(3));
            organModel.setType(resultSet.getString(4));
            organModel.setPatientID(Integer.parseInt(resultSet.getString(5)));
            organModel.setDonorID(Integer.parseInt(resultSet.getString(6)));
            organModel.setId(Integer.parseInt(resultSet.getString(7)));
            list.add(organModel);
        }


        req.setAttribute("organ",list);



        RequestDispatcher dispatcher = req.getRequestDispatcher(page);

        if (dispatcher != null){
            try {

                dispatcher.forward(req, resp);
                //resp.sendRedirect(req.getContextPath() + "WEB-INF/Organ.jsp");

            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void getById(int id) throws SQLException, ClassNotFoundException {

        String query = "select * from public.\"Organs\" where public.\"Organs\".\"OrganID\" = " + id + ";";
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData rsmt = resultSet.getMetaData();
        String[] p = new String[rsmt.getColumnCount()];
        while(resultSet.next()){
            String full = null;
            OrganModel organModel = new OrganModel();
            organModel.setBloodType(resultSet.getString(1));
            organModel.setSize(Integer.parseInt(resultSet.getString(2)));
            organModel.setExpirationDate(resultSet.getString(3));
            organModel.setType(resultSet.getString(4));
            organModel.setPatientID(Integer.parseInt(resultSet.getString(5)));
            organModel.setDonorID(Integer.parseInt(resultSet.getString(6)));
            organModel.setId(Integer.parseInt(resultSet.getString(7)));
           /* for(int i = 0; i<p.length; i++) { //Считываем данные
                p[i] = resultSet.getString(i+1);
                full = full + (" " + p[i]);
            }

            list.add(full);*/
           list.add(organModel);
        }
        req.setAttribute("organ",list);


        RequestDispatcher dispatcher = req.getRequestDispatcher(page);

        if (dispatcher != null){
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void insertInto(String[] value) throws SQLException, ClassNotFoundException {
        String ins = "(";
        for(int i = 0;i<=6;i++){
            ins = ins + value[i] +",";
        }
        ins = ins.substring(0, ins.length() - 1) + ")";
        String query = "INSERT INTO public.\"Organs\" (\"BloodType\", \"Size\", \"ExpirationDAte\", \"Type\", \"PatientID\", \"DonorID\", \"OrganID\")  VALUES "
                + ins + ";";
        statement.executeUpdate(query);
    }

    @Override
    public void deleteByID(int id) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM public.\"Organs\" WHERE  public.\"Organs\".\"OrganID\" = " + id + ";";
        statement.executeUpdate(query);
    }
}

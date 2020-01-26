import models.PatientModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class PatientsDao  implements DaoInterface{
    private String page= "WEB-INF/Patient.jsp";
    private List list = new ArrayList();
    private HttpServletRequest req;
    private HttpServletResponse resp;
    Statement statement;


    public void init(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws SQLException {
        req = request;
        resp = response;
        resp.setContentType("text/html");

        statement = ((Connection) (context.getAttribute("Connection"))).createStatement();
    }
    @Override
    public void outputTable() throws SQLException{
        list.clear();
        String query = "select * from public.\"Patients\"" ;
        ResultSet resultSet = statement.executeQuery(query);

        ResultSetMetaData rsmt = resultSet.getMetaData();
        String[] p = new String[rsmt.getColumnCount()];
        while(resultSet.next()){
            PatientModel patientModel = new PatientModel();
            patientModel.setName(resultSet.getString(1));
            patientModel.setId(Integer.parseInt(resultSet.getString(2)));
            patientModel.setSex(Boolean.valueOf(resultSet.getString(3)));
            patientModel.setBloodType(resultSet.getString(4));
            patientModel.setSeverity(Integer.parseInt(resultSet.getString(5)));
            patientModel.setOrganNeded(resultSet.getString(6));
            list.add(patientModel);

        }

        req.setAttribute("Patients",list);



        RequestDispatcher dispatcher = req.getRequestDispatcher(page);

        if (dispatcher != null){
            try {

                dispatcher.forward(req, resp);
                //resp.sendRedirect(req.getContextPath() + "WEB-INF/jsp");

            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void getById(int id) throws SQLException, ClassNotFoundException {

        String query = "select * from public.\"Patients\" where public.\"Patients\".\"PatientID\" = " + id + ";";
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData rsmt = resultSet.getMetaData();
        String[] p = new String[rsmt.getColumnCount()];
        while(resultSet.next()){
            String full = null;
            for(int i = 0; i<p.length; i++) { //Считываем данные
                p[i] = resultSet.getString(i+1);
                full = full + (" " + p[i]);
            }

            list.add(full);
        }
        req.setAttribute("Patients",list);

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
        for(int i = 0;i<=5;i++){
          ins = ins + value[i] +",";
        }
        ins = ins.substring(0, ins.length() - 1) + ")";
        String query = "INSERT INTO public.\"Patients\" (\"Name\", \"PatientID\", \"Sex\", \"BT\", \"Severity\", \"OrganNeded\") VALUES  "
                + ins + ";";
        statement.executeUpdate(query);
    }

    @Override
    public void deleteByID(int id) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM public.\"Patients\" WHERE  public.\"Patients\".\"PatientID\" = " + id + ";";
        statement.executeUpdate(query);
    }
}

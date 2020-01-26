import models.DonorModel;

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

public class DonorDao  implements DaoInterface{
    private String page= "WEB-INF/Donor.jsp";
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
        String query = "select * from public.\"Donor\"" ;
        ResultSet resultSet = statement.executeQuery(query);

        ResultSetMetaData rsmt = resultSet.getMetaData();
        String[] p = new String[rsmt.getColumnCount()];
        while(resultSet.next()){
            DonorModel donorModel = new DonorModel();
            donorModel.setSex(Boolean.valueOf(resultSet.getString(1)));
            donorModel.setBloodType(resultSet.getString(2));
            donorModel.setStatus(resultSet.getString(3));
            donorModel.setOrganID(Integer.parseInt(resultSet.getString(4)));
            donorModel.setId(Integer.parseInt(resultSet.getString(5)));
            list.add(donorModel);
        }

        req.setAttribute("Donor",list);


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

        String query = "select * from public.\"Donor\" where public.\"Donor\".\"DonorID\" = " + id + ";";
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
        req.setAttribute("Donor",list);

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
        for(int i = 0;i<=4;i++){
            ins = ins + value[i] +",";
        }
        ins = ins.substring(0, ins.length() - 1) + ")";
        String query = "INSERT INTO public.\"Donor\" (\"Sex\", \"BloodType\", \"Status\", \"OrganID\", \"DonorID\")  VALUES "
                + ins + ";";
        statement.executeUpdate(query);
    }

    @Override
    public void deleteByID(int id) throws SQLException, ClassNotFoundException, IOException {
        String query = "DELETE FROM public.\"Donor\" WHERE  public.\"Donor\".\"DonorID\" = " + id + ";";
        statement.executeUpdate(query);


    }
}

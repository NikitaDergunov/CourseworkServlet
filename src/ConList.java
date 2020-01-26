import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConList implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {

            ServletContext context=servletContextEvent.getServletContext();
            String url=context.getInitParameter("url");;
            String user=context.getInitParameter("user");;
            String pass=context.getInitParameter("password");;
            String driver=context.getInitParameter("driver");
            DbConnector connect = new DbConnector(url,driver,user,pass,context); //оздаем соединение
            context.setAttribute("Connection",connect.conn);
            //Создаем экземпляры ДАО шаблонов
            OrganDao Organ = new OrganDao();
            PatientsDao Patients = new PatientsDao();
            DonorDao Donor = new DonorDao();
            MedicalHistoryDao MH = new MedicalHistoryDao();
            //Записываем их в контекст сервлета
            context.setAttribute("Organ", Organ);
            context.setAttribute("Patients", Patients);
            context.setAttribute("Donor", Donor);
            context.setAttribute("MH", MH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }
}
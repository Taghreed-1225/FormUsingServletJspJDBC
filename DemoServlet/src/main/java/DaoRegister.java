import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoRegister {
	
	
	String jdbcurl="jdbc:mysql://localhost:3306/member";
	

    String dbusername="root";
    String dbpassword="123456";
    private String dbdriver = "com.mysql.cj.jdbc.Driver";
    public void loadDriver(String dbDriver)
    {
    try {
    Class.forName(dbDriver);
    } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }
    public Connection getConnection()
    {
    	Connection con=null;
    try {
		 con= DriverManager.getConnection(jdbcurl, dbusername, dbpassword);
	}
    catch (SQLException e)
    {
		// TODO Auto-generated catch block
		e.printStackTrace();
      
     }
    return con;
    }
    public String insert(Member member) {
    	loadDriver(dbdriver);
    	Connection con=getConnection();
    	String res=" data enter";
		String sql="insert into member1  (username,password,email,phone) "
		+"values(?,?,?,?)";
		try {
		PreparedStatement stm=con.prepareStatement(sql);
	
		stm.setString(1,member.getUsername());
		stm.setString(2,member.getPassword());
		 stm.setString(3,member.getEmail());
		stm.setString(4,member.getPhone());
		int row=stm.executeUpdate();
		
		if(row>0)
		{
			System.out.println(" a new user has been inserted successfully. ");
		}
		if( con !=null)
		{
			System.out.println(" connected to database");
			con.close();
			
		}
	}
    catch (SQLException e)
    {
		// TODO Auto-generated catch block
		e.printStackTrace();
      res="data not enter";
     }
		return res;
    	
    	
    }
}

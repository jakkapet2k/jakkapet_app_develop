package bean;

import java.sql.*;


public class LoginDao {

	public static boolean validate(UserLogin bean) {
		boolean status = false ;
		try {
			System.out.println("userInput : "+bean.user);
			System.out.println("passInput : "+bean.pass);

			ConnMariaDB connDB = new ConnMariaDB();
			Connection con = connDB.getConnection();
			String query = "select * from customer where username='" + bean.user + "' and password='" + bean.pass + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				
				rs.getString("username");
				rs.getString("password");
				
				System.out.println("userOutput : "+rs.getString("username"));
				System.out.println("passOutput : "+rs.getString("password"));
				
				if(rs.getString("username")!=null) {
					status = true;
					System.out.println("status : "+status);
				}else {
					status = false;
					System.out.println("status : "+status);
				}
				

			}
		
			st.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return status;
	}

}

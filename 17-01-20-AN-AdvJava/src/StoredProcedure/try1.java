package StoredProcedure;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import java.util.*;
public class try1 {

	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java","root","root");
		CallableStatement statement = null;
		String query = "{CALL display()}";
		statement = conn.prepareCall(query);
        ResultSet result = statement.executeQuery();
        List<student> list = new LinkedList<>();
		//System.out.println("hi");
		while(result.next()) {
			student st = new student();
			st.set_id(result.getInt("id"));
			st.set_name(result.getString("name"));
			st.set_college(result.getString("college"));
			st.set_did(result.getInt("d_id"));
			st.set_dname(result.getString("dname"));
			list.add(st);
		}
		System.out.println("StudentID\tStudentName\tCollege\tDepartmentID\tDepartmentName");
		for(student row: list) {
			System.out.println(row.get_id()+"\t\t"+row.get_name()+"\t\t"+row.get_college()+"\t"+row.get_did()+"\t\t"+row.get_dname()+"\n");
		}
		conn.close();
	 }
	catch(Exception e){
		System.out.println(e.getMessage());
	}

	}
}

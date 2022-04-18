<%@page import="com.db.MySQLConncetion"%>
<%@page import="java.sql.*"%>
<%
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<body>

	<h1>Retrieve data from database in JSP</h1>
	<table border="1">
		<tr>
			<td>SELL</td>
			<td>LIST</td>
			<td>LIVING</td>
			<td>ROOMS</td>
			<td>BEDS</td>
			<td>BATHS</td>
			<td>AGE</td>
			<td>ACRES</td>
			<td>TAXES</td>

		</tr>
		<%
		try {
			Connection con = MySQLConncetion.getConnection();
			Statement st = con.createStatement();
			String sql = "select * from home";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getInt(2)%></td>
			<td><%=rs.getInt(3)%></td>
			<td><%=rs.getInt(4)%></td>
			<td><%=rs.getInt(5)%></td>
			<td><%=rs.getInt(6)%></td>
			<td><%=rs.getInt(7)%></td>
			<td><%=rs.getFloat(8)%></td>
			<td><%=rs.getInt(9)%></td>
		</tr>
		<%
		}
		con.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
	</table>

</body>
</html>
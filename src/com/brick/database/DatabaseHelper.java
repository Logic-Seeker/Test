package com.brick.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.brick.frame.LoginScreen;
import com.brick.helper.BrickHelper;
import com.brick.helper.CustomerHelper;
import com.brick.helper.EmployeeHelper;
import com.brick.helper.LaborHelper;
import com.brick.helper.LeaderHelper;
import com.brick.helper.VehicleInfo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class DatabaseHelper {
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	public DatabaseHelper() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/brick_inventory", "root",
					"shresthas");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean checkValidLogin(String userName, String password) {

		String query = "SELECT * From user";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				if (userName.equals(rs.getString("username"))
						&& password.equals(rs.getString("password"))) {
					return true;
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public int getid(String userName, String password) {

		String query = "SELECT * From user";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				if (userName.equals(rs.getString("username"))
						&& password.equals(rs.getString("password"))) {
					return rs.getInt("user_id");
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return -1;
	}

	public int addNewUser(String userName, String password) {
		String query = "INSERT INTO user (username,password) values ('"
				+ userName + "','" + password + "');";
		Statement stmt = null;
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

		public void insertOrder(String name) {

		String query = "";
	}

	public String fetchlabourtype(int id)
	{
		String result="";
		String query = "SELECT type From labour where id ='"+id+"'";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getString("type");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;

		
	}

	public ArrayList<CustomerHelper> fetchCustomerName() {
		ArrayList<CustomerHelper> list = new ArrayList<CustomerHelper>();
		String query = "SELECT * From customer where Remove='Delete'";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				CustomerHelper customer = new CustomerHelper();
				customer.id = rs.getInt("id");
				customer.name = rs.getString("name");
				list.add(customer);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	
	
	public ArrayList<EmployeeHelper> fetchDriverName() {
		ArrayList<EmployeeHelper> list = new ArrayList<EmployeeHelper>();
		String query = "SELECT * From employee where E_Type='driver'";
		System.out.println("check");
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmployeeHelper driverName = new EmployeeHelper();
				driverName.id = rs.getInt("E_id");
				driverName.name = rs.getString("E_Name");
				list.add(driverName);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<EmployeeHelper> fetchEmployeeName() {
		ArrayList<EmployeeHelper> list = new ArrayList<EmployeeHelper>();
		String query = "SELECT * From employee where Remove='Delete'";
		System.out.println("check");
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmployeeHelper driverName = new EmployeeHelper();
				driverName.id = rs.getInt("E_id");
				driverName.name = rs.getString("E_Name");
				list.add(driverName);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}
	
	public ResultSet fetchEmployee() {
	//	ArrayList<EmployeeHelper> list = new ArrayList<EmployeeHelper>();
		String query = "SELECT E_id, E_Name as Name, E_Type as Post, PAddress as 'Permanent Address', TAddress as 'Temporary Address', Salary, Phone, Remove FROM employee where Remove='Delete'";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}

	public ArrayList<BrickHelper> fetchBrickName() {
		ArrayList<BrickHelper> list = new ArrayList<BrickHelper>();
		String query = "SELECT * From brick";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				BrickHelper brickName = new BrickHelper();
				brickName.id = rs.getInt("brick_id");
				brickName.name = rs.getString("brick_type");
				list.add(brickName);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	
	public ResultSet fetchworkdetail(int labourid) throws SQLException {

		String query = "SELECT L.name, L.type, SUM(LT.Amount) ,B.brick_type, LT.transcation_date, BD.Distance_Type FROM labour L, labour_transcation LT,brick_distance BD,brick B WHERE L.id ='"+labourid+"' AND L.id=LT.l_id AND BD.bd_id = LT.bd_id AND B.brick_id=BD.brick_id group by L.name, L.type,B.brick_type, LT.transcation_date, BD.Distance_Type;";
		Statement stmt = null;
		String errorMessage = "";
		//int result = -1;
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		//return new Object[] { result,errorMessage };


	}
	
	public ResultSet fetchpatheri(int labourid) throws SQLException {

		String query = "SELECT L.name, L.type, SUM(LT.Amount) , LT.transcation_date FROM labour L, labour_transcation LT WHERE L.id=LT.l_id AND L.id='"+labourid+"' group by L.name, L.type, LT.transcation_date ;";
		Statement stmt = null;
		String errorMessage = "";
		//int result = -1;
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		//return new Object[] { result,errorMessage };


	}

	public ResultSet fetchlaborrecords() throws SQLException {
System.err.println("DatabaseHelper 227");
		String query = "SELECT id,name as Name,type as 'Labour Type',brick_amount as 'Brick Amount',Remove from labour where Remove = 'Delete';";
		Statement stmt = null;
		String errorMessage = "";
		//int result = -1;
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		//return new Object[] { result,errorMessage };


	}
	public void setcondition()
	{
		String query = "update mark set conditon='1' where id=1";
		Statement stmt = null;
		int result = -1;
		try {
		stmt = connection.createStatement();
		result = stmt.executeUpdate(query);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	

	public ResultSet fetchleaderrecords() throws SQLException {

		String query = "SELECT id,name as Name,address as Address,mobile as 'Mobile No.',telephone as 'Telephone No.',rate as Rate,Remove from leader where Remove='Delete';";
		Statement stmt = null;
		String errorMessage = "";
		//int result = -1;
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		//return new Object[] { result,errorMessage };


	}

	public ResultSet fetchcustomerrecords() throws SQLException {

		String query = "SELECT id,name as Name,PAddress as 'Permanent Address',TAddress as 'Temporary Address',MobileNo as 'Mobile No.',TelephoneNo as 'Telephone No.',Remove from customer where Remove='Delete';";
		Statement stmt = null;
		String errorMessage = "";
		//int result = -1;
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		//return new Object[] { result,errorMessage };


	}

	public ResultSet fetchattendance(int empid) throws SQLException {

		String query = "Select Date,Absent,Leaves,Reason From attendance WHERE MONTH((Date)) = 11 AND E_id='"+empid+"';";
		Statement stmt = null;
		String errorMessage = "";
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		


	}


	
	public ResultSet fetchorder() throws SQLException {

		String query = "SELECT C.name,OE.destination,OE.no_of_brick,OE.no_of_halfbrick from order_entry OE,customer C where OE.customer_id=C.id;";
		Statement stmt = null;
		String errorMessage = "";
		//int result = -1;
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			return result;
		//return new Object[] { result,errorMessage };


	}
	
	public void deleterow(int id) throws SQLException {

		String query = "SELECT C.name,OE.destination,OE.no_of_brick,OE.no_of_halfbrick from order_entry OE,customer C where OE.customer_id=C.id;";
		Statement stmt = null;
		String errorMessage = "";
		//int result = -1;
	
			stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			
		//return new Object[] { result,errorMessage };


	}
	
	
	
	public Object insertOrderDelivery(String voucher, int vehicle, int driver,
			int brick, int half, int customer, String destination) {

		String query = "insert into OrderDelivery(VoucherNo,vechile_id,E_id,brick_id,id,destination,HalfBrick) values('"
				+ voucher
				+ "','"
				+ vehicle
				+ "','"
				+ driver
				+ "','"
				+ brick
				+ "','" + customer + "','" + destination + "','" + half + "');";
		Statement stmt = null;
		String errorMessage = "";
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
		} catch (Exception e) {
			errorMessage = e.getMessage();
			e.printStackTrace();
		}
		return new Object[] { result,errorMessage };

	}
	
	public Object insertCoal(String date,String amount, String rate) {
		float realAmount = Float.valueOf(amount);
		float realRate = Float.valueOf(rate);

		String query = "insert into Coal(date,amount,rate) values('"
				+ date
				+ "','"
				+ realAmount
				+ "','"
				+ realRate
				+ "');";
		Statement stmt = null;
		String errorMessage = "";
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
		} catch (Exception e) {
			errorMessage = e.getMessage();
			e.printStackTrace();
		}
		return new Object[] { result,errorMessage };

	}

	public Object insertlaboradvance(int l_id,String amount, Date date) {
		int realAmount = Integer.valueOf(amount);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = dateFormat.format(date);

		String query = "insert into LaborAdvance(l_id,amount,date) values('"
				+ l_id
				+ "','"
				+ realAmount
				+ "','"
				+ currentDate
				+ "');";
		Statement stmt = null;
		String errorMessage = "";
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
		} catch (Exception e) {
			errorMessage = e.getMessage();
			e.printStackTrace();
		}
		return new Object[] { result,errorMessage };

	}

	public Object insertleaderadvance(int le_id,String amount, Date date) {
		int realAmount = Integer.valueOf(amount);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = dateFormat.format(date);

		String query = "insert into LeaderAdvance(le_id,amount,date,u_id) values('"
				+ le_id
				+ "','"
				+ realAmount
				+ "','"
				+ currentDate
				+ "','"+LoginScreen.id+"');";
		Statement stmt = null;
		String errorMessage = "";
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
		} catch (Exception e) {
			errorMessage = e.getMessage();
			e.printStackTrace();
		}
		return new Object[] { result,errorMessage };

	}

	public Object insertcustomeradvance(int c_id,String amount, Date date) {
		int realAmount = Integer.valueOf(amount);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = dateFormat.format(date);

		String query = "insert into CustomerAdvance(c_id,amount,date,u_id) values('"
				+ c_id
				+ "','"
				+ realAmount
				+ "','"
				+ currentDate
				+ "','"+LoginScreen.id+"');";
		Statement stmt = null;
		String errorMessage = "";
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
		} catch (Exception e) {
			errorMessage = e.getMessage();
			e.printStackTrace();
		}
		return new Object[] { result,errorMessage };

	}

	public Object insertemployeeadvance(int l_id,String amount, Date date) {
		int realAmount = Integer.valueOf(amount);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = dateFormat.format(date);

		String query = "insert into EmployeeAdvance(e_id,amount,date,u_id) values('"
				+ l_id
				+ "','"
				+ realAmount
				+ "','"
				+ currentDate
				+ "','"+LoginScreen.id+"');";
		Statement stmt = null;
		String errorMessage = "";
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
		} catch (Exception e) {
			errorMessage = e.getMessage();
			e.printStackTrace();
		}
		return new Object[] { result,errorMessage };

	}

	public Object insertLandEntry(String date,String amount, String purpose) {
		float realAmount = Float.valueOf(amount);

		String query = "insert into Land(date,amount,purpose) values('"
				+ date
				+ "','"
				+ realAmount
				+ "','"
				+ purpose
				+ "');";
		Statement stmt = null;
		String errorMessage = "";
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
		} catch (Exception e) {
			errorMessage = e.getMessage();
			e.printStackTrace();
		}
		return new Object[] { result,errorMessage };

	}

	public int addNewEmployee(String name, long phone, String pAddress,
			String tAddress, String post, int salary) {
		String query = "INSERT INTO employee (E_Name,E_Type,PAddress,TAddress,Phone,Salary,u_id) values ('"
				+ name
				+ "','"
				+ post
				+ "','"
				+ pAddress
				+ "','"
				+ tAddress
				+ "','" + phone + "','" + salary + "','"+LoginScreen.id+"');";
		Statement stmt = null;
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}


	public int addBrickType(String brickType, String brickDesc,float brickRate) {
		String query = "INSERT INTO brick (brick_type,brick_desc,brick_amount) values ('"
				+ brickType + "','" + brickDesc + "','" + brickRate+ "');";
		Statement stmt = null;
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public ArrayList<LaborHelper> fetchLaborName() {
		ArrayList<LaborHelper> list = new ArrayList<LaborHelper>();
		String query = "SELECT * From labour where Remove='Delete'";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				LaborHelper labor = new LaborHelper();
				labor.id = rs.getInt("id");
				labor.name = rs.getString("name");
				labor.type = rs.getString("type");
				list.add(labor);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<LeaderHelper> fetchLeaderName() {
		ArrayList<LeaderHelper> list = new ArrayList<LeaderHelper>();
		String query = "SELECT * From leader where Remove='Delete'";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				LeaderHelper leader = new LeaderHelper();
				leader.id = rs.getInt("id");
				leader.name = rs.getString("name");
				list.add(leader);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<VehicleInfo> fetchVechileInfo() {
		ArrayList<VehicleInfo> list = new ArrayList<VehicleInfo>();
		String query = "SELECT * From vehicle";
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				VehicleInfo vehicleInfo = new VehicleInfo();
				vehicleInfo.vechileNo = rs.getString("vehicle_no");
				vehicleInfo.vechileId = rs.getInt("vechile_id");
				list.add(vehicleInfo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public int addNewVechile(String vechileNo, String vechileDesc) {
		String query = "INSERT INTO vehicle (vehicle_no,vechile_desc) values ('"
				+ vechileNo + "','" + vechileDesc + "');";
		Statement stmt = null;
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public int fetchbrickamount(int id) {
		String query = "SELECT * From labour where id = '"+id+"' ";
		Statement stmt = null;
		int value=0;
		//int result = -1;
		try {
			stmt = connection.createStatement();
			System.err.println("DatabaseHelper 517");
			ResultSet result = stmt.executeQuery(query);
			if (result.next())
			{
				 value = result.getInt("brick_amount");
				 System.err.println("pranij");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public int fetchid(int id) {
		String query = "SELECT * From labour where id = '"+id+"' ";
		Statement stmt = null;
		int value=0;
		System.err.println("databasehelper 547");
		try {
			stmt = connection.createStatement();
			System.err.println("DatabaseHelper 517");
			ResultSet result = stmt.executeQuery(query);
			if (result.next())
			{
				 value = result.getInt("id");
			}	 
			else
			{
				value = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public int condition() {
		String query = "SELECT * From mark where id = 1 ";
		Statement stmt = null;
		int value=0;
		//int result = -1;
		try {
			stmt = connection.createStatement();
			System.err.println("DatabaseHelper 517");
			ResultSet result = stmt.executeQuery(query);
			if (result.next())
			{
				 value = result.getInt("conditon");
				 System.err.println("pranij");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public long fetchLeaderMobile(int id) {
		String query = "SELECT * From leader where id = '"+id+"' ";
		Statement stmt = null;
		long value=0;
		//int result = -1;
		try {
			stmt = connection.createStatement();
			System.err.println(query);
			ResultSet result = stmt.executeQuery(query);
			if (result.next())
			{
				 value = result.getLong("mobile");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}
	
	public float fetchLeaderRate(int id) {
		String query = "SELECT * From leader where id = '"+id+"' ";
		Statement stmt = null;
		float value=0;
		//int result = -1;
		try {
			stmt = connection.createStatement();
			System.err.println(query);
			ResultSet result = stmt.executeQuery(query);
			if (result.next())
			{
				 value = result.getFloat("rate");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public long fetchLeaderTelephone(int id) {
		String query = "SELECT * From leader where id = '"+id+"' ";
		Statement stmt = null;
		long value=0;
		//int result = -1;
		try {
			stmt = connection.createStatement();
			System.err.println(query);
			ResultSet result = stmt.executeQuery(query);
			if (result.next())
			{
				 value = result.getLong("telephone");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public int fetchsalary(int id) {
		String query = "SELECT * From employee where E_id = '"+id+"' ";
		Statement stmt = null;
		int value=0;
		//int result = -1;
		try {
			stmt = connection.createStatement();
			System.err.println(query);
			ResultSet result = stmt.executeQuery(query);
			if (result.next())
			{
				 value = result.getInt("salary");
				 System.err.println("pranij");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}
	public int fetchphone(int id) {
		String query = "SELECT * From employee where E_id = '"+id+"' ";
		Statement stmt = null;
		int value=0;
		//int result = -1;
		try {
			stmt = connection.createStatement();
			System.err.println(query);
			ResultSet result = stmt.executeQuery(query);
			if (result.next())
			{
				 value = result.getInt("phone");
				 System.err.println("pranij");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public int fetchmobile(int id) {
		String query = "SELECT * From customer where id = '"+id+"' ";
		Statement stmt = null;
		int value=0;
		//int result = -1;
		try {
			stmt = connection.createStatement();
			System.err.println(query);
			ResultSet result = stmt.executeQuery(query);
			if (result.next())
			{
				 value = result.getInt("MobileNo");
				 System.err.println("pranij");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public int fetchtelephone(int id) {
		String query = "SELECT * From customer where id = '"+id+"' ";
		Statement stmt = null;
		int value=0;
		//int result = -1;
		try {
			stmt = connection.createStatement();
			System.err.println(query);
			ResultSet result = stmt.executeQuery(query);
			if (result.next())
			{
				 value = result.getInt("TelephoneNo");
				 System.err.println("pranij");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public int insertLabour(String name, String type, String brick) {
		if (type == "Patheri") {
			brick = "0";
		}
		String query = "insert into labour(name,type,brick_amount,u_id ) values('"
				+ name + "','" + type + "','" + Integer.valueOf(brick) + "','"+LoginScreen.id+"');";
		Statement stmt = null;
		int result = -1;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insertWorkEntry(int labourId, int brickID, int noOfBrick,
			float amount, String date) {

		String query = "insert into labour_transcation(l_id,bd_id,Number,Amount,transcation_date,u_id) values('"
				+ labourId
				+ "','"
				+ brickID
				+ "','"
				+ noOfBrick
				+ "','"
				+ amount + "','" + date + "','"+LoginScreen.id+"');";
		int result = -1;
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int insertabsent(int e_id, Date date , int absent, int leave, String reason) {
System.err.println(date);
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
String currentDate = dateFormat.format(date);
		String query = "insert into attendance(`E_id`,`Date`,`Absent`,`Leaves`,`Reason`,`u_id`) values('"+e_id+"','"+currentDate+"','"+absent+"','"+leave+"','"+reason+"','"+LoginScreen.id+"');";
		int result = -1;
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insertCustomer(String name,String pAddress,String tAddress,int Mobile,int Telephone)
	{
		
		String query="insert into customer(name,PAddress,TAddress,MobileNo,TelephoneNo,u_id ) values('"+name+"','"+pAddress+"','"+tAddress+"','"+Mobile+"','"+Telephone+"','"+LoginScreen.id+"');";
		Statement stmt = null;
		int result =-1;
		try {
			stmt=connection.createStatement();
			result= stmt.executeUpdate(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<CustomerHelper> getCustomer() {

		ArrayList<CustomerHelper> list = new ArrayList<CustomerHelper>();
		String query = "SELECT * From customer";
		try {
		pst = connection.prepareStatement(query);
		rs = pst.executeQuery();
		while (rs.next()) {
		CustomerHelper customerInfo = new CustomerHelper();
		customerInfo.id = rs.getInt("id");
		customerInfo.name = rs.getString("name");
		list.add(customerInfo);
		}
		} catch (SQLException e) {

		e.printStackTrace();
		}
		return list;

		}
	
	public int insertOrderEntry( int cust_id, String destination,
			int noOfBrick, int halfBrick) {
			String query = "insert into order_entry(customer_id,destination,no_of_brick,no_of_halfbrick ) values('"
			+ cust_id
			+ "','"
			+ destination
			+ "','"
			+ noOfBrick
			+ "','"
			+ halfBrick + "');";
			Statement stmt = null;
			int result = -1;
			try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
			} catch (Exception e) {
			e.printStackTrace();
			}
			return result;
			}
	
	public int insertleader(String name,String address,String mobile,String telephone,String rate) {
			
			long m = 0;
			long phone = 0;
			float r =0;
			if (!telephone.trim().isEmpty())
			{
			phone = Long.parseLong(telephone);
			}
			if (!mobile.trim().isEmpty())
			{
			m = Long.parseLong(mobile);
			}
			if (!rate.trim().isEmpty())
			{
			r = Float.parseFloat(rate);
			}
			String query = "insert into leader(name,address,mobile,telephone,rate,u_id) values('"
			+ name
			+ "','"
			+ address
			+ "','"
			+ m
			+ "','"
			+ phone + "','"
			+ r+ "','"+LoginScreen.id+"');";
			Statement stmt = null;
			int result = -1;
			try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			return result;
			} catch (Exception e) {
			e.printStackTrace();
			}
			return result;
			}


	public float getRate(String type, int brickId) {
		float rate = -1;
		String query = "SELECT brick_distance_amount From brick_distance where Distance_Type='"
				+ type+"'" +"and brick_id='"+brickId+"'" ;
		try {
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()){
				rate = rs.getFloat("brick_distance_amount");
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println(rate);
		return rate;

	}
	
	public  void updatelabour(int id,String name,String type, int bamount) {
		String query = "UPDATE labour SET name = '"+name+"', brick_amount ='"+bamount+"',u_id='"+LoginScreen.id+"' WHERE id ='"+id+"'";
			Statement stmt = null;
			int result = -1;
			try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			} catch (Exception e) {
			e.printStackTrace();
			}


	}
	
	public  void updatelabour(int id) {
		String query = "UPDATE labour SET Remove = 'Remove' WHERE id ='"+id+"'";
			Statement stmt = null;
			int result = -1;
			try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			} catch (Exception e) {
			e.printStackTrace();
			}


	}

	public  void updateLeader(int id) {
		String query = "UPDATE leader SET Remove = 'Remove' WHERE id ='"+id+"'";
			Statement stmt = null;
			int result = -1;
			try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			} catch (Exception e) {
			e.printStackTrace();
			}


	}

	public  void updatecustomer(int id) {
		String query = "UPDATE customer SET Remove = 'Remove' WHERE id ='"+id+"'";
			Statement stmt = null;
			int result = -1;
			try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			} catch (Exception e) {
			e.printStackTrace();
			}


	}

	public  void updateemployee(int id) {
		String query = "UPDATE employee SET Remove = 'Remove' WHERE E_id ='"+id+"'";
			Statement stmt = null;
			int result = -1;
			try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			} catch (Exception e) {
			e.printStackTrace();
			}


	}


	public  void updateleader(int id,String name,String address, String mobile,String telephone,float rate) {
		String query = "UPDATE leader SET name = '"+name+"', address ='"+address+"', mobile ='"+mobile+"', telephone ='"+telephone+"', rate ='"+rate+"',u_id='"+LoginScreen.id+"' WHERE id='"+id+"'";
			Statement stmt = null;
			int result = -1;
			try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			} catch (Exception e) {
			e.printStackTrace();
			}


	}

	public  void updateemployee(int id,String name,String type, String paddress,String taddress,int salary,int phone) {
		String query = "UPDATE employee SET E_Name = '"+name+"', E_Type ='"+type+"', PAddress ='"+paddress+"', TAddress ='"+taddress+"', Salary ='"+salary+"', Phone ='"+phone+"',u_id='"+LoginScreen.id+"' WHERE E_id ='"+id+"'";
			Statement stmt = null;
			int result = -1;
			try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			} catch (Exception e) {
			e.printStackTrace();
			}


	}

	public  void updatecustomer(int id,String name,String paddress,String taddress,long mobile,long telephone) {
		String query = "UPDATE customer SET name = '"+name+"', PAddress ='"+paddress+"', TAddress ='"+taddress+"', MobileNo ='"+mobile+"', TelephoneNo ='"+telephone+"',u_id='"+LoginScreen.id+"' WHERE id ='"+id+"'";
			Statement stmt = null;
			int result = -1;
			try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(query);
			} catch (Exception e) {
			e.printStackTrace();
			}


	}

}

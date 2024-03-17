package com.empmanagement.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.empmanagement.bean.DisplayResponceBean;
import com.empmanagement.bean.UpdateBean;
import com.empmanagement.form.ComplaintsForm;
import com.empmanagement.form.DeactivateForm;
import com.empmanagement.form.EmpComplaintResponceForm;
import com.empmanagement.form.EmployeeUpdateForm;
import com.empmanagement.form.ForgetPasswordForm;
import com.empmanagement.form.LoginForm;
import com.empmanagement.form.RegistrationForm;
import com.empmanagement.form.ResetPasswordForm;
import com.empmanagement.form.TimeSheetForm;
import com.empmanagement.form.TrackComplaintsForm;

public class DataAccessManager {

	private final static String className = "DataAccessManager";
	private final static String HRDLOGINTYPE = "hrd";
	private final static String EMPLOGINTYPE = "emp";
	private final static String YES = "yes";
	private final static String NO = "no";
	private final static boolean FALSE = false;
	private final static boolean TRUE = true;

	public static Connection getConnection() {
		String methodName = "getConnection";
		System.out.println(className + " --> " + methodName + " --> START");
		Connection con = null;
		try {
			System.out.println(className + " --> " + methodName + " CONNECTION " + con);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger");
			System.out.println(className + " --> " + methodName + " CONNECTION " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END");
		return con;

		// try {
		// Context initCtx = new InitialContext();
		// Context envCtx = (Context) initCtx.lookup("java:comp/env");
		// DataSource ds = (DataSource) envCtx.lookup("jdbc/MyDataSource");
		// con = ds.getConnection();
		//
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return con;

	}

	public int setEmployeeDetails(RegistrationForm rForm) {
		String methodName = "setEmployeeDetails";
		System.out.println(className + " --> " + methodName + " --> START");
		Connection con = null;
		int empID = 0;
		int out = 0;
		int hrd = 0;
		try {

			con = DataAccessManager.getConnection();
			con.setAutoCommit(false);
			Statement stm = con.createStatement();
			System.out.println(className + " --> " + methodName + " --> SELECT EMP ID START");
			ResultSet result = stm.executeQuery("select max(empId) from em_master");
			System.out.println(className + " --> " + methodName + rForm.getEmpName() + " --> START");
			while (result.next()) {
				empID = result.getInt(1);
			}
			System.out.println(className + " --> " + methodName + " --> EMPID SELECTED " + empID);
			System.out.println(className + " --> " + methodName + " --> INSERT MASTER DATA");
			PreparedStatement ps = con
					.prepareStatement("insert into em_master values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			int maxId = empID + 1;
			System.out.println(className + " --> " + methodName + " --> NEW EMPID  " + maxId);
			ps.setInt(1, maxId);
			ps.setString(2, rForm.getEmpName());
			ps.setLong(3, rForm.getEmpAadhaarNumber());
			ps.setString(4, rForm.getEmpPermCity());
			ps.setLong(5, rForm.getEmpPermPincode());
			ps.setString(6, rForm.getEmpCurrentCity());
			ps.setLong(7, rForm.getEmpCurrentPincode());
			ps.setLong(8, rForm.getEmpMobile());
			ps.setString(9, rForm.getEmpEmail());
			ps.setString(10, rForm.getEmpBloodGroup());
			ps.setString(11, StringUtil.giveDateFormat(rForm.getEmpJoinDate()));
			ps.setString(12, StringUtil.giveDateFormat(rForm.getEmpDOB()));
			ps.setString(13, rForm.getEmpDepartment());
			ps.setString(14, rForm.getEmpDesignation());
			ps.setLong(15, rForm.getEmpBankAccountNumber());
			ps.setString(16, rForm.getEmpBankName());
			ps.setString(17, rForm.getEmpIFSCCode());
			ps.setString(18, rForm.getEmpGender());
			ps.setString(19, rForm.getEmpLevel());
			ps.setString(20, rForm.getEmpManager());
			ps.setString(21, rForm.getEmpType());
			ps.setString(22, "ACT");
			int master = ps.executeUpdate();
			System.out.println(className + " --> " + methodName + " --> MASTER DATA INSERTED");
			System.out.println(className + " --> " + methodName + " --> ADDRESS DATA START");
			PreparedStatement psAddress = con.prepareStatement("insert into em_address values(?,?,?,?,?,?,?,?,?)");
			psAddress.setInt(1, (empID + 1));
			psAddress.setString(2, rForm.getEmpPermAddressLine1());
			psAddress.setString(3, rForm.getEmpPermAddressLine2());
			psAddress.setString(4, rForm.getEmpPermCity());
			psAddress.setLong(5, rForm.getEmpPermPincode());
			psAddress.setString(6, rForm.getEmpCurrentAddressLine1());
			psAddress.setString(7, rForm.getEmpCurrentAddressLine1());
			psAddress.setString(8, rForm.getEmpCurrentAddressLine1());
			psAddress.setLong(9, rForm.getEmpCurrentPincode());
			int address = psAddress.executeUpdate();
			System.out.println(className + " --> " + methodName + " --> ADDRESS DATA END & LOGIN DATA START");
			PreparedStatement psIDPass = con.prepareStatement("insert into em_login values(?,?)");
			psIDPass.setInt(1, (empID + 1));
			psIDPass.setString(2, StringUtil.password(rForm.getEmpDOB()));
			int login = psIDPass.executeUpdate();
			System.out.println(className + " --> " + methodName + " --> LOGIN END" + login);

			if (rForm.getEmpType().equals(YES)) {
				System.out.println(className + " --> " + methodName + " --> HRD LOGIN STARTED )" + empID);
				PreparedStatement psHRD = con.prepareStatement("insert into em_hrdlogin values(?,?)");
				psHRD.setInt(1, (empID + 1));
				psHRD.setString(2, StringUtil.password(rForm.getEmpDOB()));
				hrd = psHRD.executeUpdate();
				System.out.println(className + " --> " + methodName + " --> HRD LOGIN END " + hrd);
			}

			if (rForm.getEmpType().equals(YES)) {
				if ((master != 0) && (address != 0) && (login != 0) && (hrd != 0)) {
					con.commit();
					out = empID;
				} else {
					con.rollback();
					out = 0;
				}
			} else if (rForm.getEmpType().equals(NO)) {
				if ((master != 0) && (address != 0) && (login != 0)) {
					con.commit();
					out = empID + 1;
				} else {
					con.rollback();
					out = 0;
				}
			} else {
				con.rollback();
				out = 0;
			}

		} catch (SQLException s) {
			System.out.println(className + " --> " + methodName + " --> ERROR " + s.getMessage());
			return 99;
		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> ERROR " + out + " " + 55);
			e.printStackTrace();
			return 55;
		}
		System.out.println(className + " --> " + methodName + " --> END");
		return out;
	}

	public DisplayResponceBean showEmpDetails(int empID) {
		String methodName = "showEmpDetails";
		System.out.println(className + " --> " + methodName + " --> START");
		DisplayResponceBean displayBean = new DisplayResponceBean();
		Connection con = null;
		try {

			con = DataAccessManager.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"select empName,empPermCity,empCurrentCity,empEmail,empMobile,empDesignation, empdepartment, empJoinDate, empGender,EMPSTATUS from em_master where empId=?");
			ps.setInt(1, empID);
			ResultSet result = ps.executeQuery();
			displayBean.setEmpID(empID);
			while (result.next()) {

				displayBean.setEmpName(result.getString(1));
				displayBean.setEmpPermCity(result.getString(2));
				displayBean.setEmpCurrentCity(result.getString(3));
				displayBean.setEmpEmail(result.getString(4));
				displayBean.setEmpMobile(result.getLong(5));
				displayBean.setEmpDesignation(result.getString(6));
				displayBean.setEmpDepartmant(result.getString(7));
				displayBean.setEmpJoinDate(result.getString(8));
				displayBean.setEmpGender(result.getString(9));
				displayBean.setEmpStatus(result.getString(10));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END");
		System.out.println("displayBean ===> " + displayBean);
		return displayBean;
	}

	public int insertTimeSheet(TimeSheetForm timeSheet) {
		String methodName = "insertTimeSheet";
		System.out.println(className + " --> " + methodName + " --> START");
		int result = 0;
		Connection con = null;

		try {
			con = DataAccessManager.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into em_timesheet values(?,?,?,?)");
			ps.setInt(1, timeSheet.getEmpID());
			ps.setString(2, StringUtil.giveDateFormat(timeSheet.getTimeSheetDate()));
			ps.setString(3, timeSheet.getTaskName());
			ps.setString(4, timeSheet.getTaskDescription());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END");
		return result;
	}

	public long insertComplaint(ComplaintsForm complaintBean) {
		String methodName = "insertComplaint";
		System.out.println(className + " --> " + methodName + " --> START");
		int result = 0;
		Connection con = null;
		long complaintID = 0;
		try {
			con = DataAccessManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select max(COMPLAINTID) from em_complaints");
			while (rs.next()) {
				complaintID = rs.getInt(1) + 1;
			}
			System.out.println(className + " --->" + methodName + "--->" + complaintID);
			PreparedStatement ps = con.prepareStatement("insert into em_complaints values(?,?,?,?,?,?,?)");
			ps.setLong(1, complaintID);
			ps.setInt(2, complaintBean.getEmpID());
			ps.setString(3, complaintBean.getComplaints());
			ps.setString(4, "pending");
			ps.setString(5, "pending");
			ps.setString(6, "");
			ps.setString(7, "NO");
			result = ps.executeUpdate();
			System.out.println(className + " " + methodName + " RESULT " + result);
			if (result == 0) {
				complaintID = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END");
		return complaintID;
	}

	public boolean checkLogin(LoginForm loginForm) {
		boolean returnValue = false;
		Connection con = null;
		String methodName = "checkLogin";
		System.out.println(className + " --> " + methodName + loginForm.getPassword() + " --> START");

		try {
			con = DataAccessManager.getConnection();

			if (loginForm.getLoginType().equals(EMPLOGINTYPE)) {
				PreparedStatement ps = con.prepareStatement("select password from em_login where empID=?");
				ps.setInt(1, loginForm.getEmpID());
				ResultSet rs = ps.executeQuery();
				// PreparedStatement ps1 = con.prepareStatement("select empstatus from em_master
				// where empID=?");
				// ps1.setInt(1, loginForm.getEmpID());
				// ResultSet rs1 = ps.executeQuery();

				// while(rs1.next())
				// {
				while (rs.next()) {
					String password = rs.getString(1);
					System.out.println(className + methodName + "---> " + password);
					if (password.equals(loginForm.getPassword()) /* && STATUS.equals(rs1.getString(1)) */) {
						return true;
					} else {
						return false;
					}
				}
			}
			// }

			else if (loginForm.getLoginType().equals(HRDLOGINTYPE)) {
				PreparedStatement ps = con.prepareStatement("select password from em_hrdlogin where empID=?");
				ps.setInt(1, loginForm.getEmpID());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String password = rs.getString(1);
					System.out.println(className + methodName + "---> " + password);
					if (password.equals(loginForm.getPassword())) {
						return true;
					} else {
						return false;
					}
				}
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END");
		return returnValue;
	}

	public void insertTracking(int empID) {
		Connection con = null;
		String methodName = "insertTracking";
		System.out.println(className + " --> " + methodName + " --> START");

		try {
			con = DataAccessManager.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into em_logindetails values(?,(select sysdate from dual))");
			ps.setInt(1, empID);
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> ERROR");
			System.out.println(e.getMessage());
		}

	}

	public boolean deactiveEmployee(DeactivateForm dForm) {
		Connection con = null;
		String methodName = "deactiveEmployee";
		System.out.println(className + " --> " + methodName + " --> START");
		int out = 0;
		try {
			con = DataAccessManager.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("update em_master set empstatus = 'INA' where empId=?");
			ps.setInt(1, dForm.getEmpID());
			out = ps.executeUpdate();
			System.out.println(className + " --> " + methodName + " --> 1ST QUERY END " + out);
			if (out != 0) {
				PreparedStatement ps1 = con.prepareStatement("insert into em_empdeactivate values(?,?,?)");
				ps1.setInt(1, dForm.getEmpID());
				ps1.setString(2, dForm.getReason());
				ps1.setString(3, "INA");
				out = ps1.executeUpdate();
				System.out.println(className + " --> " + methodName + " --> 2ND QUERY ENDED " + out);
			}
			if (out != 0) {
				PreparedStatement ps2 = con.prepareStatement("delete from em_login where empId=?");
				ps2.setInt(1, dForm.getEmpID());
				out = ps2.executeUpdate();

				if (out != 0) {
					con.commit();
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> ERROR");
			e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END " + out);
		return false;
	}

	public UpdateBean getEmpDetails(int empID) {
		Connection con = null;
		String methodName = "getEmpDetails";
		System.out.println(className + " --> " + methodName + " --> START");
		UpdateBean ub = new UpdateBean();
		try {
			con = DataAccessManager.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps1 = con.prepareStatement("select * from em_master where empid=?");
			ps1.setInt(1, empID);
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				ub.setEmpID(rs.getInt(1));
				ub.setEmpName(rs.getString(2));
				ub.setEmpAadhaarNumber(rs.getLong(3));
				ub.setEmpPermCity(rs.getString(4));
				ub.setEmpPermPincode(rs.getLong(5));
				ub.setEmpCurrentCity(rs.getString(6));
				ub.setEmpCurrentPincode(rs.getLong(7));
				ub.setEmpMobile(rs.getLong(8));
				ub.setEmpEmail(rs.getString(9));
				ub.setEmpBloodGroup(rs.getString(10));
				ub.setEmpJoinDate(rs.getString(11));
				ub.setEmpDOB(rs.getString(12));
				ub.setEmpDepartment(rs.getString(13));
				ub.setEmpDesignation(rs.getString(14));
				ub.setEmpBankAccountNumber(rs.getLong(15));
				ub.setEmpBankName(rs.getString(16));
				ub.setEmpIFSCCode(rs.getString(17));
				ub.setEmpGender(rs.getString(18));
				ub.setEmpLevel(rs.getString(19));
				ub.setEmpManager(rs.getString(20));
				ub.setEmpType(rs.getString(21));
				System.out.println(StringUtil.giveDateFormat(rs.getString(11)) + "  "
						+ StringUtil.giveDateFormat(rs.getString(12)));
			}
			PreparedStatement ps2 = con.prepareStatement("select * from em_address where empID=?");
			ps2.setInt(1, empID);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				ub.setEmpPermAddressLine1(rs2.getString(2));
				ub.setEmpPermAddressLine2(rs2.getString(3));
				ub.setEmpCurrentAddressLine1(rs2.getString(6));
				ub.setEmpCurrentAddressLine2(rs2.getString(7));
			}

		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> ERROR");
			e.printStackTrace();
		}

		System.out.println(className + " --> " + methodName + " --> END " + ub);
		return ub;

	}

	public boolean updateEmployeeDetails(EmployeeUpdateForm reg) {
		boolean out = FALSE;
		Connection con = null;
		String methodName = "updateEmployeeDetails";
		System.out.println(className + " --> " + methodName + " --> START");
		UpdateBean ub = new UpdateBean();
		int out3 = 0;
		try {
			if (reg == null) {
				System.out.println(className + methodName + "reg is NULL ");
			}
			con = DataAccessManager.getConnection();
			con.setAutoCommit(false);
			System.out.println("Enter in first update");
			PreparedStatement ps = con.prepareStatement(
					"update em_master set EMPNAME=?, EMPAADHAAR=?, EMPPERMCITY=?,EMPPERMPINCODE=?, EMPCURRENTCITY=?, EMPCURRENTPINCODE=?, EMPMOBILE=?, EMPEMAIL=?, EMPBLOODGROUP=?, EMPJOINDATE=?, EMPDOB=?, EMPDEPARTMENT=?, EMPDESIGNATION=?, EMPBANKACCOUNTNUMBER=?, EMPBANKNAME=?, EMPIFSCCODE=?, EMPGENDER=?, EMPLEVEL=?, HRDOREMP=?, EMPMANAGER=? where empID=?");
			ps.setString(1, reg.getEmpName());
			ps.setLong(2, reg.getEmpAadhaarNumber());
			System.out.println(reg.getEmpAadhaarNumber());
			ps.setString(3, reg.getEmpPermCity());
			System.out.println(reg.getEmpPermCity());
			ps.setLong(4, reg.getEmpPermPincode());
			System.out.println(reg.getEmpPermPincode());
			ps.setString(5, reg.getEmpCurrentCity());
			ps.setLong(6, reg.getEmpCurrentPincode());
			ps.setLong(7, reg.getEmpMobile());
			ps.setString(8, reg.getEmpEmail());
			ps.setString(9, reg.getEmpBloodGroup());
			ps.setString(10, StringUtil.giveDateFormat(reg.getEmpJoinDate()));
			ps.setString(11, StringUtil.giveDateFormat(reg.getEmpDOB()));
			ps.setString(12, reg.getEmpDepartment());
			ps.setString(13, reg.getEmpDesignation());
			ps.setLong(14, reg.getEmpBankAccountNumber());
			ps.setString(15, reg.getEmpBankName());
			ps.setString(16, reg.getEmpIFSCCode());
			ps.setString(17, reg.getEmpGender());
			ps.setString(18, reg.getEmpLevel());
			ps.setString(19, reg.getEmpType());
			ps.setString(20, reg.getEmpManager());
			ps.setInt(21, reg.getEmpID());
			System.out.println(reg.getEmpID() + reg.getEmpName() + "  " + reg.getEmpDOB() + " " + reg.getEmpJoinDate());
			int out1 = ps.executeUpdate();
			System.out.println("End of first update and start of second " + out1);
			PreparedStatement ps1 = con.prepareStatement(
					"update em_address set PERMADDRESSLINE2=?, PERMCITY=?,CURRENTPINCODE=?,CURRENTADDRESSLINE1=?,CURRENTADDRESSLINE2=?,CURRENTCITY=?,PERMADDRESSLINE1=?,PERMPINCODE=? where empID=?");
			ps1.setString(1, reg.getEmpPermAddressLine2());
			ps1.setString(2, reg.getEmpPermCity());
			ps1.setLong(3, reg.getEmpCurrentPincode());
			ps1.setString(4, reg.getEmpCurrentAddressLine1());
			ps1.setString(5, reg.getEmpCurrentAddressLine2());
			ps1.setString(6, reg.getEmpCurrentCity());
			ps1.setString(7, reg.getEmpPermAddressLine1());
			ps1.setLong(8, reg.getEmpPermPincode());
			ps1.setLong(9, reg.getEmpID());
			int out2 = ps1.executeUpdate();
			System.out.println("End of second update " + out2);
			if (reg.getEmpType().equals(YES)) {
				System.out.println(className + " --> " + methodName + " --> HRD LOGIN STARTED )" + reg.getEmpID());
				PreparedStatement psHRD = con.prepareStatement("insert into em_hrdlogin values(?,?)");
				psHRD.setInt(1, (reg.getEmpID()));
				psHRD.setString(2, StringUtil.password(reg.getEmpDOB()));
				out3 = psHRD.executeUpdate();
				System.out.println(className + " --> " + methodName + " --> HRD LOGIN END " + out3);
			}
			if (reg.getEmpType().equals(YES)) {
				if (out1 != 0 && out2 != 0 && out3 != 0) {
					con.commit();
					System.out.println(className + " " + methodName + " SUCCESS " + out1 + " & " + out2);
					out = TRUE;
				}
			} else if (reg.getEmpType().equals(NO)) {
				if (out1 != 0 && out2 != 0) {
					con.commit();
					System.out.println(className + " " + methodName + " SUCCESS " + out1 + " & " + out2);
					out = TRUE;
				}
			} else {
				con.rollback();
				System.out.println(className + " " + methodName + " FAIL " + out1 + " & " + out2);
				out = FALSE;
			}
		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> ERROR");
			e.printStackTrace();
		}

		System.out.println(className + " --> " + methodName + " --> END " + ub);
		return out;
	}

	public int resetPassword(ResetPasswordForm rpForm) {

		Connection con = null;
		String methodName = "updateEmployeeDetails";
		System.out.println(className + " --> " + methodName + " --> START");
		UpdateBean ub = new UpdateBean();
		int out1 = 0;

		try {
			con = DataAccessManager.getConnection();
			PreparedStatement ps = con.prepareStatement("select password from em_login where empID=?");
			ps.setInt(1, rpForm.getEmpID());
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					if ((rs.getString(1).equals(rpForm.getOldPassword()))) {
						PreparedStatement ps1 = con.prepareStatement("update em_login set password=? where empID=?");
						ps1.setString(1, rpForm.getNewPassword());
						ps1.setInt(2, rpForm.getEmpID());
						out1 = ps1.executeUpdate();
					}
				}
			} else {
				return out1 = 0;
			}

		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> ERROR");
			e.printStackTrace();
		}

		System.out.println(className + " --> " + methodName + " --> END " + ub);
		return out1;
	}

	public TrackComplaintsForm showComplaints(TrackComplaintsForm track) {
		Connection con = null;
		String methodName = "showComplaints";
		System.out.println(className + " --> " + methodName + " --> START");
		ResultSet rs = null;

		TrackComplaintsForm tcForm = new TrackComplaintsForm();
		try {
			con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from em_complaints where complaintID=?");
			ps.setLong(1, track.getComplaintID());
			rs = ps.executeQuery();
			while (rs.next()) {
				tcForm.setComplaintID(rs.getLong(1));
				tcForm.setEmpID(rs.getInt(2));
				tcForm.setComplaints(rs.getString(3));
				tcForm.setComments(rs.getString(5));
				tcForm.setStatus(rs.getString(4));
				tcForm.setEmpComment(rs.getString(6));
				tcForm.setEmpComplaintResponce(rs.getString(7));
			}

		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> ERROR");
			e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END " + rs);
		return tcForm;
	}

	public ResultSet showComplaintsToHRD() {
		Connection con = null;
		String methodName = "showComplaintsToHRD";
		System.out.println(className + " --> " + methodName + " --> START");
		ResultSet rs = null;
		try {
			con = getConnection();
			Statement stm = con.createStatement();
			rs = stm.executeQuery("select * from em_complaints where status='pending'");

		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> ERROR");
			e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END " + rs);
		return rs;
	}

	public boolean insertComplaintsResponse(TrackComplaintsForm track) {

		Connection con = null;
		String methodName = "insertComplaintsResponse";
		System.out.println(className + " --> " + methodName + " --> START");
		int out = 0;
		try {
			con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("update em_complaints set status='Resolved',comments=? where complaintID=?");
			System.out.println(className + " --> " + methodName + " -->  track.getComplaintAction()"
					+ track.getComplaintAction() + " track.getComplaintID()" + track.getComplaintID());
			ps.setString(1, track.getComplaintAction());
			ps.setLong(2, track.getComplaintID());

			out = ps.executeUpdate();
			if (out != 0) {
				System.out.println(className + " --> " + methodName + " -->  " + out);
				return TRUE;
			} else {
				System.out.println(className + " --> " + methodName + " -->  " + out);
				return FALSE;
			}
		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> ERROR");
			e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END " + out);
		return FALSE;
	}

	public int insertEmpComplaintResponce(EmpComplaintResponceForm empCompResForm) {
		Connection con = null;
		String methodName = "insertEmpComplaintResponce";
		System.out.println(className + " --> " + methodName + " --> START");
		// String queryYes = "update em_complaints set EmployeeComment=? ,
		// ResolvedORNot=? where complaintID=?";
		// String queryNo = "update em_complaints set status='pending',EmployeeComment=?
		// , ResolvedORNot=? where complaintID=?";
		PreparedStatement ps = null;
		int out = 0;
		try {
			con = getConnection();
			System.out
			.println(className + " --> " + methodName + " --> COMPLAINT ID " + empCompResForm.getComplaintID());
			System.out.println(className + " --> " + methodName + " --> ps" + ps);
			if (empCompResForm.getEmpComplaintResponce().equals("YES")) {
				ps = con.prepareStatement(
						"update em_complaints set status='Resolved', EmployeeComment=? , ResolvedORNot=? where complaintID=?");
				System.out.println(className + " --> " + methodName + " YES --> ps" + ps);
				ps.setString(1, "Resolved");
			} else {
				ps = con.prepareStatement(
						"update em_complaints set status='pending',EmployeeComment=? , ResolvedORNot=? where complaintID=?");
				System.out.println(className + " --> " + methodName + " --> YES ps" + ps);
				ps.setString(1, empCompResForm.getEmpComment());
			}
			System.out.println(empCompResForm.getEmpComment() + " " + empCompResForm.getEmpComplaintResponce());
			ps.setString(2, empCompResForm.getEmpComplaintResponce());
			ps.setLong(3, empCompResForm.getComplaintID());
			out = ps.executeUpdate();
			System.out.println(className + " --> " + methodName + " --> out" + out);
		} catch (Exception e) {
			e.printStackTrace();
			return out = 55;
		}
		return out;
	}

	public boolean validateAadhaarNumber(long empAadharNumber) {
		Connection con = null;
		String methodName = "validateAadhaarNumber";
		System.out.println(className + " --> " + methodName + " --> START");
		PreparedStatement ps = null;
		boolean out = false;
		try {
			con = getConnection();
			System.out.println(className + " --> " + methodName + " --> ");
			System.out.println(className + " --> " + methodName + " --> ps" + ps);
			ps = con.prepareStatement("select EMPAADHAAR from em_master where EMPAADHAAR = ?");
			ps.setLong(1, empAadharNumber);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				long aadhaar = rs.getLong(1);
				System.out.println(aadhaar);
				if (aadhaar != 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return out;
		}
		return out;
	}

	public String checkPassword(int empID) {
		Connection con = null;
		String methodName = "checkPassword";
		System.out.println(className + " --> " + methodName + " --> START");
		PreparedStatement ps = null;
		String out = null;
		try {
			con = getConnection();
			System.out.println(className + " --> " + methodName + " --> ");
			System.out.println(className + " --> " + methodName + " --> ps" + ps);
			ps = con.prepareStatement("select PASSWORD from em_login where empID = ?");
			ps.setLong(1, empID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				out = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return out;
		}
		return out;
	}

	public boolean forgetPassword(ForgetPasswordForm form) {
		Connection con = null;
		String methodName = "forgetPassword";
		System.out.println(className + " --> " + methodName + " --> START");
		PreparedStatement ps = null;
		boolean out = false;
		try {
			con = getConnection();
			System.out.println(className + " --> " + methodName + " --> IN TRY ");
			ps = con.prepareStatement("select EMPMOBILE , EMPAADHAAR from em_Master where empID=?");
			ps.setInt(1, form.getEmpID());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (form.getEmpMobile() == rs.getLong(1) && form.getEmpAadhaarNumber() == rs.getLong(2)) {
					System.out.println(className + " " + methodName + " ");
					PreparedStatement ps1 = null;
					if (form.getLoginType().equals("hrd")) {
						ps1 = con.prepareStatement("update em_hrdlogin set password=? where empID = ?");
					} else {
						ps1 = con.prepareStatement("update em_login set password=? where empID = ?");
					}
					ps1.setString(1, form.getEmpNewPassword());
					ps1.setInt(2, form.getEmpID());

					if (ps1.executeUpdate() != 0) {
						out = true;
						System.out.println(className + " " + methodName + " SUCCESS " + out);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(className + " " + methodName + " ERROR " + out);
			return out;
		}
		return out;
	}
}

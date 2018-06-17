package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Controller.MailerCustomerId;
import com.Model.KnowCustomerIDBean;


public class KnowCustomerIDDao {
	static Connection currentCon = null;

	public static void knowCustomerid(KnowCustomerIDBean bean) {
		String email = null;
		int customerid = 0;
		int account_number = bean.getAccountNumber();

		String sql1 = "select customer_id from accountdata where account_number=" + account_number;
		System.out.println("In Dao "+account_number);
		try {
			currentCon = DbHelperS.getConnection();
			Statement s = currentCon.createStatement();
			ResultSet r = s.executeQuery(sql1);
			if (r.next()) {
				bean.setCustomerId(r.getInt("customer_id"));
				customerid = bean.getCustomerId();
				System.out.println("In Dao cust"+customerid);
			
				
			}
			r.close();
			String sql = "select email from customerprofile where customerid=" + customerid;
			ResultSet r1 = s.executeQuery(sql);
			if (r1.next()) {
				email = r1.getString("email");
				System.out.println(email);
			}
			r1.close();
			System.out.println("in Dao");
			String msg = Integer.toString(customerid);
			MailerCustomerId.send("wellsteam04@gmail.com", "wellsteam4", email, "Your Customer ID", msg);
			// RegisterCustomerBean bean= new RegisterCustomerBean();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

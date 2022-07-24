package com.foodbox.model;

import java.sql.*;

import com.foodbox.entities.PurchasedRecord;
import com.foodbox.helper.DbConnectionProvider;

public class PurchasedRecordDao {

	public static long nextPk() {
		long pk = 0;
		Connection conn;
		try {
			conn = DbConnectionProvider.getCon();
			PreparedStatement stmt = conn.prepareStatement("select Max(id_Purchase) from purchasedrecord");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pk = rs.getLong(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pk + 1;

	}

	public static long addPurchasedRecord(PurchasedRecord record) {
		int i = 0;
		try {
			Connection conn = DbConnectionProvider.getCon();
			PreparedStatement stmt = conn.prepareStatement("insert into purchasedrecord values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setLong(1, nextPk());

			stmt.setString(2, record.getPurchase_User());
			stmt.setString(3, record.getPurchase_UserEmail());
			stmt.setString(4, record.getPurchase_UserContact());
			stmt.setString(5, record.getPurchase_UserShippingAddress());
			stmt.setString(6, record.getPurchase_Date());
			stmt.setString(7, record.getPurchase_Category());
			stmt.setString(8, record.getPurchase_DeliveryStatus());
			stmt.setString(9, record.getPurchase_PaymentMode());
			stmt.setString(10, record.getPurchase_TotalAmount());
			stmt.setString(11, record.getPurchase_ExpectedMinutesForDelivery());

			i = stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}

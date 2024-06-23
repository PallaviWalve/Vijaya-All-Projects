package com.chargingstation;

public class getset
{
	static String status;
	static int uid;
	static int cid;
	static int power;
	
	public static int getPower() {
		return power;
	}
	public static void setPower(int power) {
		getset.power = power;
	}
	public static String getStatus() {
		return status;
	}
	public static void setStatus(String status) {
		getset.status = status;
	}
	public static int getCid() {
		return cid;
	}
	public static void setCid(int cid) {
		getset.cid = cid;
	}
	public static int getUid() {
		return uid;
	}
	public static void setUid(int uid) {
		getset.uid = uid;
	}
	
}

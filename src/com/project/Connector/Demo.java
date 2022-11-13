package com.project.Connector;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {


		Connection conn= DButil.provideConnection();
		
		System.out.println(conn);

	}

}

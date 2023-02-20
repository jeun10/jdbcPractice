package com.ssamz.test;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class StartTomcat {

	public static void main(String[] args) throws LifecycleException {
		// TODO Auto-generated method stub
		Tomcat server = new Tomcat();
		server.start();
		String a=null;
	}

}

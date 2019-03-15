package LD;

import java.sql.*;

import static LD.clsConstantesDB.DRIVER;
import static LD.clsConstantesDB.PASS;
import static LD.clsConstantesDB.SCHEMA;
import static LD.clsConstantesDB.URL;
import static LD.clsConstantesDB.USER;
import static LD.clsConstantesDB.TIME;

import static LD.clsConstantesDB.SQL_INSERT_ALUMNO;



public class clsDatos 
{
	public void Connect()
	{
		try
		{
			Class.forName(DRIVER).newInstance();
			conn = DriverManager
		}
	}
}

package Model;

import java.sql.ResultSet;

abstract class SQLControll {
	public abstract ResultSet Select();
	public abstract void Insert();
	public abstract void Update();
	public abstract void Delete();
}

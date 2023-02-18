package pojo;

public class UserInfo {
	Integer Uid;
	String name;
	Integer age;
	String passwd;
	Integer role;
	
	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
	
	public UserInfo() {
		
	}

	public UserInfo(Integer uid, String name, Integer age, String passwd, Integer role) {
		this.Uid = uid;
		this.name = name;
		this.age = age;
		this.passwd = passwd;
		this.role = role;
	}
	
	public UserInfo(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public UserInfo(String name, String passwd) {
		this.name = name;
		this.passwd=passwd;
	}
	
	public Integer getUid() {
		return Uid;
	}
	public void setUid(Integer uid) {
		Uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}

public class Voter {
private int id;
private String Aadhar,Name,Password,Contact;
public Voter() {}
public Voter(String Aadhar, String Name, String Password,String Contact) {
	super();
	this.Aadhar = Aadhar;
	this.Name = Name;
	this.Password = Password;
	this.Contact = Contact;
}
public String getId() {
	return Aadhar;
}
public void setId(String i) {
	this.Aadhar = i;
}
public String getName() {
	return Name;
}
public void setName(String Name) {
	this.Name = Name;
}
public String getPassword() {
	return Password;
}
public void setPassword(String Password) {
	this.Password = Password;
}
public String getContact() {
	return Contact;
}
public void setContactno(String Contact) {
	this.Contact = Contact;
}
}
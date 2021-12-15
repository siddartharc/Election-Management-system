public class Candidate {
private String id;
private String name,contactno,Party_Name;
public Candidate() {}
public Candidate(String id,String name, String contactno,String partyName) {
	super();
	this.id = id;
	this.name = name;
	this.contactno = contactno;
	this.Party_Name = partyName;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContactno() {
	return contactno;
}
public void setContactno(String contactno) {
	this.contactno = contactno;
}
public String getPartyname() {
	return Party_Name;
}
public void setPartyname(String Party_Name) {
	this.Party_Name = Party_Name;
}
}

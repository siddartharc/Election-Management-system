public class result {
private String id;
private String Party_Name,count;
public result() {}
public result(String id,String partyName,String count) {
	super();
	this.id = id;
	this.Party_Name = partyName;
	this.count = count;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPartyname() {
	return Party_Name;
}
public void setPartyname(String Party_Name) {
	this.Party_Name = Party_Name;
}
public String getcount() {
	return count;
}
public void setcount(String count) {
	this.count = count;
}
}
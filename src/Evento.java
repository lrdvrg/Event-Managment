
public class Evento {



	public Evento(String name, String date, String location, String type) {
		super();
		this.name = name;
		this.dte = date;
		this.location = location;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return dte;
	}

	public void setData(String data) {
		this.dte = data;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	String name, dte, location, type;
}

package by.tc.task01.entity;

public class Appliance {

	private String nameAppliance;

	public Appliance(String nameAppliance) {
		super();
		this.nameAppliance = nameAppliance;
	}

	public Appliance() {
		super();
		this.nameAppliance = null;
	}

	public String getNameAppliance() {
		return nameAppliance;
	}

	public void setNameAppliance(String nameAppliance) {
		this.nameAppliance = nameAppliance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameAppliance == null) ? 0 : nameAppliance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appliance other = (Appliance) obj;
		if (nameAppliance == null) {
			if (other.nameAppliance != null)
				return false;
		} else if (!nameAppliance.equals(other.nameAppliance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appliance [nameAppliance=" + nameAppliance + "]";
	}

}

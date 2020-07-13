package by.tc.task01.entity;

public class Laptop extends Appliance {

	private int batteryCapacity;
	private String OS;
	private int memoryRom;
	private int systemMemory;
	private double CPU;
	private int displayInchs;

	public Laptop(String nameAppliance, int batteryCapacity, String oS, int memoryRom, int systemMemory, double cPU,
			int displayInchs) {
		super(nameAppliance);
		this.batteryCapacity = batteryCapacity;
		OS = oS;
		this.memoryRom = memoryRom;
		this.systemMemory = systemMemory;
		CPU = cPU;
		this.displayInchs = displayInchs;
	}

	public Laptop() {
		super();
		this.batteryCapacity = 0;
		OS = null;
		this.memoryRom = 0;
		this.systemMemory = 0;
		CPU = 0;
		this.displayInchs = 0;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	public int getMemoryRom() {
		return memoryRom;
	}

	public void setMemoryRom(int memoryRom) {
		this.memoryRom = memoryRom;
	}

	public int getSystemMemory() {
		return systemMemory;
	}

	public void setSystemMemory(int systemMemory) {
		this.systemMemory = systemMemory;
	}

	public double getCPU() {
		return CPU;
	}

	public void setCPU(double cPU) {
		CPU = cPU;
	}

	public int getDisplayInchs() {
		return displayInchs;
	}

	public void setDisplayInchs(int displayInchs) {
		this.displayInchs = displayInchs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(CPU);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((OS == null) ? 0 : OS.hashCode());
		result = prime * result + batteryCapacity;
		result = prime * result + displayInchs;
		result = prime * result + memoryRom;
		result = prime * result + systemMemory;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		if (Double.doubleToLongBits(CPU) != Double.doubleToLongBits(other.CPU))
			return false;
		if (OS == null) {
			if (other.OS != null)
				return false;
		} else if (!OS.equals(other.OS))
			return false;
		if (batteryCapacity != other.batteryCapacity)
			return false;
		if (displayInchs != other.displayInchs)
			return false;
		if (memoryRom != other.memoryRom)
			return false;
		if (systemMemory != other.systemMemory)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Laptop [batteryCapacity=" + batteryCapacity + ", OS=" + OS + ", memoryRom=" + memoryRom
				+ ", systemMemory=" + systemMemory + ", CPU=" + CPU + ", displayInchs=" + displayInchs + "]";
	}

}

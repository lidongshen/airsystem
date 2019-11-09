package entity;

import java.util.Date;

public class Flight {
	private int fId;
	private int fSeatnum;
	private String fName;
	private String fFromcity;
	private String fTocity;
	private double fMoney;
	private Date fStartdate;
	private Date fEnddate;
	public Flight(int fId,  String fName, String fFromcity, String fTocity, double fMoney, int fSeatnum,Date fStartdate,
			Date fEnddate) {
		super();
		this.fId = fId;
		this.fSeatnum = fSeatnum;
		this.fName = fName;
		this.fFromcity = fFromcity;
		this.fTocity = fTocity;
		this.fMoney = fMoney;
		this.fStartdate = fStartdate;
		this.fEnddate = fEnddate;
	}
	public Flight(String fName, String fFromcity, String fTocity, double fMoney,int fSeatnum,  Date fStartdate,
			Date fEnddate) {
		super();
		this.fSeatnum = fSeatnum;
		this.fName = fName;
		this.fFromcity = fFromcity;
		this.fTocity = fTocity;
		this.fMoney = fMoney;
		this.fStartdate =  fStartdate;
		this.fEnddate =fEnddate;
	}
	public Flight() {
		super();
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public int getfSeatnum() {
		return fSeatnum;
	}
	public void setfSeatnum(int fSeatnum) {
		this.fSeatnum = fSeatnum;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfFromcity() {
		return fFromcity;
	}
	public void setfFromcity(String fFromcity) {
		this.fFromcity = fFromcity;
	}
	public String getfTocity() {
		return fTocity;
	}
	public void setfTocity(String fTocity) {
		this.fTocity = fTocity;
	}
	public double getfMoney() {
		return fMoney;
	}
	public void setfMoney(double fMoney) {
		this.fMoney = fMoney;
	}
	public Date getfStartdate() {
		return fStartdate;
	}
	public void setfStartdate(Date fStartdate) {
		this.fStartdate = fStartdate;
	}
	public Date getfEnddate() {
		return fEnddate;
	}
	public void setfEnddate(Date fEnddate) {
		this.fEnddate = fEnddate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fEnddate == null) ? 0 : fEnddate.hashCode());
		result = prime * result + ((fFromcity == null) ? 0 : fFromcity.hashCode());
		result = prime * result + fId;
		long temp;
		temp = Double.doubleToLongBits(fMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + fSeatnum;
		result = prime * result + ((fStartdate == null) ? 0 : fStartdate.hashCode());
		result = prime * result + ((fTocity == null) ? 0 : fTocity.hashCode());
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
		Flight other = (Flight) obj;
		if (fEnddate == null) {
			if (other.fEnddate != null)
				return false;
		} else if (!fEnddate.equals(other.fEnddate))
			return false;
		if (fFromcity == null) {
			if (other.fFromcity != null)
				return false;
		} else if (!fFromcity.equals(other.fFromcity))
			return false;
		if (fId != other.fId)
			return false;
		if (Double.doubleToLongBits(fMoney) != Double.doubleToLongBits(other.fMoney))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (fSeatnum != other.fSeatnum)
			return false;
		if (fStartdate == null) {
			if (other.fStartdate != null)
				return false;
		} else if (!fStartdate.equals(other.fStartdate))
			return false;
		if (fTocity == null) {
			if (other.fTocity != null)
				return false;
		} else if (!fTocity.equals(other.fTocity))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flight [fId=" + fId + ", fSeatnum=" + fSeatnum + ", fName=" + fName + ", fFromcity=" + fFromcity
				+ ", fTocity=" + fTocity + ", fMoney=" + fMoney + ", fStartdate=" + fStartdate + ", fEnddate="
				+ fEnddate + "]";
	}
	
	
	
	
}

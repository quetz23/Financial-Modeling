package model;

public class Screener_Parameters {
	private int betaMoreThan;
	private int volumeMoreThan;
	private String sector;
	private int marketCapMoreThan;
	private int divdendMoreThan;
	
	
	public int getBetaMoreThan() {
		return betaMoreThan;
	}
	public void setBetaMoreThan(int betaMoreThan) {
		this.betaMoreThan = betaMoreThan;
	}
	public int getVolumeMoreThan() {
		return volumeMoreThan;
	}
	public void setVolumeMoreThan(int volumeMoreThan) {
		this.volumeMoreThan = volumeMoreThan;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public int getMarketCapMoreThan() {
		return marketCapMoreThan;
	}
	public void setMarketCapMoreThan(int marketCapMoreThan) {
		this.marketCapMoreThan = marketCapMoreThan;
	}
	public int getDivdendMoreThan() {
		return divdendMoreThan;
	}
	public void setDivdendMoreThan(int divdendMoreThan) {
		this.divdendMoreThan = divdendMoreThan;
	}

}

package pe.com.intralot.loto.layer.dto.golden;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TicketGoldenFutbol {


	@SerializedName("ticketId")
    private long ticketId;

    
    @SerializedName("timeSend")
    private String timeSend;
    
    @SerializedName("timeRegister")
    private String timeRegister;
    
    @SerializedName("timeResolved")
    private String timeResolved;
    
    @SerializedName("timeClosedMarket")
    private String timeClosedMarket;
    
    @SerializedName("timePrint")
    private String timePrint;
    
    @SerializedName("status")
    private String status;
    

    
    @SerializedName("stake")
    private double stake;
   
    @SerializedName("wonData")
    private WonData wonData;
   
    @SerializedName("gameType")
    private List<String> gameType;
    
    @SerializedName("numBets")
    private int numBets;
    
    @SerializedName("details")
    private Details details;

	public TicketGoldenFutbol() {
		
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}



	public String getTimeSend() {
		return timeSend;
	}

	public void setTimeSend(String timeSend) {
		this.timeSend = timeSend;
	}

	public String getTimeRegister() {
		return timeRegister;
	}

	public void setTimeRegister(String timeRegister) {
		this.timeRegister = timeRegister;
	}

	public String getTimeResolved() {
		return timeResolved;
	}

	public void setTimeResolved(String timeResolved) {
		this.timeResolved = timeResolved;
	}

	public String getTimeClosedMarket() {
		return timeClosedMarket;
	}

	public void setTimeClosedMarket(String timeClosedMarket) {
		this.timeClosedMarket = timeClosedMarket;
	}

	public String getTimePrint() {
		return timePrint;
	}

	public void setTimePrint(String timePrint) {
		this.timePrint = timePrint;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getStake() {
		return stake;
	}

	public void setStake(double stake) {
		this.stake = stake;
	}


	public WonData getWonData() {
		return wonData;
	}

	public void setWonData(WonData wonData) {
		this.wonData = wonData;
	}

	public List<String> getGameType() {
		return gameType;
	}

	public void setGameType(List<String> gameType) {
		this.gameType = gameType;
	}

	public int getNumBets() {
		return numBets;
	}

	public void setNumBets(int numBets) {
		this.numBets = numBets;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}
	




}

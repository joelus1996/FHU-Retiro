package pe.com.intralot.loto.layer.model.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "TICKETSALE_GETTICKETS_FILTER_LIST", query = "{ call LOTOCARD.TICKETSALE.GETTICKETSLISTFILTER(?,?,?,?) }", callable = true, resultClass = TicketProcedureGetTicketsFilterList.class),
	@NamedNativeQuery(name = "TICKET_RETAIL_FILTER_LIST", query = "{ call RETAIL.CLIENTPRO.GETTICKETSLISTFILTER(?,?,?,?) }", callable = true, resultClass = TicketProcedureGetTicketsFilterList.class)
})
public class TicketProcedureGetTicketsFilterList {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "parameter_id")
    private String parameterId;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "sale_date")
    private String saleDate;

    @Column(name = "ticket_id")
    private String ticketId;

    @Column(name = "status")
    private String status;

    @Column(name = "table_id")
    private Integer tableId;

    @Column(name = "price")
    private Double price;

    @Column(name = "bet")
    private String bet;

    @Column(name = "more_bets")
    private String moreBets;
    
    @Column(name = "ct_ticket_date")
    private Date ticketDate;    

    @Column(name = "with_draw")
    private String withDraw;

    @Column(name = "with_ticket")
    private String withTicket;
    
    @Column(name = "more_status")
    private String moreStatus;
    
    @Column(name = "sales_channel")
    private String sales_channel;
    
    @Column(name = "pid_ticket")
    private String pid_ticket;
    
    @Column(name = "coupon_id")
    private String coupon_id;
    
    @Column(name = "programa")
    private String programa;
    
    @Column(name = "open_grecia")
    private String openGrecia;
    
    @Column(name = "id_operacion")
    private String idOperacion;
    
    @Column(name = "cv_ticketd")
    private String cvTicketd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getParameterId() {
        return parameterId;
    }

    public void setParameterId(String parameterId) {
        this.parameterId = parameterId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public String getMoreBets() {
        return moreBets;
    }

    public void setMoreBets(String moreBets) {
        this.moreBets = moreBets;
    }

    public String getWithDraw() {
        return withDraw;
    }

	public void setWithDraw(String withDraw) {
        this.withDraw = withDraw;
    }

    public String getWithTicket() {
        return withTicket;
    }

    public void setWithTicket(String withTicket) {
        this.withTicket = withTicket;
    }
    
    public String getMoreStatus() {
		return moreStatus;
	}

	public void setMoreStatus(String moreStatus) {
		this.moreStatus = moreStatus;
	}

	public String getSales_channel() {
		return sales_channel;
	}

	public void setSales_channel(String sales_channel) {
		this.sales_channel = sales_channel;
	}

	public String getPid_ticket() {
		return pid_ticket;
	}

	public void setPid_ticket(String pid_ticket) {
		this.pid_ticket = pid_ticket;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getOpenGrecia() {
		return openGrecia;
	}

	public void setOpenGrecia(String openGrecia) {
		this.openGrecia = openGrecia;
	}

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}
	
	public String getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperation(String idOperacion) {
		this.idOperacion = idOperacion;
	}

	public String getCvTicketd() {
		return cvTicketd;
	}

	public void setCvTicketd(String cvTicketd) {
		this.cvTicketd = cvTicketd;
	}

}
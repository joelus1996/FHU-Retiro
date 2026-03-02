package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "TICKETSALE_GETCLIENTTICKET_RETAIL_GRECIA",
		query = "{ call LOTOCARD.TICKETSALE.GETCLIENTTICKET_RETAILGRECIA(?,?,?) }",
		callable = true,
		resultClass = TicketProcedureGetRetailTeApuestoGrecia.class
)
public class TicketProcedureGetRetailTeApuestoGrecia {
	
	@Id
	@Column(name = "w_eventid")
	private String eventId;
	
	@Column(name = "w_programa")
	private Integer programa;
	
	@Column(name = "w_ticket")
	private Integer cpn;
	
	@Column(name = "w_item")
	private Integer item;
	
	@Column(name = "w_fecha_hora_venta") 
	private String fechaHoraVenta;
	
	@Column(name = "w_terminal_venta") 
	private Integer terminalVenta;
	
	@Column(name = "w_virtual") 
	private Integer virtual;
	
	@Column(name = "w_importe_venta")
	private Double importeVenta;
	
	@Column(name = "w_codigo_evento")
	private Integer codigoEvento;
	
	@Column(name = "w_codigo_seleccion")
	private String codigoSeleccion;
	
	@Column(name = "w_seleccion")
	private String seleccion;
	
	@Column(name = "w_codigo_resultado")
	private String codigoResultado;
	
	@Column(name = "w_mercado")
	private String mercado;
	
	@Column(name = "w_odd")
	private Double odd;
	
	@Column(name = "w_maxpay")
	private Double maxPay;

	@Column(name = "w_record_code")
	private Integer recordCode;

	@Column(name = "w_be_nev_cd")
	private Integer beNevCd;

	@Column(name = "w_tipo")
	private String tipo;

	@Column(name = "w_equipos")
	private String equipos;

	@Column(name = "w_competencia")
	private String competencia;
	
	@Column(name = "w_fecha_inicio")
	private String fechaInicio;
	
	@Column(name = "w_resultado")
	private String resultado;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Integer getPrograma() {
		return programa;
	}

	public void setPrograma(Integer programa) {
		this.programa = programa;
	}

	public Integer getCpn() {
		return cpn;
	}

	public void setCpn(Integer cpn) {
		this.cpn = cpn;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getFechaHoraVenta() {
		return fechaHoraVenta;
	}

	public void setFechaHoraVenta(String fechaHoraVenta) {
		this.fechaHoraVenta = fechaHoraVenta;
	}

	public Integer getTerminalVenta() {
		return terminalVenta;
	}

	public void setTerminalVenta(Integer terminalVenta) {
		this.terminalVenta = terminalVenta;
	}

	public Integer getVirtual() {
		return virtual;
	}

	public void setVirtual(Integer virtual) {
		this.virtual = virtual;
	}

	public Double getImporteVenta() {
		return importeVenta;
	}

	public void setImporteVenta(Double importeVenta) {
		this.importeVenta = importeVenta;
	}

	public Integer getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(Integer codigoEvento) {
		this.codigoEvento = codigoEvento;
	}

	public String getCodigoSeleccion() {
		return codigoSeleccion;
	}

	public void setCodigoSeleccion(String codigoSeleccion) {
		this.codigoSeleccion = codigoSeleccion;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getCodigoResultado() {
		return codigoResultado;
	}

	public void setCodigoResultado(String codigoResultado) {
		this.codigoResultado = codigoResultado;
	}

	public String getMercado() {
		return mercado;
	}

	public void setMercado(String mercado) {
		this.mercado = mercado;
	}

	public Double getOdd() {
		return odd;
	}

	public void setOdd(Double odd) {
		this.odd = odd;
	}

	public Double getMaxPay() {
		return maxPay;
	}

	public void setMaxPay(Double maxPay) {
		this.maxPay = maxPay;
	}

	public Integer getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(Integer recordCode) {
		this.recordCode = recordCode;
	}

	public Integer getBeNevCd() {
		return beNevCd;
	}

	public void setBeNevCd(Integer beNevCd) {
		this.beNevCd = beNevCd;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEquipos() {
		return equipos;
	}

	public void setEquipos(String equipos) {
		this.equipos = equipos;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "TicketProcedureGetRetailTeApuestoGrecia [eventId=" + eventId + ", programa=" + programa + ", cpn=" + cpn
				+ ", item=" + item + ", fechaHoraVenta=" + fechaHoraVenta + ", terminalVenta=" + terminalVenta
				+ ", virtual=" + virtual + ", importeVenta=" + importeVenta + ", codigoEvento=" + codigoEvento
				+ ", codigoSeleccion=" + codigoSeleccion + ", seleccion=" + seleccion + ", codigoResultado="
				+ codigoResultado + ", mercado=" + mercado + ", odd=" + odd + ", maxPay=" + maxPay + ", recordCode="
				+ recordCode + ", beNevCd=" + beNevCd + ", tipo=" + tipo + ", equipos=" + equipos + ", competencia="
				+ competencia + "]";
	}


}

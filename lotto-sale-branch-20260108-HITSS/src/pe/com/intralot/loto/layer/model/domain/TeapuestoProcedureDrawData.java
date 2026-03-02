package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

@Entity
@NamedNativeQuery(
		name="TEAPUESTOSALE_DRAWDATA",
		query="{ call LOTOCARD.TEAPUESTOSALE.DRAW_DATA(?,?) }",
		callable=true,
		resultSetMapping = "drawdata-data"
		)
@SqlResultSetMapping(name = "drawdata-data",
                     entities = @EntityResult (entityClass = TeapuestoProcedureDrawData.class))
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class TeapuestoProcedureDrawData {
	@Id
	@Column(name="w_event_id")
	private Integer eventId;
	
	@Column(name="w_hour")
	private String hour;
	
	@Column(name="w_league_id")
	private String leagueId;
	
	@Column(name="w_minimum")
    private Integer minimum;
	
	@Column(name="w_teams")
    private String teams;
	
	@Column(name="w_exact_goal")
    private String exactGoal;
	
	@Column(name="w_local")
    private String local;
	
	@Column(name="w_equal")
    private String equal;
	
	@Column(name="w_visitor")
    private String visitor;
			
	@Column(name="w_local_equal")
    private String localEqual;
	
	@Column(name="w_local_visitor")
    private String localVisitor;
	
	@Column(name="w_equal_visitor")
    private String equalVisitor;
	
	@Column(name="w_1t_local")
    private String t1tLocal;
	
	@Column(name="w_1t_equal")
    private String t1tEqual;
	
	@Column(name="w_1t_visitor")
    private String t1tVisitor;
	
	@Column(name="w_1t_local_2t_local")
    private String t1tLocal2tLocal;
	
	@Column(name="w_1t_equal_2t_local")
    private String t1tEqual2tLocal;
	
	@Column(name="w_1t_visitor_2t_local")
    private String t1tVisitor2tLocal;
	
	@Column(name="w_1t_local_2t_equal")
    private String t1tLocal2tEqual;
	
	@Column(name="w_1t_equal_2t_equal")
    private String t1tEqual2tEqual;
	
	@Column(name="w_1t_visitor_2t_equal")
    private String t1tVisitor2tEqual;
	
	@Column(name="w_1t_local_2t_visitor")
    private String t1tLocal2tVisitor;
	
	@Column(name="w_1t_equal_2t_visitor")
    private String t1tEqual2tVisitor;
	
	@Column(name="w_1t_visitor_2t_visitor")
    private String t1tVisitor2tVisitor;
	
	@Column(name="w_goal_lower_2")
    private String goalLower2;
	
	@Column(name="w_goal_over_3")
    private String goalOver3;
	
	@Column(name="w_goal_0_1")
    private String goal_0_1;
	
	@Column(name="w_goal_2_3")
    private String goal_2_3;
	
	@Column(name="w_goal_4_more")
    private String goal4More;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public String getTeams() {
		return teams;
	}

	public void setTeams(String teams) {
		this.teams = teams;
	}

	public String getExactGoal() {
		return exactGoal;
	}

	public void setExactGoal(String exactGoal) {
		this.exactGoal = exactGoal;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEqual() {
		return equal;
	}

	public void setEqual(String equal) {
		this.equal = equal;
	}

	public String getVisitor() {
		return visitor;
	}

	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}

	public String getLocalEqual() {
		return localEqual;
	}

	public void setLocalEqual(String localEqual) {
		this.localEqual = localEqual;
	}

	public String getLocalVisitor() {
		return localVisitor;
	}

	public void setLocalVisitor(String localVisitor) {
		this.localVisitor = localVisitor;
	}

	public String getEqualVisitor() {
		return equalVisitor;
	}

	public void setEqualVisitor(String equalVisitor) {
		this.equalVisitor = equalVisitor;
	}

	public String getT1tLocal() {
		return t1tLocal;
	}

	public void setT1tLocal(String t1tLocal) {
		this.t1tLocal = t1tLocal;
	}

	public String getT1tEqual() {
		return t1tEqual;
	}

	public void setT1tEqual(String t1tEqual) {
		this.t1tEqual = t1tEqual;
	}

	public String getT1tVisitor() {
		return t1tVisitor;
	}

	public void setT1tVisitor(String t1tVisitor) {
		this.t1tVisitor = t1tVisitor;
	}

	public String getT1tLocal2tLocal() {
		return t1tLocal2tLocal;
	}

	public void setT1tLocal2tLocal(String t1tLocal2tLocal) {
		this.t1tLocal2tLocal = t1tLocal2tLocal;
	}

	public String getT1tEqual2tLocal() {
		return t1tEqual2tLocal;
	}

	public void setT1tEqual2tLocal(String t1tEqual2tLocal) {
		this.t1tEqual2tLocal = t1tEqual2tLocal;
	}

	public String getT1tVisitor2tLocal() {
		return t1tVisitor2tLocal;
	}

	public void setT1tVisitor2tLocal(String t1tVisitor2tLocal) {
		this.t1tVisitor2tLocal = t1tVisitor2tLocal;
	}

	public String getT1tLocal2tEqual() {
		return t1tLocal2tEqual;
	}

	public void setT1tLocal2tEqual(String t1tLocal2tEqual) {
		this.t1tLocal2tEqual = t1tLocal2tEqual;
	}

	public String getT1tEqual2tEqual() {
		return t1tEqual2tEqual;
	}

	public void setT1tEqual2tEqual(String t1tEqual2tEqual) {
		this.t1tEqual2tEqual = t1tEqual2tEqual;
	}

	public String getT1tVisitor2tEqual() {
		return t1tVisitor2tEqual;
	}

	public void setT1tVisitor2tEqual(String t1tVisitor2tEqual) {
		this.t1tVisitor2tEqual = t1tVisitor2tEqual;
	}

	public String getT1tLocal2tVisitor() {
		return t1tLocal2tVisitor;
	}

	public void setT1tLocal2tVisitor(String t1tLocal2tVisitor) {
		this.t1tLocal2tVisitor = t1tLocal2tVisitor;
	}

	public String getT1tEqual2tVisitor() {
		return t1tEqual2tVisitor;
	}

	public void setT1tEqual2tVisitor(String t1tEqual2tVisitor) {
		this.t1tEqual2tVisitor = t1tEqual2tVisitor;
	}

	public String getT1tVisitor2tVisitor() {
		return t1tVisitor2tVisitor;
	}

	public void setT1tVisitor2tVisitor(String t1tVisitor2tVisitor) {
		this.t1tVisitor2tVisitor = t1tVisitor2tVisitor;
	}

	public String getGoalLower2() {
		return goalLower2;
	}

	public void setGoalLower2(String goalLower2) {
		this.goalLower2 = goalLower2;
	}

	public String getGoalOver3() {
		return goalOver3;
	}

	public void setGoalOver3(String goalOver3) {
		this.goalOver3 = goalOver3;
	}

	public String getGoal_0_1() {
		return goal_0_1;
	}

	public void setGoal_0_1(String goal_0_1) {
		this.goal_0_1 = goal_0_1;
	}

	public String getGoal_2_3() {
		return goal_2_3;
	}

	public void setGoal_2_3(String goal_2_3) {
		this.goal_2_3 = goal_2_3;
	}

	public String getGoal4More() {
		return goal4More;
	}

	public void setGoal4More(String goal4More) {
		this.goal4More = goal4More;
	}
	
	
}

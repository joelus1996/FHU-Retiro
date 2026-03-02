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
@NamedNativeQuery(name = "TEAPUESTOSALE_EXACTDATA", 
                  query = "{ call LOTOCARD.TEAPUESTOSALE.EXACT_DATA(?,?,?) }", 
          		callable=true,
        		resultSetMapping = "exactdata-data"
        		)
@SqlResultSetMapping(name = "exactdata-data",
                     entities = @EntityResult (entityClass = TeapuestoProcedureExactData.class))
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class TeapuestoProcedureExactData {

    @Id
    @Column(name = "w_event_id")
    private Integer eventId;

    @Column(name = "w_date")
    private String date;

    @Column(name = "w_hour")
    private String hour;

    @Column(name = "w_local")
    private String local;

    @Column(name = "w_image_local")
    private String imageLocal;

    @Column(name = "w_visitor")
    private String visitor;

    @Column(name = "w_image_visitor")
    private String imageVisitor;

    @Column(name = "w_s_0_0")
    private String s00;

    @Column(name = "w_s_1_0")
    private String s10;

    @Column(name = "w_s_2_0")
    private String s20;

    @Column(name = "w_s_3_0")
    private String s30;

    @Column(name = "w_s_4_0")
    private String s40;

    @Column(name = "w_s_5_more_0")
    private String s5More0;

    @Column(name = "w_s_2_1")
    private String s21;

    @Column(name = "w_s_3_1")
    private String s31;

    @Column(name = "w_s_4_1")
    private String s41;

    @Column(name = "w_s_5_more_1")
    private String s5More1;

    @Column(name = "w_s_3_2")
    private String s32;

    @Column(name = "w_s_4_2")
    private String s42;

    @Column(name = "w_s_5_more_2")
    private String s5More2;

    @Column(name = "w_s_4_3")
    private String s43;

    @Column(name = "w_s_5_more_3")
    private String s5More3;

    @Column(name = "w_s_5_more_4")
    private String s5More4;

    @Column(name = "w_s_1_1")
    private String s11;

    @Column(name = "w_s_2_2")
    private String s22;

    @Column(name = "w_s_3_3")
    private String s33;

    @Column(name = "w_s_4_4")
    private String s44;

    @Column(name = "w_s_5_more_5_more")
    private String s5More5More;

    @Column(name = "w_s_4_5_more")
    private String s45More;

    @Column(name = "w_s_3_4")
    private String s34;

    @Column(name = "w_s_3_5_more")
    private String s35More;

    @Column(name = "w_s_2_3")
    private String s23;

    @Column(name = "w_s_2_4")
    private String s24;

    @Column(name = "w_s_2_5_more")
    private String s25More;

    @Column(name = "w_s_1_2")
    private String s12;

    @Column(name = "w_s_1_3")
    private String s13;

    @Column(name = "w_s_1_4")
    private String s14;

    @Column(name = "w_s_1_5_more")
    private String s15More;

    @Column(name = "w_s_0_1")
    private String s01;

    @Column(name = "w_s_0_2")
    private String s02;

    @Column(name = "w_s_0_3")
    private String s03;

    @Column(name = "w_s_0_4")
    private String s04;

    @Column(name = "w_s_0_5_more")
    private String s05More;

    public String getDate() {
        return date;
    }

    public Integer getEventId() {
        return eventId;
    }

    public String getHour() {
        return hour;
    }

    public String getImageLocal() {
        return imageLocal;
    }

    public String getImageVisitor() {
        return imageVisitor;
    }

    public String getLocal() {
        return local;
    }

    public String getS00() {
        return s00;
    }

    public String getS01() {
        return s01;
    }

    public String getS02() {
        return s02;
    }

    public String getS03() {
        return s03;
    }

    public String getS04() {
        return s04;
    }

    public String getS05More() {
        return s05More;
    }

    public String getS10() {
        return s10;
    }

    public String getS11() {
        return s11;
    }

    public String getS12() {
        return s12;
    }

    public String getS13() {
        return s13;
    }

    public String getS14() {
        return s14;
    }

    public String getS15More() {
        return s15More;
    }

    public String getS20() {
        return s20;
    }

    public String getS21() {
        return s21;
    }

    public String getS22() {
        return s22;
    }

    public String getS23() {
        return s23;
    }

    public String getS24() {
        return s24;
    }

    public String getS25More() {
        return s25More;
    }

    public String getS30() {
        return s30;
    }

    public String getS31() {
        return s31;
    }

    public String getS32() {
        return s32;
    }

    public String getS33() {
        return s33;
    }

    public String getS34() {
        return s34;
    }

    public String getS35More() {
        return s35More;
    }

    public String getS40() {
        return s40;
    }

    public String getS41() {
        return s41;
    }

    public String getS42() {
        return s42;
    }

    public String getS43() {
        return s43;
    }

    public String getS44() {
        return s44;
    }

    public String getS45More() {
        return s45More;
    }

    public String getS5More0() {
        return s5More0;
    }

    public String getS5More1() {
        return s5More1;
    }

    public String getS5More2() {
        return s5More2;
    }

    public String getS5More3() {
        return s5More3;
    }

    public String getS5More4() {
        return s5More4;
    }

    public String getS5More5More() {
        return s5More5More;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setImageLocal(String imageLocal) {
        this.imageLocal = imageLocal;
    }

    public void setImageVisitor(String imageVisitor) {
        this.imageVisitor = imageVisitor;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setS00(String s00) {
        this.s00 = s00;
    }

    public void setS01(String s01) {
        this.s01 = s01;
    }

    public void setS02(String s02) {
        this.s02 = s02;
    }

    public void setS03(String s03) {
        this.s03 = s03;
    }

    public void setS04(String s04) {
        this.s04 = s04;
    }

    public void setS05More(String s05More) {
        this.s05More = s05More;
    }

    public void setS10(String s10) {
        this.s10 = s10;
    }

    public void setS11(String s11) {
        this.s11 = s11;
    }

    public void setS12(String s12) {
        this.s12 = s12;
    }

    public void setS13(String s13) {
        this.s13 = s13;
    }

    public void setS14(String s14) {
        this.s14 = s14;
    }

    public void setS15More(String s15More) {
        this.s15More = s15More;
    }

    public void setS20(String s20) {
        this.s20 = s20;
    }

    public void setS21(String s21) {
        this.s21 = s21;
    }

    public void setS22(String s22) {
        this.s22 = s22;
    }

    public void setS23(String s23) {
        this.s23 = s23;
    }

    public void setS24(String s24) {
        this.s24 = s24;
    }

    public void setS25More(String s25More) {
        this.s25More = s25More;
    }

    public void setS30(String s30) {
        this.s30 = s30;
    }

    public void setS31(String s31) {
        this.s31 = s31;
    }

    public void setS32(String s32) {
        this.s32 = s32;
    }

    public void setS33(String s33) {
        this.s33 = s33;
    }

    public void setS34(String s34) {
        this.s34 = s34;
    }

    public void setS35More(String s35More) {
        this.s35More = s35More;
    }

    public void setS40(String s40) {
        this.s40 = s40;
    }

    public void setS41(String s41) {
        this.s41 = s41;
    }

    public void setS42(String s42) {
        this.s42 = s42;
    }

    public void setS43(String s43) {
        this.s43 = s43;
    }

    public void setS44(String s44) {
        this.s44 = s44;
    }

    public void setS45More(String s45More) {
        this.s45More = s45More;
    }

    public void setS5More0(String s5More0) {
        this.s5More0 = s5More0;
    }

    public void setS5More1(String s5More1) {
        this.s5More1 = s5More1;
    }

    public void setS5More2(String s5More2) {
        this.s5More2 = s5More2;
    }

    public void setS5More3(String s5More3) {
        this.s5More3 = s5More3;
    }

    public void setS5More4(String s5More4) {
        this.s5More4 = s5More4;
    }

    public void setS5More5More(String s5More5More) {
        this.s5More5More = s5More5More;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

}

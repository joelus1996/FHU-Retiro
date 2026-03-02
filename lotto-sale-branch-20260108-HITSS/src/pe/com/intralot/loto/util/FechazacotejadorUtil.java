package pe.com.intralot.loto.util;
import java.util.ArrayList;

import pe.com.intralot.loto.util.AciertoscotejadorUtil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author developer5
 */
public class FechazacotejadorUtil {

    public ArrayList fechaza(String jugada, String premio) {
        ArrayList jugada_aciertos = new ArrayList();
        String[] jugada_split, fecha, premio_split;
        jugada_split = jugada.trim().split(" ");
        AciertoscotejadorUtil s = new AciertoscotejadorUtil();
      /*  System.out.println("JUGADA PRINCIPAL :"+jugada);
        System.out.println("CANTIDAD:"+jugada_split.length);
        System.out.println("TIPO :->"+jugada_split[0]);
        System.out.println("JUGADA 2 :"+jugada_split[1]);
        System.out.println("JUGADA 3 :"+jugada_split[2]);*/
        if (jugada_split.length == 3) {
            fecha = jugada_split[2].split("/");
            premio_split = premio.split("/");

            String dia_jugada, mes_jugada, anio_jugada, dia_resultado, mes_resultado, anio_resultado;


            if (jugada_split[0].equals("DMA")) {
                dia_jugada = fecha[0].trim();
                mes_jugada = fecha[1].trim();
                anio_jugada = fecha[2].trim();
                dia_resultado = premio_split[0].trim();
                mes_resultado = premio_split[1].trim();
                anio_resultado = premio_split[2].trim();
                s.d_m_a_ind = 1;
                if ((dia_jugada + mes_jugada + anio_jugada).equals(dia_resultado + mes_resultado + anio_resultado)) {
                    s.d_m_a_primero++;
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : "+"<b>"+dia_jugada+"</b>"+" /Mes : <b>"+mes_jugada+"</b>/A&ntilde;o <b>: "+anio_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : DMA");
                } else if ((dia_jugada + mes_jugada).equals(dia_resultado + mes_resultado)) {
                    s.d_m_primero++;
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : "+"<b>"+dia_jugada+"</b>"+" /Mes : <b>"+mes_jugada+"</b>/A&ntilde;o <b>: "+anio_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : DM");
                } else if (dia_jugada.equals(dia_resultado)) {
                    s.d_primero++;
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : "+"<b>"+dia_jugada+"</b>"+" /Mes : <b>"+mes_jugada+"</b>/A&ntilde;o <b>: "+anio_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : D");
                }
                else{
                	jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : "+"<b>"+dia_jugada+"</b>"+" /Mes : <b>"+mes_jugada+"</b>/A&ntilde;o <b>: "+anio_jugada+"</b>");
                	 jugada_aciertos.add("No tiene Aciertos");
                    }
            } else if (jugada_split[0].equals("DM")) {
                dia_jugada = fecha[0].trim();
                mes_jugada = fecha[1].trim();
                dia_resultado = premio_split[0].trim();
                mes_resultado = premio_split[1].trim();
                s.d_m_ind = 1;
                if ((dia_jugada + mes_jugada).equals(dia_resultado + mes_resultado)) {
                    s.d_m_segundo++;
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : <b>"+dia_jugada+"</b> /Mes : <b>"+mes_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : DM");

                } else if (dia_jugada.equals(dia_resultado)) {
                    s.d_segundo++;
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : <b>"+dia_jugada+"</b> /Mes : <b>"+mes_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : D");
                } else{
                	jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : <b>"+dia_jugada+"</b> /Mes : <b>"+mes_jugada+"</b>");
               	    jugada_aciertos.add("No tiene Aciertos");
                	  }
            } else if (jugada_split[0].equals("A")) {
            		anio_jugada = fecha[2].trim();
            		anio_resultado = premio_split[2].trim();
            		s.anio_ind = 1;
                if (anio_jugada.equals(anio_resultado)) {
                    s.anio++;
                    jugada_aciertos.add("Tus fechas elegidas: A&ntilde;o : <b>"+anio_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : A");
                } else{
                	jugada_aciertos.add("Tus fechas elegidas: A&ntilde;o : <b>"+anio_jugada+"</b>");
                	jugada_aciertos.add("No tiene Aciertos");
                	  }
            } else if (jugada_split[0].equals("D")) {
                dia_jugada = fecha[0].trim();
                dia_resultado = premio_split[0].trim();
                s.dia_ind = 1;
                if (dia_jugada.equals(dia_resultado)) {
                    s.dia++;
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : <b>"+dia_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : D");
                } else{
                /*	System.out.println("Entro a jugada dia :");
                	System.out.println("dia jugada :"+dia_jugada);
                	System.out.println("dia resulta :"+dia_resultado);*/
                	jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : <b>"+dia_jugada+"</b>");
                	jugada_aciertos.add("No tiene Aciertos");
                	  }
            } else if (jugada_split[0].equals("M")) {
	                mes_jugada = fecha[1].trim();
	                mes_resultado = premio_split[1].trim();
	                s.mes_ind = 1;
              
            	
                if (mes_jugada.equals(mes_resultado)) {
                	
                    s.mes++;
                    jugada_aciertos.add("Tus fechas elegidas: Mes : <b>"+mes_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : M");
                } else{
	                jugada_aciertos.add("Tus fechas elegidas: Mes : <b>"+mes_jugada+"</b>");	
	               	jugada_aciertos.add("No tiene Aciertos");
                	  }
            }


        } else if (jugada_split.length == 5) {
		            fecha = jugada_split[2].split("/");
		            premio_split = premio.split("/");
		
		            String dia_jugada, mes_jugada, anio_jugada, dia_resultado, mes_resultado, anio_resultado;
		            int multiplicador = Integer.parseInt(jugada_split[4]);



            if (jugada_split[0].equals("DMA")) {
            	 s.d_m_a_ind = 1;
	                dia_jugada = fecha[0].trim();
	                mes_jugada = fecha[1].trim();
	                anio_jugada = fecha[2].trim();
	                dia_resultado = premio_split[0].trim();
	                mes_resultado = premio_split[1].trim();
	                anio_resultado = premio_split[2].trim();
                if ((dia_jugada + mes_jugada + anio_jugada).equals(dia_resultado + mes_resultado + anio_resultado)) {
                    s.d_m_a_primero=1*Integer.parseInt(jugada_split[4].toString());
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : "+"<b>"+dia_jugada+"</b>"+" /Mes : <b>"+mes_jugada+"</b>/A&ntilde;o <b>: "+anio_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : DMA");
                    /*jugada_aciertos.add("Dia + Mes + Año => <b>" + 1 + "</b> acierto");
                    jugada_aciertos.add("Dia + Mes");*/
                } else if ((dia_jugada + mes_jugada).equals(dia_resultado + mes_resultado)) {
                    s.d_m_primero=1*Integer.parseInt(jugada_split[4].toString());
//                    System.out.println("dia + mes");
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : "+"<b>"+dia_jugada+"</b>"+" /Mes : <b>"+mes_jugada+"</b>/A&ntilde;o <b>: "+anio_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : DM");
                } else if (dia_jugada.equals(dia_resultado)) {
                    s.d_primero=1*Integer.parseInt(jugada_split[4].toString());
//                    System.out.println("dia ");
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : "+"<b>"+dia_jugada+"</b>"+" /Mes : <b>"+mes_jugada+"</b>/A&ntilde;o <b>: "+anio_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : D");
                } else{
                	jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : "+"<b>"+dia_jugada+"</b>"+" /Mes : <b>"+mes_jugada+"</b>/A&ntilde;o <b>: "+anio_jugada+"</b>");
                	jugada_aciertos.add("No tiene Aciertos");
                	  }

            } else if (jugada_split[0].equals("DM")) {
	            	s.d_m_ind = 1;
	                dia_jugada = fecha[0].trim();
	                mes_jugada = fecha[1].trim();
	                dia_resultado = premio_split[0].trim();
	                mes_resultado = premio_split[1].trim();
                if ((dia_jugada + mes_jugada).equals(dia_resultado + mes_resultado)) {
                    s.d_m_segundo=1*Integer.parseInt(jugada_split[4].toString());
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : <b>"+dia_jugada+"</b> /Mes : <b>"+mes_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : DM");

                } else if (dia_jugada.equals(dia_resultado)) {
                    s.d_segundo=1*Integer.parseInt(jugada_split[4].toString());
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : <b>"+dia_jugada+"</b> /Mes : </b>"+mes_jugada+"<b>");
                    jugada_aciertos.add("Aciertos : D");
                }	else{
                	jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : <b>"+dia_jugada+"</b> /Mes : </b>"+mes_jugada+"<b>");	
                	jugada_aciertos.add("No tiene Aciertos");
                		}
            } else if (jugada_split[0].equals("A")) {
	            	s.anio_ind = 1;
	                anio_jugada = fecha[0].trim();
	                anio_resultado = premio_split[0].trim();
                if (anio_jugada.equals(anio_resultado)) {
                    s.anio=1*Integer.parseInt(jugada_split[4].toString());
                    jugada_aciertos.add("Tus fechas elegidas: A&ntilde;o : <b>"+anio_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : A");
                }	else{
                	jugada_aciertos.add("Tus fechas elegidas: A&ntilde;o : <b>"+anio_jugada+"</b>");	
                	jugada_aciertos.add("No tiene Aciertos");
                		}
            } else if (jugada_split[0].equals("D")) {
            	s.dia_ind = 1;
                dia_jugada = fecha[0].trim();
                dia_resultado = premio_split[0].trim();
                if (dia_jugada.equals(dia_resultado)) {
                    s.dia=1*Integer.parseInt(jugada_split[4].toString());
                    jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : <b>"+dia_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : D");
                }	else{
                	jugada_aciertos.add("Tus fechas elegidas: D&iacute;a : <b>"+dia_jugada+"</b>");
                	jugada_aciertos.add("No tiene Aciertos");
                	}
            } else if (jugada_split[0].equals("M")) {
            	s.mes_ind = 1;
                mes_jugada = fecha[0].trim();
                mes_resultado = premio_split[0].trim();
                if (mes_jugada.equals(mes_resultado)) {
                    s.mes=1*Integer.parseInt(jugada_split[4].toString());
                    jugada_aciertos.add("Tus fechas elegidas: Mes : <b>"+mes_jugada+"</b>");
                    jugada_aciertos.add("Aciertos : M");
                }
                else{
	                jugada_aciertos.add("Tus fechas elegidas: Mes : <b>"+mes_jugada+"</b>");	
	               	jugada_aciertos.add("No tiene Aciertos");
               }

            } else {
	                System.out.println("DATOS ERRONEOS");
	                jugada_aciertos.add("DATOS ERRONEOS");

            }


        }
        return jugada_aciertos;
    }
    public void reiniciando_valores(){
    	AciertoscotejadorUtil s = new AciertoscotejadorUtil();
	s.d_m_a_ind = 0;
	s.d_m_a_primero=0;
	s.d_m_primero=0;
	s.d_primero=0;

	s.d_m_ind = 0;
	s.d_m_ind = 0;
	s.d_segundo=0;

	s.anio_ind = 0;
	s.dia=0;

	s.dia_ind = 0;
	s.dia=0;

	s.mes_ind = 0;
	s.mes=0;
    }
    
    
}

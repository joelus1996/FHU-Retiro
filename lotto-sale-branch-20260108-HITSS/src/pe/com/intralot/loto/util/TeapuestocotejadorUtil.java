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
public class TeapuestocotejadorUtil {
		Double apuesta_cantidad = 1.0;
    public ArrayList Resultado_Jugada(String cadena) {
       // String cadena = "521__ISRAEL (SUB21)-NORUEGA (SUB21)__ __05/06/13__11__0__E/E__PT V/L__27__---- ----__3__E/E__1____523__DINAMARCA-GEORGIA__ __05/06/13__13__15__L/E__PT L/E__27__---- ----__3__E/L__0____524__INGLATERRA (SUB21)-ITALIA (SUB21)__ __05/06/13__13__30__V/L__PT V/L__27__---- ----__3__E/V__0____525__URUGUAY-FRANCIA__ __05/06/13__14__0__S5-5__SF 5-5__300__---- ----__3__S1-0__0____537__FLAMENGO-NAUTICO__ __05/06/13__20__0__L/V__PT L/V__50__---- ----__3__E/V__0";
    	AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
    	String[] jugada, pr;
        Double factor_ = 0.0;
        ArrayList juego = new ArrayList();
        ArrayList ticket = new ArrayList();
        ArrayList partido = new ArrayList();
        ArrayList apuesta = new ArrayList();
        ArrayList factor = new ArrayList();
        ArrayList resultado = new ArrayList();
        ArrayList acerto = new ArrayList();
        ArrayList resultado_jugada = new ArrayList();
        jugada = cadena.split("____");
        System.out.println("tama�o:  " + jugada.length);
        for (int i = 0; i < jugada.length; i++) {
            juego.add(jugada[i]);
        }
        for (int j = 0; j < juego.size(); j++) {
            pr = juego.get(j).toString().split("__");
            ticket.add(pr[0]);
            partido.add(pr[1]);
            apuesta.add(pr[6]);
            factor.add(pr[8]);
            resultado.add(pr[11]);
            acerto.add(pr[12]);

            if (apuesta.get(j).equals(resultado.get(j))) {

                factor_ = (Double.parseDouble(factor.get(j).toString()) * Double.parseDouble(acerto.get(j).toString()));
                apuesta_cantidad = apuesta_cantidad * factor_;
                resultado_jugada.add("<b>TICKET: " + pr[0] + "   " + "PARTIDO: " + pr[1] + "   " + "APUESTA: " + pr[6] + "   " + "FACTOR: " + pr[8] + "   " + "RESULTADO: " + pr[11] + "   " + "ACERTO: " + pr[12] + " Jugada Acertada</b>");
            } else {

                factor_ = (Double.parseDouble(factor.get(j).toString()) * Double.parseDouble(acerto.get(j).toString()));
                apuesta_cantidad = apuesta_cantidad * factor_;
                resultado_jugada.add("TICKET: " + pr[0] + "   " + "PARTIDO: " + pr[1] + "   " + "APUESTA: " + pr[6] + "   " + "FACTOR: " + pr[8] + "   " + "RESULTADO: " + pr[11] + "   " + "ACERTO: " + pr[12]);
            }
        }
        for (int k = 0; k < resultado_jugada.size(); k++) {
            System.out.println("JUGADAS : " + resultado_jugada.get(k));
        }
        System.out.println("RESULTADO DE APUESTA : " + apuesta_cantidad);
        num_a.resultado_premio_teapuesto=apuesta_cantidad;

        return resultado_jugada;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author developer5
 */
package pe.com.intralot.loto.util;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;

import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.CombinacionesUtil;
import pe.com.intralot.loto.util.CotejadorUtil;


public class Super3cotejadorUtil {

	ArrayList jugada_entrada = new ArrayList();
    ArrayList jugada_entrada_pivo = new ArrayList();
    ArrayList resultado_entrada_pivo = new ArrayList();
    CotejadorUtil or_array = new CotejadorUtil();
    ArrayList resultado_de_jugada = new ArrayList();
    String jugada_completa = "", acierto_bolilla = "";
    CotejadorUtil ad = new CotejadorUtil();
    int tres_orden = 0, contador = 0, r = 0, ind = 0;
    AciertoscotejadorUtil s = new AciertoscotejadorUtil();
    String jugada_final = "", jug_variable = "", vari = "", variable_jugada = "", vari_acertados = "", var_acertados = "";
    int indicador_desordenado = 0;

    public ArrayList metodo_ordenamiento(String clase_jugada,String jugada, String resultado, String tres_desorden, String tres_orden, String dos_orden, String uno_orden) {
        ArrayList jugada_resultado = new ArrayList();

        if (tres_desorden.equals("si")) {
            cualquier_orden(clase_jugada,jugada, resultado);
        }
        if (tres_orden.equals("si")) {
            tres_ordenada(clase_jugada,jugada, resultado, tres_desorden);
        }
        if (dos_orden.equals("si")) {
            dos_ordenada(clase_jugada,jugada, resultado, tres_desorden, tres_orden);
        }
        if (uno_orden.equals("si")) {
            uno_ordenada(clase_jugada,jugada, resultado, tres_desorden, tres_orden, dos_orden);
        }

        jugada_resultado = resultado_de_jugada;
        return jugada_resultado;
    }

    public void cualquier_orden(String clase_jugada,String jugada, String resultado) {

        resultado_entrada_pivo = ad.genera_array_entrada(resultado);
        jugada_entrada = or_array.genera_array(jugada);

        for (int i = 0; i < jugada_entrada.size(); i++) {
            String variable = jugada_entrada.get(i).toString();
            for (int k = 0; k < variable.length(); k++) {
                jugada_entrada_pivo.add(variable.substring(k, k + 1));
                jug_variable = variable.substring(k, k + 1);

                for (int h = 0; h < variable.length(); h++) {
                    if (jug_variable.equals(resultado_entrada_pivo.get(h))) {
                        vari = jug_variable;
                        vari_acertados = "<b>" + jug_variable + "</b> ";
                        ind++;
                        r = 1;
                        if (ind == 3) {
                            ind = 0;
                        }
                        if (ind == 1) {
                            resultado_entrada_pivo.set(h, "H");
                            ind = 0;
                        }
                        break;
                    } else if (!jug_variable.equals(resultado_entrada_pivo.get(h))) {
                        if (r == 0) {
                            vari = jug_variable;
                            r = 1;
                        }
                    }
                }
                r = 0;
                variable_jugada = variable_jugada + vari;
                var_acertados = var_acertados + vari_acertados;
                if (!"".equals(vari_acertados)) {
                    contador++;

                }
                jugada_entrada_pivo.remove(0);
                vari_acertados = "";
                if (contador == 3) {
                    tres_orden++;
                    acierto_bolilla = "=> 3 en cualquier orden";
                    if(clase_jugada.equals("A")){
                    s.aciertos_super3_desordenA = tres_orden;
                    }else if(clase_jugada.equals("B")){
                    s.aciertos_super3_desordenB = tres_orden;	
                    }
                  
                    jugada_final = var_acertados + " ";
                } else {

                    jugada_final = variable_jugada + " ";

                }
            }

            contador = 0;
            resultado_entrada_pivo = ad.genera_array_entrada(resultado);
            jugada_completa = jugada_completa + jugada_final + " ";

            resultado_de_jugada.add(jugada_final + acierto_bolilla);
            variable_jugada = "";
            var_acertados = "";
            acierto_bolilla = "";

        }
    }

//COMIENZO DEL SEGUNDO METODO TRES EN ORDEN
    public void tres_ordenada(String clase_jugada,String jugada, String resultado, String tres_desordenada) {
        jugada_entrada = or_array.genera_array(jugada);
        int indicado = 0;
        String jugada_uno = "", jugada_dos = "", jugada_tres = "";
        for (int i = 0; i < jugada_entrada.size(); i++) {
            String variable = jugada_entrada.get(i).toString().trim();
            jugada_uno = variable.substring(0, 1);
            jugada_dos = variable.substring(1, 2);
            jugada_tres = variable.substring(2, 3);
            System.out.println("****************************************************************************");
            System.out.println("JUGADA 3 --------------------> :  "+jugada_entrada.get(i)+"  -  "+resultado);
            System.out.println("****************************************************************************");
            if (jugada_entrada.get(i).equals(resultado.trim())) {
            	if(clase_jugada.equals("A")){
            		s.aciertos_super3_3ordenA++;	
            	}else if(clase_jugada.equals("B")){
            		s.aciertos_super3_3ordenB++;
            	}
                
                indicado = 1;
                if (tres_desordenada.equals("si")) {
                    resultado_de_jugada.set(i, resultado_de_jugada.get(i) + ", 3 en orden");
                } else {
                    resultado_de_jugada.add("<b>" + jugada_uno + " " + jugada_dos + " " + jugada_tres + "</b> " + "=> 3 en orden");
                }
            } else {
                if (tres_desordenada.equals("no")) {
                    resultado_de_jugada.add(jugada_uno + " " + jugada_dos + " " + jugada_tres);
                }
            }
        }
    }
//FIN DEL METODO TRES EN ORDEN

//COMIENZO DEL TERCER METODO DOS EN ORDEN
    public void dos_ordenada(String clase_jugada,String jugada, String resultado, String tres_desordenada, String tres_ordenada) {
        int indica = 0, contador_recorrido = 0, ac_uno = 0, ac_dos = 0, ac_tres = 0;
        jugada_entrada = or_array.genera_array(jugada);
        for (int i = 0; i < jugada_entrada.size(); i++) {
            String variable = jugada_entrada.get(i).toString().trim();
            String jugada_uno = "", jugada_dos = "", jugada_tres = "", resultado_uno = "", resultado_dos = "", resultado_tres = "";
            jugada_uno = variable.substring(0, 1);
            jugada_dos = variable.substring(1, 2);
            jugada_tres = variable.substring(2, 3);
            resultado_uno = resultado.substring(1, 2);
            resultado_dos = resultado.substring(2, 3);
            resultado_tres = resultado.substring(3, 4);
            if ((jugada_uno + jugada_dos).equals(resultado_uno + resultado_dos)) {
                indica++;
                ac_uno++;
                if(clase_jugada.equals("A")){
                	s.aciertos_super3_2ordenA++;	
                }else if(clase_jugada.equals("B")){}
                	s.aciertos_super3_2ordenB++;
            }
            if ((jugada_dos + jugada_tres).equals(resultado_dos + resultado_tres)) {
                indica++;
                ac_dos++;
                if(clase_jugada.equals("A")){
                	s.aciertos_super3_2ordenA++;	
                }else if(clase_jugada.equals("B")){}
                	s.aciertos_super3_2ordenB++;
            }
            if ((jugada_uno + jugada_tres).equals(resultado_uno + resultado_tres)) {
                indica++;
                ac_tres++;
                if(clase_jugada.equals("A")){
                	s.aciertos_super3_2ordenA++;	
                }else if(clase_jugada.equals("B")){
                	s.aciertos_super3_2ordenB++;
                }
            }
            if (resultado_de_jugada.size() == jugada_entrada.size()) {

                contador_recorrido = busquedaCaracter(resultado_de_jugada.get(i).toString().trim());
                if (contador_recorrido > 0) {
                    if (indica > 0) {
                        resultado_de_jugada.set(i, resultado_de_jugada.get(i) + ",(" + indica + ") 2 en orden");
                    }
                    indica = 0;
                    ac_uno = 0;
                    ac_dos = 0;
                    ac_tres = 0;
                } else if (contador_recorrido < 1) {
                    if (ac_uno > 0 && ac_dos < 1 && ac_tres < 1) {
                        if (indica > 0) {
                            resultado_de_jugada.set(i, "<b>" + jugada_uno + " " + jugada_dos + "</b> " + jugada_tres + " => (" + indica + ") 2 en orden");
                        }
                    } else if (ac_uno < 1 && ac_dos > 0 && ac_tres < 1) {
                        if (indica > 0) {
                            resultado_de_jugada.set(i, jugada_uno + " <b>" + jugada_dos + " " + jugada_tres + "</b> " + "=> (" + indica + ") 2 en orden");
                        }
                    } else if (ac_uno < 1 && ac_dos < 1 && ac_tres > 0) {
                        if (indica > 0) {
                            resultado_de_jugada.set(i, "<b>" + jugada_uno + "</b> " + jugada_dos + " <b>" + jugada_tres + "</b> " + "=> (" + indica + ") 2 en orden");
                        }
                    } else {
                        if (indica > 0) {
                            resultado_de_jugada.set(i, "<b>" + jugada_uno + " " + jugada_dos + " " + jugada_tres + "</b> => (" + indica + ") 2 en orden");
                        } else {
                            resultado_de_jugada.set(i, jugada_uno + " " + jugada_dos + " " + jugada_tres + " ");
                        }
                    }
                    indica = 0;
                    ac_uno = 0;
                    ac_dos = 0;
                    ac_tres = 0;
                }
            } else {
                if (ac_uno > 0 && ac_dos < 1 && ac_tres < 1) {
                    if (indica > 0) {
                        resultado_de_jugada.add("<b>" + jugada_uno + " " + jugada_dos + "</b> " + jugada_tres + " => (" + indica + ") 2 en orden");
                    }
                } else if (ac_uno < 1 && ac_dos > 0 && ac_tres < 1) {
                    if (indica > 0) {
                        resultado_de_jugada.add(jugada_uno + " <b>" + jugada_dos + " " + jugada_tres + "</b> " + "=> (" + indica + ") 2 en orden");
                    }
                } else if (ac_uno < 1 && ac_dos < 1 && ac_tres > 0) {
                    if (indica > 0) {
                        resultado_de_jugada.add("<b>" + jugada_uno + "</b> " + jugada_dos + " <b>" + jugada_tres + "</b> " + "=> (" + indica + ") 2 en orden");
                    }
                } else {
                    if (indica > 0) {
                        resultado_de_jugada.add("<b>" + jugada_uno + " " + jugada_dos + " " + jugada_tres + "</b> => (" + indica + ") 2 en orden");
                    } else {
                        resultado_de_jugada.add(jugada_uno + " " + jugada_dos + " " + jugada_tres + " ");
                    }
                }
                indica = 0;
                ac_uno = 0;
                ac_dos = 0;
                ac_tres = 0;
            }
        }
    }
//FIN DEL METODO DOS EN ORDEN

//COMIENZO DEL METODO UNO EN ORDEN
    public void uno_ordenada(String clase_jugada,String jugada, String resultado, String tres_desordenada, String tres_ordenada, String dos_ordenada) {
        int indica = 0, contador_recorrido = 0, ac_uno = 0, ac_dos = 0, ac_tres = 0;
        jugada_entrada = or_array.genera_array(jugada);
        for (int i = 0; i < jugada_entrada.size(); i++) {
            String variable = jugada_entrada.get(i).toString().trim();
            String jugada_uno = "", jugada_dos = "", jugada_tres = "", resultado_uno = "", resultado_dos = "", resultado_tres = "";
            jugada_uno = variable.substring(0, 1);
            jugada_dos = variable.substring(1, 2);
            jugada_tres = variable.substring(2, 3);
            resultado_uno = resultado.substring(1, 2);
            resultado_dos = resultado.substring(2, 3);
            resultado_tres = resultado.substring(3, 4);

            if (jugada_uno.equals(resultado_uno)) {
                indica++;
                ac_uno++;
                if(clase_jugada.equals("A")){
                	s.aciertos_super3_1ordenA++;	
                }else if(clase_jugada.equals("B")){
                	s.aciertos_super3_1ordenB++;
                }
            }
            if (jugada_dos.equals(resultado_dos)) {
                indica++;
                ac_dos++;
                if(clase_jugada.equals("A")){
                	s.aciertos_super3_1ordenA++;	
                }else if(clase_jugada.equals("B")){
                	s.aciertos_super3_1ordenB++;
                }
            }
            if (jugada_tres.equals(resultado_tres)) {
                indica++;
                ac_tres++;
                if(clase_jugada.equals("A")){
                	s.aciertos_super3_1ordenA++;	
                }else if(clase_jugada.equals("B")){
                	s.aciertos_super3_1ordenB++;
                }
            }
            if (resultado_de_jugada.size() == jugada_entrada.size()) {
                contador_recorrido = busquedaCaracter(resultado_de_jugada.get(i).toString().trim());
                if (contador_recorrido > 0) {
                    resultado_de_jugada.set(i, resultado_de_jugada.get(i) + ",(" + indica + ") 1 en orden");
                    indica = 0;
                    ac_uno = 0;
                    ac_dos = 0;
                    ac_tres = 0;
                } else if (contador_recorrido < 1) {
                    if (ac_uno > 0 && ac_dos < 1 && ac_tres < 1) {
                        resultado_de_jugada.set(i, "<b>" + jugada_uno + "</b> " + jugada_dos + " " + jugada_tres + " => (" + indica + ") 1 en orden");
                    } else if (ac_uno > 0 && ac_dos < 1 && ac_tres > 0) {
                        resultado_de_jugada.set(i, "<b>" + jugada_uno + "</b> " + jugada_dos + " <b>" + jugada_tres + "</b>" + " => (" + indica + ") 1 en orden");
                    } else if (ac_uno > 0 && ac_dos > 0 && ac_tres < 1) {
                        resultado_de_jugada.set(i, "<b>" + jugada_uno + "</b> " + "<b>" + jugada_tres + "</b> " + jugada_tres + " => (" + indica + ") 1 en orden");
                    } else if (ac_uno < 1 && ac_dos > 0 && ac_tres > 0) {
                        resultado_de_jugada.set(i, jugada_uno + " <b>" + jugada_tres + "</b>" + " <b>" + jugada_tres + "</b>" + " => (" + indica + ") 1 en orden");
                    } else if (ac_uno < 1 && ac_dos < 1 && ac_tres > 0) {
                        resultado_de_jugada.set(i, jugada_uno + " " + jugada_dos + " <b>" + jugada_tres + "</b>" + " => (" + indica + ") 1 en orden");
                    } else if (ac_uno < 1 && ac_dos > 0 && ac_tres < 1) {
                        resultado_de_jugada.set(i, jugada_uno + " " + "<b>" + jugada_tres + "</b> " + jugada_tres + " => (" + indica + ") 1 en orden");
                    } else {
                        if (indica > 0) {
                            resultado_de_jugada.set(i, "<b>" + jugada_uno + " " + jugada_dos + " " + jugada_tres + "</b> => (" + indica + ") 1 en orden");
                        } else {
                            resultado_de_jugada.set(i, jugada_uno + " " + jugada_dos + " " + jugada_tres + " ");
                        }
                    }
                    indica = 0;
                    ac_uno = 0;
                    ac_dos = 0;
                    ac_tres = 0;
                }
            } else {
                if (ac_uno > 0 && ac_dos < 1 && ac_tres < 1) {
                    resultado_de_jugada.add("<b>" + jugada_uno + "</b> " + jugada_dos + " " + jugada_tres + " => (" + indica + ") 1 en orden");
                } else if (ac_uno > 0 && ac_dos < 1 && ac_tres > 0) {
                    resultado_de_jugada.add("<b>" + jugada_uno + "</b> " + jugada_dos + " <b>" + jugada_tres + "</b>" + " => (" + indica + ") 1 en orden");
                } else if (ac_uno > 0 && ac_dos > 0 && ac_tres < 1) {
                    resultado_de_jugada.add("<b>" + jugada_uno + "</b> " + "<b>" + jugada_tres + "</b> " + jugada_tres + " => (" + indica + ") 1 en orden");
                } else if (ac_uno < 1 && ac_dos > 0 && ac_tres > 0) {
                    resultado_de_jugada.add(jugada_uno + " <b>" + jugada_tres + "</b>" + " <b>" + jugada_tres + "</b>" + " => (" + indica + ") 1 en orden");
                } else if (ac_uno < 1 && ac_dos < 1 && ac_tres > 0) {
                    resultado_de_jugada.add(jugada_uno + " " + jugada_dos + " <b>" + jugada_tres + "</b>" + " => (" + indica + ") 1 en orden");
                } else if (ac_uno < 1 && ac_dos > 0 && ac_tres < 1) {
                    resultado_de_jugada.add(jugada_uno + " " + "<b>" + jugada_tres + "</b> " + jugada_tres + " => (" + indica + ") 1 en orden");
                } else {
                    if (indica > 0) {
                        resultado_de_jugada.add("<b>" + jugada_uno + " " + jugada_dos + " " + jugada_tres + "</b> => (" + indica + ") 1 en orden");
                    } else {
                        resultado_de_jugada.add(jugada_uno + " " + jugada_dos + " " + jugada_tres + " ");
                    }
                }
                indica = 0;
                ac_uno = 0;
                ac_dos = 0;
                ac_tres = 0;
            }
        }
    }
//FIN DEL METODO UNO EN ORDEN

    public int busquedaCaracter(String variable) {
        int caracter = 0;
        for (int i = 0; i < variable.length(); i++) {
            if (variable.charAt(i) == '<') {
                caracter++;
            }

        }
        return caracter;
    }
    
    public void reinicioValores(){
    	AciertoscotejadorUtil s = new AciertoscotejadorUtil();
 		 s.aciertos_super3_1ordenA=0;
 		s.aciertos_super3_1ordenB=0;
 		s.aciertos_super3_2ordenA=0;
 		s.aciertos_super3_2ordenB=0;
 		s.aciertos_super3_3ordenA=0;
 		s.aciertos_super3_3ordenB=0;
 		s.aciertos_super3_desordenA=0;
 		s.aciertos_super3_desordenB=0;
    	
    }
    
    
 
}
//FIN DEL METODO DOS EN ORDEN


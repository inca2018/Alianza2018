package inca.jesus.alianza17.Clases;

import android.provider.ContactsContract;

/**
 * Created by Jesus on 20/06/2017.
 */

public class DataServer {

    public DataServer(){
    }

    public static String COMPETENCIA="";
    public static String RIVAL="";
    public static int GOLES=0;
    public static int TIEM_JUG=0;
    public static Boolean TITULAR=false;
    public static Boolean CAPITAN=false;
    public static Boolean CORTE=false;
    public static Boolean CORTE2=false;
    public static int COD=0;
    public static int COD_EVENTO=0;
    public static final DataServer Data= new DataServer();


    public static final String VALIDAR_SESION="http://alianza2.esy.es/php2/LoginAL.php";
    public static final String LISTAR_DEPORTISTAS="http://alianza2.esy.es/php2/Deportista_Listar.php";
    public static final String REGISTRAR_DEPORTISTAS="http://alianza2.esy.es/php2/registroDeportista.php";
    public static final String REGISTRAR_EVA2="http://alianza2.esy.es/php2/registro_ev2.php";
    public static final String REGISTRAR_EV_EQUIPO="http://alianza2.esy.es/php2/Registrar_Evento_Equipo.php";
    public static final String LISTAR_EVALUACION2="http://alianza2.esy.es/php2/ListarEva2conGET.php?id=";
    public static final String LISTAR_EVENTOS="http://alianza2.esy.es/php2/ListarEventos.php";
    public static final String LISTAR_POSTULANTES="http://alianza2.esy.es/php2/ListarJugadoresConGET.php?id=";
    public static final String LISTA_USER="http://alianza2.esy.es/php2/Usuario_Listar.php";
    public static final String DELETE_USER="http://alianza2.esy.es/php2/Usuario_Eliminar.php";
    public static final String INSERT_USER="http://alianza2.esy.es/php2/Usuario_Registrar.php";
    public static final String UPDATE_USER="http://alianza2.esy.es/php2/Usuario_Actualizar.php";
    public static final String PERMISO_GET_USER="http://alianza2.esy.es/php2/Usuario_Permiso_Get.php";
    public static final String PERMISO_UPDATE_USER="http://alianza2.esy.es/php2/Usuario_Permiso_Set.php";
    public static final String PERFIL_LISTA="http://alianza2.esy.es/php2/Perfil_Lista.php";
    public static final String PERFIL_BUSCAR="http://alianza2.esy.es/php2/Perfil_BuscarNombre.php?cod=";
    public static final String PERFIL_DELETE="http://alianza2.esy.es/php2/Perfil_Eliminar.php";
    public static final String PERFIL_INSERT="http://alianza2.esy.es/php2/Perfil_Registrar.php";
    public static final String PERFIL_GET_MODULO="http://alianza2.esy.es/php2/Perfil_Modulos_Get.php";
    public static final String PERFIL_SET_MODULO="http://alianza2.esy.es/php2/Perfil_Modulos_Set.php";
    public static final String CATEGORIA_INSERT="http://alianza2.esy.es/php2/Categoria_Registro.php";
    public static final String CATEGORIA_DELETE="http://alianza2.esy.es/php2/Categoria_Eliminar.php";
    public static final String CATEGORIA_LISTA="http://alianza2.esy.es/php2/Categoria_Listar.php";
    public static final String CATEGORIA_LISTA_JUGADOR="http://alianza2.esy.es/php2/Categoria_Listar_Jugadores.php?cod=";
    public static final String CATEGORIA_INSERT_JUGADOR="http://alianza2.esy.es/php2/Categoria_Insert_Jugador.php";
    public static final String CATEGORIA_ELIMINAR_JUGADOR="http://alianza2.esy.es/php2/Categoria_Eliminar_Jugador.php";
    public static final String MIEQUIPO_LISTA="http://alianza2.esy.es/php2/Mi_Equipo_Listar.php";
    public static final String MIEQUIPO_INSERT="http://alianza2.esy.es/php2/Mi_Equipo_Registro.php";
    public static final String MIEQUIPO_ELIMINAR_JUGADOR="http://alianza2.esy.es/php2/MI_Equipo_Eliminar_Jugador.php";
    public static final String MIEQUIPO_DELETE="http://alianza2.esy.es/php2/Mi_Equipo_Eliminar.php";
    public static final String MIEQUIPO_LISTA_JUGADOR="http://alianza2.esy.es/php2/Mi_Equipo_Listar_Jugadores.php?cod=";
    public static final String MIEQUIPO_INSERT_JUGADOR="http://alianza2.esy.es/php2/Mi_Equipo_Insert_Jugador.php";
    public static final String PLANTEL_LISTA="http://alianza2.esy.es/php2/Plantel_Listar.php";
    public static final String PLANTEL_DELETE="http://alianza2.esy.es/php2/Plantel_Eliminar.php";
    public static final String PLANTEL_INSERT="http://alianza2.esy.es/php2/Plantel_Insertar_Get.php?";
    public static final String PLANTEL_UPDATE="http://alianza2.esy.es/php2/Plantel_Actualizar_Get.php?";
    public static final String EVENTO_C_LISTAR="http://alianza2.esy.es/php2/Evento_Camp_Listar.php";
    public static final String EVENTO_C_LISTAR_EQUIPOS="http://alianza2.esy.es/php2/Evento_Camp_Listar_Equipos.php";
    public static final String EVENTO_C_INSERT="http://alianza2.esy.es/php2/Evento_Camp_Registro.php";
    public static final String EVENTO_C_UPDATE="http://alianza2.esy.es/php2/Evento_Camp_Actualizar.php";
    public static final String EVENTO_C_ELIMINAR="http://alianza2.esy.es/php2/Evento_Camp_Eliminar.php";
    public static final String POSICIONES_LISTAR="http://alianza2.esy.es/php2/Posiciones_Listar.php";
    public static final String OPONENTES_LISTAR="http://alianza2.esy.es/php2/Listar_Oponentes.php";
    public static final String REGISTRO_FECHA="http://alianza2.esy.es/php2/Evento_Camp_Registro_Fecha.php";
    public static final String LISTAR_FECHA="http://alianza2.esy.es/php2/Listar_Fecha_de_Evento.php?cod=";
    public static final String GESTION="http://alianza2.esy.es/php2/GESTION_CAMPO.php";
    public static final String LIST_GES_EQUIPO="http://alianza2.esy.es/php2/Gestion_listar_equipo.php?id1=";
    public static final String REGISTRO_ESTADISTICO="http://alianza2.esy.es/php2/Registrar_estadistico.php";
    public static final String REGISTRO_ESTADISTICO2="http://alianza2.esy.es/php2/Registro_Estadistico2.php";
    public static final String REGISTRO_DATA2="http://alianza2.esy.es/php2/B_Registro_Diagnostico.php";
    public static final String VALIDAR_FISICO="http://alianza2.esy.es/php2/B_validarPFisica.php";
    public static final String REGISTRO_FISICO="http://alianza2.esy.es/php2/B_Registro_Prueba_Fisico.php";
    public static final String VALIDAR_TECNICO="http://alianza2.esy.es/php2/B_validarPTecnica.php";
    public static final String REGISTRO_TECNICO="http://alianza2.esy.es/php2/B_Registro_Prueba_Tecnico.php";
    public static final String VALIDAR_DIAG="http://alianza2.esy.es/php2/B_validarDiag.php";
    public static final String VALIDAR_PUNT="http://alianza2.esy.es/php2/B_validarPuntajes.php";
    public static final String MOSTRAR_PUNTOS="http://alianza2.esy.es/php2/B_puntajes.php";
    public static final String LISTAR_BARRIO="http://alianza2.esy.es/php2/Lista_barrio.php";
    public static final String ACTIVACION="http://alianza2.esy.es/php2/Activacion.php";
    public static final String DESACTIVACION="http://alianza2.esy.es/php2/DesActivacion.php";
    public static final String DELETE_EVENTO="http://alianza2.esy.es/php2/Eliminar_Evento_Barrio.php";
    public static final String DETALLE_1="http://alianza2.esy.es/php2/Detalle_parte1.php";
    public static final String DETALLE_2="http://alianza2.esy.es/php2/Detalle_parte2.php?cod1=";
    public static final String BARRIO_INSERT="http://alianza2.esy.es/php2/Evento_Barrio_insertar.php";
    public static final String POST_ELIMINAR="http://alianza2.esy.es/php2/Postulante_Eliminar.php";
    public static final String INSERT_POS="http://alianza2.esy.es/php2/Postulante_Insertar.php";
    public static final String RESU1="http://alianza2.esy.es/php2/Resultados1.php";

/*
    public static final String VALIDAR_SESION="http://futuroblanquiazul.org/alianza/LoginAL.php";
    public static final String LISTAR_DEPORTISTAS="http://futuroblanquiazul.org/alianza/Deportista_Listar.php";
    public static final String REGISTRAR_DEPORTISTAS="http://futuroblanquiazul.org/alianza/registroDeportista.php";
    public static final String REGISTRAR_EVA2="http://futuroblanquiazul.org/alianza/registro_ev2.php";
    public static final String REGISTRAR_EV_EQUIPO="http://futuroblanquiazul.org/alianza/Registrar_Evento_Equipo.php";
    public static final String LISTAR_EVALUACION2="http://futuroblanquiazul.org/alianza/ListarEva2conGET.php?id=";
    public static final String LISTAR_EVENTOS="http://futuroblanquiazul.org/alianza/ListarEventos.php";
    public static final String LISTAR_POSTULANTES="http://futuroblanquiazul.org/alianza/ListarJugadoresConGET.php?id=";
    public static final String LISTA_USER="http://futuroblanquiazul.org/alianza/Usuario_Listar.php";
    public static final String DELETE_USER="http://futuroblanquiazul.org/alianza/Usuario_Eliminar.php";
    public static final String INSERT_USER="http://futuroblanquiazul.org/alianza/Usuario_Registrar.php";
    public static final String UPDATE_USER="http://futuroblanquiazul.org/alianza/Usuario_Actualizar.php";
    public static final String PERMISO_GET_USER="http://futuroblanquiazul.org/alianza/Usuario_Permiso_Get.php";
    public static final String PERMISO_UPDATE_USER="http://futuroblanquiazul.org/alianza/Usuario_Permiso_Set.php";
    public static final String PERFIL_LISTA="http://futuroblanquiazul.org/alianza/Perfil_Lista.php";
    public static final String PERFIL_BUSCAR="http://futuroblanquiazul.org/alianza/Perfil_BuscarNombre.php?cod=";
    public static final String PERFIL_DELETE="http://futuroblanquiazul.org/alianza/Perfil_Eliminar.php";
    public static final String PERFIL_INSERT="http://futuroblanquiazul.org/alianza/Perfil_Registrar.php";
    public static final String PERFIL_GET_MODULO="http://futuroblanquiazul.org/alianza/Perfil_Modulos_Get.php";
    public static final String PERFIL_SET_MODULO="http://futuroblanquiazul.org/alianza/Perfil_Modulos_Set.php";
    public static final String CATEGORIA_INSERT="http://futuroblanquiazul.org/alianza/Categoria_Registro.php";
    public static final String CATEGORIA_DELETE="http://futuroblanquiazul.org/alianza/Categoria_Eliminar.php";
    public static final String CATEGORIA_LISTA="http://futuroblanquiazul.org/alianza/Categoria_Listar.php";
    public static final String CATEGORIA_LISTA_JUGADOR="http://futuroblanquiazul.org/alianza/Categoria_Listar_Jugadores.php?cod=";
    public static final String CATEGORIA_INSERT_JUGADOR="http://futuroblanquiazul.org/alianza/Categoria_Insert_Jugador.php";
    public static final String CATEGORIA_ELIMINAR_JUGADOR="http://futuroblanquiazul.org/alianza/Categoria_Eliminar_Jugador.php";
    public static final String MIEQUIPO_LISTA="http://futuroblanquiazul.org/alianza/Mi_Equipo_Listar.php";
    public static final String MIEQUIPO_INSERT="http://futuroblanquiazul.org/alianza/Mi_Equipo_Registro.php";
    public static final String MIEQUIPO_ELIMINAR_JUGADOR="http://futuroblanquiazul.org/alianza/MI_Equipo_Eliminar_Jugador.php";
    public static final String MIEQUIPO_DELETE="http://futuroblanquiazul.org/alianza/Mi_Equipo_Eliminar.php";
    public static final String MIEQUIPO_LISTA_JUGADOR="http://futuroblanquiazul.org/alianza/Mi_Equipo_Listar_Jugadores.php?cod=";
    public static final String MIEQUIPO_INSERT_JUGADOR="http://futuroblanquiazul.org/alianza/Mi_Equipo_Insert_Jugador.php";
    public static final String PLANTEL_LISTA="http://futuroblanquiazul.org/alianza/Plantel_Listar.php";
    public static final String PLANTEL_DELETE="http://futuroblanquiazul.org/alianza/Plantel_Eliminar.php";
    public static final String PLANTEL_INSERT="http://futuroblanquiazul.org/alianza/Plantel_Insertar_Get.php?";
    public static final String PLANTEL_UPDATE="http://futuroblanquiazul.org/alianza/Plantel_Actualizar_Get.php?";
    public static final String EVENTO_C_LISTAR="http://futuroblanquiazul.org/alianza/Evento_Camp_Listar.php";
    public static final String EVENTO_C_LISTAR_EQUIPOS="http://futuroblanquiazul.org/alianza/Evento_Camp_Listar_Equipos.php";
    public static final String EVENTO_C_INSERT="http://futuroblanquiazul.org/alianza/Evento_Camp_Registro.php";
    public static final String EVENTO_C_UPDATE="http://futuroblanquiazul.org/alianza/Evento_Camp_Actualizar.php";
    public static final String EVENTO_C_ELIMINAR="http://futuroblanquiazul.org/alianza/Evento_Camp_Eliminar.php";
    public static final String POSICIONES_LISTAR="http://futuroblanquiazul.org/alianza/Posiciones_Listar.php";
    public static final String OPONENTES_LISTAR="http://futuroblanquiazul.org/alianza/Listar_Oponentes.php";
    public static final String REGISTRO_FECHA="http://futuroblanquiazul.org/alianza/Evento_Camp_Registro_Fecha.php";
    public static final String LISTAR_FECHA="http://futuroblanquiazul.org/alianza/Listar_Fecha_de_Evento.php?cod=";
    public static final String GESTION="http://futuroblanquiazul.org/alianza/GESTION_CAMPO.php";
    public static final String LIST_GES_EQUIPO="http://futuroblanquiazul.org/alianza/Gestion_listar_equipo.php?id1=";
    public static final String REGISTRO_ESTADISTICO="http://futuroblanquiazul.org/alianza/Registrar_estadistico.php";
    public static final String REGISTRO_ESTADISTICO2="http://futuroblanquiazul.org/alianza/Registro_Estadistico2.php";
    public static final String REGISTRO_DATA2="http://futuroblanquiazul.org/alianza/B_Registro_Diagnostico.php";
    public static final String VALIDAR_FISICO="http://futuroblanquiazul.org/alianza/B_validarPFisica.php";
    public static final String REGISTRO_FISICO="http://futuroblanquiazul.org/alianza/B_Registro_Prueba_Fisico.php";
    public static final String VALIDAR_TECNICO="http://futuroblanquiazul.org/alianza/B_validarPTecnica.php";
    public static final String REGISTRO_TECNICO="http://futuroblanquiazul.org/alianza/B_Registro_Prueba_Tecnico.php";
    public static final String VALIDAR_DIAG="http://futuroblanquiazul.org/alianza/B_validarDiag.php";
    public static final String VALIDAR_PUNT="http://futuroblanquiazul.org/alianza/B_validarPuntajes.php";
    public static final String MOSTRAR_PUNTOS="http://futuroblanquiazul.org/alianza/B_puntajes.php";
    public static final String LISTAR_BARRIO="http://futuroblanquiazul.org/alianza/Lista_barrio.php";
    public static final String ACTIVACION="http://futuroblanquiazul.org/alianza/Activacion.php";
    public static final String DESACTIVACION="http://futuroblanquiazul.org/alianza/DesActivacion.php";
    public static final String DELETE_EVENTO="http://futuroblanquiazul.org/alianza/Eliminar_Evento_Barrio.php";
    public static final String DETALLE_1="http://futuroblanquiazul.org/alianza/Detalle_parte1.php";
    public static final String DETALLE_2="http://futuroblanquiazul.org/alianza/Detalle_parte2.php?cod1=";
    public static final String BARRIO_INSERT="http://futuroblanquiazul.org/alianza/Evento_Barrio_insertar.php";
    public static final String POST_ELIMINAR="http://futuroblanquiazul.org/alianza/Postulante_Eliminar.php";
    public static final String INSERT_POS="http://futuroblanquiazul.org/alianza/Postulante_Insertar.php";
    public static final String RESU1="http://futuroblanquiazul.org/alianza/Resultados1.php";*/

}

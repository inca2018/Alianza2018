package inca.jesus.alianza17.Clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Jugadores_Plantel implements Parcelable {
    public int Id;
    public String Nombres;
    public int DNI;
    public String Fecha_nacimiento;
    public boolean isSelected;

    public static final List<Jugadores_Plantel> CAT99=new ArrayList<Jugadores_Plantel>();
    public static final List<Jugadores_Plantel> CAT2000=new ArrayList<Jugadores_Plantel>();
    public static final List<Jugadores_Plantel> CAT2001=new ArrayList<Jugadores_Plantel>();
    public static final List<Jugadores_Plantel> CAT2002=new ArrayList<Jugadores_Plantel>();
    public static final List<Jugadores_Plantel> CAT2003=new ArrayList<Jugadores_Plantel>();
    public static final List<Jugadores_Plantel> CAT2004=new ArrayList<Jugadores_Plantel>();
    public static final List<Jugadores_Plantel> CAT2005=new ArrayList<Jugadores_Plantel>();
    public static final List<Jugadores_Plantel> CAT2006=new ArrayList<Jugadores_Plantel>();
    public static final List<Jugadores_Plantel> CAT2007=new ArrayList<Jugadores_Plantel>();
    public static final List<Jugadores_Plantel> CAT2008=new ArrayList<Jugadores_Plantel>();
    public static final List<Jugadores_Plantel> CAT2009=new ArrayList<Jugadores_Plantel>();

    public static final List<Jugadores_Plantel> PLANTEL=new ArrayList<Jugadores_Plantel>();


    static{

        CAT99.add(new Jugadores_Plantel(91,"ASIN MOSQUERA ANDRES ESTEFANO",73257263,"07/02/2000",false ));
        CAT99.add(new Jugadores_Plantel(92,"CARBAJAL RIOS ALBERTO HARRY",70451195,"07/02/1999",false ));
        CAT99.add(new Jugadores_Plantel(93,"CARTY QUISPE MIGUEL",70601147,"22/02/1999",false ));
        CAT99.add(new Jugadores_Plantel(94,"CIRILO SILVA JACK HARRINSON",61915483,"27/01/1999",false ));
        CAT99.add(new Jugadores_Plantel(95,"DIAZ GUZMAN JONATHAN LUCIO",71075186,"15/03/1999",false ));
        CAT99.add(new Jugadores_Plantel(96,"FERREYRA CHONLON KEVIN",70827539,"07/06/1999",false ));
        CAT99.add(new Jugadores_Plantel(97,"JURADO GUZMAN GEREMI YORDAN",72916594,"28/04/1999",false ));
        CAT99.add(new Jugadores_Plantel(98,"PANTA COTITO RAULIHNO JEANPIERRE",71616773,"21/11/1999",false ));
        CAT99.add(new Jugadores_Plantel(99,"PANTOJA ORMEÑO CRISTHOFER",72608324,"09/02/2000",false ));
        CAT99.add(new Jugadores_Plantel(910,"PRADO MAYTA CESAR",70799345,"26/02/1999",false ));
        CAT99.add(new Jugadores_Plantel(911,"ROSAS CRUZ SEBASTIAN PEDRO",71586799,"31/03/2000",false ));
        CAT99.add(new Jugadores_Plantel(912,"RUIZ CRIOLLO ROGER ALEXANDER",70400146,"28/01/2000",false ));
        CAT99.add(new Jugadores_Plantel(913,"SALAZAR QUELOPANA FABRIZIO",78804670,"29/06/2000",false ));
        CAT99.add(new Jugadores_Plantel(914,"SARAVIA ROJAS FRANCO",70930631,"02/06/1999",false ));
        CAT99.add(new Jugadores_Plantel(915,"TARAZONA CUEVA DANIEL ALONSO",71198801,"27/09/1999",false ));
        CAT99.add(new Jugadores_Plantel(916,"VIDAL CASIMIRO AAROM STHEPEN",73708128,"23/08/1999",false ));
        CAT99.add(new Jugadores_Plantel(917,"VILLAVICENCIO HUAMANI CELSO",70513964,"10/08/1999",false ));
        CAT2000.add(new Jugadores_Plantel(918,"ALBINO PÉREZ JOAQUIN",74356523,"21/01/2000",false ));
        CAT2000.add(new Jugadores_Plantel(919,"ALEMAN BACA JOSE WILFREDO",74654348,"23/05/2000",false ));
        CAT2000.add(new Jugadores_Plantel(920,"ARAUJO CASTAÑEDA BRAULIO ALEXIS",71407115,"16/02/2000",false ));
        CAT2000.add(new Jugadores_Plantel(921,"BARRETO SARMIENTO JEAN CARLO",73097530,"01/03/2000",false ));
        CAT2000.add(new Jugadores_Plantel(922,"CABANILLAS COQUIS MIJAILOV ERNESTO",72630173,"05/01/2000",false ));
        CAT2000.add(new Jugadores_Plantel(923,"CAMACHO MARQUEZ G'HUUSSEEPPE CARL",73917129,"20/06/2000",false ));
        CAT2000.add(new Jugadores_Plantel(924,"CARRANZA STEVES JUAN PABLO MARIANO",72659949,"10/03/2001",false ));
        CAT2000.add(new Jugadores_Plantel(925,"CHAUCA RODRIGUEZ ERICKSON DANIEL",75593304,"04/09/2000",false ));
        CAT2000.add(new Jugadores_Plantel(926,"CORNEJO LOLI MIGUEL",72261273,"18/01/2000",false ));
        CAT2000.add(new Jugadores_Plantel(927,"COTITO PEÑA KLUBER VICTOR",73231380,"28/05/2000",false ));
        CAT2000.add(new Jugadores_Plantel(928,"GAMONAL PAUCAR CHRISTOFER JULIO",70454090,"07/02/2000",false ));
        CAT2000.add(new Jugadores_Plantel(929,"GUEVARA PAIMA SANTIAGO ALEXANDER",71217409,"07/04/2000",false ));
        CAT2000.add(new Jugadores_Plantel(930,"LALANGUI OLAYA ANGELO ANTONIO",70565546,"23/08/2000",false ));
        CAT2000.add(new Jugadores_Plantel(931,"MATZUDA GUSUKUDA MAURICIO DAIKI",73266496,"05/01/2000",false ));
        CAT2000.add(new Jugadores_Plantel(932,"MILLER MARTIJENA KENNETH",71210041,"01/01/2000",false ));
        CAT2000.add(new Jugadores_Plantel(933,"ORBE GASTELU CARLOS ALEXANDER",70880538,"17/02/2000",false ));
        CAT2000.add(new Jugadores_Plantel(934,"OSHIRO GUSHIKEN JAN POL",79707264,"15/02/2000",false ));
        CAT2000.add(new Jugadores_Plantel(935,"PEREZ CAJAVILCA AYMAR JOSUE",74244087,"05/09/2000",false ));
        CAT2000.add(new Jugadores_Plantel(936,"PINEDA SAN MIGUEL JESUS ADRIAN",75270198,"28/02/2000",false ));
        CAT2000.add(new Jugadores_Plantel(937,"QUEVEDO MATHEY EDSON SEBASTIAN ",76601815,"07/04/2000",false ));
        CAT2000.add(new Jugadores_Plantel(938,"QUIJANO LOBATON ANTHONY ",72450807,"12/07/2000",false ));
        CAT2000.add(new Jugadores_Plantel(939,"ROJAS CHICOMA GIACOMO JAIR",75424593,"15/10/2000",false ));
        CAT2000.add(new Jugadores_Plantel(940,"SAENZ GOYAS KEVIN ARTURO",74079913,"24/04/2000",false ));
        CAT2000.add(new Jugadores_Plantel(941,"SALINAS SHIGUETO MARCOS BRANDON TAKESHI",74045868,"19/03/2000",false ));
        CAT2000.add(new Jugadores_Plantel(942,"TANDAZO SILVA WALTER ANGELLO",72732232,"14/06/2000",false ));
        CAT2000.add(new Jugadores_Plantel(943,"VALENZUELA DILEO OSWALDO JOSUE",70565069,"20/12/2000",false ));
        CAT2000.add(new Jugadores_Plantel(944,"ZARATE GRAJEDA POOL EDHER",73671826,"02/01/2001",false ));
        CAT2000.add(new Jugadores_Plantel(945,"ZETA YOVERA WILMER ALESSANDRO",73451797,"14/12/2000",false ));
        CAT2001.add(new Jugadores_Plantel(946,"ALFARO FERNANDEZ RENZO ALBERTO",73999022,"21/01/2001",false ));
        CAT2001.add(new Jugadores_Plantel(947,"ALVAREZ MORALES ARILSON JAROMI",71424327,"06/06/2001",false ));
        CAT2001.add(new Jugadores_Plantel(948,"ARONI PONTE LUIGUI ALBERTH",73800814,"13/07/2001",false ));
        CAT2001.add(new Jugadores_Plantel(949,"CANO LEON MANUEL ARTURO",73755503,"30/06/2001",false ));
        CAT2001.add(new Jugadores_Plantel(950,"CARRERA GOMEZ RUBINHO RENATO",70607548,"06/01/2001",false ));
        CAT2001.add(new Jugadores_Plantel(951,"DE LA CRUZ ROBATTI JOSÉ LEONARDO",73739521,"12/01/2001",false ));
        CAT2001.add(new Jugadores_Plantel(952,"DIAZ RENGIFO LEANDRO JESÚS ENRIQUE",70426220,"14/09/2001",false ));
        CAT2001.add(new Jugadores_Plantel(953,"ESPINOZA ATOCHE DIEGO ALBERTO",72666811,"30/01/2001",false ));
        CAT2001.add(new Jugadores_Plantel(954,"GALLARDO FLORES JOSÉ ANTHONY",73898122,"15/02/2004",false ));
        CAT2001.add(new Jugadores_Plantel(955,"IPARRAGUIRRE PADILLA JOE AYRTON",75983100,"24/08/2001",false ));
        CAT2001.add(new Jugadores_Plantel(956,"MAMANI SANCHEZ JHON CLAUDIO ",70852561,"30/03/2001",false ));
        CAT2001.add(new Jugadores_Plantel(957,"MARTINEZ ALVA ERNESTO BENJAMIN",72357288,"15/01/2001",false ));
        CAT2001.add(new Jugadores_Plantel(958,"MESIA OSORIO DIEGO ALONSO",72371050,"10/04/2001",false ));
        CAT2001.add(new Jugadores_Plantel(959,"MOYANO VILLALOBOS AXEL",72410646,"03/01/2001",false ));
        CAT2001.add(new Jugadores_Plantel(960,"SANDI BEJAR  MASSIMO ENRIQUE",70675695,"12/05/2002",false ));
        CAT2001.add(new Jugadores_Plantel(961,"SOTO ZAPATA LUIS ELIS",72712280,"22/11/2001",false ));
        CAT2001.add(new Jugadores_Plantel(962,"ZUTA CORDERO LEONARDO ISRAEL",72755940,"04/03/2001",false ));
        CAT2002.add(new Jugadores_Plantel(963,"ASCUES EARL ADRIAN ADEMIR",72208974,"15/11/2002",false ));
        CAT2002.add(new Jugadores_Plantel(964,"CAJA PEÑA FLAVIO ",74806272,"11/11/2002",false ));
        CAT2002.add(new Jugadores_Plantel(965,"CASTILLO OLIVERA ADRIEL ALAIN",71030946,"12/07/2002",false ));
        CAT2002.add(new Jugadores_Plantel(966,"CASTILLO TARA ENZO FRANCHESCO",72728607,"11/11/2002",false ));
        CAT2002.add(new Jugadores_Plantel(967,"CAVERO NAKAHORO  SEBASTIÁN JOSÉ",72758990,"20/06/2002",false ));
        CAT2002.add(new Jugadores_Plantel(968,"CHÁVEZ APOLAYA ALEXIS JORDANO",77223181,"23/01/2002",false ));
        CAT2002.add(new Jugadores_Plantel(969,"DE LA CRUZ ARIAS ANGEL ALBERTO",71625412,"24/05/2002",false ));
        CAT2002.add(new Jugadores_Plantel(970,"DE LA CRUZ ESPINOZA  PEDRO GIANPIER",71344005,"15/01/2002",false ));
        CAT2002.add(new Jugadores_Plantel(971,"ESCATE GALLEGOS JEREMI ALDAIR",74125922,"04/03/2002",false ));
        CAT2002.add(new Jugadores_Plantel(972,"ESPINOZA PAREDES CARLOS FABIAN",73898499,"22/06/2002",false ));
        CAT2002.add(new Jugadores_Plantel(973,"FERNANDEZ PIZARRO STEFANO JOSÉ",70374325,"12/02/2002",false ));
        CAT2002.add(new Jugadores_Plantel(974,"FRANCO COLLANTES  ADGARY YOSSUE",75653835,"19/01/2002",false ));
        CAT2002.add(new Jugadores_Plantel(975,"GUADALUPE MOSQUERA LEONARDO DE JESUS",72552585,"28/11/2002",false ));
        CAT2002.add(new Jugadores_Plantel(976,"GUERRERO VALDIVIESO MANUEL GUILLERMO",71862187,"15/02/2002",false ));
        CAT2002.add(new Jugadores_Plantel(977,"HUAMAN JAYO JEFFERSON JOAO",73494232,"30/11/2002",false ));
        CAT2002.add(new Jugadores_Plantel(978,"JIMENEZ BENAVIDES ALEXANDER JESÚS",72169521,"20/03/2002",false ));
        CAT2002.add(new Jugadores_Plantel(979,"MILLA SCHNEIDER IAN ERIC",73314382,"04/01/2002",false ));
        CAT2002.add(new Jugadores_Plantel(980,"NAVARRO DE OS RIOS MIGUEL ADALBERTO",72306891,"16/01/2002",false ));
        CAT2002.add(new Jugadores_Plantel(981,"PEREZ CAYO CARLOS DENNIS",72492459,"07/04/2002",false ));
        CAT2002.add(new Jugadores_Plantel(982,"REGINALDO PEÑA MARKO JHAIRO",70883791,"01/02/2002",false ));
        CAT2002.add(new Jugadores_Plantel(983,"RICOPA MOLINA BRYAN STWAR",74501725,"14/02/2002",false ));
        CAT2002.add(new Jugadores_Plantel(84,"RODRIGUEZ MENESES NAHUEL JEREMY",74217461,"04/03/2002",false ));
        CAT2002.add(new Jugadores_Plantel(985,"SALAZAR MANCILLA FABRICIO IVAN",73952020,"16/11/2002",false ));
        CAT2002.add(new Jugadores_Plantel(986,"SANCHEZ FLORES JECOB ALEXANDER",70959194,"09/05/2002",false ));
        CAT2002.add(new Jugadores_Plantel(987,"VALENZUELA HERRERA PEDRO PABLO",72040588,"21/04/2002",false ));
        CAT2002.add(new Jugadores_Plantel(988,"VELARDE MARTINEZ JEFFERSON JOEL",75381547,"10/02/2002",false ));
        CAT2002.add(new Jugadores_Plantel(989,"ZEVALLOS GANOZA HUMBERTO JHERICO",77209558,"19/03/2002",false ));
        CAT2002.add(new Jugadores_Plantel(990,"ZUBIATE ACOSTA  RENZO MARIO",70441284,"25/01/2002",false ));
        CAT2003.add(new Jugadores_Plantel(991,"AMPUERO REQUEJO GIOVANNI",73201181,"15/03/2003",false ));
        CAT2003.add(new Jugadores_Plantel(992,"BUITRÓN MONCADA JUNIOR",70871859,"02/10/2003",false ));
        CAT2003.add(new Jugadores_Plantel(993,"CACHO PAEZ MARIANO",71582689,"14/04/2003",false ));
        CAT2003.add(new Jugadores_Plantel(994,"CAÑA CABELLO DENZEL FARED",75503895,"22/02/2003",false ));
        CAT2003.add(new Jugadores_Plantel(995,"CHAVEZ GRANDEZ BRIT BRYAN",73540855,"17/09/2003",false ));
        CAT2003.add(new Jugadores_Plantel(996,"CLAROS DÍAZ MARCO ANTONIO",74976063,"09/03/2003",false ));
        CAT2003.add(new Jugadores_Plantel(997,"CORDERO PEREA GLENN STEFANO",72708528,"08/05/2003",false ));
        CAT2003.add(new Jugadores_Plantel(998,"GARCIA ALVARADO ALEXANDER FAURICIO",72443411,"10/06/2003",false ));
        CAT2003.add(new Jugadores_Plantel(999,"GARCIA SINTI LEVIT",75038818,"07/11/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9100,"MESIAS SILVA PAULO CESAR",70940288,"03/09/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9101,"MONSERRATE VÁSQUEZ ITALO DAVID",76255059,"09/02/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9102,"MORALES RODRIGUEZ CARLO FABIAN",72703066,"12/02/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9103,"NAVEA TOLMOS JAVIER",72388261,"11/05/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9104,"PINEAU FLORES SEBASTIEN GERARD",78012874,"20/01/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9105,"PORTAL RODRIGUEZ ANDERSON HEISEN",72445567,"20/12/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9106,"RAMOS RIVAS JACK JOSÉ",72721951,"24/07/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9107,"SULCA URIBE JOSE JESÚS",70598653,"25/06/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9108,"TIRADO NICASIO HAIDER YASIR",71276677,"16/07/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9109,"VARGAS NÚÑEZ FABRIZIO ALONSO",70898888,"03/01/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9110,"VÁSQUEZ PIZARRO LIZARDO ANDRÉ",76545749,"30/01/2003",false ));
        CAT2003.add(new Jugadores_Plantel(9111,"VASQUEZ RAMIREZ PAULO CESAR",71542441,"09/03/2003",false ));
        CAT2004.add(new Jugadores_Plantel(9112,"ALVARADO  ARONES JUAN DANIEL ",72534257,"22/05/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9113,"AMASIFUEN DE PAZ JOSE SEBASTIAN",73598090,"06/06/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9114,"ARRASCO CALDERON JOSE MAURICIO",77679590,"26/05/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9115,"CAMONES MORA JAIR YAZID",73060681,"23/01/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9116,"CARDENAS SALAZAR SANTIAGO MOISES",60988196,"01/09/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9117,"DELGADO BOLIVAR DIEGO ADRIAN",70579351,"15/05/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9118,"DÍAZ LANDAURI JORDANY ARTYEL",73066539,"10/05/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9119,"ESTRADA RODRIGUEZ AYMAR",75359903,"04/02/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9120,"FLORES ORTIZ DE VILLATE VICTOR ALFONSO",74092393,"08/08/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9121,"FLORES RODRIGUEZ SEBASTIAN MATEO",75599284,"04/01/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9122,"LLERENA FASANANDO GERSON JAFED ",72379765,"04/01/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9123,"LUPU ATOCHE JOEL HERNAN",72453681,"15/01/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9124,"MADUEÑO ALARCON FABRIZIO JOAO",74971120,"07/06/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9125,"MENDOZA VILLAR RODRIGO ALONSO",73122744,"16/01/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9126,"MEZA SALAZAR JAIR MARLON",71179989,"05/01/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9127,"MEZARINA REATEGUI FABRIZIO",72173219,"28/11/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9128,"QUIROZ LUIS GERARDO EDWIN",75569693,"20/01/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9129,"REYES ROSSI JHERSON JOAO ALDAIR",72705028,"26/08/2004",false ));
        CAT2004.add(new Jugadores_Plantel(9130,"ZAMALLOA VARGAS FRED BIAN",70573621,"03/01/2004",false ));
        CAT2005.add(new Jugadores_Plantel(9131,"ALGUEDAS ROMAN SANDIER ADHEMIR",71413965,"22/06/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9132,"AMASIFUEN DE PAZ JOSÉ NICOLAS",72869521,"05/07/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9133,"BALCAZAR SOSA LUIS JOAO",75584809,"23/04/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9134,"BRINGAS TAPIA SEBASTIAN GABRIEL",70830230,"20/02/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9135,"CARTAGENA MENDOZA JOSHUA GIANCARLO",71225739,"18/01/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9136,"COTRINA AYALICAN LUIS FELIPE",71548086,"16/11/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9137,"DELGADO VASQUEZ JUAN DAVID",75250721,"08/05/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9138,"GOMEZ CCASANI CARLOS DANIEL",73839879,"09/02/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9139,"GONZALES CALLE ALEC JOSHUA",72655256,"14/12/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9140,"GUZMAN MENDOZA VICTOR YBRAHIN",72424602,"25/03/2006",false ));
        CAT2005.add(new Jugadores_Plantel(9141,"MEDINA SOLIS ALEJANDRO",76508394,"22/04/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9142,"MORON HUARCAYA ADRIANO",72200893,"17/05/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9143,"PINTO SAMANAMUD JUSTIN RODRIGO",72503846,"26/01/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9144,"PLASENCIA UGAZ JOSEPH ALEXIS",76534110,"27/03/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9145,"REA ZAPATA JOAO ADEMIR",73328676,"21/01/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9146,"RODRIGUEZ IRAOLA GILMAR",75444297,"12/04/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9147,"SERRANO MARTINEZ NICOLAS ENRIQUE",72638520,"15/08/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9148,"SILVA TARAZONA JAREN",74089202,"08/10/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9149,"VALENZUELA ADRIANZEN RODRIGO ALONSO",70368265,"30/09/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9150,"VELASQUEZ CHUMPITAZI JHOAO",70882782,"02/08/2005",false ));
        CAT2005.add(new Jugadores_Plantel(9151,"ZAVALETA VASQUEZ NICOLAS DEL PIERO",62471164,"09/04/2005",false ));
        CAT2006.add(new Jugadores_Plantel(9152,"AGURTO PINZON ANGHELO FABIAN JUNIOR",73358044,"09/05/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9153,"ALAYO ARZOLA IARLEY JADILSON ",72079419,"25/03/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9154,"CANO VILDOSO ALESSIO FABIAN",70433094,"13/01/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9155,"CASTILLO PANTIGOSO ALOISI OSCAR",60747812,"24/06/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9156,"CORDOVA CENTURION BRYAN SMITH",60828395,"16/10/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9157,"GUERRERO MARTINEZ JEFFREY EDU",72315889,"11/01/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9158,"JUSTO GARRIDO PAOLO MARCELO",70717813,"05/07/2007",false ));
        CAT2006.add(new Jugadores_Plantel(9159,"MALMACEDA CAMPANA DIEGO",76566816,"24/02/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9160,"MEJIA HURTADO NICOLAS ",73116492,"02/02/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9161,"MORENO SAKIHARA ADRIANO MATIAS",70519317,"27/08/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9162,"MORON HUARCAYA LUIS FAVIANO",70535206,"12/11/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9163,"NECIOSUP JOYA ADRIANO NICOLAS",72370083,"22/03/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9164,"PAZ CASTILLO BRAIDY ADRIANO",70624449,"01/02/2007",false ));
        CAT2006.add(new Jugadores_Plantel(9165,"PONCE SANTOS SALVADOR MARTIN",72484565,"22/01/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9166,"QUISPE MANIHUARI MATEO GABRIEL",61912804,"29/04/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9167,"ROSARIO ARRELUCEA ZE ROBERTO JORGE LUIS",70594446,"06/12/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9168,"SOYER CANTELLA BASSCO",70534556,"17/10/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9169,"TRUJILLO VILLANUEVA DONOVAN ZIZOU",70505914,"06/08/2006",false ));
        CAT2006.add(new Jugadores_Plantel(9170,"ZAPATA ARCA ALDHAIR JUNIOR",70566464,"07/01/2006",false ));
        CAT2007.add(new Jugadores_Plantel(9171,"ACEVEDO ZAMORA HAROLD LEANDRO MARTIN",76104834,"31/05/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9172,"ARONES QUINTANILLA SANTIAGO ALEJANDRO",61086835,"21/04/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9173,"CARRERA CALDERON ADRIANO EDUARDO",70630850,"28/02/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9174,"CASTILLO DIAZ JORDANO JOAQUIN",61214506,"05/12/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9175,"CHUMPITAZ VELASQUEZ JEREMY VALENTINO",70642088,"01/03/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9176,"GARCIA GOMEZ JONATHAN JUSSEPI",70953930,"06/07/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9177,"GARCIA ROJAS FRANKCHESCO MARTIN",60946877,"02/02/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9178,"GOMEZ AGUIRRE YOSIMAR ALEJANDRO",63594630,"06/10/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9179,"GUTIERREZ LOAYZA ALESSANDRO JULIAN",60947517,"01/03/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9180,"MESIAS SILVA FABRICIO ANDRE",60946851,"30/01/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9181,"PALOMINO CRUZ GEORGE ANDERZON",60946343,"20/01/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9182,"RETUERTO GONZALES DIEGO ANTHONY",77655289,"11/06/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9183,"RODRIGUEZ ARQUIÑIGO ROY OLIVER",62374428,"04/05/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9184,"VEGA GONZALES ALESSANDRO ALFONSO",61105933,"02/06/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9185,"YBACETA LUQUE FELIPE ERNESTO",61013357,"25/02/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9186,"ZAKIMI NAKAMO RENATO THIAGO",70634450,"07/03/2007",false ));
        CAT2007.add(new Jugadores_Plantel(9187,"ZUÑIGA PAREDES ROBERTO MATHIAS KOJI",4133057,"21/09/2007",false ));
        CAT2008.add(new Jugadores_Plantel(9188,"BOCANEGRA BOULANGGER THIAGO ALONSO",71169833,"22/02/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9189,"BOCANEGRA SEDANO ADRIANO JUAN ARMANDO",72586635,"18/10/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9190,"CAMPUSANO PEREZ BRUNO ALEXANDER",71163619,"04/02/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9191,"DEZA FLORES ALEXANDER",71168217,"25/01/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9192,"GARCIA LEON LEANDRO ARIEL",71164866,"11/02/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9193,"GARCIA RAMOS EMERSON ANDRE",60639007,"11/02/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9194,"HERNANDEZ BERNAOLA KEVIN IMANOL",61358845,"13/03/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9195,"REVILLA RAMIREZ SEBASTIAN SERGIO",72058566,"30/07/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9196,"SANTOS URIOL FABRIZIO NEIL ",72071132,"01/09/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9197,"SIERRA GACON NOAH",72340232,"22/09/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9198,"SUAREZ ROSAS MAURICIO",61354886,"03/03/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9199,"TAPIA MAMANI ALEJANDRO ELI",71166859,"17/02/2008",false ));
        CAT2008.add(new Jugadores_Plantel(9200,"TIRADO SAENZ JOSE ADRIANO",61315812,"08/01/2008",false ));
        CAT2009.add(new Jugadores_Plantel(9201,"ARAMBURU TALAVERA CARLOS MATEO",62048568,"09/01/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9202,"BAYONA RODRIGUEZ THIAGO GABRIEL",74343716,"14/07/2010",false ));
        CAT2009.add(new Jugadores_Plantel(9203,"CALDERON NAVARRO LEANDRO BENJAMIN",78524756,"29/06/2010",false ));
        CAT2009.add(new Jugadores_Plantel(9204,"CRUZADO VASQUEZ ADRIANO VLADIMIR",73411882,"09/06/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9205,"GUERRERO HUETE GABRIEL OLAF ",72988316,"30/01/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9206,"GUTIERREZ ACOSTA KEVIN ROMIL",61773080,"15/03/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9207,"HUAMAN LAULATE MIGUEL ADRIAN",73157728,"23/02/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9208,"HUAMAN PINCHI JUNIOR ORLANDO",61940980,"24/02/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9209,"JACINTO BARCO MARCELO PAOLO",62048486,"27/01/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9210,"MOGOLLON LUCERO YASIT EVRAT",72986093,"07/01/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9211,"MUÑICO SALINAS ADRIANO KAMILO ",73162086,"23/03/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9212,"PONCIANO LLUNCOR ADRIANO PAOLO",73547984,"21/06/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9213,"RODRIGUEZ BONILLA ADRIANO FRANCHESCOLI",61934585,"02/01/2010",false ));
        CAT2009.add(new Jugadores_Plantel(9214,"RODRIGUEZ ORJEDA MISAEL JOSUE",63035674,"06/06/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9215,"VASQUEZ SALAS JESHUA NAHLIEL",61878400,"16/09/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9216,"VIDAURRE BENDEZU ANGELO EMMANUEL",61841314,"06/01/2009",false ));
        CAT2009.add(new Jugadores_Plantel(9217,"VILLCAS HUAROTE ANDRICK SNAYDER",72836289,"05/01/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(1,"ASIN MOSQUERA ANDRES ESTEFANO",73257263,"07/02/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(2,"CARBAJAL RIOS ALBERTO HARRY",70451195,"07/02/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(3,"CARTY QUISPE MIGUEL",70601147,"22/02/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(4,"CIRILO SILVA JACK HARRINSON",61915483,"27/01/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(5,"DIAZ GUZMAN JONATHAN LUCIO",71075186,"15/03/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(6,"FERREYRA CHONLON KEVIN",70827539,"07/06/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(7,"JURADO GUZMAN GEREMI YORDAN",72916594,"28/04/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(8,"PANTA COTITO RAULIHNO JEANPIERRE",71616773,"21/11/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(9,"PANTOJA ORMEÑO CRISTHOFER",72608324,"09/02/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(10,"PRADO MAYTA CESAR",70799345,"26/02/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(11,"ROSAS CRUZ SEBASTIAN PEDRO",71586799,"31/03/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(12,"RUIZ CRIOLLO ROGER ALEXANDER",70400146,"28/01/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(13,"SALAZAR QUELOPANA FABRIZIO",78804670,"29/06/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(14,"SARAVIA ROJAS FRANCO",70930631,"02/06/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(15,"TARAZONA CUEVA DANIEL ALONSO",71198801,"27/09/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(16,"VIDAL CASIMIRO AAROM STHEPEN",73708128,"23/08/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(17,"VILLAVICENCIO HUAMANI CELSO",70513964,"10/08/1999",false ));
        PLANTEL.add(new Jugadores_Plantel(18,"ALBINO PÉREZ JOAQUIN",74356523,"21/01/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(19,"ALEMAN BACA JOSE WILFREDO",74654348,"23/05/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(20,"ARAUJO CASTAÑEDA BRAULIO ALEXIS",71407115,"16/02/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(21,"BARRETO SARMIENTO JEAN CARLO",73097530,"01/03/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(22,"CABANILLAS COQUIS MIJAILOV ERNESTO",72630173,"05/01/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(23,"CAMACHO MARQUEZ G'HUUSSEEPPE CARL",73917129,"20/06/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(24,"CARRANZA STEVES JUAN PABLO MARIANO",72659949,"10/03/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(25,"CHAUCA RODRIGUEZ ERICKSON DANIEL",75593304,"04/09/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(26,"CORNEJO LOLI MIGUEL",72261273,"18/01/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(27,"COTITO PEÑA KLUBER VICTOR",73231380,"28/05/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(28,"GAMONAL PAUCAR CHRISTOFER JULIO",70454090,"07/02/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(29,"GUEVARA PAIMA SANTIAGO ALEXANDER",71217409,"07/04/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(30,"LALANGUI OLAYA ANGELO ANTONIO",70565546,"23/08/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(31,"MATZUDA GUSUKUDA MAURICIO DAIKI",73266496,"05/01/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(32,"MILLER MARTIJENA KENNETH",71210041,"01/01/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(33,"ORBE GASTELU CARLOS ALEXANDER",70880538,"17/02/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(34,"OSHIRO GUSHIKEN JAN POL",79707264,"15/02/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(35,"PEREZ CAJAVILCA AYMAR JOSUE",74244087,"05/09/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(36,"PINEDA SAN MIGUEL JESUS ADRIAN",75270198,"28/02/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(37,"QUEVEDO MATHEY EDSON SEBASTIAN ",76601815,"07/04/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(38,"QUIJANO LOBATON ANTHONY ",72450807,"12/07/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(39,"ROJAS CHICOMA GIACOMO JAIR",75424593,"15/10/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(40,"SAENZ GOYAS KEVIN ARTURO",74079913,"24/04/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(41,"SALINAS SHIGUETO MARCOS BRANDON TAKESHI",74045868,"19/03/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(42,"TANDAZO SILVA WALTER ANGELLO",72732232,"14/06/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(43,"VALENZUELA DILEO OSWALDO JOSUE",70565069,"20/12/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(44,"ZARATE GRAJEDA POOL EDHER",73671826,"02/01/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(45,"ZETA YOVERA WILMER ALESSANDRO",73451797,"14/12/2000",false ));
        PLANTEL.add(new Jugadores_Plantel(46,"ALFARO FERNANDEZ RENZO ALBERTO",73999022,"21/01/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(47,"ALVAREZ MORALES ARILSON JAROMI",71424327,"06/06/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(48,"ARONI PONTE LUIGUI ALBERTH",73800814,"13/07/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(49,"CANO LEON MANUEL ARTURO",73755503,"30/06/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(50,"CARRERA GOMEZ RUBINHO RENATO",70607548,"06/01/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(51,"DE LA CRUZ ROBATTI JOSÉ LEONARDO",73739521,"12/01/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(52,"DIAZ RENGIFO LEANDRO JESÚS ENRIQUE",70426220,"14/09/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(53,"ESPINOZA ATOCHE DIEGO ALBERTO",72666811,"30/01/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(54,"GALLARDO FLORES JOSÉ ANTHONY",73898122,"15/02/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(55,"IPARRAGUIRRE PADILLA JOE AYRTON",75983100,"24/08/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(56,"MAMANI SANCHEZ JHON CLAUDIO ",70852561,"30/03/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(57,"MARTINEZ ALVA ERNESTO BENJAMIN",72357288,"15/01/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(58,"MESIA OSORIO DIEGO ALONSO",72371050,"10/04/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(59,"MOYANO VILLALOBOS AXEL",72410646,"03/01/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(60,"SANDI BEJAR  MASSIMO ENRIQUE",70675695,"12/05/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(61,"SOTO ZAPATA LUIS ELIS",72712280,"22/11/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(62,"ZUTA CORDERO LEONARDO ISRAEL",72755940,"04/03/2001",false ));
        PLANTEL.add(new Jugadores_Plantel(63,"ASCUES EARL ADRIAN ADEMIR",72208974,"15/11/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(64,"CAJA PEÑA FLAVIO ",74806272,"11/11/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(65,"CASTILLO OLIVERA ADRIEL ALAIN",71030946,"12/07/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(66,"CASTILLO TARA ENZO FRANCHESCO",72728607,"11/11/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(67,"CAVERO NAKAHORO  SEBASTIÁN JOSÉ",72758990,"20/06/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(68,"CHÁVEZ APOLAYA ALEXIS JORDANO",77223181,"23/01/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(69,"DE LA CRUZ ARIAS ANGEL ALBERTO",71625412,"24/05/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(70,"DE LA CRUZ ESPINOZA  PEDRO GIANPIER",71344005,"15/01/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(71,"ESCATE GALLEGOS JEREMI ALDAIR",74125922,"04/03/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(72,"ESPINOZA PAREDES CARLOS FABIAN",73898499,"22/06/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(73,"FERNANDEZ PIZARRO STEFANO JOSÉ",70374325,"12/02/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(74,"FRANCO COLLANTES  ADGARY YOSSUE",75653835,"19/01/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(75,"GUADALUPE MOSQUERA LEONARDO DE JESUS",72552585,"28/11/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(76,"GUERRERO VALDIVIESO MANUEL GUILLERMO",71862187,"15/02/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(77,"HUAMAN JAYO JEFFERSON JOAO",73494232,"30/11/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(78,"JIMENEZ BENAVIDES ALEXANDER JESÚS",72169521,"20/03/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(79,"MILLA SCHNEIDER IAN ERIC",73314382,"04/01/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(80,"NAVARRO DE OS RIOS MIGUEL ADALBERTO",72306891,"16/01/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(81,"PEREZ CAYO CARLOS DENNIS",72492459,"07/04/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(82,"REGINALDO PEÑA MARKO JHAIRO",70883791,"01/02/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(83,"RICOPA MOLINA BRYAN STWAR",74501725,"14/02/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(84,"RODRIGUEZ MENESES NAHUEL JEREMY",74217461,"04/03/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(85,"SALAZAR MANCILLA FABRICIO IVAN",73952020,"16/11/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(86,"SANCHEZ FLORES JECOB ALEXANDER",70959194,"09/05/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(87,"VALENZUELA HERRERA PEDRO PABLO",72040588,"21/04/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(88,"VELARDE MARTINEZ JEFFERSON JOEL",75381547,"10/02/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(89,"ZEVALLOS GANOZA HUMBERTO JHERICO",77209558,"19/03/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(90,"ZUBIATE ACOSTA  RENZO MARIO",70441284,"25/01/2002",false ));
        PLANTEL.add(new Jugadores_Plantel(91,"AMPUERO REQUEJO GIOVANNI",73201181,"15/03/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(92,"BUITRÓN MONCADA JUNIOR",70871859,"02/10/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(93,"CACHO PAEZ MARIANO",71582689,"14/04/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(94,"CAÑA CABELLO DENZEL FARED",75503895,"22/02/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(95,"CHAVEZ GRANDEZ BRIT BRYAN",73540855,"17/09/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(96,"CLAROS DÍAZ MARCO ANTONIO",74976063,"09/03/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(97,"CORDERO PEREA GLENN STEFANO",72708528,"08/05/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(98,"GARCIA ALVARADO ALEXANDER FAURICIO",72443411,"10/06/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(99,"GARCIA SINTI LEVIT",75038818,"07/11/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(100,"MESIAS SILVA PAULO CESAR",70940288,"03/09/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(101,"MONSERRATE VÁSQUEZ ITALO DAVID",76255059,"09/02/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(102,"MORALES RODRIGUEZ CARLO FABIAN",72703066,"12/02/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(103,"NAVEA TOLMOS JAVIER",72388261,"11/05/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(104,"PINEAU FLORES SEBASTIEN GERARD",78012874,"20/01/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(105,"PORTAL RODRIGUEZ ANDERSON HEISEN",72445567,"20/12/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(106,"RAMOS RIVAS JACK JOSÉ",72721951,"24/07/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(107,"SULCA URIBE JOSE JESÚS",70598653,"25/06/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(108,"TIRADO NICASIO HAIDER YASIR",71276677,"16/07/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(109,"VARGAS NÚÑEZ FABRIZIO ALONSO",70898888,"03/01/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(110,"VÁSQUEZ PIZARRO LIZARDO ANDRÉ",76545749,"30/01/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(111,"VASQUEZ RAMIREZ PAULO CESAR",71542441,"09/03/2003",false ));
        PLANTEL.add(new Jugadores_Plantel(112,"ALVARADO  ARONES JUAN DANIEL ",72534257,"22/05/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(113,"AMASIFUEN DE PAZ JOSE SEBASTIAN",73598090,"06/06/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(114,"ARRASCO CALDERON JOSE MAURICIO",77679590,"26/05/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(115,"CAMONES MORA JAIR YAZID",73060681,"23/01/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(116,"CARDENAS SALAZAR SANTIAGO MOISES",60988196,"01/09/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(117,"DELGADO BOLIVAR DIEGO ADRIAN",70579351,"15/05/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(118,"DÍAZ LANDAURI JORDANY ARTYEL",73066539,"10/05/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(119,"ESTRADA RODRIGUEZ AYMAR",75359903,"04/02/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(120,"FLORES ORTIZ DE VILLATE VICTOR ALFONSO",74092393,"08/08/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(121,"FLORES RODRIGUEZ SEBASTIAN MATEO",75599284,"04/01/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(122,"LLERENA FASANANDO GERSON JAFED ",72379765,"04/01/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(123,"LUPU ATOCHE JOEL HERNAN",72453681,"15/01/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(124,"MADUEÑO ALARCON FABRIZIO JOAO",74971120,"07/06/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(125,"MENDOZA VILLAR RODRIGO ALONSO",73122744,"16/01/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(126,"MEZA SALAZAR JAIR MARLON",71179989,"05/01/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(127,"MEZARINA REATEGUI FABRIZIO",72173219,"28/11/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(128,"QUIROZ LUIS GERARDO EDWIN",75569693,"20/01/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(129,"REYES ROSSI JHERSON JOAO ALDAIR",72705028,"26/08/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(130,"ZAMALLOA VARGAS FRED BIAN",70573621,"03/01/2004",false ));
        PLANTEL.add(new Jugadores_Plantel(131,"ALGUEDAS ROMAN SANDIER ADHEMIR",71413965,"22/06/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(132,"AMASIFUEN DE PAZ JOSÉ NICOLAS",72869521,"05/07/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(133,"BALCAZAR SOSA LUIS JOAO",75584809,"23/04/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(134,"BRINGAS TAPIA SEBASTIAN GABRIEL",70830230,"20/02/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(135,"CARTAGENA MENDOZA JOSHUA GIANCARLO",71225739,"18/01/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(136,"COTRINA AYALICAN LUIS FELIPE",71548086,"16/11/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(137,"DELGADO VASQUEZ JUAN DAVID",75250721,"08/05/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(138,"GOMEZ CCASANI CARLOS DANIEL",73839879,"09/02/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(139,"GONZALES CALLE ALEC JOSHUA",72655256,"14/12/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(140,"GUZMAN MENDOZA VICTOR YBRAHIN",72424602,"25/03/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(141,"MEDINA SOLIS ALEJANDRO",76508394,"22/04/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(142,"MORON HUARCAYA ADRIANO",72200893,"17/05/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(143,"PINTO SAMANAMUD JUSTIN RODRIGO",72503846,"26/01/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(144,"PLASENCIA UGAZ JOSEPH ALEXIS",76534110,"27/03/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(145,"REA ZAPATA JOAO ADEMIR",73328676,"21/01/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(146,"RODRIGUEZ IRAOLA GILMAR",75444297,"12/04/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(147,"SERRANO MARTINEZ NICOLAS ENRIQUE",72638520,"15/08/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(148,"SILVA TARAZONA JAREN",74089202,"08/10/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(149,"VALENZUELA ADRIANZEN RODRIGO ALONSO",70368265,"30/09/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(150,"VELASQUEZ CHUMPITAZI JHOAO",70882782,"02/08/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(151,"ZAVALETA VASQUEZ NICOLAS DEL PIERO",62471164,"09/04/2005",false ));
        PLANTEL.add(new Jugadores_Plantel(152,"AGURTO PINZON ANGHELO FABIAN JUNIOR",73358044,"09/05/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(153,"ALAYO ARZOLA IARLEY JADILSON ",72079419,"25/03/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(154,"CANO VILDOSO ALESSIO FABIAN",70433094,"13/01/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(155,"CASTILLO PANTIGOSO ALOISI OSCAR",60747812,"24/06/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(156,"CORDOVA CENTURION BRYAN SMITH",60828395,"16/10/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(157,"GUERRERO MARTINEZ JEFFREY EDU",72315889,"11/01/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(158,"JUSTO GARRIDO PAOLO MARCELO",70717813,"05/07/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(159,"MALMACEDA CAMPANA DIEGO",76566816,"24/02/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(160,"MEJIA HURTADO NICOLAS ",73116492,"02/02/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(161,"MORENO SAKIHARA ADRIANO MATIAS",70519317,"27/08/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(162,"MORON HUARCAYA LUIS FAVIANO",70535206,"12/11/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(163,"NECIOSUP JOYA ADRIANO NICOLAS",72370083,"22/03/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(164,"PAZ CASTILLO BRAIDY ADRIANO",70624449,"01/02/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(165,"PONCE SANTOS SALVADOR MARTIN",72484565,"22/01/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(166,"QUISPE MANIHUARI MATEO GABRIEL",61912804,"29/04/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(167,"ROSARIO ARRELUCEA ZE ROBERTO JORGE LUIS",70594446,"06/12/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(168,"SOYER CANTELLA BASSCO",70534556,"17/10/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(169,"TRUJILLO VILLANUEVA DONOVAN ZIZOU",70505914,"06/08/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(170,"ZAPATA ARCA ALDHAIR JUNIOR",70566464,"07/01/2006",false ));
        PLANTEL.add(new Jugadores_Plantel(171,"ACEVEDO ZAMORA HAROLD LEANDRO MARTIN",76104834,"31/05/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(172,"ARONES QUINTANILLA SANTIAGO ALEJANDRO",61086835,"21/04/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(173,"CARRERA CALDERON ADRIANO EDUARDO",70630850,"28/02/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(174,"CASTILLO DIAZ JORDANO JOAQUIN",61214506,"05/12/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(175,"CHUMPITAZ VELASQUEZ JEREMY VALENTINO",70642088,"01/03/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(176,"GARCIA GOMEZ JONATHAN JUSSEPI",70953930,"06/07/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(177,"GARCIA ROJAS FRANKCHESCO MARTIN",60946877,"02/02/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(178,"GOMEZ AGUIRRE YOSIMAR ALEJANDRO",63594630,"06/10/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(179,"GUTIERREZ LOAYZA ALESSANDRO JULIAN",60947517,"01/03/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(180,"MESIAS SILVA FABRICIO ANDRE",60946851,"30/01/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(181,"PALOMINO CRUZ GEORGE ANDERZON",60946343,"20/01/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(182,"RETUERTO GONZALES DIEGO ANTHONY",77655289,"11/06/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(183,"RODRIGUEZ ARQUIÑIGO ROY OLIVER",62374428,"04/05/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(184,"VEGA GONZALES ALESSANDRO ALFONSO",61105933,"02/06/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(185,"YBACETA LUQUE FELIPE ERNESTO",61013357,"25/02/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(186,"ZAKIMI NAKAMO RENATO THIAGO",70634450,"07/03/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(187,"ZUÑIGA PAREDES ROBERTO MATHIAS KOJI",4133057,"21/09/2007",false ));
        PLANTEL.add(new Jugadores_Plantel(188,"BOCANEGRA BOULANGGER THIAGO ALONSO",71169833,"22/02/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(189,"BOCANEGRA SEDANO ADRIANO JUAN ARMANDO",72586635,"18/10/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(190,"CAMPUSANO PEREZ BRUNO ALEXANDER",71163619,"04/02/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(191,"DEZA FLORES ALEXANDER",71168217,"25/01/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(192,"GARCIA LEON LEANDRO ARIEL",71164866,"11/02/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(193,"GARCIA RAMOS EMERSON ANDRE",60639007,"11/02/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(194,"HERNANDEZ BERNAOLA KEVIN IMANOL",61358845,"13/03/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(195,"REVILLA RAMIREZ SEBASTIAN SERGIO",72058566,"30/07/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(196,"SANTOS URIOL FABRIZIO NEIL ",72071132,"01/09/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(197,"SIERRA GACON NOAH",72340232,"22/09/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(198,"SUAREZ ROSAS MAURICIO",61354886,"03/03/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(199,"TAPIA MAMANI ALEJANDRO ELI",71166859,"17/02/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(200,"TIRADO SAENZ JOSE ADRIANO",61315812,"08/01/2008",false ));
        PLANTEL.add(new Jugadores_Plantel(201,"ARAMBURU TALAVERA CARLOS MATEO",62048568,"09/01/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(202,"BAYONA RODRIGUEZ THIAGO GABRIEL",74343716,"14/07/2010",false ));
        PLANTEL.add(new Jugadores_Plantel(203,"CALDERON NAVARRO LEANDRO BENJAMIN",78524756,"29/06/2010",false ));
        PLANTEL.add(new Jugadores_Plantel(204,"CRUZADO VASQUEZ ADRIANO VLADIMIR",73411882,"09/06/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(205,"GUERRERO HUETE GABRIEL OLAF ",72988316,"30/01/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(206,"GUTIERREZ ACOSTA KEVIN ROMIL",61773080,"15/03/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(207,"HUAMAN LAULATE MIGUEL ADRIAN",73157728,"23/02/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(208,"HUAMAN PINCHI JUNIOR ORLANDO",61940980,"24/02/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(209,"JACINTO BARCO MARCELO PAOLO",62048486,"27/01/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(210,"MOGOLLON LUCERO YASIT EVRAT",72986093,"07/01/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(211,"MUÑICO SALINAS ADRIANO KAMILO ",73162086,"23/03/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(212,"PONCIANO LLUNCOR ADRIANO PAOLO",73547984,"21/06/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(213,"RODRIGUEZ BONILLA ADRIANO FRANCHESCOLI",61934585,"02/01/2010",false ));
        PLANTEL.add(new Jugadores_Plantel(214,"RODRIGUEZ ORJEDA MISAEL JOSUE",63035674,"06/06/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(215,"VASQUEZ SALAS JESHUA NAHLIEL",61878400,"16/09/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(216,"VIDAURRE BENDEZU ANGELO EMMANUEL",61841314,"06/01/2009",false ));
        PLANTEL.add(new Jugadores_Plantel(217,"VILLCAS HUAROTE ANDRICK SNAYDER",72836289,"05/01/2009",false ));

    }

    public Jugadores_Plantel(){
    }
    public Jugadores_Plantel(int id, String nombres, int DNI, String fecha_nacimiento,boolean isSelected) {
        Id = id;
        Nombres = nombres;
        this.DNI = DNI;
        Fecha_nacimiento = fecha_nacimiento;
        isSelected=isSelected;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNombres() {
        return Nombres;
    }
    public void setNombres(String nombres) {
        Nombres = nombres;
    }
    public int getDNI() {
        return DNI;
    }
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
    public String getFecha_nacimiento() {
        return Fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }



    protected Jugadores_Plantel(Parcel in) {
        Id = in.readInt();
        Nombres = in.readString();
        DNI = in.readInt();
        Fecha_nacimiento = in.readString();
        isSelected = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeString(Nombres);
        dest.writeInt(DNI);
        dest.writeString(Fecha_nacimiento);
        dest.writeByte((byte) (isSelected ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Jugadores_Plantel> CREATOR = new Parcelable.Creator<Jugadores_Plantel>() {
        @Override
        public Jugadores_Plantel createFromParcel(Parcel in) {
            return new Jugadores_Plantel(in);
        }

        @Override
        public Jugadores_Plantel[] newArray(int size) {
            return new Jugadores_Plantel[size];
        }
    };
}
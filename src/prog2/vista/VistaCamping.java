package prog2.vista;

import prog2.model.Camping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaCamping {

    private Camping camping;

    // Declarem les opcions per a referir-se a les opcions del menú
    static private enum Opcions {
        LLISTAR_TOTS_ALLOTJAMENTS, LLISTAR_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS, LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS, LLISTAR_TASQUES, AFEGIR_TASCA,
        COMPLETAR_TASCA, CALCULAR_ACCESSOS_NO_ACCESSIBLES,
        CALCULAR_METRES_TERRA, GUARDAR_CAMPING, RECUPERAR_CAMPING, SORTIR
    }

    // Declarem descripcions personalitzades per a les opcions del menú
    static private String[] descMenu = {
            "Llistar tots els allotjaments",
            "Llistar allotjaments operatius",
            "Llistar allotjaments no operatius",
            "Llistar accessos oberts",
            "Llistar accesos tancats",
            "Llistar tasques de manteniment actives",
            "Afegir una tasca de manteniment",
            "Completar una tasca de manteniment",
            "Número total d'accessos no accessibles amb vehicles",
            "Número total de metres dels accessos de terra",
            "Guardar càmping",
            "Recuperar càmping",
            "Sortir de l'aplicació",
    };

    /**
     * Inicialitza les dades del càmping
     * @param nomCamping
     */
    public VistaCamping(String nomCamping) {
        this.camping = new Camping(nomCamping);
        try {
            camping.inicialitzaDadesCamping();
        } catch (ExcepcioCamping e) {
            System.err.println("Error inicialitzant dades: " + e.getMessage());
        }
    }

    /**
     * Mètode per gestionar el càmping a través del menú
     */
    public void gestioCamping() {
        Scanner sc = new Scanner(System.in);

        // Creem l'objecte per al menú.
        Menu<Opcions> menu = new Menu<>("Menú Principal", Opcions.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenu);

        // Obtenim una opció des del menú
        Opcions opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opció
            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case LLISTAR_TOTS_ALLOTJAMENTS:
                    System.out.println("=== ALLOTJAMENTS OPERATIUS ===");
                    try { System.out.println(camping.llistarAllotjaments("operatiu"));}
                    catch (ExcepcioCamping e) { System.out.println(e.getMessage());}
                    System.out.println("=== ALLOTJAMENTS NO OPERATIUS ===");
                    try { System.out.println(camping.llistarAllotjaments("no operatiu"));}
                    catch (ExcepcioCamping e) { System.out.println(e.getMessage());}
                    break;
                case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                    System.out.println("=== ALLOTJAMENTS OPERATIUS ===");
                    try { System.out.println(camping.llistarAllotjaments("operatiu"));}
                    catch (ExcepcioCamping e) { System.out.println(e.getMessage());}
                    break;
                case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                    System.out.println("=== ALLOTJAMENTS NO OPERATIUS ===");
                    try { System.out.println(camping.llistarAllotjaments("no operatiu"));}
                    catch (ExcepcioCamping e) { System.out.println(e.getMessage());}
                    break;
                case LLISTAR_ACCESSOS_OBERTS:
                    System.out.println("=== ACCESSOS OBERTS ===");
                    try { System.out.println(camping.llistarAccessos("obert"));}
                    catch (ExcepcioCamping e) { System.out.println(e.getMessage());}
                    break;
                case LLISTAR_ACCESSOS_TANCATS:
                    System.out.println("=== ACCESSOS TANCATS ===");
                    try { System.out.println(camping.llistarAccessos("tancat"));}
                    catch (ExcepcioCamping e) { System.out.println(e.getMessage());}
                    break;
                case LLISTAR_TASQUES:
                    System.out.println("=== TASQUES ACTIVES ===");
                    try { System.out.println(camping.llistarTasquesManteniment());}
                    catch (ExcepcioCamping e) { System.out.println(e.getMessage());}
                    break;
                case AFEGIR_TASCA:
                    try { afegirTasca(sc);}
                    catch (InputMismatchException e) {
                        System.err.println("ERROR: Has d'introduir un numero enter");
                        // Netejar buffer
                        sc.nextLine();
                    }
                    catch (ExcepcioCamping e) { System.err.println("ERROR: " + e.getMessage());}
                    break;
                case COMPLETAR_TASCA:
                    try {
                        System.out.println("=== TASQUES ACTIVES ===");
                        System.out.println(camping.llistarTasquesManteniment());
                        completarTasca(sc);
                    } catch (ExcepcioCamping e) {
                        System.err.println("ERROR: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.err.println("ERROR: Has d'introduir un numero enter");
                        // Netejar buffer
                        sc.nextLine();
                    }
                    break;
                case CALCULAR_ACCESSOS_NO_ACCESSIBLES:
                    try{ System.out.println("Accessos NO accessibles amb vehicle: " +
                            camping.calculaAccessosNoAccessibles());}
                    catch (ExcepcioCamping e) { System.out.println(e.getMessage());}
                    break;
                case CALCULAR_METRES_TERRA:
                    try { System.out.println("Total metres accessos de terra: " +
                            camping.calculaMetresTerra());}
                    catch (ExcepcioCamping e) { System.out.println(e.getMessage());}
                    break;
                case GUARDAR_CAMPING:
                    System.out.print("Nom del fitxer on guardar: ");
                    String fitxerGuardar = sc.nextLine();
                    try {
                        camping.save(fitxerGuardar);
                        System.out.println("Càmping guardat correctament a '" + fitxerGuardar + "'");
                    } catch (ExcepcioCamping e) {
                        System.err.println("ERROR: " + e.getMessage());
                    }
                    break;
                case RECUPERAR_CAMPING:
                    System.out.print("Nom del fitxer a recuperar: ");
                    String fitxerCarregar = sc.nextLine();
                    try {
                        Camping campingCarregat = Camping.load(fitxerCarregar);
                        if (campingCarregat != null) {
                            this.camping = campingCarregat;
                            System.out.println("Càmping recuperat correctament de '" + fitxerCarregar + "'");
                        }
                    } catch (ExcepcioCamping e) {
                        System.err.println("ERROR: " + e.getMessage());
                    }
                    break;
                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }
        } while (opcio != Opcions.SORTIR);

        sc.close();
    }

    /**
     * Mètode auxiliar per afegir una tasca de manteniment
     */
    private void afegirTasca(Scanner sc) throws ExcepcioCamping, InputMismatchException {
        System.out.print("Introdueix el número de la tasca: ");
        int num = sc.nextInt();

        if (num < 0) throw new ExcepcioCamping("El número de la tasca ha de ser positiu");

        // Netejar buffer
        sc.nextLine();

        System.out.print("Introdueix l'ID de l'allotjament: ");
        String idAllotjament = sc.nextLine().toUpperCase().trim();

        if (idAllotjament.isEmpty()) {
            throw new ExcepcioCamping("L'ID de l'allotjament no pot estar buit");
        }

        System.out.print("Introdueix el tipus de tasca (Reparacio, Neteja, RevisioTecnica, Desinfeccio): ");
        String tipus = sc.nextLine().trim();

        if (tipus.isEmpty()) {
            throw new ExcepcioCamping("El tipus de tasca no pot estar buit");
        }

        System.out.print("Introdueix la data (YYYY-MM-DD): ");
        String data = sc.nextLine().trim();

        if (data.isEmpty()) {
            throw new ExcepcioCamping("La data no pot estar buida");
        }
        if (!esDataValida(data)) {
            throw new ExcepcioCamping("Data invàlida. Ha de ser una data real amb format YYYY-MM-DD");
        }

        System.out.print("Introdueix els dies esperats per realitzar la tasca: ");
        int dies = sc.nextInt();

        if (dies <= 0) throw new ExcepcioCamping("Els dies han de ser un número positiu");

        // Netejar buffer
        sc.nextLine();

        camping.afegirTascaManteniment(num, tipus, idAllotjament, data, dies);
        System.out.println("Tasca afegida correctament!");
    }

    /**
     * Mètode auxiliar per completar una tasca de manteniment
     */
    private void completarTasca(Scanner sc) throws ExcepcioCamping, InputMismatchException {
        System.out.print("Introdueix el número de la tasca a completar: ");
        int num = sc.nextInt();

        // Netejar buffer
        sc.nextLine();

        camping.completarTascaManteniment(num);
        System.out.println("Tasca completada correctament!");
    }

    /**
     * Mètode auxiliar per validar data
     */
    private boolean esDataValida(String data) {
        // Comprovar format
        if (!data.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }

        // Extreure components
        int any = Integer.parseInt(data.substring(0, 4));
        int mes = Integer.parseInt(data.substring(5, 7));
        int dia = Integer.parseInt(data.substring(8, 10));

        // Validar rang de mes, dia i any
        if (mes < 1 || mes > 12) return false;
        if (dia < 1 || dia > 31) return false;
        if (any < 0) return false;

        // Dies per mes (no traspas)
        int[] diesPerMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Ajust per any de traspàs (febrer)
        if (mes == 2 && esAnyTraspas(any)) {
            return dia <= 29;
        }

        return dia <= diesPerMes[mes - 1];
    }

    /**
     * Comprova si un any és de traspàs
     */
    private boolean esAnyTraspas(int any) {
        return (any % 4 == 0 && any % 100 != 0) || (any % 400 == 0);
    }

}

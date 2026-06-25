        // ─────────────────────────────────────────
        // Paso 6: Búsqueda interactiva por nombre (Validada)
        // ─────────────────────────────────────────
        System.out.println();
        System.out.println("==========================================");
        System.out.println("   BÚSQUEDA INTERACTIVA POR NOMBRE");
        System.out.println("==========================================");

        Scanner teclado = new Scanner(System.in);
        
        // ✅ Usamos el validador para leer el texto de forma segura
        String busqueda = ValidadorDatos.leerTextoNoVacio(teclado, 
                "Ingrese una palabra clave para buscar un tour (o escriba 'salir' para omitir): ");

        if (!busqueda.equalsIgnoreCase("salir")) {
            ArrayList<Tour> resultados = gestor.buscarPorNombre(busqueda);
            mostrarListadoOMensajeVacio(resultados,
                    "No se encontraron tours que coincidan con '" + busqueda + "'.");
        } else {
            System.out.println("Búsqueda omitida por el usuario.");
        }

        teclado.close();

    public ArrayList<Tour> cargarTours() {
        tours.clear();
        
        // ✅ NUEVA VALIDACIÓN: Verificar si el archivo existe antes de leer
        if (!ValidadorDatos.existeArchivo(rutaArchivo)) {
            System.out.println("❌ Error crítico: El archivo '" + rutaArchivo + "' no existe o no se puede leer.");
            System.out.println("Por favor, verifique que la carpeta 'resources' contenga el archivo 'tours.txt'.");
            return tours; // Retorna lista vacía
        }

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 0;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                procesarLinea(linea, numeroLinea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return tours;
    }

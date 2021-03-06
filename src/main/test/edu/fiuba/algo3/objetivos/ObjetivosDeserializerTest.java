package edu.fiuba.algo3.objetivos;

import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ObjetivosDeserializerTest {

    private ArrayList<Objetivo> objetivos;

    public ObjetivosDeserializerTest() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("archivos/objetivos.json"));
        this.objetivos = ObjetivosDeserializer.deserializarObjetivos(reader, new ArrayList<Jugador>());
    }

    @Test
    public void ObjetivosDeserializerCantidadCorrecta() {
        assertEquals(objetivos.size(), 13);
    }

    @Test
    public void ObjetivosDeserilazerPrimerObjetivoIgualAlJSON() throws FileNotFoundException {
        Objetivo objetivo = objetivos.get(0);
        assertEquals(objetivo.obtenerDescripcion(), "Ocupar África, 5 países de América del Norte y 4 países de Europa.");
    }

    @Test
    public void ObjetivoDeserializerObtenerObjetivoDestrucciónCorrectamente() throws FileNotFoundException {
        Objetivo objetivo = objetivos.get(12);
        assertEquals(objetivo.obtenerDescripcion(), "Destruir al ejército amarillo de ser imposible al jugador de la derecha.");
    }
}
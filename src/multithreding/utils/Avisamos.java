package multithreding.utils;

import java.util.List;

public interface Avisamos {
    void progreso(Integer percent);
    void haTerminado(List<String> resultado);
}

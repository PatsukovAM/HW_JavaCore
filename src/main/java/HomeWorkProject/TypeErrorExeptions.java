package HomeWorkProject;

import java.io.IOException;

public class TypeErrorExeptions extends IOException {
    public TypeErrorExeptions() {
        super("населенный пункт не найден, поробуйте ввести название заново или введите другой населнный пункт");
    }
}
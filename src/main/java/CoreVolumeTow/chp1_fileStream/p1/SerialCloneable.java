package CoreVolumeTow.chp1_fileStream.p1;

import java.io.*;

public class SerialCloneable implements Cloneable, Serializable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject(this);
            out.close();

            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bin);
            Object ret = in.readObject();
            in.close();
            return ret;
        }catch (Exception e){
            return null;
        }
    }
}

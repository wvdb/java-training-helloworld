package be.ictdynamic.helloworld.domain;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by wvdbrand on 6/09/2017.
 */
public class DatabaseEntity implements Serializable{
    private UUID id;
    private static UUID staticUUID = UUID.randomUUID();
    private static int intId;

    public DatabaseEntity() {
//        this.id = UUID.randomUUID();
        this.id = staticUUID;
        intId++;
    }

    public DatabaseEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatabaseEntity)) return false;

        DatabaseEntity databaseEntity = (DatabaseEntity) o;

        return id.equals(databaseEntity.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}

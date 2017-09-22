package be.ictdynamic.helloworld.oefening_inner_class_6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wvdbrand on 29/08/2017.
 */
public class CustomerDNAFile implements Serializable {
    private Preference preference;
    private CustomerDnaSource customerDnaSource;

    private List<Attribute> attributes;
    private List<Stb> stbs;

    public List<Attribute> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<>();
        }
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Stb> getStbs() {
        if (stbs == null) {
            stbs = new ArrayList<>();
        }
        return stbs;
    }

    public void setStbs(List<Stb> stbs) {
        this.stbs = stbs;
    }

    public Preference getPreferences() {
        return preference;
    }

    public void setPreferences(Preference preference) {
        this.preference = preference;
    }

    public static void exampleOfLocalInnnerClassMethod() {
        final int var1 = 10;
        int var2 = 10;
//        var2 = 11;

        // Local inner classes : Probably the vast majority of Java programmers don't know they exist
        class Dummy {
            int i1 = var1;
            int i2 = var2;

            void dummyMethod() {
                System.out.println(i1);
                System.out.println(i2);
            }
        }

        Dummy dummy = new Dummy();
        dummy.dummyMethod();
    }

    public class Preference {
//        public enum Topic {
//            SPORT, POLITICS, COMEDY
//        }
//
//        public enum interest {
//            LOW, MEDIUM, HIGH
//        }


        public Preference(Date preferenceDate) {
            this.preferenceDate = preferenceDate;
        }

        private Date preferenceDate;

        public Date getPreferenceDate() {
            return preferenceDate;
        }

        public void setPreferenceDate(Date preferenceDate) {
            this.preferenceDate = preferenceDate;
        }
    }

    public static class CustomerDnaSource {
        private String systemName;
        private boolean systemReliable;

        public CustomerDnaSource(String systemName, boolean systemReliable) {
            this.systemName = systemName;
            this.systemReliable = systemReliable;
        }

        public String getSystemName() {
            return systemName;
        }

        public void setSystemName(String systemName) {
            this.systemName = systemName;
        }

        public boolean isSystemReliable() {
            return systemReliable;
        }

        public void setSystemReliable(boolean systemReliable) {
            this.systemReliable = systemReliable;
        }
    }

    public static class Attribute {
        private String name;
        private String description;

        private List<Value> values;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Value> getValues() {
            return values;
        }

        public void setValues(List<Value> values) {
            this.values = values;
        }
        public static class Value {
            private String value;

            private String description;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getDescription() {
                return description;
            }
            public void setDescription(String description) {
                this.description = description;
            }
        }

    }

    public static class Stb {
        private String id;
        private String owner;
        private String household;

        private List<Attribute> attributes;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getHousehold() {
            return household;
        }

        public void setHousehold(String household) {
            this.household = household;
        }

        public List<Attribute> getAttributes() {
            return attributes;
        }

        public void setAttributes(List<Attribute> attributes) {
            this.attributes = attributes;
        }
        public static class Attribute {
            private String name;

            private String value;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }
            public void setValue(String value) {
                this.value = value;
            }
        }

    }

}

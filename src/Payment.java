import java.util.*;
import java.lang.*;
import java.io.*;

    class Payment {
        String Credit ;
        String Vcc ;
        String Address ;
        String Name ;
        public void setCredit (String s) {
            Credit  = s;
        }

        public void setVcc(String s) {
            Vcc = s;
        }

        public void setAddress(String p) {
            Address  = p;
        }
        public void setName ( String n ) {
            Name = n ;
        }
        //******************************************************************************
        public String getCredit () {
            return Credit ;
        }

        public String  getVcc() {
            return Vcc;
        }

        public String getAddress() {
            return Address;
        }
        public String getName () {
            return Name ;
        }

        public Payment (String c, String v , String a , String n ) {
            setCredit (c);
            setVcc(v);
            setAddress( a );
            setName( n ) ;
        }
    }



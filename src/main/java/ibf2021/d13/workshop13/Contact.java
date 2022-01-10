package ibf2021.d13.workshop13;

import java.io.Serializable;
import java.util.Random;

public class Contact implements Serializable {
    private String name;
    private String email;
    private long phoneNumber;
    private String id;

    public Contact() {
        this.id = this.genId();
    }

    public Contact(String id, String name, String email, long phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String email, long phoneNumber) {
        this.id = this.genId();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String genId() {
        String hexString = "";
        Random rand = new Random();
        // generates a random number between 1 to 16
        // hexadecimal maps numbers 1 to 16 -> 0 to f
        while (hexString.length() != 8) {
            int hex = rand.nextInt(16) + 1;
            hexString = hexString + Integer.toHexString(hex);
        }
        return hexString;
    }
}
package ch.bbw.addressbook;

import java.util.Comparator;

public class LastnameFirstnameRegistrationDatecomparator implements Comparator<Address> {

    @Override
    public int compare(Address o1, Address o2) {
        int result = o1.getLastname().compareTo(o2.getLastname());
        if (result == 0) {
            result = o1.getFirstname().compareTo(o2.getFirstname());
            if (result == 0) {
                result = o1.getRegistrationDate().compareTo(o2.getRegistrationDate());
            }
        }
        return result;
    }
}

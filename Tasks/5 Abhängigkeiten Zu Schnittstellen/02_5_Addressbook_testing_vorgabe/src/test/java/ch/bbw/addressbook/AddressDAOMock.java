package ch.bbw.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressDAOMock implements AddressDAO {

    private List<Address> addresses = new ArrayList<>();
    private int currentId = 1;

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public int getUniqueId() {
        return currentId++;
    }

    @Override
    public void create(Address address) {
        addresses.add(address);
    }

    @Override
    public Address read(int id) {
        return addresses.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Address> readAll() {
        return new ArrayList<>(addresses);
    }

    @Override
    public void update(Address address) {
        int index = addresses.indexOf(read(address.getId()));
        if (index != -1) {
            addresses.set(index, address);
        }
    }

    @Override
    public void delete(int id) {
        addresses.removeIf(a -> a.getId() == id);
    }
}

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class impluinvor extends UnicastRemoteObject implements interinvor {
    private HashMap<String, Integer> inventory;

    public impluinvor() throws RemoteException {
        inventory = new HashMap<>();
    }

    public void addProduct(String name, int quantity) throws RemoteException {
        inventory.put(name, quantity);
    }

    public boolean removeProduct(String name) throws RemoteException {
        return inventory.remove(name) != null;
    }

    public void updateQuantity(String name, int currentQuantity, int addedQuantity, int boughtQuantity) throws RemoteException {
        if (inventory.containsKey(name)) {
            int newQuantity = currentQuantity + addedQuantity - boughtQuantity;
            if (newQuantity < 0) throw new RemoteException("Quantity cannot be negative.");
            inventory.put(name, newQuantity);
        } else {
            throw new RemoteException("Product not found.");
        }
    }

    public int getQuantity(String name) throws RemoteException {
        return inventory.getOrDefault(name, -1);
    }

    public List<String> listProducts() throws RemoteException {
        return new ArrayList<>(inventory.keySet());
    }
}


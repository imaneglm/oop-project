import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface interinvor  extends Remote {
        void addProduct(String name, int quantity) throws RemoteException;
        boolean removeProduct(String name) throws RemoteException;
        void updateQuantity(String name, int currentQuantity, int addedQuantity, int boughtQuantity) throws RemoteException;
        int getQuantity(String name) throws RemoteException;
        List<String> listProducts() throws RemoteException;
}

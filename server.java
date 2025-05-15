import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    public static void main(String[] args) {
        try {
            impluinvor service = new impluinvor();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("InventoryService", iventory );
            System.out.println("Inventory RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

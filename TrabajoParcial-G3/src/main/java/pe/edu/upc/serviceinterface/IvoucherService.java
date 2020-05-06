package pe.edu.upc.serviceinterface;
import java.util.List;
import pe.edu.upc.entity.Voucher;

public interface IvoucherService {
	public void insert(Voucher i);

	public List<Voucher> list();
}

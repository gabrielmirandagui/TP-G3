package pe.edu.upc.daointerface;
import java.util.List;

import pe.edu.upc.entity.Voucher;
public interface IvoucherDao {

	public void insert(Voucher v);
	public List<Voucher> list();
}
// delcaro mis Funciones 
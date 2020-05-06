package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IvoucherDao;
import pe.edu.upc.entity.Voucher;
import pe.edu.upc.serviceinterface.IvoucherService;

@Named
@RequestScoped
public class VoucherServiceImpl implements IvoucherService, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IvoucherDao vD;

	@Override
	public void insert(Voucher v) {
		vD.insert(v);
	}

	@Override
	public List<Voucher> list() {
		// TODO Auto-generated method stub
		return vD.list();
	}

}

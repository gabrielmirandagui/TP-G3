package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.daointerface.IuserDao;
import pe.edu.upc.entity.User;
import pe.edu.upc.serviceinterface.IuserService;

@Named
public class UserServiceImpl implements IuserService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IuserDao uD;

	@Transactional
	@Override
	public Integer insert(User t) throws Exception {
		return uD.insert(t);
	}

	@Transactional
	@Override
	public Integer update(User t) throws Exception {
		return uD.update(t);
	}

	@Transactional
	@Override
	public Integer delete(User t) throws Exception {
		return uD.delete(t);
	}

	@Override
	public List<User> getAll() throws Exception {
		return uD.findAll();
	}

	@Override
	public Optional<User> getOne(User t) throws Exception {
		return uD.findById(t);
	}

	@Override
	public Optional<User> authentication(User user) throws Exception {
		String password = user.getPassword();

		String passwordHash = uD.getPassworHashedByUserName(user.getUsername());

		if (BCrypt.checkpw(password, passwordHash)) {
			user.setPassword(passwordHash);
			return uD.findUserByUsername(user);
		}

		return Optional.of(new User());
	}

}
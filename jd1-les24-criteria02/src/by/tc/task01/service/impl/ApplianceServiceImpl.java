package by.tc.task01.service.impl;

import java.util.List;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.dao.DaoException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService {

	@Override
	public <E> List<Appliance> find(Criteria<E> criteria) throws ServiceException {

		if (!Validator.criteriaValidator(criteria)) {

			throw new ServiceException("Wrong data");

		}

		List<Appliance> appliance = null;

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		try {

			appliance = applianceDAO.find(criteria);

		} catch (DaoException e) {

			e.printStackTrace();

		}

		if (appliance.isEmpty()) {

			System.out.println(
					"No " + criteria.getGroupSearchName().getSimpleName().toString() + " with these settings!");

		}

		return appliance;
	}

}

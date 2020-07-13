package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import java.util.List;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.view.PrintApplianceInfo;

public class Main {

	public static void main(String[] args) {

		List<Appliance> appliance = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria<Oven> criteriaOven = new Criteria<Oven>(Oven.class);
		criteriaOven.add(Oven.DEPTH, 30);

		try {
			appliance = service.find(criteriaOven);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		PrintApplianceInfo.print(appliance);
		System.out.println();

		//////////////////////////////////////////////////////////////////

		Criteria<Laptop> criteriaLaptop = new Criteria<Laptop>(Laptop.class);
		criteriaLaptop.add(Laptop.DISPLAY_INCHS, 19);

		try {
			appliance = service.find(criteriaLaptop);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		PrintApplianceInfo.print(appliance);
		System.out.println();

		//////////////////////////////////////////////////////////////////

		Criteria<Refrigerator> criteriaRefrigerator = new Criteria<Refrigerator>(Refrigerator.class);
		criteriaRefrigerator.add(Refrigerator.POWER_CONSUMPTION, 200);

		try {
			appliance = service.find(criteriaRefrigerator);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		PrintApplianceInfo.print(appliance);
		System.out.println();

		//////////////////////////////////////////////////////////////////

		Criteria<Speakers> criteriaSpeakers = new Criteria<Speakers>(Speakers.class);
		criteriaSpeakers.add(Speakers.POWER_CONSUMPTION, 15);

		try {
			appliance = service.find(criteriaSpeakers);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		PrintApplianceInfo.print(appliance);
		System.out.println();

		//////////////////////////////////////////////////////////////////

		Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>(TabletPC.class);
		criteriaTabletPC.add(TabletPC.COLOR, "blue");

		try {
			appliance = service.find(criteriaTabletPC);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		PrintApplianceInfo.print(appliance);
		System.out.println();

		//////////////////////////////////////////////////////////////////

		Criteria<VacuumCleaner> criteriaVacuumCleaner = new Criteria<VacuumCleaner>(VacuumCleaner.class);
		criteriaVacuumCleaner.add(VacuumCleaner.MOTOR_SPEED_REGULATION, 2950);

		try {
			appliance = service.find(criteriaVacuumCleaner);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		PrintApplianceInfo.print(appliance);
		System.out.println();

	}

}

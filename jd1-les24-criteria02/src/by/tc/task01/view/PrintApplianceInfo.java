package by.tc.task01.view;

import java.util.List;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {

	public static void print(List<? extends Appliance> appliance) {

		for (Appliance item : appliance) {

			System.out.println(item);

		}

	}

}

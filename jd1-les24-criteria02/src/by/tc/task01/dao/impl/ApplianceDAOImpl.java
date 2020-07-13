package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DaoException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

public class ApplianceDAOImpl implements ApplianceDAO {

	@Override
	public <E> List<Appliance> find(Criteria<E> criteria) throws DaoException {

		List<Appliance> app = new ArrayList<Appliance>();
		List<String> allAppliance = new ArrayList<String>();

		FileReader reader = null;
		BufferedReader bufReader = null;

		if (criteria.getGroupSearchName().getSimpleName().compareTo("Oven") == 0) {

			try {

				reader = new FileReader("resources/appliances_db.txt");
				bufReader = new BufferedReader(reader);

				String s = null;

				while ((s = bufReader.readLine()) != null) {

					allAppliance.add(s);

				}

				List<Oven> listOven = new ArrayList<Oven>();

				for (String line : allAppliance) {

					String[] params = line.split("(,) | (:)");

					if (criteria.getGroupSearchName().getSimpleName().compareTo(params[0].trim()) == 0) {

						Oven oven = new Oven();

						oven.setNameAppliance(params[0].trim());
						oven.setPowerConsumption(Integer.parseInt(params[1].split("=")[1].trim()));
						oven.setWeight(Integer.parseInt(params[2].split("=")[1].trim()));
						oven.setCapacity(Integer.parseInt(params[3].split("=")[1].trim()));
						oven.setDepth(Integer.parseInt(params[4].split("=")[1].trim()));
						oven.setHeight(Integer.parseInt(params[5].split("=")[1].trim()));
						oven.setWidth(Integer.parseInt(params[6].split("=")[1].trim()));

						listOven.add(oven);

					}

				}

				Integer power_consumption = null;
				Integer weight = null;
				Integer capacity = null;
				Integer depth = null;
				Integer height = null;
				Integer width = null;

				for (Map.Entry<E, Object> item : criteria.getCriteria().entrySet()) {

					if (item.getKey().toString().compareTo(SearchCriteria.Oven.POWER_CONSUMPTION.toString()) == 0) {

						power_consumption = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Oven.WEIGHT.toString()) == 0) {

						weight = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Oven.CAPACITY.toString()) == 0) {

						capacity = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Oven.DEPTH.toString()) == 0) {

						depth = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Oven.HEIGHT.toString()) == 0) {

						height = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Oven.WIDTH.toString()) == 0) {

						width = Integer.parseInt(item.getValue().toString());

					}

				}

				List<Oven> rOven = new ArrayList<Oven>();

				for (Oven oven : listOven) {

					if ((power_consumption == null || oven.getPowerConsumption() == power_consumption)
							&& (weight == null || oven.getWeight() == weight)
							&& (capacity == null || oven.getCapacity() == capacity)
							&& (depth == null || oven.getDepth() == depth)
							&& (height == null || oven.getHeight() == height)
							&& (width == null || oven.getWidth() == width)) {

						rOven.add(oven);

					}

				}

				app.addAll(rOven);

			} catch (FileNotFoundException e) {

				throw new DaoException(e);

			} catch (IOException e) {

				throw new DaoException(e);

			} catch (Exception e) {

				throw new DaoException(e);

			} finally {

				if (bufReader != null) {

					try {

						bufReader.close();

					} catch (IOException e) {

						// log - err
						System.err.println(e);

					}

				}

			}

		}

		if (criteria.getGroupSearchName().getSimpleName().compareTo("Laptop") == 0) {

			try {

				reader = new FileReader("resources/appliances_db.txt");
				bufReader = new BufferedReader(reader);

				String s = null;

				while ((s = bufReader.readLine()) != null) {

					allAppliance.add(s);

				}

				List<Laptop> listLaptop = new ArrayList<Laptop>();

				for (String line : allAppliance) {

					String[] params = line.split("(,) | (:)");

					if (criteria.getGroupSearchName().getSimpleName().compareTo(params[0].trim()) == 0) {

						Laptop laptop = new Laptop();

						laptop.setNameAppliance(params[0].trim());
						laptop.setBatteryCapacity(Integer.parseInt(params[1].split("=")[1].trim()));
						laptop.setOS(params[2].split("=")[1].trim());
						laptop.setMemoryRom(Integer.parseInt(params[3].split("=")[1].trim()));
						laptop.setSystemMemory(Integer.parseInt(params[4].split("=")[1].trim()));
						laptop.setCPU(Double.parseDouble(params[5].split("=")[1].trim()));
						laptop.setDisplayInchs(Integer.parseInt(params[6].split("=")[1].trim()));

						listLaptop.add(laptop);

					}

				}

				Integer battery_capacity = null;
				String os = null;
				Integer memory_rom = null;
				Integer system_memory = null;
				Double cpu = null;
				Integer display_inchs = null;

				for (Map.Entry<E, Object> item : criteria.getCriteria().entrySet()) {

					if (item.getKey().toString().compareTo(SearchCriteria.Laptop.BATTERY_CAPACITY.toString()) == 0) {

						battery_capacity = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Laptop.OS.toString()) == 0) {

						os = item.getValue().toString();

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Laptop.MEMORY_ROM.toString()) == 0) {

						memory_rom = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Laptop.SYSTEM_MEMORY.toString()) == 0) {

						system_memory = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Laptop.CPU.toString()) == 0) {

						cpu = Double.parseDouble(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Laptop.DISPLAY_INCHS.toString()) == 0) {

						display_inchs = Integer.parseInt(item.getValue().toString());

					}

				}

				List<Laptop> rLaptop = new ArrayList<Laptop>();

				for (Laptop laptop : listLaptop) {

					if ((battery_capacity == null || laptop.getBatteryCapacity() == battery_capacity)
							&& (os == null || (laptop.getOS().compareTo(os) == 0))
							&& (memory_rom == null || laptop.getMemoryRom() == memory_rom)
							&& (system_memory == null || laptop.getSystemMemory() == system_memory)
							&& (cpu == null || laptop.getCPU() == cpu)
							&& (display_inchs == null || laptop.getDisplayInchs() == display_inchs)) {

						rLaptop.add(laptop);

					}

				}

				app.addAll(rLaptop);

			} catch (FileNotFoundException e) {

				throw new DaoException(e);

			} catch (IOException e) {

				throw new DaoException(e);

			} catch (Exception e) {

				throw new DaoException(e);

			} finally {

				if (bufReader != null) {

					try {

						bufReader.close();

					} catch (IOException e) {

						// log - err
						System.err.println(e);

					}

				}

			}

		}

		if (criteria.getGroupSearchName().getSimpleName().compareTo("Speakers") == 0) {

			try {

				reader = new FileReader("resources/appliances_db.txt");
				bufReader = new BufferedReader(reader);

				String s = null;

				while ((s = bufReader.readLine()) != null) {

					allAppliance.add(s);

				}

				List<Speakers> listSpeakers = new ArrayList<Speakers>();

				for (String line : allAppliance) {

					String[] params = line.split("(,) | (:)");

					if (criteria.getGroupSearchName().getSimpleName().compareTo(params[0].trim()) == 0) {

						Speakers speakers = new Speakers();

						speakers.setNameAppliance(params[0].trim());
						speakers.setPowerConsumption(Integer.parseInt(params[1].split("=")[1].trim()));
						speakers.setNumberOfSpeakers(Integer.parseInt(params[2].split("=")[1].trim()));
						speakers.setFrequencyRange(params[3].split("=")[1].trim());
						speakers.setCordLength(Integer.parseInt(params[4].split("=")[1].trim()));

						listSpeakers.add(speakers);

					}

				}

				Integer power_consumption = null;
				Integer number_of_speakers = null;
				String frequency_range = null;
				Integer cord_length = null;

				for (Map.Entry<E, Object> item : criteria.getCriteria().entrySet()) {

					if (item.getKey().toString().compareTo(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()) == 0) {

						power_consumption = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString()
							.compareTo(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()) == 0) {

						number_of_speakers = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Speakers.FREQUENCY_RANGE.toString()) == 0) {

						frequency_range = item.getValue().toString();

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Speakers.CORD_LENGTH.toString()) == 0) {

						cord_length = Integer.parseInt(item.getValue().toString());

					}

				}

				List<Speakers> rSpeakers = new ArrayList<Speakers>();

				for (Speakers speaker : listSpeakers) {

					if ((power_consumption == null || speaker.getPowerConsumption() == power_consumption)
							&& (number_of_speakers == null || speaker.getNumberOfSpeakers() == number_of_speakers)
							&& (frequency_range == null
									|| (speaker.getFrequencyRange().compareTo(frequency_range) == 0))
							&& (cord_length == null || speaker.getCordLength() == cord_length)) {

						rSpeakers.add(speaker);

					}

				}

				app.addAll(rSpeakers);

			} catch (FileNotFoundException e) {

				throw new DaoException(e);

			} catch (IOException e) {

				throw new DaoException(e);

			} catch (Exception e) {

				throw new DaoException(e);

			} finally {

				if (bufReader != null) {

					try {

						bufReader.close();

					} catch (IOException e) {

						// log - err
						System.err.println(e);

					}

				}

			}

		}

		if (criteria.getGroupSearchName().getSimpleName().compareTo("Refrigerator") == 0) {

			try {

				reader = new FileReader("resources/appliances_db.txt");
				bufReader = new BufferedReader(reader);

				String s = null;

				while ((s = bufReader.readLine()) != null) {

					allAppliance.add(s);

				}

				List<Refrigerator> listRefrigerator = new ArrayList<Refrigerator>();

				for (String line : allAppliance) {

					String[] params = line.split("(,) | (:)");

					if (criteria.getGroupSearchName().getSimpleName().compareTo(params[0].trim()) == 0) {

						Refrigerator refrigerator = new Refrigerator();

						refrigerator.setNameAppliance(params[0].trim());
						refrigerator.setPowerConsumption(Integer.parseInt(params[1].split("=")[1].trim()));
						refrigerator.setWeight(Integer.parseInt(params[2].split("=")[1].trim()));
						refrigerator.setFreezerCapacity(Integer.parseInt(params[3].split("=")[1].trim()));
						refrigerator.setOverallCapacity(Integer.parseInt(params[4].split("=")[1].trim()));
						refrigerator.setHeight(Integer.parseInt(params[5].split("=")[1].trim()));
						refrigerator.setWidth(Integer.parseInt(params[6].split("=")[1].trim()));

						listRefrigerator.add(refrigerator);

					}

				}

				Integer power_consumption = null;
				Integer weight = null;
				Integer freezer_capacity = null;
				Integer overall_capacity = null;
				Integer height = null;
				Integer width = null;

				for (Map.Entry<E, Object> item : criteria.getCriteria().entrySet()) {

					if (item.getKey().toString()
							.compareTo(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()) == 0) {

						power_consumption = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Refrigerator.WEIGHT.toString()) == 0) {

						weight = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString()
							.compareTo(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()) == 0) {

						freezer_capacity = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString()
							.compareTo(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()) == 0) {

						overall_capacity = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Refrigerator.HEIGHT.toString()) == 0) {

						height = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.Refrigerator.WIDTH.toString()) == 0) {

						width = Integer.parseInt(item.getValue().toString());

					}

				}

				List<Refrigerator> rRefrigerator = new ArrayList<Refrigerator>();

				for (Refrigerator refrigerator : listRefrigerator) {

					if ((power_consumption == null || refrigerator.getPowerConsumption() == power_consumption)
							&& (weight == null || refrigerator.getWeight() == weight)
							&& (freezer_capacity == null || refrigerator.getFreezerCapacity() == freezer_capacity)
							&& (overall_capacity == null || refrigerator.getOverallCapacity() == overall_capacity)
							&& (height == null || refrigerator.getHeight() == height)
							&& (width == null || refrigerator.getWidth() == width)) {

						rRefrigerator.add(refrigerator);

					}

				}

				app.addAll(rRefrigerator);

			} catch (FileNotFoundException e) {

				throw new DaoException(e);

			} catch (IOException e) {

				throw new DaoException(e);

			} catch (Exception e) {

				throw new DaoException(e);

			} finally {

				if (bufReader != null) {

					try {

						bufReader.close();

					} catch (IOException e) {

						// log - err
						System.err.println(e);

					}

				}

			}

		}

		if (criteria.getGroupSearchName().getSimpleName().compareTo("TabletPC") == 0) {

			try {

				reader = new FileReader("resources/appliances_db.txt");
				bufReader = new BufferedReader(reader);

				String s = null;

				while ((s = bufReader.readLine()) != null) {

					allAppliance.add(s);

				}

				List<TabletPC> listTabletPC = new ArrayList<TabletPC>();

				for (String line : allAppliance) {

					String[] params = line.split("(,) | (:)");

					if (criteria.getGroupSearchName().getSimpleName().compareTo(params[0].trim()) == 0) {

						TabletPC tabletPC = new TabletPC();

						tabletPC.setNameAppliance(params[0].trim());
						tabletPC.setBatteryCapacity(Integer.parseInt(params[1].split("=")[1].trim()));
						tabletPC.setDisplayInches(Integer.parseInt(params[2].split("=")[1].trim()));
						tabletPC.setMemoryRom(Integer.parseInt(params[3].split("=")[1].trim()));
						tabletPC.setFlashMemoryCapacity(Integer.parseInt(params[4].split("=")[1].trim()));
						tabletPC.setColor(params[5].split("=")[1].trim());

						listTabletPC.add(tabletPC);

					}

				}

				Integer battery_capacity = null;
				Integer display_inches = null;
				Integer memory_rom = null;
				Integer flash_memory_capacity = null;
				String color = null;

				for (Map.Entry<E, Object> item : criteria.getCriteria().entrySet()) {

					if (item.getKey().toString().compareTo(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()) == 0) {

						battery_capacity = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()) == 0) {

						display_inches = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.TabletPC.MEMORY_ROM.toString()) == 0) {

						memory_rom = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString()
							.compareTo(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()) == 0) {

						flash_memory_capacity = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.TabletPC.COLOR.toString()) == 0) {

						color = item.getValue().toString();

					}

				}

				List<TabletPC> rTabletPC = new ArrayList<TabletPC>();

				for (TabletPC tabletPC : listTabletPC) {

					if ((battery_capacity == null || tabletPC.getBatteryCapacity() == battery_capacity)
							&& (display_inches == null || tabletPC.getDisplayInches() == display_inches)
							&& (memory_rom == null || tabletPC.getMemoryRom() == memory_rom)
							&& (flash_memory_capacity == null
									|| tabletPC.getFlashMemoryCapacity() == flash_memory_capacity)
							&& (color == null || (tabletPC.getColor().compareTo(color) == 0))) {

						rTabletPC.add(tabletPC);

					}

				}

				app.addAll(rTabletPC);

			} catch (FileNotFoundException e) {

				throw new DaoException(e);

			} catch (IOException e) {

				throw new DaoException(e);

			} catch (Exception e) {

				throw new DaoException(e);

			} finally {

				if (bufReader != null) {

					try {

						bufReader.close();

					} catch (IOException e) {

						// log - err
						System.err.println(e);

					}

				}

			}

		}

		if (criteria.getGroupSearchName().getSimpleName().compareTo("VacuumCleaner") == 0) {

			try {

				reader = new FileReader("resources/appliances_db.txt");
				bufReader = new BufferedReader(reader);

				String s = null;

				while ((s = bufReader.readLine()) != null) {

					allAppliance.add(s);

				}

				List<VacuumCleaner> listVacuumCleaner = new ArrayList<VacuumCleaner>();

				for (String line : allAppliance) {

					String[] params = line.split("(,) | (:)");

					if (criteria.getGroupSearchName().getSimpleName().compareTo(params[0].trim()) == 0) {

						VacuumCleaner vacuumCleaner = new VacuumCleaner();

						vacuumCleaner.setNameAppliance(params[0].trim());
						vacuumCleaner.setPowerConsumption(Integer.parseInt(params[1].split("=")[1].trim()));
						vacuumCleaner.setFilterType(params[2].split("=")[1].trim());
						vacuumCleaner.setBagType(params[3].split("=")[1].trim());
						vacuumCleaner.setWandType(params[4].split("=")[1].trim());
						vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(params[5].split("=")[1].trim()));
						vacuumCleaner.setCleaningWidth(Integer.parseInt(params[6].split("=")[1].trim()));

						listVacuumCleaner.add(vacuumCleaner);

					}

				}

				Integer power_consumption = null;
				String filter_type = null;
				String bag_type = null;
				String wand_type = null;
				Integer motor_speed_regulation = null;
				Integer cleaning_width = null;

				for (Map.Entry<E, Object> item : criteria.getCriteria().entrySet()) {

					if (item.getKey().toString()
							.compareTo(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()) == 0) {

						power_consumption = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString().compareTo(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString()) == 0) {

						filter_type = item.getValue().toString();

					}

					if (item.getKey().toString().compareTo(SearchCriteria.VacuumCleaner.BAG_TYPE.toString()) == 0) {

						bag_type = item.getValue().toString();

					}

					if (item.getKey().toString().compareTo(SearchCriteria.VacuumCleaner.WAND_TYPE.toString()) == 0) {

						wand_type = item.getValue().toString();

					}

					if (item.getKey().toString()
							.compareTo(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()) == 0) {

						motor_speed_regulation = Integer.parseInt(item.getValue().toString());

					}

					if (item.getKey().toString()
							.compareTo(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()) == 0) {

						cleaning_width = Integer.parseInt(item.getValue().toString());

					}

				}

				List<VacuumCleaner> rVacuumCleaner = new ArrayList<VacuumCleaner>();

				for (VacuumCleaner vacuumCleaner : listVacuumCleaner) {

					if ((power_consumption == null || vacuumCleaner.getPowerConsumption() == power_consumption)
							&& (filter_type == null || (vacuumCleaner.getFilterType().compareTo(filter_type) == 0))
							&& (bag_type == null || (vacuumCleaner.getBagType().compareTo(bag_type) == 0))
							&& (wand_type == null || (vacuumCleaner.getWandType().compareTo(wand_type) == 0))
							&& (motor_speed_regulation == null
									|| vacuumCleaner.getMotorSpeedRegulation() == motor_speed_regulation)
							&& (cleaning_width == null || vacuumCleaner.getCleaningWidth() == cleaning_width)) {

						rVacuumCleaner.add(vacuumCleaner);

					}

				}

				app.addAll(rVacuumCleaner);

			} catch (FileNotFoundException e) {

				throw new DaoException(e);

			} catch (IOException e) {

				throw new DaoException(e);

			} catch (Exception e) {

				throw new DaoException(e);

			} finally {

				if (bufReader != null) {

					try {

						bufReader.close();

					} catch (IOException e) {

						// log - err
						System.err.println(e);

					}

				}

			}

		}

		return app;
	}

}

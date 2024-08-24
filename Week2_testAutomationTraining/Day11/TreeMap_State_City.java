package Day11;
import java.util.*;
import java.util.Map.Entry;


	class State {
		private String name;
		private long population;

		public State(String name, long population) {
			super();
			this.name = name;
			this.population = population;
		}

		@Override
		public String toString() {
			return "State [name=" + name + ", population=" + population + "]";
		}
	}

	class City {
		private String name;
		private double total_area;

		public City(String name, double total_area) {
			super();
			this.name = name;
			this.total_area = total_area;
		}

		@Override
		public String toString() {
			return "City [name=" + name + ", total_area=" + total_area + "]";
		}
	}

	public class TreeMap_State_City {
		public static void main(String[] args) {
			Map<State, City> hmss = new HashMap<>();
			hmss.put(new State("Karnataka",2432), new City("Bangalore",1421));
			hmss.put(new State("Tamil Nadu",5432), new City("Chennai",5428));
			hmss.put(new State("Kerala",1439), new City("Trivandrum",1231));

			Set<Entry<State, City>> sess = hmss.entrySet();
			Iterator<Entry<State, City>> iess = sess.iterator();

			while (iess.hasNext()) {
				Entry<State, City> ess = iess.next();
				System.out.println(ess.getKey() + "->" + ess.getValue());
			}

		}
	}




package be.vdab.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import be.vdab.entities.Pizza;

public class PizzaDAO extends AbstractDAO {

	private static final Map<Long, Pizza> PIZZAS = new ConcurrentHashMap<>();

	private static final String BEGIN_SELECT = "SELECT id, naam, prijs, pikant FROM pizzas ";

	private static final String SQL_FIND_ALL = BEGIN_SELECT + "ORDER BY id";
	private static final String SQL_READ = BEGIN_SELECT + "WHERE id=?";
	private static final String SQL_FIND_BY_PRIJS_BETWEEN = BEGIN_SELECT + "WHERE prijs BETWEEN ? AND ? ORDER BY prijs";
	private static final String SQL_CREATE = "INSERT INTO pizzas(naam, prijs, pikant) VALUES (?,?,?)";

	static {
		PIZZAS.put(12L, new Pizza(12, "Prosciutto", BigDecimal.valueOf(4), true));
		PIZZAS.put(14L, new Pizza(14, "Margerhita", BigDecimal.valueOf(5), false));
		PIZZAS.put(17L, new Pizza(17, "Calzone", BigDecimal.valueOf(4), false));
		PIZZAS.put(23L, new Pizza(23, "Fungi & Olive", BigDecimal.valueOf(5), false));
	}

	public List<Pizza> findAll() {
		try (Connection connection = dataSource.getConnection()) {
			
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(SQL_FIND_ALL);
			
			List<Pizza> pizzas = new ArrayList<>();
			while (results.next()) {
				pizzas.add(resultSetRijNaarPizza(results));
			}
			return pizzas;
			
			// TODO ENDED HERE !!!!
		}
		catch (SQLException ex ) {
			throw new DAOException(ex);
		}
	}

	private Pizza resultSetRijNaarPizza(ResultSet resultSet) throws SQLException {
		return new Pizza(resultSet.getLong("id"), resultSet.getString("naam"), resultSet.getBigDecimal("prijs"),
				resultSet.getBoolean("pikant"));
	}

	public Pizza read(long id) {
		return PIZZAS.get(id);
	}

	public List<Pizza> findByPrijsBetween(BigDecimal van, BigDecimal tot) {
		List<Pizza> gevondenPizzas = new ArrayList<>();

		for (Pizza pizza : PIZZAS.values()) {
			if (pizza.getPrijs().compareTo(van) >= 0 && pizza.getPrijs().compareTo(tot) <= 0) {
				gevondenPizzas.add(pizza);
			}
		}

		return gevondenPizzas;
	}

	public void create(Pizza pizza) {
		pizza.setId(Collections.max(PIZZAS.keySet()) + 1);
		PIZZAS.put(pizza.getId(), pizza);
	}

}

package be.vdab.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Pizza;

public class PizzaDAO extends AbstractDAO {

//	private static final Map<Long, Pizza> PIZZAS = new ConcurrentHashMap<>();
	
	private static final Logger logger = Logger.getLogger(PizzaDAO.class.getName());
	

	private static final String BEGIN_SELECT = "SELECT id, naam, prijs, pikant FROM pizzas ";

	private static final String SQL_FIND_ALL = BEGIN_SELECT + "ORDER BY id";
	private static final String SQL_READ = BEGIN_SELECT + "WHERE id=?";
	private static final String SQL_FIND_BY_PRIJS_BETWEEN = BEGIN_SELECT + "WHERE prijs BETWEEN ? AND ? ORDER BY prijs";
	private static final String SQL_CREATE = "INSERT INTO pizzas(naam, prijs, pikant) VALUES (?,?,?)";

//	static {
//		PIZZAS.put(12L, new Pizza(12, "Prosciutto", BigDecimal.valueOf(4), true));
//		PIZZAS.put(14L, new Pizza(14, "Margerhita", BigDecimal.valueOf(5), false));
//		PIZZAS.put(17L, new Pizza(17, "Calzone", BigDecimal.valueOf(4), false));
//		PIZZAS.put(23L, new Pizza(23, "Fungi & Olive", BigDecimal.valueOf(5), false));
//	}

	public List<Pizza> findAll() {
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet results = statement.executeQuery(SQL_FIND_ALL);) {

			List<Pizza> pizzas = new ArrayList<>();
			while (results.next()) {
				pizzas.add(resultSetRijNaarPizza(results));
			}
			return pizzas;

		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Exception in findAll() naar pizzaluigis database", ex);
			throw new DAOException(ex);
		}
	}

	private Pizza resultSetRijNaarPizza(ResultSet resultSet) throws SQLException {
		return new Pizza(resultSet.getLong("id"), resultSet.getString("naam"), resultSet.getBigDecimal("prijs"),
				resultSet.getBoolean("pikant"));
	}

	public Pizza read(long id) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_READ);) {

			statement.setLong(1, id);

			try (ResultSet results = statement.executeQuery();) {
				if (results.next()) {
					return resultSetRijNaarPizza(results);
				}
				return null;
			}

		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Exception in read() naar pizzaluigis database", ex);
			throw new DAOException(ex);
		}
	}

	public List<Pizza> findByPrijsBetween(BigDecimal van, BigDecimal tot) {

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_PRIJS_BETWEEN);) {

			List<Pizza> gevondenPizzas = new ArrayList<>();

			statement.setBigDecimal(1, van);
			statement.setBigDecimal(2, tot);

			try (ResultSet results = statement.executeQuery();) {
				while (results.next()) {
					gevondenPizzas.add(resultSetRijNaarPizza(results));
				}
			}
			return gevondenPizzas;

		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Exception in findByPrijsBetween() naar pizzaluigis database", ex);
			throw new DAOException(ex);
		}

	}

	public void create(Pizza pizza) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);) {
			
			statement.setString(1, pizza.getNaam());
			statement.setBigDecimal(2, pizza.getPrijs());
			statement.setBoolean(3, pizza.isPikant());
			statement.executeUpdate();
			try (ResultSet results = statement.getGeneratedKeys()) {
				results.next();
				pizza.setId(results.getLong(1));
			}
			
		}
		catch (SQLException ex ) {
			logger.log(Level.SEVERE, "Exception in create() naar pizzaluigis database", ex);
			throw new DAOException(ex);
		}
	}

}

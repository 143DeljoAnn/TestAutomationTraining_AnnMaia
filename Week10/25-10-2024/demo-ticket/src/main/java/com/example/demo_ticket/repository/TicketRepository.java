package com.example.demo_ticket.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_ticket.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	/* Get all Tickets with a specific From Place and To Place */
//Derived Query method
	public List<Ticket> findByFromplaceOrToplace(String from_place, String to_place);

	/* Get all Tickets From Place and to Place , Price less than */
	public List<Ticket> findByFromplaceAndToplaceAndPriceLessThan(String from_place, String to_place, float price);

//public List<Ticket> findByFromplaceContaining(String str);
//public List<Ticket> findByFromPlaceStartingWith(String prefix)
//List<Product> findByNameEndingWith(String suffix);
//public List<Product> findByPriceLessThanEqual(float price);
// List<Product> findByIdBetween(int startId, int endId);
//void deleteById(Long id);
//void deleteByIdGreaterThan(Long id);

	// JPQL
	@Query("SELECT w FROM Ticket w WHERE w.fromplace = :fromplace")
	List<Ticket> met(@Param("fromplace") String str);

	// SQL
	@Query(value = "SELECT * FROM ticket WHERE username = :uname", 
			nativeQuery = true) 
	List<Ticket> met9(@Param("uname") String username);

	@Modifying
	@Transactional
	@Query("UPDATE Ticket t SET t.price = t.price*0.9 WHERE t.username = :uname") 
	void met10(@Param("uname") String username);

	 
	/*
	 * 
	 * // Find products by name using JPQL
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.name = :name") List<Product>
	 * findByName(@Param("name") String name);
	 * 
	 * // Find products by category using JPQL
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.category = :category") List<Product>
	 * findByCategory(@Param("category") String category);
	 * 
	 * // Find products with price less than a specified value using JPQL
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.price < :maxPrice") List<Product>
	 * findByPriceLessThan(@Param("maxPrice") Double maxPrice);
	 * 
	 * // Native SQL query to find products by name
	 * 
	 * @Query(value = "SELECT * FROM products WHERE name = :name", nativeQuery =
	 * true) List<Product> findByNameNative(@Param("name") String name);
	 * 
	 * // Find products with a price greater than a specified value
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.price > :minPrice") List<Product>
	 * findByPriceGreaterThan(@Param("minPrice") Double minPrice);
	 * 
	 * // Find products with a price less than a specified value
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.price < :maxPrice") List<Product>
	 * findByPriceLessThan(@Param("maxPrice") Double maxPrice);
	 * 
	 * // Find products with a quantity equal to a specified value
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.quantity = :quantity") List<Product>
	 * findByQuantity(@Param("quantity") Integer quantity);
	 * 
	 * // Find products with a quantity greater than or equal to a specified value
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.quantity >= :minQuantity")
	 * List<Product> findByQuantityGreaterThanEqual(@Param("minQuantity") Integer
	 * minQuantity);
	 * 
	 * // Find products with a price within a specified range
	 * 
	 * @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice"
	 * ) List<Product> findByPriceBetween(@Param("minPrice") Double
	 * minPrice, @Param("maxPrice") Double maxPrice);
	 * 
	 * // Count products with a price greater than a specified value
	 * 
	 * @Query("SELECT COUNT(p) FROM Product p WHERE p.price > :minPrice") Long
	 * countByPriceGreaterThan(@Param("minPrice") Double minPrice);
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE Product p SET p.price = :newPrice WHERE p.id > :id") void
	 * updatePriceByIdGreaterThan(Long id, Double newPrice);
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE Product p SET p.price = :newPrice WHERE p.id = :id") void
	 * updateProductPriceById(Long id, Double newPrice);
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE Product p SET p.category = :newCategory WHERE p.price < :maxPrice"
	 * ) void updateProductCategoryByPriceLessThan(Double maxPrice, String
	 * newCategory);
	 * 
	 * 
	 */

}

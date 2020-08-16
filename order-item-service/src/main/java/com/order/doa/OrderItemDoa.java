package com.order.doa;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.order.model.Orderr;


/*public interface OrderItemDoa extends JpaRepository<Orderr, Integer> {*/
public interface OrderItemDoa extends CrudRepository<Orderr, Integer> {

	Orderr save(Orderr orderr);

	Iterable<Orderr> findAll();

	Orderr findById(int orderId);


}

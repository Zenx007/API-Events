package br.com.events.events.repo;

import br.com.events.events.model.Event;
import br.com.events.events.model.Subscription;

import br.com.events.events.model.User;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {
    public Subscription findByEventAndSubscriber(Event evt, User user);

    @Query(value = " select count (subscription_number as quantidade, indication_user_id,user_name"
    +" from tbl_subscription inner join tbl_user"
    + " on tbl_subscription.indication_user_id = tbl_user"
    +" where indication_user_id is not null "
    +"  and event_id = :eventId"
    + " group by indication_user_id"
    +" order by quantidade desc;" nativeQuery = true)


    public List<SubscriptionRankingItem> generateRanking(@Param("eventId") Integer eventId);
}

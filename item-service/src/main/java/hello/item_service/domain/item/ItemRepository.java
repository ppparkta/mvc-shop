package hello.item_service.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepository {
    // 여기도 처리하고 싶은데 잘 몰라서 공부해야 할 듯
    // 일단 강의에서 얼핏 들은대로 ConcurrentHashMap 사용함
    private static final Map<Long, Item> store = new ConcurrentHashMap<>(); // static
    // 강의에서는 long을 사용했으나 나는 AtomicLong을 사용함.
    // 멀티쓰레드에 대한 처리를 도와줌
    private static AtomicLong sequence = new AtomicLong(); // static

    public Item save(Item item) {
        item.setId(sequence.getAndIncrement());
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}

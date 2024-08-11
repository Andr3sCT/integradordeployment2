package apx.school.demo.Servicio;

import apx.school.demo.Entity.IntEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IntService {
    private Map<Long, IntEntity> list = new HashMap<>();
    private Long id = 1L;

    public List<IntEntity> getAll() {
        return new ArrayList<>(list.values());
    }

    public IntEntity getById(Long id) {
        return list.get(id);
    }

    public IntEntity save(IntEntity user) {
        user.setId(id);
        list.put(id, user);
        id++;
        return user;
    }

    public IntEntity update(IntEntity user, Long id) {
        if (list.containsKey(id)) {
            user.setId(id);
            list.put(id, user);
            return user;
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        list.remove(id);
    }
}

package apx.school.demo.Control;

import apx.school.demo.Entity.IntEntity;
import apx.school.demo.Servicio.IntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class IntControl {

    @Autowired
    private IntService intService;

    @GetMapping("/")
    public ResponseEntity<List<IntEntity>> findAll() {
        List<IntEntity> lista = this.intService.getAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntEntity> findById(@PathVariable("id") Long id) {
        IntEntity get = this.intService.getById(id);
        return ResponseEntity.ok(get);
    }

    @PostMapping("/")
    public ResponseEntity<IntEntity> save(@RequestBody IntEntity intEntity) {
        IntEntity save = this.intService.save(intEntity);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IntEntity> update(@RequestBody IntEntity intEntity, @PathVariable("id") Long id) {
        IntEntity update = this.intService.update(intEntity, id);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.intService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

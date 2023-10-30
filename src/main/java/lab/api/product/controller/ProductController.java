package lab.api.product.controller;

import lab.api.product.domain.Product;
import lab.api.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {
    private ProductRepository productRepository;

    @GetMapping("product/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findById(id));
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @PostMapping("product")
    public ResponseEntity save(@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Post Sucess!");
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete Sucess!");
    }

    @PutMapping("product/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Product updateProduct){
        var product = productRepository.findById(id).get();
        BeanUtils.copyProperties(updateProduct,product);
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Put Sucess!");
    }

}

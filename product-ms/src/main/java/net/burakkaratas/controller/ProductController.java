package net.burakkaratas.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController
{

    @PostMapping
    public String create()
    {
        return "Created!";
    }

    @GetMapping
    public String get()
    {
        return "Product!";
    }

    @PutMapping
    public String update()
    {
        return "Updated!";
    }

    @DeleteMapping
    public String delete()
    {
        return "Deleted!";
    }
}

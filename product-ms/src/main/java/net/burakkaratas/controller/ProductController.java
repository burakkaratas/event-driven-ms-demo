package net.burakkaratas.controller;

import lombok.RequiredArgsConstructor;
import net.burakkaratas.command.CreateProductCommand;
import net.burakkaratas.controller.request.CreateProductRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController
{

    private final CommandGateway commandGateway;

    @PostMapping
    public String create(@RequestBody CreateProductRequest request)
    {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .title(request.getTitle())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();
        String returnValue;
        try
        {
            returnValue = commandGateway.sendAndWait(createProductCommand);
        }
        catch (Exception exception)
        {
            returnValue = exception.getLocalizedMessage();
        }
        return returnValue;
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
